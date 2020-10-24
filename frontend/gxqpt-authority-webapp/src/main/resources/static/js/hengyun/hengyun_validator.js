//////////////////////加载及显示验证信息///////////////////////////
var projectPrefixs = ["api/admin/","api/deployer/"];
/**
 * 开启恒运校验体系
 * 校验规则向后端服务器拉取，保持与后端服务器的校验规则一致，使得修改校验的时候，仅仅需要修改一个地方即可
 * @param setting   ajax配置文件，这里setting是提交表单的setting，就是共用你提交表单的setting。我会将他修改成验证表单提交的setting。你的表单提交setting怎么写的  这里就是什么。
 * @param fromParentElem   表单作用域（jquery选择器），我在设置验证信息的时候，需要有一个作用域。
 * @param callbackValidatorRuleConfig   规则配置回调地址，可以不填写，默认支持ValidateForm
 * @returns
 */
function openValidator(setting,fromParentElem,callbackValidatorRuleConfig){
	
	var settingCopy = copy(setting);
	
	settingCopy["success"] = validatorLoadSuccess;
	settingCopy["data"] = null;
	settingCopy["dataType"] = "json";
	settingCopy["url"] = builderValidatorUrl(settingCopy["url"]);
	settingCopy["fromParentElem"] = fromParentElem;
	if(callbackValidatorRuleConfig){
		settingCopy["callbackValidatorRuleConfig"] = callbackValidatorRuleConfig;
	} else {
		settingCopy["callbackValidatorRuleConfig"] = defaultCallbackValidatorRuleConfig;
	}
	ajaxHengyun(settingCopy);
}

function validatorLoadSuccess(rows){
	
	if(!rows || rows.length == 0){
		return ;	
	}

	
	addValidtor(this.fromParentElem,this.callbackValidatorRuleConfig,rows);
}

function addValidtor(parentEle,callbackValidatorRuleConfig,constraints){
	
	var $parentEle = $(parentEle);
	for(var i in constraints){
		
		var constraint = constraints[i];
		var name = constraint.fieldName;
		var constraintText = "";
		for(var j in constraint.constraints){
			
			constraintText += getDesc(constraint.constraints[j],constraint.fieldType);
		}
		$parentEle.find("[name='"+name+"']:visible").attr("placeholder",constraintText);
		callbackValidatorRuleConfig($parentEle.find("[name='"+name+"']:visible"),constraint);
	}
}

function getDesc(constraint,fieldType){
	
	if(fieldType == "string" && constraint.type == "range"){
		return "最大长度"+constraint.attrs.max;
	}
	return "";
}

function copy(obj){
	
	var copyObj = {};
	for ( var key in obj) {
		copyObj[key] = obj[key];
	}
	return copyObj;
}

function builderValidatorUrl(url){
	
	for(var i in projectPrefixs){
		var index = url.indexOf(projectPrefixs[i]);
		if(index < 0){
			continue ;
		}
		return  url.substring(0,index + projectPrefixs[i].length) + "from/validator/" + url.substring(index + projectPrefixs[i].length);
	}
}

//////////////////////校验规则配置   有默认规则   可以被覆盖///////////////////////////
function defaultCallbackValidatorRuleConfig(jqueryElem,constraint){
	
	var dataType = "";
	for(var j in constraint.constraints){

		switch(constraint.fieldType){
		    case "string": dataType +=stringValidatorRuleConfig(constraint.constraints[j]) + ",";break;
		    case "number": dataType +=numberValidatorRuleConfig(constraint.constraints[j]) + ",";break;
		    case "date": dataType += dateValidatorRuleConfig(constraint.constraints[j]) + ",";break;
		    default : dataType += ortherValidatorRuleConfig(constraint.constraints[j]) + ",";break;
		}
	}
	
	dataType = removeLastChar(dataType,",");
	if(dataType.length > 0){
		jqueryElem.attr("dataType",dataType);
	}
}
function removeLastChar(str,removeChar){
	
	if(!str || str.length == 0 || str.charAt(str.length-1) != removeChar){
		return str;
	}
	return removeLastChar(str.substring(0,str.length-1),removeChar);
}

//字符串长度验证规则
function stringValidatorRuleConfig(constraint){
	
	if(constraint.type == "range"){
		return "*0-"+constraint.attrs.max;
	}
	
	if(constraint.type == "notNull"){
		return "*";
	}
	return "";
}
//数字校验规则
function numberValidatorRuleConfig(constraint){
	
	if(constraint.type == "range"){
		return "n0-"+constraint.attrs.max;
	}
	
	if(constraint.type == "notNull"){
		return "*";
	}
	return "";
}
//时间校验规则
function dateValidatorRuleConfig(constraint){
	
	if(constraint.type == "notNull"){
		return "*";
	}
	return "";
}
//除了上面以为的其他类型的校验规则
function ortherValidatorRuleConfig(constraint){
	
	if(constraint.type == "notNull"){
		return "*";
	}
	return "";
}