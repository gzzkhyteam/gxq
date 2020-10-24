$(function () {
    CurentTime();
    setInterval(CurentTime, 1000);
    /*nav导航*/
    $(".py_ul_l li a").eq("3").addClass("nav_bg");
    $(".py_ul_l li a").click(function () {
        $(".py_ul_l li a").removeClass("nav_bg");
        $(this).addClass("nav_bg");
    });
    $(".py_ul_r li a").eq("0").addClass("nav_bg");
    $(".py_ul_r li a").click(function () {
        $(".py_ul_r li a").removeClass("nav_bg");
        $(this).addClass("nav_bg");
    });

    /*进度条*/
    var value = 7;
    if (value == 1) {
        $(".jd_value").html("10%");
        $(".icon_pic").eq("0").addClass("icon_pic_top");
    } else if (value == 2) {
        $(".jd_value").html("20%");
        $(".icon_pic").eq("0").addClass("icon_pic_top");
        $(".icon_pic").eq("1").addClass("icon_pic_top");
    } else if (value == 3) {
        $(".jd_value").html("30%");
        $(".icon_pic").eq("0").addClass("icon_pic_top");
        $(".icon_pic").eq("1").addClass("icon_pic_top");
        $(".icon_pic").eq("2").addClass("icon_pic_top");
    } else if (value == 4) {
        $(".jd_value").html("40%");
        $(".icon_pic").eq("0").addClass("icon_pic_top");
        $(".icon_pic").eq("1").addClass("icon_pic_top");
        $(".icon_pic").eq("2").addClass("icon_pic_top");
        $(".icon_pic").eq("3").addClass("icon_pic_top");
    } else if (value == 5) {
        $(".jd_value").html("50%");
        $(".icon_pic").eq("0").addClass("icon_pic_top");
        $(".icon_pic").eq("1").addClass("icon_pic_top");
        $(".icon_pic").eq("2").addClass("icon_pic_top");
        $(".icon_pic").eq("3").addClass("icon_pic_top");
        $(".icon_pic").eq("4").addClass("icon_pic_top");
    } else if (value == 6) {
        $(".jd_value").html("60%");
        $(".icon_pic").eq("0").addClass("icon_pic_top");
        $(".icon_pic").eq("1").addClass("icon_pic_top");
        $(".icon_pic").eq("2").addClass("icon_pic_top");
        $(".icon_pic").eq("3").addClass("icon_pic_top");
        $(".icon_pic").eq("4").addClass("icon_pic_top");
        $(".icon_pic").eq("5").addClass("icon_pic_top");
    } else if (value == 7) {
        $(".jd_value").html("70%");
        $(".icon_pic").eq("0").addClass("icon_pic_top");
        $(".icon_pic").eq("1").addClass("icon_pic_top");
        $(".icon_pic").eq("2").addClass("icon_pic_top");
        $(".icon_pic").eq("3").addClass("icon_pic_top");
        $(".icon_pic").eq("4").addClass("icon_pic_top");
        $(".icon_pic").eq("5").addClass("icon_pic_top");
        $(".icon_pic").eq("6").addClass("icon_pic_top");
    } else if (value == 8) {
        $(".jd_value").html("80%");
        $(".icon_pic").eq("0").addClass("icon_pic_top");
        $(".icon_pic").eq("1").addClass("icon_pic_top");
        $(".icon_pic").eq("2").addClass("icon_pic_top");
        $(".icon_pic").eq("3").addClass("icon_pic_top");
        $(".icon_pic").eq("4").addClass("icon_pic_top");
        $(".icon_pic").eq("5").addClass("icon_pic_top");
        $(".icon_pic").eq("6").addClass("icon_pic_top");
        $(".icon_pic").eq("7").addClass("icon_pic_top");
    } else if (value == 9) {
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
    } else if (value == 10) {
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

    /*部门统计*/

    /*分类排名*/

    /*  统一监管*/

    /*应用统计*/

    /*实时调用情况*/

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

/*部门统计*/

/*分类排名*/

/*  统一监管*/

/*应用统计*/

/*实时调用情况*/

// $(function() {
// 	//计算资源总量
// 	footer_con_1();
// 	//磁盘总空间
// 	footer_con_2();
// 	//内存总量
// 	footer_con_3();
// 	//互联网出口宽带总量
// 	footer_con_4();
// 	//警告处理状态
// 	error_deal_2();
// 	error_deal_1();
// 	//网络拓扑图
// 	py_big_l_pub();
// })

//计算资源总量
function footer_con_1(valueList) {
    var dom = document.getElementById("footer_con_1");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    // data = [
    // 	["0", 22],
    // 	[" ", 25],
    // 	[" ", 23],
    // 	[" ", 26],
    // 	[" ", 28],
    // 	[" ", 32],
    // 	[" ", 31],
    // 	[" ", 29],
    // 	[" ", 19],
    // 	[" ", 23],
    // 	["10", 25],
    // 	[" ", 29],
    // 	[" ", 28],
    // 	[" ", 27],
    // 	[" ", 25],
    // 	[" ", 29],
    // 	[" ", 32],
    // 	[" ", 35],
    // 	[" ", 37],
    // 	[" ", 38],
    // 	["20", 35],
    // 	[" ", 29],
    // 	[" ", 33],
    // 	[" ", 35],
    // 	[" ", 36],
    // 	[" ", 34],
    // 	[" ", 38],
    // 	[" ", 42],
    // 	[" ", 35],
    // 	[" ", 29],
    // 	["30", 25],
    // 	[" ", 26],
    // 	[" ", 22],
    // 	[" ", 28],
    // 	[" ", 25],
    // 	[" ", 30],
    // 	[" ", 29],
    // 	[" ", 33],
    // 	[" ", 37],
    // 	[" ", 32],
    // 	["40", 35],
    // 	[" ", 34],
    // 	[" ", 39],
    // 	[" ", 36],
    // 	[" ", 34],
    // 	[" ", 35],
    // 	[" ", 29],
    // 	[" ", 28],
    // 	[" ", 27],
    // 	[" ", 25],
    // 	["50", 25],
    // 	[" ", 26],
    // 	[" ", 22],
    // 	[" ", 28],
    // 	[" ", 25],
    // 	[" ", 30],
    // 	[" ", 29],
    // 	[" ", 33],
    // 	[" ", 32],
    // 	[" ", 29],
    // 	["60", 25]
    // ];
    //
    // var dateList = data.map(function(item) {
    // 	return item[0];
    // });
    // var valueList = data.map(function(item) {
    // 	return item[1];
    // });
    var dateList = [];
    option = {
        title: {
            text: '计算资源总量/利用率',
            textStyle: {
                color: '#40CED3',
                fontSize: 17,
                fontWeight: 'normal'
            }
        },
        grid: {
            left: '3%',
            right: '3%',
            top: '20%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            data: dateList,
            boundaryGap: false,
            axisLine: {
                lineStyle: {
                    color: '#fff'
                }
            },
            type: 'category'
        },
        yAxis: {
            splitLine: {
                show: false
            },
            min: 0,
            max: 100,
            interval: 20,
            // axisLine: {
            // 	lineStyle: {
            // 		color: '#fff'
            // 	}
            // },
            // type: 'value',
            axisLabel: {
                color: '#fff',
                formatter: '{value} %'    //控制输出格式
            },
            type: 'value',
        },
        series: [{
            type: 'line',
            showSymbol: false,
            data: valueList,
            smooth: true,
            itemStyle: {
                normal: {
                    color: '#BF5365'
                }
            },
            areaStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: 'rgb(255, 158, 68)'
                    }, {
                        offset: 1,
                        color: 'rgba(255, 70, 131,.3)'
                    }])
                }
            }
        }]
    };
    ;
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}

