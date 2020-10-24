$(function(){
    Date.prototype.format = function(fmt) { 
        var o = { 
            "M+" : this.getMonth()+1,                 //月份 
            "d+" : this.getDate(),                    //日 
            "h+" : this.getHours(),                   //小时 
            "m+" : this.getMinutes(),                 //分 
            "s+" : this.getSeconds(),                 //秒 
            "q+" : Math.floor((this.getMonth()+3)/3), //季度 
            "S"  : this.getMilliseconds()             //毫秒 
        }; 
        if(/(y+)/.test(fmt)) {
            fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
        }
        for(var k in o) {
            if(new RegExp("("+ k +")").test(fmt)){
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
            }
        }
        return fmt;
    }

    //获取应用列表
    function getSystem() {
        var data = {};
        $("#list").jqGrid({
            mtype: 'POST',
            postData:{ pageNo:1, pageSize:20, data: data},
            url: _GATE_URL + '/api/developer/fastapplication/page',
            datatype: "json",
            contentType : 'application/json',
            serializeGridData:function(postData){
                return JSON.stringify(postData);
            },
            colNames: ['应用名称', '标识', '应用地址', '业务类型', '状态', '创建时间', '操作'],
            colModel: [{
                name: 'name',
                index: 'name',
            }, {
                name: 'appId',
                index: 'appId'
            }, {
                name: 'indexUrl',
                index: 'indexUrl',
                formatter: function (cellValue, options, rowObject) {
                    return '<span class="appUrl">'+_GATE_URL + rowObject.indexUrl+'</span>'
                }
            }, {
                name: 'type',
                index: 'type',
                formatter: function (cellValue, options, rowObject) {
                    switch (rowObject.bizConfigId) {
                        case 222:
                        case '222':
                            return '考勤管理';
                        case 333:
                        case '333':
                            return '收发文管理';
                        case 444:
                        case '444':
                            return '会议管理';
                    }
                }
            }, {
                name: 'status',
                index: 'status',
                formatter: function (cellValue, options, rowObject) {
                    return rowObject.status ? '启用' : '停用';
                }
            }, {
                name: 'createTime',
                index: 'createTime',
                formatter: function (cellValue, options, rowObject) {
                    // return new Date(rowObject.createTime).format('yyyy-MM-dd');
                    return rowObject.createTime;
                }
            }, {
                name: 'handle',
                index: 'handle',
                width: '220px',
                formatter: function (cellValue, options, rowObject) {
                    var edit = '<a href="' + _CP + '/fastApp/create?id=' + rowObject.id + '" class="handle">修改</a>';
                    var active = '<span data-ctrl="startUse" data-id="' + rowObject.id + '" class="handle">启用</span>';
                    var stop = '<span data-ctrl="stopUse" data-id="' + rowObject.id + '" class="handle">停用</span>';
                    var detail = '<a href="' + _CP + '/fastApp/detail?id=' + rowObject.id + '" class="handle">详情</a>';

                    var time = new Date(rowObject.updateTime).getTime();
                    var currentTime = new Date().getTime();
                    var text = '应用启动中...';
                    if (currentTime > (time + 5 * 60 * 1000)) {
                        text = '打开应用';
                    }

                    var open = '<span data-time="'+rowObject.createTime+'" data-url="' + rowObject.indexUrl + '" class="openapp handle">'+text+'</span>';


                    var download = "http://127.0.0.1:10086/api/file/file/download?url=http://127.0.0.1:10086/file/45kj6352/2018/05/8c4ef924-1863-4c46-bbb1-9c1f965f58f6.rar&filename=fast-webapp.rar"
                    var downloadBtn = '<a href="' + download + '" class="handle">下载</a>';

                    if (rowObject.status) {
                        // 启用状态
                        return stop + detail + open + downloadBtn;
                    } else {
                        // 停用状态
                        return edit + active + detail + downloadBtn;
                    }
                }
            }],
            jsonReader : {
                root: "data.list",
                page: "data.pageNum",
                total: "data.pages",
                records: "data.total"
            },
            pager: '#pager',
            height: 'auto',
            onPaging: function (pgButton) {
                var pageNo=$(".ui-pg-input").val();
                pageNo=parseInt(pageNo);
                var total=$("#sp_1_pager_toppager").text();
                total=parseInt(total);
                if(pgButton=="next"){
                    if(pageNo>=total){
                        return false;
                    }else{
                        pageNo+=1;
                    }
                }else if(pgButton=="prev"){
                    if(pageNo>1){
                        pageNo-=1;
                    }else{
                        return false;
                    }
                }else if(pgButton=="last"){
                    pageNo=total;
                }else if(pgButton=="first"){
                    pageNo=1;
                }
                var pageSize=$(".ui-pg-selbox").val();
                if(pageNo!=0){
                    updateList(pageNo, pageSize);
                    return false;
                }
            }
        });
    }

    function getCase () {
        ajaxHengyun({
            type:'GET',
            data: {
                parentId: 1
            },
            url: _GATE_URL + '/api/developer/fastmenu/getBizConfig',
            success:function (res) {
                var optionHtml = [];
                if (res && res.data) {
                    optionHtml.push('<option value="">全部</option>');
                    for (var i = 0; i < res.data.length; i++) {
                        optionHtml.push('<option value="' + res.data[i].id + '">' + res.data[i].name + '</option>');
                        $('#searchType').html(optionHtml.join(''));
                    }
                }
            }
        })
    }

    function updateList (pageNo, pageSize) {
        var postData = {
            data: {
                // 应用名称
                name: $('.search-name').val(),
                // 创建人
                createUser: $('.create-user').val(),
                // 业务类型
                type: $('#searchType').val(),
                // 申请时间-开始
                startTime: $('.start-time').val(),
                // 申请时间-结束
                endTime: $('.end-time').val()
            },
            pageNo: pageNo || $(".ui-pg-input").val() || 0,
            pageSize: pageSize || $(".ui-pg-selbox").val() || 20
        }
        $('#list').setGridParam({
            postData:postData
        },true).trigger('reloadGrid');
    }

    function startUseOrStopUse (id, ctrl) {
        ajaxHengyun({
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                id: id,
                status: (ctrl == 'startUse')
            }),
            url: _GATE_URL + '/api/developer/fastapplication/startUse',
            success: function (res) {
                layer.msg('操作成功', {time:1000});
                updateList();
            }
        })
    }

    function bindEvent () {
        // 点击进入创建应用页面
        $('#createApp').on('click', function () {
            window.location.href = 'create';
        });
        
        $('#searchBtn').on('click', function () {
            updateList();
        });

        $('#list').on('click', '.handle', function () {
            var id = $(this).data('id');
            var ctrl = $(this).data('ctrl');
            // 停用或者启用
            if (ctrl) {
                startUseOrStopUse(id, ctrl);
            }
        });

        $('#list').on('click', '.openapp', function () {
            var url = $(this).data('url');
            var time = new Date($(this).data('time')).getTime();
            var currentTime = new Date().getTime();
            if (currentTime > (time + 5 * 60 * 1000)) {
                window.open(url);
            }
        });

        setInterval(function () {
            var openapp = $('.openapp');
            var currentTime = new Date().getTime();
            for (var i = 0; i < openapp.length; i++) {
                var time = new Date(openapp.eq(i).data('time')).getTime();
                if (currentTime > (time + 5 * 60 * 1000)) {
                    openapp.eq(i).text('打开应用');
                }
            }
        }, 60 * 1000);

        var clipboard = new ClipboardJS('.appUrl', {
            text: function(e) {
                layer.msg('地址已复制', {time: 1000});
                return $(e).text();
            }
        });
    }

    function init () {
        getSystem();
        getCase();
        bindEvent();
    }

    init();
});
