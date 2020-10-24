$(function () {
    CurentTime();
    setInterval(CurentTime, 1000);
    /*nav导航*/
    $(".py_ul_l li a").eq("4").addClass("nav_bg");
    $(".py_ul_l li a").click(function () {
        $(".py_ul_l li a").removeClass("nav_bg");
        $(this).addClass("nav_bg");
    });
    $(".py_ul_r li a").eq("4").addClass("nav_bg");
    $(".py_ul_r li a").click(function () {
        $(".py_ul_r li a").removeClass("nav_bg");
        $(this).addClass("nav_bg");
    });

    /*组件预估价值*/
    // value();
    /*成本图*/
    // cost();
    /*已有降本案例*/
    //trend();
    /*工期图*/
    // time();
    /*可降低成本*/
    // reduce();
    /*可缩短工期*/
    // shorten();

});

/*日期*/
function CurentTime() {
    var now = new Date();
    var year = now.toLocaleDateString(); //年月日
    var hh = now.getHours(); //时
    var mm = now.getMinutes(); //分
    var ss = now.getSeconds(); //秒
    var week = now.getDay(); //星期
    switch (week) {
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

/*组件预估价值*/
function value(data) {
    //应用名称
    var nameList = [];
    //缩短周期
    var reduceTimeNumlist = [];
    //降低成本
    var reduceCostNumlist = [];
    if (data.nameList) {
        nameList = data.nameList.reverse();
    }
    if (data.reduceTimeNumlist) {
        reduceTimeNumlist = data.reduceTimeNumlist.reverse();
    }
    if (data.reduceCostNumlist) {
        reduceCostNumlist = data.reduceCostNumlist.reverse();
    }
    var dom = document.getElementById("value");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    app.title = '折柱混合';
    option = {
        color: ['#3398DB'],
        tooltip: {
            trigger: 'axis',
            axisPointer: { // 坐标轴指示器，坐标轴触发有效
                type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            top: '25px',
            right: '15px',
            textStyle: {
                color: '#fff',
                fontSize: '14'
            },
            data: ['可缩短工期（人月）', '可降低成本（万元）']
        },
        grid: {
            left: '7%',
            right: '7%',
            bottom: '2%',
            containLabel: true
        },
        xAxis: [{
            name: '（万）',
            type: 'value',
            min: 0,
            max: 250,
            axisTick: {
                alignWithLabel: true
            },
            axisLabel: {
                textStyle: {
                    color: '#fff', //坐标值得具体的颜色
                    fontSize: '14'
                }
            },
            axisLine: {
                lineStyle: {
                    color: '#0b0f36'
                }
            },
            splitLine: {
                lineStyle: {
                    color: '#0b2df8'
                }
            }
        }],
        yAxis: [{
            type: 'category',
            data: nameList,
            axisLabel: {
                textStyle: {
                    color: '#fff', //坐标值得具体的颜色
                    fontSize: '14'
                }
            },
            axisLine: {
                lineStyle: {
                    color: '#0b2df8'
                }
            }
        }],
        series: [{
            name: '可缩短工期（人月）',
            type: 'bar',
            barWidth: '30%',
            data: reduceTimeNumlist,
            itemStyle: {
                normal: {
                    barBorderRadius: 30,
                    color: new echarts.graphic.LinearGradient(
                        1, 0, 0, 0, [{
                            offset: 1,
                            color: '#007bf4'
                        },
                            {
                                offset: 0,
                                color: '#b77aff'
                            }
                        ]
                    )
                }
            },
        },
            {
                name: '可降低成本（万元）',
                type: 'bar',
                barWidth: '30%',
                data: reduceCostNumlist,
                itemStyle: {
                    normal: {
                        barBorderRadius: 30,
                        color: new echarts.graphic.LinearGradient(
                            1, 0, 0, 0, [{
                                offset: 1,
                                color: '#00a1eb'
                            },
                                {
                                    offset: 0,
                                    color: '#00dee1'
                                }
                            ]
                        )
                    }
                },
            },
        ]

    };
    ;
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}

/*标准提质情况*/
function cost(data) {
    var datas = [];
    for(var i in data){
        datas = datas.concat(data[i]['children']);
    }
    datas = toJsonNameAndValue(datas,'fileCount','classifyName');
    data = toJsonNameAndValue(data,'fileCount','classifyName');
    var dom = document.getElementById("cost");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    option = {
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        //		legend: {
        //			orient: 'vertical',
        //			x: 'right',
        //			data: ['知乎', '营销广告', '搜索引擎', '邮件营销', '联盟广告', '视频广告', '百度', '谷歌', '必应', '其他']
        //		},
        series: [{
            name: '数量',
            type: 'pie',
            selectedMode: 'single',
            center: ['40%', '50%'],
            radius: [0, '50%'],
            color: ['#49DFF0', '#015fa7', '#5e5288'],
            label: {
                normal: {
                    position: 'inner'
                }
            },
            labelLine: {
                normal: {
                    show: false
                }
            },
            data: data
        },
            {
                name: '数量',
                type: 'pie',
                color: ['#188FC7', '#1D6D90', '#6F7FDB', '#81C1F2', '#6243FA', '#59C69F', '#4379C9', '#A2D15D'],
                center: ['40%', '50%'],
                radius: ['60%', '80%'],
                data: datas
            }
        ]
    };
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}
function toJsonNameAndValue(data,key1,key2){
    for(var i = 0; i < data.length; i++) {
        for(key in data[i]){
            if(key!=key1&&key!=key2){
                delete data[i][key];
            }
        }
        data[i]["value"] = parseInt(data[i][key1]);
        delete data[i][key1];

        data[i]["name"] = data[i][key2];
        delete data[i][key2];
    }
    return data;
}
/*已有降本案例*/
function trend(_option) {
    var dom = document.getElementById("trend");
    var myChart = echarts.init(dom);
    var opNames = ['建设成本', '使用成本','维护成本'];
    var app = {};
    // option = null;
    // option = {
    //     tooltip: {
    //         trigger: 'axis',
    //         axisPointer: { // 坐标轴指示器，坐标轴触发有效
    //             type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
    //         }
    //     },
    //     grid: {
    //         left: '1%',
    //         right: '4%',
    //         bottom: '8%',
    //         containLabel: true
    //     },
    //     xAxis: {
    //         type: 'category',
    //         axisLabel: {
    //             textStyle: {
    //                 color: '#fff', //坐标值得具体的颜色
    //                 fontSize: '14'
    //             }
    //         },
    //         axisLine: {
    //             lineStyle: {
    //                 color: '#0b0f36'
    //             }
    //         },
    //         data: _option.appNames
    //     },
    //     yAxis: [{
    //         name: '(万元)',
    //         nameTextStyle: {
    //             color: '#fff',
    //             padding: [0, 30, 0, 0],
    //         },
    //         type: 'value',
    //         axisLabel: {
    //             textStyle: {
    //                 color: '#fff', //坐标值得具体的颜色
    //                 fontSize: '14'
    //             }
    //         },
    //         axisLine: {
    //             lineStyle: {
    //                 color: '#0b0f36'
    //             }
    //         },
    //         splitLine: {
    //             lineStyle: {
    //                 color: '#0b2df8'
    //             }
    //         }
    //     }, {
    //         name: '(人/天)',
    //
    //         nameTextStyle: {
    //             color: '#fff',
    //             padding: [0, 30, 0, 0],
    //         },
    //         position: "right",
    //         type: 'value',
    //         axisLabel: {
    //             textStyle: {
    //                 color: '#fff', //坐标值得具体的颜色
    //                 fontSize: '14'
    //             }
    //         },
    //         axisLine: {
    //             lineStyle: {
    //                 color: '#0b0f36'
    //             }
    //         },
    //         splitLine: {
    //             lineStyle: {
    //                 color: '#0b2df8'
    //             }
    //         }
    //     }],
    //     series: [{
    //         name: '节约成本（万元）',
    //         type: 'line',
    //
    //         barWidth: 30,
    //         label: {
    //             normal: {
    //                 show: true,
    //                 position: 'insideRight'
    //             }
    //         },
    //         data: _option.appCosts
    //     },
    //         {
    //             name: '节约时间（人天）',
    //             type: 'line',
    //
    //             label: {
    //                 normal: {
    //                     show: true,
    //                     position: 'insideRight'
    //                 }
    //             },
    //             yAxisIndex: 1,
    //             data: _option.appTime
    //         }
    //     ],
    //     color: ['#844af6', '#0e43d0', '#169de0', '#42dee8', '#29d663']
    // };
    option = {
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            textStyle: {
                color: '#fff',
                fontSize: '14'
            },
            data: opNames
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        yAxis: {
            name:'单位/万',
            nameGap:20,
            nameTextStyle:{
              color:'#fff',
              padding:[0,30,0,0],
            },
            type: 'value',
            axisLabel: {
              textStyle: {
                color: '#fff', //坐标值得具体的颜色
                fontSize: '14'
              }
            },
            axisLine: {
              lineStyle: {
                color: '#0b0f36'
              }
            },
            splitLine: {
              lineStyle: {
                color: '#0b2df8'
              }
            }
          },
        xAxis: {
            type: 'category',
            axisLine: {
                lineStyle: {
                  color: '#0b0f36'
                }
              },
            axisLabel: {
            	textStyle: {
                    color: '#fff', //坐标值得具体的颜色
                    fontSize: '14'
                  },
                interval: 0,
                formatter:function(value)
                {
                    var ret = "";//拼接加\n返回的类目项
                    var maxLength = 4;//每项显示文字个数
                    var valLength = value.length;//X轴类目项的文字个数
                    var rowN = Math.ceil(valLength / maxLength); //类目项需要换行的行数
                    if (rowN > 1)//如果类目项的文字大于3,
                    {
                        for (var i = 0; i < rowN; i++) {
                            var temp = "";//每次截取的字符串
                            var start = i * maxLength;//开始截取的位置
                            var end = start + maxLength;//结束截取的位置
                            //这里也可以加一个是否是最后一行的判断，但是不加也没有影响，那就不加吧
                            temp = value.substring(start, end) + "\n";
                            ret += temp; //凭借最终的字符串
                        }
                        return ret;
                    }
                    else {
                        return value;
                    }
                }  ,
                textStyle: {
                    color: '#fff', //坐标值得具体的颜色
                    fontSize: '14'
                }
            },
            data: _option.names
        },
        color: ['#844af6', '#0e43d0', '#169de0', '#42dee8', '#29d663'],
        series: [
            {
                name: opNames[0],
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true
                    }
                },
                data: _option.builds
            },
            {
                name: opNames[1],
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                    }
                },
                data: _option.uses
            },
            {
                name: opNames[2],
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                    }
                },
                barWidth:50,
                data: _option.protects
            }
        ]
    };
    ;
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}

