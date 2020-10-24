$(function() {
	CurentTime();
	setInterval(CurentTime, 1000);
	/*nav导航*/
	$(".py_ul_l li a").eq("5").addClass("nav_bg");
	$(".py_ul_l li a").click(function() {
		$(".py_ul_l li a").removeClass("nav_bg");
		$(this).addClass("nav_bg");
	});
	$(".py_ul_r li a").eq("0").addClass("nav_bg");
	$(".py_ul_r li a").click(function() {
		$(".py_ul_r li a").removeClass("nav_bg");
		$(this).addClass("nav_bg");
	});

	/*进度条*/
	var value = 7;
	if(value == 1) {
		$(".jd_value").html("10%");
		$(".icon_pic").eq("0").addClass("icon_pic_top");
	} else if(value == 2) {
		$(".jd_value").html("20%");
		$(".icon_pic").eq("0").addClass("icon_pic_top");
		$(".icon_pic").eq("1").addClass("icon_pic_top");
	} else if(value == 3) {
		$(".jd_value").html("30%");
		$(".icon_pic").eq("0").addClass("icon_pic_top");
		$(".icon_pic").eq("1").addClass("icon_pic_top");
		$(".icon_pic").eq("2").addClass("icon_pic_top");
	} else if(value == 4) {
		$(".jd_value").html("40%");
		$(".icon_pic").eq("0").addClass("icon_pic_top");
		$(".icon_pic").eq("1").addClass("icon_pic_top");
		$(".icon_pic").eq("2").addClass("icon_pic_top");
		$(".icon_pic").eq("3").addClass("icon_pic_top");
	} else if(value == 5) {
		$(".jd_value").html("50%");
		$(".icon_pic").eq("0").addClass("icon_pic_top");
		$(".icon_pic").eq("1").addClass("icon_pic_top");
		$(".icon_pic").eq("2").addClass("icon_pic_top");
		$(".icon_pic").eq("3").addClass("icon_pic_top");
		$(".icon_pic").eq("4").addClass("icon_pic_top");
	} else if(value == 6) {
		$(".jd_value").html("60%");
		$(".icon_pic").eq("0").addClass("icon_pic_top");
		$(".icon_pic").eq("1").addClass("icon_pic_top");
		$(".icon_pic").eq("2").addClass("icon_pic_top");
		$(".icon_pic").eq("3").addClass("icon_pic_top");
		$(".icon_pic").eq("4").addClass("icon_pic_top");
		$(".icon_pic").eq("5").addClass("icon_pic_top");
	} else if(value == 7) {
		$(".jd_value").html("70%");
		$(".icon_pic").eq("0").addClass("icon_pic_top");
		$(".icon_pic").eq("1").addClass("icon_pic_top");
		$(".icon_pic").eq("2").addClass("icon_pic_top");
		$(".icon_pic").eq("3").addClass("icon_pic_top");
		$(".icon_pic").eq("4").addClass("icon_pic_top");
		$(".icon_pic").eq("5").addClass("icon_pic_top");
		$(".icon_pic").eq("6").addClass("icon_pic_top");
	} else if(value == 8) {
		$(".jd_value").html("80%");
		$(".icon_pic").eq("0").addClass("icon_pic_top");
		$(".icon_pic").eq("1").addClass("icon_pic_top");
		$(".icon_pic").eq("2").addClass("icon_pic_top");
		$(".icon_pic").eq("3").addClass("icon_pic_top");
		$(".icon_pic").eq("4").addClass("icon_pic_top");
		$(".icon_pic").eq("5").addClass("icon_pic_top");
		$(".icon_pic").eq("6").addClass("icon_pic_top");
		$(".icon_pic").eq("7").addClass("icon_pic_top");
	} else if(value == 9) {
		$(".jd_value").html("90%");
		$(".icon_pic").eq("0").addClass("icon_pic_top");
		$(".icon_pic").eq("1").addClass("icon_pic_top");
		$(".icon_pic").eq("2").addClass("icon_pic_top");
		$(".icon_pic").eq("3").addClass("icon_pic_top");
		$(".icon_pic").eq("4").addClass("icon_pic_top");
		$(".icon_pic").eq("5").addClass("icon_pic_top");
		$(".icon_pic").eq("6").addClass("icon_pic_top");
		$(".icon_pic").eq("7").addClass("icon_pic_top");
		$(".icon_pic").eq("8").addClass("icon_pic_top");
	} else if(value == 10) {
		$(".jd_value").html("100%");
		$(".icon_pic").eq("0").addClass("icon_pic_top");
		$(".icon_pic").eq("1").addClass("icon_pic_top");
		$(".icon_pic").eq("2").addClass("icon_pic_top");
		$(".icon_pic").eq("3").addClass("icon_pic_top");
		$(".icon_pic").eq("4").addClass("icon_pic_top");
		$(".icon_pic").eq("5").addClass("icon_pic_top");
		$(".icon_pic").eq("6").addClass("icon_pic_top");
		$(".icon_pic").eq("7").addClass("icon_pic_top");
		$(".icon_pic").eq("8").addClass("icon_pic_top");
		$(".icon_pic").eq("9").addClass("icon_pic_top");
	}

	/*关联情况*/
	dataPlatform_glqk_fun("");
	/*平台预警级别*/
	dataPlatform_platformError("");
	/*  应用预警情况分析*/
	dataPlatform_yyyjqk_fun("");
	/*应用预警情况*/
	dataPlatform_ssdy("");
	/*预警产生处理情况*/

	dataPlatform_yjcscl_fun("");

});
/*日期*/
function CurentTime() {
	var now = new Date();
	var year = now.toLocaleDateString(); //年月日
	var hh = now.getHours(); //时
	var mm = now.getMinutes(); //分
	var ss = now.getSeconds(); //秒
	var week = now.getDay(); //星期
	switch(week) {
		case 1:
			week = '一';
			break;
		case 2:
			week = '二';
			break;
		case 3:
			week = '三';
			break;
		case 4:
			week = '四';
			break;
		case 5:
			week = '五';
			break;
		case 6:
			week = '六';
			break;
		case 0:
			week = '日';
			break;
	}
	var data = year + " " + fnW(hh) + ":" + fnW(mm) + ":" + fnW(ss) + " 星期" + week;
	$(".date").html(data);

}

