    getOrgShare();
    getApiTop();
    getgxqptData();
    getDataTrend();
    getDirMonthData();
    getDirTypeNum();
    getDirMonthCallInfo();
    getUnitDirTypeNum();
    var parm = {
        data: {},
        pageNo: 1,
        pageSize: 10,

    };

    $(".navsecond li").click(function () {
        $(".navsecond li a").removeClass('active');
        $($(this).find('a')[0]).addClass('active');
        var shareTypeNum = Number($(this).attr('data-shareType'));
        parm.shareType = shareTypeNum;
        parm.pageNo = 1;
        getList(parm, shareTypeNum);
    })

    getList(parm, 1);

    /**
     * 查询API调用信息
     */


    function getList(parm, shareTypeNum) {
        parm.data = shareTypeNum || 2;
        ajaxHengyun({
            type: "POST",
            dataType: 'json',
            contentType: 'application/json',
            url: _gateUrl + '/api/exchange/screen/getApiCallInfo',
            data: JSON.stringify(parm),
            success: function (rows) {
                var html = ""
                var colspanNum = 8
                if (shareTypeNum === 2) {
                    colspanNum = 9
                }
                if (rows.data) {
                    rows.data.list.forEach(function (value, index) {
                        var value = dealElement(value);
                        var num = (rows.data.pageNum - 1) * 10 + index + 1;
                        html += '<tr>';
                        html += '<td>' + num + '</td>';
                        html += '<td>' + value.dirName + '</td>';
                        html += '<td>' + value.apiName + '</td>';
                        html += '<td>' + value.ipAddr + '</td>';
                        if (shareTypeNum === 2) {
                            html += '<td>' + value.unitName + '</td>';
                        }
                        html += '<td>' + value.visitTime + '</td>';
                        html += '<td>' + value.dataCount + '</td>';
                        html += '</tr>';
                    });
                    if (rows.data.list.length == 0) {
                        html += "<tr><td class='text-center' colspan='" + colspanNum + "'>暂无数据</td></tr>"
                        $(".pagination,.currentPage").css("display", "none");
                    } else {
                        $(".pagination,.currentPage").css("display", "inline-block");
                    }
                    if (shareTypeNum === 2) {
                        $(".unitName").css("display", "table-cell")
                    } else {
                        $(".unitName").css("display", "none")
                    }
                    $("#dataList tbody").html(html);
                    $('#totalPages').text(rows.data.pages);
                    $('.total').text(rows.data.total);
                    jqPaginator(rows.data);
                    updateIformHeight();
                } else {
                    html += "<tr><td class='text-center' colspan='" + colspanNum + "'>暂无数据</td></tr>";
                    $("#dataSourceList tbody").html(html);
                    $(".pagination,.currentPage").css("display", "none");
                    updateIformHeight();
                }
            }
        });
    }

    /**
     * 部门共享情况
     */
    function getOrgShare() {
        ajaxHengyun({
            type: 'POST',
            // async: false,
            dataType: 'json',
            url: _gateUrl + '/api/exchange/screen/getOrgUseView',
            success: function (rows) {
                if (rows.data) {
                    var value = rows.data;
                    deptShare(value.busTitle, value.apiList, value.dirList);
                }
            }
        });
    }

    /**
     * api调用TOP10
     */
    function getApiTop() {
        ajaxHengyun({
            type: 'POST',
            // async: false,
            dataType: 'json',
            url: _gateUrl + '/api/exchange/screen/getApiCallTopList',
            success: function (rows) {
                if (rows.data) {
                    topTen(rows.data.returnList);
                }
            }
        });
    }

    /**
     * 平台数据情况
     */
    function getgxqptData() {
        ajaxHengyun({
            type: 'POST',
            // async: false,
            dataType: 'json',
            url: _gateUrl + '/api/exchange/screen/getShareDataView',
            success: function (rows) {
                if (rows.data) {
                    var value = rows.data;
                    for (var i in value.dirList) {
                        value.dirList[i] = value.dirList[i] * 41;
                        value.setList[i] = value.setList[i] * 42;
                        value.apiList[i] = value.apiList[i] * 37;
                    }
                    dataShap(value.busTitle, value.dirList, value.setList, value.apiList)
                }
            }
        });
    }

    /**
     * 数据趋势
     */
    function getDataTrend() {
        ajaxHengyun({
            type: 'POST',
            // async: false,
            dataType: 'json',
            url: _gateUrl + '/api/exchange/screen/getDataTrend',
            success: function (rows) {
                if (rows.data) {
                    var value = rows.data;
                    dataTrend(value.busTitle, value.dataList, value.apiCallList);
                }
            }
        });
    }

    /**
     * 目录数量统计图
     */
    function getDirMonthData() {
        ajaxHengyun({
            type: 'GET',
            // async: false
            dataType: 'json',
            url: _gateUrl + '/api/exchange/screen/getDirMonthData',
            success: function (rows) {
                if (rows.data) {
                    var value = rows.data;
                    var xData = []
                    var yData = {
                        openNum: [],
                        shareNum: [],
                        totalNum: []
                    }
                    value.forEach(function (item, index) {
                        xData.push(item.createMonth)
                        yData.openNum.push(item.openNum)
                        yData.shareNum.push(item.shareNum)
                        yData.totalNum.push(item.totalNum)
                    });
                    dirMonthData(xData, yData);
                }
            }
        });
    }

    /**
     * 查询目录占比
     */
    function getDirTypeNum() {
        ajaxHengyun({
            type: 'GET',
            // async: false
            dataType: 'json',
            url: _gateUrl + '/api/exchange/screen/getDirTypeNum',
            success: function (rows) {
                if (rows.data) {
                    var value = rows.data;
                    dirTypeNum(value);
                }
            }
        });
    }

    /**
     * 查询目录月度调用次数
     */
    function getDirMonthCallInfo() {
        ajaxHengyun({
            type: 'GET',
            // async: false
            dataType: 'json',
            url: _gateUrl + '/api/exchange/screen/getDirMonthCallInfo',
            success: function (rows) {
                if (rows.data) {
                    var value = rows.data;
                    var xData = []
                    var yData = {
                        openNum: [],
                        shareNum: [],
                        totalNum: []
                    }
                    value.forEach(function (item, index) {
                        xData.push(item.callMonth)
                        yData.openNum.push(item.openNum)
                        yData.shareNum.push(item.shareNum)
                        yData.totalNum.push(item.shareNum + item.openNum)
                    });
                    dirMonthCallInfo(xData, yData);
                }
            }
        });
    }

    /**
     * 查询各单位开放与不开放的占比
     */
    function getUnitDirTypeNum() {
        ajaxHengyun({
            type: 'GET',
            // async: false
            dataType: 'json',
            url: _gateUrl + '/api/exchange/screen/getUnitDirTypeNum',
            success: function (rows) {
                if (rows.data) {
                    $("#unitAnalysis").html('');
                    var value = rows.data;
                    value.forEach(function (item, index) {
                        var idName = "unitDirTypeAnalysis" + index;
                        var html = '<div class="col-md-4 col-lg-4 col-sm-4">\n' +
                            '<div id="' + idName + '" class="analysis"></div>\n' +
                            '</div>'
                        $("#unitAnalysis").append(html)
                        updateIformHeight();
                        unitDirTypeNum(idName, item)
                    })
                }
            }
        });
    }

    function unitDirTypeNum(id, data) {
        var myChart = echarts.init(document.getElementById(id));
        var option = {
            title: {
                text: data.unitName,
                x: 'left'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                left: 'center',
                bottom: '10',
                data: ['共享目录', '开放目录']
            },
            series: [
                {
                    name: '单位部门开放共享目录占比',
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '60%'],
                    data: [
                        {value: data.shareNum, name: '共享目录'},
                        {value: data.openNum, name: '开放目录'},
                    ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    };

    function dirMonthCallInfo(xData, yData) {
        var myChart = echarts.init(document.getElementById('dirMonthCallInfo'));
        var option = {
            backgroundColor: '#fff',
            title: {
                text: '目录调用次数统计'
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow'
                }
            },
            legend: {data: ["共享目录", "开放目录"]},
            grid: {
                left: '3%',
                right: '4%',
                bottom: '10%',
                containLabel: true
            },
            xAxis: [{
                type: 'category',
                data: xData,
                axisLabel: {
                    show: true,
                    textStyle: {
                        color: "#00c7ff",
                    },
                    interval: 0,
                    rotate: 30
                },
                axisLine: {
                    show: true,
                    lineStyle: {
                        color: "#A6A6A6",
                        width: 1,
                        type: "solid"
                    },
                },
                axisTick: {
                    show: false
                }
            }],
            yAxis: [{
                type: 'value',
                axisTick: {
                    show: false,
                },
                axisLine: {
                    show: true,
                    lineStyle: {
                        color: "#A6A6A6",
                        width: 1,
                        type: "solid"
                    },
                },
                splitLine: {
                    show: false
                }
            }],
            series: [{
                name: '开放目录',
                type: 'bar',
                data: yData.openNum,
                barGap: 1,
                barWidth: 20,
                itemStyle: {
                    normal: {
                        color: '#b78217'
                    }
                }
            }, {
                name: '共享目录',
                type: 'bar',
                data: yData.shareNum,
                barGap: 1,
                barWidth: 20,
                itemStyle: {
                    normal: {
                        color: '#2392fb'
                    }
                }
            }/*, {
                name: '目录总数',
                type: 'line',
                data: yData.totalNum,
                barGap: 1,
                itemStyle: {
                    normal: {
                        color: '#b78217'
                    }
                }
            }*/]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    };

    function dirTypeNum(data) {
        var myChart = echarts.init(document.getElementById('catalogTotal'));
        var color = ['#fb734e', '#e32f46', '#94d96c', '#0bbcb7', '#1a9bfc', '#7049f0', '#FFE84E', '#F9A11C'];
        var dataStyle = {
            normal: {
                label: {
                    show: false
                },
                labelLine: {
                    show: false
                },
                shadowBlur: 40,
                borderWidth: 10,
                shadowColor: 'rgba(0, 0, 0, 0)' //边框阴影
            }
        };
        var placeHolderStyle = {
            normal: {
                color: '#393d50',
                label: {
                    show: false
                },
                labelLine: {
                    show: false
                }
            },
            emphasis: {
                color: '#393d50'
            }
        };
        option = {
            backgroundColor: '#fff',
            title: {
                text: '目录数量占比'
            },
            tooltip: {
                trigger: 'item',
                show: true,
                formatter: "{b} : <br/>{d}%",
                backgroundColor: 'rgba(0,0,0,0.7)', // 背景
                padding: [8, 10], //内边距
                extraCssText: 'box-shadow: 0 0 3px rgba(255, 255, 255, 0.4);', //添加阴影
            },
            legend: {
                // orient: 'vertical',
                // icon: 'circle',
                left: 'center',
                bottom: '10',
                itemGap: 20,
                data: ['开放目录', '无条件共享目录', '有条件共享目录', '不共享目录'],
                textStyle: {
                    color: '#fft'
                }
            },
            series: [{
                type: 'pie',
                clockWise: false,
                radius: ['35%', '40%'],
                center: ['50%', '45%'],
                itemStyle: dataStyle,
                hoverAnimation: false,
                startAngle: 36,
                label: {
                    borderRadius: '10',
                },
                data: [{
                    value: data.openNum,
                    name: '开放目录',
                    itemStyle: {
                        normal: {
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                offset: 0,
                                color: color[0]
                            }, {
                                offset: 1,
                                color: color[1]
                            }])
                        }
                    }
                },
                    {
                        value: 45.4,
                        name: '',
                        tooltip: {
                            show: false
                        },
                        itemStyle: placeHolderStyle
                    },
                ]
            },
                {
                    type: 'pie',
                    clockWise: false,
                    radius: ['45%', '50%'],
                    center: ['50%', '45%'],
                    itemStyle: dataStyle,
                    hoverAnimation: false,
                    startAngle: 72,
                    data: [{
                        value: data.noShareNum,
                        name: '无条件共享目录',
                        itemStyle: {
                            normal: {
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                    offset: 0,
                                    color: color[2]
                                }, {
                                    offset: 1,
                                    color: color[3]
                                }])
                            }
                        }
                    },
                        {
                            value: 43.3,
                            name: '',
                            tooltip: {
                                show: false
                            },
                            itemStyle: placeHolderStyle
                        },
                    ]
                },
                {
                    type: 'pie',
                    clockWise: false,
                    radius: ['55%', '60%'],
                    center: ['50%', '45%'],
                    itemStyle: dataStyle,
                    hoverAnimation: false,
                    startAngle: 108,
                    data: [{
                        value: data.condShareNum,
                        name: '有条件共享目录',
                        itemStyle: {
                            normal: {
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                    offset: 0,
                                    color: color[4]
                                }, {
                                    offset: 1,
                                    color: color[5]
                                }]),
                            }
                        }
                    },
                        {
                            value: 0,
                            name: '',
                            tooltip: {
                                show: false
                            },
                            itemStyle: placeHolderStyle
                        },
                    ]
                },
                {
                    type: 'pie',
                    clockWise: false,
                    radius: ['65%', '70%'],
                    center: ['50%', '45%'],
                    itemStyle: dataStyle,
                    hoverAnimation: false,
                    startAngle: 144,
                    data: [{
                        value: data.noShareNum,
                        name: '不共享目录',
                        itemStyle: {
                            normal: {
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                    offset: 0,
                                    color: color[6]
                                }, {
                                    offset: 1,
                                    color: color[7]
                                }]),
                            }
                        }
                    },
                        {
                            value: 0,
                            name: '',
                            tooltip: {
                                show: false
                            },
                            itemStyle: placeHolderStyle
                        },
                    ]
                }
            ]
        };
        myChart.setOption(option);
    };

    function dirMonthData(xData, yData) {
        var myChart = echarts.init(document.getElementById('dirMonthData'));
        var option = {
            backgroundColor: '#fff',
            title: {
                text: '目录数量统计图'
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow'
                }
            },
            legend: {data: ["总数", "共享目录", "开放目录"]},
            grid: {
                left: '3%',
                right: '4%',
                bottom: '10%',
                containLabel: true
            },
            xAxis: [{
                type: 'category',
                data: xData,
                axisLabel: {
                    show: true,
                    textStyle: {
                        color: "#00c7ff",
                    },
                    interval: 0,
                    rotate: 30
                },
                axisLine: {
                    show: true,
                    lineStyle: {
                        color: "#A6A6A6",
                        width: 1,
                        type: "solid"
                    },
                },
                axisTick: {
                    show: false
                }
            }],
            yAxis: [{
                type: 'value',
                axisTick: {
                    show: false,
                },
                axisLine: {
                    show: true,
                    lineStyle: {
                        color: "#A6A6A6",
                        width: 1,
                        type: "solid"
                    },
                },
                splitLine: {
                    show: false
                }
            }],
            series: [{
                name: '共享目录',
                type: 'bar',
                data: yData.shareNum,
                barGap: 1,
                barWidth: 20,
                itemStyle: {
                    normal: {
                        color: '#1e87d6'
                    }
                }
            }, {
                name: '开放目录',
                type: 'bar',
                data: yData.openNum,
                barGap: 1,
                barWidth: 20,
                itemStyle: {
                    normal: {
                        color: '#b78217'
                    }
                }
            }, {
                name: '总数',
                type: 'line',
                data: yData.totalNum,
                barGap: 1,
                itemStyle: {
                    normal: {
                        color: '#f1584b'
                    }
                }
            }]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    };

    function deptShare(busTitle, apiList, dirList) {
        var myChart = echarts.init(document.getElementById('top_left'));
        var option = {
            backgroundColor: '#fff',
            title: {
                text: '部门共享情况'
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow'
                }
            },
            legend: {data: ["目录数", "API数"]},
            grid: {
                left: '3%',
                right: '4%',
                bottom: '10%',
                containLabel: true
            },
            xAxis: [{
                type: 'category',
                data: busTitle,
                axisLabel: {
                    show: true,
                    textStyle: {
                        color: "#00c7ff",
                    },
                    interval: 0,
                    rotate: 30
                },
                axisLine: {
                    show: true,
                    lineStyle: {
                        color: "#A6A6A6",
                        width: 1,
                        type: "solid"
                    },
                },
                axisTick: {
                    show: false
                }
            }],
            yAxis: [{
                type: 'value',
                axisTick: {
                    show: false,
                },
                axisLine: {
                    show: true,
                    lineStyle: {
                        color: "#A6A6A6",
                        width: 1,
                        type: "solid"
                    },
                },
                splitLine: {
                    show: false
                }
            }],
            series: [{
                name: '目录数',
                type: 'bar',
                data: dirList,
                barGap: 1,
                barWidth: 20,
                itemStyle: {
                    normal: {
                        color: '#1e87d6'
                    }
                }
            }, {
                name: 'API数',
                type: 'line',
                data: apiList,
                barGap: 1,
                itemStyle: {
                    normal: {
                        color: '#b78217'
                    }
                }
            }]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    };

    function topTen(data) {
        var dom = document.getElementById("top_right");
        var myChart = echarts.init(dom);
        var app = {};
        option = null;
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
            backgroundColor: '#fff',
            tooltip: {
                formatter: '{b} : {c}',
            },
            title: {
                text: 'API调用TOP10'
            },
            grid: {
                left: '10%',
                right: '10%',
                bottom: '5%',
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
                axisLabel: {
                    show: true,
                    textStyle: {
                        color: "#00c7ff",
                    },
                    interval: 0,
                    rotate: 40
                },
                axisLine: {
                    show: true,
                    lineStyle: {
                        color: "#A6A6A6",
                        width: 1,
                        type: "solid"
                    },
                },
                axisTick: {
                    show: false
                }
            }],
            yAxis: [{
                type: 'value',
                axisTick: {
                    show: false,
                },
                axisLine: {
                    show: true,
                    lineStyle: {
                        color: "#A6A6A6",
                        width: 1,
                        type: "solid"
                    },
                },
                splitLine: {
                    show: false
                }
            }],
            series: [
                //背景
                {
                    name: '数据',
                    type: 'bar',
                    data: chartData,
                    z: 3,
                    barWidth: 20,
                    itemStyle: {
                        normal: {
                            color: '#45bd74'
                        }
                    }
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


    function dataShap(busTitle, dirList, setList, apiList) {
        var myChart = echarts.init(document.getElementById('middle'));
        var option = {
            backgroundColor: '#fff',
            title: {
                text: '平台数据情况'
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow'
                }
            },
            legend: {
                data: ["数据目录", "数据集", "API"]
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '8%',
                containLabel: true
            },
            xAxis: [{
                type: 'category',
                data: busTitle,
                axisLabel: {
                    show: true,
                    textStyle: {
                        color: "#00c7ff",
                    },
                    interval: 0,
                },
                axisLine: {
                    show: true,
                    lineStyle: {
                        color: "#A6A6A6",
                        width: 1,
                        type: "solid"
                    },
                },
                axisTick: {
                    show: false
                }
            }],
            yAxis: [{
                type: 'value',
                axisTick: {
                    show: false,
                },
                axisLine: {
                    show: true,
                    lineStyle: {
                        color: "#A6A6A6",
                        width: 1,
                        type: "solid"
                    },
                },
                splitLine: {
                    show: false
                }
            }],
            series: [{
                name: '数据目录',
                type: 'line',
                data: dirList,
                barGap: 1,
                barWidth: 20,
                smooth: true,
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
            }, {
                name: '数据集',
                type: 'line',
                data: setList,
                barGap: 1,
                barWidth: 20,
                smooth: true,
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
            }, {
                name: 'API',
                type: 'line',
                data: apiList,
                barGap: 1,
                barWidth: 20,
                smooth: true,
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
            }]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    }


    function dataTrend(busTitle, dataList, apiCallList) {
        var myChart = echarts.init(document.getElementById('bottom'));
        var option = {
            backgroundColor: '#fff',
            title: {
                text: '数据趋势'
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow'
                }
            },
            legend: {
                data: ["调用次数", "数据交换量"]
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '8%',
                containLabel: true
            },
            xAxis: [{
                type: 'category',
                data: busTitle,
                axisLabel: {
                    show: true,
                    textStyle: {
                        color: "#00c7ff",
                    },
                    interval: 0,
                },
                axisLine: {
                    show: true,
                    lineStyle: {
                        color: "#A6A6A6",
                        width: 1,
                        type: "solid"
                    },
                },
                axisTick: {
                    show: false
                }
            }],
            yAxis: [{
                type: 'value',
                axisTick: {
                    show: false,
                },
                axisLine: {
                    show: true,
                    lineStyle: {
                        color: "#A6A6A6",
                        width: 1,
                        type: "solid"
                    },
                },
                splitLine: {
                    show: false
                }
            }],
            series: [{
                name: '调用次数',
                type: 'line',
                data: apiCallList,
                barGap: 1,
                barWidth: 20,
                itemStyle: {
                    normal: {
                        color: '#044f89'
                    }
                }
            }, {
                name: '数据交换量',
                type: 'line',
                data: dataList,
                barGap: 1,
                barWidth: 20,
                itemStyle: {
                    normal: {
                        color: '#a503f4'
                    }
                }
            }]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    }
