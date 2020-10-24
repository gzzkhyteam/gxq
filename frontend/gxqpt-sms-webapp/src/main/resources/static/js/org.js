
function getOrgan(userId) {
	if(!userId){
		console.log("未获取到登录用户信息");
		return false;
	}
    ajaxHengyun({
        type: 'GET',
        url: urlPost+"/api/admin/p/emp/getTreeEmpPhoneByUserId",
        data: {userId: userId,"filterPhone":"true"},
        success: function (data) {
            if (data.data) {
                var units = data.data;
                nodes = builderTrees(units);
                var setting = {
                    data: {
                        key: {
                            name: 'name'
                        },
                        simpleData: {
                            idKey: 'id',
                        }
                    },
                    view: {
                        expandSpeed: ""
                    },
                    callback: {
                        onClick: zTreeOnCheck
                    }
                };
                $.fn.zTree.init($("#ztree"), setting, nodes);/* 生成树 */
                var treeObj = $.fn.zTree.getZTreeObj("ztree");
                var nodes = treeObj.getNodes();
                if(nodes.length>0){
                    var item=nodes[0].children;
                    if (item.length>1) {
                        treeObj.selectNode(item[0]);
                        if(item[0].orgId){
                            mainorgid = item[0].orgId;
                        }
                        maindeptid = item[0].id;
                    }
                }
            }
        }
    });
}