function fnW(str) {
	var num;
	str >= 10 ? num = str : num = "0" + str;
	return num;
}
var colors = ["00E59A",'8E39ED','d90b0d','fc6400','fc6400','D1CB12','0067ff','fc6400','D1CB12','0067ff','0067ff'];
var sizes = [40,39,38,37,36,35,34,33,32,31,30,29,28,27,26];
var dept_name =["党政办公室","组织与人力资源部","投资促进局","规划建设局","财政局","创业服务中心","科技创新创业局","产业发展局","政务服务中心","监察审计局","社会事务局","国土分局","国税局","地税分局","工商分局","质监分局"];
var app_name =["大数据精准经济监测","大数据精准市场监管","大数据精准信用评估","大数据精准生态监测","大数据精准国土监测","大数据精准移动办公","大数据精准安全监管","智慧质监"];
var dept_app_link=["共享交换平台","大数据分析平台","统一监控平台","安全保障平台","统一运维平台","移动终端平台","权限管理系统","云盘管理系统","标准管理系统","预警管理系统","消息管理系统","模块监控系统","短信管理系统","日志管理系统","邮件管理系统","日志服务","消息队列服务","发布管道服务","邮件管理服务","服务管理中心","文件服务","统一认证服务","预警管道服务","共享交换服务","共性管理模块","共性管理工具","模块管理中心","日志模块","消息队列模块","统一认证模块"];
/*
 * 数组去重
 */
