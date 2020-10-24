$(function () {
    CurentTime();
    setInterval(CurentTime, 1000);
    /*nav导航*/
    $(".py_ul_l li a").eq("1").addClass("nav_bg");
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

    /*平台数据情况*/
    //dataPlatform_ptsjqq_fun();
    /*部门使用情况*/
    //dataPlatform_bmsyqk_fun();
    /*  api调用*/
    //dataPlatform_demo_ybq_fun();
    /*数据趋势*/
    //dataPlatform_sjqs_fun();
    /*关系图*/
    //dataPlatform_gxt_fun();
    /*云标签*/

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

/*平台数据情况*/
function dataPlatform_ptsjqq_fun(busTitle, dirList, setList, apiList) {
    var dom = document.getElementById("dataPlatform_ptsjqq");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                label: {
                    backgroundColor: '#6a7985'
                }
            }
        },
        legend: {
            top: 0,
            data: ['数据目录', '数据集', 'API'],
            textStyle: {
                fontSize: 12,
                color: '#96bdd2'
            }
        },

        grid: {
            top: 10,
            left: '3%',
            right: '4%',
            bottom: '6%',
            containLabel: true
        },
        xAxis: [{
            type: 'category',
            boundaryGap: false,
            data: busTitle,
            axisLine: {
                lineStyle: {
                    color: '#96bdd2',
                    fontSize: '12'
                }
            }
        }],
        yAxis: [{
            name: '单位/个',
            nameGap: -10,
            nameTextStyle: {
                padding: [20, 0, 0, 50]
            },
            type: 'value',

            splitLine: {
                show: false
            },
            axisLine: {
                lineStyle: {
                    color: '#96bdd2'
                }
            }
        }],
        series: [{
            name: '数据目录',
            type: 'line',

            smooth: true,
            areaStyle: {
                normal: {}
            },
            data: dirList,
            itemStyle: {
                color: '#989bfe',
                fontSize: '12'
            },
            areaStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: 'rgba(152, 155, 254,.3)'
                    }, {
                        offset: 1,
                        color: 'rgba(152, 155, 254,.3)'
                    }])
                }
            }
        },
            {
                name: '数据集',
                type: 'line',

                smooth: true,
                areaStyle: {
                    normal: {}
                },
                data: setList,
                itemStyle: {
                    color: '#3380c3',
                    fontSize: '12'
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgba(53, 132, 202,.3)'
                        }, {
                            offset: 1,
                            color: 'rgba(53, 132, 202,.3)'
                        }])
                    }
                }
            },

            {
                name: 'API',
                type: 'line',
                smooth: true,
                label: {
                    normal: {
                        show: false,
                        position: 'top'
                    }
                },
                data: apiList,
                itemStyle: {
                    color: '#03ffbb',
                    fontSize: '12'
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgba(3, 255, 187,.3)'
                        }, {
                            offset: 1,
                            color: 'rgba(3, 255, 187,.3)'
                        }])
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


/*部门使用情况*/
function dataPlatform_bmsyqk_fun(busTitle, apiList, dirList) {
    var dom = document.getElementById("dataPlatform_bmsyqk");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    app.title = '折柱混合';

    option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                crossStyle: {
                    color: '#999'
                }
            }
        },

        legend: {
            data: ['目录数', 'API数'],
            top: 0,
            textStyle: {
                fontSize: 12,
                color: '#96bdd2'
            }
        },
        grid: {
            top: 10,
            left: '3%',
            right: '4%',
            bottom: '6%',
            containLabel: true
        },
        xAxis: [{
            type: 'category',
            data: busTitle,
            axisPointer: {
                type: 'shadow'
            },
            axisLabel: {
                interval: 0,
                //				padding:[15,-20,0,0],
                //				rotate: 20
            },
            axisLine: {
                lineStyle: {
                    color: '#96bdd2',
                    fontSize: '12'
                }
            }
        }],
        yAxis: [{
            type: 'value',
            name: '单位/个',
            nameGap: -10,
            nameTextStyle: {
                padding: [0, 0, 0, 50]
            },
            min: 0,
            interval: 500,
            splitLine: {
                show: false
            },
            axisLabel: {
                formatter: '{value}'
            },
            axisLine: {
                lineStyle: {
                    color: '#96bdd2',
                    fontSize: '12'
                }
            }
        }],

        series: [

            {
                name: '目录数',
                type: 'bar',
                data: dirList,
                barWidth: 25,
                itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1, [{
                                offset: 0,
                                color: '#2a86f2'
                            },
                                {
                                    offset: 1,
                                    color: '#0b88a9'
                                }
                            ]
                        )
                    }
                }

            },
            {
                name: 'API数',
                type: 'line',
                data: apiList,
                itemStyle: {
                    color: '#eca815',
                    fontSize: '12'
                }
            }
        ]
    };

    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}

