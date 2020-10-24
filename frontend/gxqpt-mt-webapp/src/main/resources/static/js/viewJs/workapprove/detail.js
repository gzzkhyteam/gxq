$(function () {
    // 是否是处理
    var isHandle = getQuery('deal');
    var id = getQuery('id');
    var isSend = getQuery('isSend');
    // var cancelForm = '';

    //当前用户用户名
    var userId = $.cookie('_user_id');

    // 获取查询参数
    function getQuery (name) {
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return  unescape(r[2]); return null;  
    }

    function renderDetail(detail) {
        // 审批类型字典
        var checkType = {
            overtime: '加班',
            leave: '请假',
            business: '出差',
            outside: '外勤',
            supply: '补签'
        };

        // 审批类型的名称
        var currentTypeName = detail.applyId ? '撤销' + checkType[detail.aprType] : checkType[detail.aprType];

        // 撤销原因
        var cancelReasonHtml = '';
        if (detail.canceReasonl) {
            cancelReasonHtml = '<div class="card-item">\
                                    <div class="left-container">撤销理由：</div>' + detail.canceReasonl + '\
                                </div>'
        }

        // 日期
        var date = '';
        // 补签
        if (detail.aprType === 'supply') {
            date = '<div class="right-container">' + detail.date;
        } else {
            date = '<div class="right-container">' + detail.startTime + ' 至 ' + detail.endTime + '</div>';
        }

        // 补签、请假、出差类型
        var businessType = detail.businessType ? (detail.businessType == 'official' ? '公务出差' : '外出培训') : '';
        var leaveTypes = {
            leave: '事假',
            sick: '病假',
            year: '年假',
            relatives: '探亲假',
            marriage: '婚假',
            maternity: '产假',
            funeral: '丧假'
        }
        var leaveType = detail.leaveType ? leaveTypes[detail.leaveType] : '';
        var supplyType = detail.supplyType ? ['', '签到', '签退'][detail.supplyType] : '';
        var typeHtml = '';
        if (businessType || leaveType || supplyType) {
            typeHtml = '<div class="card-item">\
                            <div class="left-container">' + currentTypeName + '类型：</div>\
                            <div class="right-container">' + (businessType || leaveType || supplyType) + '</div>\
                        </div>';
        }

        // 抄送范围
        var sendPerson = [];
        for (var i = 0; i < detail.sendPersons.length; i++) {
            sendPerson.push(detail.sendPersons[i].apprUserName);
        }

        // 附件列表
        var filelist = [];
        if (detail.files && detail.files.length > 0) {
            filelist.push('<div class="file-container">');
            for (var i = 0; i < detail.files.length; i++) {
                var file = detail.files[i];
                if (file.fileType.indexOf('image') > -1) {
                    filelist.push('<a href="'+file.fileUrl+'" target="_blank"><img class="file" src="' + file.fileUrl + '" /></a>');
                } else {
                    filelist.push('<div class="file"><a title="'+file.fileName+'" href="/api/file/file/download?url=' + file.fileUrl + '&filename=' + file.fileName + '" target="_blank">' + file.fileName + '</a></div>');
                }
            }
            filelist.push('</div>');
        } else {
            filelist.push('无附件');
        }

        // 审批记录
        var records = [];
        if (detail.applyRecodes) {
            var agreeType = ['通过', '驳回'];
            for (var i = 0; i < detail.applyRecodes.length; i++) {
                var record = detail.applyRecodes[i];
                records.push('<tr>');
                records.push('<td>' + (record.apprUserName || '--') + '</td>');
                records.push('<td>' + (record.apprTime || '--') + '</td>');
                records.push('<td>' + (agreeType[record.agree] || '--') + '</td>');
                records.push('<td>' + (record.apprOpinion || '--') + '</td>');
                records.push('</tr>');
            }
        }

        var html = '<div class="card-item">\
                <div class="left-container">审批类型：</div>\
                <div class="right-container">' + currentTypeName + '</div>\
            </div>\
            <div class="card-item">\
                <div class="left-container">申请人：</div>\
                <div class="right-container">' + detail.applyName + '</div>\
            </div>\
            <div class="card-item">\
                <div class="left-container">申请时间：</div>\
                <div class="right-container">' + detail.createTime + '</div>\
            </div>'+typeHtml+'\
            <div class="card-item">\
                <div class="left-container">' + currentTypeName + '日期：</div>' + date + '\
            </div>'+cancelReasonHtml+'\
            <div class="card-item">\
                <div class="left-container">' + currentTypeName + '内容：</div>\
                <div class="right-container">' + detail.content + '</div>\
            </div>\
            <div class="card-item">\
                <div class="left-container">抄送范围：</div>\
                <div class="right-container">' + sendPerson.join(',') + '</div>\
            </div>\
            <div class="card-item">\
                <div class="left-container">附件资料：</div>\
                <div class="right-container">' + filelist.join('') + '</div>\
            </div>\
            <div class="card-item">\
                <div class="left-container">审核记录：</div>\
                <div class="right-container">\
                    <table class="table table-striped table-bordered table-hover">\
                        <thead>\
                            <th>审核人</th>\
                            <th>审核时间</th>\
                            <th>审核状态</th>\
                            <th>审核意见</th>\
                        </thead>\
                        <tbody>' + records.join('') + '</tbody>\
                    </table>\
                </div>\
            </div>';
        $('.card').prepend(html);
    }

    // 获取详情
    function getDetail() {
        ajaxHengyun({
            type: "GET",
            dataType: 'json',
            url:  _GATE_URL+"/api/mt/apprApply/getApprApplyInfo",
            data: {
                id: id,
                HyTimestamp: Date.now()
            },
            success: function(result) {
                var data = result.data;
                // 查看的是自己的考勤、不是撤销的记录、状态是审批中或者已结束
                if (data && data.applyUserId == userId && !data.applyId && (data.curState == 1 || data.curState == 3)) {
                    $('#quit').show();
                    $('#detail').show();
                } else {
                    $('#audit').show();
                }
                renderDetail(data);
            }
        });
    }

    // 处理审批请求
    function handleCheck() {
        var data = {
            id: id,
            agree: $('input[name=result]:checked').val(),
            apprOpinion: $('#apprOpinion').val()
        };
        ajaxHengyun({
            type: "GET",
            dataType: 'json',
            url:  _GATE_URL+"/api/mt/apprApply/dealApprApply",
            data: data,
            success: function(res){
                if (res.errcode == 0) {
                    window.location.href = 'detail?isSend='+isSend+'&id=' + id;
                } else {
                    layer.msg(res.errmsg, {time: 1000});
                }
            }
        });
    }

    // 撤销审批
    function cancellApprApply() {
        layer.confirm('<form id="cancelReason">\
                <p>确定撤销吗？撤销需要再次审批</p>\
                <div class="form-group" style="margin: 0;">\
                    <label class="control-label w84" >\
                        <span class="text-danger">*</span>\
                        <span>撤销理由</span>\
                        <span>：</span>\
                    </label>\
                    <div class="form-control-wrap">\
                        <input\
                            class="form-control Wdate"\
                            style="width: 205px;"\
                            name="canceReasonl"\
                            type="textarea"/>\
                            <span id="error" class="text-danger" style="display: none;">请填写撤销理由</span>\
                    </div>\
                </div>\
            </form>', {
            btn: ['提交', '取消'],
            shade: [0.4,'#000'],
            title: '撤销确认'
        }, function (index) {
            // 初始化校验撤销理由
            var reason = $('input[name="canceReasonl"]').val();
            if (!reason) {
                $('#error').show();
                return;
            }
            // cancelForm = $('#cancelReason').Validform();
            // var isOk = cancelForm.check(false);
            // debugger
            // return;
            ajaxHengyun({
                type: "POST",
                dataType: 'json',
                contentType: 'application/json',
                url:  _GATE_URL+"/api/mt/apprApply/cancellApprApply",
                data: JSON.stringify({
                    id: id,
                    canceReasonl: $('input[name="canceReasonl"]').val()
                }),
                success: function(result) {
                    parent.layer.closeAll();
                    window.location.href = "list";
                }
            });
        });
    }

    // 事件绑定
    function bindEvent() {
        // 如果是办理
        if (isHandle) {
            $('#handleResult').show();
            $('#handleContent').show();
            $('#submit').show();
        }

        // 审批确定
        $('#submit').valid({
            form: '#checkForm',
            showAllError: true,
            checkpassed: handleCheck
        });

        // 返回
        $('.btn-back').on('click', function () {
            window.location.href = 'list?isSend='+isSend;
        });

        // 撤销
        $('#quit').on('click', function () {
            cancellApprApply();
        });
    }

    bindEvent();
    getDetail();
});
