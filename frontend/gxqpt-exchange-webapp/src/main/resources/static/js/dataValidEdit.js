$(function(){
    //正则校验规则
    function require(val){//非空判断
        if(val){
            return true;
        }else{
            return false;
        }
    };
    function number(val){//判断是否为数字
        var reg =/^\d+(\.\d+)?$/ ;
        if (!reg.test(val)) {
            return false;
        } else {
            return true;
        }
    };
    function integer(val){//判断是否为整数
        var reg = /^-?\\d+$/;
        if (!reg.test(val)) {
            return false;
        } else {
            return true;
        }
    };
    function sex(val){//判断性别
        if (val=="男" || val=="女") {
            return true;
        } else {
            return false;
        }
    };
    function email(val){//判断email地址
        var reg = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        if (!reg.test(val)) {
            return false;
        } else {
            return true;
        }
    };
    function url(val){//判断网址
        var reg = /^(\w+:\/\/)?\w+(\.\w+)+.*$/;
        if (!reg.test(val)) {
            return false;
        } else {
            return true;
        }
    };
    function mobile(val){//判断手机号码
        var reg = /^13[0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}$/;
        if (!reg.test(val)) {
            return false;
        } else {
            return true;
        }
    };
    function idcard(gets){//判断身份证号
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
    };

    //获取数据集列表
    function querySetData(){
        var dataDto = {
            "data": setId,
            "pageNo": pageNo,
            "pageSize": 10
        };
        ajaxHengyun({
            type: "POST",
            dataType: 'json',
            contentType: 'application/json',
            url: _gateUrl+"/api/exchange/set/querySetData",
            data: JSON.stringify(dataDto),
            success: function (res) {
                if(res.data){
                    var html = "";
                    res.data.dataList.list.forEach(function(val,index){
                        if(val.key_id==keyId){
                            res.data.fieldName.forEach(function(rows,num){
                                var isTextArea = false;
                                for(var key in val){
                                    if(key=="key_id"){
                                        html+='<tr style="display: none;">';
                                        html+='<th width="120">'+key+'：</th>';
                                        html+='<td>';
                                        html+='<input type="text" name="'+key+'" class="form-control" value="'+val[key]+'"/>';
                                        html+='</td>';
                                        html+='</tr>';
                                    }
                                    var laberVal = "";
                                    if(rows.fieldCode==key){
                                        if(rows.fieldType=="text"){
                                            isTextArea=true;
                                        }
                                        laberVal = val[key];
                                        if(!laberVal){
                                            laberVal = "";
                                        };
                                        html+='<tr>';
                                        html+='<th width="120">'+rows.fieldCode+'：</th>';
                                        html+='<td>';
                                        if(isTextArea){
                                            html+='<textarea id="reason" name="'+rows.fieldCode+'" rows="5" cols="" class="form-control">'+laberVal+'</textarea>';
                                        }else{
                                            html+='<input type="text" name="'+rows.fieldCode+'" class="form-control" value="'+laberVal+'"/>';
                                        }
                                        html+='</td>';
                                        html+='</tr>';
                                    }
                                }
                            });
                        }
                    });
                    $("#validEdit tbody").html(html);
                }
            }
        });
    };

    function init(){
        querySetData();
    };

    init();
});
function save(index){
    var gxqptDutiesDTO =$("#dataForm").serializeJSON();
    var dataDto={
        "deleteIdList": [],
        "setId": setId,
        "updateObjList": [gxqptDutiesDTO]
    };
    ajaxHengyun({
        type: "POST",
        dataType: 'json',
        contentType: 'application/json',
        url: _gateUrl+"/api/exchange/set/updateWareHouseData",
        data: JSON.stringify(dataDto),
        success: function (res) {
            if (res.data) {
                dataDto={
                    "deleteIdList": [],
                    "setId": setId,
                    "updateObjList": []
                };
                parent.layer.msg("编辑成功！",{time:3000});
                parent.home.reloadPage();
                parent.layer.close(index);
            }else{
                parent.layer.msg(res.errmsg+"，请重试！",{time:3000});
            }
        }
    });
}