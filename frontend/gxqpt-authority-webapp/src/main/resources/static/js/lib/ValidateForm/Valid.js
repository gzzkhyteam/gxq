/**
 * Created by D on 2016/12/6.
 * 夏金晶 2016年12月6日
 */
$.fn.valid = function (options) {

    $(options.form).keydown(function (e) {
        if(e.keyCode == 13){
            e.preventDefault();//取消点击enter键自动触发提交操作
        }
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

    var btns = '';
    if ($(this).size() == 1) {
        //btns = "#" + $(this)[0].id;
        btns = $(this);
        //var xx=$(this)[0];
    } else if ($(this).size() > 1) {
        for (var i = 0; i < $(this).size(); i++) {
            btns += "#" + $(this)[i].id + ","
        }
        btns = btns.substring(0, btns.length - 1);
    }

    $(options.form).Validform({
        btnSubmit: btns,
        showAllError: options.showAllError,
        beforeSubmit: options.checkpassed,
        ignoreHidden: true,//当为true时对hidden的表单元素将不做验证
        postonce: options.postonce,//防止重复提交
        //dragonfly: true,//当为true时，值为空时不做验证
        tiptype: function (msg, o, cssctl) {
            //msg：提示信息;
            //o:{obj:*,type:*,curform:*}, obj指向的是当前验证的表单元素（或表单对象），
            //type指示提示的状态，值为1、2、3、4， 1：正在检测/提交数据，2：通过验证，3：验证失败，4：提示ignore状态,
            //curform为当前form对象;
            //cssctl:内置的提示信息样式控制函数，该函数需传入两个参数：显示提示信息的对象 和 当前提示的状态（既形参o中的type）;

        	if(msg){
        		var index = msg.indexOf("请填写0到");
        		if(index >= 0){
        			msg = "最大不超过"+msg.substring(index+"请填写0到".length,1000);
        		}
        	}
        	
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
                    if(!msg){
                        infoObj.css("display","none")
                    }else{
                        infoObj.css({
                            left: left + 60,
                            top: top - 45
                        }).show().animate({
                            top: top - 35
                        }, 100);
                    }
                }

            }
        }
        , datatype: {//传入自定义datatype类型，可以是正则，也可以是函数（函数内会传入一个参数）;
            "idcard":function(gets,obj,curform,datatype){
                //该方法由佚名网友提供;

                var Wi = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 ];// 加权因子;
                var ValideCode = [ 1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 ];// 身份证验证位值，10代表X;

                if (gets.length == 15) {
                    return isValidityBrithBy15IdCard(gets);
                }else if (gets.length == 18){
                    var a_idCard = gets.split("");// 得到身份证数组
                    if (isValidityBrithBy18IdCard(gets)&&isTrueValidateCodeBy18IdCard(a_idCard)) {
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
                    for ( var i = 0; i < 17; i++) {
                        sum += Wi[i] * a_idCard[i];// 加权求和
                    }
                    valCodePosition = sum % 11;// 得到验证码所位置
                    if (a_idCard[17] == ValideCode[valCodePosition]) {
                        return true;
                    }
                    return false;
                }

                function isValidityBrithBy18IdCard(idCard18){
                    var year = idCard18.substring(6,10);
                    var month = idCard18.substring(10,12);
                    var day = idCard18.substring(12,14);
                    var temp_date = new Date(year,parseFloat(month)-1,parseFloat(day));
                    // 这里用getFullYear()获取年份，避免千年虫问题
                    if(temp_date.getFullYear()!=parseFloat(year) || temp_date.getMonth()!=parseFloat(month)-1 || temp_date.getDate()!=parseFloat(day)){
                        return false;
                    }
                    return true;
                }

                function isValidityBrithBy15IdCard(idCard15){
                    var year =  idCard15.substring(6,8);
                    var month = idCard15.substring(8,10);
                    var day = idCard15.substring(10,12);
                    var temp_date = new Date(year,parseFloat(month)-1,parseFloat(day));
                    // 对于老身份证中的你年龄则不需考虑千年虫问题而使用getYear()方法
                    if(temp_date.getYear()!=parseFloat(year) || temp_date.getMonth()!=parseFloat(month)-1 || temp_date.getDate()!=parseFloat(day)){
                        return false;
                    }
                    return true;
                }

            },
            "dec": function (gets, obj, curform,  regxp) {
                //var reg = /^[\u4E00-\u9FA5\uf900-\ufa2d\w\.\s]{4,12}$/;
                var reg = /^-?[1-9]+(\.\d+)?$|^-?0(\.\d+)?$|^-?[1-9]+[0-9]*(\.\d+)?$/;
                if (!reg.test(gets)) {
                    return false;
                } else {
                    return true;
                }
            },
            "integeP": function (gets, obj, curform, regxp) {
                var reg = /^([1-9]\d*|[0]{1,1})$/;
                if (!reg.test(gets)) {
                    return false;
                } else {
                    if(Number(gets) > 2147483647){
                        return false;
                    }
                    return true;
                }
            },

            "integeMax": function (gets, obj, curform, regxp) {
                var reg = /^[0-9]\d*$/;
                if (!reg.test(gets)) {
                    return false;
                } else {
                    if(Number(gets) > 10000){
                        return false;
                    }
                    return true;
                }
            },

            "positive": function (gets, obj, curform, regxp) {
                var reg = /^[1-9]\\d*|0$/;
                if (!reg.test(gets)) {
                    return false;
                } else {
                    return true;
                }
            },

            "zh": function (gets, obj, curform, regxp) {
                //var reg = /^[\u4E00-\u9FA5\uf900-\ufa2d\w\.\s]{4,12}$/;
                var reg = /^[\u4E00-\u9FA5]+[\u4E00-\u9FA5]?$/;
                if (!reg.test(gets)) {
                    return false;
                } else {
                    return true;
                }
            },
            'phone':function (gets,obj,curform,regxp) {
                //输入0-20的数字
                var reg = /^\d+[\d-]*\d+$/;
                if(reg.test(gets)){
                    return true;
                }else{
                    return false;
                }
            },
            // 昵称只能是数字字母下划线
            'nickname': function(gets,obj,curform,regxp) {
                if(!gets){
                    return false;
                }
                var reg = /^[a-zA-Z0-9_]*$/;
                if(reg.test(gets)){
                    return true;
                }else{
                    return false;
                }
            },
            // 数据范围
            "range0to2147483647": function(gets,obj,curform,regxp) {
                if(gets < 0 || gets > 2147483647){
                    return false;
                }
                return true
            },
            // 数据范围
            "range0to2147483647": function(gets,obj,curform,regxp) {
                if(gets < 0 || gets > 2147483647){
                    return false;
                }
                return true
            },
            "numRange": function(gets,obj,curform,regxp) {  //验证数字范文的    格式为：    dataType="...,numRange,*0-522,......"   代表验证的数据范围是0-522
            	
            	var dataType = $(obj).attr("dataType");
            	var dataTypes = dataType.split(",");
            	var index = 0 ;
            	for(index=0; index < dataTypes.length; index++){
            		if(dataTypes[index].trim() == "numRange"){
            			index++;
            			break;
            		}
            	}
            	var rangeNum = dataTypes[index].trim().substr(1);
            	var value = rangeNum.split("-");
            	if(parseFloat(value[0]) > gets || gets > parseFloat(value[1])){
            		return false;
            	}
            	return true;
            }
        }
    });
};