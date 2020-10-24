package com.hengyunsoft.platform.file.repository.file.service.impl;

import com.hengyunsoft.base.dao.BaseAllDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.file.config.FileProperties;
import com.hengyunsoft.platform.file.constant.DataType;
import com.hengyunsoft.platform.file.entity.file.po.File;
import com.hengyunsoft.platform.file.entity.file.po.FileRecycle;
import com.hengyunsoft.platform.file.repository.file.dao.FileRecycleMapper;
import com.hengyunsoft.platform.file.repository.file.example.FileExample;
import com.hengyunsoft.platform.file.repository.file.example.FileRecycleExample;
import com.hengyunsoft.platform.file.repository.file.service.FileRecycleService;
import com.hengyunsoft.platform.file.repository.file.service.FileService;
import com.hengyunsoft.platform.file.support.FileManager;
import com.hengyunsoft.platform.file.utils.FileUtils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

/**
 * 回收站实现类
 */
@Service
@Slf4j
public class FileRecycleServiceImpl extends BaseAllServiceImpl<Long, FileRecycle, FileRecycleExample> implements FileRecycleService {
    @Autowired
    private FileRecycleMapper fileRecycleMapper;
    @Autowired
    private FileRecycleService fileRecycleService;
    @Autowired
    private FileService fileService;
    @Autowired
    private FileProperties fileProperties;

    @Override
    protected BaseAllDao<Long, FileRecycle, FileRecycleExample> getDao() {
        return fileRecycleMapper;
    }

    /**
     * 回收站删除数据，并删除文件表相关记录，支持一个或者多个删除，及文件夹删除
     * 1.原始记录表只做逻辑删除，回收站表数据做物理删除
     * 2.将云盘系统的资源彻底删除，不可恢复
     *
     * @param appId
     * @param adminId
     * @param ids
     * @param
     * @return
     */
    @Override
    public int removeFileRecycleByAppIdAndIds(String appId, Long adminId, Long[] ids) {
        int result = 0;
        for (Long id : ids) {
            result = removeFileRecursion(result, id, appId, adminId);
        }
        return result;
    }

    /**
     * 文件存储节点递归
     *
     * @param result
     * @param id
     * @param appId
     * @param adminId
     * @return
     */
    public int removeFileRecursion(int result, Long id, String appId, Long adminId) {
        FileRecycle fileRecycle = fileRecycleMapper.selectByAppIdAndId(appId, id);
        log.info("查询回收站信息开始,应用ID[{}],ID[{}]", appId, id);

        //是否存在文件夹
        if (fileRecycle == null) {
            log.info("查询返回回收站信息为空！！,id[{}]", id);
            return result;//删除失败，并结束递归
        }
        boolean isExitsFile = DataType.DIR.toString().equals(fileRecycle.getDataType());
        result++;//成功返回

        //删除回收站记录
        int re = fileRecycleMapper.removeFileRecycleByAppIdAndId(appId, adminId, id);

        //删除原始文件记录
        if (re > 0) {
            // 还存在子节点恢复的情况
            if (isExitsFile) {//保留文件夹
                fileService.removeDirByAppIdAndId(appId, adminId, 1, id);
            } else {
                fileService.removeFileById(id);
            }
        }
        log.info("从回收站删除记录,id[{}]", id);

        //不存在文件夹情况
        if (!isExitsFile) {
            removeFileFromFastDfs(fileRecycle.getGroupName(), fileRecycle.getRemoteFileName(), fileRecycle.getAbsolutePath());
        }

        //存在文件夹情况
        if (isExitsFile) {
            log.info("根据父文件夹Id[{}]查询子文件列表开始", id);
            FileExample example = new FileExample();
            example.createCriteria().andFolderIdEqualTo(fileRecycle.getId());

            //根据父文件夹Id查询子文件列表
            List<File> list = fileService.find(example);
            if (list == null || list.size() <= 0) {
                log.info("无子文件！！结束递归,父id[{}]", fileRecycle.getId());
                return result;//无子节点，跳出递归
            }
            for (File ele : list) {
                //处理非文件夹
                if (ele != null && !DataType.DIR.toString().equals(ele.getDataType())) {
                    removeFileFromFastDfs(ele.getGroupName(), ele.getRemoteFileName(), ele.getAbsolutePath());
                    if (isExitsFile) {//保留文件夹
                        fileService.removeDirByAppIdAndId(appId, adminId, 1, id);
                    } else {
                        fileService.removeFileById(id);
                    }
                    log.info("删除原始文件记录,ID[{}]", ele.getId());
                }
                //继续递归文件夹寻找需要删除的资源
                if (ele != null && DataType.DIR.toString().equals(ele.getDataType())) {
                    log.info("根据当前文件夹Id查询是否为一级删除开始,id[{}]", ele.getId());
                    FileRecycleExample frExample = new FileRecycleExample();
                    frExample.createCriteria().andIsOneLevelDeleteEqualTo(true).andIdEqualTo(ele.getId());

                    //根据当前文件夹Id查询是否为一级删除
                    List<FileRecycle> frList = fileRecycleService.find(frExample);
                    if (frList != null && frList.size() > 0) {
                        log.info("当前文件夹为一级删除,终止递归,id[{}]", ele.getId());
                        return result;//跳出递归
                    }
                    log.info("进入递归处理文件夹[{}]", ele.getId());
                    result = removeFileRecursion(result, ele.getId(), appId, adminId);//递归子文件夹
                }
            }
        }
        return result;
    }

