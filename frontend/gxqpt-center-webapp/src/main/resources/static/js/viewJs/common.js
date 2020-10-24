var userId = $("#userId").val();
var systemCode=$("#systemCode").val();
$(".userTxt,.userInfo ul").off("mouseenter").on("mouseenter", function () {
    $("#rotate").addClass("rotate");
    $(".userInfo ul").css("display", "inline-block");
});
$(".userTxt,.userInfo ul").off("mouseleave").on("mouseleave", function () {
    $("#rotate").removeClass("rotate");
    $(".userInfo ul").css("display", "none");
});
$(".infoTip").click(function(){
    window.location.href=_cp+"/admin/home?type=all";
});
/*获取消息总数*/
getInfoTotal();
function getInfoTotal() {
    ajaxHengyun({
        type: 'post',
        url: urlPrev + '/api/msgs/bbs/msg/getNotReadMsg',
        contentType: 'application/json',
        data: JSON.stringify({
            pageNo: 1,
            pageSize: 1,
            data: {
                conditions:"all",
                userId: userId
            }
        }),
        success: function (res) {
            if(res.errmsg=="ok"){
                if(Number(res.data.total)>0){
                    if(res.data.total>99){
                        $("#infoTotal").text("99+");
                    }else{
                        $("#infoTotal").text(res.data.total);
                    }
                    $("#infoTotal").css("display","inline-block");
                }
            }else{
                $("#infoTotal").text("0");
            };
        }
    })
};
/* 跳转密码修改页面 */
function repassword() {
    layer.open({
        id: 'repassword',
        type: 2,
        anim: 6,
        title: '密码修改',
        maxmin: false, //开启最大化最小化按钮
        area: ['540px', '320px'],
        content: _cp+"/admin/repassword?id=" + userId,
        btn: ['<span class="glyphicon glyphicon-ok"></span> 提交', '<span class="glyphicon glyphicon-remove"></span> 取消'],
        yes: function (index, layero) {
            var iframeWin = window[layero.find('iframe')[0]['name']];
            iframeWin.save(index);
        }
    });
};

/* 跳转基本信息页面 */
function personInfoPage() {
    layer.open({
        id: 'personInfoPage',
        type: 2,
        anim: 6,
        title: '基本信息',
        maxmin: false, //开启最大化最小化按钮
        area: ['720px', '600px'],
        content: _cp+"/admin/personInfoPage?id=" + userId+"&systemCode="+systemCode,
        btn: ['<span class="glyphicon glyphicon-ok"></span> 提交', '<span class="glyphicon glyphicon-remove"></span> 取消'],
        // btn: ['<span class="glyphicon glyphicon-remove"></span> 关闭'],
        yes: function (index, layero) {
            var iframeWin = window[layero.find('iframe')[0]['name']];
            iframeWin.save(index);
        }
    });
};
function goBack(){
    window.location.href = _cp+"/admin/index";
}