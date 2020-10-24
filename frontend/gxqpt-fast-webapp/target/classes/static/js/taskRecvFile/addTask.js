$(function () {
	function initChosen () {
		$("#coordinationId").chosen();
		$("#deptIds").chosen();
		$("#cooperateDeptIds").chosen();
		$("#handlerIds").chosen();
	}

	function init () {
		initChosen();
	}

	init();
});

var iframeName= parent.$("iframe").first().attr("name");
$(function(){
    loadFile();
});

function loadFile() {
    fileUpload2 = new FileUpload({
        "filePicker": "filePicker1",
        "dndArea": "dndArea1",
        "uploader": "uploader1",
        "jxButton": "jxButton1",
        "busType": "emgnc",
        "token": $.cookie("_token")
    });
}
var FileList = new Array();
function successUpload(json) {
    if (json.data && json.data.list) {
        var file = json.data.list[0];
        $('#attachmentName').val(file.submittedFileName);
        $('#attachmentUrl').val(file.url);
        $('#dndArea1').css('background-image', 'url(' + file.url + ')').text(file.submittedFileName);
    }
}


var index = parent.layer.getFrameIndex(window.name);
var indexP = parent.parent.layer.getFrameIndex(window.name);
$('#btnGoBack').click( function () {
    parent.layer.close(index);
});

$('#btnAddWillDoTask').valid({
    form: '#addOrUpdateTaskForm',
    showAllError: true,
    checkpassed: function () {
        addOrUpdateTask();
    }
});

function addOrUpdateTask() {
    var result = null;
    var managerName = $("#managerId :selected").text();
    var cooperateManagerNames = new Array();
    var selectSpanCoo = $("#cooperateManagerId_chosen .chosen-choices .search-choice span");
    for (var i = 0; i < selectSpanCoo.length; i++) {
        cooperateManagerNames.push(selectSpanCoo[i].innerHTML);
    }

    var deptNames = new Array();
    var selectSpanDept = $("#deptIds_chosen .chosen-choices .search-choice span");
    for (var i = 0; i < selectSpanDept.length; i++) {
        deptNames.push(selectSpanDept[i].innerHTML);
    }

    var cooperateDeptNames = new Array();
    var selectSpanCooDept = $("#cooperateDeptIds_chosen .chosen-choices .search-choice span");
    for (var i = 0; i < selectSpanCooDept.length; i++) {
        cooperateDeptNames.push(selectSpanCooDept[i].innerHTML);
    }

    var handlerNames = new Array();
    var selectSpanHan = $("#handlerIds_chosen .chosen-choices .search-choice span");
    for (var i = 0; i < selectSpanHan.length; i++) {
        handlerNames.push(selectSpanHan[i].innerHTML);
    }
    var postData = GetWebControls("#addOrUpdateTaskForm");

    // debugger;
    /*var undertakeRoom = postData["undertakeRoom"];
    var coordinationId = postData["coordinationId"];
    var coordinationRoom = postData["coordinationRoom"];
    var agent = postData["agent"];
    
    postData["undertakeRoom"] = undertakeRoom.split(",");
    postData["coordinationId"] = coordinationId.split(",");
    postData["coordinationRoom"] = coordinationRoom.split(",");
    postData["agent"] = agent.split(",");

    postData["managerName"] = managerName.toString();
    postData["cooperateManagerNames"] = cooperateManagerNames.toString();
    postData["deptNames"] = deptNames.toString();
    postData["cooperateDeptNames"] = cooperateDeptNames.toString();
    postData["handlerNames"] = handlerNames.toString();
    postData["attachmentUrl"] = fileList;*/
    postData["finishTimeLimit"] = Date.parse(new Date($("#finishTimeLimit").val()));
    postData = JSON.stringify(postData);
    if (managerName == '请选择牵头领导' && deptNames.length == 0
            && handlerNames.length == 0) {
        parent.parent.layer.alert("提交失败！因为牵头领导、承办处室、经办人至少要选择一个！");
    } else {
        parent.layer.confirm("您确定提交吗？", {
            icon : 3,
            title : '确认'
        }, function(){
            ajaxHengyun({
                url : _GATE_URL + "/api/developer/fastapplicationdoc/saveExtraDoc",
                type : "POST",
                dataType : "json",
                contentType : "application/json",
                data : postData,
                success : function(date) {
                    if (date.errmsg == 'ok') {
                        parent.layer.alert("提交成功！", function() {
                            if (iframeName == "home") {
                                parent.home.loadOldTaskProject(true);
                            } else {
                                parent.loadOldTaskProject(true);
                            }
                            parent.layer.closeAll();
                        });
                    } else {
                        parent.layer.alert("提交失败！");
                    }
                },
                error: function () {
                     parent.layer.alert("提交失败！");
                 }
            });
        },function(){
            
        });
    }
    return result;
}

/*
 自动获取页面控件值
 */
function GetWebControls(element) {
    var reVal = "";
    $(element).find('input,select,textarea').each(
            function(r) {
                var id = $(this).prop('name');
                var value = $(this).val();
                var type = $(this).prop('type');
                if (id) {
                    switch (type) {
                    case "checkbox":
                        if ($(this).prop("checked")) {
                            reVal += '"' + id + '"' + ':' + '"1",';
                        } else {
                            reVal += '"' + id + '"' + ':' + '"0",';
                        }
                        break;
                    case "radio":
                        if ($(this).prop("checked")) {
                            reVal += '"' + id + '":' + '"' + $.trim(value)
                                    + '",';
                        }
                        break;
                    default:
                        if (value != "") { //如果值为空就传空，不需要传空格 -wgj
                            reVal += '"' + id + '"' + ':' + '"'
                                    + $.trim(value) + '",';
                        } else {
                            reVal += '"' + id + '"' + ':' + '"",';
                        }
                        break;
                    }
                }
            });
    reVal = reVal.substr(0, reVal.length - 1);
    reVal = reVal.replace(/\\/g, '\\\\');
    reVal = reVal.replace(/\n/g, '\\n');
    return jQuery.parseJSON('{' + reVal + '}');
}