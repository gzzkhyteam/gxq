$(function() {
    CurentTime();
    setInterval(CurentTime, 1000);
    /*nav导航*/
    $(".py_ul_l li a").eq("2").addClass("nav_bg");
    $(".py_ul_l li a").click(function() {
        $(".py_ul_l li a").removeClass("nav_bg");
        $(this).addClass("nav_bg");
    });
    $(".py_ul_r li a").eq("2").addClass("nav_bg");
    $(".py_ul_r li a").click(function() {
        $(".py_ul_r li a").removeClass("nav_bg");
        $(this).addClass("nav_bg");
    });

    /*关系图*/
    getRelationship();
    /*雷达图*/
    getRadar();
    /*组件各类别占比情况*/
    getAssembly();

});
//关系图
function getRelationship(appId){
    ajaxHengyun({
        url: gateUrl + "/api/developer/module/getModuleRelation",
        data:{appId:appId},
        success: function (rdate) {
            /*var data = JSON.parse(rdate.data.result);
            var links = JSON.parse(rdate.data.links);*/
            var data = eval("("+rdate.data.result+")");
            var links = eval("("+rdate.data.links+")");
            relationship(data,links);
        },error: function (date) {
        }
    });
}
//组建类别占比情况
function getAssembly(appId){
    ajaxHengyun({
        url: gateUrl + "/api/developer/module/getModuleCount",
        data:{appId:appId},
        success: function (date) {
            assembly(date.data);
        },error: function (date) {

        }
    });
}
//雷达图
function getRadar(){
    ajaxHengyun({
        url: gateUrl + "/api/developer/module/getRadarCount",
        success: function (date) {
            app(date.data);
        },error: function (date) {

        }
    });
}
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
/*平台共性设施发展情况*/
function develop() {
    var dom = document.getElementById("develop");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    app.title = '折柱混合';

    option = {
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['支撑平台', '共性应用', '共性服务', '共性模块'],
            right: '5%',
            top: '13%',
            textStyle: {
                color: '#fff'
            }
        },
        grid: {
            left: '3%',
            top: '25%',
            right: '5%',
            bottom: '8%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            axisLabel: {
                formatter: '{value}',
                textStyle: {
                    color: '#fff', //坐标值得具体的颜色
                    fontSize: '14'
                }
            },
            axisLine: {
                lineStyle: {
                    color: '#0c0f36'
                }
            },
            data: ['201712', '201801', '201802', '201803', '201804', '201805']
        },
        yAxis: {
            type: 'value',
            axisLabel: {
                formatter: '{value}',
                textStyle: {
                    color: '#fff', //坐标值得具体的颜色
                    fontSize: '14'
                }
            },
            axisLine: {
                lineStyle: {
                    color: '#0c0f36'
                }
            },
            splitLine: {
                lineStyle: {
                    color: '#0b2df8'
                }
            },
        },
        series: [{
            name: '支撑平台',
            type: 'line',
            data: [170, 480, 270, 270, 690, 120],
            symbolSize: 6,
            itemStyle: {
                normal: {
                    lineStyle: {
                        width: 2.5 //折线宽度
                    }
                }
            }
        },
            {
                name: '共性应用',
                type: 'line',
                data: [270, 580, 370, 370, 790, 220],
                symbolSize: 6,
                itemStyle: {
                    normal: {
                        lineStyle: {
                            width: 2.5 //折线宽度
                        }
                    }
                }
            },
            {
                name: '共性服务',
                type: 'line',
                data: [370, 680, 470, 470, 890, 320],
                symbolSize: 6,
                itemStyle: {
                    normal: {
                        lineStyle: {
                            width: 2.5 //折线宽度
                        }
                    }
                }
            },
            {
                name: '共性模块',
                type: 'line',
                data: [470, 780, 570, 570, 990, 420],
                symbolSize: 6,
                itemStyle: {
                    normal: {
                        lineStyle: {
                            width: 2.5 //折线宽度
                        }
                    }
                }
            }
        ],
        color: ['#29d663', '#42dee8', '#0e43d0', '#844af6']
    };;
    if(option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}

