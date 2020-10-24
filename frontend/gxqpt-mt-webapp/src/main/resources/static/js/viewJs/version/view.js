$(function () {

	// 获取id，如果不为null,意味着来自编辑而不是新增
    var id = getQueryString('id');
    // 获取url里面的指定参数
    function getQueryString(query) {
        var reg = new RegExp("(^|&)"+ query +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return  unescape(r[2]); return null;
    }

	function bindEvent() {
		// 返回
		$("body").on("click",".btn-back",function(){
	        window.location.href=_cp+"/module/versionList";
	    });
	}

	function getDetail() {
		ajaxHengyun({
            type: 'POST',
            data: {
                id: id
            },
            url: _GATE_URL + '/api/mt/clientVersion/getBaseInfo',
            success: function (res) {
                var data = res.data;
                var html = '<tr>\
                                <th>版本号</th>\
                                <td colspan="2">' + data.verNumber + '</td>\
                                <td rowspan="3"><img src="' + data.downQrCode + '"></td>\
                            </tr>\
                            <tr>\
                                <th>版本名称</th>\
                                <td colspan="2">' + data.verName + '</td>\
                            </tr>\
                            <tr>\
                                <th>是否强制更新</th>\
                                <td colspan="2">' + (data.pwUpdate == 2 ? '是' : '否') + '</td>\
                            </tr>\
                            <tr>\
                                <th>发布日期</th>\
                                <td>' + data.publishTime + '</td>\
                                <th>创建日期</th>\
                                <td>' + data.createTime + '</td>\
                            </tr>\
                            <tr>\
                                <th>升级内容</th>\
                                <td colspan="3">' + (data.updateContent || '') + '</td>\
                            </tr>\
                            <tr>\
                                <th>附件</th>\
                                <td colspan="3">' + (data.apkFileName || '无附件') + '</td>\
                            </tr>';
                $('#detailTable').append(html);
            }
        })
	}

	function init() {
		bindEvent();
		getDetail();
	}

	init();
    
});
