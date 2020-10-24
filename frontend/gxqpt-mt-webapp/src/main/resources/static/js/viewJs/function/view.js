$(function () {
    $("body").on("click",".btn-back",function(){
        window.location.href=_cp+"/module/functionList?id="+parentId;
        // window.location.href=history.back();
    });
    /*获取详情*/
    var parentId;
    getAppBaseInfo();
    function getAppBaseInfo(){
        ajaxHengyun({
            type:"POST",
            dataType: 'json',
            url:  _GATE_URL+"/api/mt/appmanager/getFunctionInfo",
            data:{funcId:_id},
            success:function(rows){
                if (rows.data){
                    $("#appName").text(rows.data.appName);
                    $("#appPath").text(rows.data.appPath);
                    $("#showUrl").text(rows.data.showUrl);
                    $("#appDesc").html(rows.data.appDesc);
                    parentId=rows.data.parentId;
                    var isShowText="";
                    if(rows.data.isShow==1){
                        isShowText =  "不显示";
                    };
                    if(rows.data.isShow==2){
                        isShowText =  "显示";
                    };
                    $("#isShow").text(isShowText);
                }else{
                    parent.layer.msg(rows.errmsg+"，请重试！",{time:3000});
                }
            }
        });
    };
});
