$(function () {

    // 初始化部门选项
    function getParts() {
        parent.getUnitIdFromTopWindow(function(unitId) {
            if (!unitId) {
                console.log('获取单位id失败');
                return;
            }
            ajaxHengyun({
                url: _GATE_URL + "/api/admin/gxqpt/dpm/findDpmByOrgEnable",
                type: 'GET',
                data: {
                    orgId: unitId
                },
                success: function (res) {
                    var data = res.data;
                    if (data) {
                        var options = ['<option value="">全部</option>'];
                        for (var i = 0; i < data.length; i++) {
                            options.push('<option value="' + data[i].id + '">' + data[i].name + '</option>');
                        }
                        $('select[name=deptId]').html(options.join(''));
                    }
                },
                error: function(err) {
                    console.log(err);
                }
            });
        });
    }

    // 获取所有人的卡片
    function getlist() {
        parent.getUnitIdFromTopWindow(function(unitId) {
            if (!unitId) {
                console.log('获取单位id失败');
                return;
            }
            ajaxHengyun({
                url: _GATE_URL + "/api/mt/work/getList",
                type: 'post',
                data: {
                    // 部门id
                    deptId: $('select[name=deptId]').val() || '',
                    // 用户名
                    name: $('input[name=name]').val() || '',
                    // 单位id
                    unitId: unitId
                },
                success: function (res) {
                    var data = res.data;
                    if (data) {
                        $('#content').empty();
                        var content = [];
                        for (var i = 0; i < data.length; i++) {
                            var log = data[i];
                            content.push('<div class="col-sm-3  task-box" data-id="' + log.gxqptEmpId + '" style="background: #09c;">' +
                                    '<img src="'+(log.photo ? log.photo : (_cp+'/static/images/person.png'))+'" class="pull-left userImgSize"/>' +
                                    '<ul class="pull-left">' +
                                    '<li class="nameClass">' + log.name + '</li>' +
                                    '<li>部门：<span>' + (log.maindeptname || '--') + '</span></li>' +
                                    '<li>职务：<span>' + (log.maindutyname || '--') + '</span></li>' +
                                    '<li style="position: relative;left: 12px;">本周日志数量：<span id="logNum"  class="numTxt" >' + log.count + '</span></li>' +
                                    '</ul>' +
                                    '<span id="logTag">查看日志</span>' +
                                    '</div>');
                        }
                        $('#content').html(content.join(''));
                    }
                },
                error: function(err) {
                    console.log(err);
                }
            });
        });
    }

    function bindEvent() {
        // 点击搜索按钮
        $("button.search-button").click(function () {
            getlist();
        });

        // 点击卡片查看详情
        $("#content").on('click', '.task-box', function () {
            var userName = $(this).find(".nameClass").text();
            window.location.href = 'myworklog?userId=' + $(this).data('id')+"&userName="+encodeURI(userName);
            return;
        });
    }

    function init() {
        getParts();
        getlist();
        bindEvent();
    }

    init();
});
