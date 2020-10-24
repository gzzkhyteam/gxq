/**
 * jQuery HengYunUI 1.1
 * 恒运贵阳分公司 Copyright © Hengyun 2016
 */
//样式
$(function () {
    readyIndex();
});

function readyIndex() {
    $(".main_menu li div").click(function () {
        $(".main_menu li div").removeClass('main_menu leftselected');
        $(this).addClass('main_menu leftselected');
    }).hover(function () {
        $(this).addClass("hoverleftselected");
    }, function () {
        $(this).removeClass("hoverleftselected");
    });
}
/**
 * 预览打印pdf文件
 * @param applyCode 申请编号
 * @param busType  业务类型
 */
function printPdf(applyCode,busType){
	window.open(RootPath()+"/file/printPdf.do?applyCode="+applyCode+"&busType="+busType,"_blank");
}
/**
 * 下载pdf文件
 * @param applyCode 申请编号
 * @param busType  业务类型
 */
function downlodPrint(applyCode,busType){
	window.location.href=RootPath()+"/file/downloadPdf.do?applyCode="+applyCode+"&busType="+busType;
}
//盖章
function SignClick(){
	alertDialog("找不到对应的印章!", -2);
}
/**
加载布局
**/
function Loadlayout() {
    if ($('.layout').length > 0) {
        $("#layout").splitter({
            type: "v",
            outline: true,
            minLeft: 150, sizeLeft: 200, maxLeft: 350,
            anchorToWindow: true,
            accessKey: "L"
        });
    }
}
//Tab标签切换
function Tabchange(id) {
    $('.ScrollBar').find('.tabPanel').hide();
    $('.ScrollBar').find("#" + id).show();
    $(".tab_list_top div").removeClass("actived");
    $(".tab_list_top").find("#Tab" + id).addClass("actived"); //添加选中样式  
}
function thisTabchange(e, id) {
    $(e).parent().find('div').removeClass("actived");
    $(e).addClass("actived");
    $('.tabPanel').hide();
    $("#" + id).show();
}
function standTabchange(e, id) {
    $(e).parent().find('div').removeClass("standtabactived");
    $(e).addClass("standtabactived");
    $(e).parent().next().children('div').hide();
    $("#" + id).show();
}
/********
接收地址栏参数
**********/
function GetQuery(key) {
    var search = location.search.slice(1); //得到get方式提交的查询字符串
    var arr = search.split("&");
    for (var i = 0; i < arr.length; i++) {
        var ar = arr[i].split("=");
        if (ar[0] == key) {
            if (unescape(ar[1]) == 'undefined') {
                return "";
            } else {
                return unescape(ar[1]);
            }
        }
    }
    return "";
}
/*
获取动态tab标签【当前】iframeID
*/
function tabiframeId() {
    var tabs_container = top.$("#tabs_container");
    return "tabs_iframe_" + tabs_container.find('.selected').attr('id').substr(5);
}

/*
获取动态tab标签【前一个】iframeID
*/
function prevtabiframeId() {
    var tabs_container = top.$("#tabs_container");
    return "tabs_iframe_" + tabs_container.find('.selected').prev().attr('id').substr(5);
}
/*
获取动态tab标签【后一个】iframeID
*/
function pnexttabiframeId() {
    var tabs_container = top.$("#tabs_container");
    return "tabs_iframe_" + tabs_container.find('.selected').next().attr('id').substr(5);
}
//关闭当前tab
function btn_back() {
    top.ThisCloseTab();
}
/*
中间加载对话窗
*/
function Loading(bool, text) {
    var ajaxbg = top.$("#loading_background,#loading");
    if (!!text) {
        top.$("#loading").css("left", (top.$('body').width() - top.$("#loading").width()) / 2);
        top.$("#loading span").html(text);
    } else {
        top.$("#loading").css("left", (top.$('body').width() - top.$("#loading").width()) / 2);
        top.$("#loading span").html("正在拼了命为您加载…");
    }
    if (bool) {
        ajaxbg.show();
    } else {
        ajaxbg.hide();
    }
}
/* 
请求Ajax 带返回值
*/
function getAjax(url, postData, callBack) {
    $.ajax({
        type: 'post',
        dataType: "text",
        url: RootPath() + url,
        data: postData,
        cache: false,
        async: false,
        success: function (data) {
            callBack(data);
            //Loading(false);
        },
        error: function (data) {
            //alert("error:" + JSON.stringify(data));
            Loading(false);
        }
    });
}
/*
以post object方式提交
application/json
*/
function AjaxObject(url, postData, callBack) {
    try {
        $.ajax({
            url: RootPath() + url,
            type: "post",
            data: postData,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            async: false,
            success: function (data) {
                if (data.Code == "-1") {
                    Loading(false);
                    alertDialog(data.Message, -1);
                } else {
                    Loading(false);
                    callBack(data);
                }
            },
            error: function (data) {
                Loading(false);
                alertDialog(data.responseText, -1);
            }
        });
    } catch (e) {

    }
}
/*
以post object方式提交
application/json
*/
function AjaxForm(url, formId, callBack) {
    try {
    	 var formSetting = {
				dataType: 'json',
				success: function (data) {
		               if (data.Code == "-1") {
		                    Loading(false);
		                    alertDialog(data.Message, -1);
		                } else {
		                    Loading(false);
		                    callBack(data);
		                }
		            },
		            error: function (data) {
		                Loading(false);
		                alertDialog(data.responseText, -1);
		        }
			};
			if(typeof validateFormByLV === 'function'){
				formSetting.beforeSubmit = validateFormByLV;
			}
			if(typeof beforeSubmit === 'function'){
				formSetting.beforeSubmit = beforeSubmit;
			}
			if(typeof beforeSerialize === 'function'){
				formSetting.beforeSerialize = beforeSerialize;
			}
			if(url!=null && url!=''){
				$('#'+formId).prop("action", url);
			}
			$('#'+formId).ajaxSubmit(formSetting);
			/* $('#'+formId).on('submit', function(e) {
			    e.preventDefault();
			    $(this).prop("action", url);
			    $(this).ajaxSubmit(formSetting);
			});*/
    } catch (e) {

    }
}
/*
以post表单方式提交
application/x-www-form-urlencoded
*/
function AjaxJson(url, postData, callBack) {
    try {
        $.ajax({
            url: RootPath() + url,
            type: "post",
            data: postData,
            dataType: "json",
            async: false,
            success: function (data) {
                if (data.Code == "-1") {
                    Loading(false);
                    alertDialog(data.Message, -1);
                } else {
                    Loading(false);
                    callBack(data);
                }
            },
            error: function (data) {
                Loading(false);
                alertDialog(data.responseText, -1);
            }
        });
    } catch (e) {

    }
}
/*
刷新当前页面
*/
function Replace() {
    location.reload();
    return false;
}
/*
href跳转页面
*/
function Urlhref(url) {
    location.href = url;
    return false;
}
/*
iframe同步连接
*/
function iframe_src(iframe, src) {
    Loading(true);
    $("#" + iframe).attr('src', RootPath() + src);
    $("#" + iframe).load(function () {
        Loading(false);
    });
}
/*
grid表格扩展Begin
*/

/**获取表格选择行
**/
function GetJqGridRowIndx(jgrid) {
    return $(jgrid).jqGrid('getGridParam', 'selrow');
}
/**获取JqGrid表格列值
jgrid：ID，code：列字段
**/
function GetJqGridRowValue(jgrid, code) {
    var KeyValue = "";
    var selectedRowIds = $(jgrid).jqGrid("getGridParam", "selarrrow");
    if (selectedRowIds != "") {
        var len = selectedRowIds.length;
        for (var i = 0; i < len ; i++) {
            var rowData = $(jgrid).jqGrid('getRowData', selectedRowIds[i]);
            KeyValue += rowData[code] + ",";
        }
        KeyValue = KeyValue.substr(0, KeyValue.length - 1);
    } else {
        var rowData = $(jgrid).jqGrid('getRowData', $(jgrid).jqGrid('getGridParam', 'selrow'));
        KeyValue = rowData[code];
    }
    return KeyValue;
}
/**获取JqGrid表格列值
jgrid：ID，RowIndx:行ID,code：列字段
**/
function GetJqGridValue(jgrid, RowIndx, code) {
    var rowData = $(jgrid).jqGrid('getRowData', RowIndx);
    return rowData[code];
}

/**grid表格扩展end**/


/**
格式化时间显示方式、用法:format="yyyy-MM-dd hh:mm:ss";
*/
formatDate = function (v, format) {
    if (!v) return "";
    var d = v;
    if (typeof v === 'string') {
        if (v.indexOf("/Date(") > -1)
            d = new Date(parseInt(v.replace("/Date(", "").replace(")/", ""), 10));
        else
            d = new Date(Date.parse(v.replace(/-/g, "/").replace("T", " ").split(".")[0]));//.split(".")[0] 用来处理出现毫秒的情况，截取掉.xxx，否则会出错
    }
    var o = {
        "M+": d.getMonth() + 1,  //month
        "d+": d.getDate(),       //day
        "h+": d.getHours(),      //hour
        "m+": d.getMinutes(),    //minute
        "s+": d.getSeconds(),    //second
        "q+": Math.floor((d.getMonth() + 3) / 3),  //quarter
        "S": d.getMilliseconds() //millisecond
    };
    if (/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (d.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
        }
    }
    return format;
};
/**
当前时间
*/
function CurrentTime() {
    var date = new Date();
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var day = date.getDate();
    var hour = date.getHours();
    var minute = date.getMinutes();
    var second = date.getSeconds();
    return year + '-' + month + '-' + day + ' ' + hour + ':' + minute;
}

