(function () {
	$(document).ready(function() {
		var STEP = {
			CASE_SELECTED: 'CASE_SELECTED',
			NEXT_STEP: 'NEXT_STEP'
		};

		var APP_CODE = {
			// 平台
			TYPT: 'zcpt',
			// 应用
			GXYY: 'zcyy',
			// 服务
			GXFW: 'zcfw',
			// 模块
			GXMK: 'zcfwmk'
		};

		function getQuery (name) {
			var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
			var r = window.location.search.substr(1).match(reg);
			if(r!=null)return  unescape(r[2]); return null;  
		}

	    function bindEvent () {
	    	// 取消新增回到首页
	    	$('#cancel').on('click', function () {
	    		window.location.href = 'appList';
	    	});
	    }

	    function insertText (list, code, name) {
        	var id = '';
        	switch (code) {
        		// 平台
        		case APP_CODE.TYPT:
        			return;
        		// 应用
        		case APP_CODE.GXYY:
        			id = '#application';
        			break;
        		// 服务
        		case APP_CODE.GXFW:
        			id = '#service';
        			break;
        		// 模块
        		case APP_CODE.GXMK:
        			id = '#module';
        			break;
        	}
        	if (id && list.length > 0) {
        		var listHtml = ['<p>'+name+'</p>'];
		    	for (var i = 0; i < list.length; i++) {
		    		listHtml.push('<span class="item">' + list[i].name + '</span>');
		    	}
		    	
				$(id).append(listHtml.join(''));
        	}
	    }

	    function getDetailById (id) {
	    	ajaxHengyun({
	    		type: 'GET',
	    		data: {
	    			id: id
	    		},
	    		url: _GATE_URL + '/api/developer/fastapplication/getById',
	    		success: function (res) {
	    			var data = res.data;
	    			if (data) {
	    				var lines = $('.CASE_SELECTED .app-detail');
	    				if (data.name) {
	    					$('#appName').text(data.name);
	    					lines.eq(0).show();
	    				}
	    				if (data.userName) {
	    					$('#createUser').text(data.userName);
	    				}
	    				if (data.appId) {
	    					$('.app-flag').text(data.appId);
	    					lines.eq(1).show();
	    				}
	    				if (data.logoUrl) {
	    					$('.app-logo').css('background-image', 'url(' + data.logoUrl + ')');
	    					lines.eq(2).show();
	    				}
	    				if (data.desc) {
	    					$('.app-desc').text(data.desc);
	    					lines.eq(3).show();
	    				}
	    				if (data.bizConfigId) {
	    					$('#case').text(data.bizConfigId);
	    					lines.eq(4).show();
	    				}
		    			
		    			for (var i = 0; i < data.application.length; i++) {
							var list = data.application[i].application;
							var code = data.application[i].code;
							var name = data.application[i].name;
							insertText(list, code, name);
						}
						$('.CASE_SELECTED').show();
	    			}
	    		}
	    	});
	    }

	    function init () {
	    	bindEvent();
	    	// 如果能够获得id的值，那就是来自修改
	    	var id = getQuery('id');
	    	getDetailById(id);
	    }

	    init();
	});
})();