function toHeavy(list){
	var res = []; 
	var json = {}; 
	for(var i = 0; i < list.length; i++){
		if(!json[list[i]]){ 
			res.push(list[i]); 
			json[list[i]] = 1; 
		} 
	} 
	return res;
}


//关系情况
function dataPlatform_glqk_fun(appid){
	
	ajaxHengyun({
		
		
		url: gateUrl + "/api/piping/fairwarn/relationship",
		success:function (result){
			
			var data = result.data;
			
			//var data = [{depName:"aa",appName:"bbb",count:1},{depName:"aa",appName:"ccc",count:2},{depName:"bb",appName:"bbb",count:3},{depName:"bb",appName:"ccc",count:4}];
			var xAxis3D = [];
			var yAxis3D = [];
			var optionData = [];
			var tempDate = {};
			for(var i in data){
				xAxis3D.push(data[i].appName );
				yAxis3D.push(data[i].department );
				tempDate[data[i].appName+"--"+data[i].department] = data[i].count;
			}
			xAxis3D = toHeavy(xAxis3D);
			yAxis3D = toHeavy(yAxis3D);
			for(var i=0;i<xAxis3D.length;i++){
				var xAxis = xAxis3D[i]
				for(var j=0; j<yAxis3D.length;j++){
					
					optionData.push([i,j,tempDate[xAxis3D[i]+"--"+yAxis3D[j]]]);
				}
			}
			dataPlatform_glqk_fun_echarts(xAxis3D,yAxis3D,optionData);
		}
	})
}
    
/*关联情况*/
function dataPlatform_glqk_fun_echarts(xAxis3D,yAxis3D,optionData) {

	var dom = document.getElementById("dataPlatform_glqk");
	var myChart = echarts.init(dom);

	var hours = xAxis3D;
	var days = yAxis3D;

	var data = optionData;
	var option = {
	    tooltip: {
	    	formatter: function(x){
	    		return "应用："+hours[x.data.value[0]] + "<br />部门：" +  days[x.data.value[1]] + "<br />预警数：" +  x.data.value[2];
	    	},
	    },
	    visualMap: {
	        max: 20,
	        inRange: {
	            color: ['#313695', '#4575b4', '#74add1', '#abd9e9', '#e0f3f8', '#ffffbf', '#fee090', '#fdae61', '#f46d43', '#d73027', '#a50026']
	        }
	    },
	    xAxis3D: {
	        type: 'category',
	        data: hours,
	        name:"",
	        axisLabel: {
				show: true,
				textStyle: {
					color: '#fff',
					fontSize: 12,
				},
			},
	    },
	    yAxis3D: {
	        type: 'category',
	        data: days,
	        name:"",
	        axisLabel: {
				show: true,
				textStyle: {
					color: '#fff',
					fontSize: 12,
				},
			},
	    },
	    zAxis3D: {
	        type: 'value',
	        name:"预警数量",
	        nameTextStyle:{
	        	color:'#fff'
	        },
	        axisLabel: {
				show: true,
				textStyle: {
					color: '#fff',
					fontSize: 12,
				},
			},
	    },
	    grid3D: {
	        boxWidth: 200,
	        boxDepth: 80,
	        viewControl: {
	            // projection: 'orthographic'
	        },
	        light: {
	            main: {
	                intensity: 1.2,
	                shadow: true
	            },
	            ambient: {
	                intensity: 0.3
	            }
	        },
            axisLine:{
                lineStyle:{
                    color:'#fff'
				}
            },
			axisPointer:{
	        	lineStyle:{
	        		color:'#FFD603'
				}
			},
	        axisLabel: {
				show: true,
				textStyle: {
					color: '#B2B2B2',
					fontSize: 12,
				},
			},
	    },
	    series: [{
	        type: 'bar3D',
	        data: data.map(function (item) {
	            return {
	                value: [item[0], item[1], item[2]],
	            }
	        }),
	        shading: 'lambert',

	        label: {
	            textStyle: {
	                fontSize: 16,
	                borderWidth: 1
	            }
	        },

	        emphasis: {
	            label: {
	                textStyle: {
	                    fontSize: 20,
	                    color: '#ff5e00'
	                }
	            },
	            itemStyle: {
	                color: '#ff5e00'
	            }
	        }
	    }]
	}
	if(option && typeof option === "object") {
		myChart.setOption(option, true);
	}
}

