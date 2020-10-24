$(function(){
    //初始化地图
    function getMap(tempLongtude,tempLatitude){
        var map = new BMap.Map("map");    // 创建Map实例
        map.centerAndZoom(new BMap.Point(tempLongtude, tempLatitude), 14);  // 初始化地图,设置中心点坐标和地图级别
        map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
        map.setCurrentCity("贵阳");          // 设置地图显示的城市 此项是必须设置的

        marker = new BMap.Marker(new BMap.Point(tempLongtude,tempLatitude));  // 创建标注
        map.addOverlay(marker);

        map.enableScrollWheelZoom();    //启用滚轮放大缩小，默认禁用
        map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用
    };
    /* 下载文件 */
    function downLoadFolder(url,filename){
        var urlDownload="${_gate_url}/api/file/file/download?url="+url+"&filename="+filename;
        window.open(urlDownload);
    }
    // 获取详情信息
    function getInfo() {
        ajaxHengyun({
            type:"POST",
            dataType: 'json',
            url:  _GATE_URL+"/api/mt/punchClock/getBaseInfoPunchClockHis",
            data:{id:_id},
            success:function(rows){
                getMap(rows.data.lng,rows.data.lat);
                var adceTypeText = "",clockTypeText = "";
                if(rows.data.adceType==1){
                    adceTypeText = "内勤";
                }else if(rows.data.adceType==2){
                    adceTypeText = "外勤";
                };
                if(rows.data.clockType==1){
                    clockTypeText = "签到";
                }else if(rows.data.clockType==2){
                    clockTypeText = "签退";
                };
                $("#codeType").text(adceTypeText+clockTypeText);
                $("#clockTime").text(rows.data.clockTime);
                $("#location").text(rows.data.location);
                $("#outterReason").text(rows.data.outterReason||"无");
                var files = rows.data.imageList;
                if(files.length>0){
                    var filesHtml="";
                    for(var i in files){
                        filesHtml+='<a class="fileDownload" href="javascript:" onclick="downLoadFolder(\''+files[i].fileUrl+'\',\''+files[i].fileName+'\')">'+files[i].oldName+'<i class="fa fa-download"></i></a><br/>'
                    }
                    $(".file-container").html(filesHtml);
                }else{
                    $(".file-container").text("无");
                }
            }
        });
    };
    getInfo();
});