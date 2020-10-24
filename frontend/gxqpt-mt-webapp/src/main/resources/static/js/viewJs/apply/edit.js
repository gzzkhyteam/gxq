


$(function () {
    // 用来保存选择的组件的id
    var ids = null;
    var dict = angular.module('dict', []);
    dict.controller('controller', function ($scope,$http,token) {
        var urlPrev ='${_gate_url}';
        $scope.submit = function () {
            $('.btn-submit').click();
        };
        $scope.save = function () {
            saveObj();
        }
    }).service('token',function () {
        this.token = function () {
            return getToken();
        }
    });
    // 格式化操作项，且过程中勾选已选择的项目
    function formatterAct(cellvalue, options, rawObject) {
        var scan = '<a class="ui-button detail" href="javascript:void(0);" data-name="'+rawObject.componentName+'" data-id="' + rawObject.id + '"><i class="fa fa-file-text-o"></i> 查看</a>';
        return scan;
    }

    /*获取详情*/
    function getAppBaseInfo(){
        ajaxHengyun({
            type:"POST",
            dataType: 'json',
            url:  _GATE_URL+"/api/mt/appmanager/getAppBaseInfo",
            data:{id:_id},
            success:function(rows){
                if (rows.data){
                    var audit = rows.data.audit
                    var allIds = [];
                    for (var i = 0; i < audit.componentList.length; i++) {
                        allIds.push(audit.componentList[i].id)
                    }
                    ids = allIds;
                    $("#id").val(audit.id);
                    $("#appName").val(audit.appName);
                    $("#appPath").val(audit.appPath);
                    $("#appPackageName").val(audit.appPackageName);
                    $("#appStartAct").val(audit.appStartAct);
                    $("#iconPathId").attr("src",audit.iconPath).removeClass('hidden');
                    $("input[name='iconPath']").val(audit.iconPath);
                    $("input[name='isShow'][value='"+audit.isShow+"']").attr("checked",true);
                    $('#radio'+audit.appType).prop('checked', true);
                    $('#for'+audit.appType).show();
                    ue.ready(function() {
                        ue.execCommand('insertHtml', audit.appDesc);
                        if(audit.appDesc){
                            $("#appExplain > input").val("1");
                        };
                    });
                }else{
                    parent.layer.msg(rows.errmsg+"，请重试！",{time:3000});
                }
            }
        });
    };

    function saveObj(){
        var gxqptDutiesDTO =$("#dataForm").serializeJSON();
        gxqptDutiesDTO.appDesc =ue.getContent();
        gxqptDutiesDTO.componentIds = ids;
        ajaxHengyun({
            type:"POST",
            dataType: 'json',
            contentType: 'application/json',
            url:  _GATE_URL+"/api/mt/appmanager/createAppFirst",
            data:JSON.stringify(gxqptDutiesDTO),
            success:function(rows){
                if (rows.data){
                    parent.layer.msg("操作成功！",{icon:6,time:1000});
                    window.location.href=_cp+"/module/applyList";
                }else{
                    parent.layer.msg(rows.errmsg+"，请重试！",{time:3000});
                }
            }
        });
    };
    ue.addListener('blur',savecontent);
    function savecontent(){
        if(ue.getContent()){
            $("#appExplain > input").val("1");
        }else{
            $("#appExplain > input").val("");
        }
        $("#appExplain > input").blur();
    };

    // 获取组件列表
    function getComponentList() {
        //表格列表初始化
        $("#list").jqGrid({
            mtype: 'POST',
            postData:{ pageNo:0, pageSize: 500, data: ''},
            url: _GATE_URL + '/api/mt/component/page',
            datatype: "json",
            contentType : 'application/json',
            sortable: false,
            serializeGridData:function(postData){
                return JSON.stringify(postData);
            },
            colNames: ['组件名称', '操作'],
            colModel: [{
                name: 'componentName',
                index: 'componentName'
            }, {
                name: 'id',
                index: 'id',
                title: false,
                width: '100',
                align: 'center',
                formatter: formatterAct
            }],
            jsonReader : {
                root: "data.list",
                page: "data.pageNum",
                total: "data.pages",
                records: "data.total"
            },
            width: 450,
            height: 'auto',
            multiselect: true,
            multiselectWidth: 30,
            beforeSelectRow:function(rowid, e){//多选
                if(e.type == 'click'){
                    i = $.jgrid.getCellIndex($(e.target).closest('td')[0]),
                        cm = jQuery("#list").jqGrid('getGridParam', 'colModel');
                        //当点击的单元格为名称或者cb时，选择
                    return (cm[i].name == 'cb' || cm[i].name == 'componentName');
                }
                return false;
            },
            onSelectAll: function(aRowids,status){
                if(status){
                    for(var i=0; i<aRowids.length; i++){
                        var curRowData = jQuery("#list").jqGrid('getRowData', aRowids[i]);
                        ids.push(aRowids[i]);
                        ids=removeDuplicatedItem(ids);
                    }
                }else{
                    for(var i=0; i<aRowids.length; i++){
                        var ret = jQuery.inArray(aRowids,ids);
                        ids.splice(ret,1);
                    }
                }
            },
            onSelectRow: function(id,check){
                if(check){
                    var curRowData = jQuery("#list").jqGrid('getRowData', id);
                    ids.push(id);
                    ids=removeDuplicatedItem(ids);
                }else{
                    var ret = jQuery.inArray(id,ids);
                    ids.splice(ret,1);
                }
            },
            gridComplete: function () {
                var timeInt = setInterval(function () {
                    if (ids !== null) {
                        // 循环所有已选择的id
                        for (var i = 0; i < ids.length; i++) {
                            var id = ids[i];
                            $("#list").jqGrid('setSelection', id);
                        }
                        clearInterval(timeInt);
                    }
                }, 300);
            }
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
        $("body").on("click",".btn-back",function(){
            window.location.href=_cp+"/module/applyList";
        });

        /*提交*/
        $('.btn-submit').valid({
            form: '#dataForm',
            ignoreHidden: true,
            showAllError: true,
            checkpassed: function () {
//                var appElement = document.querySelector('[ng-controller=controller]');
//                var $scope = angular.element(appElement).scope();
                saveObj();
            }
        });

        // 点击详情按钮
        $("#list").on('click', '.detail', function() {
            getDetail($(this).data('id'), $(this).data('name'));
        });

        // 类型切换
        $('input[name="appType"]').on('change', function () {
            var type = $(this).val();
            $('#for2').hide();
            $('#for1').hide();
            // 安卓
            if (type == 1) {
                $('#for1').show();
            } else {
                $('#for2').show();
            }
        });
    }

    function init() {
        bindEvent();
        getAppBaseInfo();
        getComponentList();
    }

    init();

});
