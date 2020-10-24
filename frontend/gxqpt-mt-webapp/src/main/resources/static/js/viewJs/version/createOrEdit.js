$(function () {
    var dict = angular.module('dict', []);
    dict.controller('controller', function ($scope,$http,token) {
        var urlPrev ='${_gate_url}';
        $scope.save = function () {
            doSubmit();
        }
    }).service('token',function () {
        this.token = function () {
            return getToken();
        }
    });
    var fileUploadAddress=_GATE_URL+"/api/file";

    var apkInfo = {
        apkFileId: '',
        apkFileName: '',
        apkFilePath: '',
        apkFileSize: ''
    };

    // 获取id，如果不为null,意味着来自编辑而不是新增
    var id = getQueryString('id');
    // 获取url里面的指定参数
    function getQueryString(query) {
        var reg = new RegExp("(^|&)"+ query +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return  unescape(r[2]); return null;
    }

    // 初始化文件上传和富文本框编辑器
    var ue;
    function initFileUploadAndEdit() {
        /* 附件上传 begin */
        var token = $.cookie("_token");
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
                    var url = json.data.list[0].url;
                    UE.getEditor('editor').focus();
                    UE.getEditor('editor').execCommand('inserthtml','<img src="'+url+'"/>');
                }
            });
            // 文件
            fileUpload3 = new FileUpload({
                "filePicker" : "filePicker3",
                "dndArea" : "dndArea3",
                "uploader" : "uploader3",
                "jxButton" : "jxButton3",
                "folderId": folderId,
                "dataType": dataType,
                "token": token,
                "_isAdmin": true,
                accept: {
                    title: 'Apk',
                    extensions: 'apk',
                    mimeTypes: 'application/vnd.android.package-archive'
                },
                successUpload: function (json, file) {
                    if (!json.data) {
                        return;
                    }
                    var serveFile = json.data.list[0];
                    $('#fileName').text(serveFile.submittedFileName);
                    apkInfo.apkFileId = serveFile.id;
                    apkInfo.apkFileName = serveFile.submittedFileName;
                    apkInfo.apkFilePath = serveFile.url;
                    apkInfo.apkFileSize = file.file.size;
                }
            });
        };
        /* 附件上传 end */

        /* 富文本编辑器 begin */
        var pageType="provide";
        ue = UE.getEditor('editor', {
            initialFrameHeight: 300
        });
        // UE.registerUI('uploadimg', function(editor, uiName) {
        //     //注册按钮执行时的command命令，使用命令默认就会带有回退操作
        //     editor.registerCommand(uiName, {
        //         execCommand: function() {
        //             alert('execCommand:' + uiName)
        //         }
        //     });
        //     //创建一个button
        //     var uploadimg = new UE.ui.Button({
        //         //按钮的名字
        //         name: "uploadimg",
        //         //提示
        //         title: "图片上传",
        //         //添加额外样式，指定icon图标，这里默认使用一个重复的icon
        //         cssRules: 'background-position: -380px 0px;',
        //         //点击时执行的命令
        //         onclick: function() {
        //             //这里可以不用执行命令,做你自己的操作也可
        //             // editor.execCommand(uiName);
        //             $("#filePicker2 .webuploader-element-invisible").click();
        //         }
        //     });
        //     //当点到编辑内容上时，按钮要做的状态反射
        //     editor.addListener('selectionchange', function() {
        //         var state = editor.queryCommandState(uiName);
        //         if (state == -1) {
        //             uploadimg.setDisabled(true);
        //             uploadimg.setChecked(false);
        //         } else {
        //             uploadimg.setDisabled(false);
        //             uploadimg.setChecked(state);
        //         }
        //     });
        //     //因为你是添加button,所以需要返回这个button
        //     return uploadimg;
        // });
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

    // 提交保存或者更新
    function doSubmit() {
        if (!apkInfo.apkFileSize) {
            layer.msg('请选择文件', {time: 2000});
            return;
        } else if (apkInfo.apkFileName.length > 30) {
            layer.msg('文件名最长30个字符，请修改重试', {time: 3000});
            return;
        }
        var data = {
            verName: $('input[name="verName"]').val(),
            verNumber: parseInt($('input[name="verNumber"]').val()),
            pwUpdate: $('input[name="pwUpdate"]:checked').val(),
            updateContent: UE.getEditor('editor').getContent(),
            apkFileId: apkInfo.apkFileId,
            apkFileName: apkInfo.apkFileName,
            apkFilePath: apkInfo.apkFilePath,
            apkFileSize: parseInt(apkInfo.apkFileSize),
        };
        // 修改
        if (id) {
            data.id = id;
        }

        ajaxHengyun({
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json',
            url: _GATE_URL + '/api/mt/clientVersion/createVersion',
            success:function (res) {
                if (res.errcode == 0) {
                    window.location.href = 'versionList';
                    return
                }
                layer.msg(res.errmsg, {time: 2000});
            },
            error: function(err) {
                console.log(err);
            }
        });
    }

    function bindEvent() {
        // 取消
        $("#quit").on("click", function(){
            window.location.href="versionList";
        });

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

    function initRender() {
        // 编辑
        if (id) {
            ajaxHengyun({
                type:'POST',
                data: {
                    id: id
                },
                url: _GATE_URL + '/api/mt/clientVersion/getBaseInfo',
                success: function (res) {
                    var data = res.data;
                    $('input[name="verName"]').val(data.verName);
                    $('input[name="verNumber"]').val(data.verNumber);
                    $('input[value="'+data.pwUpdate+'"]').prop('checked', true);
                    apkInfo.apkFileId = data.apkFileId;
                    apkInfo.apkFileSize = data.apkFileSize;
                    apkInfo.apkFileName = data.apkFileName;
                    apkInfo.apkFilePath = data.apkFilePath;
                    $('#fileName').text(apkInfo.apkFileName);
                    var ue = UE.getEditor('editor');
                    ue.ready(function () {
                        ue.setContent(data.updateContent);
                        if(data.updateContent){
                            $("#appExplain > input").val("1");
                        };
                    });
                },
                error: function(err) {
                    console.log(err);
                }
            });
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
        initRender();
        initFileUploadAndEdit();
        bindEvent();
    }

    init();
});
