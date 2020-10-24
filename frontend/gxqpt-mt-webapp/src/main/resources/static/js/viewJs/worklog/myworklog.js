$(function () {
    // 获取id，如果不为null,意味着来自查看别人的而不是自己的
    var userIdInfo = getQueryString('userId');
    var userNameInfo = getQueryString('userName');
    // 获取url里面的指定参数
    function getQueryString(query) {
        var reg = new RegExp("(^|&)"+ query +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return  decodeURIComponent(r[2]); return null;
    }

    function getWorklog() {
        //获取数据
        var userId="";
        if(userIdInfo){
            userId = userIdInfo;
        }else{
            userId=$.cookie("_user_id");
            $("#fillLog").removeClass("hidden");
        }
        var startTime = $('input[name="startTime"]').val();
        var endTime = $('input[name="endTime"]').val();
        var data = {
            userId: userId,
            // 日志日期-开始
            startTime: startTime ? startTime + ' 00:00:00': '',
            // 日志日期-结束
            endTime: endTime ? endTime + ' 23:59:59' : '',
            // 清除缓存
            timeStamp: Date.now()
        };
        parent.getUnitIdFromTopWindow(function (unitId) {
            if (!unitId) {
                console.log('something wrong!');
                return;
            }
            data.unitId = unitId;
            ajaxHengyun({
                type:"GET",
                dataType: 'json',
                url:  _GATE_URL+"/api/mt/work/findByUserId",
                data: data,
                success:function(rows){
                    if (rows.data) {
                        var itemInfo=rows.data;
                        var userNameText = "";
                        if(userNameInfo){
                            userNameText = userNameInfo+"的日志";
                        }else{
                            userNameText = "我的日志";
                        };
                        $("#worklogUserName").html(userNameText);
                        var html="";
                        if(itemInfo.length==0){
                            html = '<p class="text-center noData">无日志信息</p>';
                        } else {
                            for(var i in itemInfo){
                                var WorkLogDetailDTO = itemInfo[i].workLogDetailDTOS;
                                html+='<fieldset>';
                                html+='<h4 class="h4-title">'+itemInfo[i].createDate.substring(0,10);
                                if (userIdInfo) {
                                    html+='<span class="pull-right reply-box"  data-logid="'+itemInfo[i].id+'">回复</span>';
                                }
                                html+='</h4>';
                                if (!userIdInfo) {
                                    html+='<ul>';
                                } else {
                                    html+='<ul class="reply-box" data-logid="'+itemInfo[i].id+'">';
                                }
                                for(var j in WorkLogDetailDTO){
                                    if(!userIdInfo){
                                        html+='<li><a href="'+_cp+'/module/editWorklog?id='+WorkLogDetailDTO[j].id+'&logId='+itemInfo[i].id+'"> '+(parseInt(j)+1)+'.'+WorkLogDetailDTO[j].description +'('+WorkLogDetailDTO[j].createTime.substring(11)+')'+' </a></li>';
                                    }else{
                                        html+='<li class="detailsLog">'+(parseInt(j)+1)+'.'+WorkLogDetailDTO[j].description+'</li>';
                                    }
                                };
                                html+='</ul>';
                                html+='</fieldset>';
                            };
                        }
                        $("#worklogList").html(html);
                    };
                }
            });
        });
    }

    // 获取默认开始时间
    function getDefaultStartDate() {
        var dateTime = new Date(Date.now() - (30 * 24 * 60 * 60 * 1000));
        var date = [];
        var year = dateTime.getFullYear();
        var month = dateTime.getMonth() + 1;
        month = month < 10 ? '0' + month : month;
        var day = dateTime.getDate();
        date.push(year);
        date.push(month);
        date.push(day);
        return date.join('-');
    }

    // 获取默认结束时间
    function getDefaultEndDate() {
        var dateTime = new Date();
        var date = [];
        var year = dateTime.getFullYear();
        var month = dateTime.getMonth() + 1;
        month = month < 10 ? '0' + month : month;
        var day = dateTime.getDate();
        date.push(year);
        date.push(month);
        date.push(day);
        return date.join('-');
    }

    // 时间日期选择器初始化
    function initDatetimePicker() {
        //时间限制，开始时间不能大于结束时间
        $('#startTime').off('focus').on('focus',function(){
            WdatePicker({lang:'zh-cn',maxDate:CurentTime("endTime"),onpicked:onBlur("startTime"),dateFmt:'yyyy-MM-dd'});
        }).val(getDefaultStartDate());
        $('#endTime').off('focus').on('focus',function(){
            WdatePicker({lang:'zh-cn',minDate:CurentTime("startTime"),onpicked:onBlur("endTime"),dateFmt:'yyyy-MM-dd'});
        }).val(getDefaultEndDate());
        function CurentTime(id) {
            if(id){
                var time = $("#"+id).val();
                return time;
            }
        };
        function onBlur(id){
            if(id){
              $("#"+id).blur();
            };
        };
    }

    // 事件绑定
    function bindEvent() {
        // 日志详情
        $("body").on("click", ".reply-box",function(){
            var logid=$(this).data("logid");
            window.location.href="viewWorklog?logId="+logid;
        });

        // 点击查询按钮
        $('#searchBtn').on('click', getWorklog);

        $('.btn-back').on('click', function () {
            if (userIdInfo) {
                window.location.href = 'leaderview';
            }
        });
    }

    function init() {
        bindEvent();
        initDatetimePicker();
        getWorklog();
        if (userIdInfo) {
            $('#btn-back').removeClass('hidden');

        }
    }

    init();
});