/*关系图*/
function relationship(result,links) {
    var dom = document.getElementById("relationship");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    option = {
        title: {
            text: ''
        },
        tooltip: {},
        animationDurationUpdate: 1500,
        animationEasingUpdate: 'quinticInOut',
        label: {
            normal: {
                show: true,
                textStyle: {
                    fontSize: 12
                },
            }
        },
        legend: {
            x: "center",
            show: false,
            data: ["部门","应用", "组件"]
        },
        series: [

            {
                type: 'graph',
                layout: 'force',
                symbolSize: 30,
                focusNodeAdjacency: true,
                roam: true,
                categories: [{
                    name: '部门',
                    itemStyle: {
                        normal: {
                            color: "#f432ad",
                        }
                    },
                },{
                    name: '应用',
                    itemStyle: {
                        normal: {
                            color: "#13bf84",
                        }
                    },
                }, {
                    name: '组件',
                    itemStyle: {
                        normal: {
                            color: "#1ed1d8",
                        }
                    }
                }],
                itemStyle: {
                    normal: {
                        borderColor: '#fff',
                        borderWidth: 1,
                        shadowBlur: 10,
                        shadowColor: 'rgba(0, 0, 0, 0.3)'
                    }
                },
                label: {
                    position: 'right',
                    formatter: '{b}'
                },
                lineStyle: {
                    color: 'source',
                    curveness: 0.3
                },
                emphasis: {
                    lineStyle: {
                        width: 10
                    }
                },
                // label: {
                // 	normal: {
                // 		show: true,
                // 		textStyle: {
                // 			fontSize: 10
                // 		},
                // 	}
                // },
                force: {
                    repulsion: 800,
                    edgeLength:200
                },
                edgeSymbolSize: [4, 50],
                edgeLabel: {
                    normal: {
                        show: true,
                        textStyle: {
                            fontSize: 10
                        },
                        formatter: "{c}"
                    }
                },
               /* data:result.map(function (node,idx) {
                    node.symbolSize=Math.round(Math.random()*30);
                    return node;
                }),*/
                data:result,
                links: links.map(function (node,idx){
                    node.label = {show:true,fontSize:16};
                    return node;
                }),
                // lineStyle: {
                // 	normal: {
                // 		opacity: 0.9,
                // 		width: 1,
                // 		curveness: 0
                // 	}
                // },
            }
        ],
        color: ['#f432ad', '#3bf49f', '#1ed1d8', '#3d92e6']
    };
    if(option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}
/*平台接入应用情况*/
function app(data) {
    var value =[];
    
    if(data.ymfw){
        value.push(parseInt(data.ymfw));
    }else{
        value.push(0);
    }

    if(data.gnsy){
        value.push(parseInt(data.gnsy));
    }else{
        value.push(0);
    }

    if(data.hyyhs){
        value.push(parseInt(data.hyyhs));
    }else{
        value.push(0);
    }

    if(data.yhtlsj){
        value.push(parseInt(data.yhtlsj));
    }else {
        value.push(0);
    }

    if(data.fwyhs){
        value.push(parseInt(data.fwyhs));
    }else{
        value.push(0);
    }
    var dom = document.getElementById("app");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    option = {
        // backgroundColor:'rgba(100,100,100,.05)',
        tooltip: {},
        radar: {
            shape: 'polygon',
            splitArea: {
                show: false,
            },
            splitLine: {
                lineStyle: {
                    color: '#24816F',
                }
            },
            axisLine: {
                lineStyle: {
                    color: '#02FAC7',
                }
            },
            name: {
                textStyle: {
                    color: '#fff',
                    borderRadius: 3,
                    padding: [3, 5]
                }
            },
            indicator: [
                {
                 name: '页面浏览量',
                  max: value[0]+200
                },
                {
                    name: '功能使用次数',
                    max: value[1]+300
                },
                {
                    name: '活跃用户数',
                    max: value[2]+10
                },
                {
                    name: '用户停留时间[分钟]',
                    max: value[3]+100
                },
                {
                    name: '访问用户数',
                    max: value[4]+13
                }
            ]
        },
        series: [{
            name: '',
            type: 'radar',
            data: [{
                value: value,
                name: '使用情况',
                lineStyle: {
                    normal: {
                        color: 'rgb(8,222,247)'
                    }
                },
                areaStyle: {
                    normal: {
                        color: 'rgba(8,222,247, 0.3)'
                    }
                }
            }]
        }]
    };
    if(option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}

/*共性设施使用情况*/
function usage() {
    var dom = document.getElementById("usage");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    app.title = '折柱混合';

    option = {
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            top: '15px',
            right: '15px',
            textStyle: {
                color: '#2b8dfc'
            },
            data: ['共性模块', '共性服务', '共性应用', '支撑平台']
        },
        calculable: true,
        xAxis: [{
            type: 'category',
            axisLabel: {
                textStyle: {
                    color: '#b4e1f7', //坐标值得具体的颜色
                    // fontSize:'14'
                }
            },
            axisLine: {
                lineStyle: {
                    color: '#2b8dfc'
                }
            },
            data: ['201712', '201801', '201812', '201803', '201814', '201805']
        }],
        yAxis: [{
            type: 'value',
            axisLabel: {
                textStyle: {
                    color: '#b4e1f7', //坐标值得具体的颜色
                    // fontSize:'14'
                }
            },
            axisLine: {
                lineStyle: {
                    color: '#2b8dfc'
                }
            },
            splitLine: {
                lineStyle: {
                    color: '#1b1b4f'
                }
            }
        }],
        series: [{
            name: '共性模块',
            type: 'bar',
            itemStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(
                        0, 0, 0, 1, [{
                            offset: 0,
                            color: '#296ed5'
                        },
                            {
                                offset: 0.5,
                                color: '#6c3dd7'
                            },
                            {
                                offset: 1,
                                color: '#9c1bd7'
                            }
                        ]
                    )
                }
            },
            data: [800, 200, 900, 700, 400, 1300]
        },
            {
                name: '共性服务',
                type: 'bar',
                itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1, [{
                                offset: 0,
                                color: '#25d8d5'
                            },
                                {
                                    offset: 1,
                                    color: '#2a91f8'
                                }
                            ]
                        )
                    }
                },
                data: [1400, 300, 1400, 1000, 700, 1800]
            },
            {
                name: '共性应用',
                type: 'bar',
                itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1, [{
                                offset: 0,
                                color: '#c69751'
                            },
                                {
                                    offset: 1,
                                    color: '#308bf4'
                                }
                            ]
                        )
                    }
                },
                data: [500, 200, 600, 400, 300, 700]
            },
            {
                name: '支撑平台',
                type: 'bar',
                itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1, [{
                                offset: 0,
                                color: '#87D673'
                            },
                                {
                                    offset: 1,
                                    color: '#09BBB7'
                                }
                            ]
                        )
                    }
                },
                data: [1800, 400, 1900, 1400, 800, 2600]
            }
        ]
    };;
    if(option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}

