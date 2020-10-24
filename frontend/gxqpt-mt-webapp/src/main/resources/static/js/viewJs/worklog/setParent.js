$(function () {
    var setting = {
        check: {
            enable: true
        },
        data: {
            key: {
                children:"deptList"
            },
            simpleData: {
                enable: true
            }
        }
    };

    var zNodes =[
        { id:1, pId:0, name:"随意勾选 1", open:true},
        { id:11, pId:1, name:"随意勾选 1-1", open:true},
        { id:111, pId:11, name:"随意勾选 1-1-1"},
        { id:112, pId:11, name:"随意勾选 1-1-2"},
        { id:12, pId:1, name:"随意勾选 1-2", open:true},
        { id:121, pId:12, name:"随意勾选 1-2-1"},
        { id:122, pId:12, name:"随意勾选 1-2-2"},
        { id:2, pId:0, name:"随意勾选 2", checked:true, open:true},
        { id:21, pId:2, name:"随意勾选 2-1"},
        { id:22, pId:2, name:"随意勾选 2-2", open:true},
        { id:221, pId:22, name:"随意勾选 2-2-1", checked:true},
        { id:222, pId:22, name:"随意勾选 2-2-2"},
        { id:23, pId:2, name:"随意勾选 2-3"}
    ];

    var code;

    function setCheck() {
    }

    //获取人员信息
    ajaxHengyun({
        type:"GET",
        dataType: 'json',
        url:  _GATE_URL+"/api/admin/p/emp/getTreeEmpPhoneByUserId",
        data:{userId:userId},
        success:function(rows){
            if (rows.data){
                var dataString = JSON.stringify(rows.data);
                dataString = dataString.replace(/empList/g,"deptList");
                var nodes = JSON.parse(dataString);
                $.fn.zTree.init($("#ztree"), setting, nodes);
                var idsArray = idsString.split(",");
                if(idsArray.length>0){
                    var zTree = $.fn.zTree.getZTreeObj('ztree');
                    idsArray.forEach(function(value, index){
                        var node = zTree.getNodeByParam("gxqptEmpId", value, null);
                        if(node){
                            zTree.checkNode(node, true, true);
                        };
                    });
                };
            };
        }
    });

});
function save(index){
    var idsArray=[];
    var namesArray=[];
    var treeObj = $.fn.zTree.getZTreeObj("ztree");
    var nodes = treeObj.getCheckedNodes(true);
    if(nodes){
        for(var i in nodes){
            var level = nodes[i].level;
            if(level==2){
                idsArray.push(nodes[i].gxqptEmpId);
                namesArray.push(nodes[i].name);
            }
        };
        ids=idsArray.join(",");
        names=namesArray.join(",");
        parent.home.setParentVal(ids,names);
        parent.layer.close(index);
    }
}