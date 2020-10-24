$(function () {
    var userIdInfo=$.cookie('_user_id');
    var userNameInfo=$.cookie('_user_name');
    var userIdString = "";

	// 获取id然后根据id进行查询,某天的详情
    var id = getQueryString('id');
    // 获取日志id查询详情，某天日志的详情。如果存在，即来自我收到的日志
    var logId = getQueryString('logId');

    // 获取url里面的指定参数
    function getQueryString(query) {
        var reg = new RegExp("(^|&)"+ query +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return  unescape(r[2]); return null;
    }

    // 获取某天的详情
	function getDayDetails() {
		ajaxHengyun({
           	url: _GATE_URL + "/api/mt/work/get",
            type: 'GET',
            data: {
            	id: id || logId
            },
            success: function (res) {
                userIdString = res.data.userId;
                getAuthorityList();
                var details = res.data.workLogDetailDTOS;
                var desc = [];
                var files = [];
                $.each(details, function(idx, detail) {
                    desc.push('<li>'+detail.description+'</li>');
                    var fileList = detail.workLogFileDTOS;
                    $.each(fileList, function(i, file){
                        var fileType = file.fileType.toLowerCase();
                        if (fileType.indexOf('image') > -1) {
                            files.push('<li class="pull-left">\
                                            <p class="imgWrap">\
                                                <a href="'+file.fileUrl+'" target="_blank">\
                                                    <img class="img-responsive img-thumbnail" src="'+file.fileUrl+'">\
                                                </a>\
                                            </p>\
                                        </li>');
                        } else {
                            files.push('<li class="pull-left">\
                                            <p>'+file.fileName+'</p>\
                                            <div class="file-panel">\
                                                <a href="'+file.fileUrl+'" target="_blank" class="downFile">下载附件</a>\
                                            </div>\
                                        </li>');
                        }
                    });
                });
                $('#desc').html(desc.join(''));
                if (files.length > 0) {
                    $('.filelist').html(files.join(''));
                } else {
                    $('.filelist').html('无附件');
                };

            },
            error: function(err) {
                console.log(err);
            }
        });
	}

    //日志回复
    function saveData() {
        var saveDTO={
            workLogId: logId,
            userId: userIdInfo,
            content: $("#content").val()
        };
        ajaxHengyun({
            url:  _GATE_URL+"/api/mt/work/saveAnswer",
            type: 'post',
            contentType: 'application/json', //设置请求头信息
            data: JSON.stringify(saveDTO),
            dataType: "json",
            success: function (data) {
                if (data.errmsg == 'ok') {
                    $("#content").val("");
                    getAnswerList();
                } else {
                    parent.layer.msg(data.errmsg);
                }
            },
        });
    };
    //获取回复信息
    function getAnswerList(){
        ajaxHengyun({
            url: _GATE_URL + "/api/mt/work/getAnswerList",
            type: 'GET',
            data: {
                workLogId: logId
            },
            success: function (res) {
                var replyHtml = [];
                var replys = res.data;
                for (var i = 0; i < replys.length; i++) {
                    var reply = replys[i];
                    replyHtml.push('<div class="reply">\
                        <label>'+reply.createUser+'  '+reply.createTime+'  回复：</label>\
                        <p>'+reply.content+'</p>\
                    </div>');
                }
                if (replys.length == 0) {
                    replyHtml.push('<p class="no-reply">暂无回复</p>');
                }
                $('#reply-container').html(replyHtml.join(''));
            },
            error: function(err) {
                console.log(err);
            }
        });
    }

    //获取可看人信息
    function getAuthorityList() {
        parent.getUnitIdFromTopWindow(function (unitId) {
            if (!unitId) {
                console.log('获取单位id失败');
                return;
            }
            ajaxHengyun({
                type:"GET",
                dataType: 'json',
                url:  _GATE_URL+"/api/mt/work/getAuthorityList",
                data: {
                    userId: userIdString,
                    unitId: unitId
                },
                success:function(rows){
                    if (rows.data){
                        var array = rows.data;
                        var idsArray = [],namesArray = [];
                        for(var i in array){
                            idsArray.push(array[i].userId);
                            namesArray.push(array[i].name);
                        };
                        userIds=idsArray;
                        var nameString = namesArray.join(",");
                        $("#csPerson").text(nameString);
                    };
                }
            });
        });
    };

    function bindEvent() {
        $("body").on("click",".btn-back",function(){
            window.location.href=_cp+'/module/myworklog?userId=' + userIdInfo +"&userName="+userNameInfo;;
        });

        // 提交回复
        $('#saveOk').valid({
            form: '#reply-content',
            showAllError: true,
            checkpassed: saveData
        });
    }

    function init() {
        // 查询日志的回复
        if (logId) {
            $('.none').show();
            bindEvent();
            getAnswerList();
        }
        getDayDetails();
    }

    init();
});