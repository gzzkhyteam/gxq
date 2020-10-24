var html="";
var channelId="";
var htm="";
var pre_array=new Array();
var draft_home="";//用来区别是来自草稿箱还是已发送
/**
 * 传递参数---服务商，区别是来自草稿箱还是已发送
 * @param channelServer_pass
 * @param home
 */
function deliver(channelServer_pass,home) {
    channelServer=channelServer_pass;
    draft_home=home;
}
function init(appId,channelId_defined,channelName_defined,templateId,templateName_defined){
    channelId=channelId_defined;
    ajaxHengyun({
        type:"get",
        dataType: 'json',
        cache: false,
        url: urlPost+"/api/sms/api/smschannel/list",
        data:{appId:appId},
        success:function(data){
            var arrdata=data.data;
            $("#useCarReason").combobox({
                disabled: false,
                editable: false,  // 可编辑
                panelHeight: 'auto',
                valueField: 'channelId',
                textField: 'channelName',
                multiple: false,  // 单选复选
                data: arrdata,
                onSelect: function (data) {
                    channelServer=data.channelServer;
                    var _that=$(this);
                    appName=data.channelName;
                    channelId=data.channelId;
                   //级联根据channelId获取模板
                    ajaxHengyun({
                        type:"post",
                        url: urlPost+"/api/sms/api/smstemplate/listcreate",
                        data:{channelId:channelId},
                        success:function(data){
                            var arrdata=data.data.list;
                            //参数和code放在一个表里面然后循环匹配

                            $("#useReason").combobox({
                                disabled: false,
                                editable: false,  // 可编辑
                                panelHeight: 'auto',
                                valueField: 'templateCode',
                                textField: 'name',
                                multiple: false,  // 单选复选
                                data: arrdata,
                                onSelect: function (data) {
                                    $("#useReason").attr("id_add",$(this).combobox('getValues')[0]);
                                    $("#useReason").attr("name_add",$(this).combobox('getText'));

                                    var _that=$(this);
                                    var templatename=data.name;
                                    templateid=data.templateCode;

                                    var content=data.content;
                                    var templateParam=data.templateParam;
                                    appId_send=data.appId;
                                    appName=data.appName;

                                    for(var i=0;i<arrdata.length;i++){
                                        var arr=arrdata[i];
                                        var templateCode_cam=arrdata[i].templateCode;
                                        var templateParams_cam=arrdata[i].templateParam;
                                        var preview="短信效果：";
                                        preview+="<p>"+templateParams_cam+"</p>";
                                        $("#preview").html(preview);
                                        if(templateid==templateCode_cam){
                                            var array;
                                            array = templateParams_cam.split(",");
                                            var param_array=new Array();
                                            for(var j=0;j<array.length;j++){
                                                var param=array[j].split(":")[0].replace(/"/g,"").replace(/{/,"");
                                                param_array[j]=param;
                                            }
                                            html="";
                                            htm="";
                                            pre_array=param_array;
                                            for(var k=0;k<param_array.length;k++){


                                                htm+="<li><span>"+param_array[k]+"：</span><span class=\"qudao\"><input class=\"qudaoinput\" id="+param_array[k]+" type=\"text\"></span></li>";
                                                html+="<li><span>"+param_array[k]+"：</span><span class=\"qudao\"><input class=\"qudaoinput\" name="+param_array[k]+" type=\"text\"></span></li>";

                                            }

                                            if($("#content").has("li").length > 0){
                                                $("#content").empty();
                                                $("#content").html(html);
                                            }else{
                                                $("#content").html(html);
                                            }
                                            var yulan=content;

                                            //测试内容删除
                                            content_tt=content;
                                            //转换content
                                            var yulan_array=new Array();
                                            for(var pre=0;pre< pre_array.length;pre++ ){
                                                if(channelServer=="Alibaba"||channelServer=="Baidu"){
                                                    spiltMark="${";
                                                }else if(channelServer=="Tencent"){
                                                    spiltMark="{";
                                                }
                                                var old=spiltMark+pre_array[pre]+"}";
                                                var rep="<span class="+pre_array[pre]+">"+old+"</span>";
                                                yulan=yulan.replace(old,rep);
                                            }
                                            if($("#yulan").html()){
                                                $("#yulan").empty();
                                                $("#yulan").html(yulan);

                                            }else{
                                                $("#yulan").html(yulan);

                                            }
                                            $('.qudaoinput').bind('input propertychange', function(){
                                                var names = $(this).attr('name');
                                                var val = $(this).val();
                                                $('.'+names).text(val)
                                            })
                                            break;


                                        }
                                    }
                                },
                                onLoadSuccess: function () {
                                    //下拉框热区范围改为整个输入框
                                    $(".combo").click(function(){
                                        $(this).prev().combobox("showPanel");
                                    });
                                }
                            });
                        }//success
                    })
                },
                onLoadSuccess: function () {
                    //下拉框热区范围改为整个输入框
                    $(".combo").click(function(){
                        $(this).prev().combobox("showPanel");
                    });
                    //写默认的channelId
                    $("#useCarReason").attr("id_add",channelId_defined)
                    $("#useCarReason").combobox("setValue",channelName_defined)

                    ajaxHengyun({
                        type:"post",
                        url: urlPost+"/api/sms/api/smstemplate/listcreate",
                        //data:{channelId:channelId},
                        data:{channelId:channelId_defined},
                        success:function(data){
                            var arrdata=data.data.list;
                            //参数和code放在一个表里面然后循环匹配

                            $("#useReason").combobox({
                                disabled: false,
                                editable: false,  // 可编辑
                                panelHeight: 'auto',
                                valueField: 'templateCode',
                                textField: 'name',
                                multiple: false,  // 单选复选
                                data: arrdata,
                                onSelect: function (data) {
                                    $("#useReason").attr("id_add",$(this).combobox('getValues')[0]);
                                    $("#useReason").attr("name_add",$(this).combobox('getText'));

                                    var _that=$(this);
                                    var templatename=data.name;
                                    templateid=data.templateCode;

                                    var content=data.content;

                                    var templateParam=data.templateParam;
                                    appId_send=data.appId;
                                    appName=data.appName;

                                    for(var i=0;i<arrdata.length;i++){
                                        var arr=arrdata[i];
                                        var templateCode_cam=arrdata[i].templateCode;
                                        var templateParams_cam=arrdata[i].templateParam;
                                        var preview="短信效果：";
                                        preview+="<p>"+templateParams_cam+"</p>";
                                        $("#preview").html(preview);
                                        if(templateid==templateCode_cam){
                                            var array;
                                            array = templateParams_cam.split(",");
                                            var param_array=new Array();
                                            for(var j=0;j<array.length;j++){
                                                var param=array[j].split(":")[0].replace(/"/g,"").replace(/{/,"");
                                                param_array[j]=param;
                                            }
                                            html="";
                                            htm="";
                                            pre_array=param_array;
                                            for(var k=0;k<param_array.length;k++){


                                                htm+="<li><span>"+param_array[k]+"：</span><span class=\"qudao\"><input class=\"qudaoinput\" id="+param_array[k]+" type=\"text\"></span></li>";
                                                //html+="<li><span>"+param_array[k]+"：</span><span class=\"qudao\"><textarea class=\"qudaoinput\" style='resize:none;width:100%;' name="+param_array[k]+" type=\"text\"></textarea></span></li>";
                                                html+="<li><span>"+param_array[k]+"：</span><span class=\"qudao\"><textarea style='resize:none;width:100%;overflow-y:auto;max-height: 60px  ' onpropertychange=\"this.style.height=this.scrollHeight+'px'\"  oninput=\"this.style.height=this.scrollHeight + 'px'\" class=\"qudaoinput\"  name="+param_array[k]+" type=\"text\"></textarea></span></li>";
                                            }

                                            if($("#content").has("li").length > 0){
                                                $("#content").empty();
                                                $("#content").html(html);
                                            }else{
                                                $("#content").html(html);
                                            }
                                            var yulan=content;

                                            //测试内容删除
                                            content_tt=content;
                                            //转换content
                                            var yulan_array=new Array();
                                            for(var pre=0;pre< pre_array.length;pre++ ){
                                                if(channelServer=="Alibaba"||channelServer=="Baidu"){
                                                    spiltMark="${";
                                                }else if(channelServer=="Tencent"){
                                                    spiltMark="{";
                                                }
                                                var old=spiltMark+pre_array[pre]+"}";
                                                var rep="<span class="+pre_array[pre]+">"+old+"</span>";
                                                yulan=yulan.replace(old,rep);
                                            }
                                            if($("#yulan").html()){
                                                $("#yulan").empty();
                                                $("#yulan").html(yulan);

                                            }else{
                                                $("#yulan").html(yulan);

                                            }

                                            $('.qudaoinput').bind('input propertychange', function(){
                                                var names = $(this).attr('name');
                                                var val = $(this).val();
                                                $('.'+names).text(val)
                                            })
                                            break;


                                        }
                                    }
                                },
                                onLoadSuccess: function () {
                                    $("#useReason").attr("id_add",templateId)
                                    $("#useReason").combobox("setValue",templateName_defined)
                                    //下拉框热区范围改为整个输入框
                                    $(".combo").click(function(){
                                        $(this).prev().combobox("showPanel");
                                    });
                                }
                            });

                        }//success
                    })

                }
            });

        }
    })
}

/**
 * content
 * @type {string}
 */
var templateId_pass="";
function paramSpilt(template_params,templateId){
    templateId_pass=templateId;
   //分割传过来的参数放入
    var array;
    array = template_params.split(",");
    var key_array=new Array();
    var val_array=new Array();
    for(var j=0;j<array.length;j++){
        var param_key=array[j].split(":")[0].replace(/"/g,"").replace(/{/,"");
        var param_val=array[j].split(":")[1].replace(/"/g,"").replace(/{/,"").replace(/}/,"");
        key_array[j]=param_key;
        val_array[j]=param_val;

    }
    for(var k=0;k<key_array.length;k++){
        htm +="<li><span>"+key_array[k]+"：</span><span class=\"qudao\"><input class=\"qudaoinput\" id="+key_array[k]+"  type=\"text\" value="+val_array[k]+"></span></li>";
        //html+="<li><span>"+key_array[k]+"：</span><span class=\"qudao\"><input class=\"qudaoinput\"  name="+key_array[k]+" type=\"text\" value="+val_array[k]+"></span></li>";
        html+="<li><span>"+key_array[k]+"：</span><span class=\"qudao\"><textarea  style='resize:none;width:100%;overflow-y:auto;max-height: 60px  ' onpropertychange=\"this.style.height=this.scrollHeight+'px'\"  oninput=\"this.style.height=this.scrollHeight + 'px'\" class=\"qudaoinput\"  name="+key_array[k]+" type=\"text\" >"+val_array[k]+"</textarea></span></li>";
    }
    if($("#content").has("li").length > 0){
        $("#content").empty();
        $("#content").html(html);
    }else{
        $("#content").html(html);
    }
}


/*发送
*/
var stas=true;
$("#sendbtn").click(function(){
    if(stas==false){
        return;
    }else{
        stas=false;
    }
    setTimeout(function(){
        stas = true;
    },500)

    if(draft_home==2){
        status=2;
    }else{
        status=0;
    }
    /*var val=$("#contactPerson").val()
    if(!val){
        layer.msg('接收人不能为空！',{offset: ['40%', '35%']});
        return;
    }*/
    sendfun(status);

})

/**
 * 定时发送
 * @param status
 * @param time
 */

$("#sendtime").click(function(){
    if(stas==false){
        return;
    }else{
        stas=false;
    }
    setTimeout(function(){
        stas = true;
    },500)
    if(draft_home==2){
        status=2;
    }else{
        status=0;
    }

   /* var val=$("#contactPerson").val()
    if(val.match(/^[ ]+$/)){
        layer.msg('接收人不能为空！',{offset: ['40%', '35%']});
        return;
    }
    if(!val){
        layer.msg('接收人不能为空！',{offset: ['40%', '35%']});
        return;
    }
*/

    layer.open({
        type: 1,
        title:'定时发送',
        area: ['350px', '200px'],
        shadeClose: true, //点击遮罩关闭
        content: $(".datapicker"),
        btn:['确定','取消'],
        yes:function(){
            var sendJobTime=$(".datapicker").find('input').val();
            if(""!=sendJobTime)
            {
                sendfun(status,sendJobTime);
                layer.closeAll();
            }else {

                layer.msg('时间不能为空！',{offset: ['40%', '35%']});
            }
        }

    });
})

/**
 * 存草稿
 * @param status
 * @param time
 */

$("#savedraft").click(function(){
    if(stas==false){
        return;
    }else{
        stas=false;
    }
    setTimeout(function(){
        stas = true;
    },500)
    status=1;
    /*var val=$("#contactPerson").val()
    if(!val){
        layer.msg('接收人不能为空！',{offset: ['40%', '35%']});
        return;
    }*/
    sendfun(status);

})
/**
 * 发送
 */
//用于点击三个按钮以后跳转界面
function jump(status){
    /*if(status==1){//存草稿成功跳转草稿箱
        window.location.href= '/gxqpt-sms/sms/shortDrafts';
    }else if(status==0){//发送或者定时发送成功跳转已发送列表
        window.location.href= '/gxqpt-sms/sms/publishShortSucess';
    }else{//操作失败
        window.location.href= '/gxqpt-sms/sms/create';
    }*/
    if(status==1){//存草稿成功跳转草稿箱
        $(parent.top.document).find('a.tab_nei')[1].click();
//       window.location.href= '/gxqpt-sms/sms/shortDrafts';
    }else if(status==0){//发送或者定时发送成功跳转已发送列表
        //window.location.href= '/gxqpt-sms/sms/publishShortSucess';
        $(parent.top.document).find('a.tab_nei')[2].click();
    }else{//操作失败
        window.location.href= '/gxqpt-sms/sms/publishShortSucess';
    }
}
var pass_content;
function sendfun(status,time){
    //是不是电话号码的格式
    var reg = /^1[34578][0-9]{9}$/;
    var flag=true;
    var mobile="";
    var submobile="";
    var mobileArray=new Array();
    var submobileArray=new Array();
    if($("#contactPerson").text()){
        isExist=true;
        submobile+=$("#contactPerson").text();
        if(submobile.indexOf("<")!=-1){
            //李孟珊珊02<15285138211>管理员<15218869970>15732153018
            mobileArray=submobile.split(">");
        }
        for(var r=0;r<mobileArray.length;r++){
            if(mobileArray[r]){
                if(mobileArray[r].indexOf("<")!=-1){
                    mobile+=mobileArray[r]+">,";
                    mobileArray[r]=mobileArray[r].substring(mobileArray[r].indexOf("<")+1,mobileArray[r].length);

                    flag=reg.test(mobileArray[r]);
                    if(!flag){
                        layer.msg('请输入正确格式的接收人！',{offset: ['40%', '35%']});
                        return;
                    }
                }else{
                    mobile+=mobileArray[r]+",";
                    if(mobileArray[r].indexOf(",")!=-1){
                        submobileArray=mobileArray[r].split(",");
                        for(var q=0;q<submobileArray.length;q++){
                            flag=reg.test(submobileArray[q]);
                            if(!flag){
                                layer.msg('请输入正确格式的接收人！',{offset: ['40%', '35%']});
                                return;
                            }
                        }
                    }else{
                        flag=reg.test(mobileArray[r]);
                        if(!flag){
                            layer.msg('请输入正确格式的接收人！',{offset: ['40%', '35%']});
                            return;
                        }
                    }

                }
            }

        }
    }

    if(mobileArray.length==0){
        mobile=submobile+",";
    }
    if(!isExist){
        layer.msg('接收人不能为空！',{offset: ['40%', '35%']});
        return;
    }

    mobile=mobile.substr(0,mobile.length-1);
    /*var mobile=$("#contactPerson").val();
    if(mobile.match(/^[ ]+$/)){
        layer.msg('接收人不能为空！',{offset: ['40%', '35%']});
        return;
    }
    if(!mobile){
        layer.msg('接收人不能为空！',{offset: ['40%', '35%']});
        return;
    }
    var reg = /^1[34578][0-9]{9}$/;
    var flag=true;
    if(mobile.indexOf(",")!=-1){
        var arrayPhone;
        arrayPhone = mobile.split(",");
        for(var k=0;k<arrayPhone.length;k++){
            var contact_number="";
            if(arrayPhone[k].indexOf("<")!=-1){
                contact_number=arrayPhone[k].substring(arrayPhone[k].indexOf("<")+1,arrayPhone[k].length-1)
            }else{
                contact_number=arrayPhone[k];
            }


            flag=reg.test(contact_number);
            if(!flag){
                layer.msg('请输入正确格式的接收人！',{offset: ['40%', '35%']});
                return;
            }
        }
    }else{
        if(mobile.indexOf("<")!=-1){
            contact_number=mobile.substring(mobile.indexOf("<")+1,mobile.length-1)
        }else{
            contact_number=mobile;
        }
        flag=reg.test(contact_number);
        if(!flag){
            layer.msg('请输入正确格式的接收人！',{offset: ['40%', '35%']});
            return;
        }
    }*/
   if(!channelId){
        layer.msg('请选择使用账号！',{offset: ['40%', '35%']});
        return;
    }
    if(!($("#useReason").attr("id_add"))){
        layer.msg('请选择使用模板！',{offset: ['40%', '35%']});
        return;
    }

   //模板参数循环li标签得id的值
    var test=htm;
    var array_li=new Array();
    var array_in=new Array();
    //测试内容删除
    var array_content=new Array();
    var templateParams="{";
    array_li = test.split("</li>");
    for(var index=0;index<array_li.length-1;index++){
        var str = array_li[index];
        str=(str.substring(str.indexOf('id=')+3,str.indexOf('type')-1)).trim();
        var inputVal=$("textarea[name="+str+"]").val();
        if(inputVal==""){
            layer.msg('模板参数填写不完整！',{offset: ['40%', '35%']});
            return;
        }
        array_in[index]=str;

        templateParams+="\""+str+"\""+":"+"\""+inputVal+"\""+",";
        //内容测试放值删除
        array_content[index]=inputVal;
    }
    templateParams=templateParams.substr(0,templateParams.length-1);
    templateParams+="}";
    //内容测试删除
    //如果没有选pre_array
    if(pre_array.length==0){
        content_tt=pass_content;
        pre_array=array_in;
        //需要改变
        for(var pre=0;pre< pre_array.length;pre++ ){
            if(channelServer=="Alibaba"||channelServer=="Baidu"){
                spiltMark="${";
            }else if(channelServer=="Tencent"){
                spiltMark="{";
            }

            var old=spiltMark+pre_array[pre]+"}";
            //var old="${"+pre_array[pre]+"}";
            var rep=array_content[pre];
            content_tt=content_tt.replace(old,rep);
        }


    }else {
        //如果选了有存在
        for (var pre = 0; pre < pre_array.length; pre++) {
            if(channelServer=="Alibaba"||channelServer=="Baidu"){
                spiltMark="${";
            }else if(channelServer=="Tencent"){
                spiltMark="{";
            }

            var old=spiltMark+pre_array[pre]+"}";

            var rep = array_content[pre];
            content_tt = content_tt.replace(old, rep);
        }
    }


    templateid=templateId_pass;
    //topic
    var topic=$("#smsTopic").val();
    channelId="{\"Sms\":\""+channelId+"\"}";
    //来源于已发送则传参mgsid为空值
   if(draft_home==0){
       msgId_Pass="";
   }
    ajaxHengyun({

        type:"post",
        url: urlPost+"/api/sms/api/smsrecord/add",
        contentType:"application/json",    //注意传参格式
        dataType:"json",
        data:JSON.stringify({
            "msgId":msgId_Pass,
            "receiver":mobile,
            "channelId":channelId,
            "templateId":templateid,
            "templateParams":templateParams,
            "topic":topic,
            "draft":status,
            "startTime":time,
            "context":content_tt
        }),
        success:function(rows){
            if(rows.data) {
                if(rows.data=="发送短信异常"){
                    layer.msg(rows.data,{offset: ['40%', '35%']});
                }else{
                    layer.msg(rows.data,{offset: ['40%', '35%']});
                    //跳转界面 发送定时发送---已发送 草稿-----草稿箱

                    setTimeout('jump(status)', 1000 )
                }

            } else {

                layer.msg('失败！',{offset: ['40%', '35%']});

            }
        }
    })


    /**
     * 常用联系人电话的update,save
     */
    ajaxHengyun({
        type:"post",
        dataType:'json',
        cache:false,
        //url: urlPost+"/api/msgs/message/getSendPhonenum",
        url: urlPost+"/api/sms/api/message/getSendPhonenum",
        data:{contact_send:mobile},
        success: function (data){

            console.log("success");
        },
        error:function(){
            console.log("fail");
        }
    })
}

/*
传模板对应的content参数
 */
var msgId_Pass="";
function changeTxt(content,template_params,msgId_pass){
    pass_content=content;
    yulan=content;
    msgId_Pass=msgId_pass;
    var array;
    array = template_params.split(",");
    var param_array=new Array();
    for(var j=0;j<array.length;j++){
        var param=array[j].split(":")[0].replace(/"/g,"").replace(/{/,"");
        param_array[j]=param;
    }
   for(var pre=0;pre< param_array.length;pre++ ){
       if(channelServer=="Alibaba"||channelServer=="Baidu"){
           spiltMark="${";
       }else if(channelServer=="Tencent"){
           spiltMark="{";
       }

       var old=spiltMark+param_array[pre]+"}";

        var rep="<span class="+param_array[pre]+"></span>";
        yulan=yulan.replace(old,rep);
    }
    $("#yulan").html(yulan);
    var length = $("#content").children('li').length;
    var right = $('#yulan').children('span');
    for(var i=0;i<length;i++){
        right.eq(i).html($("#content").children('li').eq(i).children('.qudao').children('.qudaoinput').val());
        // console.log($("#content").children('li').eq(i).children('.qudao').children('.qudaoinput').val());
    }
    $('.qudaoinput').bind('input propertychange', function(){
        var names = $(this).attr('name');
        var val = $(this).val();
        $('.'+names).text(val)
    })
}

/*新建发布右侧选项卡*/

$(".btnbox span").click(function () {
    $(this).addClass("spancurrent").siblings().removeClass("spancurrent");
    var n=$(this).index();
    $(".treebox .treecontainer").hide();
    $(".treebox .treecontainer").eq(n).show();
})
/*
常用联系人
 */
/**
 * 初次进入新建发布页面,展示用户的全部联系人
 */
var phonenumArray = []
getIdPhonenum();
function getIdPhonenum(){
    var contact=null ;
    ajaxHengyun({
        type:"post",
        dataType:'json',
        cache:false,
        url: urlPost+"/api/sms/api/message/getIdPhonenum",
        data:{contact:contact},
        success: function (data){
            if(data.errcode == 0){
                phonenumArray = []
                $("#oftenconnection").html('');
                $.each(data.data.list,function(index,item){
                    phonenumArray.push(item.id)
                    $("#oftenconnection").append("<li id="+item.id+" title="+item.contact+">"+item.contactname+"<"+item.contact+"><span class='glyphicon glyphicon-remove phonenum' onclick='deleteContactByIds(\""+item.id+"\")'></span><li/>")
                })
            }
        },
        error:function(){
            console.log("false");
        }
    })
}
/*常用联系人点击右侧自动填入左侧*/
var phone="";
$("#oftenconnection").on('click','li',function(){
    var family;
    var isLeaf=false;
    if(phone==""){
        //var family=$(this).text()+"<"+$(this).attr("title")+">";
        family=$(this).text().trim()
        phone+="<span class='spanbox'><span class='spantext'>"+family+"<i class='fa fa-remove'></i></span></span>";

    }else{
        phone+=",";
        family=$(this).text().trim()
        //var family=$(this).text()+"<"+$(this).attr("title")+">";
        phone+="<span class='spanbox'><span class='spantext'>"+family+"<i class='fa fa-remove'></i></span></span>";

    }
    if($("#contactPerson").html()){
        var str=$("#contactPerson").html();
        //var mobile=compareStr(str,phone);
        $("#contactPerson>span").each(function(){
            var spanTxt=$(this).find('.spantext').text().trim();

            if(spanTxt==family||spanTxt.indexOf(family)!=-1){
                phone="";
                return false;
            }else{
                isLeaf=true;
            }

        })
        if(isLeaf){
            str+=phone
            $("#contactPerson").html('')
            $("#contactPerson").append(str);
            phone="";
        }
    }else{
        $("#contactPerson").append(phone);
        phone="";
    }

    $(this).addClass("contactli").siblings().removeClass('contactli');
})
//删除单条数据
$("#contactPerson").on('click','.fa-remove',function(){
    $(this).parent().remove();
})
//删除常用联系人
function deleteContactByIds(id) {
    var ids = [];
    var msgTopInfo = '确认删除所选中的常用联系人吗？';
    if(id){
        ids = [id]
    }else{
        ids = phonenumArray
        msgTopInfo = '确认清空常用联系人吗？';
    }
    parent.layer.open({
        type: 1,
        title: '删除确认',
        maxmin: false, //开启最大化最小化按钮
        area: ['270px', '136px'],
        content: msgTopInfo,
        btn: ['<span class="glyphicon glyphicon-ok"></span>确定', '<span class="glyphicon glyphicon-remove"></span>取消'],
        yes: function (index, layero) {
            ajaxHengyun({
                type:"post",
                dataType:'json',
                url: urlPost+"/api/sms/api/message/deleteContactByIds?ids="+ids,
                success: function (data){
                    if(data.errcode==0){
                        parent.layer.close(index);
                        parent.layer.msg("删除成功！", {time: 1500})
                        getIdPhonenum()
                    }else{
                        parent.layer.msg(data.errmsg, {time: 1500})
                    }
                },
                error:function(){
                    //保存失败
                    console.log("fail");
                }
            })
        }
    });
}

/*$("#oftenconnection").on('click','li',function(){
    if(phone==""){
        //var family=$(this).text()+"<"+$(this).attr("title")+">";
        var family=$(this).text()
        phone+=family;

    }else{
        phone+=",";
        var family=$(this).text()
        //var family=$(this).text()+"<"+$(this).attr("title")+">";
        phone+=family;

    }
    if($("#contactPerson").val()){
        var str=$("#contactPerson").val();
        var mobile=compareStr(str,phone);
        $("#contactPerson").val(mobile);
        phone="";
    }else{
        $("#contactPerson").val(phone);
        phone="";
    }

    $(this).addClass("contactli").siblings().removeClass('contactli');
})*/

/*
*对比两个字符串
* src为联系人原有的内容
* pass为后面选择的字符串
* array_con放拼接在原字符串后面的值
 */
function compareStr(src,pass){
    var array_src=new Array();
    var array_pass=new Array();
    var array_con=new Array();
    var des="";
    array_src=src.split(",");
    array_pass=pass.split(",");
    //差集
    //var array_fir=Array.minus(array_src,array_pass);
    //var array_sec=Array.minus(array_pass,array_src);
    //两个差集取交集
    //var array_cha=Array.intersect(array_fir,array_sec);
    //并集
    var array_bing=Array.union(array_src,array_pass);
    des=array_bing.join(",");
    return des;


}
Array.prototype.uniquelize = function(){
    var ra = new Array();
    for(var i = 0; i < this.length; i ++){
        if(!ra.contains(this[i])){
            ra.push(this[i]);
        }

    }
    return ra;
};
Array.union = function(a, b){
    return a.concat(b).uniquelize();
};
Array.prototype.contains = function(val)
{
    for (var i = 0; i < this.length; i++)
    {
        if (this[i] == val)
        {
            return true;
        }
    }
    return false;
};

