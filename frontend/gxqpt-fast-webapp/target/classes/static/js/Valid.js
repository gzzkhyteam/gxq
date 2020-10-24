/**
 * Created by D on 2016/12/6.
 * 夏金晶 2016年12月6日
 */
var options = {
    form: null,
    showAllError: false,
    checkpassed: null,
    postonce: true,
    datatype: null,
}
//在这里对验证表达式做扩展
function getExtDatatype() {

    return {
        idCard: /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/,
        realIdcard: function (gets, obj, curform, datatype) {
            //该方法由佚名网友提供;

            var Wi = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1];// 加权因子;
            var ValideCode = [1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2];// 身份证验证位值，10代表X;

            if (gets.length == 15) {
                return isValidityBrithBy15IdCard(gets);
            } else if (gets.length == 18) {
                var a_idCard = gets.split("");// 得到身份证数组
                if (isValidityBrithBy18IdCard(gets) && isTrueValidateCodeBy18IdCard(a_idCard)) {
                    return true;
                }
                return false;
            }
            return false;

            function isTrueValidateCodeBy18IdCard(a_idCard) {
                var sum = 0; // 声明加权求和变量
                if (a_idCard[17].toLowerCase() == 'x') {
                    a_idCard[17] = 10;// 将最后位为x的验证码替换为10方便后续操作
                }
                for (var i = 0; i < 17; i++) {
                    sum += Wi[i] * a_idCard[i];// 加权求和
                }
                valCodePosition = sum % 11;// 得到验证码所位置
                if (a_idCard[17] == ValideCode[valCodePosition]) {
                    return true;
                }
                return false;
            }

            function isValidityBrithBy18IdCard(idCard18) {
                var year = idCard18.substring(6, 10);
                var month = idCard18.substring(10, 12);
                var day = idCard18.substring(12, 14);
                var temp_date = new Date(year, parseFloat(month) - 1, parseFloat(day));
                // 这里用getFullYear()获取年份，避免千年虫问题
                if (temp_date.getFullYear() != parseFloat(year) || temp_date.getMonth() != parseFloat(month) - 1 || temp_date.getDate() != parseFloat(day)) {
                    return false;
                }
                return true;
            }

            function isValidityBrithBy15IdCard(idCard15) {
                var year = idCard15.substring(6, 8);
                var month = idCard15.substring(8, 10);
                var day = idCard15.substring(10, 12);
                var temp_date = new Date(year, parseFloat(month) - 1, parseFloat(day));
                // 对于老身份证中的你年龄则不需考虑千年虫问题而使用getYear()方法
                if (temp_date.getYear() != parseFloat(year) || temp_date.getMonth() != parseFloat(month) - 1 || temp_date.getDate() != parseFloat(day)) {
                    return false;
                }
                return true;
            }

        }
    }
}
$.fn.valid = function (options) {
    $(this).click(function () {
        $(options.form).submit();
    });

    if ($.trim($(options.form).attr('action')) == '') {
        $(options.form).submit(function () {
            return false;
        });
    }

    $('.Validform_checktip').each(function () {
        if ($.trim($(this).text()) == '') {
            $(this).parent().hide();
        }
    });
    var datatype = getExtDatatype();
    for (var key in options.datatype) {
        datatype[key] = options.datatype[key];
    }
    $(options.form).Validform({
        showAllError: options.showAllError,
        beforeSubmit: options.checkpassed,
        datatype: datatype,
        postonce: options.postonce,//防止重复提交
        //dragonfly: true,//当为true时，值为空时不做验证
        tiptype: function (msg, o, cssctl) {
            //msg：提示信息;
            //o:{obj:*,type:*,curform:*}, obj指向的是当前验证的表单元素（或表单对象），
            //type指示提示的状态，值为1、2、3、4， 1：正在检测/提交数据，2：通过验证，3：验证失败，4：提示ignore状态,
            //curform为当前form对象;
            //cssctl:内置的提示信息样式控制函数，该函数需传入两个参数：显示提示信息的对象 和 当前提示的状态（既形参o中的type）;

            if (!o.obj.is("form")) {//验证表单元素时o.obj为该表单元素，全部验证通过提交表单时o.obj为该表单对象;
                var infoObj = o.obj.next('.Validform_info');
                var objtip = o.obj.next('.Validform_checktip');

                if (infoObj.size() == 0) {
                    var htmlstrs = '<div class="Validform_info" style="display: none;">'
                        + '<span class="Validform_checktip">' + msg + '</span>'
                        + '<span class="Validform_dec"><s class="Validform_dec1">&#9670;</s><s class="Validform_dec2">&#9670;</s></span></div>';
                    o.obj.after(htmlstrs);
                    infoObj = o.obj.next('.Validform_info');
                    objtip = o.obj.next('.Validform_checktip');
                }

                cssctl(objtip, o.type);
                objtip.text(msg);

                if ($.trim(infoObj.children('.Validform_checktip').text()) == '') {
                    infoObj.children('.Validform_checktip').html(msg);
                }

                if (o.obj.attr('errorid') == undefined) {
                    infoObj.children('.Validform_checktip').html(msg);
                }

                //定位
                if (o.type == 2) {
                    infoObj.fadeOut(100);
                } else {
                    if (infoObj.is(":visible")) {
                        return;
                    }
                    var left = o.obj.position().left, top = o.obj.position().top;

                    if (o.obj[0].type == 'select-one') {
                        left = o.obj.parent().position().left, top = o.obj.parent().position().top;
                    }

                    infoObj.css({
                        left: left + 60,
                        top: top - 45
                    }).show().animate({
                        top: top - 35
                    }, 100);
                }

            }
        }
    });
}
function clearValidformErrorInfo(options) {
    $(options.form).find('.Validform_checktip').each(function () {

        $(this).parent().hide();
    });
    $(options.form).find('.Validform_error').each(function () {
        $(this).removeClass("Validform_error");
    });
}