/*工期图*/
function time(data) {
    var dom = document.getElementById("time");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    option = {
        tooltip: {
            trigger: 'item'
        },
        series: [{
            name: '增效情况',
            type: 'pie',
            color: ['#29D663', '#844AF6', '#2354D8', '#00bcd4'],
            radius: '80%',
            center: ['40%', '50%'],
            labelLine: {
                normal: {
                    length: 1
                }
            },
            data: [{
                value: data.app,
                name: '支撑应用'
            },
                {
                    value: data.service,
                    name: '支撑服务'
                },
                {
                    value: data.module,
                    name: '支撑模块'
                },
                {
                    value: data.platform,
                    name: '支撑平台'
                }
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }],
    };
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}

/*可降低成本*/
function reduce(data) {
    var dom = document.getElementById("reduce");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    app.title = '折柱混合';
    option = {
        tooltip: {
            trigger: 'item'
        },
        series: [{
            name: '可降低成本（万元）',
            type: 'pie',
            radius: '80%',
            center: ['40%', '50%'],
            labelLine: {
                normal: {
                    length: 1
                }
            },
            data: [{
                value: data.protect,
                name: '维护成本'
            },
                {
                    value: data.build,
                    name: '建设成本'
                },
                {
                    value: data.use,
                    name: '使用成本'
                }
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }],
        color: ['#844af6', '#188fc7', '#015fa7', '#0352a7']
    };
    ;
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}

/*可缩短工期*/
function shorten(data) {
    var dom = document.getElementById("shorten");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    option = {
        tooltip: {
            trigger: 'item'
        },
        series: [{
            name: '降低成本',
            type: 'pie',
            color: ['#116192', '#42DEE8', '#31E8A7','#24a6f3'],
            radius: '80%',
            center: ['40%', '50%'],
            labelLine: {
                normal: {
                    length: 1
                }
            },
            data: [{
                value: data.app,
                name: '支撑应用'
            },
                {
                    value: data.service,
                    name: '支撑服务'
                },
                {
                    value: data.module,
                    name: '支撑模块'
                },
                {
                    value: data.platform,
                    name: '支撑平台'
                }
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }],
    };
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}

/*降本情况*/
function setReduce(data, list, document) {

    if(!data.length){
    data = transObj(data, list);}
    setRollTime(data.length,document);
    
    if (data) {
        var text = ""
        for (var i = 0; i < data.length; i++) {
            text += "<tr><td>" + (i + 1) + "</td>";
            for (var j = 0; j < list.length; j++) {
                text += "<td>" + realNumTotoFixed(data[i][list[j]]) + "</td>";
            }
            text += "</tr>";
        }
        $("." + document).append(text);
        var rate = $("." + document).parents('.table-rolling').height()/25;
        $("." + document).parents('.table-rolling').css('animation-duration',rate+'s');
    }
}

/** 设置滚动速度*/
function setRollTime(rows,document){
    var rollTime = rows*2;
    var rollTimeanimation = "rollUp "+rollTime+"s infinite linear";
    $("#"+document).css({
    		"animation": rollTimeanimation
    })
}

/*字段数组转实体数组*/
function transObj(data, list) {
    var result = [];
    var cellNum = 0;
    if (data[list[0]]) {
        cellNum = data[list[0]].length;
    }
    for (var i = 0; i < cellNum; i++) {
        var cell = {};
        for (var j in list) {
            if (data[list[j]]) {
                cell[list[j]] = data[list[j]][i];
            }
        }
        result.push(cell);
    }
    return result;
}
function realNumTotoFixed(val) {
    // isNaN()函数 把空串 空格 以及NUll 按照0来处理 所以先去除
    if (val === "" || val == null) {
        return false;
    }
    if (!isNaN(val)) {
    	try {
    	  //在这里运行代码
    		return val.toFixed(1);
    	} catch(err) {
    	  //在这里处理错误
    		return val;
    	}
        
    } else {
        return val;
    }
}