/*平台预警级别*/
function dataPlatform_platformError(appid){
	dataPlatform_platformError_echarts();
	ajaxHengyun({
        url: gateUrl + "/api/warn/fairwarn/level?appid="+appid,
        success: function (rdate) {
           var data = rdate.data;
           var list = [];
           var list1 = [{value: 0,name: '较大预警',itemStyle: {color: '#fc6400'}}, {value: 0,name: '一般预警',itemStyle: {color: '#fffb13'}},
			{value: 0,name: '低风险预警',itemStyle: {color: '#0067ff'}}, {value: 0,name: '重大预警',itemStyle: {color: '#d90b0d'}}];
           if(data!=null && data.length>0){
        	   for (var i = 0; i < data.length; i++) {
        		   var entity = {};
        		   entity.value = data[i].count;
        		   var itemStyles = {};
	       		    var normals ={};
	       		    itemStyles.normal=normals;
	       		   entity.itemStyle=itemStyles;
				   if(data[i].level==1){
					   normals.color= "#0067ff"; 
					   entity.name = "低风险预警";
				   }else if(data[i].level==2){
					   normals.color= "#fffb13"; 
					   entity.name = "一般预警";
				   }else if(data[i].level==3){
					   normals.color= "#fc6400"; 
					   entity.name = "较大预警";
				   }else if(data[i].level==4){
					   normals.color= "#d90b0d"; 
					   entity.name = "重大预警";
				   }
				   list.push(entity);
        	   }
        	   dataPlatform_platformError_echarts(list);
           }else{
        	   dataPlatform_platformError_echarts(list1); 
           }
        },error: function (date) {
        	
        }
    });
}
/*平台预警级别*/
function dataPlatform_platformError_echarts(list) {
	var dom = document.getElementById("dataPlatform_platformError");
	var myChart = echarts.init(dom);
	var app = {};
	option = null;
	option = {
		tooltip: {
			trigger: 'item',
			formatter: "{a} <br/>{b} : {c} ({d}%)"
		},
		series: [{
			name: '数量',
			type: 'pie',
			radius: '70%',
			center: ['50%', '50%'],
			data:list,
			itemStyle: {
				normal: {
					label: {
						show: true,
						formatter: '{b}'
					},
					labelLine: {
						show: false
					}
				},
				emphasis: {
					shadowBlur: 10,
					shadowOffsetX: 0,
					shadowColor: 'rgba(0, 0, 0, 0.5)'
				}
			}
		}]
	};;
	if(option && typeof option === "object") {
		myChart.setOption(option, true);
	}
}

