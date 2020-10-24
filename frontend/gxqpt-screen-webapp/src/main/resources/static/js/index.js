$(function () {
    CurentTime();
    setInterval(CurentTime, 1000);
    /*nav导航*/
    $(".py_ul_l li a").eq("0").addClass("nav_bg");
    $(".py_ul_l li a").click(function () {
        $(".py_ul_l li a").removeClass("nav_bg");
        $(this).addClass("nav_bg");
    });
    $(".py_ul_r li a").eq("0").addClass("nav_bg");
    $(".py_ul_r li a").click(function () {
        $(".py_ul_r li a").removeClass("nav_bg");
        $(this).addClass("nav_bg");
    });

    // /*进度条*/
    // var value = 7;
    // if (value == 1) {
    //     $(".jd_value").html("10%");
    //     $(".icon_pic").eq("0").addClass("icon_pic_top");
    // } else if (value == 2) {
    //     $(".jd_value").html("20%");
    //     $(".icon_pic").eq("0").addClass("icon_pic_top");
    //     $(".icon_pic").eq("1").addClass("icon_pic_top");
    // } else if (value == 3) {
    //     $(".jd_value").html("30%");
    //     $(".icon_pic").eq("0").addClass("icon_pic_top");
    //     $(".icon_pic").eq("1").addClass("icon_pic_top");
    //     $(".icon_pic").eq("2").addClass("icon_pic_top");
    // } else if (value == 4) {
    //     $(".jd_value").html("40%");
    //     $(".icon_pic").eq("0").addClass("icon_pic_top");
    //     $(".icon_pic").eq("1").addClass("icon_pic_top");
    //     $(".icon_pic").eq("2").addClass("icon_pic_top");
    //     $(".icon_pic").eq("3").addClass("icon_pic_top");
    // } else if (value == 5) {
    //     $(".jd_value").html("50%");
    //     $(".icon_pic").eq("0").addClass("icon_pic_top");
    //     $(".icon_pic").eq("1").addClass("icon_pic_top");
    //     $(".icon_pic").eq("2").addClass("icon_pic_top");
    //     $(".icon_pic").eq("3").addClass("icon_pic_top");
    //     $(".icon_pic").eq("4").addClass("icon_pic_top");
    // } else if (value == 6) {
    //     $(".jd_value").html("60%");
    //     $(".icon_pic").eq("0").addClass("icon_pic_top");
    //     $(".icon_pic").eq("1").addClass("icon_pic_top");
    //     $(".icon_pic").eq("2").addClass("icon_pic_top");
    //     $(".icon_pic").eq("3").addClass("icon_pic_top");
    //     $(".icon_pic").eq("4").addClass("icon_pic_top");
    //     $(".icon_pic").eq("5").addClass("icon_pic_top");
    // } else if (value == 7) {
    //     $(".jd_value").html("70%");
    //     $(".icon_pic").eq("0").addClass("icon_pic_top");
    //     $(".icon_pic").eq("1").addClass("icon_pic_top");
    //     $(".icon_pic").eq("2").addClass("icon_pic_top");
    //     $(".icon_pic").eq("3").addClass("icon_pic_top");
    //     $(".icon_pic").eq("4").addClass("icon_pic_top");
    //     $(".icon_pic").eq("5").addClass("icon_pic_top");
    //     $(".icon_pic").eq("6").addClass("icon_pic_top");
    // } else if (value == 8) {
    //     $(".jd_value").html("80%");
    //     $(".icon_pic").eq("0").addClass("icon_pic_top");
    //     $(".icon_pic").eq("1").addClass("icon_pic_top");
    //     $(".icon_pic").eq("2").addClass("icon_pic_top");
    //     $(".icon_pic").eq("3").addClass("icon_pic_top");
    //     $(".icon_pic").eq("4").addClass("icon_pic_top");
    //     $(".icon_pic").eq("5").addClass("icon_pic_top");
    //     $(".icon_pic").eq("6").addClass("icon_pic_top");
    //     $(".icon_pic").eq("7").addClass("icon_pic_top");
    // } else if (value == 9) {
    //     $(".jd_value").html("90%");
    //     $(".icon_pic").eq("0").addClass("icon_pic_top");
    //     $(".icon_pic").eq("1").addClass("icon_pic_top");
    //     $(".icon_pic").eq("2").addClass("icon_pic_top");
    //     $(".icon_pic").eq("3").addClass("icon_pic_top");
    //     $(".icon_pic").eq("4").addClass("icon_pic_top");
    //     $(".icon_pic").eq("5").addClass("icon_pic_top");
    //     $(".icon_pic").eq("6").addClass("icon_pic_top");
    //     $(".icon_pic").eq("7").addClass("icon_pic_top");
    //     $(".icon_pic").eq("8").addClass("icon_pic_top");
    // } else if (value == 10) {
    //     $(".jd_value").html("100%");
    //     $(".icon_pic").eq("0").addClass("icon_pic_top");
    //     $(".icon_pic").eq("1").addClass("icon_pic_top");
    //     $(".icon_pic").eq("2").addClass("icon_pic_top");
    //     $(".icon_pic").eq("3").addClass("icon_pic_top");
    //     $(".icon_pic").eq("4").addClass("icon_pic_top");
    //     $(".icon_pic").eq("5").addClass("icon_pic_top");
    //     $(".icon_pic").eq("6").addClass("icon_pic_top");
    //     $(".icon_pic").eq("7").addClass("icon_pic_top");
    //     $(".icon_pic").eq("8").addClass("icon_pic_top");
    //     $(".icon_pic").eq("9").addClass("icon_pic_top");
    // }

    /*部门统计*/
   // dataPlatform_bmtj();
    /*分类排名*/
    // dataPlatform_flpm();
    /*  统一监管*/
    // dataPlatform_tyjg();
    /*应用统计*/
//	dataPlatform_demo_left();
//     dataPlatform_demo_right();
    /*实时调用情况*/
    // dataPlatform_ssdy();
    /*网点关系图*/
//	dataPlatform_web();
//     relation_charts();

});