/*  api调用*/

function dataPlatform_demo_ybq_fun(data) {
    var dom = document.getElementById("dataPlatform_ybq");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    var bgImg = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADQAAAF+CAYAAADNzDlVAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAilJREFUeNrs1rENwjAURdEfC0pmQAwBDfuwE8wDDSULIGagTGEcFNHQpfPXseT0V0ryzrA/XzcRsWt3HX2fsd1XSRITc8O2JIn5RZVIdsr87mU54xT0TBL1/Sms2uPd7qPXivvp+PfKpfuGBAkStPxMf7muLXe43FiO5ViO5VjOsAoSxHIsx3Isx3Isx3KGVZAglmM5lmM5lmM5liMFQYJYjuVYjuVYjuVYTpAgQSzHcizHcizHcoZVkCCWYzmWYzmWYzmWM6yCBLEcy7Ecy7Ecy7GcIEGCWI7lWI7lWI7lDKsgQYJYjuVYjuVYjuUMqyBBLMdyLMdyLMdyLGdYBQliOZZjOZZjOZZjOUGCBLEcy7Ecy7EcyxlWQYJYjuVYjuVYjuVYzrAKEsRyLMdyLMdyLMdypCBIEMuxHMuxHMuxnGEVJEgQy7Ecy7Ecy7GcYRUkiOVYjuVYjuVYjuUMqyBBLMdyLMdyLMdyLCdIkCCWYzmWYzmWYznDKkgQy7Ecy7Ecy7EcyxlWQYJYjuVYjuVYjuVYjhQECWI5lmM5lmM5ljOsggQJYjmWYzmWYzmWM6yCBLEcy7Ecy7Ecy7GcYRUkiOVYjuVYjuVYjuUECRLEcizHcizHcixnWAUJYjmWYzmWYzmWYznDKkgQy7Ecy7Ecy7Ecy5GCIEEsx3Isx3Isx3IsJ0iQIJZjOZZjOZZjOcMqSBDLsRzLsRzL9Wy5odZqhwQJWn4+AgwApGqd0LftHcgAAAAASUVORK5CYII=';

    var fillImg = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADQAAAF+CAYAAADNzDlVAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAABFhJREFUeNrs3U+O1DgUgHHblUFzhb7GCCHNtnfMFUasOA9HYEWfAQlpZq6AEOIIdPcFZgMVe5L6Q6pLzQjFLZK2fpZSKbVioQ8n9b68+Dnxz39fXYYYrkIIF+Fxt5the5kagQkHhtepEZhvUCk01tLh3Gul3aZQwovxSwMwn8cfhW74+Lul66jJawgQIEB1QJfDdj1s5ZFvI8NzLsfluByX43KAlmzjKRdyTkYIEJeb6XK5JC7H5bhchculmLmcOASoAqjPGyMEiMtVuFyMhctxOS5X4XKlRC4nDgECBIjLLeVyXSnpqhQux+W43FyXi/Jy4hCgKqC+74wQIC5XkZdLKcvLcTkuV+FyOScuJw4Bmt/MlwPE5WprH4LaBy7H5WpcbvjgcuIQIECAuByXe0iXy4eJtOONXilx2NJh238PIYbpmPP9qvpc7O5YU+r351/KB9hyAl7C3WPO9+vqs3O5hkZocrn9H+PJwdP3Y87h/n9sNX24HKBFgLaesQLiclUul9Q+yMvJy1Xl5bLaB3EIUE3biVzvGSsgLjfb5Yb7ci7H5bhchcvFWLicOAQIECAux+W43P1QXcmpuWuotbyc2gdxCFBF29c+FHk5QFzOfDl5OS63jMsFtQ/iECBAgLgcl+Ny34PqcoMrot+cFkzEWIbtuN9/H0/R/yuyWFGf2zR8vBiLIHa5hTsFE3FGkcWifT4Pey63fqDt9hemsOYWSylGaM2t++P6zWUjS7KNuZGX1pdbO5S83Mqb9eXEIUC1gfV4r2GEAP08IHk5LsfluNzkcsEzVnEIULXLFS4HiMvNdrnh+uFyXI7LVbhcTN7hJQ4BqnU5eTlAXG6+y/XbjstxOS5X4XJ93nA5cQhQrcupYwXE5Wa7XLRWMJfjclUuV6wVLA4BAgSIyy3ncl0p6aoULsfluNxcl4vRM1ZxCBAgQFxuybWC25ov1+Wc2nK543tOj/tpeYxpOz9mzX3GERpd7uI4PWZcGuO8Hf82vSr07n5FfW7TZrPlcuIQoAqgL19+NUKAuFyFyw1xyDPWVbtci9dQY/Pl+o7LiUOA5rdD7cPGCAHicubLcTkut4jLmS8nDgF6CJdT+wCIy3kfK5fjcsu43HA/xOXEIUCVLnffhAYjBIjL/ZjLZevLcTkuV+Vyyfpy4hCgKqCvX58YIUBcbr7Lxd8/vb1u6Gf7hstxuZ/tcp6xikOAAAHicubLPYz2BHk5LsfluJzA+tja7hlrr/YBEJeb63Lx2cd38nJcjstVuFyyvpw4BAgQIC7H5bgcl3u0Lpd77/AShwBVNGuSAOJylS739MNf7blcSv1+uFI+LFmbT5avzbv/gOmY8/2q+lzc+ZWbqvZPK76OS9duvrNfV5/2XG4YMS4nDgECBIjLcbmHdLmGzjh5OS7H5cShxoGsLweIy1W63G/v/+FyXI7LVbic+XLiECBAgLgcl+NyXI7LrcXlYilFHAIEaH77T4ABAKzsRPWz+TQ7AAAAAElFTkSuQmCCgg';
    var chartData = data.sort(down);

    var bgData = [];
    var itemData = [];

    // 取出每一条数据value,作为显示数据
    chartData.forEach(function (items, index) {
        itemData.push(items.value);
    })

    // 取出所有数据最大值,作为背景象形柱图数据
    chartData.forEach(function (items, index) {
        bgData.push({
            name: items.name,
            value: Math.max.apply(null, itemData)
        });
    })

    // 所有数据最大值
    var maxValue = Math.max.apply(null, itemData);

    // 字体 distance放大参数
    var scale = 1;

    //富文本配置
    var rich = {
        white: {
            color: "#fff",
            align: 'left',
            fontSize: 18 * scale,
            padding: [0, 0]
        },
    };

    var option = {
        /* backgroundColor: '#031f2d',*/
        tooltip: {
            formatter: '{b} : {c}',
        },
        grid: {
            left: '3%',
            right: '6%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [{
            type: 'category',

            data: (function (data) {
                var arr = [];
                data.forEach(function (items) {
                    arr.push(items.name);
                });
                return arr;
            })(chartData),

            boundaryGap: ['20%', '20%'],
            splitLine: {
                show: false
            },
            axisLine: {
                /* show: false*/
                lineStyle: {
                    color: '#96bdd2',
                    fontSize: '12'
                }
            },
            axisTick: {
                show: false
            },
            axisLabel: {
                interval: 0,
                rotate: 60,
                textStyle: {
                    fontSize: 14 * scale,
                    color: '#3fdaff'
                }
            }
        }],
        yAxis: [{
            type: 'value',
            splitLine: {
                show: false
            },
            axisLine: {
                show: false
            },
            axisTick: {
                show: false //控制刻度的属性
                /*,
                inside: true,
                length: 10 * scale,
                lineStyle: {
                    color: '#0b5263'
                }*/
            },
            axisLabel: {
                show: false //控制y轴标注的属性
                /*textStyle: {
                    color: '#0b5263',
                    fontSize: 14 * scale
                }*/
            },
        }],
        series: [
            //背景
            {
                name: 'bg',
                type: 'pictorialBar',
                barWidth: '45%',
                // barGap: '0%',
                silent: true,
                label: {
                    normal: {
                        show: true,
                        position: "top",
                        distance: 20 * scale,
                        formatter: function (params) {
                            var stuNum = 0;
                            chartData.forEach(function (value, index, array) {
                                if (params.name == value.name) {
                                    stuNum = value.value;
                                }
                            })
                            return stuNum + '{white| }';
                        },
                        textStyle: {
                            color: "#b4e1f7",
                            fontSize: 16
                        },
                        rich: rich
                    }
                },
                symbol: 'image://' + bgImg,
                symbolClip: false,
                symbolBoundingData: maxValue,
                symbolSize: [52, '100%'],
                data: bgData
            },
            {
                name: '数据',
                type: 'pictorialBar',
                barWidth: '45%',
                barGap: '-100%',
                data: chartData,
                z: 3,
                symbol: 'image://' + fillImg,
                symbolClip: true,
                symbolBoundingData: maxValue,
                symbolSize: [52, '100%']
            },
        ]
    };

    function down(x, y) {
        return y.value - x.value;
    }

    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}

