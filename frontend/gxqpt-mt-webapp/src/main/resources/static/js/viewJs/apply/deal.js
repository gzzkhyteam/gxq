function save(index){
    var gxqptDutiesDTO =$("#dataForm").serializeJSON();
    if(!gxqptDutiesDTO.auditContent){
        parent.layer.msg("审核意见不能为空！",{time:2000});
        return false;
    }
    ajaxHengyun({
        type:"POST",
        dataType: 'json',
        contentType: 'application/json',
        url:  _GATE_URL+"/api/mt/appmanager/auditApp ",
        data:JSON.stringify(gxqptDutiesDTO),
        success:function(rows){
            if (rows.data){
                parent.home.reloadPage();
                parent.layer.close(index);
            }else{
                parent.layer.msg(rows.errmsg+"，请重试！",{time:3000});
            }
        }
    });
};