////磁盘总空间
function footer_con_2(valueList) {
    var dom = document.getElementById("footer_con_2");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    // data = [
    // 	["0", 22],
    // 	[" ", 25],
    // 	[" ", 23],
    // 	[" ", 26],
    // 	[" ", 28],
    // 	[" ", 32],
    // 	[" ", 31],
    // 	[" ", 29],
    // 	[" ", 19],
    // 	[" ", 23],
    // 	["10", 25],
    // 	[" ", 29],
    // 	[" ", 28],
    // 	[" ", 27],
    // 	[" ", 25],
    // 	[" ", 29],
    // 	[" ", 32],
    // 	[" ", 35],
    // 	[" ", 37],
    // 	[" ", 38],
    // 	["20", 35],
    // 	[" ", 29],
    // 	[" ", 33],
    // 	[" ", 35],
    // 	[" ", 36],
    // 	[" ", 34],
    // 	[" ", 38],
    // 	[" ", 42],
    // 	[" ", 35],
    // 	[" ", 29],
    // 	["30", 25],
    // 	[" ", 26],
    // 	[" ", 22],
    // 	[" ", 28],
    // 	[" ", 25],
    // 	[" ", 30],
    // 	[" ", 29],
    // 	[" ", 33],
    // 	[" ", 37],
    // 	[" ", 32],
    // 	["40", 35],
    // 	[" ", 34],
    // 	[" ", 39],
    // 	[" ", 36],
    // 	[" ", 34],
    // 	[" ", 35],
    // 	[" ", 29],
    // 	[" ", 28],
    // 	[" ", 27],
    // 	[" ", 25],
    // 	["50", 25],
    // 	[" ", 26],
    // 	[" ", 22],
    // 	[" ", 28],
    // 	[" ", 25],
    // 	[" ", 30],
    // 	[" ", 29],
    // 	[" ", 33],
    // 	[" ", 32],
    // 	[" ", 29],
    // 	["60", 25]
    // ];
    //
    // var dateList = data.map(function(item) {
    // 	return item[0];
    // });
    // var valueList = data.map(function(item) {
    // 	return item[1];
    // });
    var dateList = [];
    option = {
        title: {
            text: '磁盘总空间/利用率',
            textStyle: {
                color: '#40CED3',
                fontSize: 17,
                fontWeight: 'normal'
            }
        },
        grid: {
            left: '3%',
            right: '3%',
            top:'20%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            data: dateList,
            boundaryGap: false,
            axisLine: {
                lineStyle: {
                    color: '#fff'
                }
            },
            type: 'category'
        },
        yAxis: {
            splitLine: {
                show: false
            },
            min: 0,
            max: 100,
            interval: 20,
            // axisLine: {
            // 	lineStyle: {
            // 		color: '#fff'
            // 	}
            // },
            // type: 'value',
            axisLabel: {
                color: '#fff',
                formatter: '{value} %'    //控制输出格式
            },
            type: 'value',
        },
        series: [{
            type: 'line',
            showSymbol: false,
            data: valueList,
            smooth: true,
            itemStyle: {
                normal: {
                    color: '#5EB4E1'
                }
            },
            areaStyle: {
                normal: {
                    color: '#3D72AD'
                }
            }
        }]
    };
    ;
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}