/*应用预警情况分析*/
function dataPlatform_yyyjqk_fun(appid){
	//dataPlatform_yyyjqk_fun_echarts();
	
	ajaxHengyun({
        url: gateUrl + "/api/warn/fairwarn/type?appid="+appid,
        success: function (rdate) {
          var data =  rdate.data;
          
          if(data!=null && data.appNames){
	          /*[高新区发展平台, 政务部, 武当山开发区, 贵阳开发区, 高新区平台]
	          [跳操不规范, 系统登录问题, 乱扔垃圾, 工作超时, 秩序]
	          [[1, 0, 4, 0, 3], [6, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 3, 0, 3, 0]]*/
        	  var indicatorList = [];
        	  var dataList = [];
	          var appNames = data.appNames;
	          var types = data.types;
	          var counts = data.counts;
	          for(var i=0;i<appNames.length;i++){
	        	  dataEntity ={};
	        	  dataEntity.name=appNames[i];
	        	  dataEntity.value=counts[i];
	        	  
	        	  dataList.push(dataEntity);
	        	  
	        	  
	          }
	          
	          var maxNum = 0;
	          
	          for(var i=0;i<5;i++){
	        	  maxNum = 0;
	        	  for(var j=0;j<counts.length;j++){
	        		  if(maxNum < counts[j][i]){
	        			  maxNum = counts[j][i];
	        		  }
	        	  }
	        	  var names = {};
	        	  names.name=types[i]
	        	  names.max = maxNum + 5;
	        	  indicatorList.push(names);
	          }
	          
	          
	          dataPlatform_yyyjqk_fun_echarts(indicatorList,dataList);
          }else{
        	  var indicatorList1 = [{name: '工作超时',max: 6500}, {name: '流程异常',max: 16000},
      			{name: '考核异常',max: 30000}, {name: '系统对接',max: 38000}, {name: '人员变动',max: 52000}];
        	  var dataList1 = [];
        	  dataPlatform_yyyjqk_fun_echarts(indicatorList1,dataList1); 
          }
        },error: function (date) {
        	//dataPlatform_yyyjqk_fun_echarts(indicatorList1,dataList1);
        }
    });
}
function dataPlatform_yyyjqk_fun_echarts(indicatorList,dataList) {
	var dom = document.getElementById("dataPlatform_yyyjqk");
	var myChart = echarts.init(dom);
	var app = {};
	option = null;
	option = {
		title: {},
		tooltip: {},
		radar: {
			// shape: 'circle',
			radius: '60%',
			name: {
				textStyle: {
					color: '#2a9cff',
					//					fontWeight: 'bold',
					/*backgroundColor: '#082752',*/
					borderRadius: 3,
					padding: [3, 5],
					fontSize: '14'
				}
			},
			indicator: indicatorList,
			splitArea: {
				areaStyle: {
					/* color: ['rgba(114, 172, 209, 0.2)',
					 'rgba(114, 172, 209, 0.4)', 'rgba(114, 172, 209, 0.6)',
					 'rgba(114, 172, 209, 0.8)', 'rgba(114, 172, 209, 1)'],
					 */
					color: '#082752'
				}
			},
			splitLine: {
				lineStyle: {
					color: ['rgba(1, 122, 179,1)',
						'rgba(1, 122, 179,1)', 'rgba(1, 122, 179,1)',
						'rgba(1, 122, 179,1)', 'rgba(1, 122, 179,1)'
					],
					width: '3'
				}
			},
			axisLine: {
				lineStyle: {
					color: '#0272a9',
					width: '3'
				}
			}
		},
		series: [{
			type: 'radar',
			// areaStyle: {normal: {}},
			data: dataList,
		}]
	};
	if(option && typeof option === "object") {
		myChart.setOption(option, true);
	}
}

