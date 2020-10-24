/* 单选与复选 */
$.fn.extend({
    checkboxed: function () {
        return this.each(function () {
            var that = $(this);
            var label = that.children('label');
            var checkbox = that.children('input[type=checkbox]');

            if (/msie/.test(navigator.userAgent.toLowerCase())) {
                checkbox.click(function (event) {
                    this.blur();
                    this.focus();
                    getChange();
                });
            } else {
                checkbox.change(function (event) {
                    event.preventDefault();
                    getChange();
                });
            }

            function getChange() {
                if (checkbox.is(':checked')) {
                    that.addClass('checkbox_checked');
                } else {
                    that.removeClass('checkbox_checked');
                }
                checkbox.attr("checked", checkbox.is(':checked') ? true : false);
                if (checkbox.is(':checked') && checkbox.attr('id') === "checkboxAll") {
                    $(".checkbox").addClass('checkbox_checked');
                    $('input[type=checkbox]').prop("checked", true);
                } else if (!checkbox.is(':checked') && checkbox.attr('id') === "checkboxAll") {
                    $(".checkbox").removeClass('checkbox_checked');
                    $('input[type=checkbox]').prop("checked", false);
                }

                if (!checkbox.is(':checked') && $("#checkboxAll").is(":checked")) {
                    $("#checkboxAll").parent().removeClass('checkbox_checked');
                    $("#checkboxAll").prop("checked", false);
                }
                //alert($('input:checkbox[type=checkbox]:checked').length);
            }
        });
    },
    radioed: function () {
        return this.each(function () {
            var that = $(this);
            var label = that.children('label');
            var radio = that.children('input[type=radio]');

            that.click(function (event) {
                event.preventDefault();

                if (!$(this).hasClass("radio_checked")) {
                    $(this).addClass('radio_checked').children("input").attr("checked", true);
                }
                $(this).siblings().removeClass("radio_checked").children("input").attr("checked", false);
            });
        });
    }
});

var OCAR = {
    getQueryUrl: function (_param) {
        var getTabUrl = window.location.href;
        var $p = function (_parameter) {
            var sValue = getTabUrl.match(new RegExp("[\?\&]" + _parameter + "=([^\&]*)(\&?)", "i"));
            return sValue ? sValue[1] : sValue;
        };
        var uid = $p(_param) || "";
        return uid;
    }
}
/* ajax请求和普通ajax表单提交 */
function validateAjax(options, callback) {
    var $params = $.extend({type: "GET", url: "", data: {}, global: false, async: true}, options);
    var $callback = callback || "";

    // console.log($params);
    $.ajax({
        type: $params.type,
        url: $params.url,
        async: $params.async,
        data: $params.data,
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        global: $params.global, //触发全局AJAX事件  true:默认值,打开全局事件；false:关闭
        cache: false,
        success: function (data) {
            if ($.isFunction($callback)) {
                $callback(data);
            } else {
                // console.log(data);
            }
        },
        error: function (err) {
            // console.log(err);
        },
        beforeSend: function (xhr) {
            if ($.isFunction($params.beforeSend)) {
                $params.beforeSend(xhr);
            }
        },
        complete: function (xhr) {
            // return;
            if ($.isFunction($params.complete)) {
                $params.complete(xhr);
            }
        }
    });
}

$(function () {
    /* 复选与单选 */
    $(".checkbox").checkboxed();
    $(".radio").radioed();
})
var Path = {
    /* 开发环境路径 */
    devUrl: 'http://127.0.0.1:8020/front-official-car/',
    //devPath: 'http://localhost:3010/fgwdemo/',
    // devPath: 'http://hy.manami.com.cn/fgwdemo/',
    // devPath: 'http://192.168.1.110/',

    /* 生产环境路径 */
    prodUrl: '/',

    /* Server port */
    port: 8001,
};
