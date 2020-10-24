$(function () {    
    // 格式化操作项
    function formatterAct(cellvalue, options, rawObject) {
        var deleteBtn = '<a class="ui-button delete" href="javascript:void(0);" data-id="' + rawObject.id + '"><i class="fa fa-file-text-o"></i> 删除</a>';
        var edit = '<a class="ui-button" href="'+ _cp + '/module/componentCreateOrEdit?id=' + rawObject.id + '"><i class="fa fa-edit"></i> 修改</a>';
        var scan = '<a class="ui-button detail" href="javascript:void(0);" data-name="'+rawObject.componentName+'" data-id="' + rawObject.id + '"><i class="fa fa-file-text-o"></i> 查看</a>';
        var splitter = '<span class="oper-separator"></span>';
        // if (publishStatus.published == cellvalue) {
        //     return scan;
        // } else {
        //     return publish + splitter + edit;
        // }
        return edit + splitter + deleteBtn + splitter + scan;
    }

    // 更新列表
    function updateList (pageNo, pageSize) {
        var postData = {
            data: $('input[name="componentName"]').val(),
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
            postData:{ pageNo:0, pageSize:20, data: ''},
            url: _GATE_URL + '/api/mt/component/page',
            datatype: "json",
            contentType : 'application/json',
            serializeGridData:function(postData){
                return JSON.stringify(postData);
            },
            colNames: ['组件名称', '组件使用说明', '操作'],
            colModel: [{
                name: 'componentName',
                index: 'componentName',
                // width: '80',
            }, {
                name: 'componentDesc',
                index: 'componentDesc',
                // width: '60',
                // 限制只提取文字，且只显示100个字符
                formatter: function (cellvalue) {
                    var contentArr = cellvalue.match(/>[^<]+/g);
                    if (contentArr) {
                        var str = contentArr.join('').replace(/>/g, '');
                        return str.length > 100 ? str.substring(1, 100) + '...' : str
                    }
                    return '--';
                }
            }, {
                name: 'id',
                index: 'id',
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
                }else if (pgButton == "records") {
                    // 切换分页条数，查询第一页
                    pageNo = 1;
                }
                var pageSize=$(".ui-pg-selbox").val();
                if(pageNo!=0){
                    updateList(pageNo, pageSize);
                    return false;
                }
            }
        });
    }

    // 发布
    function doDelete(id){
        parent.layer.confirm("您确认需要删除吗？",{
            title:'删除确认',
            shade: [0.4,'#000'],
            btn: ['确定','取消'] //按钮
        }, function(){
            ajaxHengyun({
                type:'POST',
                data: {
                    id: id
                },
                url: _GATE_URL + '/api/mt/component/delete',
                success:function (res) {
                    parent.layer.closeAll();
                    updateList();
                },
                error: function(err) {
                    parent.layer.closeAll();
                }
            });
        }, function(){
            parent.layer.closeAll();
        });
    }

    // 打开详情弹窗
    function getDetail(id, name) {
        parent.layer.open({
            type: 2,
            anim:6,
            title: name + '使用说明',
            maxmin: false, //开启最大化最小化按钮
            area: ['500px', '80%'],
            content: _cp+"/module/componentDetail?id="+id,
            btn: ['<span class="glyphicon glyphicon-ok"></span> 确定','<span class="glyphicon glyphicon-remove"></span> 取消'],
            yes: function (index, layero) {
                parent.layer.closeAll();
            }
        });
    }

    // 事件绑定
    function bindEvent() {
        // 点击删除按钮
        $("#list").on('click', '.delete', function() {
            doDelete($(this).data('id'));
        });
        // 点击详情按钮
        $("#list").on('click', '.detail', function() {
            getDetail($(this).data('id'), $(this).data('name'));
        });
        // 点击查询
        $('#searchBtn').on('click', function (){
            updateList(0, $(".ui-pg-selbox").val() || 20);
        });
        // 点击新增
        $('body').on('click', '.btn-create', function() {
            window.location.href = _cp+"/module/componentCreateOrEdit";
        });
    }

    function init() {
        bindEvent();
        initList();
    }

    init();
});
