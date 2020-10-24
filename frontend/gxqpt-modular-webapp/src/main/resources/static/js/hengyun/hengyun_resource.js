var resourceJs = {
    _gate_url: "",
    _app_id: "",
    _user_id: "",
    buttonList: null,
    menuList: null,
    FIND_MENU_URL: function () {
        return this._gate_url + "/api/admin/p/resource/findcanoperatemenu";
    },
    FIND_BUTTON_URL: function () {
        return this._gate_url + "/api/admin/p/resource/findcanoperatebutton";
    },

    data: {},
    init: function (_gate_url, _app_id, _user_id) {
        //初始化数据
        this._gate_url = _gate_url;
        this._app_id = _app_id;
        this._user_id = _user_id;
        return this;
    },
    /**
     * @param resource_code 资源编码  [必填]
     * @param group 菜单分组 配置的时候设置的 [默认空]
     * @param resourceId 菜单id 查询自定菜单id下的按钮 可以不设置[默认空，查所有]
     * @param cache 是否启用查询缓存 默认true
     * @param display 是否设置显示样式 [默认false]
     * @param btnHtml 按钮html [默认空]
     * @param htmlInsert 是否将按钮插入当前位置 [默认false]
     * @param isReplace 是否替换按钮中的占位符 [默认true]
     * @returns {Array}
     */
    containButton: function (settings) {
        if (!resourceJs._gate_url || !resourceJs._app_id || !resourceJs._user_id) {
            return '请先调用init方法，正确设置 _gate_url/ _app_id/ _user_id';
        }

        //查询用户拥有的按钮
        var isCache = true;
        if(settings['cache'] == null || typeof(settings['cache']) == "undefined" || settings['cache']){
            isCache = true;
        } else {
            isCache = false;
        }
        if(isCache && resourceJs.buttonList == null){
            var resourceParam = {
                "appId": resourceJs._app_id, "userId": resourceJs._user_id,
                "group": settings['group'], "resourceId":settings['resourceId'],
            };
            ajaxHengyun({
                type: "POST",
                async: false,
                url: resourceJs.FIND_BUTTON_URL(),
                data: JSON.stringify(resourceParam),
                datatype: "json",
                contentType: 'application/json',
                success: function (rows) {
                    if (rows.errcode == 0 && rows.data) {
                        resourceJs.buttonList = rows.data;
                    }
                }
            });
        }

        //是否开启 设置显示样式
        if (settings['display']) {
            for (var i = 0; i < resourceJs.buttonList.length; i++) {
                var resource = buttonList[i];
                if (resource['code'] == settings['resource_code']) {
                    return 'display:block;';
                }
            }
            return 'display:none;';
        }

        if (settings['btnHtml']) {
            var btnHtml = '';
            //判断是否有指定的权限code
            for (var i = 0; i < resourceJs.buttonList.length; i++) {
                var resource = resourceJs.buttonList[i];
                if (resource['code'] == settings['resource_code']) {
                    btnHtml = settings['btnHtml'];
                    // 替换占位符
                    var isReplace = settings['isReplace'];
                    if(isReplace == null || typeof(isReplace) == "undefined" || isReplace){
                        btnHtml = btnHtml.replace('{{name}}', resource['name']);
                        btnHtml = btnHtml.replace('{{icon}}', resource['icon']);
                        btnHtml = btnHtml.replace('{{url}}', resource['url']);
                    }
                    break;
                }
            }

            if (btnHtml) {// 能进来，就代表有这个权限
                if (settings['htmlInsert']) {
                    $("#" + settings['resource_code']).after(btnHtml);
                }
            }
            return btnHtml;
        }

        return resourceJs.menuList;
    },
    findMenu: function (settings) {
        if (!resourceJs._gate_url || !resourceJs._app_id || !resourceJs._user_id) {
            return '请先调用init方法，正确设置 _gate_url/ _app_id/ _user_id';
        }

        //查询用户拥有的按钮
        //获取菜单
        var isCache = true;
        if(settings['cache'] == null || typeof(settings['cache']) == "undefined" || settings['cache']){
            isCache = true;
        } else {
            isCache = false;
        }
        if(isCache && resourceJs.menuList== null){
            var resourceParam = {
                "appId": resourceJs._app_id, "userId": resourceJs._user_id
            };
            ajaxHengyun({
                type: "POST",
                async: false,
                url: resourceJs.FIND_MENU_URL(),
                data: JSON.stringify(resourceParam),
                datatype: "json",
                contentType: 'application/json',
                success: function (rows) {
                    if (rows.errcode == 0 && rows.data) {
                        resourceJs.menuList = rows.data;
                    }
                }
            });
        }
        return resourceJs.menuList;
    },

};