    /**
     * 清空回收站
     *
     * @param appId
     * @param admin_id
     * @return
     */
    @Override
    public int cleanAll(String appId, Long admin_id) {
        return fileRecycleMapper.cleanAll(appId, admin_id);
    }

    /**
     * 保存数据不使用自动生成主键
     *
     * @param relist
     * @return
     */
    @Override
    public int saveNoAutoGenId(List<FileRecycle> relist) {
        if (relist == null) {
            throw new RuntimeException("list is null");
        }
        int result = 0;
        for (FileRecycle t : relist) {
            saveNoAutoGenId(t);
            result++;
        }
        return result;
    }

    /**
     * 保存数据不使用自动生成主键
     *
     * @param refile
     * @return
     */
    @Override
    public int saveNoAutoGenId(FileRecycle refile) {
        if (refile == null) {
            throw new RuntimeException("不允许保存空对象");
        }
        Date nowDate = new Date();
        refile.setCreateTime(nowDate);
        refile.setUpdateTime(nowDate);
        return getDao().insert(refile);
    }

    /**
     * 还原回收站数据
     *
     * @param appId
     * @param adminId
     * @param ids
     * @return
     */
    @Override
    public int updateRecycle(String appId, Long adminId, Long[] ids) {
        int result = 0;
        for (Long id : ids) {
            result = updateRecycleRecursion(result, id, appId, adminId);
        }
        return result;
    }

    /**
     * 获取永久回收数据
     *
     * @return
     */
    @Override
    public List<FileRecycle> getForeverRecycle() {
        Boolean isOneLevelDelete = true;//是否一级删除
        return fileRecycleMapper.getForeverRecycle(isOneLevelDelete);
    }

    /**
     * 永久回收数据
     * 1.根据一级删除标识和时间查询10天后回收站数据
     * 2.根据当前id及foldId,递归删除当前节点及子节点的数据
     * 3.子节点存在一级删除,终止递归删除操作
     *
     * @param
     * @return
     */
    @Override
    public void updateForeverRecycle(Long id) {
        updateFecycleRecursion(id);
    }

    /**
     * 清空回收站数据
     *
     * @return
     */
    @Override
    public int deleteAll() {
        FileRecycleExample fileExample = new FileRecycleExample();
        return fileRecycleMapper.deleteByExample(fileExample);
    }

