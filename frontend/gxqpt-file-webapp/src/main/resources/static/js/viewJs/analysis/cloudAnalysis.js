$(function () {
    //个人文件使用图谱echarts图表
    var gaugeEcharts;
    function coludEcharts(data){
        gaugeEcharts = echarts.init(document.getElementById("cloud"));
        gaugeEcharts.on("click", clickFun);
        var option = {
            tooltip : {
                formatter: "{b}"
            },
            grid: {
                top: '10%',
            },
            title: {
                text: "个人文件使用图谱",
                top: 0,
                left: 'left',
                textStyle: {
                    color: '#28A4D7',
                    fontSize: 16
                }
            },
            series: [
                {
                    type: 'tree',
                    data: [data],
                    top: '18%',
                    bottom: '14%',
                    layout: 'radial',
                    symbol: 'emptyCircle',
                    symbolSize: 7,
                    initialTreeDepth: 3,
                    animationDurationUpdate: 750,
                    initialTreeDepth:1,
                }
            ]
        };
        gaugeEcharts.setOption(option);
    }

    // 获取个人文件使用图谱数据
    function cloud(){
        var data = {
            "name": "全部文件",
            "children": [
                {
                    "name": "图片",
                    "dataType": 'IMAGE',
                },
                {
                    "name": "文档",
                    "dataType": 'DOC',
                },
                {
                    "name": "视频",
                    "dataType": 'VIDEO',
                },
                {
                    "name": "音频",
                    "dataType": 'AUDIO',
                },
                {
                    "name": "其它",
                    "dataType": 'OTHER',
                }
            ]
        };
        coludEcharts(data);
    }

    function clickFun(param){
        var dataTypeVal = param.data.dataType;
        if(!dataTypeVal){
            return false;
        };
        if(!param.data.children){
            var parm={
                pageNo:1,
                pageSize: '100000',
                data:{
                    dataType: param.data.dataType,
                    folderId: null,
                    submittedFileName:""
                }
            };
            ajaxHengyun({
                type:"POST",
                url: _GATE_URL+'/api/file/file/page',
                dataType: "json",//必须添加，所有地方都一样
                contentType : 'application/json',   //必须添加，所有地方都一样
                data: JSON.stringify(parm),
                success: function (rows) {
                    if(rows.data){
                        if(rows.data.list.length>0){
                            var childrenArray = [];
                            rows.data.list.forEach(function(val,index){
                                var obj = {
                                    "name":val.submittedFileName,
                                    "mcHereShow":true
                                };
                                childrenArray.push(obj);
                            });
                        }
                        var option = gaugeEcharts.getOption();
                        var optionChildrenVal = option.series[0].data[0].children;
                        optionChildrenVal.forEach(function(val,index){
                            if(val.dataType==dataTypeVal){
                                val.children = childrenArray;
                            }
                        })
                        gaugeEcharts.setOption(option);
                        $(this).tree('toggle', param.target);
                    }
                }
            });
        }
    }

    //格式化对象中的值
    function dealElement(obj,val){
        if ( obj === null || obj === undefined || obj === "" ) return obj;
        for ( var key in obj ){
            if ( obj[key] == null){
                obj[key]=val;
            }
        }
        return obj;
    }

    function init(){
        cloud();//获取个人文件使用图谱
	}
	init();
});