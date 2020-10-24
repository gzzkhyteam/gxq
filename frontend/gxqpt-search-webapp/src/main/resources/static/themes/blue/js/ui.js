/**
 * 恒运贵阳分公司UI 1.0.0
 * @param $
 */

var ErrorCode = {
		0:"操作成功",
		1:"操作失败"
};

var isIEBrowser = function() {
	return !!(navigator.userAgent.indexOf("MSIE ") > 0 || !!navigator.userAgent
			.match(/Trident.*rv\:11\./));
};

var escapeHTML = function(text) {
	if (typeof text === 'string') {
		return text.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g,
				'&gt;').replace(/"/g, '&quot;').replace(/'/g, '&#039;')
				.replace(/`/g, '&#x60;');
	}
	return text;
};

/**
 * jqGrid method
 */

/**
 * 在url上附加参数
 * @param url
 */
var appendUrlParam = function(url,paramString) {
	if(!url || !paramString) {
		return;
	}

	var r = url;
	if(url.indexOf('?')>-1) {
		r+="&"+paramString;
	} else {
		r+="?"+paramString;
	}
	
	return r;
};


(function($){
	
	
	/**
	 * 序列化表单
	 */
	$.fn.serializeObject = function() {
    	var o = {};
    	var a = this.serializeArray();
    	$.each(a, function() {
    		if (o[this.name]) {
    			if (!o[this.name].push) {
    				o[this.name] = [ o[this.name] ];
    			}
    			o[this.name].push(this.value || '');
    		} else {
    			o[this.name] = this.value || '';
    		}
    	});
    	return o;
    };
    
	$(function() {
		
		/**
		 * 注册菜单点击事件
		 */
		$('.nav-item').click(function() {
			var _b = $(this).hasClass("active");
			if(_b == false) {
				$(".nav-item").each(function() {
					_b = $(this).hasClass("active");
					if(_b == true) {
						$(this).removeClass("active");
					}
				});
				$(this).addClass("active");
			}
		});
	});
	
})(jQuery);


/*
 * 删除选择行
 */
var delSelectRow = function(gridId, deleteUrl) {
	var ids = $('#'+gridId).jqGrid('getGridParam','selarrrow');
	if(!ids) {
		alert('请选择行');
		return false;
	}
	
	var rowid;
	var paramData = {};
	
	if(ids.length==1) {
		rowid=$("#"+gridId).jqGrid("getGridParam","selrow");
		paramData = {"id" : rowid};
	} else {
		alert("你没有选取或者选取为多行数据");
		return false;
	}
	
	$.ajax({
		url:deleteUrl,
		data:paramData
	});
	
};

/**
 * 消息提示
 * @param level
 * @param message
 */
var showTipMessage = function(level,message) {
	if(level == "OK") {
		
	}
	if(level == "WARN") {
		
	}
	if(level == "ERROR") {
		
	}
};