    /**
     * 递归处理回收站数据
     *
     * @param id
     */
    private void updateFecycleRecursion(Long id) {

        //删除当前节点
        fileRecycleMapper.foreverRecycle(id);//回收站
        fileService.updateForeverRecycle(id);//原始位置
        log.info("根据父资源Id[{}]查询子资源列表开始", id);
        FileExample example = new FileExample();
        example.createCriteria().andFolderIdEqualTo(id);

        //根据父资源查询子资源列表
        List<File> list = fileService.find(example);
        if (list == null || list.size() <= 0) {
            log.info("无子文件！！结束递归,父id[{}]", id);
            return;//无子节点，跳出递归
        }
        for (File e : list) {
            //处理非文件夹
            if (e != null && !DataType.DIR.toString().equals(e.getDataType()) && e.getFolderId() != -1) {
                fileRecycleMapper.foreverRecycle(e.getId());//回收站
                fileService.updateForeverRecycle(e.getId());//原始位置
                log.info("删除原始文件记录,ID[{}]", e.getId());
            }
            //继续递归文件夹寻找需要删除的资源
            if (e != null && DataType.DIR.toString().equals(e.getDataType()) && e.getFolderId() != -1) {
                log.info("根据当前文件夹Id查询是否为一级删除开始,id[{}]", e.getId());
                FileRecycleExample frExample = new FileRecycleExample();
                frExample.createCriteria().andIsOneLevelDeleteEqualTo(true).andIdEqualTo(e.getId());

                //根据当前文件夹Id查询是否为一级删除
                List<FileRecycle> frList = fileRecycleService.find(frExample);
                if (frList != null && frList.size() > 0) {
                    log.info("当前文件夹为一级删除,终止递归,id[{}]", e.getId());
                    return;//跳出递归
                }
                log.info("进入递归处理文件夹[{}]", e.getId());
                updateFecycleRecursion(e.getId());//递归子文件夹
            }
        }
    }

    /**
     * 文件存储节点递归
     * 1.根据当前id查询回收站记录
     * 2.处理treePath用于sql中找到相关的节点
     * 3.根据一级删除标识查询当前父节点是否被删除
     * 4.物理删除回收站的数据,逻辑删除原始记录表中数据
     * 5.存在子文件夹先物理删除非文件夹,再递归子文件夹
     *
     * @param result
     * @param id
     * @param appId
     * @param adminId
     * @return
     */
    public int updateRecycleRecursion(int result, Long id, String appId, Long adminId) {
        FileRecycle fileRecycle = fileRecycleMapper.selectByAppIdAndId(appId, id);
        log.info("查询回收站信息开始,应用ID[{}],ID[{}]", appId, id);

        //是否存在文件夹
        if (fileRecycle == null) {
            log.info("查询返回回收站信息为空！！,id[{}]", id);
            return result;
        }
        boolean isExitsFile = DataType.DIR.toString().equals(fileRecycle.getDataType());
        result++;//成功返回
        String treePath = "";
        String currentParentId = ""; //当前节点父ID
        boolean isExitsParentIsDelete = false;//是否存在父节点被删除
        if (isExitsFile) {
            String[] tmp = fileRecycle.getTreePath().split(",");
            for (int i = 0; i < tmp.length; i++) {
                treePath += "'" + tmp[i] + "',";
                if (tmp.length - 1 == i) {//倒数第一个为父ID
                    currentParentId = tmp[i];
                }
            }
        }
        if (!"".equals(treePath)) {
            treePath = treePath.substring(0, treePath.length() - 1);
        }

        //查询当前父节点是否被删除
        FileExample curExample = new FileExample();
        if (!StringUtils.isEmpty(currentParentId)) {
            curExample.createCriteria().andIdEqualTo(Long.parseLong(currentParentId))
                    .andIsDeleteEqualTo(true);
            List<File> fileList = fileService.find(curExample);
            if (fileList != null && fileList.size() > 0) {
                isExitsParentIsDelete = true; //被删除
            }
        }

        //删除回收站记录
        int re = fileRecycleMapper.removeFileRecycleByAppIdAndId(appId, adminId, id);
        log.info("从回收站删除记录,id[{}]", id);

        //从回收站还原文件数据到原始位置
        if (re > 0) {
            addRecycle(isExitsParentIsDelete, id, appId, adminId, treePath);
        }

        //存在文件夹情况
        if (isExitsFile) {
            log.info("根据父文件夹Id[{}]查询子文件列表开始", id);
            FileExample example = new FileExample();
            example.createCriteria().andFolderIdEqualTo(fileRecycle.getId());

            //根据父文件夹Id查询子文件列表
            List<File> list = fileService.find(example);
            if (list == null || list.size() <= 0) {
                log.info("无子文件！！结束递归,父id[{}]", fileRecycle.getId());
                return result;//无子节点，跳出递归
            }
            for (File ele : list) {
                //处理非文件夹,子目录不存在新生成的父目录情况
                if (ele != null && !DataType.DIR.toString().equals(ele.getDataType()) && ele.getFolderId() != -1) {
                    addRecycle(isExitsParentIsDelete, id, appId, adminId, treePath);
                    log.info("删除原始文件记录,ID[{}]", ele.getId());
                }
                //继续递归文件夹寻找需要还原的资源,子目录不存在新生成的父目录情况
                if (ele != null && DataType.DIR.toString().equals(ele.getDataType()) && ele.getFolderId() != -1) {
                    log.info("根据当前文件夹Id查询是否为一级删除开始,id[{}]", ele.getId());
                    FileRecycleExample frExample = new FileRecycleExample();
                    frExample.createCriteria().andIsOneLevelDeleteEqualTo(true).andIdEqualTo(ele.getId());

                    //根据当前文件夹Id查询是否为一级删除
                    List<FileRecycle> frList = fileRecycleService.find(frExample);
                    if (frList != null && frList.size() > 0) {
                        log.info("当前文件夹为一级删除,终止递归,id[{}]", ele.getId());
                        return result;//跳出递归
                    }
                    log.info("进入递归处理文件夹[{}]", ele.getId());
                    result = updateRecycleRecursion(result, ele.getId(), appId, adminId);//递归子文件夹
                }
            }
        }
        return result;
    }

