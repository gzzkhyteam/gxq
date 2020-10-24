$(function () {
    var dict = angular.module('dict', []);
    dict.controller('controller', function ($scope,$http,token) {
        var urlPrev ='${_gate_url}';
        $scope.submit = function () {
            $('.btn-submit').click();
        };
        $scope.save = function () {
            doSubmit();
        }
    }).service('token',function () {
        this.token = function () {
            return getTokenVal();
        }
    });
    var ue;
    // 获取id，如果不为null,意味着来自编辑而不是新增
    var id = getQueryString('id');
    // 获取isDetail，如果不为null,意味着来自查看
    var isDetail = getQueryString('isDetail');
    // 获取模块是否成功
    var getModuleSuccess = false;
    // 获取url里面的指定参数
    function getQueryString(query) {
        var reg = new RegExp("(^|&)"+ query +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return  unescape(r[2]); return null;
    }

    // 初始化文件上传和富文本框编辑器
    function initFileUploadAndEdit() {
        /* 附件上传 begin */
        var token = getTokenVal();
        var folderId="-1";
        var dataType="";
        loadFile();
        function loadFile() {
            // 超链接
            fileUpload1 = new FileUpload({
                "filePicker" : "filePicker1",
                "dndArea" : "dndArea1",
                "uploader" : "uploader1",
                "jxButton" : "jxButton1",
                "folderId": folderId,
                "dataType": dataType,
                "token": token,
                "_isAdmin": true,
                successUpload: function (json) {
                    if(json.errcode!==0){
                        parent.layer.msg(json.errmsg+"，请重试！",{time:3000});
                        return false;
                    };
                    var url = json.data.list[0].url;
                    var name = json.data.list[0].submittedFileName;
                    var urlDownload = _GATE_URL + "/api/file/file/download?url=" + url + "&filename=" + name;
                    $('#temp').html('<a href="'+urlDownload+'" target="_blank">'+name+'</a>');
                    window.setTimeout(function(){
                        UE.getEditor('editor').focus();
                        UE.getEditor('editor').execCommand('inserthtml',$('#temp').html());
                    }, 500);
                }
            });

            // 富文本图片上传
            fileUpload2 = new FileUpload({
                "filePicker" : "filePicker2",
                "dndArea" : "dndArea2",
                "uploader" : "uploader2",
                "jxButton" : "jxButton2",
                "folderId": folderId,
                "dataType": dataType,
                "token": token,
                "_isAdmin": true,
                accept: {
                    title: 'Images',
                    extensions: 'gif,jpg,jpeg,bmp,png',
                    mimeTypes: 'image/*'
                },
                successUpload: function (json) {
                    if(json.errcode!==0){
                        parent.layer.msg(json.errmsg+"，请重试！",{time:3000});
                        return false;
                    };
                    var url = json.data.list[0].url;
                    UE.getEditor('editor').focus();
                    UE.getEditor('editor').execCommand('inserthtml','<img src="'+url+'"/>');
                }
            });
        };
        /* 附件上传 end */

        /* 富文本编辑器 begin */
        var pageType="provide";
        ue = UE.getEditor('editor', {
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

                    $("#filePicker2 .webuploader-element-invisible").click();
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
        ue.addListener('blur',savecontent);
    }

    // 获取所有模块名称和id
    function getAllModules() {
        ajaxHengyun({
            type: 'POST',
            data: JSON.stringify({}),
            contentType: 'application/json',
            url: _GATE_URL + '/api/mt/appmanager/findAllApp',
            success:function (res) {
                var html = [];
                if (res.data && res.data.length > 0) {
                    for (var i = 0; i < res.data.length; i++) {
                        var id = res.data[i].id;
                        var name = res.data[i].appName;
                        html.push('<option value="'+id+'">'+name+'</option>');
                    }
                }
                $('#moduleName').html(html.join(''));
                getModuleSuccess = true;
            },
            error: function(err) {
                console.log(err);
            }
        });
    }

    // 提交保存
    function doSubmit() {
        var data = {
            // auditorTime: $('#auditorTime').val(),
            content: UE.getEditor('editor').getContent(),
            title: $('#title').val(),
            commonlyMark: $('#commonlyMark').val(),
            modularId: $('#moduleName').val()
        };
        // 新增
        var url = _GATE_URL + '/api/mt/help/save';
        if (id) {
            data.id = id;
            url = _GATE_URL + '/api/mt/help/update';
        }
        var appElement = document.querySelector('[ng-controller=controller]');
        var $scope = angular.element(appElement).scope();
        ajaxHengyun({
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json',
            url: url,
            success:function (res) {
                window.location.href = 'helpList'
            },
            error: function(err) {
                console.log(err);
            }
        });
    }

    function bindEvent() {
        // 提交验证
        $('#submit').valid({
            form: '#addForm',
            ignoreHidden: true,
            showAllError: true,
            checkpassed: function () {
                var appElement = document.querySelector('[ng-controller=controller]');
                var $scope = angular.element(appElement).scope();
                $scope.save();
            }
        });
    }

    // 初始化渲染
    function initRender() {
        // 编辑
        if (id) {
            ajaxHengyun({
                type:'GET',
                data: {
                    id: id
                },
                url: _GATE_URL + '/api/mt/help/get',
                success: function (res) {
                    var ue = UE.getEditor('editor');
                    ue.ready(function () {
                        ue.setContent(res.data.content);
                        if(res.data.content){
                            $("#appExplain > input").val("1");
                        };
                    });
                    // $('#auditorTime').val(res.data.auditorTime);
                    $('#title').val(res.data.title);
                    $("#commonlyMark").val(res.data.commonlyMark);
                    var timeInterval = setInterval(function () {
                        if (getModuleSuccess) {
                            $("#moduleName").val(res.data.modularId);
                            clearInterval(timeInterval)
                        }
                    }, 500);
                    if (isDetail) {
                        $('#title').prop('disabled', 'disabled');
                        $('#commonlyMark').prop('disabled', 'disabled');
                        $('#moduleName').prop('disabled', 'disabled');
                        $('#submit').hide();
                        $('#addForm .btn-default').text('返回');
                        $('#appDetail').show();
                        $('#appDetail div').html(res.data.content);
                        // ue.setDisabled();
                        $('.page-title-scend').text('帮助详情');
                    } else {
                        $('#appExplain').show();
                        $('.page-title-scend').text('帮助修改');
                    }
                },
                error: function(err) {
                    console.log(err);
                }
            });
        } else {
            $('#appExplain').show();
        }
    }
    function savecontent(){
        if(ue.getContent()){
            $("#appExplain > input").val("1");
        }else{
            $("#appExplain > input").val("");
        }
        $("#appExplain > input").blur();
    };

    function init() {
        getAllModules();
        initFileUploadAndEdit();
        initRender();
        bindEvent();
    }

    init();
});

// 图片上传成功之后的回调
function successUpload(json) {
    var url = json.data.list[0].url;
    UE.getEditor('editor').focus();
    UE.getEditor('editor').execCommand('inserthtml','<img src="'+url+'"/>');
};
// 超链接添加文件或者图片成功之后的回调
function successUploadFile(json) {
    var url = json.data.list[0].url;
    var name = json.data.list[0].submittedFileName;
    var urlDownload = "${_gate_url}/api/file/file/download?url=" + url + "&filename=" + name;
    html='<a href="'+urlDownload+'">'+name+'</a>';
    $("#testcon").html(html);
    window.setTimeout(function(){
        UE.getEditor('editor').focus();
        UE.getEditor('editor').execCommand('inserthtml',$('#testcon').html());
    },1000);
};
function successUploadFileFirst(json) {
};

function getTokenVal() {
    return $.cookie("_token");
}