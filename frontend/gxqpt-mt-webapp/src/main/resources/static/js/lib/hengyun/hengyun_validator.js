//使用闭包，避免与外部函数有命名冲突

(function (){
//////////////////////加载及显示验证信息///////////////////////////
var projectPrefixs = ["api/admin/","api/mt/","api/clientVersion/"];
/**
 * 开启恒运校验体系
 * 校验规则向后端服务器拉取，保持与后端服务器的校验规则一致，使得修改校验的时候，仅仅需要修改一个地方即可
 * @param ajaxSetting      ajax配置文件，这里ajaxSetting是提交表单的ajaxSetting，就是共用你提交表单的ajaxSetting。我会将他修改成验证表单提交的ajaxSetting。你的表单提交ajaxSetting怎么写的  这里就是什么。
 * @param fromParentElem   表单作用域（jquery选择器），我在设置验证信息的时候，需要有一个作用域。
 * @param selectorSetting  选择器配置：{attrName:"name",refix:"",suffix:""}这个是默认配置。 
 * 							attrName：表示在表单中的属性名称，列如：<br>
 * 									    &lt;input id="name" &gt; 那么你的attrName是id<br>
 * 										&lt;input name="name" &gt; 那么你的attrName是name<br>
 * 										&lt;input ng-model="name" &gt; 那么你的attrName是ng-model<br>
 * 							refix： 前缀   前缀列子&lt;input ng-model="app.name" &gt;   那么你的refix就是app.<br>
 * 							suffix： 后缀  后缀列子&lt;input ng-model="nameXX" &gt;   那么你的refix就是XX<br>
 * @param callbackValidatorRuleConfig   规则配置回调地址，可以不填写，默认支持ValidateForm
 * @returns
 */
function openValidator(ajaxSetting,fromParentElem,selectorSetting,callbackValidatorRuleConfig){
	var ajaxSettingCopy = copy(ajaxSetting);
	
	ajaxSettingCopy["success"] = validatorLoadSuccess;
	ajaxSettingCopy["data"] = null;
	ajaxSettingCopy["dataType"] = "json";
	ajaxSettingCopy["url"] = builderValidatorUrl(ajaxSettingCopy["url"]);
	ajaxSettingCopy["fromParentElem"] = fromParentElem;
	ajaxSettingCopy["selectorSetting"] = formatterSelectorSetting(selectorSetting);

	if(callbackValidatorRuleConfig){
		ajaxSettingCopy["callbackValidatorRuleConfig"] = callbackValidatorRuleConfig;
	} else {
		ajaxSettingCopy["callbackValidatorRuleConfig"] = defaultCallbackValidatorRuleConfig;
	}
	ajaxHengyun(ajaxSettingCopy);
}

function formatterSelectorSetting(selectorSetting){
	
	var formatterSetting = {
							attrName:"name",
							prefix:"",
							suffix:""
						};
	if(!selectorSetting){
		return formatterSetting;
	}
	for(var key in formatterSetting){
		
		if(selectorSetting[key]){
			formatterSetting[key] = selectorSetting[key];
		}
	}
	return formatterSetting;
}

function validatorLoadSuccess(rows){
	
	if(!rows || rows.length == 0){
		return ;	
	}

	
	addValidtor(this.fromParentElem,this.selectorSetting,this.callbackValidatorRuleConfig,rows);
}

function addValidtor(parentEle,selectorSetting,callbackValidatorRuleConfig,constraints){
	
	var $parentEle = $(parentEle);
	for(var i in constraints){
		
		var constraint = constraints[i];
		var name = constraint.fieldName;
		var constraintText = "";
		for(var j in constraint.constraints){
			
			constraintText += getDesc(constraint.constraints[j],constraint.fieldType);
		}
		var selector = selectorSetting.attrName+"='"+selectorSetting.prefix+name+selectorSetting.suffix+"'";
		var customPlaceholder = $parentEle.find("["+selector+"]").attr("placeholder");
		if(notEmpty(customPlaceholder)){
			constraintText = customPlaceholder + "(" + constraintText+")";
		}
		$parentEle.find("["+selector+"]").attr("placeholder",constraintText);
		callbackValidatorRuleConfig($parentEle.find("["+selector+"]"),constraint);
	}
}

function getDesc(constraint,fieldType){
	
	if(fieldType == "string" && constraint.type == "range"){
		return "最大长度"+constraint.attrs.max;
	}
	if(fieldType == "int" && constraint.type == "range"){
		return "最大值是：  "+constraint.attrs.max;
	}
	if(fieldType == "double" && constraint.type == "range"){
		return "最大值是："+constraint.attrs.max;
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
	
	var dataTypes = "";
	for(var j in constraint.constraints){
		var dataType = null;
		switch(constraint.fieldType){
		    case "string": dataType =stringValidatorRuleConfig(constraint.constraints[j]) ;break;
		    case "int": dataType =numberValidatorRuleConfig(constraint.constraints[j]) ;break;
		    case "double": dataType =doubleValidatorRuleConfig(constraint.constraints[j]) ;break;
		    case "date": dataType = dateValidatorRuleConfig(constraint.constraints[j]) ;break;
		    default : dataType = ortherValidatorRuleConfig(constraint.constraints[j]);break;
		}
		if(dataType){
			dataTypes += dataType + ",";
		}
	}
	
	dataTypes = removeLastChar(dataTypes,",");
	if(dataTypes.length > 0){
		var customRule = jqueryElem.attr("dataType");
		if(notEmpty(customRule)){
			dataTypes = customRule + "," + dataTypes;
		}
		jqueryElem.attr("dataType",dataTypes);
	}
}

function notEmpty(str){
	
	return str && str.length > 0 ;
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
	return null;
}
//整数校验规则
function numberValidatorRuleConfig(constraint){
	
	
	if(constraint.type == "notNull"){
		return "*,/\\d+/";
	}
	return null;
}
/**
 * 浮点数（小数）校验规则
 * @param constraint
 * @returns
 */
function doubleValidatorRuleConfig(constraint){
	
	if(constraint.type == "notNull"){
		return "*,/^\\d+\\.?\\d*$/";
	}
	return null;
}
//时间校验规则
function dateValidatorRuleConfig(constraint){
	
	if(constraint.type == "notNull"){
		return "*";
	}
	return null;
}
//除了上面以为的其他类型的校验规则
function ortherValidatorRuleConfig(constraint){
	
	if(constraint.type == "notNull"){
		return "*";
	}
	return null;
}

window.openValidator = openValidator;

})();