    /**
     * 回收站处理
     * 存在父节点被删除,更新当前子节点为父节点
     *
     * @param isExitsParentIsDelete
     * @param id
     * @param appId
     * @param adminId
     * @param treePath
     */
    public void addRecycle(boolean isExitsParentIsDelete, Long id, String appId, Long adminId, String treePath) {
        if (isExitsParentIsDelete) {
            log.info("存在父节点被删除,更新当前节点为父节点,id[{}]", id);
            fileService.updateRecycleFile(appId, adminId, id, "");//回收当前节点
            File currFile = new File();
            currFile.setId(id);
            currFile.setFolderId(new Long(-1));
            fileService.updateByIdSelective(currFile);//更新为父节点;
        } else {
            fileService.updateRecycleFile(appId, adminId, id, treePath);//回收所有
        }
    }

    /**
     * 从fastDFS存储磁盘删除文件
     *
     * @param GroupName
     * @param fileName
     * @param absolutePath
     */
    public void removeFileFromFastDfs(String GroupName, String fileName, String absolutePath) {
        boolean flag = false;
        if (fileProperties.getFastdfs().isEnabled()) {
            flag = FileManager.getInstance().deleteFile(GroupName, fileName);
            if (flag) {
                log.info("从云盘中彻底删除文件成功,组名[{}],文件名[{}]", GroupName, fileName);
            } else {
                log.info("从云盘中彻底删除文件失败,组名[{}],文件名[{}]", GroupName, fileName);
            }
        } else {
            flag = FileUtils.deleteFileOn(Paths.get(absolutePath, fileName).toString());
            if (flag) {
                log.info("从应用磁盘中彻底删除文件成功,绝对路径[{}],文件名[{}]", absolutePath, fileName);
            } else {
                log.info("从应用磁盘中彻底删除文件失败,绝对路径[{}],文件名[{}]", absolutePath, fileName);
            }
        }
    }

    @Override
    public Boolean clearAll(String appId, Long adminId) {
        FileRecycleExample example = new FileRecycleExample();
        example.createCriteria().andAppIdEqualTo(appId)
                .andCreateUserEqualTo(adminId);
        fileRecycleMapper.deleteByExample(example);
        return true;
    }
}