/*进度条*/
function initAccessRate(value) {
    $(".jd_value").html(value + "%");
    value = (value - (value % 10)) / 10;
    if (value == 1) {
        $(".icon_pic").eq("0").addClass("icon_pic_top");
    } else if (value == 2) {
        $(".icon_pic").eq("0").addClass("icon_pic_top");
        $(".icon_pic").eq("1").addClass("icon_pic_top");
    } else if (value == 3) {
        $(".icon_pic").eq("0").addClass("icon_pic_top");
        $(".icon_pic").eq("1").addClass("icon_pic_top");
        $(".icon_pic").eq("2").addClass("icon_pic_top");
    } else if (value == 4) {
        $(".icon_pic").eq("0").addClass("icon_pic_top");
        $(".icon_pic").eq("1").addClass("icon_pic_top");
        $(".icon_pic").eq("2").addClass("icon_pic_top");
        $(".icon_pic").eq("3").addClass("icon_pic_top");
    } else if (value == 5) {
        $(".icon_pic").eq("0").addClass("icon_pic_top");
        $(".icon_pic").eq("1").addClass("icon_pic_top");
        $(".icon_pic").eq("2").addClass("icon_pic_top");
        $(".icon_pic").eq("3").addClass("icon_pic_top");
        $(".icon_pic").eq("4").addClass("icon_pic_top");
    } else if (value == 6) {
        $(".icon_pic").eq("0").addClass("icon_pic_top");
        $(".icon_pic").eq("1").addClass("icon_pic_top");
        $(".icon_pic").eq("2").addClass("icon_pic_top");
        $(".icon_pic").eq("3").addClass("icon_pic_top");
        $(".icon_pic").eq("4").addClass("icon_pic_top");
        $(".icon_pic").eq("5").addClass("icon_pic_top");
    } else if (value == 7) {
        $(".icon_pic").eq("0").addClass("icon_pic_top");
        $(".icon_pic").eq("1").addClass("icon_pic_top");
        $(".icon_pic").eq("2").addClass("icon_pic_top");
        $(".icon_pic").eq("3").addClass("icon_pic_top");
        $(".icon_pic").eq("4").addClass("icon_pic_top");
        $(".icon_pic").eq("5").addClass("icon_pic_top");
        $(".icon_pic").eq("6").addClass("icon_pic_top");
    } else if (value == 8) {
        $(".icon_pic").eq("0").addClass("icon_pic_top");
        $(".icon_pic").eq("1").addClass("icon_pic_top");
        $(".icon_pic").eq("2").addClass("icon_pic_top");
        $(".icon_pic").eq("3").addClass("icon_pic_top");
        $(".icon_pic").eq("4").addClass("icon_pic_top");
        $(".icon_pic").eq("5").addClass("icon_pic_top");
        $(".icon_pic").eq("6").addClass("icon_pic_top");
        $(".icon_pic").eq("7").addClass("icon_pic_top");
    } else if (value == 9) {
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
}

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
function dataPlatform_bmtj(deptStaticOption) {
    var dom = document.getElementById("dataPlatform_bmtj");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    app.title = '折柱混合';

    option = {
        tooltip: {
            trigger: 'axis',
            //          axisPointer: {
            //              type: 'cross',
            //              crossStyle: {
            //                  color: '#999'
            //              }
            //          }
        },
        legend: {
            // data: ['应用',  '目录', 'api'],
            data: ['目录', 'API'],
            textStyle: {
                fontSize: 12,
                color: '#fff'
            }
        },
        xAxis: [{
            type: 'category',
            data: deptStaticOption["dept"],//['党政办公室', '规划建设局', '财政局', '国税局', '质监分局', '产业发展局',],
            axisLine: {
                lineStyle: {
                    color: '#fff'
                }
            },
            axisLabel: {
                padding: [20, -20, 0, 0],
                rotate: 35,
            },
            axisPointer: {
                type: 'shadow'
            }
        }],
        yAxis: [{
            type: 'value',
            name: '单位：个',
            min: 0,
            //max: 3000,
           // interval: 500,
            splitNumber: 2,
            scale: true,
            splitLine: {
                show: false
            },
            axisLine: {
                lineStyle: {
                    color: '#fff'
                }
            },
            axisLabel: {
                formatter: '{value}'
            }
        }
        ],
        series: [/*{
            name: '应用',
            type: 'bar',
            data: deptStaticOption["app"],
            itemStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(
                        0, 0, 0, 1, [{
                            offset: 0,
                            color: '#0CF2F6'
                        },
                            {
                                offset: 1,
                                color: '#0086FE'
                            }
                        ]
                    )
                }

            }
        },*/ {
                name: '目录',
                type: 'bar',
                data: deptStaticOption["dir"],
                itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1, [{
                                offset: 0,
                                color: '#158d9e'
                            },
                                {
                                    offset: 1,
                                    color: '#afcc42'
                                }
                            ]
                        )
                    }

                }
            }, {
                name: 'API',
                type: 'bar',
                data: deptStaticOption["api"],
                itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1, [{
                                offset: 0,
                                color: '#13256c'
                            },
                                {
                                    offset: 1,
                                    color: '#2d4898'
                                }
                            ]
                        )
                    }

                }
            }
        ]
    };
    ;
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}

