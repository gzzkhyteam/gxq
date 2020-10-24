var qudaoTypeArray = [];//渠道类型数组
var wxfileArray = [];
/* 附件上传 begin */
var token = getCurToken();//getToken();getCurToken();
var folderId="-1";
var dataType="";
var wbFileUrl = "",wbFileSize=0,wbFileId="",wbFileName="";
loadFile();
/*
*
*
*上传控件webupload初始化
*
*
**/
function loadFile() {
    fileUpload = new FileUploadImg({
        "filePicker" : "filePicker2",
        "dndArea" : "dndArea2",
        "uploader" : "uploader2",
        "jxButton" : "jxButton2",
        "folderId":folderId,
        "dataType":dataType,
        "token":token,
        "_isAdmin":true,
        callbackfun:successUpload
    });
    fileUpload3 = new FileUploadImg({
        "filePicker" : "filePicker3",
        "dndArea" : "dndArea3",
        "uploader" : "uploader3",
        "jxButton" : "jxButton3",
        "folderId":folderId,
        "dataType":dataType,
        "token":token,
        "_isAdmin":true,
        callbackfun:successUploadImg
    });
    fileUpload = new FileUpload({
        "filePicker" : "filePicker1",
        "dndArea" : "dndArea1",
        "uploader" : "uploader1",
        "jxButton" : "jxButton1",
        "folderId":folderId,
        "dataType":dataType,
        "token":token,
        "_isAdmin":true
    });
}
/*
*
*
*图片上传成功后回调
*
*
**/
function successUpload(json) {
    wxfileArray.push(json.data.list[0]);
    var url = json.data.list[0].url;
    //得到图片路径，存放到微信中，图文json串中
    var html = '<img src="'+url+'"/>';
    UE.getEditor('myEditor').focus();
    UE.getEditor('myEditor').execCommand('inserthtml',html);
};
/*
*
*
*微博图片上传成功后回调
*
*
**/
function successUploadImg(json) {
    var html = '<p><span>'+json.data.list[0].submittedFileName+'</span><span class="remove fa fa-remove" onclick="removeWbFile(this)"></span></p>'
    $("#showFile").html(html);
    wbFileUrl = json.data.list[0].url;
    wbFileSize = json.data.list[0].size;
    wbFileId = json.data.list[0].id;
    wbFileName = json.data.list[0].submittedFileName;
};
function removeWbFile(ele){
    $(ele).parent().remove();
    wbFileUrl = '';
    wbFileSize = '';
    wbFileId = '';
    wbFileName = '';
}
/*
*
*
*附件上传成功后回调
*
*
**/
function successUploadFile(json) {
    var url = json.data.list[0].url;
    var name = json.data.list[0].submittedFileName;
    var urlDownload = "${_gate_url}/api/file/file/download?url=" + url + "&filename=" + name;
    html='<a href="'+urlDownload+'">'+name+'</a>';
    $("#testcon").html(html);
    window.setTimeout(function(){
        UE.getEditor('myEditor').focus();
        UE.getEditor('myEditor').execCommand('inserthtml',$('#testcon').html());
    },1000);
};
var ue = UE.getEditor('myEditor');//初始化富文本编辑器
/*
*
*
*自定义富文本编辑器中的上传图片按钮
*
*
**/
UE.registerUI('uploadimg', function(editor, uiName) {
    //注册按钮执行时的command命令，使用命令默认就会带有回退操作
    editor.registerCommand(uiName, {
        execCommand: function() {
            alert('execCommand:' + uiName)
        }
    });
    //创建一个button
    var uploadimg = new UE.ui.Button({
        //按钮的名字
        name: "uploadimg",
        //提示
        title: "图片上传",
        //添加额外样式，指定icon图标，这里默认使用一个重复的icon
        cssRules: 'background-position: -380px 0px;',
        //点击时执行的命令
        onclick: function() {
            //这里可以不用执行命令,做你自己的操作也可
            //editor.execCommand(uiName);
            //弹出上传文件的窗口

            $("#uploader1 .webuploader-element-invisible").click();
        }
    });
    //当点到编辑内容上时，按钮要做的状态反射
    editor.addListener('selectionchange', function() {
        var state = editor.queryCommandState(uiName);
        if (state == -1) {
            uploadimg.setDisabled(true);
            uploadimg.setChecked(false);
        } else {
            uploadimg.setDisabled(false);
            uploadimg.setChecked(state);
        }
    });
    //因为你是添加button,所以需要返回这个button
    return uploadimg;
});
/*
*
*
*自定义富文本编辑器中的上传附件按钮
*
*
**/
UE.registerUI('uploadfiles', function(editor, uiName) {
    //注册按钮执行时的command命令，使用命令默认就会带有回退操作
    editor.registerCommand(uiName, {
        execCommand: function() {
            alert('execCommand:' + uiName)
        }
    });
    //创建一个button
    var uploadfiles = new UE.ui.Button({
        //按钮的名字
        name: "uploadfiles",
        //提示
        title: "附件上传",
        //添加额外样式，指定icon图标，这里默认使用一个重复的icon
        cssRules: 'background-position: -620px -40px;',
        //点击时执行的命令
        onclick: function() {
            //这里可以不用执行命令,做你自己的操作也可
            // editor.execCommand(uiName);
            $("#filePicker1 .webuploader-element-invisible").click();
        }
    });
    //当点到编辑内容上时，按钮要做的状态反射
    editor.addListener('selectionchange', function() {
        var state = editor.queryCommandState(uiName);
        if (state == -1) {
            uploadfiles.setDisabled(true);
            uploadfiles.setChecked(false);
        } else {
            uploadfiles.setDisabled(false);
            uploadfiles.setChecked(state);
        }
    });
    //因为你是添加button,所以需要返回这个button
    return uploadfiles;
});



