$(function(){
    $(".btn-save").click(function(){
        var isDelete=$("input[name='isDelete']:checked").val();
        var timePeriod=$("#numValid").val();
        if(timePeriod){
            var reg = /^[1-9]\d*$/;
            if (!reg.test(timePeriod)) {
                parent.layer.msg("请填写大于零的整数！", {icon: 6, time: 1500});
                $("#numValid").val("");
                return false;
            }
        }
        save(isDelete,timePeriod);
    });

    $(".btn-saveDefault").click(function(){
        save("0","30");
    });

    function recyclesettingFind(){
        ajaxHengyun({
            type: "get",
            url: _GATE_URL+"/api/file/recyclesetting/find",
            datatype: 'json',
            success: function (rows) {
                if (rows.data) {
                    $("#numValid").val(rows.data[0].timePeriod);
                    $("input[name='isDelete']").removeProp("checked");
                    if(rows.data[0].isDelete){
                        $("input[name='isDelete'][value='1']").prop("checked",true);
                    }else{
                        $("input[name='isDelete'][value='0']").prop("checked",true);
                    }
                }else{
                    parent.layer.msg(rows.errmsg+"请重试！", {icon: 6, time: 1500});
                }
            }
        });
    }

    function save(isDelete,timePeriod){
        ajaxHengyun({
            type: "post",
            url: _GATE_URL+"/api/file/recyclesetting/saveOrUpdate",
            datatype: 'json',
            data:JSON.stringify({"isDelete": Number(isDelete), "timePeriod": timePeriod}),
            contentType : 'application/json',
            success: function (rows) {
                if (rows.data) {
                    recyclesettingFind();
                    parent.layer.msg("设置成功！", {icon: 6, time: 1500});
                }else{
                    parent.layer.msg(rows.errmsg+"请重试！", {icon: 6, time: 1500});
                }
            }
        });
    }
    recyclesettingFind();
})