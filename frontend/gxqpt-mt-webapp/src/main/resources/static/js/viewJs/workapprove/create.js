var createForm = {
    overtime: '',
    leave: '',
    business: '',
    outside: '',
    supply: '',
    commonData: ''
};

// 审批人id
var userIds = [];
// 抄送人id
var copyIds = [];
// 设置审批人
function setPeoples(id, name){
    if (id) {
        var value = $("#addPerson_ptspEmpName").val();
        $("#addPerson_ptspEmpName").val(value ? value + ',' + name : name);
        createForm.commonData.check(false);
        userIds.push(id);
        $('.people-container').append('<div class="people-list" data-id="' + id + '">' + name + '</div>\
                                        <div class="people-arrow"></div>');
    }
}

function setCopyPeoples(ids, names){
    if (ids) {
        $('#addPerson_ptcsEmpName').val(names);
        copyIds = ids.split(',');
    } else {
        $('#addPerson_ptcsEmpName').val('');
        copyIds = [];
    }
}

$(function () {
    // 当前审批类型
    var currentCheckType = 'overtime';
    // 附件
    var fileList = [];
    // 省份和市的关联列表
    var provinceCityList = {};

    // 获取标准的时间格式字符串，兼容IE
    function getDate(date) {
        return date.replace(/\-/g, '/');
    }

    function getMaxMinDatetime(time) {
        var date = new Date(getDate(time));
        var max = date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate() + ' 23:59:00';
        var min = date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate() + ' 00:00:00';
        return {
            max: max,
            min: min
        }
    }

    // 根据选择的类型显示相应的表单
    function updateFormData(val) {
        $('#formData .dataForm').hide();
        $('#'+val).show();
    }

    // 获取省市的数据联动表
    function getProvince() {
        ajaxHengyun({
            type: 'GET',
            data: {
                parentId: -1
            },
            url: _GATE_URL + '/api/admin/area/findAreaTree',
            success: function (res) {
                if (res.data) {
                    var proHtml = []
                    for (var i = 0; i < res.data.length; i++) {
                        var item = res.data[i];
                        proHtml.push('<option value="'+item.name+'">'+item.name+'</option>');
                        provinceCityList[item.name] = item.children;
                    }
                    $('#province').html(proHtml.join(''));
                    $('#province').trigger('change');
                }
            },
            error: function(err) {
                console.log(err);
            }
        });
    }
    // 初始化验证方式
    function initValid() {
        var options = {
            showAllError: true,
            ignoreHidden: true,//当为true时对hidden的表单元素将不做验证
            postonce: true,//防止重复提交
            tiptype: function (msg, o, cssctl) {
                //msg：提示信息;
                if (!o.obj.is("form")) {//验证表单元素时o.obj为该表单元素，全部验证通过提交表单时o.obj为该表单对象;
                    var infoObj = o.obj.next('.Validform_info');
                    var objtip = o.obj.next('.Validform_checktip');

                    if (infoObj.size() == 0) {
                        var htmlstrs = '<div class="Validform_info" style="display: none;">'
                            + '<span class="Validform_checktip">' + msg + '</span>'
                            + '<span class="Validform_dec"><s class="Validform_dec1">&#9670;</s><s class="Validform_dec2">&#9670;</s></span></div>';
                        o.obj.after(htmlstrs);
                        infoObj = o.obj.next('.Validform_info');
                        objtip = o.obj.next('.Validform_checktip');
                    }

                    cssctl(objtip, o.type);
                    objtip.text(msg);

                    if ($.trim(infoObj.children('.Validform_checktip').text()) == '') {
                        infoObj.children('.Validform_checktip').html(msg);
                    }

                    if (o.obj.attr('errorid') == undefined) {
                        infoObj.children('.Validform_checktip').html(msg);
                    }

                    //定位
                    if (o.type == 2) {
                        infoObj.fadeOut(100);
                    } else {
                        if (infoObj.is(":visible")) {
                            return;
                        }
                        var left = o.obj.position().left, top = o.obj.position().top;

                        if (o.obj[0].type == 'select-one') {
                            left = o.obj.parent().position().left, top = o.obj.parent().position().top;
                        }

                        infoObj.css({
                            left: left + 60,
                            top: top - 45
                        }).show().animate({
                            top: top - 35
                        }, 100);
                    }

                }
            }
        };
        createForm.overtime = $("#overtime").Validform(options);
        createForm.leave = $("#leave").Validform(options);
        createForm.business = $("#business").Validform(options);
        createForm.outside = $("#outside").Validform(options);
        createForm.supply = $("#supply").Validform(options);
        createForm.commonData = $("#commonData").Validform(options);
    }

    // 获取默认抄送人和审批人
    function getDeaultSenders() {
        ajaxHengyun({
            type: 'GET',
            data: {
                aprType: currentCheckType
            },
            contentType: 'application/json',
            url: _GATE_URL + '/api/mt/apprApply/getDefaultPerson',
            success: function (res) {
                if (res.data) {
                    //审批人列表
                    var apprPersons = res.data.apprPersons;
                    // 审批人用户名
                    var userNames = [];
                    // 审批人html列表
                    var html = [];
                    userIds = [];
                    for (var i = 0; i < apprPersons.length; i++) {
                        userIds.push(apprPersons[i].apprUserId);
                        userNames.push(apprPersons[i].apprUserName);
                        html.push('<div class="people-list" data-id="' + apprPersons[i].apprUserId + '">');
                        html.push(apprPersons[i].apprUserName + '</div>');
                        html.push('<div class="people-arrow"></div>');
                    }
                    var sendPersons = res.data.sendPersons;
                    var copyNames = [];
                    copyIds = [];
                    for (var i = 0; i < sendPersons.length; i++) {
                        copyIds.push(sendPersons[i].apprUserId);
                        copyNames.push(sendPersons[i].apprUserName);
                    }
                    $('#addPerson_ptcsEmpName').val(copyNames.join(','));
                    $("#addPerson_ptspEmpName").val(userNames.join(','));
                    $('.people-container').html(html.join(''));
                }
            },
            error: function(err) {
                console.log(err);
            }
        });
    }

    // 选择审批人或者抄送人
    function selectPeople(isCopy){
        parent.getUnitIdFromTopWindow(function (unitId) {
            var userId = $.cookie("_user_id");
            var ids = '';
            // 抄送人
            if (isCopy) {
                ids = copyIds.join(",");
            } else {
                ids = userIds.join(',');
            }
            var search = '?unitId=' + unitId+'&userId='+userId+'&userIds='+ids
            if (!isCopy) {
                search = search + '&check=true'
            }
            parent.layer.open({
                id: 'setParent',
                type: 2,
                anim:6,
                title: '人员选择',
                maxmin: false, //开启最大化最小化按钮
                area: ['500px', '80%'],
                content: _cp+"/fast/workapprove/selectPeople"+search,
                btn: ['<span class="glyphicon glyphicon-ok"></span> 确定','<span class="glyphicon glyphicon-remove"></span> 取消'],
                yes: function (index, layero) {
                    var html=layero.context;
                    var Id=html.getElementById("setParent");
                    var iframe=$(Id).find("iframe").attr("name");
                    var rowData = parent[iframe].save(index);
                }
            });
        });
    };

    // 时间日期选择器初始化
    function initDatetimePicker() {
        //时间限制，开始时间不能大于结束时间 且不能跨天
        $('#startTime0').off('focus').on('focus',function(){
            var maxDate = CurentTime("endTime0") || '';
            var opt = {lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:00'};
            if (maxDate) {
                var date = getMaxMinDatetime(maxDate);
                opt.minDate=date.min;
                opt.maxDate=maxDate;
            }
            WdatePicker(opt);
        });
        $('#endTime0').off('focus').on('focus',function(){
            var minDate = CurentTime("startTime0") || '';
            var opt = {lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:00'};
            if (minDate) {
                var date = getMaxMinDatetime(minDate);
                opt.maxDate=date.max;
                opt.minDate=minDate;
            }
            WdatePicker(opt);
        });

        //时间限制，开始时间不能大于结束时间
        $('#startTime').off('focus').on('focus',function(){
            WdatePicker({lang:'zh-cn',maxDate:CurentTime("endTime"),dateFmt:'yyyy-MM-dd HH:mm:00'});
        });
        $('#endTime').off('focus').on('focus',function(){
            WdatePicker({lang:'zh-cn',minDate:CurentTime("startTime"),dateFmt:'yyyy-MM-dd HH:mm:00'});
        });

        //时间限制，开始时间不能大于结束时间
        $('#startTime1').off('focus').on('focus',function(){
            WdatePicker({lang:'zh-cn',maxDate:CurentTime("endTime1"),dateFmt:'yyyy-MM-dd HH:mm:00'});
        });
        $('#endTime1').off('focus').on('focus',function(){
            WdatePicker({lang:'zh-cn',minDate:CurentTime("startTime1"),dateFmt:'yyyy-MM-dd HH:mm:00'});
        });

        //外勤时间限制，开始时间不能大于结束时间
        $('#startTime2').off('focus').on('focus',function(){
            var maxDate = CurentTime("endTime2");
            var opt = {lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:00'};
            if (maxDate) {
                var date = getMaxMinDatetime(maxDate);
                opt.minDate=date.min;
                opt.maxDate=maxDate;
            }
            WdatePicker(opt);
        });
        $('#endTime2').off('focus').on('focus',function(){
            var minDate = CurentTime("startTime2");
            var opt = {lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:00'};
            if (minDate) {
                var date = getMaxMinDatetime(minDate);
                opt.maxDate=date.max;
                opt.minDate=minDate;
            }
            WdatePicker(opt);
        });

        // 补签时间限制
        $('#buqianTime').off('focus').on('focus',function(){
            var date = new Date();
            var maxDate = date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate() + ' ' + date.getHours() + '-' + date.getMinutes() + '-' + date.getSeconds();
            WdatePicker({
                lang: 'zh-cn',
                dateFmt: 'yyyy-MM-dd HH:mm:00',
                maxDate: maxDate
            });
        })

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
                    fileHtml.push('<p class="fileItem">' + list[i].submittedFileName);
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

    function saveFormData() {
        var formData = $("#"+currentCheckType).serializeJSON();
        // 审批人
        var apprPersons = [];
        var names = $('#addPerson_ptspEmpName').val().split(',');
        for (var i = 0; i < userIds.length; i++) {
            apprPersons.push({
                apprUserName: names[i],
                apprUserId: userIds[i]
            });
        }
        // 抄送人
        var sendPersons = [];
        var names = $('#addPerson_ptcsEmpName').val().split(',');
        for (var i = 0; i < copyIds.length; i++) {
            sendPersons.push({
                apprUserName: names[i],
                apprUserId: copyIds[i]
            });
        }
        // 审批类型
        var aprType = $('input[name=aprType]:checked').val();
        formData.aprType = aprType;
        formData.apprPersons = apprPersons;
        formData.sendPersons = sendPersons;

        // 文件列表
        formData.images = fileList;
        
        // 请假时长和出差时长，调试用，最后需要删除
        formData.leaveHour = 2;
        formData.businessHour = 2;

        ajaxHengyun({
            type: 'POST',
            data: JSON.stringify(formData),
            contentType: 'application/json',
            url: _GATE_URL + '/api/mt/apprApply/createApprApply',
            success:function (res) {
                window.location.href = 'list'
            },
            error: function(err) {
                console.log(err);
            }
        });
    }

    function bindEvent () {
        // 审批类型切换
        $('#typeCheck .radioInput').on('change', function () {
            currentCheckType = $(this).val();
            updateFormData(currentCheckType);
            getDeaultSenders();
        });

        // 提交按钮
        $('#saveForm').on('click', function () {
            console.log(fileList);
            var formStatus = createForm[currentCheckType].check(false);
            var commonStatus = createForm.commonData.check(false);
            // 验证通过
            if (formStatus && commonStatus) {
                saveFormData();
            }
        });

        // 选择审批人
        $('#addPerson_ptsp').on('click', function () {
            selectPeople(false);
        });

        // 选择抄送人
        $('#addPerson_ptcs').on('click', function () {
            selectPeople(true);
        });

        // 删除审批人
        $('.people-container').on('click', '.people-list', function () {
            var $_this = $(this);
            var id = $_this.data('id');
            $_this.next('.people-arrow').remove();
            $_this.remove();
            var userNames = $("#addPerson_ptspEmpName").val().split(',');
            for (var i = 0; i < userIds.length; i++) {
                if (userIds[i] == id) {
                    userIds.splice(i, 1);
                    userNames.splice(i, 1);
                    break;
                }
            }
            $("#addPerson_ptspEmpName").val(userNames.join(','));
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

        // 省市联动
        $('#province').on('change', function () {
            var value = $(this).val();
            var cities = [];
            for (var i = 0; i < provinceCityList[value].length; i++) {
                var city = provinceCityList[value][i].name;
                cities.push('<option value="'+city+'">'+city+'</option>');
            }
            $('#city').html(cities.join(''));
        });

        // 时间改变时计算时长
        var times = [{
            key: '#startTime',
            value: '#time'
        }, {
            key: '#endTime',
            value: '#time'
        }, {
            key: '#startTime0',
            value: '#time0'
        }, {
            key: '#endTime0',
            value: '#time0'
        }, {
            key: '#startTime1',
            value: '#time1'
        }, {
            key: '#endTime1',
            value: '#time1'
        }, {
            key: '#startTime2',
            value: '#time2'
        }, {
            key: '#endTime2',
            value: '#time2'
        }];
        $('#startTime, #endTime').on('blur', function () {
            var start = $('#startTime').val();
            var end = $('#endTime').val();
            if (start && end) {
                var inter = new Date(getDate(end)).getTime() - new Date(getDate(start)).getTime();
                var hour = (inter / 1000 / 60 / 60).toFixed(2);
                $('#time').text(hour)
            }
        });
        $('#startTime0, #endTime0').on('blur', function () {
            var start = $('#startTime0').val();
            var end = $('#endTime0').val();
            if (start && end) {
                var inter = new Date(getDate(end)).getTime() - new Date(getDate(start)).getTime();
                var hour = (inter / 1000 / 60 / 60).toFixed(2);
                $('#time0').text(hour)
            }
        });
        $('#startTime1, #endTime1').on('blur', function () {
            var start = $('#startTime1').val();
            var end = $('#endTime1').val();
            if (start && end) {
                var inter = new Date(getDate(end)).getTime() - new Date(getDate(start)).getTime();
                var hour = (inter / 1000 / 60 / 60).toFixed(2);
                $('#time1').text(hour)
            }
        });
        $('#startTime2, #endTime2').on('blur', function () {
            var start = $('#startTime2').val();
            var end = $('#endTime2').val();
            if (start && end) {
                var inter = new Date(getDate(end)).getTime() - new Date(getDate(start)).getTime();
                var hour = (inter / 1000 / 60 / 60).toFixed(2);
                $('#time2').text(hour)
            }
        });
    }

    // 页面初始化操作
    function init() {
        bindEvent();
        initDatetimePicker();
        initValid();
        getDeaultSenders();
        loadFile();
        getProvince();
    }

    init();
});
