package com.hengyunsoft.platform.jobs;

import com.alibaba.druid.filter.config.ConfigTools;
import com.hengyunsoft.platform.file.repository.file.service.FileService;
import com.hengyunsoft.platform.logs.entity.logs.po.*;
import com.hengyunsoft.platform.logs.repository.logs.dao.*;
import com.hengyunsoft.platform.logs.repository.logs.example.*;
import com.hengyunsoft.platform.logs.repository.logs.service.*;
import com.hengyunsoft.security.auth.cache.TokenCache;
import com.hengyunsoft.utils.UploadFileUtil;
import com.hengyunsoft.utils.UploadResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 文件保留设置定期执行
 */
@Component
@Slf4j
public class LogFileKeepActuator {
    @Autowired
    private LogWarnSetMapper logWarnSetMapper;
    @Autowired
    private LogStructAppService logStructAppService;
    @Autowired
    private LogStructAppMapper logStructAppMapper;
    @Autowired
    private LogStructApacheService logStructApacheService;
    @Autowired
    private LogStructApacheMapper logStructApacheMapper;
    @Autowired
    private LogStructTomcatService logStructTomcatService;
    @Autowired
    private LogStructTomcatMapper logStructTomcatMapper;
    @Autowired
    private LogStructNginxService logStructNginxService;
    @Autowired
    private LogDeleteAppService logDeleteAppService;
    @Autowired
    private LogStructNginxMapper logStructNginxMapper;
    @Autowired
    private LogFileInterfaceMapper logFileInterfaceMapper;
    @Autowired
    private LogDeleteAppMapper logDeleteAppMapper;
    @Autowired
    private LogFileService logFileService;
    @Autowired
    private LogFileInterfaceService logFileInterfaceService;
    @Autowired
    private FileService fileService;

    @Value("${gxqpt.mysql.file.host}")
    private String host;//mysql 的ip
    @Value("${gxqpt.mysql.file.port}")
    private String port;//mysql的端口
    @Value("${gxqpt.mysql.file.username}")
    private String username;//mysql用户名
    @Value("${gxqpt.mysql.file.password}")
    private String password;//mysql的password
    @Value("${gxqpt.mysql.file.database}")
    private String database;//mysql的数据库
    @Value("${ftp.serverUrl}")
    private String serverUrl;//上传地址
    @Value("${ftp.logAppId}")
    private String logAppId;//日志系统的appid
    @Value("${ftp.logAppSecret}")
    private String logAppSecret;//日志系统的密码
    @Value("${logs.runfile}")
    private String temporary;//临时文件夹 存入可执行文件
    //@Autowired
   // private FileApi fileApi;

     /**说明：
      * 符合所有的服务。。。。。
      * 所有的服务，调用文件上传和文件删除的时候，传的appId都是日志系统的appId,而做业务的时候属于哪个应用系统的就在LOG表中记录哪个系统的appid
      * ，比如从FTP上取文件、或是文件采集,在log表中存的都是各个应用系统的APPID，而上传后，存的都是日志系统的appid.所以调用删除文件接口的时候，需要传日志系统的appid**/
    /**
     * 30分钟执行一次
     */
    @Scheduled(cron = "0 0/30 * * * ?")
    public void logDeleteData() {
        log.info("-------日志保留最新数据-----");
        //查询配置的保留天数
        LogWarnSetExample example = new LogWarnSetExample();
        example.createCriteria();
        List<LogWarnSet> logWarnSetList = logWarnSetMapper.selectByExample(example);
        if(logWarnSetList.size()==0){
            return;
        }
        LogWarnSet logWarnSet = logWarnSetList.get(0);
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DAY_OF_MONTH, -Math.toIntExact(logWarnSet.getStructSaveDays()));
        Date structDate = now.getTime();//获得结构化日志保留日期的最小时间（180天前的时间）

        Calendar now2 = Calendar.getInstance();
        now2.add(Calendar.DAY_OF_MONTH, -Math.toIntExact(logWarnSet.getFileSaveDays()));
        Date fileDate = now2.getTime();//获得日志文件保留日期的最小时间（180天前的时间）

