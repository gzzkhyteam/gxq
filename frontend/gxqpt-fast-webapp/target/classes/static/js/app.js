(function($){
	
	 /**
     * 初始化jqgrid默认配置
     */
    $.extend(jQuery.jgrid.defaults,
			{
				toppager:true,
    			// toolbar: [true,"top"],
				bottompager:false,
				pagerpos:"right",
				recordpos:"left",
				datatype:"json",
				altRows:true,
				hidegrid: false,
				// width:"100%",
				/*altclass:'altClass',*/
				autoencode:true,
				viewsortcols:[false,'vertical',true],
				forceFit:false,
				rowNum : 20,
				rowList : [ 10, 20, 30 ],
				mtype : "post",
				autowidth : true,
				viewrecords : true, // 定义是否要显示总记录数
				edit:false,add:false,del:false,search:false,
	            shrinkToFit: true,
		        rownumbers: true,
		        height : 400,
		        sortable:false,
		        hoverrows:true,
		        scrollrows:true,
		        loadtext:'数据加载中',
		        // multiselect: true,
		        // multiboxonly: true,
		        // multikey:'shiftKey',
		        gridview: true,
		        beforeSelectRow: beforeSelectRow,
		        multiSort: true,
		        styleUI:"Bootstrap",
		        prmNames: {page:"page",rows:"rows", sort:"sidx",order:"sord", search:"search", nd:"nd", npage:null},
				jsonReader:{root: "items",    // 数据
					 		page: "page",    // 当前页码
					 		total: "totalPages",    // 总页数
					 		records: "totalRecords", // 总数据行
					 		repeatitems: true, // 如果为false，根据name来搜索对应的数据元素。
					 		cell: "cell",
					 		id: "id",
					 		userdata: "userdata",
					 		subgrid: {
					 			root:"rows", 
					 			repeatitems: true, 
					 			cell:"cell"
					 		}
					}
				
			}
	);
	
    
    function beforeSelectRow() {
    	$(this).jqGrid('resetSelection');
    	return true;  
    }
    
	$(document).ready(function() {
		
		/*$('div.fit').each(function(index,domEle){
			// var pheight = $(this).parent().height();
			var pheight = $(window).height();
			
			var oheight = 0;
			$.each($(this).siblings(),function() {
				oheight+=$(this).height();
			});
			
			$(this).height(pheight-oheight);
			
		});*/
		
		//自应高度
        /*$(window).resize(function () {
        	$("#list2").setGridHeight($(window).height()-60-102-8);
        });*/
		
		
	});
	
	
})(jQuery);