/*应用预警情况*/
function dataPlatform_ssdy(appid){
	var myDatas = ["大数据精准经济监测","大数据精准市场监管","大数据精准信用评估","大数据精准生态监测","大数据精准国土监测","大数据精准移动办公","大数据精准安全监管","智慧质监","科技创新创业局","产业发展局"];
	var databeasts = {
		1: [389, 370, 324, 262, 259, 232, 214, 196, 176, 133],
		2: [389, 370, 324, 262, 259, 232, 214, 196, 176, 133],
		3: [389, 370, 324, 262, 259, 232, 214, 196, 176, 133],
		4: [389, 370, 324, 262, 259, 232, 214, 196, 176, 133],
		5: [389, 370, 324, 262, 259, 232, 214, 196, 176, 133],
		6: [389, 370, 324, 262, 259, 232, 214, 196, 176, 133],
		7: [389, 370, 324, 262, 259, 232, 214, 196, 176, 133],
		8: [389, 370, 324, 262, 259, 232, 214, 196, 176, 133],
		9: [389, 370, 324, 262, 259, 232, 214, 196, 176, 133],
		10: [389, 370, 324, 262, 259, 232, 214, 196, 176, 133],
		11: [389, 370, 324, 262, 259, 232, 214, 196, 176, 133],
		12: [389, 370, 324, 262, 259, 232, 214, 196, 176, 133],
	};
	var timeLineData = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];
	var databeautys = {
		1: [389, 370, 324, 262, 259, 232, 214, 196, 176, 133],
		2: [389, 370, 324, 262, 259, 232, 214, 196, 176, 133],
		3: [389, 370, 324, 262, 259, 232, 214, 196, 176, 133],
		4: [389, 370, 324, 262, 259, 232, 214, 196, 176, 133],
		5: [389, 370, 324, 262, 259, 232, 214, 196, 176, 133],
		6: [389, 370, 324, 262, 259, 232, 214, 196, 176, 133],
		7: [389, 370, 324, 262, 259, 232, 214, 196, 176, 133],
		8: [389, 370, 324, 262, 259, 232, 214, 196, 176, 133],
		9: [389, 370, 324, 262, 259, 232, 214, 196, 176, 133],
		10: [389, 370, 324, 262, 259, 232, 214, 196, 176, 133],
		11: [389, 370, 324, 262, 259, 232, 214, 196, 176, 133],
		12: [389, 370, 324, 262, 259, 232, 214, 196, 176, 133],

	};
	ajaxHengyun({
        url: gateUrl + "/api/warn/fairwarn/apps?appid="+appid,
        success: function (rdate) {
        	var data = rdate.data;
        	if(data!=null){
        		var inner =  data.inner;
            	var outer = data.outer;
            	var myData = [];
            	var databeast = [];
            	var myData1 = [];
            	var databeast1 = [];
            	if(inner != null && inner.length>0){
            		for (var i = 0; i < inner.length; i++) {
            			myData.push(inner[i].appName);
                		databeast.push(inner[i].count);
    				}
            	}
            	if(outer != null && outer.length>0){
            		for (var i = 0; i < outer.length; i++) {
            			myData1.push(outer[i].appName);
                		databeast1.push(outer[i].count);
    				}
            	}
            	
            	dataPlatform_ssdy_echarts(myData,myData1,databeast,databeast1);
        	}else{
        		dataPlatform_ssdy_echarts(myDatas,myDatas,databeasts[timeLineData[1]],databeautys[timeLineData[1]]);
        	}
        },error: function (date) {
        	dataPlatform_ssdy_echarts(myDatas,myDatas,databeasts[timeLineData[1]],databeautys[timeLineData[1]]);
        }
    });
}
function dataPlatform_ssdy_echarts(myData,myData1,databeast,databeast1) {
	var dom = document.getElementById("dataPlatform_ssdy");
	var myChart = echarts.init(dom);
	var app = {};
	option = null;
	//------------------------------------引用请注明出处
	option = {
		baseOption: {
			title: {
				text: '内部应用预警情况                            接入应用预警情况',
				x: 'center',
				top: 30,
				textStyle: {
					color: '#40CED3',
					fontWeight: 'normal'
				}

			},
			/*  backgroundColor: '#000',*/
			timeline: {
				show: false,
				axisType: 'category',
				data: [],
			},
			tooltip: {
				show: true,
				trigger: 'axis',
				formatter: '{b}<br/>{a}: {c}个',
				axisPointer: {
					type: 'shadow',
				}
			},

			grid: [{
				show: false,
				left: '4%',
				top: 60,
				bottom: 30,
				containLabel: true,
				width: '40%',
			}, {
				show: false,
				left: '54%',
				top: 60,
				bottom: 50,
				width: '30%'
			}, {
				show: false,
				right: '4%',
				top: 60,
				bottom: 30,
				containLabel: true,
				width: '40%',
			}, ],

			xAxis: [{
				type: 'value',
				inverse: true,
				axisLine: {
					show: false,
				},
				axisTick: {
					show: false,
				},
				position: 'bottom',
				axisLabel: {
					show: true,
					textStyle: {
						color: '#B2B2B2',
						fontSize: 12,
					},
				},
				splitLine: {
					show: true,
					lineStyle: {
						color: '#1F2022',
						width: 1,
						type: 'solid',
					},
				},
			}, {
				gridIndex: 1,
				show: false,
			}, {
				gridIndex: 2,
				type: 'value',
				axisLine: {
					show: false,
				},
				axisTick: {
					show: false,
				},
				position: 'bottom',
				axisLabel: {
					show: true,
					textStyle: {
						color: '#B2B2B2',
						fontSize: 12,
					},
				},
				splitLine: {
					show: true,
					lineStyle: {
						color: '#1F2022',
						width: 1,
						type: 'solid',
					},
				},
			}, ],
			yAxis: [{
				type: 'category',
				inverse: true,
				position: 'right',
				axisLine: {
					show: false
				},
				axisTick: {
					show: false
				},
				axisLabel: {
					show: true,
					margin: 8,
					textStyle: {
						color: '#fff',
						fontSize: 12,
					},

				},
				data: myData,
			}, {
				gridIndex: 1,
				type: 'category',
				inverse: true,
				position: 'left',
				axisLine: {
					show: false
				},
				axisTick: {
					show: false
				},
				axisLabel: {
					show: false,
					textStyle: {
						color: '#fff',
						fontSize: 12,
					},

				},
				data: myData.map(function(value) {
					return {
						value: value,
						textStyle: {
							align: 'center',
						}
					}
				}),
			}, {
				gridIndex: 2,
				type: 'category',
				inverse: true,
				position: 'left',
				axisLine: {
					show: false
				},
				axisTick: {
					show: false
				},
				axisLabel: {
					show: true,
					textStyle: {
						color: '#fff',
						fontSize: 12,
					},

				},
				data: myData1,
			}, ],
			series: [],

		},

		options: [],

	};

	//option.baseOption.timeline.data.push(timeLineData[1]);
	option.options.push({
		title: {

		},
		series: [{
				name: '数量',
				type: 'bar',
				barGap: 20,
				barWidth: 15,
				label: {
					normal: {
						show: false,
					},
					emphasis: {
						show: true,
						position: 'left',
						offset: [0, 0],
						textStyle: {
							color: '#fff',
							fontSize: 14,
						},
					},
				},
				itemStyle: {
					normal: {
						color: new echarts.graphic.LinearGradient(
							1, 0, 0, 0, [{
									offset: 0,
									color: '#DA9E3E'
								},
								{
									offset: 1,
									color: '#DC432A'
								}
							]
						)
					}

				},

				data: databeast,
			},

			{
				name: '数量',
				type: 'bar',
				barGap: 20,
				barWidth: 15,
				xAxisIndex: 2,
				yAxisIndex: 2,
				label: {
					normal: {
						show: false,
					},
					emphasis: {
						show: true,
						position: 'right',
						offset: [0, 0],
						textStyle: {
							color: '#fff',
							fontSize: 14,
						},
					},
				},
				itemStyle: {
					normal: {
						color: new echarts.graphic.LinearGradient(
							1, 0, 0, 0, [{
									offset: 0,
									color: '#0CF2F6'
								},
								{
									offset: 0.5,
									color: '#06BBFA'
								},
								{
									offset: 1,
									color: '#0086FE'
								}
							]
						)
					}

				},
				data: databeast1,
			}
		]
	});

	if(option && typeof option === "object") {
		myChart.setOption(option, true);
	}
}

