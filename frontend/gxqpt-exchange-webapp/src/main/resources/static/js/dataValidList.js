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
var parm = {
    "data": setId,
    "pageNo": 1,
    "pageSize": 10
};
function getList(parm){
    ajaxHengyun({
        type: "POST",
        dataType: 'json',
        contentType: 'application/json',
        url: _gateUrl+"/api/exchange/set/querySetData",
        data: JSON.stringify(parm),
        success: function (res) {
            if (res.data) {
                if(res.data.fieldName){
                    var html="<tr>";
                    res.data.fieldName.forEach(function(val,index){
                        html+='<th>'+val.fieldCode+"</th>";
                    });
                    html+='<th>操作</th>';
                    $("#systemList thead").html(html);
                }
                if(res.data.dataList.list){
                    var htmlTbody = "";
                    res.data.dataList.list.forEach(function(row,num){
                        var htmlTr="";
                        var thEle = $("#systemList thead th");
                        var isValidPassNum = 0;
                        thEle.each(function(n,thEle){
                            var thCode = $(thEle).text();
                            for(var key in row){
                                var isValidPass = true;
                                if(key==thCode){
                                    res.data.eles.forEach(function(elesRow,x){
                                        var ruleCodes = elesRow.ruleCodes;
                                        if(key==elesRow.elementName){
                                            ruleCodes.forEach(function(ruleCodesRow,y){
                                                switch (ruleCodesRow){
                                                    case "1":
                                                        isValidPass = require(row[key]);
                                                        break;
                                                    case "2":
                                                        isValidPass = number(row[key]);
                                                        break;
                                                    case "3":
                                                        isValidPass = integer(row[key]);
                                                        break;
                                                    case "4":
                                                        isValidPass = sex(row[key]);
                                                        break;
                                                    case "5":
                                                        isValidPass = idcard(row[key]);
                                                        break;
                                                    case "6":
                                                        isValidPass = mobile(row[key]);
                                                        break;
                                                    case "7":
                                                        isValidPass = email(row[key]);
                                                        break;
                                                    case "8":
                                                        isValidPass = url(row[key]);
                                                        break;
                                                }
                                                if(!isValidPass){
                                                    isValidPassNum+=1;
                                                    return false;
                                                }
                                            })
                                        }
                                    });
                                    if(!row[key]){
                                        row[key]="";
                                    }
                                    htmlTr+='<td class="'+key+'" title="'+row[key]+'"><p style="max-width: 240px;">'+row[key]+'</p></td>';
                                }
                            }
                        });
                        if(isValidPassNum>0){
                            htmlTr+='<td class="errorData actTd" width="150">\n' +
                                '<a href="javascript:" class="editBtn">编辑</a>\n' +
                                // '<a href="javascript:" class="ignoreBtn">忽略</a>\n' +
                                '<a href="javascript:" class="deleteBtn">删除</a>\n' +
                                '</td>';
                            htmlTbody+="<tr class='errorData' data-keyId='"+row.key_id+"'>";
                            htmlTbody+=htmlTr;
                        }else{
                            htmlTr+='<td></td>';
                            htmlTbody+="<tr data-keyId='\"+row.key_id+\"'>";
                            htmlTbody+=htmlTr;
                        }

                        htmlTbody+="</tr>";
                    });
                    $("#systemList tbody").html(htmlTbody);
                    $('#totalPages').text(res.data.dataList.pages);
                    $('.total').text(res.data.total);
                    jqPaginator(res.data.dataList);
                }else{
                    var length =res.data.fieldName.length+1;
                    var htmlTbody = "<tr><td class='text-left' colspan='"+length+"' >暂无数据</td></tr>";
                    $("#systemList tbody").html(htmlTbody);
                    $(".pagination,.currentPage").css("display","none");
                }
                updateIformHeight();
            }else{
                $(".pagination,.currentPage").css("display","none");
                parent.layer.msg(res.errmsg+"，请重试！",{time:3000});
            }
        }
    });
};

$("body").on("click",".goBack",function(){//上一步
    window.location.href = _cp+'/module/dataSetDataValid?id='+setId;
});
var dataDto={
    "deleteIdList": [],
    "setId": setId,
    "updateObjList": []
};