//内存总量
function footer_con_3(valueList) {
    var dom = document.getElementById("footer_con_3");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    // data = [
    // 	["0", 22],
    // 	[" ", 25],
    // 	[" ", 23],
    // 	[" ", 26],
    // 	[" ", 28],
    // 	[" ", 32],
    // 	[" ", 31],
    // 	[" ", 29],
    // 	[" ", 19],
    // 	[" ", 23],
    // 	["10", 25],
    // 	[" ", 29],
    // 	[" ", 28],
    // 	[" ", 27],
    // 	[" ", 25],
    // 	[" ", 29],
    // 	[" ", 32],
    // 	[" ", 35],
    // 	[" ", 37],
    // 	[" ", 38],
    // 	["20", 35],
    // 	[" ", 29],
    // 	[" ", 33],
    // 	[" ", 35],
    // 	[" ", 36],
    // 	[" ", 34],
    // 	[" ", 38],
    // 	[" ", 42],
    // 	[" ", 35],
    // 	[" ", 29],
    // 	["30", 25],
    // 	[" ", 26],
    // 	[" ", 22],
    // 	[" ", 28],
    // 	[" ", 25],
    // 	[" ", 30],
    // 	[" ", 29],
    // 	[" ", 33],
    // 	[" ", 37],
    // 	[" ", 32],
    // 	["40", 35],
    // 	[" ", 34],
    // 	[" ", 39],
    // 	[" ", 36],
    // 	[" ", 34],
    // 	[" ", 35],
    // 	[" ", 29],
    // 	[" ", 28],
    // 	[" ", 27],
    // 	[" ", 25],
    // 	["50", 25],
    // 	[" ", 26],
    // 	[" ", 22],
    // 	[" ", 28],
    // 	[" ", 25],
    // 	[" ", 30],
    // 	[" ", 29],
    // 	[" ", 33],
    // 	[" ", 32],
    // 	[" ", 29],
    // 	["60", 25]
    // ];
    //
    // var dateList = data.map(function(item) {
    // 	return item[0];
    // });
    // var valueList = data.map(function(item) {
    // 	return item[1];
    // });
    var dateList = [];
    option = {
        title: {
            text: '内存总量/利用率',
            textStyle: {
                color: '#40CED3',
                fontSize: 17,
                fontWeight: 'normal'
            }
        },
        grid: {
            left: '3%',
            right: '3%',
            top: '20%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            data: dateList,
            boundaryGap: false,
            axisLine: {
                lineStyle: {
                    color: '#fff'
                }
            },
            type: 'category'
        },
        yAxis: {
            splitLine: {
                show: false
            },
            min: 0,
            max: 100,
            interval: 20,
            // axisLine: {
            // 	lineStyle: {
            // 		color: '#fff'
            // 	}
            // },
            // type: 'value',
            axisLabel: {
                color: '#fff',
                formatter: '{value} %'    //控制输出格式
            },
            type: 'value',
        },
        series: [{
            type: 'line',
            showSymbol: false,
            data: valueList,
            smooth: true,
            itemStyle: {
                normal: {
                    color: '#6C7C9D'
                }
            },
            areaStyle: {
                normal: {
                    color: '#52658C'
                }
            }
        }]
    };
    ;
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}