/*
*
*
*ztree树配置
*
*
**/
var setting = {
    view: {
        showIcon: showIconForTree
    },
    data: {
        simpleData: {
            enable: true
        }
    },
    callback: {
        onClick: onClick
    }


};
var settingTwo = {
    view: {
        showIcon: showIconForTree
    },
    data: {
        simpleData: {
            enable: true
        }
    },
    callback: {
        onClick: onClickTwo
    }


};
function showIconForTree(treeId, treeNode) {//不显示节点图标
    return false;
};
function onClick(event, treeId, treeNode, clickFlag) {
    if(!treeNode.id){
        return false;
    };
    if(treeNode.children){
        return false;
    };
    for(var i in qudaoTypeArray){
        if(qudaoTypeArray[i].id==treeNode.id){
            return false;
        }
    };
    if(treeNode.name){
        var html='<span class="qudaoItem">'+treeNode.name+'<i class="fa fa-remove" onclick="removeQudaoItem(this,\''+treeNode.id+'\')"></i></span>';
        $("#qudaoContainerInput").append(html);
        var qudaoInfo={
            id:treeNode.id,
            channelType:treeNode.type,
            name:treeNode.name
        };
        qudaoTypeArray.push(qudaoInfo);
        isShowUe();
    };
};
function onClickTwo(event, treeId, treeNode, clickFlag) {
    if(!treeNode.id){
        return false;
    };
    var id = treeNode.id;
    ajaxHengyun({
        type:"get",
        dataType: 'json',
        url:  _GATE_URL+'/api/msgs/channelgroup/detail',
        data:{id:id},
        success:function(rows){
            if(rows.data){
                rows.data.forEach(function(val,index){
                    var qudaoInfo={
                        id:val.id,
                        channelType:val.type,
                        name:val.name
                    };
                    var ishove = false;
                    for(var i in qudaoTypeArray){
                        if(qudaoTypeArray[i].id==val.id){
                            ishove = true;
                        }
                    };
                    if(!ishove){
                        qudaoTypeArray.push(qudaoInfo);
                        var html='<span class="qudaoItem">'+val.name+'<i class="fa fa-remove" onclick="removeQudaoItem(this,\''+val.id+'\')"></i></span>';
                        $("#qudaoContainerInput").append(html);
                    }
                });
                isShowUe();
            }
        }
    });
    /*if(treeNode.name){
        var html='<span class="qudaoItem">'+treeNode.name+'<i class="fa fa-remove" onclick="removeQudaoItem(this,\''+treeNode.id+'\')"></i></span>';
        $("#qudaoContainerInput").append(html);
        var qudaoInfo={
            id:treeNode.id,
            channelType:treeNode.type,
            name:treeNode.name
    };
        qudaoTypeArray.push(qudaoInfo);
        isShowUe();
    };*/
};
/*var zNodes =[
    { id:1, name:"微信", type:"wx", open:true,
        children: [
            { id:11, name:"微信公众号1", type:"wx"},
            { id:12, name:"微信公众号2", type:"wx"},
            { id:13, name:"微信公众号3", type:"wx"},
        ]},
    { id:2, name:"微博", type:"wb",
        children: [
            { id:21, name:"官方微博1", type:"wb"},
            { id:22, name:"官方微博2", type:"wb"},
            { id:23, name:"官方微博3", type:"wb"},
        ]},
    { id:3, name:"公示平台", type:"gspt",
        children: [
            { id:31, name:"公示平台1", type:"gspt"},
            { id:32, name:"公示平台2", type:"gspt"},
            { id:33, name:"公示平台3", type:"gspt"},
        ]},
    { id:4, name:"移动终端", type:"ydzd",},

];
$.fn.zTree.init($("#treeDemo"), setting, zNodes);*/