/*function editDataValid(gxqptDutiesDTO){//编辑成功后调用方法
    var editDataTrEle = $("#systemList tbody tr");
    editDataTrEle.each(function(trNo,editDataTrEleRow){
        var trKyeIdVal = $(editDataTrEleRow).attr("data-keyid");
        if(trKyeIdVal==gxqptDutiesDTO.key_id){
            for(var keyName in gxqptDutiesDTO){
                var tdEditEle = $(editDataTrEleRow).find("."+keyName);
                if(tdEditEle){
                    $(tdEditEle).text(gxqptDutiesDTO[keyName]);
                }
            }
            $(editDataTrEleRow).find(".actTd").empty();
            $(editDataTrEleRow).find("td").removeClass("errorData");
        }
    });
    dataDto.updateObjList.push(gxqptDutiesDTO);
}*/


$("body").on("click",".editBtn",function(){//编辑
    var trEle = $(this).parent().parent();
    var keyId = $(trEle).attr("data-keyid");
    var pageNo = $("#pageNum").text();
    parent.layer.open({
        id: 'validDataEdit',
        type: 2,
        anim:6,
        title: '数据修改',
        maxmin: false, //开启最大化最小化按钮
        area: ['750px', '560px'],
        shade: [0.5, '#000'],
        content: _cp+"/module/dataSetDataValidEdit?id="+keyId+"&setId="+setId+"&pageNo="+pageNo,
        btn: ['<span class="glyphicon glyphicon-ok"></span> 确定','<span class="glyphicon glyphicon-remove"></span> 关闭'],
        yes: function (index, layero) {
            var html=layero.context;
            var Id=html.getElementById("validDataEdit");
            var iframe=$(Id).find("iframe").attr("name");
            var rowData = top[iframe].save(index);
        }
    });
});

/*$("body").on("click",".ignoreBtn",function(){//忽略
    var _this = this;
    var tdEle = $(this).parent().parent().find("td");
    parent.layer.confirm("您确定要忽略该条信息吗？",{
        title:'温馨提示',
        shade: [0.4,'#000'],
        btn: ['确定','取消'] //按钮
    }, function(index){
        $(_this).parent().empty();
        tdEle.each(function(a,tdRow){
            $(tdRow).removeClass("errorData");
        });
        parent.layer.close(index);
    });
});*/

$("body").on("click",".deleteAll",function(){//一键删除
    var trEle = $("#systemList tbody tr");
    trEle.each(function(itemNo,deleteAllItem){
        var isErrorData = $(deleteAllItem).find(".actTd").hasClass("errorData");
        if(isErrorData){
            var keyId = $(trEle).eq(itemNo).attr("data-keyid");
            dataDto.deleteIdList.push(keyId);
        }
    });
    if(dataDto.deleteIdList.length==0){
        return false;
    }
    parent.layer.confirm("删除后将不能恢复，您确定要删除该条信息吗？",{
        title:'温馨提示',
        shade: [0.4,'#000'],
        btn: ['确定','取消'] //按钮
    }, function(index){
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
                    parent.layer.msg("删除成功！",{time:3000});
                    parent.home.getList(parm);
                    parent.layer.close(index);
                }else{
                    parent.layer.msg(res.errmsg+"，请重试！",{time:3000});
                }
            }
        });
    });
});


$("body").on("click",".deleteBtn",function(){//删除
    var trEle = $(this).parent().parent();
    var keyId = $(trEle).attr("data-keyid");
    parent.layer.confirm("删除后将不能恢复，您确定要删除该条信息吗？",{
        title:'温馨提示',
        shade: [0.4,'#000'],
        btn: ['确定','取消'] //按钮
    }, function(index){
        dataDto.deleteIdList.push(keyId);
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
                    parent.layer.msg("删除成功！",{time:3000});
                    parent.home.getList(parm);
                    parent.layer.close(index);
                }else{
                    parent.layer.msg(res.errmsg+"，请重试！",{time:3000});
                }
            }
        });
    });
});

function reloadPage(){
    getList(parm);
};

$("body").on("click",".saveBtn",function(){//保存
    window.location.href = _cp+'/module/dataSetManageList?pageNo=1';
    /*ajaxHengyun({
        type: "POST",
        dataType: 'json',
        contentType: 'application/json',
        url: _gateUrl+"/api/exchange/set/updateWareHouseData",
        data: JSON.stringify(dataDto),
        success: function (res) {
            if (res.data) {
                window.location.href = _cp+'/module/dataSetManageList?pageNo=1';
            }else{
                parent.layer.msg(res.errmsg+"，请重试！",{time:3000});
            }
        }
    });*/
});


function init(){
    getList(parm)
};

init();