/*数据趋势*/
var a = "123.168.0.22";

function dataPlatform_sjqs_fun(busTitle, dataList, apiCallList) {
    var dom = document.getElementById("dataPlatform_sjqs");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    option = {
        legend: {
            data: ['调用次数', '数据交换量'],
            textStyle: {
                fontSize: 12,
                color: '#96bdd2'
            }
        },
        tooltip: {
            trigger: 'axis',
        },
        grid: {
            top: 10,
            left: '3%',
            right: '4%',
            bottom: '6%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: busTitle,
            axisLine: {
                lineStyle: {
                    color: '#96bdd2',
                    fontSize: '12'
                }
            }
        },
        yAxis: {
            type: 'value',
            interval: 1000,
            splitLine: {
                show: false
            },
            axisLine: {
                lineStyle: {
                    color: '#96bdd2',
                    fontSize: '12'
                }
            }
        },
        series: [{
            name: '调用次数',
            type: 'line',
            data: apiCallList,
            itemStyle: {
                color: '#009cff',
                fontSize: '12'
            }
        },
            {
                name: '数据交换量',
                type: 'line',
                data: dataList,
                itemStyle: {
                    color: '#a703f7',
                    fontSize: '12'
                }
            }
        ]
    };

    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}

/*关系图*/

/*关系图*/
function dataPlatform_gxt_fun(shipData) {
    var dom = document.getElementById("dataPlatform_gxt");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    var dwIcon = "../../static/images/share/icon_002.png";
    var mlIcon = "../../static/images/share/icon_001.png";
    var sjjIcon = "../../static/images/share/icon_005.png";
    var apiIcon = "../../static/images/share/icon_006.png";
    var maxLen = 9;
    var xs = 1; //横坐标节点的距离
    var gs = 2; //横坐标组的距离
    var lines = [];
    var lineColors = ['#13DCE0', '#FA38B4', '#FFE817', '#FFE858', '#FFE869'];
    data = shipData;
    formateJson(data.sort(function (a, b) {
        return a.sortValue - b.sortValue;
    }));

    function formateJson(data) {
        var m = 0;
        var n = 0;
        var oldSortValue;
        data.map(function (value, index) {
            value.value = [];
            if (index == 0) {
                value.value[1] = n;
            } else {
                if (n > maxLen - 1) {
                    m += xs;
                    n = 0;
                }
                if (value.sortValue != oldSortValue) {
                    m += gs;
                    n = 0;
                }
                value.value[1] = n;
            }
            if (m == 0) {
                value.value[0] = value.sortValue;
            } else {
                value.value[0] = m;
            }
            n++;
            oldSortValue = value.sortValue;
        })
    }

    function getCoordByName(name) {
        var coord;
        $.each(data, function (index, value) {
            if (value.name == name) {
                coord = value.value;
            }
        });
        return coord;
    }

    function getLines(data) {
        $.each(data, function (index1, value1) {
            if (value1.target && value1.target.length) {
                $.each(value1.target, function (index, value) {
                    lines.push({
                        fromName: value1.name,
                        toName: value.name,
                        coords: [value1.value, getCoordByName(value.name)],
                        relation: value.type
                    });
                });
            }
        })
    }

    getLines(data);
    console.log(data)
    option = {
        legend: {
            show: true,
            //			orient: 'vertical',
            top: 30,
            x: 'center',
            right: '10%',
            itemWidth: 30,
            itemHeight: 5,
            data: ['', '数据流'],
            textStyle: {
                color: '#fff'
            }
        },
        tooltip: {
            formatter: '{b}'
        },
        grid: {
            top: '15%',
        },
        xAxis: {
            //			min:0,
            //			max:15,
            axisLine: {
                show: false
            },
            axisTick: {
                show: false
            },
            axisLabel: {
                show: false
            },
            splitLine: {
                show: false
            }
        },
        yAxis: {
            //			min:0,
            //			max:15,
            axisLine: {
                show: false,
            },
            axisTick: {
                show: false
            },
            axisLabel: {
                show: false
            },
            splitLine: {
                show: false,
            }
        },
        series: [{
            name: '应用节点',
            coordinateSystem: 'cartesian2d',
            type: 'effectScatter',
            zlevel: 2,
            symbolSize: 8,
            //			symbol: 'image://' + retailtable,
            rippleEffect: {
                brushType: 'stroke',
                period: 7,
                scale: 6
            },
            data: data.map(function (node, idx) {
                switch (node.category) {
                    case 'api':
                        node.symbol = 'image://' + apiIcon;
                        break;
                    case 'ml':
                        node.symbol = 'image://' + mlIcon;
                        break;
                    case 'sjj':
                        node.symbol = 'image://' + sjjIcon;
                        break;
                    case 'dw':
                        node.symbol = 'image://' + dwIcon;
                        break;
                    default:
                        break;
                }
                node.label = {
                    show: true,
                    formatter: function (data) {
                        if (data.name.length > 3) {
                            return data.name.substr(0, 3) + '...';
                        } else {
                            return data.name;
                        }
                    },
                    offset: [-15, -15],
                    color: 'rgba(255,255,255,.7)',
                    rotate: 45,
                };
                return node;
            })
        }, {
            name: '数据流',
            type: 'lines',
            coordinateSystem: 'cartesian2d',
            zlevel: 2,
            large: true,
            effect: {
                show: true,
                constantSpeed: 30,
                symbol: 'arrow', //ECharts 提供的标记类型包括 'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'
                symbolSize: 6,
                trailLength: 0,
            },
            lineStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: '#58B3CC'
                    }, {
                        offset: 1,
                        color: '#F58158'
                    }], false),
                    width: 1,
                    opacity: 0.6,
                    curveness: 0.2
                }
            },
            data: lines.map(function (node, idx) {
                switch (node.relation) {
                    case '(拥有)目录':
                        node.lineStyle = {
                            color: lineColors[0]
                        };
                        break;
                    case '(拥有)数据集':
                        node.lineStyle = {
                            color: lineColors[1]
                        };
                        break;
                    case '(拥有)API':
                        node.lineStyle = {
                            color: lineColors[2]
                        };
                        break;
                    case '共享':
                        node.lineStyle = {
                            color: lineColors[3]
                        };
                        break;
                    case '申请':
                        node.lineStyle = {
                            color: lineColors[4]
                        };
                        break;
                    default:
                        break;
                }
                node.name = node.relation;
                node.label = {
                    show: true,
                    color:'rgba(0,0,0,0)',
                    position: 'middle'
                };
                return node;
            })
        }]
    }
    if (option && typeof option === "object") {
        myChart.on('mouseover', function (params) {
            var lines = myChart.getOption().series[1];
            lines.effect.symbolSize = 0;
            var nodes = myChart.getOption().series[0];
            var series = [];
            if (params.componentSubType == 'effectScatter') {
                lines.data.map(function (value, index) {
                    if (value.fromName == params.name || value.toName == params.name) {
                        if ((value.coords[0][0] == params.value[0] && value.coords[0][1] == params.value[1]) || value.coords[1][0] == params.value[0] && value.coords[1][1] == params.value[1]) {
                            return value.label.color = value.lineStyle.color;
                        } else {
                            value.label ? value.label.color = 'rgba(255,255,255,.1)' : value.label = {color: 'rgba(255,255,255,.1)'};
                            value.lineStyle ? value.lineStyle.opacity = 0.1 : value.lineStyle = {opacity: 0.1};
                            return value
                        }
                    } else {
                        value.label ? value.label.color = 'rgba(255,255,255,.1)' : value.label = {color: 'rgba(255,255,255,.1)'};
                        value.lineStyle ? value.lineStyle.opacity = 0.1 : value.lineStyle = {opacity: 0.1};
                        return value
                    }
                })
                //高亮自己
                nodes.data.map(function (value, index) {
                    if (value.name != params.name) {
                        value.symbolSize = 1;
                        value.itemStyle ? value.itemStyle.opacity = 0.1 : value.itemStyle = {opacity: 0.1};
                    }
                    // return value;
                })
                //把它自己直接关联的高亮
                nodes.data.map(function (value, index) {
                    if (value.name == params.name) {
                        if (value.target && value.target.length) {
                            $.each(value.target, function (index1, value1) {
                                nodes.data.map(function (value2, index2) {
                                    if (value1.name == value2.name) {
                                        value2.symbolSize = 8;
                                        value2.itemStyle ? value2.itemStyle.opacity = 1 : value2.itemStyle = {opacity: 1};
                                    }
                                })
                            })
                        }
                    }
                })
                //把直接关联它自己的高亮
                nodes.data.map(function (value, index) {
                    if (value.name != params.name) {
                        if (value.target && value.target.length) {
                            value.target.map(function (value1, index1) {
                                if(value1.name == params.name){
                                    value.symbolSize = 8;
                                    value.itemStyle ? value.itemStyle.opacity = 1 : value.itemStyle = {opacity: 1};
                                }
                            })
                        }
                    }
                })
                series.push(lines);
                series.push(nodes);
                console.log(series)
                myChart.setOption({
                    series: series
                })
            }
        });
        myChart.on('mouseout', function (params) {
            var lines = myChart.getOption().series[1];
            lines.effect.symbolSize = 6;
            var nodes = myChart.getOption().series[0];
            var series = [];
            if (params.componentSubType == 'effectScatter') {
                lines.data.map(function (value, index) {
                    value.label.color = 'rgba(0,0,0,0)';
                    value.lineStyle.opacity = 1;
                    return value;
                })
                nodes.data.map(function (value, index) {
                    value.symbolSize = 8;
                    value.itemStyle ? value.itemStyle.opacity = 1 : value.itemStyle = {opacity: 1};
                    return value;
                })
                series.push(lines);
                series.push(nodes);
                console.log(series);
                myChart.setOption({
                    series: series
                })
            }
        });
        myChart.setOption(option, true);
    }
}

/*云标签*/