/*
*
*
*删除渠道项
*
*
**/
function removeQudaoItem(ele,id){
    for(var i in qudaoTypeArray){
        if(qudaoTypeArray[i].id==id){
            $(ele).parent().remove();
            qudaoTypeArray.splice(i,1);
            isShowUe();
        }
    };
};

/*
*
*
*判断显示富文本还是纯文本
*
*
**/
function isShowUe(){
    loadFile();
    var isShowUe = true;
    if(qudaoTypeArray.length>0){
        for(var i in qudaoTypeArray){
            if(qudaoTypeArray[i].channelType=="2"){
                isShowUe=false;
            }
        };
        if(isShowUe){
            $("#myTextArea,#upFileBtn").addClass("hidden");
            $("#myEditor").removeClass("hidden");
            $("#myTextArea").val("");
            $("#showFile").html("");
            wbFileUrl = "";
        }else{
            $("#myEditor").addClass("hidden");
            ue.setContent("");
            $("#myTextArea,#upFileBtn").removeClass("hidden");
        }
    }else{
        $("#myTextArea,#upFileBtn").addClass("hidden");
        $("#myEditor").removeClass("hidden");
        $("#myTextArea").val("");
    };
}
/*
*
*
*获取渠道信息
*
*
**/
function channelTree(){
    ajaxHengyun({
        type:"get",
        dataType: 'json',
        url:  _GATE_URL+'/api/msgs/channel/tree',
        data:{},
        success:function(rows){
            if( rows.data.length<1){
                zNodes =[
                    { id:"", name:"暂无数据"},
                ];
                rows.data=zNodes;
            }else{
                for(var i in rows.data){
                    rows.data[i].open=true;
                };
            };
            $.fn.zTree.init($("#treeDemo"), setting, rows.data);
        }
    });
};
/*
*
*
*查询渠道信息
*
*
**/
function channelLike(){
    ajaxHengyun({
        type:"get",
        dataType: 'json',
        url:  _GATE_URL+'/api/msgs/channel/like',
        data:{name:$("#contactEdit").val()},
        success:function(rows){
            if(rows.data==null||rows.data.length<1){
                zNodes =[
                    { id:"", name:"暂无数据"},
                ];
                rows.data=zNodes;
            };
            $.fn.zTree.init($("#treeDemo"), setting, rows.data);
        }
    });
};
/*
*
*
*获取渠道群组信息
*
*
**/
function channelgroupAll(){
    ajaxHengyun({
        type:"get",
        dataType: 'json',
        url:  _GATE_URL+'/api/msgs/channelgroup/all',
        data:{name:null},
        success:function(rows){
            if(rows.data==null||rows.data.length<1){
                zNodes =[
                    { id:"", name:"暂无数据"},
                ];
                rows.data=zNodes;
            };
            $.fn.zTree.init($("#channelgroup"), settingTwo, rows.data);
        }
    });
};
/*
*
*
*查询渠道群组信息
*
*
**/
function channelgroupQuery(){
    ajaxHengyun({
        type:"post",
        dataType: 'json',
        url:  _GATE_URL+'/api/msgs/channelgroup/all',
        data:{name:$("#groupName").val()},
        success:function(rows){
            if(rows.data==null||rows.data.length<1){
                zNodes =[
                    { id:"", name:"暂无数据"},
                ];
                rows.data=zNodes;
            };
            $.fn.zTree.init($("#channelgroup"), settingTwo, rows.data);
        }
    });
};
/*
*
*
*定时发送
*
*
**/
function setTimeSave(){
    var errorArray=[];

    if(qudaoTypeArray.length==0){
        errorArray.push("发送渠道不能为空");
    };
    if(!$("#qudaoTitle").val()){
        errorArray.push("发送主题不能为空");
    };
    if(!$("#myTextArea").val() && !ue.getContent()){
        errorArray.push("消息内容不能为空");
    };
    if(errorArray.length>0){
        parent.layer.msg(errorArray.join(","),{time:3000});
        return false;
    };
    parent.layer.open({
        id: 'createFile',
        type: 2,
        anim: 6,
        title: '定时发送',
        maxmin: false, //开启最大化最小化按钮
        area: ['500px', '450px'],
        content: _cp+"/msgs/setTimeSave",
        btn: ['<span class="glyphicon glyphicon-ok"></span>确定并发送', '<span class="glyphicon glyphicon-backward"></span>取消'],
        yes: function (index, layero) {
            var html = layero.context;
            var Id = html.getElementById("createFile");
            var iframe = $(Id).find("iframe").attr("name");
            var rowData = parent[iframe].save(index);
        }
    });
};
/*
*
*
*保存方法
*
*
**/
function save(dataDto){
    ajaxHengyun({
        type:"post",
        dataType: 'json',
        contentType: 'application/json',
        url:  _GATE_URL+'/api/msgs/message/save',
        data:JSON.stringify(dataDto),
        success:function(rows){
            if(rows.data){
            	if(rows.errcode === 0){
	                parent.layer.msg("保存成功",{time:2000});
	                if(dataDto.draft=="0"){
	                    if(!dataDto.startTime){
	                    	$(".J_menuItem",parent.document).parent("li").removeClass("active");
	                    	$(".J_menuItem",parent.document).eq(3).parent("li").addClass("active");
	                        window.location.href=_cp+"/msgs/publishSucess";
	                    }else{
	                    	$(".J_menuItem",parent.document).parent("li").removeClass("active");
	                    	$(".J_menuItem",parent.document).eq(2).parent("li").addClass("active");
	                        window.location.href=_cp+"/msgs/drafts";
	                    }	
	                }
	                if(dataDto.draft=="1"){
                    	$(".J_menuItem",parent.document).parent("li").removeClass("active");
                    	$(".J_menuItem",parent.document).eq(2).parent("li").addClass("active");
	                    window.location.href=_cp+"/msgs/drafts";
	                }
            	}else{
            		parent.layer.msg(rows.data,{time:2000});
            	}
            }else{
                parent.layer.msg(rows.errmsg,{time:3000});
            }
        }
    });
};
/*
*
*
*获取保存数据
*
*
**/
function getFormData(draftVal,time){
    var dataDto={
        "channelIds": qudaoTypeArray,//渠道集合
        "draft": Number(draftVal),//发送状态，0发送，1存草稿
        "fileId": "",//信息文件id
        "fileUrl": "",//信息文件url
        "filePath": "",//微信封面图片地址
        "fileName": "",//信息文件名称
        "imgText": "",//消息内容
        "startTime": time,//定时发送时间
        "topic": $("#qudaoTitle").val()//信息的主题
    };
    //判断发送渠道中是否存在微信、微博
    var wbIsExist=false,wxIsExist=false;
    for(var i in qudaoTypeArray){
        if(qudaoTypeArray[i].channelType=="2"){
            wbIsExist=true;
        };
        if(qudaoTypeArray[i].channelType=="1"){
            wxIsExist=true;
        }
    };
    if(wbIsExist && !wxIsExist){//存在微博不存在微信的情况
        dataDto.fileId=wbFileId;
        dataDto.fileUrl=wbFileUrl;
        dataDto.fileName=wbFileName;
        dataDto.filePath="";
        dataDto.imgText=$("#myTextArea").val();
        if($("#myTextArea").val()!=null && $("#myTextArea").val().length>140){
        	parent.layer.msg("内容字数不应超过140字！",{time:3000});
        	return false;
        }
    }else if(wbIsExist && wxIsExist){//既存在微博也存在微信的情况
        var num = 64* 1024
        if(Number(wbFileSize)>num){
            var errorInfo = "选择的发送渠道中存在微信公众号，上传的图片将在微信中作为封面图片使用，图片大小不能超过64KB！";
            parent.layer.msg(errorInfo,{time:3000});
            return false;
        };
        dataDto.fileId=wbFileId;
        dataDto.fileUrl=wbFileUrl;
        dataDto.fileName=wbFileName;
        dataDto.filePath=wbFileUrl;
        dataDto.imgText=$("#myTextArea").val();
        if($("#myTextArea").val()!=null&&$("#myTextArea").val().length>140){
        	parent.layer.msg("内容字数不应超过140字！",{time:3000});
        	return false;
        }
    }else if(!wbIsExist && wxIsExist){//不存在微博存在微信的情况
        dataDto.fileUrl="";
        dataDto.imgText=ue.getContent();
        $("#ueHtml").html(dataDto.imgText);
        var wxImg = $("#ueHtml img");
        if(wxImg && wxImg.length>0){
            var wxImgFilePath = $(wxImg[0]).attr("src");
            var wxImgSize = "";
            for(var j in wxfileArray){
                if(wxfileArray[j].url==wxImgFilePath){
                    wxImgSize=wxfileArray[j].size;
                }
            }
            var num = 64* 1024;
            if(Number(wxImgSize)>num){
                var errorInfo = "选择的发送渠道中存在微信公众号，富文本编辑器中的第一张图片将在微信中作为封面图片使用，因此第一张图片大小不能超过64KB！";
                parent.layer.msg(errorInfo,{time:5000});
                return false;
            }else{
                dataDto.filePath=wxImgFilePath;
            };
        };
    }else{//既不存在微博也不存在微信的情况
    	dataDto.imgText=ue.getContent();
    	$("#ueHtml").html(dataDto.imgText);
    	var wxImg = $("#ueHtml img");
    	var imgFilePath = $(wxImg[0]).attr("src");
        dataDto.fileUrl="";
        dataDto.filePath=imgFilePath;
        dataDto.fileName="";        
    };
    dataDto.channelIds=qudaoTypeArray;
    if(draftVal=="0"){
        var errorArray=[];
        if(dataDto.channelIds.length==0){
            errorArray.push("发送渠道不能为空");
        };
        if(!dataDto.topic){
            errorArray.push("发送主题不能为空");
        };
        if(!dataDto.imgText){
            errorArray.push("消息内容不能为空");
        };
        if(errorArray.length>0){
            parent.layer.msg(errorArray.join(","),{time:3000});
            return false;
        };
    }
    save(dataDto);
};


$(function(){
    isShowUe();
    channelTree();
    channelgroupAll();
    $('.title_first',parent.document).text("消息发布");
    $(".title_second",parent.document).text("新建发布");
});