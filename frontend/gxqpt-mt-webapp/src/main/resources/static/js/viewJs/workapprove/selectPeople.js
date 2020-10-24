// 是否是审批，获取得到就是审批
var check = getQuery('check');
var unitId = getQuery('unitId');

// 获取查询参数
function getQuery (name) {
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;  
}

$(function () {
    var ZTree = '';
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
        },
        callback: {
            onClick: function (e, treeId, treeNode, clickFlag) {
                ZTree.checkNode(treeNode, !treeNode.checked, true);
            }
        }
    };

    if (check) {
        setting.check.chkStyle = 'radio';
        setting.check.radioType = 'all';
    }

    // 根据条件设置树是否可选或者勾选已选的
    function setCheck(list) {
        var idsArr = idsString.split(',');
        for (var j = 0; j < idsArr.length; j++) {
            for (var i = 0; i < list.length; i++) {
                var gxqptEmpId = list[i].gxqptEmpId;
                if (!gxqptEmpId) {
                    list[i].nocheck = true;
                    list[i].open = true;
                } else if (idsArr[j] == gxqptEmpId) {
                    if (check) {
                        list[i].nocheck = true;
                    } else {
                        list[i].checked = true;
                    }
                    break;
                } else if (gxqptEmpId == userId) {
                    list[i].nocheck = true;
                }

                if (list[i].deptList) {
                    setCheck(list[i].deptList);
                }
            }
        }
    }

    //获取人员信息
    ajaxHengyun({
        type:"GET",
        dataType: 'json',
        url:  _GATE_URL+"/api/admin/p/emp/getTreeEmpPhoneByUserId",
        data:{userId:userId},
        success:function(rows){
            if (rows.data){
                // 只能选择当前单位的人员
                var tree = rows.data;
                if (unitId) {
                    for (var i = 0; i < rows.data.length; i++) {
                        if(rows.data[i].id == unitId) {
                            tree = [];
                            tree.push(rows.data[i]);
                            break;
                        }
                    }
                }
                var dataString = JSON.stringify(tree);
                dataString = dataString.replace(/empList/g,"deptList");
                var nodes = JSON.parse(dataString);
                // if (check) {
                setCheck(nodes);
                // }
                ZTree = $.fn.zTree.init($("#ztree"), setting, nodes);
                // 抄送，勾选上已经选择的人
                // if (!check) {
                //     var idsArray = idsString.split(",");
                //     if(idsArray.length>0){
                //         var zTree = $.fn.zTree.getZTreeObj('ztree');
                //         idsArray.forEach(function(value, index){
                //             var node = zTree.getNodeByParam("gxqptEmpId", value, null);
                //             if(node){
                //                 zTree.checkNode(node, true, true);
                //             };
                //         });
                //     };
                // }
            };
        }
    });
});
function save(index){
    var treeObj = $.fn.zTree.getZTreeObj("ztree");
    var nodes = treeObj.getCheckedNodes(true);
    if(nodes.length > 0){
        // 审批人
        if (check) {
            parent.home.setPeoples(nodes[0].gxqptEmpId, nodes[0].name);
        } else {
            // 抄送人
            var idsArray=[];
            var namesArray=[];
            for(var i in nodes){
                var level = nodes[i].level;
                if(level==2){
                    idsArray.push(nodes[i].gxqptEmpId);
                    namesArray.push(nodes[i].name);
                }
            }
            ids=idsArray.join(",");
            names=namesArray.join(",");
            parent.home.setCopyPeoples(ids, names);
        }
    } else {
        // 审批人
        if (check) {
            parent.home.setPeoples('', '');
        } else {
            parent.home.setCopyPeoples('', '');
        }
    }
    parent.layer.close(index);
}