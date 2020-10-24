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
				},
			}
	);
	
    
    function beforeSelectRow() {
    	$(this).jqGrid('resetSelection');
    	return true;  
    }
    
})(jQuery);

/**
 * 解决jqgrid 动态改变宽度问题
 */
$(window).bind("resize", function() {
	var width = $(".grid-section").width();
	$(".ui-jqgrid table").setGridWidth(width);
});

/**
 * 初始化jqgrid的导出功能
 * @param id jqgrid id
 */
function initExport(id) {
	var list = $(id);
	//初始化
	(function () {
		list.navGrid('#pager',
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
		list.navButtonAdd('#pager',
			{
				buttonicon: "ui-icon-mail-closed",
				title: "导出全部数据",
				caption: "导出全部数据",
				position: "last",
				onClickButton: queryTableDatas(true)
			});


		// 添加导出本页功能的按钮
		list.navButtonAdd('#pager',
			{
				buttonicon: "ui-icon-pencil",
				title: "导出本页数据",
				caption: "导出本页数据",
				position: "last",
				onClickButton: queryTableDatas(false)
			});
		// 添加自定义导出功能
		list.navButtonAdd('#pager',
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
							queryTableDatas(true, array)();
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
		data = data || "{items:[]}";
		if (!data.items) {
			data = JSON.parse(data);
		}
		var hasIndex = colNames[0] === '序号';
		$.each(data.items, function (index, value) {
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
			var href = 'data:text/csv;charset=u\tf-8,\ufeff' + csvStr;
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

/**
 *将数组对象插入select
 */
function insertSelect(id,arr){

}

//申请时间格式化
function formatterTime(cellvalue) {
    if(!cellvalue) return "";
    cellvalue=cellvalue.replace(/-/g, "/");
    Date.prototype.Format = function (fmt) { //author: meizz
        var o = {
            "M+": this.getMonth() + 1, //月份
            "d+": this.getDate(), //日
            "h+": this.getHours(), //小时
            "m+": this.getMinutes(), //分
            "s+": this.getSeconds(), //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds() //毫秒
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    };
    return new Date(cellvalue).Format("yyyy-MM-dd hh:mm:ss");
}

