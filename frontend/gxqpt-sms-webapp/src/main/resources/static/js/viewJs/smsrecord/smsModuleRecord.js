$(function () {
	init();
	function init() {
        bindEvent();
        initList();
    }
    // 更新列表
    function updateList (pageNo, pageSize) {
        var startTime = $('#startTime').val();
        var endTime = $('#endTime').val();
        var postData = {
            data: {
                // 应用名称
            	appName: $('#appName').val(),
                // 发送人名称
            	senderName: $('#senderName').val(),
                // 发送主题
            	topic: $('#topic').val(),
                // 接收人手机号
            	phone: $('#phone').val(),
            	// 短信类型 
            	sourceType : 'MODULAR',
            	startTime : startTime + (startTime==''?'':' 00:00:00'),
            	endTime : endTime + (endTime==''?'':' 00:00:00')
            },
            pageNo: pageNo || $(".ui-pg-input").val() || 0,
            pageSize: pageSize || $(".ui-pg-selbox").val() || 20
        }
        $('#list').setGridParam({
            postData:postData
        },true).trigger('reloadGrid');
    }

    // 初始化表格
    function initList () {
        //表格列表初始化
        $("#list").jqGrid({
            mtype: 'POST',
            postData:{ pageNo:1, pageSize:20, data: {
            	sourceType : 'MODULAR'
            }},
            url: _GATE_URL + '/api/sms/api/smsrecord/ext/list',
            datatype: "json",
            contentType : 'application/json',
            serializeGridData:function(postData){
                return JSON.stringify(postData);
            },
            colNames: ['模块名称', '发送人', '接收人手机号', '短信主题','短信内容','类型','发送时间','操作'],
            colModel: [{
                name: 'appName',
                index: 'appName'
            }, {
                name: 'senderName',
                index: 'senderName'
            }, {
                name: 'receiver',
                index: 'receiver'
            }, {
                name: 'topic',
                index: 'topic'
            }, {
                name: 'context',
                index: 'context'
            } , {
                name: 'sourceType ',
                index: 'sourceType ',
                formatter: function(cellvalue, options, rawObject){
                	if(rawObject.sourceType='MODULAR'){
                		return '模块';
                	}
                	return '';
                }
            }, {
                name: 'sendTime',
                index: 'sendTime'
            }, {
                name: 'act',
                index: 'act',
                title: false,
                width: '150',
                align: 'center',
                formatter: formatterAct
            }],
            pager: '#pager',
            height: 'auto',
            jsonReader : {
                root: "data.list",
                page: "data.pageNum",
                total: "data.pages",
                records: "data.total"
            },
            onPaging: function (pgButton) {
                var pageNo=$(".ui-pg-input").val();
                pageNo=parseInt(pageNo);
                var total = ($("#sp_1_pager_toppager").text()).replace(/,/g,'');
                total=parseInt(total);
                if(pgButton=="next"){
                    if(pageNo>=total){
                        return false;
                    }else{
                        pageNo+=1;
                    }
                }else if(pgButton=="prev"){
                    if(pageNo>1){
                        pageNo-=1;
                    }else{
                        return false;
                    }
                }else if(pgButton=="last"){
                    pageNo=total;
                }else if(pgButton=="first"){
                    pageNo=1;
                }else if (pgButton == "records") {
                    // 切换分页条数，查询第一页
                    pageNo = 1;
                } else if(pgButton == "user") {
                    if(pageNo > total){
                        pageNo = total;
                    }
                }
                var pageSize=$(".ui-pg-selbox").val();
                if(pageNo!=0){
                    updateList(pageNo, pageSize);
                    return false;
                }
            }
        });
    }

    // 事件绑定
    function bindEvent() {
        // 点击查询
        $('#searchBtn').valid({
            form: '#search-condition',
            showAllError: true,
            checkpassed: function () {
                updateList(1, $(".ui-pg-selbox").val() || 20);
            }
        });
    }

    //操作
    function formatterAct(cellvalue, options, rawObject) {
        var returnValue = "";
        returnValue += '<a class="ui-button" href="javascript:void(0);" onclick=deletePage(\''+ rawObject.id +'\')>';
        returnValue += '删除</a>';
        return returnValue;
    };

    //刷新表格
    window.reloadJqgrid = function(){
        $('#list').setGridParam({
            postData:{
                pageNo:1,
                pageSize:20,
                data: {
                    sourceType : 'MODULAR'
                }}},true).trigger('reloadGrid');
    }

    /* 删除 */
    window.deletePage = function (id) {
        parent.layer.confirm("您确定要删除吗？", {
            title: '温馨提示',
            shade: [0.4, '#000'],
            btn: ['确定', '取消'] //按钮
        }, function(value, index, elem) {
            ajaxHengyun({
                type: "post",
                url: _GATE_URL + '/api/sms/api/smsrecord/deleteById',
                data:{"id":id},
                success: function(rows) {
                    if(rows.data) {
                        parent.layer.msg("删除成功！", {
                            icon: 6,
                            time: 1000
                        });
                        parent.home.reloadJqgrid();
                    } else {
                        parent.layer.msg("删除失败，请稍后重试！", {
                            time: 1000
                        });
                    }
                }
            });
        }, function() {
            closeLayer();
        });
    }

});