//设置绝对路径
var _cp ;
var url = "";
var delUrl = "";
var downloadUrlByUri = "";
function setCp(cp){
    _cp = cp ;
    url = _cp+"/comm/file/uploadFile.do";
    delUrl =_cp+"/comm/file/deleteById.do?id=";
    downloadUrlByUri =_cp+"/comm/file/downLoadAttachment.do?url=";
}
//国家城市选择
function findListByPid(pid){
	/*var data_ ;
	if(_cp){
		$.ajax({
			url:_cp+"/country/findListByPid.do",
			type:"post" ,
			data:{"pid":pid},
			async:false ,
			success:function(data){
				data = eval('(' + data + ')') ;
				if(data&&data.errcode==1){
					layer.alert(data.errmsg) ;
				}
				data_ = data.list ;
			}
		}) ;
	}
	return data_;*/
}
$(function() {
	
	//初始化方法，初始化chosen控件和数据
	var init = function() {
		var data = findListByPid() ;
		if(!data) return ;
		data.unshift({"name":'请选择国家名称',"id":'-1'}) ;
		var option = [];
		//option.push('<option>','请选择国家名称','</option>');
		if(!data) return ;
		$.each(data,
		function(index, item) {
			var province = item.name;
			option.push('<option value="'+item.id+'">',province,'</option>');
		});
		option = option.join('');
		$('#country_dept').html(option);
		$("#country_dept").chosen({
			no_results_text: "没有找到",
			allow_single_deselect:true
		});
		$("#city_dept").chosen({
			no_results_text: "没有找到",
			allow_single_deselect:true
		});
	} ;
	//执行init方法
	init();
	//省份变动触发事件
	$('#country_dept').change(function(){
		var province = $(this).val();
		if(province=="-1"){
			$('#city_dept_chosen').css("display", "none");		
		}else{
			$('#city_dept_chosen').css("display", "inline-block");	
		}
		var citys = null;
		citys = findListByPid(province) ;
		/*$.each(data,function(index,item){
			if(item.province == province){
				citys = item.city;
			}
		});*/
		citys.unshift({"name":'请选择城市名称',"id":'-1'}) ;
		var option = [];
		$.each(citys,function(index,item){
			option.push('<option value="'+item.id+'">',item.name,'</option>');
		});
		$('#city_dept').html(option.join(''));
		$('#city_dept').trigger('chosen:updated');
	});
});
//自定义删除提示方法
var options = {
	controlId: null,
	controlName:null,
	url: null,
	id: null,
	successInfo:"操作成功",
	errorInfo:"操作失败"
};
$.fn.removePromote=function(options){			
	top.layer.confirm(options.controlName,{
		  title:'温馨提示',
		  shade: [0.4,'#000'],
		  btn: ['确定','取消'] //按钮
		}, function(){
			$.ajax({
		       	url:options.url,
		       	data: {"id": options.id},
		       	type:"post", 
		       	async:false,      
		       	dataType:"json",
		       	success:function(data){
		       		$(this).alertInfo(options.successInfo);
		       		$(options.controlId).setGridParam().trigger("reloadGrid");
		       	},
		       	error:function(){
		       		$(this).alertInfo(options.errorInfo);
		       	}
    		});
		}, function(){
			closeLayer();
		});
};
$.fn.alertInfo=function(info){			
	top.layer.confirm(info,{
		  title:'温馨提示',
		  shade: [0.4,'#000'],
		  btn: ['确定'] //按钮
		}, function(){
			closeLayer();
		});
};
function closeLayer(){
	top.layer.closeAll();
}

function getStarTime(id) {
	var starData = $("#" + id).val();
	if (starData != "" && starData != null && starData != undefined) {
		return starData;
	} else {
		return "";
	}
}
/**
 * 初始化jqgrid的导出功能
 * @param id jqgrid id
 */
