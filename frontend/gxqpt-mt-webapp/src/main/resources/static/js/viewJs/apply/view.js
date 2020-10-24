$(function () {
    $("body").on("click",".btn-back",function(){
        window.location.href=_cp+"/module/applyList";
    });

    // 查看组件详情
    $('body').on('click', '.com-detail', function() {
        getDetail($(this).data('id'), $(this).data('name'));
    });

    // 打开组件详情弹窗
    function getDetail(id, name) {
        parent.layer.open({
            type: 2,
            anim:6,
            title: name + '使用说明',
            maxmin: false, //开启最大化最小化按钮
            area: ['500px', '80%'],
            content: _cp+"/module/componentDetail?id="+id,
            btn: ['<span class="glyphicon glyphicon-ok"></span> 确定','<span class="glyphicon glyphicon-remove"></span> 取消'],
            yes: function (index, layero) {
                parent.layer.closeAll();
            }
        });
    }

    /*获取详情*/
    getAppBaseInfo();
    function getAppBaseInfo(){
        ajaxHengyun({
            type:"POST",
            dataType: 'json',
            url:  _GATE_URL+"/api/mt/appmanager/getAppBaseInfo",
            data:{id:_id},
            success:function(rows){
                if (rows.data){
                    var audit = rows.data.audit
                    var current = rows.data.current
                    //审批中
                    $("#appName").text(audit.appName);
                    var appTypeText="";
                    if(audit.appType==1){
                        appTypeText =  "Android";
                    };
                    if(audit.appType==2){
                        appTypeText =  "H5";
                    };
                    $("#appType").text(appTypeText);
                    $("#appPath").text(audit.appPath);
                    $("#appOrder").text(audit.appOrder);
                    var isShowText="";
                    if(audit.isShow==1){
                        isShowText =  "不显示";
                    };
                    if(audit.isShow==2){
                        isShowText =  "显示";
                    };
                    $("#isShow").text(isShowText);
                    $("#createTime ").text(audit.createTime);
                    $("#appDesc").html(audit.appDesc);
                    $("#iconPath").html('<a href="'+audit.iconPath+'" target="_blank"><img src="'+audit.iconPath+'" style="width: 60px; height: 60px;"/>');
                    // 组件
                    if (audit.componentList.length > 0) {
                        var tds = ['<tbody>'];
                        for (var i = 0; i < audit.componentList.length; i++) {
                            var c = audit.componentList[i];
                            tds.push('<tr>\
                                    <td>'+c.componentName+'</td>\
                                    <td><span class="com-detail" data-name="'+c.componentName+'" data-id="' + c.id + '">查看</span></td>\
                                </tr>')
                        }
                        tds.push('</tbody>');
                        $('#component').append(tds.join('')).show();
                    } else {
                        $('#no-component').show();
                    }
                    //当前
                    $("#appName1").text(current.appName);
                    var appTypeText="";
                    if(current.appType==1){
                        appTypeText =  "Android";
                    };
                    if(current.appType==2){
                        appTypeText =  "H5";
                    };
                    $("#appType1").text(appTypeText);
                    $("#appPath1").text(current.appPath);
                    $("#appOrder1").text(current.appOrder);
                    var isShowText="";
                    if(current.isShow==1){
                        isShowText =  "不显示";
                    };
                    if(current.isShow==2){
                        isShowText =  "显示";
                    };
                    $("#isShow1").text(isShowText);
                    $("#createTime1").text(current.createTime);
                    $("#appDesc1").html(current.appDesc);
                    $("#iconPath1").html('<a href="'+current.iconPath+'" target="_blank"><img src="'+current.iconPath+'" style="width: 60px; height: 60px;"/>');
                    // 组件
                    if (current.componentList.length > 0) {
                        var tds = ['<tbody>'];
                        for (var i = 0; i < current.componentList.length; i++) {
                            var c = current.componentList[i];
                            tds.push('<tr>\
                                    <td>'+c.componentName+'</td>\
                                    <td><span class="com-detail" data-name="'+c.componentName+'" data-id="' + c.id + '">查看</span></td>\
                                </tr>')
                        }
                        tds.push('</tbody>');
                        $('#component1').append(tds.join('')).show();
                    } else {
                        $('#no-component1').show();
                    }
                }else{
                    parent.layer.msg(rows.errmsg+"，请重试！",{time:3000});
                }
            }
        });
    };
});