/*预警产生处理情况*/
function dataPlatform_yjcscl_fun(appid){
	ajaxHengyun({
        url: gateUrl + "/api/warn/fairwarn/months?appid="+appid,
        success: function (rdate) {
        	var data = rdate.data;
        	var pendingList=[];
        	var newComeList=[];
        	var handledList=[];
        	var monthList=[];
        	if(data!=null && data.length>0){
        		for (var i = data.length-1; i < data.length; i--) {
            		pendingList.push(data[i].pending);
            		newComeList.push(data[i].newCome);
            		handledList.push(data[i].handled);
            		monthList.push(data[i].month);
            		if(i==0){
            			break;
            		}
    			}
            	dataPlatform_yjcscl_fun_echarts(monthList,pendingList,newComeList,handledList);
        	}
        },error: function (date) {
        	
        }
    });
}
function dataPlatform_yjcscl_fun_echarts(monthList,pendingList,newComeList,handledList) {
	var dom = document.getElementById("dataPlatform_yjcscl");
	var myChart = echarts.init(dom);
	var app = {};
	option = null;
	app.title = '堆叠柱状图';

	var pendingListMax = Math.max.apply(null,pendingList);
	var newComeListMax = Math.max.apply(null,newComeList) ;
	var handledListMax = Math.max.apply(null,handledList);
	 maxYAxis = Math.max.apply(null,[pendingListMax,newComeListMax,handledListMax])+10;
	
	option = {
		tooltip: {
			trigger: 'axis',
			axisPointer: { // 坐标轴指示器，坐标轴触发有效
				type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
			}
		},
		legend: {
			data: ['待处理', '产生', '已处理'],
			textStyle: {
				fontSize: 12,
				color: '#fff'
			}
		},
		grid: {
			left: '3%',
			right: '4%',
			bottom: '3%',
			containLabel: true
		},
		xAxis: [{
			type: 'category',
			data: monthList,
			axisLabel: {
				interval: 0,
				rotate: 40
			},
			axisLine: {
				lineStyle: {
					color: '#fff',
					fontSize: '12'
				}
			},
		}],
		yAxis: [{
			type: 'value',
			splitLine: {
				show: false
			},
			axisLine: {
				lineStyle: {
					color: '#fff',
					fontSize: '12'
				}
			},
			max: maxYAxis
		}],
		series: [{
				name: '待处理',
				type: 'bar',
				data: pendingList,
				barWidth: 15,
				/*itemStyle: {
				            	 normal: {
			                          color: new echarts.graphic.LinearGradient(
			                              0, 0, 0, 1,
			                              [
			                                  {offset: 0, color: '#f84242'},
			                                  {offset: 1, color: '#f84242'}
			                              ]
			                          )
			                 	}
			                 	
				            	}*/
				itemStyle: {
					color: '#f84242',
					fontSize: '12',
					emphasis: {
						barBorderRadius: 8
					},
					normal: {
						barBorderRadius: 8,
						color: new echarts.graphic.LinearGradient(
							0, 0, 1, 0, [{
									offset: 0,
									color: '#f84242'
								},
								{
									offset: 1,
									color: '#f84242'
								}

							]
						)
					}
				}
			},

			{
				name: '产生',
				type: 'bar',
				stack: '产生',
				data: newComeList,
				barWidth: 15,
				itemStyle: {
					color: '#f8d442',
					fontSize: '12',
					emphasis: {
						barBorderRadius: 8
					},
					normal: {
						barBorderRadius: 8,
						color: new echarts.graphic.LinearGradient(
							0, 0, 1, 0, [{
									offset: 0,
									color: '#f8d442'
								},
								{
									offset: 1,
									color: '#f8d442'
								}

							]
						)
					}
				}
			},
			{
				name: '已处理',
				type: 'bar',
				data: handledList,
				barWidth: 15,
				itemStyle: {
					color: '#42f842',
					fontSize: '12',
					emphasis: {
						barBorderRadius: 8
					},
					normal: {
						barBorderRadius: 8,
						color: new echarts.graphic.LinearGradient(
							0, 0, 1, 0, [{
									offset: 0,
									color: '#42f842'
								},
								{
									offset: 1,
									color: '#42f842'
								}

							]
						)
					}

				}

			}
		]
	};;
	if(option && typeof option === "object") {
		myChart.setOption(option, true);
	}
}