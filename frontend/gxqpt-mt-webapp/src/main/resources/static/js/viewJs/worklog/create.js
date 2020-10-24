var userIds=[];
$(function () {
    var dict = angular.module('dict', []);
    dict.controller('controller', function ($scope,$http,token) {
        var urlPrev ='${_gate_url}';
        $scope.submit = function () {
            $('.btn-submit').click();
        };
        $scope.save = function () {
            saveData();
        }
    }).service('token',function () {
        this.token = function () {
            return getToken();
        }
    });

    function initFileUpload() {
        //附件上传
        var token = $.cookie("_token");
        var folderId="-1";
        var dataType="";
        loadFile();
        function loadFile() {
            fileUpload = new FileUpload({
                "filePicker" : "filePicker",
                "dndArea" : "dndArea",
                "uploader" : "uploader",
                "jxButton" : "jxButton",
                "folderId":folderId,
                "dataType":dataType,
                "token":token,
                "_isAdmin":true
            });
        }
        $('#saveOk').valid({
            form: '.dataForm',
            ignoreHidden: true,
            showAllError: true,
            checkpassed: function () {
                var appElement = document.querySelector('[ng-controller=controller]');
                var $scope = angular.element(appElement).scope();
                $scope.save();
            }
        });
    }

    // 保存数据
    function saveData() {
        var workLog = new Object();
        workLog.description = $("#description").val();
        workLog.userId = $.cookie("_user_id");
        workLog.userIds = userIds;
        workLog.files = FileList;
        parent.getUnitIdFromTopWindow(function (unitId) {
            if (!unitId) {
                console.log('获取单位id失败');
                return;
            }
            workLog.unitId = unitId;
            ajaxHengyun({
                url:  _GATE_URL + "/api/mt/work/save ",
                type: 'post',
                contentType: 'application/json', //设置请求头信息
                data: JSON.stringify(workLog),
                dataType: "json",
                success: function (data) {
                    if (data.errmsg == 'ok') {
                        parent.layer.closeAll();
                        window.location.href = _cp+"/module/myworklog";
                    } else {
                        parent.layer.msg(data.errmsg);
                    }
                },
            });
        });
    };

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
                    userId: $.cookie("_user_id"),
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
                        $("#addPerson_ptspEmpName").val(nameString);
                    };
                }
            });
        });
    }
    
    function setParent(id){
        parent.layer.open({
            id: 'setParent',
            type: 2,
            anim:6,
            title: '人员选择',
            maxmin: false, //开启最大化最小化按钮
            area: ['500px', '80%'],
            content: _cp+"/module/setParent?userId="+id+"&userIds="+userIds.join(","),
            btn: ['<span class="glyphicon glyphicon-ok"></span> 确定','<span class="glyphicon glyphicon-remove"></span> 取消'],
            yes: function (index, layero) {
                var html=layero.context;
                var Id=html.getElementById("setParent");
                var iframe=$(Id).find("iframe").attr("name");
                var rowData = parent[iframe].save(index);
            }
        });
    };

    // 获取我的所有单位
    function getAllOrg() {
        ajaxHengyun({
            url:  _GATE_URL+"/api/mt/userConfi/getMyOrgList",
            type: 'GET',
            data: {},
            success: function (res) {
                if (res.data) {
                    var orglist = res.data.orgList;
                    var options = ['<option value="" selected>请选择单位</option>'];
                    for (var i = 0; i < orglist.length; i++) {
                        options.push('<option value="'+orglist[i].id+'">'+orglist[i].name+'</option>');
                    }
                    $('#orgid').html(options.join(''));
                }
            }
        });
    }
    function bindEvent() {
        //选择人员
        $("body").on("click","#addPerson_ptsp",function(){
            setParent($.cookie("_user_id"));
        });

        // 返回
        $("body").on("click",".btn-back",function(){
            window.location.href=_cp+'/module/myworklog';
        });
    }
    function init() {
        bindEvent();
        initFileUpload();
        getAllOrg();
        getAuthorityList();
    }
    init();
});
var FileList = new Array();
function successUpload(json) {
    var fileInfo = json.data.list;
    var html = "" ;
    for (var i in fileInfo) {
        var fileUrl = fileInfo[i].fileUrl || fileInfo[i].url;
        var fileName = fileInfo[i].fileName || fileInfo[i].submittedFileName;
        html += "<p class='fileItem'>"+fileName + "<i class='fa fa-trash-o' title='删除' onclick='deleteFile(this,"+fileInfo[i].id+")'></i><i class='fa fa-download' title='下载' onclick=\"doDownloadFile(\'"+fileUrl+"\', \'"+fileName+"\')\"></i></p>";
        var fileInfoObj={};
        fileInfoObj.userId=$.cookie("_user_id");
        fileInfoObj.fileUrl =fileInfo[i].url;
        fileInfoObj.fileType =fileInfo[i].dataType;
        fileInfoObj.fileSize =fileInfo[i].size;
        fileInfoObj.fileName =fileInfo[i].submittedFileName;
        fileInfoObj.id =fileInfo[i].id;
        FileList.push(fileInfoObj);
    };
    $("#wrapper").append(html);

}
function deleteFile(ele,id){
    for(var i=0;i<FileList.length;i++){
        if(FileList[i].id==id){
            FileList.splice(FileList[i],1);
            $(ele).parent().remove();
        }
    }
}
function doDownloadFile(path, name){
    window.open("/api/file/file/download?url="+path+"&filename="+name);
}
function setParentVal(ids,names){
    $("#addPerson_ptspEmpName").val(names);
    userIds=ids.split(",");
}