/*组件各类别占比情况*/
function assembly(date) {
    var dom = document.getElementById("assembly");
    var myChart = echarts.init(dom);
    var placeHolderStyle = {
        normal: {
            label: {
                show: false
            },
            labelLine: {
                show: false
            },
            color: "rgba(0,0,0,0)",
            borderWidth: 0
        },
        emphasis: {
            color: "rgba(0,0,0,0)",
            borderWidth: 0
        }
    };

    var dataStyle = {
        normal: {
            formatter: '{c}%',
            position: 'center',
            show: true,
            textStyle: {
                padding: [30, 0, 0, 0],
                fontSize: '28',
                fontWeight: 'normal',
                color: '#fff'
            }
        }
    };
    // var left = ['10%','30%','50%','70%','90%'];
    var color = ['#7DCE2F','#CC4335','#00C5D5','#006DC1'];
    var center = [['10%', '45%'],['36%', '45%'],['63%', '45%'],['89%', '45%']];
    var values = [48,36,48,46,56];
    var titles = [];
    var details = [];
    var warq = [{
        type: 'pie',
        hoverAnimation: false, //鼠标经过的特效
        radius: ['59%', '60%'],
        center: center[0],
        startAngle: 225,
        labelLine: {
            normal: {
                show: false
            }
        },
        label: {
            normal: {
                position: 'center'
            }
        },
        data: [{
            value: 75,
            itemStyle: {
                normal: {
                    color: color[0]
                    //								color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                    //									offset: 0,
                    //									color: '#01babc'
                    //								}, {
                    //									offset: 1,
                    //									color: '#99da69'
                    //								}]),
                }
            },
        }, {
            value: 25,
            itemStyle: placeHolderStyle,
        },

        ]
    },
        {
            // name: '总人数',
            type: 'pie',
            hoverAnimation: false, //鼠标经过的特效
            radius: ['59%', '60%'],
            center: center[1],
            startAngle: 225,
            labelLine: {
                normal: {
                    show: false
                }
            },
            label: {
                normal: {
                    position: 'center'
                }
            },
            data: [{
                value: 100,
                itemStyle: {
                    normal: {
                        color: color[1]
                        //								color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        //									offset: 0,
                        //									color: '#01babc'
                        //								}, {
                        //									offset: 1,
                        //									color: '#99da69'
                        //								}]),
                    }
                },
            }, {
                value: 33,
                itemStyle: placeHolderStyle,
            },

            ]
        },
        {
            type: 'pie',
            hoverAnimation: false,
            radius: ['59%', '60%'],
            center: center[2],
            startAngle: 225,
            labelLine: {
                normal: {
                    show: false
                }
            },
            label: {
                normal: {
                    position: 'center'
                }
            },
            data: [{
                value: 75,
                itemStyle: {
                    normal: {
                        color: color[2]
                        //								color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        //									offset: 0,
                        //									color: '#4897f6'
                        //								}, {
                        //									offset: 1,
                        //									color: '#9f3edd'
                        //								}]),
                    }
                },
            }, {
                value: 25,
                itemStyle: placeHolderStyle,
            },

            ]
        },
        {
            type: 'pie',
            hoverAnimation: false,
            radius: ['59%', '60%'],
            center: center[3],
            startAngle: 225,
            labelLine: {
                normal: {
                    show: false
                }
            },
            label: {
                normal: {
                    position: 'center'
                }
            },
            data: [{
                value: 75,
                itemStyle: {
                    normal: {
                        color: color[3]
                        //								color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        //									offset: 0,
                        //									color: '#4897f6'
                        //								}, {
                        //									offset: 1,
                        //									color: '#9f3edd'
                        //								}]),
                    }
                },
            }, {
                value: 25,
                itemStyle: placeHolderStyle,
            },

            ]
        }];
    if(date){
        for(var i=0;i<date.length;i++){
            titles[i]={
                text: date[i].name,
                left: center[i][0],
                top: '70%',
                textAlign: 'center',
                textStyle: {
                    fontWeight: 'normal',
                    fontSize: '16',
                    color: '#fff',
                    textAlign: 'center',
                }
            };
            details[i]={
                type: 'pie',
                hoverAnimation: false, //鼠标经过的特效
                radius: ['45%', '59%'],
                center:center[i],
                startAngle: 225,
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                label: {
                    normal: {
                        position: 'center'
                    }
                },
                data: [{
                    value: date[i].num,
                    itemStyle: {
                        normal: {
                            color: color[i],
                        }
                    },
                    label: dataStyle,
                }, {
                    value: 133-date[i].num,
                    itemStyle: placeHolderStyle,
                },

                ]
            }
        }
        $.each(warq,function(index,value){
            details.push(value);
        });
    }
    var option = null;
    option = {
        title: titles,
        series: details,
    };
    if(option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}
/*应用集成发展情况*/
function Integrate() {
    var dom = document.getElementById("Integrate");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    app.title = '折柱混合';

    option = {
        tooltip: {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            right: '5%',
            bottom: '10%',
            data: ['平台应用', '接入应用'],
            textStyle: {
                color: '#2a9cff'
            }
        },
        series: [{
            name: '救助资金分布（%）',
            type: 'pie',
            radius: '60%',
            center: ['50%', '50%'],

            data: [{
                value: 60,
                name: '平台应用'
            },
                {
                    value: 40,
                    name: '接入应用'
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
        color: ['#0e43d0', '#844af6']
    };;
    if(option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}