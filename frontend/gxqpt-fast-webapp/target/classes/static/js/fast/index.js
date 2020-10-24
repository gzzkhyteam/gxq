$(function () {
    var id = getQuery('id');
	var appId = getQuery('appId');

	// 获取查询参数
	function getQuery (name) {
		// var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		// var r = window.location.search.substr(1).match(reg);
		// if(r!=null)return  unescape(r[2]); return null;
		if(name == 'id'){
			return APP_ID;
		}
		if(name == 'appId'){
			return APP_ID;
		}
		return APP_ID;
	}

	// 根据id获取所有的详情
	function getDetailById () {
    	ajaxHengyun({
    		type: 'GET',
    		data: {
    			appId: appId
    		},
    		url: _GATE_URL + '/api/developer/fastapplication/detailByAppId',
    		success: function (res) {
    			var data = res.data;
                if (data) {
                    $('.index-logo').css('background-image', 'url(' + data.logoUrl + ')');
                    $('.index-name').text(data.name);
                }
    		}
    	});
    }

    function getMenuHtml (prop, data, count) {
    	var html = [];
    	html.push('<li' + (count === 0 ? ' class="active"' : '') + '>\
					<a href="javascript:void(0);" class="J_menuItem" target="home">\
						<span class="nav-label">' + prop + '</span>\
						<span class="fa arrow"></span>\
					</a>\
					<ul class="nav nav-second-level">');
		for (var i = 0; i < data.length; i++) {
            var url = data[i].url;
            var target = 'home';
            if (prop === '关联应用') {
                target = '_blank';
            }
            if (url) {
                url = url.replace("{APP_ID}", appId)
            }
			html.push('<li >\
				<a href="' + url + '" class="J_menuItem" target="' + target + '">\
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\
					<span>' + data[i].name + '</span>\
				</a>\
			</li>')
		}
		html.push('</ul></li>');
		return html.join('');
    }

    // 动态加载菜单栏
    function initMenu () {
    	ajaxHengyun({
    		type: 'POST',
    		contentType: 'application/json',
    		data: JSON.stringify({
    			appId: appId,
    			parentId: 1
    		}),
    		url: _GATE_URL + '/api/developer/fastmenu/getMenu',
    		success: function (res) {
                var data = '';
                if (res && res.data) {
                    try{
                        data = JSON.parse(res.data);
                    }catch(e){
                        return
                    }
                }
    			var menuHtml = [];
    			var relationAppHtml = [];
    			// count等于0代表需要active
    			var count = 0;
    			for (var prop in data) {
    				if (prop === '关联应用') {
    					relationAppHtml = getMenuHtml(prop, data[prop]);
    				} else {
    					menuHtml.push(getMenuHtml(prop, data[prop], count));
    					count++;
    				}
    			}
    			menuHtml.push(relationAppHtml);
    			$('#side-menu').html(menuHtml.join('')).metisMenu();
    		}
    	});
    }

	function init () {
		if (!appId || !id) {
			return;
		}
		getDetailById();
		initMenu();
	}

	init();
})
