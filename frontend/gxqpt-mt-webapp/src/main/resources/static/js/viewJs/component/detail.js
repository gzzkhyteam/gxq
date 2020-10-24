$(function () {

	// 获取id，如果不为null,意味着来自编辑而不是新增
    var id = getQueryString('id');
    // 获取url里面的指定参数
    function getQueryString(query) {
        var reg = new RegExp("(^|&)"+ query +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return  unescape(r[2]); return null;
    }

	function getDetail() {
        // 获取详情
        ajaxHengyun({
            type:'POST',
            data: {
                id: id
            },
            url: _GATE_URL + '/api/mt/component/detail',
            success: function (res) {
                var data = res.data;
                $('.component-content').html(data.componentDesc);
            },
            error: function(err) {console.log(err);}
        });
	}
    getDetail();
});
