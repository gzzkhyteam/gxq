$(function () {
    var fileList = [];
    // var position = {};

    // 获取单位的考勤规则
    function getInfo(){
        ajaxHengyun({
            url:  _GATE_URL+"/api/mt/punchClock/getMyUnityPunchClockRule",
            type: "get",
            data: {},
            success: function (result) {
                var data = result.data;
                if (data) {
                    $("#inTime").val(data.inTime);
                    $("#outTime").val(data.outTime);
                    $("#startTime").val(data.startTime);
                    $("#endTime").val(data.endTime);
                    $("#location").val(data.location);
                    $('#lat').val(data.lat);
                    $('#lng').val(data.lng);
                    $('#signId').val(data.id);
                    $("#distanceRange option").each(function () {
                        if ($(this).val() == data.distanceRange) {
                            $(this).attr("selected", "selected")
                        }
                    });
                    getMap();
                    fileList = data.fileList || [];
                    var fileHtml = [];
                    $('.fileItem').remove();
                    for (var i = 0; i < fileList.length; i++) {
                        fileHtml.push('<p class="fileItem"><a href="/api/file/file/download?url=' + fileList[i].fileUrl + '&filename=' + fileList[i].fileName + '" target="_blank">' + fileList[i].fileName + '</a>');
                        fileHtml.push('<i class="fa fa-trash-o file-delete" title="删除" data-id="' + fileList[i].fileId + '"></i></p>');
                    }
                    $('#wrapper').append(fileHtml.join(''));
                }
                // } else {
                    // 自动定位，偏差太大，所以取消
                    // var count = 0;
                    // var timeInterval = setInterval(function () {
                    //     debugger
                    //     if (count > 10) {
                    //         clearInterval(timeInterval);
                    //         return;
                    //     }
                    //     if (position.lat) {
                    //         console.log('---------------------------------');
                    //         console.log(position);
                    //         console.log('---------------------------------');
                    //         // BMap.Convertor.translate(position,0,function (p) {
                    //         //     console.log('---------------------------------');
                    //         //     console.log(p);
                    //         //     console.log('---------------------------------');
                    //         //     clearInterval(timeInterval);
                    //         //     $('#lat').val(p.lat);
                    //         //     $('#lng').val(p.lng);
                    //         //     getMap();
                    //         // });
                    //         $('#lat').val(position.lat);
                    //         $('#lng').val(position.lng);
                    //         getMap();
                    //         clearInterval(timeInterval);
                    //     }
                    //     count++;
                    // }, 400);
                // }
            }
        });
    };

    //初始化地图
    function getMap(){
        var latitude = "";//纬度
        var longtude = "";//经度
        var address = "";
        var tempLatitude = $('#lat').val();
        var tempLongtude = $('#lng').val();
        if (tempLatitude == "" || tempLatitude == null) {
            tempLatitude = 26.624585;
        }
        if (tempLongtude == "" || tempLongtude == null) {
            tempLongtude = 106.653648;
        }
        var map = new BMap.Map("dituContent");    // 创建Map实例
        map.centerAndZoom(new BMap.Point(tempLongtude, tempLatitude), 14);  // 初始化地图,设置中心点坐标和地图级别
        map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
        map.setCurrentCity("贵阳");          // 设置地图显示的城市 此项是必须设置的

        marker = new BMap.Marker(new BMap.Point(tempLongtude, tempLatitude));  // 创建标注
        map.addOverlay(marker);

        map.enableScrollWheelZoom();    //启用滚轮放大缩小，默认禁用
        map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用

        var i = 0
        //点击获取坐标

        map.addEventListener("click", function (e) {
            var marker;
            map.clearOverlays();
            if (i != -1) {
                //存储经纬度
                lat = e.point.lat;//纬度
                lng = e.point.lng;//经度

                //在地图上面描点
                marker = new BMap.Marker(new BMap.Point(lng, lat));  // 创建标注
                map.addOverlay(marker);
                //marker.enableDragging();    //可拖拽

                var gc = new BMap.Geocoder();
                //获取地址的数据地址
                var pt = e.point;
                gc.getLocation(pt, function (rs) {
                    var addComp = rs.addressComponents;
                    address = addComp.province + addComp.city + addComp.district + addComp.street + addComp.streetNumber;
                    $("#location").val(address).trigger('blur');

                    //画图
                    var label = new BMap.Label(address, {offset: new BMap.Size(20, -10)});
                    marker.setLabel(label);
                });
                i++;
            }
            latitude = e.point.lat;
            longtude = e.point.lng;
            $('#lat').val(e.point.lat);
            $('#lng').val(e.point.lng);
        });
    };

    // 初始化附件上传
    function loadFile() {
        fileUpload = new FileUpload({
            filePicker: "filePicker",
            folderId: "-1",
            dataType: "",
            token: $.cookie('_token'),
            multiple: true,
            successUpload: function (json) {
                var list = json.data.list;
                var fileHtml = [];
                for (var i = 0; i < list.length; i++) {
                    var fileInfo = {
                        fileId: list[i].id,
                        fileName: list[i].submittedFileName,
                        fileSize: list[i].size,
                        fileType: list[i].mime,
                        fileUrl: list[i].url
                    };
                    fileHtml.push('<p class="fileItem"><a href="/api/file/file/download?url=' + list[i].url + '&filename=' + list[i].submittedFileName + '" target="_blank">' + list[i].submittedFileName + '</a>');
                    fileHtml.push('<i class="fa fa-trash-o file-delete" title="删除" data-id="' + list[i].id + '"></i></p>');
                    fileList.push(fileInfo);
                }
                $('#wrapper').append(fileHtml.join(''));
            }
        });
        fileUpload.on('beforeFileQueued', function (file) {
            if (fileList.length == 3) {
                layer.alert('最多只能上传三个文件');
                return false;
            }
            return true;
        });
    };

    // 获取地理位置
    // function getLocation() {
    //     var geolocation = new BMap.Geolocation();
    //     //弹出地理授权
    //     geolocation.getCurrentPosition(function(r) {
    //         if (this.getStatus() == BMAP_STATUS_SUCCESS) {
    //             position = r.point;
    //         } else {
    //             console.log("定位失败");
    //         }
    //     },
    //     //获取失败时候的回调
    //     function(r) {
    //         console.log('定位失败');
    //         return {
    //             //设置高精度
    //             enableHighAccuracy: true
    //         };
    //     });
    //     // debugger
    //     // if (navigator && navigator.geolocation) {
    //     //     debugger
    //     //     navigator.geolocation.getCurrentPosition(function (p) {
    //     //         debugger;
    //     //         position = p;
    //     //     });
    //     // }
    // }
    // getLocation();

    function getStarTime(id) {
        return $('#'+id).val();
    }

    $('#inTime').off('focus').on('focus', function () {
        WdatePicker({
            lang: 'zh-cn',
            skin: 'whyGreen',
            dateFmt: 'HH:mm:ss',
            isShowToday: false,
            maxDate: getStarTime('outTime')
        });
    });
    $('#outTime').off('focus').on('focus', function () {
        WdatePicker({
            lang: 'zh-cn',
            skin: 'whyGreen',
            dateFmt: 'HH:mm:ss',
            isShowToday: false,
            minDate: getStarTime('inTime')
        });
    });
    $("body").on("click",".btn-submit",function(){
        $('.saveData').click();
    });
    $('.saveData').valid({
        form: '#dataForm',
        showAllError: true,
        checkpassed: function () {
            save();
        }
    });
    // 文件删除
    $('#wrapper').on('click', '.file-delete', function () {
        var fileId = $(this).data('id');
        for (var i = 0; i < fileList.length; i++) {
            if (fileList[i].fileId == fileId) {
                fileList.splice(i, 1);
            }
        }
        $(this).parent('.fileItem').remove();
    });
    // 保存考勤规则
    function save() {
        parent.layer.confirm("您确定保存吗？", {btn: ['提交', '取消'], shade: false}, function (index) {
            parent.layer.load(2, {shade: [0.4, '#000']});
            var gxqptDutiesDTO = $("#dataForm").serializeJSON();
            gxqptDutiesDTO.fileList = fileList;
            ajaxHengyun({
                type: "POST",
                dataType: 'json',
                contentType: 'application/json',
                url:  _GATE_URL+"/api/mt/punchClock/crateePunchClockRule",
                data: JSON.stringify(gxqptDutiesDTO),
                success: function(rows){
                    if (rows.data){
                        getInfo();
                        parent.layer.msg("保存成功！",{icon:6,time:1000});
                        parent.layer.closeAll();
                    }else{
                        parent.layer.msg(rows.errmsg+"，请重试！",{time:3000});
                    }
                },
                error: function () {
                    parent.layer.msg("请重试！",{time:1000});
                    parent.layer.closeAll();
                }
            });
        });
    };

    getInfo();
    loadFile();
    getMap();
});
