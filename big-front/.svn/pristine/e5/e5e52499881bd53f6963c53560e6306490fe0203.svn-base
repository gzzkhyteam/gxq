const arrAct = {//数字操作
	remove:(arr,item,key)=>{//删除元素
		if(typeof(item) == 'string' || typeof(item) == 'number'){
			arr.splice(arr.indexOf(item),1);
		}else if(typeof(item) == 'object'){
			arr.forEach(function(obj,idx){
				if(obj[key] == item[key]){
					arr.splice(idx,1);
				}
			})
		}
	}
}
export {arrAct};
