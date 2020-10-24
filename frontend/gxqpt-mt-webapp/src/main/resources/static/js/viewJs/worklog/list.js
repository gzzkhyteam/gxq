$(function () {

    // 更新列表
    function updateList (pageNo, pageSize) {
        var startTime = $('input[name="startTime"]').val();
        var endTime = $('input[name="endTime"]').val();
        var postData = {
            data: {
                // 部门id
                mainDeptId: $('select[name="mainDeptId"]').val(),
                // 发布日期-开始
                startTime: startTime ? startTime + ' 00:00:00': '',
                // 发布日期-结束
                endTime: endTime ? endTime + ' 23:59:59' : ''
            },
            pageNo: pageNo || $(".ui-pg-input").val() || 0,
            pageSize: pageSize || $(".ui-pg-selbox").val() || 20
        }
        parent.getUnitIdFromTopWindow(function (unitId) {
            if (!unitId) {
                console.log('获取单位id失败');
                return;
            }
            postData.data.unitId = unitId;
            $('#list').setGridParam({
                postData: postData
            },true).trigger('reloadGrid');
        });
    }

    // 格式化操作项
    function formatterAct(cellvalue, options, rawObject) {
        return "<a href='javascript:void(0)' class='detail' data-id='" + cellvalue + "'><i class='fa fa-pencil'></i>查看</a>";
    }

    // 初始化表格列表
    function initTable() {
        parent.getUnitIdFromTopWindow(function (unitId) {
            if (!unitId) {
                console.log('获取单位id失败');
                return;
            }
            $("#list").jqGrid({
                mtype: 'POST',
                url: _GATE_URL + '/api/mt/work/page',
                postData: {
                    pageNo: 0,
                    pageSize: 20,
                    data: {
                        unitId: unitId
                    }
                },
                datatype: "json",
                contentType : 'application/json',
                serializeGridData:function(postData){
                    return JSON.stringify(postData);
                },
                colNames: ['日期', '姓名', '部门', '职务', '日志详情'],
                colModel: [
                    {name: 'createDate', sortable: false},
                    {name: 'userName', sortable: false},
                    {name: 'mainDeptName', sortable: false},
                    {name: 'mainDutyName', sortable: false},
                    {name: 'id', title: false, width: '100', sortable: false, formatter: formatterAct}],
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
        });
    }

    // 初始化部门选项
    function getParts() {
        parent.getUnitIdFromTopWindow(function(unitId) {
            if (!unitId) {
                console.log('获取单位id失败');
                return;
            }
            ajaxHengyun({
                url: _GATE_URL + "/api/admin/gxqpt/dpm/findDpmByOrgEnable",
                type: 'GET',
                data: {
                    orgId: unitId
                },
                success: function (res) {
                    var data = res.data;
                    if (data) {
                        var options = ['<option value="">全部</option>'];
                        for (var i = 0; i < data.length; i++) {
                            options.push('<option value="' + data[i].id + '">' + data[i].name + '</option>');
                        }
                        $('select[name=mainDeptId]').html(options.join(''));
                    }
                },
                error: function(err) {
                    console.log(err);
                }
            });
        });
    }

    // 日志详情
    function getDetails(id) {
        parent.layer.open({
            type: 2,
            id: 'id',
            title: '日志详情',
            shadeClose: false,
            scrollbar: false,
            ignoreHidden: true,
            shade: 0.6,
            area: ['72%', '60%'],
            content:['viewWorklog?id='+id, 'no'],
            btn:['<span class="glyphicon glyphicon-backward"></span> 关闭'],
        });
    }

    // 事件绑定
    function bindEvent() {
        // 查询按钮点击
        $("button.search-button").click(function(){
            updateList();
        });

        // 查看详情点击
        $('#list').on('click', '.detail', function () {
            getDetails($(this).data('id'));
        });
    }

    function init() {
        getParts();
        initTable();
        bindEvent();
    }

    init();

});