        //删除结构化日志文件
        deleteApp(structDate);
        deleteTomcat(structDate);
        deleteApache(structDate);
        deleteNginx(structDate);

        //删除文件
        deleteFile(fileDate);
    }
    //删除app日志，并更新相关的文件状态为已失效
    public void deleteApp(Date structDate){
        //查询过期的app日志
        LogStructAppExample logStructAppExample = new LogStructAppExample();
        logStructAppExample.createCriteria().andLogTimeLessThan(structDate);
        List<LogStructApp> logStructApp = logStructAppMapper.selectByExample(logStructAppExample);
        //对删除过期的app的数据进行保存，保存的是实时写入的日志（即调用的对外开放接口write 写入log_struct_app的日志），只有这种实时写入的
        // 日志是没有日志文件的（其他的日志都会有日志文件，都可以重新生成），需要保存成文件，等文件过期后再将此文件删除。
        //实时写入的日志，documentId是为NULL的。
        //查询过期的app日志
        LogStructAppExample logStructAppExampleSS = new LogStructAppExample();
        logStructAppExampleSS.createCriteria().andLogTimeLessThan(structDate).andDocumentIdEqualTo("WRITE");//如果documentid为空，说明是实时写入的，没有文件
        List<LogStructApp> logStructAppSS = logStructAppMapper.selectByExample(logStructAppExampleSS);
        boolean runWriteApp= true;//保存实时写入的结构化日志是否成功
        if(logStructAppSS.size()>0){//如果存在实时写入的结构化日志，就保存成SQL上传
            runWriteApp = saveAppLogFile(logStructAppSS,structDate);
        }
        //删除过期的APP日志
        List<Long> listid = new ArrayList<Long>();
        List<String> documentIdList = new ArrayList<String>();
        for(int i=0;i<logStructApp.size();i++){
            if(!runWriteApp){//保存实时写入的结构化日志失败，便不删除日志
                if(!logStructApp.get(i).getDocumentId().equals("WRITE")){
                    listid.add(Long.valueOf(logStructApp.get(i).getId()));
                }
            }else{
                listid.add(Long.valueOf(logStructApp.get(i).getId()));
            }
            int mark=0;
            for(int j=0;j<documentIdList.size();j++){
                if(documentIdList.get(j).equals(logStructApp.get(i).getDocumentId())){
                    mark = 1;
                    break;
                }
            }
            if(mark==0){
                documentIdList.add(logStructApp.get(i).getDocumentId());//查询出删除的文件ID
            }
        }
        logStructAppService.deleteByIds(listid);

        //将删除app结构化的日志相当的文档，将表log_file_interface,中is_delete_struct 置成1，表示已失效。
        if(documentIdList.size()>0){
            updateLogFileInterfaceStatus(documentIdList);
        }
    }

    //删除tomcat日志，并更新相关的文件状态为已失效
    public void deleteTomcat(Date structDate){
        //查询过期的tocamt日志
        LogStructTomcatExample logStructTomcatExample = new LogStructTomcatExample();
        logStructTomcatExample.createCriteria().andLogTimeLessThan(structDate);
        List<LogStructTomcat> logStructTomcat = logStructTomcatMapper.selectByExample(logStructTomcatExample);
        //删除过期的tomcat日志
        List<Long> listid = new ArrayList<Long>();
        List<String> documentIdList = new ArrayList<String>();
        for(int i=0;i<logStructTomcat.size();i++){
            listid.add(Long.valueOf(logStructTomcat.get(i).getId()));
            int mark=0;
            for(int j=0;j<documentIdList.size();j++){
                if(documentIdList.get(j).equals(logStructTomcat.get(i).getDocumentId())){
                    mark = 1;
                    break;
                }
            }
            if(mark==0){
                documentIdList.add(logStructTomcat.get(i).getDocumentId());//查询出删除的文件ID
            }
        }
        logStructTomcatService.deleteByIds(listid);

        //将删除app结构化的日志相当的文档，将表log_file_interface,中is_delete_struct 置成1，表示已失效。
        if(documentIdList.size()>0) {
            updateLogFileInterfaceStatus(documentIdList);
        }
    }

    //删除apache日志，并更新相关的文件状态为已失效
    public void deleteApache(Date structDate){
        //查询过期的app日志
        LogStructApacheExample logStructApacheExample = new LogStructApacheExample();
        logStructApacheExample.createCriteria().andLogTimeLessThan(structDate);
        List<LogStructApache> logStructApache = logStructApacheMapper.selectByExample(logStructApacheExample);
        //删除过期的Apache日志
        List<Long> listid = new ArrayList<Long>();
        List<String> documentIdList = new ArrayList<String>();
        for(int i=0;i<logStructApache.size();i++){
            listid.add(Long.valueOf(logStructApache.get(i).getId()));
            int mark=0;
            for(int j=0;j<documentIdList.size();j++){
                if(documentIdList.get(j).equals(logStructApache.get(i).getDocumentId())){
                    mark = 1;
                    break;
                }
            }
            if(mark==0){
                documentIdList.add(logStructApache.get(i).getDocumentId());//查询出删除的文件ID
            }
        }
        logStructApacheService.deleteByIds(listid);

        //将删除app结构化的日志相当的文档，将表log_file_interface,中is_delete_struct 置成1，表示已失效。
        if(documentIdList.size()>0) {
            updateLogFileInterfaceStatus(documentIdList);
        }
    }
    //删除nginx日志，并更新相关的文件状态为已失效
    public void deleteNginx(Date structDate){
        //查询过期的app日志
        LogStructNginxExample logStructNginxExample = new LogStructNginxExample();
        logStructNginxExample.createCriteria().andLocalTimeLessThan(structDate);
        List<LogStructNginx> logStructNginx = logStructNginxMapper.selectByExample(logStructNginxExample);
        //删除过期的Nginx日志
        List<Long> listid = new ArrayList<Long>();
        List<String> documentIdList = new ArrayList<String>();
        for(int i=0;i<logStructNginx.size();i++){
            listid.add(Long.valueOf(logStructNginx.get(i).getId()));
            int mark=0;
            for(int j=0;j<documentIdList.size();j++){
                if(documentIdList.get(j).equals(logStructNginx.get(i).getDocumentId())){
                    mark = 1;
                    break;
                }
            }
            if(mark==0){
                documentIdList.add(logStructNginx.get(i).getDocumentId());//查询出删除的文件ID
            }
        }
        logStructNginxService.deleteByIds(listid);

        //将删除app结构化的日志相当的文档，将表log_file_interface,中is_delete_struct 置成1，表示已失效。
        if(documentIdList.size()>0) {
            updateLogFileInterfaceStatus(documentIdList);
        }
    }

    //将删除app结构化的日志相当的文档，将表log_file_interface,中is_delete_struct 置成1，表示已失效。
    public void updateLogFileInterfaceStatus(List<String> documentIdList){
       // LogFileInterfaceExample logFileInterfaceExample = new LogFileInterfaceExample();
       // logFileInterfaceExample.createCriteria().andDocumentIdIn(documentIdList);
            logFileInterfaceService.updateLogFileInterfaceStatus(documentIdList);
    }

    //删除过期的日志文件
    public void deleteFile(Date fileDate){
        //查询过期的log_file_interface
        LogFileInterfaceExample logFileInterfaceExample = new LogFileInterfaceExample();
        logFileInterfaceExample.createCriteria().andLogStartTimeLessThan(fileDate);
        List<LogFileInterface> logFileInterface = logFileInterfaceMapper.selectByExample(logFileInterfaceExample);
        List<String> documentIdList = new ArrayList<String>();
        Long[] documentIdLong = new Long[logFileInterface.size()];
        List<Long> ids = new ArrayList<>();
        for(int i=0;i<logFileInterface.size();i++){
            ids.add(logFileInterface.get(i).getId());
            documentIdList.add(logFileInterface.get(i).getDocumentId());
            documentIdLong[i]= Long.valueOf(logFileInterface.get(i).getDocumentId());
        }
        logFileInterfaceService.deleteByIds(ids);//删除log_file

        //删除过期的保留实时写入的结构化的日志
        LogDeleteAppExample logDeleteAppExample = new LogDeleteAppExample();
        logDeleteAppExample.createCriteria().andLogStartTimeLessThan(fileDate);
        List<LogDeleteApp> logDeleteApp = logDeleteAppMapper.selectByExample(logDeleteAppExample);
        List<Long> documentIdAppList = new ArrayList<Long>();
        Long[] documentIdAppLong = new Long[logDeleteApp.size()];
        for(int j=0;j<logDeleteApp.size();j++){
            documentIdAppList.add(logDeleteApp.get(j).getId());
            documentIdAppLong[j]= Long.valueOf(logDeleteApp.get(j).getDocumentId());
        }
        if(logDeleteApp.size()>0){
            logDeleteAppService.deleteByIds(documentIdAppList);
            fileService.removeList(logAppId,null,documentIdAppLong); //物理删除服务器上的日志文件
        }

        if(documentIdList.size()>0){
            deleteFourStructAndFile(documentIdList);//删除四个struct 和 log_File
            fileService.removeList(logAppId,null,documentIdLong); //物理删除服务器上的日志文件
        }
    }
    //删除四个struct
    public void deleteFourStructAndFile(List<String> documentIdList){
        //删除log_file
        LogFileExample logFileExample = new LogFileExample();
        logFileExample.createCriteria().andDocumentIdIn(documentIdList);
        logFileService.deleteByDocumentIds(logFileExample,"定时删除过期文件log_file数据");
        //删除App
        LogStructAppExample logStructAppExample = new LogStructAppExample();
        logStructAppExample.createCriteria().andDocumentIdIn(documentIdList);
        logStructAppService.deleteByDocumentIds(logStructAppExample,"定时删除过期的结构化app数据");
        //删除Tomcat
        LogStructTomcatExample logStructTomcatExample = new LogStructTomcatExample();
        logStructTomcatExample.createCriteria().andDocumentIdIn(documentIdList);
        logStructTomcatService.deleteByDocumentIds(logStructTomcatExample,"定时删除过期的结构化tomcat数据");
        //删除Apache
        LogStructApacheExample logStructApacheExample = new LogStructApacheExample();
        logStructApacheExample.createCriteria().andDocumentIdIn(documentIdList);
        logStructApacheService.deleteByDocumentIds(logStructApacheExample,"定时删除过期的结构化apache数据");
        //删除Nginx
        LogStructNginxExample logStructNginxExample = new LogStructNginxExample();
        logStructNginxExample.createCriteria().andDocumentIdIn(documentIdList);
        logStructNginxService.deleteByDocumentIds(logStructNginxExample,"定时删除过期的结构化nginx数据");

    }
    //保存即将删除的实时写的的APPLOG日志成文件,logStructAppSS过时的结构化日志，最小日期
    public boolean saveAppLogFile( List<LogStructApp> logStructAppSS,Date structDate){
        StringBuffer command = new StringBuffer();
        String passwordm = null;//用户密码
        Long simple=System.currentTimeMillis();
        //格式化日期
        java.text.SimpleDateFormat sdf= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String structDateStr=sdf.format(structDate);;
        try {
            passwordm = ConfigTools.decrypt(password);//解密
        } catch (Exception e) {
            e.printStackTrace();
        }
        String OS = System.getProperty("os.name").toLowerCase();

        String path=temporary; //取临时文件路径
        if (StringUtils.isEmpty(path)) {
            log.error("参数logs.runfile未配置，请检查！");
            return false;
        }

        boolean isDir = isDir(path);
        if (!isDir) {
            log.error("参数logs.runfile：" + path + "不是文件夹，请检查！");
            return false;
        }

        if (!path.endsWith("/")) {
            path = path + "/";
        }

        //path=path.replace('/', '\\'); // 将/换成\

        File fileTemp=new File(path);
        if  (!fileTemp .exists()  && !fileTemp .isDirectory()){
            fileTemp .mkdir();
        }
        System.out.println("bat或sh文件生成路径："+path);
        //String path = this.getClass().getResource("/").getPath();
        //System.out.println("bat或sh文件生成路径："+path);
        //path前后有双引号的转义字符，在直接使用当路径的时候，会转义回来，如果写入文件，会把转义字符当成文本字符写入文件，所以写入文件前应该去掉前后的转义字符。
        //String filePath = path.substring(0,path.length()-1).replaceAll("/", "\\\\");
        //注意哪些地方要空格，哪些不要空格（如果配置了mysql的环境变量可以直接写mysqldump  如果没配置需要mysql的bin路径+mysqldump  注意：如果路径有空格，需要引起来 比如：\"D:\\Program Files\\MySQL\\MySQL Server 5.5\\bin\\mysqldump\" ）
        String  sqlName = "";
        String passwordwl = "";
        /*if(OS.contains("windows")){

        }else if(OS.contains("linux")){

        }*/
        sqlName = path+"writeApp_"+simple+".sql";
        if(OS.contains("windows")){
            passwordwl = "\""+passwordm+"\"";//windows用双引号引特殊字符，没有特殊字符可以不写引号
           command.append("mysqldump -u").append(username).append(" -p").append(passwordwl)//密码是用的小p，而端口是用的大P。
                .append(" -h").append(host).append(" -P").append(port).append(" -t")
                .append(" --default-character-set=utf8 ").append(database).append(" log_struct_app")
                .append(" --where=\"DATE_FORMAT(log_time,'%Y%%%Y%%m%d%%%d%%H%i%%%i%%s')<DATE_FORMAT('"+structDateStr+"','%Y%%%Y%%m%d%%%d%%H%i%%%i%%s')\"")
                //.append(" --where=\"DATE_FORMAT(log_time,'%Y%m%d%H%i%s')<DATE_FORMAT('"+structDateStr+"','%Y%m%d%H%i%s')\"")//由于%在bat文件中是有含义的。直接写正确的日期格式，直接执行bat文件会过滤内容，之前的%Y%m%d%H%i%s  会变成 mHs 。为了执行过去，只能用上面的格式。
                .append(" > ").append(sqlName);
        }else if(OS.contains("linux")){
            passwordwl = "'"+passwordm+"'";//linux用单引号引特殊字符，没有特殊字符可以不写引号
            command.append("mysqldump -u").append(username).append(" -p").append(passwordwl)//密码是用的小p，而端口是用的大P。
                    .append(" -h").append(host).append(" -P").append(port).append(" -t")
                    .append(" --default-character-set=utf8 ").append(database).append(" log_struct_app")
                    .append(" --where=\"DATE_FORMAT(log_time,'%Y%m%d%H%i%s')<DATE_FORMAT('"+structDateStr+"','%Y%m%d%H%i%s')\"")
                    //.append(" --where=\"DATE_FORMAT(log_time,'%Y%m%d%H%i%s')<DATE_FORMAT('"+structDateStr+"','%Y%m%d%H%i%s')\"")//由于%在bat文件中是有含义的。直接写正确的日期格式，直接执行bat文件会过滤内容，之前的%Y%m%d%H%i%s  会变成 mHs 。为了执行过去，只能用上面的格式。
                    .append(" > ").append(sqlName);
        }
        String commond = command.toString();
        FileWriter fw=null;

        //生成bat文件.再执行bat。
        /**说明：生成bat文件的原因，直接用runtime.exec（）执行命令行，输出的内容不全，只是最开始的一些注释，只有执行bat文件的时候，才可以完整的执行**/
        //获取当前运行环境的系统类型名称
        String fix = ".bat";
        if(OS.contains("windows")){
            fix = ".bat";
        }else if(OS.contains("linux")){
            fix = ".sh";
        }
        try{
            System.out.println("===================生成可执行文件=开始=================");
            fw=new FileWriter(path+"exportApp_"+simple+fix);
            System.out.println("===================生成可执行文件=执行中=================");
            //将实时写入的日志记录在文件里
            fw.write(commond);
            System.out.println("===================生成可执行文件=结束中=================");
        }catch (IOException e1) {
            e1.printStackTrace();
        } finally{
            if(fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(0);
                }
            }
        }
        //执行bat文件
        Runtime runtime = Runtime.getRuntime();
        Process ps =null;
        try {
            ps = runtime.exec("cmd /c start /b "+path+"exportApp_"+simple+fix);
            ps.waitFor();  //等待子进程完成再往下执行。
            //等待5秒，否则文件没生成呢，就执行下面了。
            try{
                Thread.currentThread().sleep(5000);
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = ps.exitValue();  //接收执行完毕的返回值
        ps.destroy();  //销毁子进程
        ps = null;
        boolean uploadStatus=true;
        if (i == 0) {
            //上传到文件服务器
            uploadStatus=upLoad(logStructAppSS,path+"writeApp_"+simple+".sql",simple);

            //删除临时sql文件

            File file = new File(path+"writeApp_"+simple+".sql");
            if(file.exists()){
                file.delete();
            }
            //删除临时bat文件
            File file1 = new File(path+"exportApp_"+simple+fix);
            if(file1.exists()){
                file1.delete();
            }
            System.out.println("执行完成.");
        } else {
            System.out.println("执行失败.");
        }
        return uploadStatus;
    }
   //上传文件
    public boolean upLoad(List<LogStructApp> logStructAppSS,String filePath,Long simple){
        File file = new File(filePath);
        ByteArrayOutputStream bos = null;
        BufferedInputStream in = null;

        bos = new ByteArrayOutputStream((int) file.length());
        try {
            in = new BufferedInputStream(new FileInputStream(file));
            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while (-1 != (len = in.read(buffer, 0, buf_size))) {
                bos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e1) {
            e1.printStackTrace();
        }finally {
            try {
                in.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String token = TokenCache.of(logAppId, logAppSecret).get().get();
        //String token = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIzNWtqNjM1NiIsImFwcE5hbWUiOiLml6Xlv5fnrqHnkIbns7vnu58iLCJleHAiOjE1MjYwMDAzMDN9.HDoyC_iigp4a5uGat_8gPyYftCZA5TGLstEX6A-QmYG3yDNHc-OCA3toirbhZ2MoM33QNF9oBOlQCRSGEkFiSMlfY-1hc5CrIpr5bvmGJMNC37KM5Rf_Od1_HyFlhkVFoT7iTW7_nlNdniQSfaWJNaju73wf2Vt6dLW_xp1JdX0";
        com.hengyunsoft.utils.Result fileUpload=UploadFileUtil.uploadFile(serverUrl+"/api/file/p/file/simple",token,null,file.getName(), bos.toByteArray());
        if(fileUpload.getErrcode()!=0){
            log.error("错误码：errorCode:"+fileUpload.getErrcode() +"  信息提示：errorMsg:"+fileUpload.getErrmsg());
            return false;
        }
        UploadResult uploadListDTO = fileUpload.getData();
        if (null != uploadListDTO) {
            Date maxDate = logStructAppSS.get(0).getLogTime();
            Date minDate = logStructAppSS.get(0).getLogTime();
            for(int k=1;k<logStructAppSS.size();k++){
                if(maxDate.compareTo(logStructAppSS.get(k).getLogTime())<0){
                    maxDate = logStructAppSS.get(k).getLogTime();
                }
                if(minDate.compareTo(logStructAppSS.get(k).getLogTime())>0){
                    minDate = logStructAppSS.get(k).getLogTime();
                }
            }
            LogDeleteApp logDeleteApp = new LogDeleteApp();
            logDeleteApp.setAppId(logAppId);//logAppId，不是日志文件的内容原属于的应用系统，而是保存储即将删除这些数据的系统。
            logDeleteApp.setFileName("writeApp_"+simple);
            logDeleteApp.setDocumentId(uploadListDTO.getList().get(0).getId() + "");
            logDeleteApp.setDocumentPath("");
            logDeleteApp.setLogStartTime(minDate);
            logDeleteApp.setLogEndTime(maxDate);
            logDeleteApp.setCreateTime(new Date());
            logDeleteAppService.save(logDeleteApp);
        }
        return true;
    }

    //判断是否是个目录
    public static boolean isDir(String dir) {
        if (StringUtils.isEmpty(dir)) {
            return false;
        }
        File file = new File(dir);
        if (file.isDirectory()) {
            return true;
        }
        return false;
    }
   /*@PostConstruct
    public void init() {
        log.info("-------日志保留最新数据-----");

        try {
            logDeleteData();
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/
}
