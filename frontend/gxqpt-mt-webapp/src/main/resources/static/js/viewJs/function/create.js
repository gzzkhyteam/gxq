$(function () {
    $("body").on("click",".btn-back",function(){
        window.location.href=_cp+"/module/functionList?id="+_id;
        // window.location.href=history.back();
    });
    /*提交*/
    $('.btn-submit').valid({
        form: '#dataForm',
        //showAllError:可选项 true | false，true：提交表单时所有错误提示信息都会显示，
        //false：一碰到验证不通过的就停止检测后面的元素，只显示该元素的错误信息;
        ignoreHidden: true,
        showAllError: true,
        checkpassed: function () {
            saveObj();
        }
    });
    function saveObj(){
        var gxqptDutiesDTO =$("#dataForm").serializeJSON();
        gxqptDutiesDTO.appDesc =ue.getContent();
        ajaxHengyun({
            type:"POST",
            dataType: 'json',
            contentType: 'application/json',
            url:  _GATE_URL+"/api/mt/appmanager/createFunction",
            data:JSON.stringify(gxqptDutiesDTO),
            success:function(rows){
                if (rows.data){
                    parent.layer.msg("新增功能成功！",{icon:6,time:1000});
                    window.location.href=_cp+"/module/functionList?id="+_id;
                }else{
                    parent.layer.msg(rows.errmsg+"，请重试！",{time:3000});
                }
            }
        });
    };
    ue.addListener('blur',savecontent);
    function savecontent(){
        if(ue.getContent()){
            $("#appExplain > input").val("1");
        }else{
            $("#appExplain > input").val("");
        }
        $("#appExplain > input").blur();
    };
});
