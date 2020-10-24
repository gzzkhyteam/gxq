$(function(){
    function getValidField(valId,isRead){
        var html = "";
        html+='<select name="status" class="chosen-select dataValidType"';
        if(!isRead){
            html+='disabled';
        };
        html+='>';
        html+='<option value="-1"';
        if(valId=="-1"){
            html+="selected";
        };
        html+='>请选择</option>';
        html+='<option value="1"';
        if(valId=="1"){
            html+="selected";
        };
        html+='>非空验证</option>';
        html+='<option value="2"';
        if(valId=="2"){
            html+="selected";
        };
        html+='>数字</option>';
        html+='<option value="3"';
        if(valId=="3"){
            html+="selected";
        };
        html+='>整数</option>';
        html+='<option value="4"'
        if(valId=="4"){
            html+="selected";
        };
        html+='>性别</option>';
        html+='<option value="5"';
        if(valId=="5"){
            html+="selected";
        };
        html+='>身份证</option>';
        html+='<option value="6"';
        if(valId=="6"){
            html+="selected";
        };
        html+='>手机号码</option>';
        html+='<option value="7"';
        if(valId=="7"){
            html+="selected";
        };
        html+='>邮箱地址</option>';
        html+='<option value="8"';
        if(valId=="8"){
            html+="selected";
        };
        html+='>网址</option>';
        html+='</select>';
        return html;
    };

    $("body").on("click",".dataValidType",function(event){
        event.stopPropagation();
    });

    $("body").on("click",".dataValidAdd",function(event){
        event.stopPropagation();
        var inputEle = $(this).parent().parent().find("input[type='checkbox']");
        var isSet = $(inputEle).prop("checked");
        if(!isSet){
            parent.layer.msg("请选中后再进行规则设置！",{time:3000});
            return false;
        };
        var num = $(this).parent().find(".dataValidItem").length+1;
        var html = "";
        html+='<div class="pull-left dataValidItem">';
        html+='<label>校验规则<span class="dataValidNum">'+num+'</span>：</label> ';
        html+=getValidField("-1","write");
        html+=' <i class="fa fa-remove dataValidRemove" title="删除校验规则"></i>';
        html+='</div>';
        $(this).before(html);
    });
    $("body").on("click",".dataValidRemove",function(event){
        event.stopPropagation();
        var tdObj = $(this).parent().parent();
        $(this).parent().remove();
        var dataValidNumObj = $(tdObj).find(".dataValidNum");
        if($(dataValidNumObj).length>0){
            $(dataValidNumObj).each(function(index,value){
               $(value).text(index+2);
            });
        }
    });
    $("body").on("click","#databaseTab tbody tr",function(event){
        var inputEle = $(this).find("input[type='checkbox']");
        var selectEle = $(this).find("select");
        var isSet = $(inputEle).prop("checked");
        if(!isSet){
            $(inputEle).prop("checked",true);
            selectEle.each(function(index,ele){
                $(ele).removeProp("disabled");
            })
        }else{
            $(inputEle).removeProp("checked");
            selectEle.each(function(index,ele){
                $(ele).prop("disabled",true);
            })
        }
    });
    $("body").on("click","#databaseTab tbody td input",function(event){
        if($(this).prop("checked")){
            $(this).removeProp("checked");
        }else{
            $(this).prop("checked",true);
        }
    });
    $("#nextPageBtn").click(function(){
        save();
    });

    //获取数据集字段
    function getSetRule(){
        ajaxHengyun({
            type: "GET",
            url: _gateUrl+"/api/exchange/set/getSetRule",
            data: {setId:setId},
            success: function (res) {
                if (res.data) {
                    var setList = res.data.eles;
                    if(setList.length>0){
                        var html="";
                        setList.forEach(function(val,index){
                            html+='<tr>';
                            html+='<td class="paddTop"><input type="checkbox" value="'+val.elementId+'" data-name="'+val.elementName+'"';
                            if(val.ruleCodes.length>0){
                                html+='checked';
                            };
                            html+='/></td>';
                            html+='<td class="paddTop">'+val.elementName+'</td>';
                            html+='<td>';
                            if(val.ruleCodes.length>0){
                                val.ruleCodes.forEach(function(val,index){
                                    html+='<div class="pull-left dataValidItem">';
                                    html+='<label>校验规则'+(index+1)+'：</label>';
                                    html+=getValidField(val,"write");
                                    html+='</div>';
                                });
                            }else {
                                html+='<div class="pull-left dataValidItem">';
                                html+='<label>校验规则1：</label>';
                                html+=getValidField("-1","");
                                html+='</div>';
                            }
                            html+='<i class="fa fa-plus-circle dataValidAdd" title="添加校验规则" ></i>';
                            html+='</td>';
                            html+='</tr>';
                        });
                        $("#databaseTab tbody").html(html);
                        updateIformHeight();
                        $("#nextPageBtn").removeProp("disabled");
                    }
                }else{
                    parent.layer.msg(res.errmsg+"，请重试！",{time:3000});
                }
            }
        });
    };

    function save(){
        var dataDto = {
            "eles": [],
            "setId": setId
        };
        var trArray = $("#databaseTab tbody tr");
        var ruleCodesLength = true;
        trArray.each(function(index,val){
            var obj = {
                "elementId":"",
                "elementName": "",
                "ruleCodes": []
            };
            var inputEle = $(val).find("input[type='checkbox']");
            var isSet = $(inputEle).prop("checked");
            if(isSet){
                obj.elementId=$(inputEle).val();
                obj.elementName=$(inputEle).attr("data-name");
                var setEle = $(val).find("select");
                setEle.each(function(num,rows){
                    if($(rows).val()!="-1"){
                        obj.ruleCodes.push($(rows).val())
                    }
                });
                if(obj.ruleCodes.length==0){
                    parent.layer.msg("请设置字段\""+obj.elementName+"\"的校验规则！",{time:3000});
                    ruleCodesLength = false;
                    return false;
                }
                dataDto.eles.push(obj);
            }
        })
        if(!ruleCodesLength){
            return false;
        };
        ajaxHengyun({
            type: "POST",
            dataType: 'json',
            contentType: 'application/json',
            url: _gateUrl+"/api/exchange/set/saveSetRule",
            data: JSON.stringify(dataDto),
            success: function (res) {
                if (res.data) {
                    window.location.href = _cp+'/module/dataSetDataValidList?id='+setId;
                }else{
                    parent.layer.msg(res.errmsg+"，请重试！",{time:3000});
                }
            }
        });
    }
    
    function init() {
        getSetRule();
    }

    init();
});