//互联网出口宽带总量
function footer_con_4(valueList) {
    var dom = document.getElementById("footer_con_4");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    // data = [
    // 	["0", 22],
    // 	[" ", 25],
    // 	[" ", 23],
    // 	[" ", 26],
    // 	[" ", 28],
    // 	[" ", 32],
    // 	[" ", 31],
    // 	[" ", 29],
    // 	[" ", 19],
    // 	[" ", 23],
    // 	["10", 25],
    // 	[" ", 29],
    // 	[" ", 28],
    // 	[" ", 27],
    // 	[" ", 25],
    // 	[" ", 29],
    // 	[" ", 32],
    // 	[" ", 35],
    // 	[" ", 37],
    // 	[" ", 38],
    // 	["20", 35],
    // 	[" ", 29],
    // 	[" ", 33],
    // 	[" ", 35],
    // 	[" ", 36],
    // 	[" ", 34],
    // 	[" ", 38],
    // 	[" ", 42],
    // 	[" ", 35],
    // 	[" ", 29],
    // 	["30", 25],
    // 	[" ", 26],
    // 	[" ", 22],
    // 	[" ", 28],
    // 	[" ", 25],
    // 	[" ", 30],
    // 	[" ", 29],
    // 	[" ", 33],
    // 	[" ", 37],
    // 	[" ", 32],
    // 	["40", 35],
    // 	[" ", 34],
    // 	[" ", 39],
    // 	[" ", 36],
    // 	[" ", 34],
    // 	[" ", 35],
    // 	[" ", 29],
    // 	[" ", 28],
    // 	[" ", 27],
    // 	[" ", 25],
    // 	["50", 25],
    // 	[" ", 26],
    // 	[" ", 22],
    // 	[" ", 28],
    // 	[" ", 25],
    // 	[" ", 30],
    // 	[" ", 29],
    // 	[" ", 33],
    // 	[" ", 32],
    // 	[" ", 29],
    // 	["60", 25]
    // ];
    //
    // var dateList = data.map(function(item) {
    // 	return item[0];
    // });
    // var valueList = data.map(function(item) {
    // 	return item[1];
    // });
    var dateList = [];
    option = {
        title: {
            text: '互联网出口带宽总量/利用率',
            textStyle: {
                color: '#40CED3',
                fontSize: 17,
                fontWeight: 'normal'
            }
        },
        grid: {
            left: '3%',
            right: '3%',
            top: '20%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            data: dateList,
            boundaryGap: false,
            axisLine: {
                lineStyle: {
                    color: '#fff'
                }
            },
            type: 'category'
        },
        yAxis: {
            splitLine: {
                show: false
            },
            min: 0,
            max: 100,
            interval: 20,
            // axisLine: {
            // 	lineStyle: {
            // 		color: '#fff'
            // 	}
            // },
            // type: 'value',
            axisLabel: {
                color: '#fff',
                formatter: '{value} %'    //控制输出格式
            },
            type: 'value',
        },
        series: [{
            type: 'line',
            showSymbol: false,
            data: valueList,
            smooth: true,
            itemStyle: {
                normal: {
                    color: '#A78553'
                }
            },
            areaStyle: {
                normal: {
                    color: '#876C4E'
                }
            }
        }]
    };
    ;
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}

