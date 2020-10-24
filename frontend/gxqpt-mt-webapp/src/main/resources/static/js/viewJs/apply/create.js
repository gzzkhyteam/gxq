

$(function () {
    // 用来保存选择的组件的id
    var ids = [];
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
    // 格式化操作项
    function formatterAct(cellvalue, options, rawObject) {
        var scan = '<a class="ui-button detail" href="javascript:void(0);" data-name="'+rawObject.componentName+'" data-id="' + rawObject.id + '"><i class="fa fa-file-text-o"></i> 查看</a>';
        return scan;
    }

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

    ue.addListener('blur',function(){savecontent();});
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
                ids=removeDuplicatedItem(aRowids);
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

    var fileUpload4 = null;
    function initApkUpload () {
        /* 附件上传 begin */
        var token = $.cookie("_token");
        var folderId="-1";
        var dataType="";
        // 初始化apk上传
        fileUpload4 = new FileUploadSecond({
            "filePicker" : "filePicker4",
            "dndArea" : "dndArea4",
            "uploader" : "uploader4",
            "jxButton" : "jxButton4",
            "folderId": '-1',
            "dataType": '',
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
                } else {
                    $('input[name="appPath"]').val(json.data.list[0].url);
                }
            }
        });
    }

    function bindEvent() {
        /*提交*/
        $('.btn-submit').valid({
            form: '#dataForm',
            //showAllError:可选项 true | false，true：提交表单时所有错误提示信息都会显示，
            //false：一碰到验证不通过的就停止检测后面的元素，只显示该元素的错误信息;
            ignoreHidden: true,
            showAllError: true,
            checkpassed: function () {
//                var appElement = document.querySelector('[ng-controller=controller]');
//                var $scope = angular.element(appElement).scope();
//                $scope.save();
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
            $('#forH5').hide();
            $('#forAndroid, #pathForAndroid').hide();
            // 安卓
            if (type == 1) {
                $('#forAndroid, #pathForAndroid').show();
                if (!fileUpload4) {
                    initApkUpload();
                }
            } else {
                $('#forH5').show();
            }
        });
    }
    bindEvent();
    getComponentList();
});