/*
自动获取页面控件值
*/
function GetWebControls(element) {
    var reVal = "";
    $(element).find('input,select,textarea').each(function (r) {
        var id = $(this).prop('id');
        var value = $(this).val();
        var type = $(this).prop('type');
        if(id){
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
        			reVal += '"' + id + '":' + '"' + $.trim(value) + '",';
        		} 
        		break;	
        	default:
        		if (value != "") { //如果值为空就传空，不需要传空格 -wgj
        			reVal += '"' + id + '"' + ':' + '"' + $.trim(value) + '",';
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
/*
自动获取页面控件值
*/
function GetWebControlsByName(element) {
    var reVal = "";
    $(element).find('input,select,textarea').each(function (r) {
        var id = $(this).prop('name');
        var value = $(this).val();
        var type = $(this).prop('type');
        if(id){
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
        			reVal += '"' + id + '":' + '"' + $.trim(value) + '",';
        		} 
        		break;	
        	default:
        		if (value != "") { //如果值为空就传空，不需要传空格 -wgj
        			reVal += '"' + id + '"' + ':' + '"' + $.trim(value) + '",';
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
/*
自动给控件赋值
*/
function SetWebControls(data) {
    try {
        for (var key in data) {
            var id = $('#' + key);
            if (id.attr('id')) {
                var value = $.trim(data[key]).replace("&nbsp;", "").replace(/</g, "<").replace(/>/, ">");
                var type = id.attr('type');
                switch (type) {
                    case "checkbox":
                        if (value == 1) {
                            id.attr("checked", 'checked');
                        } else {
                            id.removeAttr("checked");
                        }
                        break;
                    default:
                        id.val(value);
                        break;
                }
            }
        }
    } catch (e) {
        alert(e);
    }
}
/*
自动给控件赋值、对Lable
*/
function SetWebLable(data) {
    for (var key in data) {
        var id = $('#' + key);
        if (id.attr('id')) {
            var value = $.trim(data[key]).replace("&nbsp;", "");
            id.text(value);
        }
    }
}
/**
* 获取搜索条件：返回JSON
* var parameter = GetParameterJson("搜索区域table的ID");
*/
function GetParameterJson(tableId) {
    var parameter = "";
    $("#" + tableId + " tr").find('td').find('input,select').each(function () {
        var pk_id = $(this).attr('id');
        var pk_value = $("#" + pk_id).val();
        parameter += '"' + pk_id + '"' + ':' + '"' + $.trim(pk_value) + '",';
    });
    parameter = parameter.substr(0, parameter.length - 1);
    return '{' + parameter + '}';
}
/**
* 获取动态table：键、值，返回JSON
* var GetTableData = GetTableDataJson("table的ID");
*/
function GetTableDataJson(tableId) {
    var item_Key_Value = "";
    var index = 1;
    var trjson = "";
    if ($(tableId + " tbody tr").length > 0) {
        $(tableId + " tbody tr").each(function () {
            var tdjson = "";
            $(this).find('td').find('input,select,textarea').each(function () {
                var pk_id = $(this).attr('id');
                var pk_value = "";
                if ($("#" + pk_id).attr('type') == "checkbox") {
                    if ($("#" + pk_id).attr("checked")) {
                        pk_value = "1";
                    } else {
                        pk_value = "0";
                    }
                } else {
                    pk_value = $("#" + pk_id).val();
                }
                var array = new Array();
                array = pk_id.split("?"); //字符分割
                tdjson += '"' + array[0] + '"' + ':' + '"' + $.trim(pk_value) + '",';
            });
            tdjson = tdjson.substr(0, tdjson.length - 1);
            trjson += '{' + tdjson + '},';
        });
    } else {
        $(tableId + " tr").each(function () {
            var tdjson = "";
            $(this).find('td').find('input,select,textarea').each(function () {
                var pk_id = $(this).attr('id');
                var pk_value = "";
                if ($("#" + pk_id).attr('type') == "checkbox") {
                    if ($("#" + pk_id).attr("checked")) {
                        pk_value = "1";
                    } else {
                        pk_value = "0";
                    }
                } else {
                    pk_value = $("#" + pk_id).val();
                }
                var array = new Array();
                array = pk_id.split("?"); //字符分割
                tdjson += '"' + array[0] + '"' + ':' + '"' + $.trim(pk_value) + '",';
            });
            tdjson = tdjson.substr(0, tdjson.length - 1);
            trjson += '{' + tdjson + '},';
        });
    }
    trjson = trjson.substr(0, trjson.length - 1);
    if (trjson == '{}') {
        trjson = "";
    }
    return '[' + trjson + ']';
}
/**
获取选中复选框值
值：1,2,3,4
**/
function CheckboxValue() {
    var reVal = '';
    $('[type = checkbox]').each(function () {
        if ($(this).attr("checked")) {
            reVal += $(this).val() + ",";
        }
    });
    reVal = reVal.substr(0, reVal.length - 1);
    return reVal;
}
/**
文本框只允许输入数字
**/
function IsNumber(obj) {
    $("#" + obj).bind("contextmenu", function () {
        return false;
    });
    $("#" + obj).css('ime-mode', 'disabled');
    $("#" + obj).keypress(function (e) {
        //48-57是大键盘的数字键，96-105是小键盘的数字键，8是退格符←  
        if (!((e.which <= 57 && e.which >= 48) || (e.which <= 105 && e.which >= 96) || (e.which == 8))) {
            return false;
        } 
    });
}
/**
只能输入数字和小数点
**/
function IsMoney(obj) {
    $("#" + obj).bind("contextmenu", function () {
        return false;
    });
    $("#" + obj).css('ime-mode', 'disabled');
    $("#" + obj).bind("keydown", function (e) {
        var key = window.event ? e.keyCode : e.which;
        if (isFullStop(key)) {
            return $(this).val().indexOf('.') < 0;
        }
        return (isSpecialKey(key)) || ((isNumber(key) && !e.shiftKey));
    });
    function isNumber(key) {
        return (key <= 57 && key >= 48) || (key <= 105 && key >= 96);
    }
    function isSpecialKey(key) {
        return key == 8 || key == 46 || (key >= 37 && key <= 40) || key == 35 || key == 36 || key == 9 || key == 13;
    }
    function isFullStop(key) {
        return key == 190 || key == 110;
    }
}
/**
* 金额格式(保留2位小数)后格式化成金额形式
*/
function FormatCurrency(num) {
    num = num.toString().replace(/\$|\,/g, '');
    if (isNaN(num))
        num = "0";
    sign = (num == (num = Math.abs(num)));
    num = Math.floor(num * 100 + 0.50000000001);
    cents = num % 100;
    num = Math.floor(num / 100).toString();
    if (cents < 10)
        cents = "0" + cents;
    for (var i = 0; i < Math.floor((num.length - (1 + i)) / 3) ; i++)
        num = num.substring(0, num.length - (4 * i + 3)) + '' +
                num.substring(num.length - (4 * i + 3));
    return (((sign) ? '' : '-') + num + '.' + cents);
}
//保留两位小数    
//功能：将浮点数四舍五入，取小数点后2位   
function ToDecimal(x) {
    var f = parseFloat(x);
    if (isNaN(f)) {
        return 0;
    }
    f = Math.round(x * 100) / 100;
    return f;
}
/**
查找数组中是否存在某个值
arr:数组
val:对象值
**/
function ArrayExists(arr, val) {
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] == val)
            return true;
    }
    return false;
}
/*弹出对话框begin========================================*/
/*关闭对话框*/
function closeDialog() {
    var api = frameElement.api, W = api.opener;
    api.close();
    return true;
}
/*
弹出对话框（带：确认按钮、取消按钮）
*/
function openDialog(url, _id, _title, _width, _height, callBack) {
    Loading(true);
    top.$.dialog({
        id: _id,
        width: _width,
        height: _height,
        max: false,
        lock: true,
        title: _title,
        resize: false,
        extendDrag: true,
        //content: 'url:' + RootPath() + url,
        content: 'url:' + RootPath()+url,
        ok: function () {
            callBack(_id);
            return false;
        },
        cancel: true
    });
}

/*
最大化弹出对话框（带：确认按钮、取消按钮）
*/
function FullopenDialog(url, _id, _title, callBack) {
    Loading(true);
    top.$.dialog({
        id: _id,
        lock: true,
        title: _title,
        max: false,
        min: false,
        width: top.$(window).width() - 40,
        height: top.$('body').height() - 100,
        content: 'url:' + RootPath() + url,
        ok: function () {
            callBack(_id);
            return false;
        },
        cancel: true
    });
}
/*
弹出对话框（没按钮）
*/
function Dialog(url, _id, _title, _width, _height) {
    Loading(true);
    top.$.dialog({
        id: _id,
        width: _width,
        height: _height,
        max: false,
        lock: true,
        title: _title,
        //content: 'url:' + RootPath() + url
        content: 'url:' +RootPath()+ url
    });
}
/*
最大化弹出对话框（没按钮）
*/
function FullDialog(url, _id, _title) {
    Loading(true);
    top.$.dialog({
        id: _id,
        lock: true,
        title: _title,
        max: false,
        min: false,
        width: top.$(window).width() - 40,
        height: top.$('body').height() - 100,
        content: 'url:' + RootPath() + url
    });
}

/*
 弹出保存、取消
 */
function SaveCancle(url, _id, _title, _width, _height, _callBack) {
    Loading(true);
    top.$.dialog({
        id: _id,
        width: _width,
        height: _height,
        max: false,
        lock: true,
        title: _title,
        content: 'url:' + RootPath() + url,
        button: [
            {
                name: '保 存',
                callback: function () {
                    _callBack(_id);
                    return false;
                }
            },
            {
                name: '取 消'
            }
        ]
    });
}
/*
弹出查询
*/
function QueryDialog(url, _id, _title, _width, _height, _callBack) {
    Loading(true);
    top.$.dialog({
        id: _id,
        width: _width,
        height: _height,
        max: false,
        lock: true,
        title: _title,
        content: 'url:' + RootPath() + url,
        button: [
            {
                name: '查 询',
                callback: function () {
                    _callBack(_id);
                    return false;
                }
            },
            {
                name: '取 消'
            }
        ]
    });
}
/*
弹出对话框
*/
function MessageDialog(_html, _id, _title, _width, _height, _callBack) {
    top.$.dialog({
        id: _id,
        width: _width,
        height: _height,
        max: false,
        min: false,
        title: _title,
        content: _html,
        ok: function () {
            var data = eval("(" + top.GetParameterJson(_id) + ")");;
            _callBack(data);
            return false;
        },
        cancel: true
    });
}
/*
弹出打印网页
*/
function PrintDialog(url, _id, _title, _width, _height, _callBack, _callPrint,_callDown,_callSign) {
    Loading(true);
    top.$.dialog({
        id: _id,
        width: _width,
        height: _height,
        max: false,
        lock: true, 
        title: _title,
        content: 'url:' + RootPath() + url,
        button: [
            {
                name: '保存',
                callback: function () {
                    _callBack(_id);
                    return false;
                }
            },
            {
                name: '盖章',
                callback: function () {
                	_callSign(_id);
                    return false;
                }
            },
            {
                name: '打 印',
                callback: function () {
                	_callPrint(_id);
                    return false;
                }
            },{
                name: '下载',
                callback: function () {
                	_callDown(_id);
                    return false;
                }
            },
            {
                name: '取 消'
            }
        ]
    });
}

/*打开网页 window.open
/*url:          表示请求路径
/*windowname:   定义页名称
/*width:        宽度
/*height:       高度
---------------------------------------------------*/
function OpenWindow(url, title, w, h) {
    var width = w;
    var height = h;
    var left = ($(window).width() - width) / 2;
    var top = ($(window).height() - height) / 2;
    window.open(RootPath() + url, title, 'height=' + height + ', width=' + width + ', top=' + top + ', left=' + left + ', toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no, titlebar=yes, alwaysRaised=yes');
}

/**
短暂提示
msg: 显示消息
time：停留时间
type：类型 success：成功，error ：失败，warn：警告
**/
function tipDialog(msg, time, type) {
    var msg = "<div class='ui_alert_tip'>" + msg + "</div>";
    if (type == 'success') {
        top.$.dialog.tips(msg, time, 'succ.png');
    } else if (type == 'error') {
        top.$.dialog.tips(msg, time, 'fail.png');
    } else if (type == 'warn') {
        top.$.dialog.tips(msg, time, 'i.png');
    } else {
        top.$.dialog.tips(msg, time, 'fail.png');
    }
}
/*
警告消息
msg: 显示消息
type：类型 >1：成功，<1：失败，其他：警告
*/
function alertDialog(msg, type) {
    var msg = "<div class='ui_alert'>" + msg + "</div>";
    var icon = "";
    if (type >= 1) {
        icon = "succ.png";
    } else if (type == -1) {
        icon = "fail.png";
    } else {
        icon = "i.png";
    }
    top.$.dialog({
        id: "alertDialog",
        icon: icon,
        content: msg,
        title: "温馨提示",
        ok: function () {
            return true;
        }
    });
}
/*
确认对话框
*/
function confirmDialog(_title, msg, callBack) {
    var msg = "<div class='ui_alert'>" + msg + "</div>";
    top.$.dialog({
        id: "confirmDialog",
        lock: true,
        icon: "hits.png",
        content: msg,
        title: _title,
        ok: function () {
            callBack(true);
            return true;
        },
        cancel: function () {
            callBack(false);
            return true;
        }
    });
}
/*弹出对话框end========================================*/
/***
 * 自动关闭弹出内容提示
timeOut : 4000,				//提示层显示的时间
msg : "恭喜你!你已成功操作此插件，谢谢使用！",			//显示的消息
type : "success"//提示类型（1、success 2、error 3、warning）
***/
function TipMsg(msg, timeOut, type) {
    $(".tip_container").remove();
    var bid = parseInt(Math.random() * 100000);
    $("body").prepend('<div id="tip_container' + bid + '" class="container tip_container"><div id="tip' + bid + '" class="mtip"><span id="tsc' + bid + '"></span></div></div>');
    var $this = $(this);
    var $tip_container = $("#tip_container" + bid);
    var $tip = $("#tip" + bid);
    var $tipSpan = $("#tsc" + bid);
    //先清楚定时器
    clearTimeout(window.timer);
    //主体元素绑定事件
    $tip.attr("class", type).addClass("mtip");
    //$tipSpan.html(msg);
    //layer.alert(msg);
    layer.msg(msg, {
    	  offset: 'a',
    	  anim: 2
    	});
    $tip_container.slideDown(300);
    //提示层隐藏定时器
    window.timer = setTimeout(function () {
        $tip_container.slideUp(300);
        $(".tip_container").remove();
    }, timeOut);
    //鼠标移到提示层时清除定时器
    $tip_container.on("mouseover", function () {
        clearTimeout(window.timer);
    });
    //鼠标移出提示层时启动定时器
    $tip_container.on("mouseout", function () {
        window.timer = setTimeout(function () {
            $tip_container.slideUp(300);
            $(".tip_container").remove();
        }, timeOut);
    });
    $("#tip_container" + bid).css("left", ($(window).width() - $("#tip_container" + bid).width()) / 2);
}


/*
验证是否为空
*/
function IsNullOrEmpty(str) {
    var isOK = true;
    if (str == undefined || str == "" || str == 'null') {
        isOK = false;
    }
    return isOK;
}
function IsDelData(id) {
    var isOK = true;
    if (id == undefined || id == "" || id == 'null' || id == 'undefined') {
        isOK = false;
        tipDialog('您没有选中任何项,请您选中后再操作。', 4, 'warning');
    }
    return isOK;
}
function IsChecked(id) {
    var isOK = true;
    if (id == undefined || id == "" || id == 'null' || id == 'undefined') {
        isOK = false;
        tipDialog('您没有选中任何项,请您选中后再操作。', 4, 'warning');
    } else if (id.split(",").length > 1) {
        isOK = false;
        tipDialog('很抱歉,一次只能选择一条记录。', 4, 'warning');
    }
    return isOK;
}

/*鼠标右击菜单begin========================================*/
var getOffset = {
    top: function (obj) {
        return obj.offsetTop + (obj.offsetParent ? arguments.callee(obj.offsetParent) : 0);
    },
    left: function (obj) {
        return obj.offsetLeft + (obj.offsetParent ? arguments.callee(obj.offsetParent) : 0);
    }
};
/**********鼠标右键菜单 start*****************/
function LoadrightMenu(element) {
    var oMenu =$('.rightMenu');
    $(document).click(function () {
        oMenu.hide();
    });
    $(document).mousedown(function (e) {
        if (3 == e.which) {
            oMenu.hide();
        }
    });
    var aUl = oMenu.find("ul");
    var aLi = oMenu.find("li");
    var showTimer = hideTimer = null;
    var i = 0;
    var maxWidth = maxHeight = 0;
    var aDoc = [document.documentElement.offsetWidth, document.documentElement.offsetHeight];
    oMenu.hide();
    for (i = 0; i < aLi.length; i++) {
        //为含有子菜单的li加上箭头
        aLi[i].getElementsByTagName("ul")[0] && (aLi[i].className = "sub");
        //鼠标移入
        aLi[i].onmouseover = function () {
            var oThis = this;
            var oUl = oThis.getElementsByTagName("ul");
            //鼠标移入样式
            oThis.className += " active";
            //显示子菜单
            if (oUl[0]) {
                clearTimeout(hideTimer);
                showTimer = setTimeout(function () {
                    for (i = 0; i < oThis.parentNode.children.length; i++) {
                        oThis.parentNode.children[i].getElementsByTagName("ul")[0] &&
						(oThis.parentNode.children[i].getElementsByTagName("ul")[0].style.display = "none");
                    }
                    oUl[0].style.display = "block";
                    oUl[0].style.top = oThis.offsetTop + "px";
                    oUl[0].style.left = oThis.offsetWidth + "px";

                    //最大显示范围					
                    maxWidth = aDoc[0] - oUl[0].offsetWidth;
                    maxHeight = aDoc[1] - oUl[0].offsetHeight;

                    //防止溢出
                    maxWidth < getOffset.left(oUl[0]) && (oUl[0].style.left = -oUl[0].clientWidth + "px");
                    maxHeight < getOffset.top(oUl[0]) && (oUl[0].style.top = -oUl[0].clientHeight + oThis.offsetTop + oThis.clientHeight + "px");
                }, 300);
            }
        };
        //鼠标移出	
        aLi[i].onmouseout = function () {
            var oThis = this;
            var oUl = oThis.getElementsByTagName("ul");
            //鼠标移出样式
            oThis.className = oThis.className.replace(/\s?active/, "");

            clearTimeout(showTimer);
            hideTimer = setTimeout(function () {
                for (i = 0; i < oThis.parentNode.children.length; i++) {
                    oThis.parentNode.children[i].getElementsByTagName("ul")[0] &&
					(oThis.parentNode.children[i].getElementsByTagName("ul")[0].style.display = "none");
                }
            }, 300);
        };
    }
    //自定义右键菜单
    $(element).bind("contextmenu", function () {
        var event = event || window.event;
        oMenu.show();
        oMenu.css('top', event.clientY + "px");
        oMenu.css('left', event.clientX + "px");
        //最大显示范围
        maxWidth = aDoc[0] - oMenu.width();
        maxHeight = aDoc[1] - oMenu.height();
        //防止菜单溢出
        if (oMenu.offset().top > maxHeight) {
            oMenu.css('top', maxHeight + "px");
        }
        if (oMenu.offset().left > maxWidth) {
            oMenu.css('left', maxWidth + "px");
        }
        return false;
    }).bind("click", function () {
        oMenu.hide();
    });
}
/**********鼠标右键菜单 end*****************/

//自动补全表格
var IndetableRow_autocomplete = 0;
var scrollTopheight = 0;
function autocomplete(Objkey, width, height, data, callBack) {
    if ($('#' + Objkey).attr('readonly') == 'readonly') {
        return false;
    }
    if ($('#' + Objkey).attr('disabled') == 'disabled') {
        return false;
    }
    IndetableRow_autocomplete = 0;
    scrollTopheight = 0;
    var X = $("#" + Objkey).offset().top;
    var Y = $("#" + Objkey).offset().left;
    $("#div_gridshow").html("");
    if ($("#div_gridshow").attr("id") == undefined) {
        $('body').append('<div id="div_gridshow" style="overflow: auto;z-index: 1000;border: 1px solid #A8A8A8;width:' + width + ';height:' + height + ';position: absolute; background-color: #fff; display: none;"></div>');
    } else {
        $("#div_gridshow").height(height);
        $("#div_gridshow").width(width);
    }
    var sbhtml = '<table class="grid" style="width: 100%;">';
    if (data != "") {
        sbhtml += '<tbody>' + data + '</tbody>';
    } else {
        sbhtml += '<tbody><tr><td style="color:red;text-align:center;width:' + width + ';">没有找到您要的相关数据！</td></tr></tbody>';
    }
    sbhtml += '</table>';
    $("#div_gridshow").html(sbhtml);
    $("#div_gridshow").css("left", Y).css("top", X + $('#' + Objkey).height()).show();
    $("#div_gridshow .grid td").css("border-left", "none").css("padding-left", "2px");
    if (data != "") {
        $("#div_gridshow").find('tbody tr').each(function (r) {
            if (r == 0) {
                $(this).addClass('selected');
            }
        });
    }
    $("#div_gridshow").find('tbody tr').click(function () {
        var parameter = "";
        $(this).find('td').each(function (i) {
            parameter += '"' + $(this).attr('id') + '"' + ':' + '"' + $.trim($(this).text()) + '",';
        });
        if ($('#' + Objkey).attr('readonly') == 'readonly') {
            return false;
        }
        if ($('#' + Objkey).attr('disabled') == 'disabled') {
            return false;
        }
        callBack(JSON.parse('{' + parameter.substr(0, parameter.length - 1) + '}'));
        $("#div_gridshow").hide();
    });
    $("#div_gridshow").find('tbody tr').hover(function () {
        $(this).addClass("selected");
    }, function () {
        $(this).removeClass("selected");
    });
    //任意键关闭
    document.onclick = function (e) {
        var e = e ? e : window.event;
        var tar = e.srcElement || e.target;
        if (tar.id != 'div_gridshow') {
            if ($(tar).attr("id") == 'div_gridshow' || $(tar).attr("id") == Objkey) {
                $("#div_gridshow").show();
            } else {
                $("#div_gridshow").hide();
            }
        }
    };
}
//方向键上,方向键下,回车键
function autocompletekeydown(Objkey, callBack) {
    $("#" + Objkey).keydown(function (e) {
        switch (e.keyCode) {
            case 38: // 方向键上
                if (IndetableRow_autocomplete > 0) {
                    IndetableRow_autocomplete--;
                    $("#div_gridshow").find('tbody tr').removeClass('selected');
                    $("#div_gridshow").find('tbody tr').each(function (r) {
                        if (r == IndetableRow_autocomplete) {
                            scrollTopheight -= 22;
                            $("#div_gridshow").scrollTop(scrollTopheight);
                            $(this).addClass('selected');
                        }
                    });
                }
                break;
            case 40: // 方向键下
                var tindex = $("#div_gridshow").find('tbody tr').length - 1;
                if (IndetableRow_autocomplete < tindex) {
                    IndetableRow_autocomplete++;
                    $("#div_gridshow").find('tbody tr').removeClass('selected');
                    $("#div_gridshow").find('tbody tr').each(function (r) {
                        if (r == IndetableRow_autocomplete) {
                            scrollTopheight += 22;
                            $("#div_gridshow").scrollTop(scrollTopheight);
                            $(this).addClass('selected');
                        }
                    });
                }
                break;
            case 13:  //回车键
                var parameter = "";
                $("#div_gridshow").find('tbody tr').each(function (r) {
                    if (r == IndetableRow_autocomplete) {
                        $(this).find('td').each(function (i) {
                            parameter += '"' + $(this).attr('id') + '"' + ':' + '"' + $.trim($(this).text()) + '",';
                        });
                    }
                });
                if ($('#' + Objkey).attr('readonly') == 'readonly') {
                    return false;
                }
                if ($('#' + Objkey).attr('disabled') == 'disabled') {
                    return false;
                }
                callBack(JSON.parse('{' + parameter.substr(0, parameter.length - 1) + '}'));
                $("#div_gridshow").hide();
                break;
            default:
                break;
        }
    });
}
/**
树下拉框
Objkey:          ID
width：          宽度
height：         高度
data：           数据
**/
function comboBoxTree(Objkey, height) {
    top.$(".ui_state_highlight").focus();
    var width = $("#" + Objkey).width();
    $("#" + Objkey).css('ime-mode', 'disabled');
    $("#" + Objkey).bind("contextmenu", function () { return false; });
    $("#" + Objkey).keypress(function (e) { return false; });
    if ($('#' + Objkey).attr('readonly') == 'readonly') { return false; }
    if ($('#' + Objkey).attr('disabled') == 'disabled') { return false; }
    var X = $("#" + Objkey).offset().top - 1;
    var Y = $("#" + Objkey).offset().left - 1;
    var comboBoxTree = "comboBoxTree" + Objkey;
    if ($("#" + comboBoxTree).attr("id") == undefined) {
        $('body').append('<div id="' + comboBoxTree + '" style="overflow: auto;border: 1px solid #ccc;border-top:none;width:' + width + 'px;height:' + height + ';position: absolute; background-color: #fff; display: none;"></div>');
    }
    $("#" + comboBoxTree).css("left", Y).css("top", X + $("#" + Objkey).height() + 2).css("z-index", "99").slideDown(100);
    //任意键关闭
    document.onclick = function (e) {
        var e = e ? e : window.event;
        var tar = e.srcElement || e.target;
        if (tar.id != '' + comboBoxTree + '') {
            if ($(tar).hasClass("bbit-tree-ec-icon")) {
                return false;
            }
            if ($(tar).attr("id") == Objkey) {
                return false;
            } else {
                $("#" + comboBoxTree).slideUp(100);
            }
        }
    };
}
/*删除数据
/*url:        表示请求路径
/*parm：      条件参数
--------------------------------------------------*/
function delConfirm(url, parm, msg) {
    confirmDialog("温馨提示", msg, function (r) {
        if (r) {
            Loading(true, "正在删除数据...");
            window.setTimeout(function () {
                AjaxJson(url, parm, function (data) {
                    tipDialog(data.Message, 3, data.Code);
                    if (data.Code > 0) {
                        windowload();
                    }
                });
            }, 200);
        }
    });
}
function delConfig(url, parm, count) {
    if (count == undefined) {
        count = 1;
    }
    confirmDialog("温馨提示", "注：您确定要删除 " + count + " 条记录？", function (r) {
        if (r) {
            Loading(true, "正在删除数据...");
            window.setTimeout(function () {
                AjaxJson(url,parm, function (data) {
                    tipDialog(data.msg, 3, data.result);
                    if (data.result =='success') {
                        windowload();
                    }
                });
            }, 200);
        }
    });
}
/*绑定数据字典下拉框
ControlId:控件ID
Code:分类编码
Memo:默认显示
*/
function BindDropItem(ControlId, Code, Memo) {
    $(ControlId).html("");
    if (IsNullOrEmpty(Memo)) {
        $(ControlId).append("<option value=''>" + Memo + "</option>");
    }
    getAjax('/CommonModule/DataDictionary/BinDingItemsJson', { Code: Code }, function (data) {
        var itemjson = eval("(" + data + ")");
        $.each(itemjson, function (i) {
            $(ControlId).append($("<option></option>").val(itemjson[i].Code).html(itemjson[i].FullName));
        });
        Loading(false);
    });
}
/*绑定下拉框
ControlId:控件ID
Memo:默认显示
*/
function JsonBindDrop(ControlId, Memo, DataJson) {
    $(ControlId).html("");
    if (IsNullOrEmpty(Memo)) {
        $(ControlId).append("<option value=''>" + Memo + "</option>");
    }
    var DataJson = eval("(" + DataJson + ")");
    $.each(DataJson, function (i) {
        $(ControlId).append($("<option></option>").val(DataJson[i].Code).html(DataJson[i].FullName));
    });
}
/*
验证对象值不能重复 
id:字段ID、
tablename：表名、
keyfield：主键Id、
Msg：提示消息
*/
function FieldExist(id, tablename, keyfield, Msg) {
    var $ObjFiel = $("#" + id);
    var postData = {
        tablename: tablename,
        fieldname: id,
        fieldvalue: $ObjFiel.val(),
        keyfield: GetQuery('KeyValue'),
        keyvalue: keyfield
    };
    getAjax('/Utility/FieldExist', postData, function (data) {
        if (data.toLocaleLowerCase() == 'false') {
            tipCss("#" + id, Msg + "已存在,请重新输入");
        }
        Loading(false);
    });
}
/*公共导出Excel，将表格数据取出来。在导出Excel
obj:表格对象ID
fileName：导出Excel文件名
*/
function SetDeriveExcel(obj, fileName) {
    var columnModel = $(obj).jqGrid('getGridParam', 'colModel');
    var dataModel = $(obj).jqGrid("getRowData");
    var footerData = $(obj).jqGrid("footerData");
    var JsonData = {
        JsonColumn: JSON.stringify(columnModel),
        JsonData: JSON.stringify(dataModel),
        JsonFooter: JSON.stringify(footerData),
        FileName: fileName
    };
    getAjax("/Utility/SetDeriveExcel", JsonData, function (data) { });
}
/*
表格视图列名
*/
function columnModelData(jgrid) {
	/***********test start*****************/
	return;
	/***********test end*******************/
	/*
    AjaxJson("/Utility/LoadViewColumn", {}, function (data) {
        $.each(data, function (i) {
            $(jgrid).hideCol(data[i].FieldName);
        });
    });
    */
}
function getQueryString(name) { 
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r != null) return unescape(r[2]); return null; 
	} 
//获取后台菜单按钮
function LoadButtons(menuId){
	var menuCode=getQueryString("menuId");
	var byType=1;//通过id查询
	if(menuId!="" && menuId.length > 0 ){
		menuCode=menuId;//菜单code,根据此code加载对应页面按钮
		byType=2;//通过code查询
	}
	var myary=new Array();
	if(menuCode){
		var url="/sys/resource/getMenuButton.do";
		AjaxJson(url, {"menuCode":menuCode,"byType":byType}, function (data) {
			var buttonJson=data.bList;
			 var tmp= new Object();
             tmp.ButtonId="-101";
             tmp.ModuleId="-102";
             tmp.ParentId="0";
             tmp.Code="lr-replace";
             tmp.FullName="刷新";
             tmp.Icon= "arrow_refresh.png";
             tmp.Category="1";
             tmp.JsEvent="Replace()";
             tmp.ActionEvent="";
             tmp.Split='1';
             tmp.Remark="刷新当前(Ctrl+Q)";
             tmp.Enabled= 1;
             tmp.SortCode=1;
             tmp.DeleteMark= 0;
             myary.push(tmp);
             tmp= new Object();
             tmp.ButtonId="-103";
             tmp.ModuleId="-104";
             tmp.ParentId="0";
             tmp.Code="lr-replace";
             tmp.FullName="刷新";
             tmp.Icon= "arrow_refresh.png";
             tmp.Category="2";
             tmp.JsEvent="Replace()";
             tmp.Split='1';
             tmp.Remark="刷新当前(Ctrl+Q)";
             tmp.Enabled= 1;
             tmp.SortCode=1;
             tmp.DeleteMark= 0;
             myary.push(tmp);
			if(buttonJson!=null && buttonJson.length > 0 ){
                for (var i = 0; i < buttonJson.length; i++) {
                     tmp= new Object();
                     tmp.ButtonId=buttonJson[i].id;
                     tmp.ModuleId=buttonJson[i].pId;
                     tmp.ParentId="0";
                     tmp.Code=buttonJson[i].resourceCode;
                     tmp.FullName=buttonJson[i].resourceName;
                     tmp.Icon= buttonJson[i].iconUrl;
                     tmp.Category="1";
                     tmp.JsEvent=buttonJson[i].buttonMethod;
                     tmp.ActionEvent="/CommonModule/User/Form";
                     tmp.Split='1';
                     tmp.Remark=buttonJson[i].resourceName;
                     tmp.Enabled= 1;
                     tmp.SortCode=1;
                     tmp.DeleteMark= 0;
                     myary.push(tmp);
                     //右键菜单
                     tmp= new Object();
                     tmp.ButtonId=buttonJson[i].id;
                     tmp.ModuleId=buttonJson[i].pId;
                     tmp.ParentId="0";
                     tmp.Code=buttonJson[i].resourceCode;
                     tmp.FullName=buttonJson[i].resourceName;
                     tmp.Icon= buttonJson[i].iconUrl;
                     tmp.Category="2";
                     tmp.JsEvent=buttonJson[i].buttonMethod;
                     tmp.ActionEvent="/CommonModule/User/Form";
                     tmp.Split='1';
                     tmp.Remark=buttonJson[i].resourceName;
                     tmp.Enabled= 1;
                     tmp.SortCode=1;
                     tmp.DeleteMark= 0;
                     myary.push(tmp);
                }
            }
			 tmp= new Object();
             tmp.ButtonId="-105";
             tmp.ModuleId="-106";
             tmp.ParentId="0";
             tmp.Code="lr-leave";
             tmp.FullName="离开";
             tmp.Icon= "back.png";
             tmp.Category="1";
             tmp.JsEvent="btn_back()";
             tmp.Split='1';
             tmp.Remark="刷新当前(Ctrl+Q)";
             tmp.Enabled= 1;
             tmp.SortCode=1;
             tmp.DeleteMark= 0;
             myary.push(tmp);
             tmp= new Object();
             tmp.ButtonId="-107";
             tmp.ModuleId="-108";
             tmp.ParentId="0";
             tmp.Code="lr-leave";
             tmp.FullName="离开";
             tmp.Icon= "back.png";
             tmp.Category="2";
             tmp.JsEvent="btn_back()";
             tmp.Split='1';
             tmp.Remark="关闭当前窗口(Esc)";
             tmp.Enabled= 1;
             tmp.SortCode=1;
             tmp.DeleteMark= 0;
             myary.push(tmp);
		});
	}
	 return myary;
}
function PartialLoadButton() {
	var PartialButton ="PartialButton";
	var menu_code="";
	if(arguments.length>0){
		PartialButton=arguments[0];//显示按钮的的div样式
		menu_code=arguments[1];//菜单code,根据此code加载对应页面按钮
	}
	var JsonData = "";
    var toolbar_html = "";
    var toolbar_Children_Count = 0;
	var Data = LoadButtons(menu_code);
	JsonData = Data;
	$.each(Data, function (i) {
        if (Data[i].ParentId == '0' && Data[i].Category == '1') {
            var toolbar_Children_List = Toolbar_Children(Data[i].ButtonId, Data);
            if (toolbar_Children_Count > 0) {
                toolbar_html += "<a id=\"" + Data[i].Code + "\" ids=\"" + Data[i].ButtonId + "\" class=\"tools_btn dropdown\">";
                toolbar_html += "<div style=\"float: left;\"><div class=\"icon\"><img src=\"" + RootPath() + "/statics/img/Images/Icon16/" + Data[i].Icon + "\" /></div><div class=\"text\">" + Data[i].FullName + "</div></div>";
                toolbar_html += "<div class=\"dropdown-icon\"><img src=\"" + RootPath() + "/statics/img/Images/dropdown-icon.png\" /></div>";
                toolbar_html += "<div class=\"dropdown-data\"><i></i><span></span>";
                toolbar_html += "    <ul>";
                toolbar_html += toolbar_Children_List;
                toolbar_html += "    </ul>";
                toolbar_html += "</div>";
                toolbar_html += "</a>";
            } else {
                var title = "title=\"" + Data[i].Remark + "\"";
                if (Data[i].Remark == "") { title = ""; }
                toolbar_html += "<a id=\"" + Data[i].Code + "\" ids=\"" + Data[i].ButtonId + "\" " + title + " onclick=\"" + Data[i].JsEvent + "\" class=\"tools_btn\"><span><b style=\"background: url('" + RootPath() + "/statics/img/Images/Icon16/" + Data[i].Icon + "') 50% 4px no-repeat;\">" + Data[i].FullName + "</b></span></a>";
            }
            if (Data[i].Split == '1') {
                toolbar_html += "<div class=\"tools_separator\"></div>";
            }
        }
    });
	$('.tools_bar .'+PartialButton).html(toolbar_html);
    function Toolbar_Children(ButtonId, Data) {
        var _toolbar_Children = "";
        toolbar_Children_Count = 0;
        $.each(Data, function (i) {
            if (Data[i].ParentId == ButtonId) {
                var title = "title=\"" + Data[i].Remark + "\"";
                if (Data[i].Remark == "") { title = ""; }
                _toolbar_Children += "<li id=\"" + Data[i].Code + "\" ids=\"" + Data[i].ButtonId + "\" " + title + " onclick=\"" + Data[i].JsEvent + "\"><img src=\"" + RootPath() + "/statics/img/Images/Icon16/" + Data[i].Icon + "\" />" + Data[i].FullName + "</li>";
                toolbar_Children_Count++;
            }
        });
        return _toolbar_Children;
    }
    $(".tools_btn").hover(function () {
        $(this).addClass("tools_btn_hover");
    }, function () {
        $(this).removeClass("tools_btn_hover");
    });
    $(".tools_bar .dropdown").hover(function () {
        var left = $(this).offset().left - ($(this).find('.dropdown-data').width() / 2) + ($(this).width() / 2 + 9);
        $(this).find('.dropdown-data').show().css('top', ($(this).offset().top + 50)).css('left', left);
        $(this).find('.dropdown-icon').addClass('dropdown-icon-hover');
        $(this).addClass('dropdown-selected');
    }, function () {
        if (!$(this).hasClass("_click")) {
            $(this).removeClass('dropdown-selected');
            $(this).find('.dropdown-data').hide();
            $(this).find('.dropdown-icon').removeClass('dropdown-icon-hover');
        }
    });
    $('.tools_bar .dropdown').toggle(function () {
        $(this).addClass('_click');
        var left = $(this).offset().left - ($(this).find('.dropdown-data').width() / 2) + ($(this).width() / 2 + 9);
        $(this).find('.dropdown-data').show().css('top', ($(this).offset().top + 50)).css('left', left);
        $(this).find('.dropdown-icon').addClass('dropdown-icon-hover');
        $(this).addClass('dropdown-selected');
    }, function () {
        $(this).removeClass('dropdown-selected');
        $(this).find('.dropdown-data').hide();
        $(this).find('.dropdown-icon').removeClass('dropdown-icon-hover');
        $('.dropdown').removeClass('_click');
    });
    $(".dropdown-data li").click(function () {
        $('.dropdown').removeClass('dropdown-selected');
        $('.dropdown').find('.dropdown-data').hide();
        $('.dropdown').find('.dropdown-icon').removeClass('dropdown-icon-hover');
        $('.dropdown').removeClass('_click');
    });
    //右击菜单
    var right_toolbar_Count = 0;
    var right_toolbar_html = "";
    right_toolbar_html += '<div class="rightMenu"><ul>';
    $.each(JsonData, function (i) {
        if (JsonData[i].ParentId == '0' && JsonData[i].Category == '2') {
            var title = "title=\"" + JsonData[i].Remark + "\"";
            if (JsonData[i].Remark == "") { title = ""; }
            var righttoolbar_Children_List = right_toolbar_Children(JsonData[i].ButtonId, JsonData);
            if (right_toolbar_Count > 0) {
                right_toolbar_html += "<li id=\"right_" + JsonData[i].Code + "\" ids=\"" + JsonData[i].ButtonId + "\" " + title + " onclick=\"" + JsonData[i].JsEvent + "\" ><img src=\"" + RootPath() + "/statics/img/Images/Icon16/" + JsonData[i].Icon + "\" />" + JsonData[i].FullName + righttoolbar_Children_List + "</li>";
            } else {
                right_toolbar_html += "<li id=\"right_" + JsonData[i].Code + "\"  ids=\"" + JsonData[i].ButtonId + "\" " + title + " onclick=\"" + JsonData[i].JsEvent + "\" ><img src=\"" + RootPath() + "/statics/img/Images/Icon16/" + JsonData[i].Icon + "\" />" + JsonData[i].FullName + "</li>";
            }
            if (JsonData[i].Split == '1') {
                right_toolbar_html += "<div class=\"m-split\"></div>";
            }
        }
    });
    right_toolbar_html += '</ul></div>';
    function right_toolbar_Children(ButtonId, JsonData) {
        var _right_toolbar = "<ul>";
        right_toolbar_Count = 0;
        $.each(JsonData, function (i) {
            if (JsonData[i].ParentId == ButtonId) {
                var title = "title=\"" + JsonData[i].Remark + "\"";
                if (JsonData[i].Remark == "") { title = ""; }
                _right_toolbar += "<li id=\"right_" + JsonData[i].Code + "\"  ids=\"" + JsonData[i].ButtonId + "\" " + title + " onclick=\"" + JsonData[i].JsEvent + "\" ><img src=\"img/Images/Icon16/" + JsonData[i].Icon + "\" />" + JsonData[i].FullName + "</li>";
                if (JsonData[i].Split == '1') {
                    _right_toolbar += "<div class=\"m-split\"></div>";
                }
                right_toolbar_Count++;
            }
        });
        return _right_toolbar + "</ul>";
    }
    $("body").append(right_toolbar_html);
    if ($('.rightMenu').find('li').length > 0) {
        LoadrightMenu("#grid_List");
    } else {
        $('.rightMenu').remove();
    }
}


//加载权限按钮
function PartialButton(_module,buttonJson) {
    var JsonData = "";
    var toolbar_html = "";
    var toolbar_Children_Count = 0;
    
    /**************test start**************/
    var dataurl = "";
    if (_module == "DataDictionary") {
    	dataurl = "/statics/CommonModule/DataDictionary/datadictionarypartialbutton.js";
    }else if (_module == "View") {
    	dataurl = "/statics/CommonModule/View/viewpartialbutton.js";
    }else if (_module == "User") {
    	dataurl = "/statics/CommonModule/UserManager/userpartialbutton.js";
    }else if(_module == "Custom"){
    	partialbuttonjson=buttonJson;
    	
    }
	$.getScript(RootPath() + dataurl, function(data, status, jqxhr) {
	}).done(function() {
		var Data = partialbuttonjson;
		JsonData = Data;
		$.each(Data, function (i) {
            if (Data[i].ParentId == '0' && Data[i].Category == '1') {
                var toolbar_Children_List = Toolbar_Children(Data[i].ButtonId, Data)
                if (toolbar_Children_Count > 0) {
                    toolbar_html += "<a id=\"" + Data[i].Code + "\" ids=\"" + Data[i].ButtonId + "\" class=\"tools_btn dropdown\">";
                    toolbar_html += "<div style=\"float: left;\"><div class=\"icon\"><img src=\"" + RootPath() + "/statics/img/Images/Icon16/" + Data[i].Icon + "\" /></div><div class=\"text\">" + Data[i].FullName + "</div></div>";
                    toolbar_html += "<div class=\"dropdown-icon\"><img src=\"" + RootPath() + "/statics/img/Images/dropdown-icon.png\" /></div>";
                    toolbar_html += "<div class=\"dropdown-data\"><i></i><span></span>";
                    toolbar_html += "    <ul>";
                    toolbar_html += toolbar_Children_List;
                    toolbar_html += "    </ul>";
                    toolbar_html += "</div>";
                    toolbar_html += "</a>";
                } else {
                    var title = "title=\"" + Data[i].Remark + "\"";
                    if (Data[i].Remark == "") { title = ""; }
                    toolbar_html += "<a id=\"" + Data[i].Code + "\" ids=\"" + Data[i].ButtonId + "\" " + title + " onclick=\"" + Data[i].JsEvent + "\" class=\"tools_btn\"><span><b style=\"background: url('" + RootPath() + "/statics/img/Images/Icon16/" + Data[i].Icon + "') 50% 4px no-repeat;\">" + Data[i].FullName + "</b></span></a>";
                }
                if (Data[i].Split == '1') {
                    toolbar_html += "<div class=\"tools_separator\"></div>";
                }
            }
        });
		$('.tools_bar .PartialButton').html(toolbar_html);
	    function Toolbar_Children(ButtonId, Data) {
	        var _toolbar_Children = "";
	        toolbar_Children_Count = 0;
	        $.each(Data, function (i) {
	            if (Data[i].ParentId == ButtonId) {
	                var title = "title=\"" + Data[i].Remark + "\"";
	                if (Data[i].Remark == "") { title = ""; }
	                _toolbar_Children += "<li id=\"" + Data[i].Code + "\" ids=\"" + Data[i].ButtonId + "\" " + title + " onclick=\"" + Data[i].JsEvent + "\"><img src=\"" + RootPath() + "/statics/img/Images/Icon16/" + Data[i].Icon + "\" />" + Data[i].FullName + "</li>";
	                toolbar_Children_Count++;
	            }
	        });
	        return _toolbar_Children;
	    }
	    $(".tools_btn").hover(function () {
	        $(this).addClass("tools_btn_hover");
	    }, function () {
	        $(this).removeClass("tools_btn_hover");
	    });
	    $(".tools_bar .dropdown").hover(function () {
	        var left = $(this).offset().left - ($(this).find('.dropdown-data').width() / 2) + ($(this).width() / 2 + 9);
	        $(this).find('.dropdown-data').show().css('top', ($(this).offset().top + 50)).css('left', left);
	        $(this).find('.dropdown-icon').addClass('dropdown-icon-hover');
	        $(this).addClass('dropdown-selected');
	    }, function () {
	        if (!$(this).hasClass("_click")) {
	            $(this).removeClass('dropdown-selected');
	            $(this).find('.dropdown-data').hide();
	            $(this).find('.dropdown-icon').removeClass('dropdown-icon-hover');
	        }
	    });
	    $('.tools_bar .dropdown').toggle(function () {
	        $(this).addClass('_click');
	        var left = $(this).offset().left - ($(this).find('.dropdown-data').width() / 2) + ($(this).width() / 2 + 9);
	        $(this).find('.dropdown-data').show().css('top', ($(this).offset().top + 50)).css('left', left);
	        $(this).find('.dropdown-icon').addClass('dropdown-icon-hover');
	        $(this).addClass('dropdown-selected');
	    }, function () {
	        $(this).removeClass('dropdown-selected');
	        $(this).find('.dropdown-data').hide();
	        $(this).find('.dropdown-icon').removeClass('dropdown-icon-hover');
	        $('.dropdown').removeClass('_click');
	    });
	    $(".dropdown-data li").click(function () {
	        $('.dropdown').removeClass('dropdown-selected');
	        $('.dropdown').find('.dropdown-data').hide();
	        $('.dropdown').find('.dropdown-icon').removeClass('dropdown-icon-hover');
	        $('.dropdown').removeClass('_click');
	    });
	    //右击菜单
	    var right_toolbar_Count = 0;
	    var right_toolbar_html = "";
	    right_toolbar_html += '<div class="rightMenu"><ul>';
	    $.each(JsonData, function (i) {
	        if (JsonData[i].ParentId == '0' && JsonData[i].Category == '2') {
	            var title = "title=\"" + JsonData[i].Remark + "\"";
	            if (JsonData[i].Remark == "") { title = ""; }
	            var righttoolbar_Children_List = right_toolbar_Children(JsonData[i].ButtonId, JsonData);
	            if (right_toolbar_Count > 0) {
	                right_toolbar_html += "<li id=\"right_" + JsonData[i].Code + "\" ids=\"" + JsonData[i].ButtonId + "\" " + title + " onclick=\"" + JsonData[i].JsEvent + "\" ><img src=\"" + RootPath() + "/statics/img/Images/Icon16/" + JsonData[i].Icon + "\" />" + JsonData[i].FullName + righttoolbar_Children_List + "</li>";
	            } else {
	                right_toolbar_html += "<li id=\"right_" + JsonData[i].Code + "\"  ids=\"" + JsonData[i].ButtonId + "\" " + title + " onclick=\"" + JsonData[i].JsEvent + "\" ><img src=\"" + RootPath() + "/statics/img/Images/Icon16/" + JsonData[i].Icon + "\" />" + JsonData[i].FullName + "</li>";
	            }
	            if (JsonData[i].Split == '1') {
	                right_toolbar_html += "<div class=\"m-split\"></div>";
	            }
	        }
	    });
	    right_toolbar_html += '</ul></div>';
	    function right_toolbar_Children(ButtonId, JsonData) {
	        var _right_toolbar = "<ul>";
	        right_toolbar_Count = 0;
	        $.each(JsonData, function (i) {
	            if (JsonData[i].ParentId == ButtonId) {
	                var title = "title=\"" + JsonData[i].Remark + "\"";
	                if (JsonData[i].Remark == "") { title = ""; }
	                _right_toolbar += "<li id=\"right_" + JsonData[i].Code + "\"  ids=\"" + JsonData[i].ButtonId + "\" " + title + " onclick=\"" + JsonData[i].JsEvent + "\" ><img src=\"img/Images/Icon16/" + JsonData[i].Icon + "\" />" + JsonData[i].FullName + "</li>";
	                if (JsonData[i].Split == '1') {
	                    _right_toolbar += "<div class=\"m-split\"></div>";
	                }
	                right_toolbar_Count++;
	            }
	        });
	        return _right_toolbar + "</ul>";
	    }
	    $("body").append(right_toolbar_html);
	    if ($('.rightMenu').find('li').length > 0) {
	        LoadrightMenu("#grid_List");
	    } else {
	        $('.rightMenu').remove();
	    }
	}).fail(function() {
		//马上执行挽救操作
	});
}
//=================动态菜单tab标签========================
function AddTabMenu(tabid, url, name, img, Isclose, IsReplace, IsVisitorModule) {
    $('#overlay_startmenu').hide(); $('#start_menu_panel').hide(); $('#start_menu_panel .nicescroll-rails').show(); $('.nicescroll-rails').hide();
    if (url == "" || url == "#" || url == RootPath()) {
        url = RootPath() + "/Error/Error404";
    }
    //将moundId放到url中
    if(url.indexOf('?') > 0){
    	url=url+"&menuId="+tabid;
    }else{
    	url=url+"?menuId="+tabid;
    }
    var tabs_container = top.$("#tabs_container");
    var ContentPannel = top.$("#ContentPannel");
    if (IsReplace == 'true' || IsReplace == true) {
        top.RemoveDiv(tabid);
    }
    if (top.document.getElementById("tabs_" + tabid) == null) { //如果当前tabid存在直接显示已经打开的tab
       /*Loading(true);*/
        if (!IsVisitorModule) {
            VisitorModule(tabid, name);
        }
        if (tabs_container.find('li').length >= 10) {
            Loading(false);
            alertDialog("为保证系统效率,只允许同时运行10个功能窗口,请关闭一些窗口后重试！", 0);
            return false;
        }
        tabs_container.find('li').removeClass('selected');
        ContentPannel.find('iframe').hide();
        if (Isclose != 'false') { //判断是否带关闭tab
            tabs_container.append("<li id=\"tabs_" + tabid + "\" class='selected' win_close='true'><span title='" + name + "' onclick=\"AddTabMenu('" + tabid + "','" + url + "','" + name + "','true')\"><a>" + name + "</a></span><a class=\"win_close\" title=\"关闭当前窗口\" onclick=\"RemoveDiv('" + tabid + "')\"></a></li>");
        } else {
            tabs_container.append("<li id=\"tabs_" + tabid + "\" class=\"selected\" onclick=\"AddTabMenu('" + tabid + "','" + url + "','" + name + "','false')\"><a>" + name + "</a></li>");
        }
        ContentPannel.append("<iframe id=\"tabs_iframe_" + tabid + "\" name=\"tabs_iframe_" + tabid + "\" height=\"100%\" width=\"100%\" src=\"" + url + "\" frameBorder=\"0\"></iframe>");
    } else {
        if (!IsVisitorModule) {
            VisitorModule(tabid, name);
        }
        tabs_container.find('li').removeClass('selected');
        ContentPannel.find('iframe').hide();
        tabs_container.find('#tabs_' + tabid).addClass('selected');
        top.document.getElementById("tabs_iframe_" + tabid).style.display = 'block';
    }
    $('iframe#' + tabiframeId()).load(function () {
        Loading(false);
    });
    LoadrightMenu(".tab-nav li");
}
//关闭当前tab
function ThisCloseTab() {
    var tabs_container = top.$("#tabs_container");
    top.RemoveDiv(tabs_container.find('.selected').attr('id').substr(5));
}
//全部关闭tab
function AllcloseTab() {
    top.$(".tab-nav").find("[win_close=true]").each(function () {
        RemoveDiv($(this).attr('id').substr(5));
    });
}
//关闭除当前之外的tab
function othercloseTab() {
    var tabs_container = top.$("#tabs_container");
    var id = tabs_container.find('.selected').attr('id').substr(5);
    top.$(".tab-nav").find("[win_close=true]").each(function () {
        if ($(this).attr('id').substr(5) != id) {
            RemoveDiv($(this).attr('id').substr(5));
        }
    });
}
//关闭事件
function RemoveDiv(obj) {
    console.log(obj);
    Loading(false);
    var tabs_container = top.$("#tabs_container");
    var ContentPannel = top.$("#ContentPannel");
//    var ModuleId = tabs_container.find('.selected').attr('id').substr(5);//原来ID
//    var ModuleName = tabs_container.find('.selected').find('span').attr('title');//原来名称
//    SetLeave(ModuleId, ModuleName);
    tabs_container.find("#tabs_" + obj).remove();
    ContentPannel.find("#tabs_iframe_" + obj).remove();
    var tablist = tabs_container.find('li');
    var pannellist = ContentPannel.find('iframe');
    if (tablist.length > 0) {
        tablist[tablist.length - 1].className = 'selected';
        pannellist[tablist.length - 1].style.display = 'block';
        var id = tabs_container.find('.selected').attr('id').substr(5);
        VisitorModule(id);
    }
}
//访问模块，写入系统菜单Id
function VisitorModule(ModuleId, ModuleName) {
    top.$("#ModuleId").val(ModuleId);
    /*
    getAjax("/Home/SetModuleId", { ModuleId: ModuleId, ModuleName: ModuleName }, function (data) { });
    */
}
//离开模块
function SetLeave(ModuleId, ModuleName) {
    getAjax("/Home/SetLeave", { ModuleId: ModuleId, ModuleName: ModuleName }, function (data) { });
}
/*获取多个相同name的input值，以指定的分隔符号分隔
inputName:input name
separator：分隔符
*/
function GetSameTextValue(inputName,separator){
	  var extValus="";
	  $("input[name="+inputName+"]").each(function(){
    	 var v=$(this).val();
    	  if(v!=''){
    		  extValus+=v+separator;
    	  }
    });
	if(extValus!=null && extValus!=''){
		extValus=extValus.substr(0, extValus.length-1);
	}  
	return extValus;
}
//=================动态菜单tab标签========================
//js获取网站根路径(站点及虚拟目录)
function RootPath() {
    var strFullPath = window.document.location.href;
    var strPath = window.document.location.pathname;
    var pos = strFullPath.indexOf(strPath);
    var prePath = strFullPath.substring(0, pos);
    var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
    //如果发布IIS，有虚假目录用用这句
     return (prePath + postPath);
    //return (prePath);
    /*
    console.log(strFullPath);
    console.log(strPath);
    console.log(pos);
    console.log(prePath);
    console.log(postPath);
    */
    //return (prePath);
}
/**
 * 文本框根据输入内容自适应高度
 * @param                {HTMLElement}        输入框元素
 * @param                {Number}                设置光标与输入框保持的距离(默认0)
 * @param                {Number}                设置最大高度(可选)
 */
var autoTextarea = function (elem, extra, maxHeight) {
        extra = extra || 0;
        var isFirefox = !!document.getBoxObjectFor || 'mozInnerScreenX' in window,
        isOpera = !!window.opera && !!window.opera.toString().indexOf('Opera'),
                addEvent = function (type, callback) {
                        elem.addEventListener ?
                                elem.addEventListener(type, callback, false) :
                                elem.attachEvent('on' + type, callback);
                },
                getStyle = elem.currentStyle ? function (name) {
                        var val = elem.currentStyle[name];
 
                        if (name === 'height' && val.search(/px/i) !== 1) {
                                var rect = elem.getBoundingClientRect();
                                return rect.bottom - rect.top -
                                        parseFloat(getStyle('paddingTop')) -
                                        parseFloat(getStyle('paddingBottom')) + 'px';        
                        };
 
                        return val;
                } : function (name) {
                                return getComputedStyle(elem, null)[name];
                },
                minHeight = parseFloat(getStyle('height'));
        elem.style.resize = 'none';
 
        var change = function () {
                var scrollTop, height,
                        padding = 0,
                        style = elem.style;
 
                if (elem._length === elem.value.length) return;
                elem._length = elem.value.length;
 
                if (!isFirefox && !isOpera) {
                        padding = parseInt(getStyle('paddingTop')) + parseInt(getStyle('paddingBottom'));
                };
                scrollTop = document.body.scrollTop || document.documentElement.scrollTop;
 
                elem.style.height = minHeight + 'px';
                if (elem.scrollHeight > minHeight) {
                        if (maxHeight && elem.scrollHeight > maxHeight) {
                                height = maxHeight - padding;
                                style.overflowY = 'auto';
                        } else {
                                height = elem.scrollHeight - padding;
                                style.overflowY = 'hidden';
                        };
                        minHeight=minHeight+20;
                        style.height = minHeight + extra + 'px';
                        scrollTop += parseInt(style.height) - elem.currHeight;
                        document.body.scrollTop = scrollTop;
                        document.documentElement.scrollTop = scrollTop;
                        elem.currHeight = parseInt(style.height);
                };
        };
        addEvent('propertychange', change);
        addEvent('input', change);
        addEvent('focus', change);
        change();
};


//加载权限按钮
function PartialButtonRight(_module,buttonJson) {
    var JsonData = "";
    var toolbar_html = "";
    var toolbar_Children_Count = 0;
    /**************test start**************/
    var dataurl = "";
    if (_module == "DataDictionary") {
    	dataurl = "/statics/CommonModule/DataDictionary/datadictionarypartialbutton.js";
    }else if (_module == "View") {
    	dataurl = "/statics/CommonModule/View/viewpartialbutton.js";
    }else if (_module == "User") {
    	dataurl = "/statics/CommonModule/UserManager/userpartialbutton.js";
    }else if(_module == "Custom"){
    	partialbuttonjson=buttonJson;
    	
    }
	$.getScript(RootPath() + dataurl, function(data, status, jqxhr) {
	}).done(function() {
		var Data = partialbuttonjson;
		JsonData = Data;
		$.each(Data, function (i) {
			if(Data[i].FullName !="删除"){
            if (Data[i].ParentId == '0' && Data[i].Category == '1') {
                var toolbar_Children_List = Toolbar_Children(Data[i].ButtonId, Data);
                if (toolbar_Children_Count > 0) {
                    toolbar_html += "<a id=\"" + Data[i].Code + "\" ids=\"" + Data[i].ButtonId + "\" class=\"tools_btn dropdown\">";
                    toolbar_html += "<div style=\"float: left;\"><div class=\"icon\"><img src=\"" + RootPath() + "/statics/img/Images/Icon16/" + Data[i].Icon + "\" /></div><div class=\"text\">" + Data[i].FullName + "</div></div>";
                    toolbar_html += "<div class=\"dropdown-icon\"><img src=\"" + RootPath() + "/statics/img/Images/dropdown-icon.png\" /></div>";
                    toolbar_html += "<div class=\"dropdown-data\"><i></i><span></span>";
                    toolbar_html += "    <ul>";
                    toolbar_html += toolbar_Children_List;
                    toolbar_html += "    </ul>";
                    toolbar_html += "</div>";
                    toolbar_html += "</a>";
                } else {
                    var title = "title=\"" + Data[i].Remark + "\"";
                    if (Data[i].Remark == "") { title = ""; }
                    toolbar_html += "<a id=\"" + Data[i].Code + "\" ids=\"" + Data[i].ButtonId + "\" " + title + " onclick=\"R" + Data[i].JsEvent + "\" class=\"tools_btn\"><span><b style=\"background: url('" + RootPath() + "/statics/img/Images/Icon16/" + Data[i].Icon + "') 50% 4px no-repeat;\">" + Data[i].FullName + "</b></span></a>";
                }
                if(i==3){
                	return false;
                }
                /*
                if (Data[i].Split == '1') {
                    toolbar_html += "<div class=\"tools_separator\"></div>";
                }
				*/
            }
			}
        });
		$('#Rtools_bar #PartialButtonRight').html(toolbar_html);
	    function Toolbar_Children(ButtonId, Data) {
	        var _toolbar_Children = "";
	        toolbar_Children_Count = 0;
	        $.each(Data, function (i) {
	            if (Data[i].ParentId == ButtonId) {
	                var title = "title=\"" + Data[i].Remark + "\"";
	                if (Data[i].Remark == "") { title = ""; }
	                _toolbar_Children += "<li id=\"" + Data[i].Code + "\" ids=\"" + Data[i].ButtonId + "\" " + title + " onclick=\"R" + Data[i].JsEvent + "\"><img src=\"" + RootPath() + "/statics/img/Images/Icon16/" + Data[i].Icon + "\" />" + Data[i].FullName + "</li>";
	                toolbar_Children_Count++;
	            }
	        });
	        return _toolbar_Children;
	    }
	    $("#Rtools_bar").hover(function () {
	        $(this).addClass("tools_btn_hover");
	    }, function () {
	        $(this).removeClass("tools_btn_hover");
	    });
	    $("#Rtools_bar .dropdown").hover(function () {
	        var left = $(this).offset().left - ($(this).find('.dropdown-data').width() / 2) + ($(this).width() / 2 + 9);
	        $(this).find('.dropdown-data').show().css('top', ($(this).offset().top + 50)).css('left', left);
	        $(this).find('.dropdown-icon').addClass('dropdown-icon-hover');
	        $(this).addClass('dropdown-selected');
	    }, function () {
	        if (!$(this).hasClass("_click")) {
	            $(this).removeClass('dropdown-selected');
	            $(this).find('.dropdown-data').hide();
	            $(this).find('.dropdown-icon').removeClass('dropdown-icon-hover');
	        }
	    });
	    $('#Rtools_bar .dropdown').toggle(function () {
	        $(this).addClass('_click');
	        var left = $(this).offset().left - ($(this).find('.dropdown-data').width() / 2) + ($(this).width() / 2 + 9);
	        $(this).find('.dropdown-data').show().css('top', ($(this).offset().top + 50)).css('left', left);
	        $(this).find('.dropdown-icon').addClass('dropdown-icon-hover');
	        $(this).addClass('dropdown-selected');
	    }, function () {
	        $(this).removeClass('dropdown-selected');
	        $(this).find('.dropdown-data').hide();
	        $(this).find('.dropdown-icon').removeClass('dropdown-icon-hover');
	        $('.dropdown').removeClass('_click');
	    });
	    $(".dropdown-data li").click(function () {
	        $('.dropdown').removeClass('dropdown-selected');
	        $('.dropdown').find('.dropdown-data').hide();
	        $('.dropdown').find('.dropdown-icon').removeClass('dropdown-icon-hover');
	        $('.dropdown').removeClass('_click');
	    });
	    //右击菜单
	    var right_toolbar_html =  '<div class="rightMenu" id="lrightMenu"><ul>';
	    /*
	    right_toolbar_html += '<div class="rightMenu"><ul>';
		*/
	    $.each(JsonData, function (i) {
	        if (JsonData[i].ParentId == '0' && JsonData[i].Category == '2') {
	            var title = "title=\"" + JsonData[i].Remark + "\"";
	            if (JsonData[i].Remark == "") { title = ""; }
	            if(JsonData[i].FullName != '权限设置'){
	            	right_toolbar_html += "<li id=\"right_" + JsonData[i].Code + "\"  ids=\"" + JsonData[i].ButtonId + "\" " + title + " onclick=\"R" + JsonData[i].JsEvent + "\" ><img src=\"" + RootPath() + "/statics/img/Images/Icon16/" + JsonData[i].Icon + "\" />" + JsonData[i].FullName + "</li>";
	            }
	            if (JsonData[i].Split == '1') {
	                right_toolbar_html += "<div class=\"m-split\"></div>";
	            }
	        }
	    });
	    right_toolbar_html += '</ul></div>';
	    $("#rightDiv").append(right_toolbar_html);
	}).fail(function() {
		//马上执行挽救操作
	});
}


function dateFormat(date, format) {
	 
    date = new Date(date+"GMT+0800");
    var o = {
        'M+' : date.getMonth() + 1, //month
        'd+' : date.getDate(), //day
        'H+' : date.getHours(), //hour
        'm+' : date.getMinutes(), //minute
        's+' : date.getSeconds(), //second
        'q+' : Math.floor((date.getMonth() + 3) / 3), //quarter
        'S' : date.getMilliseconds() //millisecond
    };

    if (/(y+)/.test(format))
        format = format.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length));

    for (var k in o)
        if (new RegExp('(' + k + ')').test(format))
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ('00' + o[k]).substr(('' + o[k]).length));

    return format;
}