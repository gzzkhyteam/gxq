$(function () {
    // 审核状态
    var checkStatus = {
        pass: 2,
        wait: 1
    };

    // 获取默认开始时间
    function getDefaultStartDate() {
        var dateTime = new Date(Date.now() - (30 * 24 * 60 * 60 * 1000));
        var date = [];
        var year = dateTime.getFullYear();
        var month = dateTime.getMonth() + 1;
        month = month < 10 ? '0' + month : month;
        var day = dateTime.getDate();
        date.push(year);
        date.push(month);
        date.push(day);
        return date.join('-');
    }

    // 获取默认结束时间
    function getDefaultEndDate() {
        var dateTime = new Date();
        var date = [];
        var year = dateTime.getFullYear();
        var month = dateTime.getMonth() + 1;
        month = month < 10 ? '0' + month : month;
        var day = dateTime.getDate();
        date.push(year);
        date.push(month);
        date.push(day);
        return date.join('-');
    }

    // 格式化操作项
    function formatterAct(cellvalue, options, rawObject) {
        var check = '<a class="ui-button check-in" href="javascript:void(0);" data-id="' + rawObject.id + '"><i class="fa fa-file-text-o"></i> 审核</a>';
        var edit = '<a class="ui-button" href="'+ _cp + '/module/helpAddOrEdit?id=' + rawObject.id + '"><i class="fa fa-edit"></i> 修改</a>';
        var giveup = '<a class="ui-button giveup" href="javascript:void(0);" data-id="' + rawObject.id + '"><i class="fa fa-trash-o"></i> 弃审</a>';
        var deleteHelp = '<a class="ui-button deleteBtn" href="javascript:void(0);" data-id="' + rawObject.id + '"><i class="fa fa-trash-o"></i> 删除</a>';
        var detail = '<a class="ui-button" href="'+ _cp + '/module/helpAddOrEdit?isDetail=true&id=' + rawObject.id + '"><i class="fa fa-edit"></i> 查看</a>';
        var splitter = '<span class="oper-separator"></span>';
        // 已审核
        if (checkStatus.pass === rawObject.status) {
            return giveup + splitter + deleteHelp + splitter + detail;
        } else {
            return check + splitter + edit + splitter + deleteHelp + splitter + detail;
        }
    }

    // 格式化常用标识
    function formatterMark(cellvalue, options, rawObject) {
        // 已审核
        if (cellvalue == "1") {
            return "是";
        } else if(cellvalue == "2"){
            return "否";
        }
    }

    /* 弃审 */
    function delect(id){
        parent.layer.confirm("您确定要弃审吗？",{
            title:'温馨提示',
            shade: [0.4,'#000'],
            btn: ['确定','取消'] //按钮
        }, function(){
            ajaxHengyun({
                type:'POST',
                data: JSON.stringify({
                    id: id
                }),
                contentType: 'application/json',
                url: _GATE_URL + '/api/mt/help/discardAudit',
                success:function (res) {
                    parent.layer.closeAll();
                    updateList();
                },
                error: function(err) {
                    console.log(err);
                    parent.layer.closeAll();
                }
            });
        }, function(){
            parent.layer.closeAll();
        });
    }

    // 审核
    function doCheck(id){
        parent.layer.confirm("确定审核吗？",{
            title:'温馨提示',
            shade: [0.4,'#000'],
            btn: ['确定','取消'] //按钮
        }, function(){
            ajaxHengyun({
                type:'POST',
                data: JSON.stringify({
                    id: id
                }),
                contentType: 'application/json',
                url: _GATE_URL + '/api/mt/help/audit',
                success:function (res) {
                    parent.layer.closeAll();
                    updateList();
                },
                error: function(err) {
                    console.log(err);
                    parent.layer.closeAll();
                }
            });
        }, function(){
            parent.layer.closeAll();
        });
    }

    // 时间日期选择器初始化
    function initDatetimePicker() {
        //时间限制，开始时间不能大于结束时间
        $('#startTime').off('focus').on('focus',function(){
            WdatePicker({lang:'zh-cn',maxDate:CurentTime("endTime"),onpicked:onBlur("startTime"),dateFmt:'yyyy-MM-dd'});
        });
        $('#endTime').off('focus').on('focus',function(){
            WdatePicker({lang:'zh-cn',minDate:CurentTime("startTime"),onpicked:onBlur("endTime"),dateFmt:'yyyy-MM-dd'});
        });
        function CurentTime(id) {
            if(id){
                var time = $("#"+id).val();
                return time;
            }
        };
        function onBlur(id){
            if(id){
              $("#"+id).blur();
            };
        };
    }

    // 更新列表
    function updateList (pageNo, pageSize) {
        var startTime = $('input[name="startTime"]').val();
        var endTime = $('input[name="endTime"]').val();
        var postData = {
            data: {
                // 内容title
                title: $('input[name="title"]').val(),
                // 登记日期-开始
                startTime: startTime ? startTime + ' 00:00:00': '',
                // 登记日期-结束
                endTime: endTime ? endTime + ' 23:59:59' : ''
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
            postData:{ pageNo:0, pageSize:20, data: {}},
            url: _GATE_URL + '/api/mt/help/page',
            datatype: "json",
            contentType : 'application/json',
            serializeGridData:function(postData){
                return JSON.stringify(postData);
            },
            colNames: ['标题', '帮助内容', '登记日期', '审核状态', '常用标志', '操作'],
            colModel: [{
                name: 'title',
                index: 'title',
                width: '80',
            }, {
                name: 'content',
                index: 'content',
                width: '60',
                formatter: function (cellvalue) {
                    var contentArr = cellvalue.match(/>[^<]+/g);
                    if (contentArr) {
                        var str = contentArr.join('').replace(/>/g, '');
                        return str.length > 20 ? str.substring(0, 20) + '...' : str
                    }
                    return '';
                }
            }, {
                name: 'createTime',
                index: 'createTime',
                width: '120',
            }, {
                name: 'status',
                index: 'status',
                width: '60',
                formatter: function (cellvalue, options, rawObject) {
                    return cellvalue == checkStatus.pass ? '已审核' : '未审核'
                }
            }, {
                name: 'commonlyMark',
                index: 'commonlyMark',
                formatter: formatterMark
            }, {
                name: 'status',
                index: 'status',
                title: false,
                width: '100',
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
                }
                var pageSize=$(".ui-pg-selbox").val();
                if(pageNo!=0){
                    updateList(pageNo, pageSize);
                    return false;
                }
            }
        });
    }

    // 删除方法
    function delectFun(id) {
        parent.layer.confirm("您确定要删除该条信息吗？",{
            title:'温馨提示',
            shade: [0.4,'#000'],
            btn: ['确定','取消'] //按钮
        }, function(){
            ajaxHengyun({
                type:"post",
                dataType: 'json',
                url: _GATE_URL + '/api/mt/help/delete?id='+id,
                success:function(rows){
                    if (rows.data){
                        parent.layer.msg("删除成功！",{time:1000});
                        updateList();
                    }else{
                        parent.layer.msg(rows.errmsg+"，请重试！",{time:3000});
                    }
                }
            });
        });
    }

    // 事件绑定
    function bindEvent() {
        // 点击弃审按钮
        $("#list").on('click', '.giveup', function() {
            delect($(this).data('id'));
        });
        // 点击审核按钮
        $("#list").on('click', '.check-in', function() {
            doCheck($(this).data('id'));
        });
        // 点击查询
        $('#searchBtn').on('click', function () {
            updateList(0, $(".ui-pg-selbox").val() || 20);
        });
        // 点击删除
        $('#list').on('click', '.deleteBtn', function () {
            var id = $(this).attr("data-id");
            delectFun(id);
        });
    }

    function init() {
        bindEvent();
        initList();
        initDatetimePicker();
    }

    init();
});
