$(function () {
    var emergencyStatus = ['--','普通','紧急','非常紧急'];
    var dealStatus = ['--','未处理','已处理','已关闭'];
	// 获取id，如果不为null,意味着来自处理而不是查看
    var id = getQueryString('id');
    var close = getQueryString('close');
    // 获取url里面的指定参数
    function getQueryString(query) {
        var reg = new RegExp("(^|&)"+ query +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return  unescape(r[2]); return null;
    }
    var ue="";
    // 初始化文件上传和富文本框编辑器
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
                accept: {
                    title: 'Images',
                    extensions: 'gif,jpg,jpeg,bmp,png',
                    mimeTypes: 'image/*'
                },
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
                successUpload: function (json) {
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
    }

    function getDetails() {
    	ajaxHengyun({
            type: 'POST',
            data: {
            	id: id,
                isWeb: true
            },
            url: _GATE_URL + '/api/mt/feedback/getFeedBackInfo',
            success:function (res) {
                var detail = res.data;
                var imageHtml = [];
                for (var i = 0; i < detail.imageList.length; i++) {
                    var url = detail.imageList[i].fileUrl;
                    imageHtml.push('<a href="'+url+'" target="_blank"><img src="'+url+'"></a>');
                }
                var html = '<col width="120"/></col>\
                    <col width="100"/></col>\
                    <tr>\
                        <th>标题</th>\
                        <td colspan="3">'+detail.fbTitle+'</td>\
                    </tr>\
                    <tr>\
                        <th>反馈人</th>\
                        <td>'+detail.createUserName+'</td>\
                        <th>紧急程度</th>\
                        <td>'+emergencyStatus[detail.fbEmergency||0]+'</td>\
                    </tr>\
                    <tr>\
                        <th>处理状态</th>\
                        <td>'+dealStatus[detail.fbState]+'</td>\
                        <th>登记日期</th>\
                        <td>'+detail.createTime+'</td>\
                    </tr>\
                    <tr>\
                        <th>关闭人</th>\
                        <td>'+(detail.fbCloseName||'--')+'</td>\
                        <th>关闭时间</th>\
                        <td>'+(detail.fbCloseTime||'--')+'</td>\
                    </tr>\
                    <tr>\
                        <th>反馈内容</th>\
                        <td colspan="3">'+detail.fbContent+'</td>\
                    </tr>\
                    <tr>\
                        <th>图片</th>\
                        <td colspan="3" id="images">'+imageHtml.join('')+'</td>\
                    </tr>';
                var replyHtml = [];
                var replys = detail.msgList;
                for (var i = 0; i < replys.length; i++) {
                    var reply = replys[i];
                    replyHtml.push('<div class="reply">\
                        <label>'+reply.createUserName+' '+reply.createTime+' 回复：</label>\
                        '+reply.msgContent+'\
                    </div>');
                }
                if (replys.length == 0) {
                    replyHtml.push('<p class="no-reply">暂无回复</p>');
                }
                $('#detail').html(html);
                $('#reply-container').html(replyHtml.join(''));
            },
            error: function(err) {
                console.log(err);
            }
        });
    }

	// 回复
	function doReply() {
		var data = {
            isWeb: true,
            id: id,
            context: UE.getEditor('editor').getContent()
        };
        if (data.context == '') {
            layer.msg('回复内容不能为空', {time:2000});
            return;
        }
        ajaxHengyun({
            type: 'POST',
            data: data,
            url: _GATE_URL + '/api/mt/feedback/replyFeedback',
            success:function (res) {
                layer.msg('回复成功', {time:1000});
                setTimeout(function(){
                    getDetails();
                    ue.execCommand('cleardoc');
                },500);
            },
            error: function(err) {
                console.log(err);
            }
        });
	}

	// 事件绑定
    function bindEvent() {
    	// 返回
    	$("body").on("click",".btn-back",function(){
	        window.location.href=_cp+"/module/feedbackList";
	    });

    	// 提交回复
	    $('.btn-submit').on('click', function(){
	    	doReply();
	    });
    }

    bindEvent();
    getDetails();
    if (!close) {
        initFileUploadAndEdit();
    } else {
        $('.replyEdit').remove();
        $('.btn-submit').remove();
    }
});
