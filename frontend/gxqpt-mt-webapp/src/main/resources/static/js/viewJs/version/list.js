$(function () {
    // 审核状态
    var publishStatus = {
        published: 2,
        waitPublish: 1
    };
    
    // 格式化操作项
    function formatterAct(cellvalue, options, rawObject) {
        var publish = '<a class="ui-button publish" href="javascript:void(0);" data-id="' + rawObject.id + '"><i class="fa fa-file-text-o"></i> 发布</a>';
        var edit = '<a class="ui-button" href="'+ _cp + '/module/versionCreateOrEdit?id=' + rawObject.id + '"><i class="fa fa-edit"></i> 修改</a>';
        var scan = '<a class="ui-button" href="'+ _cp + '/module/versionView?id=' + rawObject.id + '"><i class="fa fa-trash-o"></i> 查看</a>';
        var splitter = '<span class="oper-separator"></span>';
        // 已发布
        if (publishStatus.published == cellvalue) {
            return scan;
        } else {
            return publish + splitter + edit;
        }
    }

    // 时间日期选择器初始化
    function initDatetimePicker() {
        //时间限制，开始时间不能大于结束时间
        $('#startTime').off('focus').on('focus',function(){
            WdatePicker({lang:'zh-cn',maxDate:CurentTime("endTime"),onpicked:onBlur("startTime"),dateFmt:'yyyy-MM-dd'});
        }).val();
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
        $('.Validform_info').remove();
        var startTime = $('input[name="startTime"]').val();
        var endTime = $('input[name="endTime"]').val();
        var postData = {
            data: {
                // 版本号
                verNumber: $('input[name="verNumber"]').val(),
                // 发布日期-开始
                startPublishTime: startTime ? startTime + ' 00:00:00': '',
                // 发布日期-结束
                endPublishTime: endTime ? endTime + ' 23:59:59' : ''
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
            url: _GATE_URL + '/api/mt/clientVersion/find',
            datatype: "json",
            contentType : 'application/json',
            serializeGridData:function(postData){
                return JSON.stringify(postData);
            },
            colNames: ['发布日期', '状态', '版本名称', '发布版本号', '升级内容', '升级数量', '操作'],
            colModel: [{
                name: 'publishTime',
                index: 'publishTime',
                width: '80',
            }, {
                name: 'state',
                index: 'state',
                width: '60',
                formatter: function (cellvalue, options, rawObject) {
                    return cellvalue == publishStatus.published ? '已发布' : '未发布'
                }
            }, {
                name: 'verName',
                index: 'verName',
                width: '120',
            }, {
                name: 'verNumber',
                index: 'verNumber',
                width: '60',
                formatter: function (cellvalue) {
                    return 'V' + cellvalue
                }
            }, {
                name: 'updateContent',
                index: 'updateContent',
                formatter: function (cellvalue) {
                    var contentArr = cellvalue.match(/>[^<]+/g);
                    if (contentArr) {
                        var str = contentArr.join('').replace(/>/g, '');
                        return str.length > 100 ? str.substring(1, 100) + '...' : str
                    }
                    return '';
                }
            }, {
                name: 'updateNum',
                index: 'updateNum'
            }, {
                name: 'state',
                index: 'state',
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

    // 发布
    function doPublish(id){
        parent.layer.confirm("确定发布吗？",{
            title:'温馨提示',
            shade: [0.4,'#000'],
            btn: ['确定','取消'] //按钮
        }, function(){
            ajaxHengyun({
                type:'POST',
                data: {
                    id: id
                },
                url: _GATE_URL + '/api/mt/clientVersion/publishVersion',
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

    // 事件绑定
    function bindEvent() {
        // 点击发布按钮
        $("#list").on('click', '.publish', function() {
            doPublish($(this).data('id'));
        });
        // 点击查询
        $('#searchBtn').valid({
            form: '#search-condition',
            showAllError: true,
            checkpassed: function () {
                updateList(0, $(".ui-pg-selbox").val() || 20);
            }
        });
        // 点击新增
        $('body').on('click', '.btn-create', function() {
            window.location.href = _cp+"/module/versionCreateOrEdit";
        });

        $('input[name="verNumber"]').on('blur', function () {
            if ($(this).val() == '') {
                $('.Validform_info').remove();
            }
        });
    }

    function init() {
        bindEvent();
        initList();
        initDatetimePicker();
    }

    init();
});