/*分类排名*/
function dataPlatform_flpm() {
    var dom = document.getElementById("dataPlatform_flpm");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        grid: {
            left: '3%',
            right: '3%',
            bottom: '1%',
            top: '5%',
            containLabel: true
        },
        xAxis: {
            type: 'value',
            boundaryGap: [0],
            show: false
        },
        yAxis: {
            type: 'category',
            data: ['行业1', '行业2', '行业3', '行业4', '行业5', '行业6', '行业7', '行业8', '行业9', '行业10',],
            axisLine: {
                lineStyle: {
                    color: '#fff'
                }
            }
        },
        series: {
            name: '2011年',
            type: 'bar',
            data: [1, 2, 3, 6, 7, 8, 9, 10, 11, 13],
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

/*  统一监管*/
function dataPlatform_tyjg(data) {
    var list = jsonCellToArray(data);
    var cpuUseRate = 0;
    var memUseRate = 0;
    var bandwidthUseRate = 0;
    var all = 0;
    if (list.cpuUseRate) {
        cpuUseRate = (arraySum(list.cpuUseRate) / list.cpuUseRate.length).toFixed(2);
    }
    if (list.memUseRate) {
        memUseRate = (arraySum(list.memUseRate) / list.memUseRate.length).toFixed(2);
    }
    // diskUseRate = (arraySum(list.diskUseRate) / list.diskUseRate.length).toFixed(2);
    if (list.bandwidthUseRate) {
        bandwidthUseRate = (arraySum(list.bandwidthUseRate) / list.bandwidthUseRate.length).toFixed(2);
    }
    all = parseFloat(cpuUseRate * 0.5 + memUseRate * 0.3 + bandwidthUseRate * 0.2).toFixed(2);

    var dom = document.getElementById("dataPlatform_tyjg");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    option = {
        tooltip: {
            formatter: "{a} <br/>{c} {b}"
        },
        series: [{
            name: '速度',
            type: 'gauge',
            center: ['50.8%', '57%'],
            z: 3,
            min: 0,
            max: 1,
            splitNumber: 10,
            radius: '75%',
            axisLine: { // 坐标轴线
                lineStyle: { // 属性lineStyle控制线条样式
                    width: 4,
                    color: [
                        [0.09, 'lime'],
                        [0.82, '#1e90ff'],
                        [1, '#ff4500']
                    ]
                }
            },
            axisTick: { // 坐标轴小标记
                length: 12, // 属性length控制线长
                lineStyle: { // 属性lineStyle控制线条样式
                    color: 'auto'
                }
            },
            splitLine: { // 分隔线
                length: 16, // 属性length控制线长
                lineStyle: { // 属性lineStyle（详见lineStyle）控制线条样式
                    color: '#fff'
                }
            },
            axisLabel: {
                color: '#fff',
                padding: 1
            },
            title: {
                // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                fontWeight: 'bolder',
                fontSize: 15,
                color: '#fff'
            },
            detail: {
                // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                formatter: function (value) {
                    value = (value + '').split('.');
                    value.length < 2 && (value.push('00'));
                    return ('00' + value[0]).slice(-2) +
                        '.' + (value[1] + '00').slice(0, 2);
                },
                fontWeight: 'normal',
                fontSize: 25,
                borderRadius: 2,
                backgroundColor: 'rgba(0,0,220,.2)',
                borderColor: '#17c0d5',
                borderWidth: 1,
                fontFamily: 'Arial',
                width: 50,
                height: 25,
                color: '#fff',
                rich: {}
            },
            data: [{
                value: all,
                name: '整体情况'
            }]
        },
            {
                name: '转速',
                type: 'gauge',
                center: ['18%', '60%'], // 默认全局居中
                radius: '50%',
                min: 0,
                max: 1,
                endAngle: -45,
                splitNumber: 10,
                axisLine: { // 坐标轴线
                    lineStyle: { // 属性lineStyle控制线条样式
                        width: 4,
                        color: [
                            [0.29, 'lime'],
                            [0.86, '#1e90ff'],
                            [1, '#ff4500']
                        ],
                    }
                },
                axisTick: { // 坐标轴小标记
                    length: 10, // 属性length控制线长
                    lineStyle: { // 属性lineStyle控制线条样式
                        color: 'auto'
                    }
                },
                splitLine: { // 分隔线
                    length: 15, // 属性length控制线长
                    lineStyle: { // 属性lineStyle（详见lineStyle）控制线条样式
                        color: '#fff'
                    }
                },
                pointer: {
                    width: 5
                },
                title: {
                    offsetCenter: [0, '-35%'], // x, y，单位px
                    color: '#fff'
                },
                detail: {
                    color: '#fff',
                    fontSize: 25,
                },
                data: [{
                    value: cpuUseRate,
                    name: 'CPU'
                }]
            },
            {
                name: '网络',
                type: 'gauge',
                center: ['83%', '60%'], // 默认全局居中
                radius: '50%',
                min: 0,
                max: 1,
                startAngle: 160,
                endAngle: 20,
                splitNumber: 2,
                axisLine: { // 坐标轴线
                    lineStyle: { // 属性lineStyle控制线条样式
                        width: 4,
                        color: [
                            [0.2, 'lime'],
                            [0.8, '#1e90ff'],
                            [1, '#ff4500']
                        ],
                    }
                },
                axisTick: { // 坐标轴小标记
                    splitNumber: 5,
                    length: 10, // 属性length控制线长
                    lineStyle: { // 属性lineStyle控制线条样式
                        color: 'auto'
                    }
                },
                splitLine: { // 分隔线
                    length: 15, // 属性length控制线长
                    lineStyle: { // 属性lineStyle（详见lineStyle）控制线条样式
                        color: '#fff'
                    }
                },
                pointer: {
                    width: 2
                },
                title: {
                    offsetCenter: [0, '-35%'], // x, y，单位px
                    color: '#fff'
                },
                detail: {
                    show: false
                },
                data: [{
                    value: bandwidthUseRate,
                    name: '流量'
                }]
            },
            {
                name: '内存',
                type: 'gauge',
                center: ['83%', '60%'], // 默认全局居中
                radius: '50%',
                min: 0,
                max: 1,
                startAngle: -20,
                endAngle: -160,
                splitNumber: 2,
                axisLine: { // 坐标轴线
                    lineStyle: { // 属性lineStyle控制线条样式
                        width: 4,
                        color: [
                            [0.2, 'lime'],
                            [0.8, '#1e90ff'],
                            [1, '#ff4500']
                        ]
                    }
                },
                axisTick: { // 坐标轴小标记
                    splitNumber: 5,
                    length: 10, // 属性length控制线长
                    lineStyle: { // 属性lineStyle控制线条样式
                        color: 'auto'
                    }
                },
                splitLine: { // 分隔线
                    length: 15, // 属性length控制线长
                    lineStyle: { // 属性lineStyle（详见lineStyle）控制线条样式
                        color: '#fff',
                    }
                },
                pointer: {
                    width: 2
                },
                title: {
                    offsetCenter: [0, '35%'], // x, y，单位px
                    color: '#fff'
                },
                detail: {
                    show: false
                },
                data: [{
                    value: memUseRate,
                    name: '内存'
                }]
            }
        ]
    };

    //			setInterval(function (){
    //			    option.series[0].data[0].value = (Math.random()*100).toFixed(2) - 0;
    //			    option.series[1].data[0].value = (Math.random()*7).toFixed(2) - 0;
    //			    option.series[2].data[0].value = (Math.random()*2).toFixed(2) - 0;
    //			    option.series[3].data[0].value = (Math.random()*2).toFixed(2) - 0;
    //			    myChart.setOption(option,true);
    //			},2000);;
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}

/*应用统计*/
function dataPlatform_demo_left() {
    var dom = document.getElementById("dataPlatform_demo_left");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    option = {
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        series: [{
            name: '应用',
            type: 'pie',
            radius: '70%',
            center: ['54%', '50%'],
            selectedMode: 'single',
            data: [{
                value: 47,
                name: '接入应用',
                itemStyle: {
                    color: '#01ABC0'
                }
            },
                {
                    value: 53,
                    name: '通用应用',
                    itemStyle: {
                        color: '#9F54DC'
                    }
                }
            ],
            label: {
                normal: {
                    position: 'inner'
                }
            },
            itemStyle: {
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

function dataPlatform_demo_right() {
    var dom = document.getElementById("dataPlatform_demo_right");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    app.title = '环形图';

    option = {
        title: {
            text: '2018',
            x: '35%',
            y: 'center',
            textStyle: {
                color: '#A0C9DD',
                fontFamily: '微软雅黑',
                fontSize: 20,
                fontWeight: 'bolder'
            }
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            right: 120,
            y: 'center',
            data: ['通用应用', '平台应用', '接入应用'],
            textStyle: {
                fontSize: 12,
                color: '#fff'
            }
        },
        series: [{
            name: '访问来源',
            type: 'pie',

            selectedMode: 'single',
            radius: ['0%', '20%'],
            center: ['40%', '50%'],
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
            data: [{
                value: 1548,
                name: ' ',
                itemStyle: {
                    color: '#2A3F50'
                }
            }

            ]
        },
            {
                name: '访问来源',
                type: 'pie',

                selectedMode: 'single',
                radius: ['20%', '33%'],
                center: ['40%', '50%'],
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
                data: [{
                    value: 1548,
                    name: ' ',
                    itemStyle: {
                        color: '#172E40'
                    }
                }

                ]
            },
            {
                name: '访问来源',
                type: 'pie',
                radius: ['40%', '60%'],
                center: ['40%', '50%'],
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: false,
                        position: 'center'
                    },
                    emphasis: {
                        show: true,
                        textStyle: {
                            fontSize: '30',
                            fontWeight: 'bold'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data: [{
                    value: 60,
                    name: '通用应用',
                    itemStyle: {
                        color: '#356EEE'
                    }
                },
                    {
                        value: 21,
                        name: '平台应用',
                        itemStyle: {
                            color: '#02FAC7'
                        }
                    },
                    {
                        value: 19,
                        name: '接入应用',
                        itemStyle: {
                            color: '#16C0D5'
                        }
                    }
                ]
            }
        ]
    };
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}

/*实时调用情况*/
var a = "123.168.0.22";

function dataPlatform_ssdy(data) {
    var dom = document.getElementById("dataPlatform_ssdy");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;

    //data = [["0",22],[" ",25],[" ",23],[" ",26],[" ",28],[" ",32],[" ",31],[" ",29],[" ",19],[" ",23],["10",25],[" ",29],[" ",28],[" ",27],[" ",25],[" ",29],[" ",32],[" ",35],[" ",37],[" ",38],["20",35],[" ",29],[" ",33],[" ",35],[" ",36],[" ",34],[" ",38],[" ",42],[" ",35],[" ",29],["30",25],[" ",26],[" ",22],[" ",28],[" ",25],[" ",30],[" ",29],[" ",33],[" ",37],[" ",32],["40",35],[" ",34],[" ",39],[" ",36],[" ",34],[" ",35],[" ",29],[" ",28],[" ",27],[" ",25],["50",25],[" ",26],[" ",22],[" ",28],[" ",25],[" ",30],[" ",29],[" ",33],[" ",32],[" ",29],["60",25]];
    var dateList = [];
    var valueList = [];
    dateList = data.map(function (item) {
        return item[0];
    });
    valueList = data.map(function (item) {
        return item[1];
    });

    option = {

        tooltip: {
            trigger: 'axis'
        },
        xAxis: {
            data: dateList,
            boundaryGap: false,
            axisLine: {
                lineStyle: {
                    color: '#fff'
                }
            }
        },
        yAxis: {
            splitLine: {
                show: false
            },
            axisLine: {
                lineStyle: {
                    color: '#fff'
                }
            },
            //			scale: true,
            show: false

        },
        grid: {
            left: '0%',
            right: '0%',
            bottom: '0%',
            top: '35%',
            height: '65%',
            containLabel: true
        },
        series: {
            type: 'line',
            showSymbol: false,
            data: valueList,
            smooth: true,
            itemStyle: {
                normal: {
                    color: 'rgb(77, 52, 205)'
                }
            },
            areaStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: 'rgb(7, 37, 96)'
                    }, {
                        offset: 1,
                        color: 'rgb(9, 21, 58)'
                    }])
                }
            }
        }
    };
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}

//网点关系图
function relation_charts() {
    var dom = document.getElementById("relation_charts");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;


    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}

//网点关系图
function dataPlatform_web() {
    var dom = document.getElementById("dataPlatform_web");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;

    var uploadedDataURL = "js/data-1500091095891-ByeJQMPSZ.json";
    $.get(uploadedDataURL, function (data) {
        //		data = JSON.parse(data);
        myChart.setOption(
            option = {
                //				backgroundColor:'#080B1F',
                bmap: {
                    center: [125.35, 43.86],
                    zoom: 12,
                    roam: false,
                    mapStyle: {
                        'styleJson': [{
                            'featureType': 'water',
                            'elementType': 'all',
                            'stylers': {
                                'color': '#031628'
                            }
                        }, {
                            'featureType': 'land',
                            'elementType': 'geometry',
                            'stylers': {
                                'color': '#000102'
                            }
                        }, {
                            'featureType': 'highway',
                            'elementType': 'all',
                            'stylers': {
                                'visibility': 'off'
                            }
                        }, {
                            'featureType': 'arterial',
                            'elementType': 'geometry.fill',
                            'stylers': {
                                'color': '#000000'
                            }
                        }, {
                            'featureType': 'arterial',
                            'elementType': 'geometry.stroke',
                            'stylers': {
                                'color': '#0b3d51'
                            }
                        }, {
                            'featureType': 'local',
                            'elementType': 'geometry',
                            'stylers': {
                                'color': '#000000'
                            }
                        }, {
                            'featureType': 'railway',
                            'elementType': 'geometry.fill',
                            'stylers': {
                                'color': '#000000'
                            }
                        }, {
                            'featureType': 'railway',
                            'elementType': 'geometry.stroke',
                            'stylers': {
                                'color': '#08304b'
                            }
                        }, {
                            'featureType': 'subway',
                            'elementType': 'geometry',
                            'stylers': {
                                'lightness': -70
                            }
                        }, {
                            'featureType': 'building',
                            'elementType': 'geometry.fill',
                            'stylers': {
                                'color': '#000000'
                            }
                        }, {
                            'featureType': 'all',
                            'elementType': 'labels.text.fill',
                            'stylers': {
                                'color': '#857f7f'
                            }
                        }, {
                            'featureType': 'all',
                            'elementType': 'labels.text.stroke',
                            'stylers': {
                                'color': '#000000'
                            }
                        }, {
                            'featureType': 'building',
                            'elementType': 'geometry',
                            'stylers': {
                                'color': '#022338'
                            }
                        }, {
                            'featureType': 'green',
                            'elementType': 'geometry',
                            'stylers': {
                                'color': '#062032'
                            }
                        }, {
                            'featureType': 'boundary',
                            'elementType': 'all',
                            'stylers': {
                                'color': '#465b6c'
                            }
                        }, {
                            'featureType': 'manmade',
                            'elementType': 'all',
                            'stylers': {
                                'color': '#022338'
                            }
                        }, {
                            'featureType': 'label',
                            'elementType': 'all',
                            'stylers': {
                                'visibility': 'off'
                            }
                        }]
                    },
                },
                series: [{
                    type: 'lines',
                    coordinateSystem: 'bmap',
                    polyline: true,
                    data: data,
                    silent: true,
                    lineStyle: {
                        normal: {
                            opacity: 0.2,
                            width: 1
                        }
                    },
                    progressiveThreshold: 500,
                    progressive: 100
                }, {
                    type: 'lines',
                    coordinateSystem: 'bmap',
                    polyline: true,
                    data: data,
                    lineStyle: {
                        normal: {
                            width: 0.02
                        }
                    },
                    effect: {
                        constantSpeed: 40,
                        show: true,
                        trailLength: 0.02,
                        symbolSize: 2
                    },
                    zlevel: 1
                }]
            });
        if (option && typeof option === "object") {
            myChart.setOption(option, true);
        }
    });
    myChart.on('rendered', function () {
        $('.py_big_m').find('img').parent().parent().remove();
    });
}

/*数组求和*/
function arraySum(array) {
    var a = 0;
    for (var i in array) {
        a += array[i];
    }
    return a;
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
            result[key] = getFloatArray(arr);
        }
    }
    return result;
}

/*数组保留2位小数*/
function getFloatArray(array) {
    for (var i = 0; i < array.length; i++) {
        if (isRealNum(array[i])) {
            array[i] = parseFloat(array[i].toFixed(2));
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