//节点选中事件
function zTreeOnCheck(event, treeId, treeNode){

    var orgContact=$("#contactPerson").val();
    var zTree = $.fn.zTree.getZTreeObj("ztree");
    var tempDepNames = "";
    var sonValue="";
    var con="";
    //判断是否为叶子节点还是父节点
    if(treeNode.children){//父节点
        for(var i=0;i<treeNode.children.length;i++){

           if(treeNode.children[i].empList){
               //有empList 一般为单位节点
                if(treeNode.children[i].empList.length>0){
                    //遍历
                    for(var j=0;j<treeNode.children[i].empList.length;j++){
                        if(treeNode.children[i].empList[j].mainmobile==undefined || treeNode.children[i].empList[j].mainmobile==null || treeNode.children[i].empList[j].mainmobile==""){
                            if(treeNode.children[i].empList[j].submobile==undefined || treeNode.children[i].empList[j].submobile==null || treeNode.children[i].empList[j].submobile==""){
                                treeNode.children[i].empList[j].mainmobile="";
                                tempDepNames += treeNode.children[i].empList[j].name+"<"+treeNode.children[i].empList[j].mainmobile+">";
                            }else{
                                tempDepNames +=treeNode.children[i].empList[j].name+ "<"+treeNode.children[i].empList[j].submobile +">"+ ",";
                            }
                        }else{
                            tempDepNames +=treeNode.children[i].empList[j].name+ "<"+treeNode.children[i].empList[j].mainmobile +">"+ ",";
                        }
                    }
                }
            }else{
                //无empList 一般为部门节点 循环children

                    if(treeNode.children[i].mainmobile==undefined || treeNode.children[i].mainmobile==null || treeNode.children[i].mainmobile==""){
                        if(treeNode.children[i].submobile==undefined || treeNode.children[i].submobile==null || treeNode.children[i].submobile==""){
                            treeNode.children[i].mainmobile="";
                            tempDepNames += treeNode.children[i].name+"<"+treeNode.children[i].mainmobile+">";
                        }else{
                            tempDepNames +=treeNode.children[i].name+ "<"+treeNode.children[i].submobile +">"+ ",";
                        }

                    }else{
                        tempDepNames +=treeNode.children[i].name+ "<"+treeNode.children[i].mainmobile +">"+ ",";
                    }

            }

        }
    }else{
        //叶子节点
        if(treeNode.mainmobile==undefined || treeNode.mainmobile==null || treeNode.mainmobile==""){
            if(treeNode.submobile==undefined || treeNode.submobile==null || treeNode.submobile==""){

            }else{
               sonValue += treeNode.name+"<"+treeNode.submobile +">";
                tempDepNames +="<span class='spanbox'><span class='spantext'>"+treeNode.name+"<"+treeNode.submobile+">"+"<i class='fa fa-remove'></i></span></span>";
            }
        }else{
            sonValue +=treeNode.name+"<"+treeNode.mainmobile +">";
            tempDepNames +="<span class='spanbox'><span class='spantext'>"+treeNode.name+"<"+treeNode.mainmobile+">"+"<i class='fa fa-remove'></i></span></span>";

        }
    }

    //选择单位或者部门 tempDepNames为：李孟珊珊02<15285138211>,管理员<15218869970>
    // 选择叶子节点 tempDepNames为：
    //先判断是否含有，
    var tempArray= new Array();
    var tempDep="";
    var  isLeaf=true;
    if(tempDepNames.indexOf(",")!=-1){
        //来源自单位或者部门
        tempDepNames=tempDepNames.substr(0,tempDepNames.length-1);
        tempArray=tempDepNames.split(",");
    }
    if($("#contactPerson").html() && ($("#contactPerson").html().indexOf(">")!=-1)){
        var str=$("#contactPerson").html();
        $("#contactPerson>span").each(function(){
            var spanTxt=$(this).find('.spantext').text().trim();
            if(tempArray.length>0){
                //来自单位或者部门
                for(var kk=0;kk<tempArray.length;kk++){
                    if(spanTxt==tempArray[kk]||spanTxt.indexOf(tempArray[kk])!=-1){
                        tempArray[kk]="";
                    }
                }
                isLeaf=false;
            }else{
               //来自叶子节点
                if(spanTxt==sonValue||spanTxt.indexOf(sonValue)!=-1){
                    isLeaf=false;
                    return false;
                }else{
                    isLeaf=true;

                }
            }
       });
        //看数组里面还有哪些值拼
        if(tempArray.length>1){
            for(var nn=0;nn<tempArray.length;nn++){
                if(tempArray[nn]){
                    con+="<span class='spanbox'><span class='spantext'>"+tempArray[nn]+"<i class='fa fa-remove'></i></span></span>";
                }

            }
            str+=con;
            $("#contactPerson").html('')
            $("#contactPerson").append(str);
        }

        //如果为true就拼
      if(isLeaf){
            str+=tempDepNames;
            $("#contactPerson").html('')
            $("#contactPerson").append(str);
        }

   }else{//如果接收人为空
        if(tempArray.length>0){
            //来自单位或者部门
            for(var kk=0;kk<tempArray.length;kk++){
                tempDep+="<span class='spanbox'><span class='spantext'>"+tempArray[kk]+"<i class='fa fa-remove'></i></span></span>";
              }
            if($("#contactPerson").html()==""){
                $("#contactPerson").append(tempDep);
                tempDepNames="";
            }else{
                $("#contactPerson").append(",").append(tempDep);
                tempDepNames="";
            }
        }else{
            //来自叶子节点
            $("#contactPerson").append(tempDepNames);
            tempDepNames="";
        }

    }
}
function builderTrees(r){

    if(!r || r.length == 0){
        return ;
    }
    r.forEach(function (value, index) {

        var isChildOrg = true;
        if(!value.children || value.children.length == 0){
            value.children = [];
            isChildOrg = false;
        }
        if(!(!value.deptList || value.deptList.length == 0)){
            value.deptList.forEach(function (item, index) {
                value.children.push(item);
                if(!(!item.empList || item.empList.length == 0)){
                    item.children = item.empList;
                }
            });
        }
        if(!value.name){
            value.isHidden = true;
        }
        if(isChildOrg){
            builderTree(value.children);
        }
        return ;
    });
    return r;
}
/*
*对比两个字符串
* src为联系人原有的内容
* pass为后面选择的字符串
* array_con放拼接在原字符串后面的值
 */
function compareStr(src,pass){
    var array_src=new Array();
    var array_pass=new Array();
    var array_con=new Array();
    var des="";
    array_src=src.split(",");
    array_pass=pass.split(",");
   //差集
   //var array_fir=Array.minus(array_src,array_pass);
   //var array_sec=Array.minus(array_pass,array_src);
   //两个差集取交集
   //var array_cha=Array.intersect(array_fir,array_sec);
   //并集
   var array_bing=Array.union(array_src,array_pass);
   des=array_bing.join(",");
   return des;


}
Array.prototype.uniquelize = function(){
    var ra = new Array();
    for(var i = 0; i < this.length; i ++){
        if(!ra.contains(this[i])){
            ra.push(this[i]);
        }

    }
    return ra;
};
Array.union = function(a, b){
    return a.concat(b).uniquelize();
};
Array.prototype.contains = function(val)
{
    for (var i = 0; i < this.length; i++)
    {
        if (this[i] == val)
        {
            return true;
        }
    }
    return false;
};
