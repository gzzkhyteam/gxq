/* 附件上传 begin */
var token = getToken();
var folderId="-1";
var dataType="";
loadFile();
function loadFile() {

    fileUpload1 = new FileUploadImg({
        "filePicker" : "filePicker2",
        "dndArea" : "dndArea2",
        "uploader" : "uploader2",
        "jxButton" : "jxButton2",
        "folderId":folderId,
        "dataType":dataType,
        "token":token,
        "_isAdmin":true
    });
    fileUpload3 = new FileUploadFirst({
        "filePicker" : "filePicker3",
        "dndArea" : "dndArea3",
        "uploader" : "uploader3",
        "jxButton" : "jxButton3",
        "folderId":folderId,
        "dataType":dataType,
        "token":token,
        "_isAdmin":true
    });
    fileUpload2 = new FileUpload({
        "filePicker" : "filePicker1",
        "dndArea" : "dndArea1",
        "uploader" : "uploader1",
        "jxButton" : "jxButton1",
        "folderId":folderId,
        "dataType":dataType,
        "token":token,
        "_isAdmin":true
    });
};
/* 附件上传 end */

/* 富文本编辑器 begin */
var pageType="provide";
var ue = UE.getEditor('editor', {
    initialFrameHeight: 300
});
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
            // editor.execCommand(uiName);

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

function successUpload(json) {
    var url = json.data.list[0].url;
    UE.getEditor('editor').focus();
    UE.getEditor('editor').execCommand('inserthtml','<img src="'+url+'"/>');
};
function successUploadFile(json) {
    var url = json.data.list[0].url;
    var name = json.data.list[0].submittedFileName;
    var urlDownload = _GATE_URL+"/api/file/file/download?url=" + url + "&filename=" + name;
    html='<a href="'+urlDownload+'">'+name+'</a>';
    $("#testcon").html(html);
    window.setTimeout(function(){
        UE.getEditor('editor').focus();
        UE.getEditor('editor').execCommand('inserthtml',$('#testcon').html());
    },1000);
};
function successUploadFileFirst(json) {
    $(".iconPathStyle").removeClass("hidden");
    $(".iconPathStyle").attr("src",json.data.list[0].url);
    $("input[name='iconPath']").val(json.data.list[0].url);
};

function getToken() {
    return $.cookie("_token");
}