//警告处理状态
function error_deal_2(data) {
    data = jsonCellToArray(data);
    var appNum = [];
    var count = [];
    if (data.appName) {
        appNum = data.appName;
    }
    if (data.count) {
        count = data.count;
    }
    // var appId = data.appId;
    var dom = document.getElementById("error_deal_2");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    option = {
        title: {
            text: '应用系统访问次数TOP10',
            left: 12,
            textStyle: {
                color: '#40CED3',
                fontWeight: 'normal',
                fontSize: 18,
            }
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        grid: {
            left: '5%',
            right: '15%',
            bottom: '1%',
            top: '12%',
            containLabel: true
        },
        xAxis: {
            type: 'value',
            boundaryGap: [0],
            show: false
        },
        yAxis: {
            type: 'category',
            data: appNum,
            axisLine: {
                lineStyle: {
                    color: '#1A8FF0'
                }
            }
        },
        series: {
            name: '访问次数',
            type: 'bar',
            label: {
                normal: {
                    show: true,
                    position: 'right',
                    color: '#B4E1F7'
                }
            },
            data: count,
            barWidth: 15,
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

            }
        }
    };
    ;
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}
/*调用应用占比*/
function error_deal_1(data) {
    data = jsonCellToArray(data);
    var dom = document.getElementById("error_deal_1");
    var myChart = echarts.init(dom);
    var appName = [];
    var count = [];
    if (data.appName) {
        appName = data.appName;
    }
    if (data.count) {
        count = data.count;
    }
    var colors = ['#4169E1', '#6495ED', '#B0C4DE', '#778899', '#708090', '#1E90FF', '#F0F8FF', '#4682B4', '#87CEFA', '#87CEEB'];
    var array = pieChartData(appName, count, colors);
    option = null;
    option = {
        title: {
            text: '调用应用占比',
            x: 'center',
            top: 20,
            textStyle: {
                color: '#40CED3',
                fontWeight: 'normal',
                fontSize: 18,
            }
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        series: [{
            name: '调用应用',
            type: 'pie',
            radius: '40%',
            center: ['55%', '50%'],
            // data: [{
            //     value: 335,
            //     name: '应用1',
            //     itemStyle: {
            //         color: '#8AC5FF'
            //     }
            // },
            //     {
            //         value: 310,
            //         name: '应用2',
            //         itemStyle: {
            //             color: '#CDEDFC'
            //         }
            //     },
            //     {
            //         value: 234,
            //         name: '应用3',
            //         itemStyle: {
            //             color: '#015FA7'
            //         }
            //     },
            //     {
            //         value: 135,
            //         name: '应用4',
            //         itemStyle: {
            //             color: '#3991D1'
            //         }
            //     },
            //     {
            //         value: 323,
            //         name: '其他',
            //         itemStyle: {
            //             color: '#2A9CFF'
            //         }
            //     }
            // ],
            data: array,
            itemStyle: {
                normal: {
                    label: {
                        show: true,
                        formatter: '{b}: {c} \n ({d}%)'
                    },
                    labelLine: {
                        show: true
                    }
                },
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }]
    };
    ;
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}
//网络拓扑图
function py_big_l_pub() {
    var dom = document.getElementById("py_big_l_pub");
    var myChart = echarts.init(dom);
    var app = {};
    var colors = ['#0187EA', '#2A89BC', '#5078BF', '#537DBF', '#697A92', '#3586CA'];
    option = null;
    //	myChart.showLoading();
    $.get('static/js/webkit-dep.json', function (webkitDep) {
        //	    myChart.hideLoading();

        option = {
            series: [{
                showAllSymbol: true,
                type: 'graph',
                layout: 'force',
                animation: false,
                roam: true,
                focusNodeAdjacency: true,
                label: {
                    normal: {
                        position: 'right',
                        formatter: '{b}'
                    }
                },
                draggable: true,
                data: webkitDep.nodes.map(function (node, idx) {
                    node.symbol = webkitDep.categories[node.category].symbol;
                    node.symbolSize = 25,
                        node.id = idx;
                    return node;
                }),
                categories: webkitDep.categories,
//				symbol:'image://images/net_icon/02.png',
                force: {
                    // initLayout: 'circular'
                    edgeLength: 200,
                    repulsion: 20,
//					gravity: 0.15
                },
                edges: webkitDep.links
            }]
        };

        myChart.setOption(option);
    });
    ;
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}

/*获取该项占总数百分比*/
function getRatiosArray(array, total) {
    for (var i = 0; i < array.length; i++) {
        array[i] = 100 * ((array[i] / total).toFixed(4));
    }
    return array;
}

/*数组取整*/
function getIntArray(array) {
    for (var i = 0; i < array.length; i++) {
        array[i] = parseInt(array[i]);
    }
    return array;
}

/*数组保留2位小数*/
function getFloatArray(array) {
    for (var i = 0; i < array.length; i++) {
        if (isRealNum(array[i])) {
            array[i] = array[i].toFixed(2);
        }
    }
    return array;
}

/*判断是否是数字*/
function isRealNum(val) {
    // isNaN()函数 把空串 空格 以及NUll 按照0来处理 所以先去除
    if (val === "" || val == null) {
        return false;
    }
    if (!isNaN(val)) {
        return true;
    } else {
        return false;
    }
}

/*设置四个波形的total*/
function setTotal(array, ratios) {
    $("#footer_con_1_title").html(array[0] + "核/" + ratios[0] + "%");
    $("#footer_con_2_title").html(array[1] * 1000 + "GB/" + ratios[1] + "%");
    $("#footer_con_3_title").html(array[2] + "GB/" + ratios[2] + "%");
    $("#footer_con_4_title").html(array[3] + "MBps/" + ratios[3] + "%");
}

/*设置宿主机利用率*/
function setTop10(data) {
    var rows = document.getElementById('host_top').rows;
    // var rows = $("#host_top").rows;
    var cells = [];
    var text = "";
    for (var i = 1; i < rows.length; i++) {
        cells = jsonToArray(data[i - 1]);
        for (var j = 1; j < rows[i].cells.length; j++) {
            if (j == 1) {
                text = cells[j - 1];
            } else {
                text = cells[j - 1] + "%";
            }
            rows[i].cells[j].innerHTML = text;
        }
    }
}

/*获取json中value的数组(行数组)*/
function jsonToArray(json) {
    var result = [];
    for (var key in json) {
        // result.push(key);
        result.push(arrayScale100(json[key]));
    }
    return getFloatArray(result);
}

/*获取json中某一key的数组(列数组)*/
function jsonCellToArray(array) {
    var result = {};
    var arr = [];
    if (array != null && array.length > 0) {
        for (var key in array[0]) {
            arr = [];
            for (var i = array.length; i > -1; i--) {
                for (var mk in array[i]) {
                    if (mk == key) {
                        arr.push(array[i][mk]);
                    }
                }
            }
            result[key] = arr;
        }
    }
    return getFloatArray(result);
}

/*将数字扩大100倍*/
function arrayScale100(value) {
    if (isRealNum(value)) {
        return value * 100;
    } else {
        return value;
    }
}

/*调用应用占比*/
function pieChartData(names, values, colors) {
    var data = [];
    for (var i = 0; i < names.length; i++) {
        var map = {};
        var colorMap = {};
        map.name = names[i];
        map.value = values[i];
        colorMap.color = colors[i];
        map.itemStyle = colorMap;
        data.push(map);
    }
    return data;
}