function initExport(id) {
	var list = $(id);
	//初始化
	(function () {
		list.navGrid('#list_toppager_center',
			{
				edit: false,
				add: false,
				del: false,
				search: false,
				refresh: false,
				view: false,
				position: "left",
				cloneToTop: true
			});
		// 添加导出全部功能的按钮
		list.navButtonAdd('#list_toppager',
			{
				buttonicon: "ui-icon-mail-closed",
				title: "导出全部数据",
				caption: "导出全部数据",
				position: "last",
				onClickButton: queryTableDatas(true)
			});


		// 添加导出本页功能的按钮
		list.navButtonAdd('#list_toppager',
			{
				buttonicon: "ui-icon-pencil",
				title: "导出本页数据",
				caption: "导出本页数据",
				position: "last",
				onClickButton: queryTableDatas(false)
			});
		// 添加自定义导出功能
		list.navButtonAdd('#list_toppager',
			{
				buttonicon: "ui-icon-pencil",
				title: "自定义导出",
				caption: "自定义导出",
				position: "last",
				onClickButton: function () {
					var html = "<table>";
					var param = list.jqGrid("getGridParam");
					param.colNames[0] = "序号";
					$.each(param.colNames, function (index, value) {
						html += '<tr><td><label><input type="checkbox" checked="checked" name="colIndex" value="' + index + '"/>' + value + '</label> </td></tr>';
					});
					html += '</table>';

					var t = layer.open({
						content: html,
						btn: ['确定', '取消'],
						yes: function () {
							var array = [];
							$('input[name="colIndex"]:checked').each(function () {
								array.push($(this).val());
							});
							if (array.length == 0) {
								array = undefined;
							}
							queryTableDatas(true,array)();
							layer.close(t);
						}
					});
				}
			});
	})();


	/**
	 * 检查字符串是否为一个html字符串
	 * @param htmlStr 字符串
	 * @returns {boolean} html字符串返回true， 其他返回false
	 */
	function checkHtml(htmlStr) {
		if (!htmlStr) {
			return false;
		}
		var reg = /<[^>]+>/g;
		return reg.test(htmlStr);
	}

	/**
	 * 在原始字符串后面添加字符
	 * @param origin 原始字符串
	 * @param commaStr 添加的字符
	 * @returns {string|Array.<T>|*} 添加后的新字符
	 */
	function pushComma(origin, commaStr) {
		origin = origin.concat("\"" + commaStr + "\",");
		return origin;
	}

	/**
	 * 向服务器请求数据
	 * @param all 是否请求全部
	 */
	function queryTableDatas(all, filter) {
		console.info("aaaa");
		return function () {
			var param = list.jqGrid("getGridParam");
			var postData = param.postData;
			if (all) {
				postData.rows = param.records;
				postData.page = 1;
			}
			$.ajax({
				url: param.url,
				data: postData,
				type: 'POST',
				success: function (data) {
					var csv = generateCSV(data, filter);
					handleDownload(csv, all, filter);
				}
			});
		}
	}

	/**
	 * 产生csv字符串
	 * @param data 数据
	 * @param filter 过滤器
	 * @returns {string} 产生的csv字符串
	 */
	function generateCSV(data, filter) {
		var param = list.jqGrid("getGridParam");
		var csvStr = '';
		var newLine = '\r\n';
		param.colNames[0] = "序号";
		var colModels = [];
		var colNames = [];
		if (!filter) {
			colModels = param.colModel;
			colNames = param.colNames;
		} else {
			$.each(filter, function (index, value) {
				colModels.push(param.colModel[value]);
				colNames.push(param.colNames[value]);
			})
		}

		$.each(colNames, function (index, value) {
			csvStr = pushComma(csvStr, value);
		});
		csvStr += newLine;
		data = data || "{rows:[]}";
		if (!data.rows) {
			data = JSON.parse(data);
		}
		var hasIndex = colNames[0] === '序号';
		$.each(data.rows, function (index, value) {
			if (hasIndex) {
				csvStr = pushComma(csvStr, index + 1);
			}
			$.each(colModels, function (i, colModel) {
				if (i !== 0 || !hasIndex) {
					var colValue = value[colModel.index];
					if (colModel.formatter) {
						colValue = colModel.formatter(colValue, colModel.formatoptions, value);
						if (checkHtml(colValue)) {
							colValue = $(colModel.formatter(colValue, colModel.formatoptions, value)).text();
						}
					}
					colValue = (colValue || '') + "";
					csvStr = pushComma(csvStr, colValue);
				}
			});
			csvStr += newLine;
		});
		return csvStr;
	}

	/**
	 * 将产生的字符串下载下来
	 * @param csvStr csv字符串
	 * @param all 是否下载的全部数据
	 */
	function handleDownload(csvStr, all, filter) {
		var param = list.jqGrid("getGridParam");
		var fileName = (param.caption || "文件下载") + (all ? filter ? "(自定义)" : "(全部)" : "(第" + param.postData.page + "页)") + ".csv";
		if (window.navigator.msSaveOrOpenBlob) {
			var href = "\ufeff" + csvStr;
			var blob = new Blob([decodeURIComponent(encodeURI(href))], {
				type: 'text/csv;charset=utf-8;'
			});
			navigator.msSaveBlob(blob, fileName);
		} else {
			var href = 'data:text/csv;charset=utf-8,\ufeff' + csvStr;
			var encodeUri = encodeURI(href);
			var link = document.createElement("a");
			link.setAttribute("href", encodeUri);
			link.setAttribute("target", '_blank');
			link.setAttribute("download", fileName);
			document.body.appendChild(link);
			link.click();
			setTimeout(function () {
				document.body.removeChild(link);
			}, 0);
		}
	}

}
