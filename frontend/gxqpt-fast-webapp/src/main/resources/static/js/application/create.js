(function () {
	$(document).ready(function() {
		var STEP = {
			CASE_SELECTED: 'CASE_SELECTED',
			NEXT_STEP: 'NEXT_STEP'
		};

		var APP_CODE = {
			// 平台
			TYPT: 'zcpt',
			// 应用
			GXYY: 'zcyy',
			// 服务
			GXFW: 'zcfw',
			// 模块
			GXMK: 'zcfwmk'
		};

		// 所有应用id的关联关系结构
		var relation = {};

		// 所有初始化的ajax请求结束即为2
		var initCount = 0;

		// 编辑时的appid
		var editAppId = '';

		// 默认选中的应用的appid
		var DEFAULT_SELECT_APPID = [
			'25kj6355',
			'35kj6351',
			'45kj6314'
		];

		function getQuery (name) {
			var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
			var r = window.location.search.substr(1).match(reg);
			if(r!=null)return  unescape(r[2]); return null;  
		}

		function gotoStep (step) {
			switch (step) {
				case STEP.CASE_SELECTED:
					$('.' + STEP.CASE_SELECTED).show();
					$('.' + STEP.NEXT_STEP).hide();
					$('#save').hide();
					$('#next').show();
					$('#preStep').hide();
					break;
				case STEP.NEXT_STEP:
					$('.' + STEP.CASE_SELECTED).hide();
					$('.' + STEP.NEXT_STEP).show();
					$('#next').hide();
					$('#save').show();
					$('#preStep').show();
					break;
				default:
					break;
			}
		}


	    function getCase () {
	    	ajaxHengyun({
				type:'GET',
				data: {
					parentId: 1
				},
				url: _GATE_URL + '/api/developer/fastmenu/getBizConfig',
				success:function (res) {
	                initCount++;
	                var radioHtml = [];
	                if (res && res.data) {
	                	for (var i = 0; i < res.data.length; i++) {
	                		radioHtml.push('<div class="radio form-group">\
												<label>\
													<input type="radio" name="case" value="' + res.data[i].id + '">' + res.data[i].name + '\
												</label>\
											</div>');
		                	$('#case').html(radioHtml.join(''));
		                }
	                }
	            }
			});
	    }

	    function pushCheckbox (name, list, id) {
	    	var listHtml = [];
	    	var disabled = (id=="#service" || id=="#module")?true:false;
	    	listHtml.push('<div>' + name + '</div>');
	    	for (var i = 0; i < list.length; i++) {
	    		var input = '';
	    		if (disabled) {
	    			input = '<input type="checkbox" disabled value="' + list[i].appId + '">'
	    		} else {
	    			input = '<input type="checkbox" value="' + list[i].appId + '">'
	    		}
	    		listHtml.push('<div class="form-group">\
					<div class="checkbox">\
						<label class="checkbox-inline"> ' + input + list[i].name + '\
						</label>\
					</div>\
				</div>');
	    	}
	    	
			$(id).append(listHtml.join(''));
	    }

	    function getCheckedValues (id) {
	    	var checkedList = $('#' + id + ' input:checked');
	    	var vals = [];
	    	for (var i = 0; i < checkedList.length; i++) {
	    		vals.push(checkedList.eq(i).val());
	    	}
	    	return vals;
	    }

	    function getAllDatas () {
	    	// 平台
    		var defCheckedIds = getCheckedValues('platform');
    		// 应用
    		var anmCheckedIds = getCheckedValues('application');
    		// 服务
    		var serviceCheckedIds = getCheckedValues('service');
    		// 模块
    		var moduleCheckedIds = getCheckedValues('module');
    		// 所有选择的平台和应用的appid
    		var selectMenuAppId = defCheckedIds.concat(anmCheckedIds);
    		// 所有选择的服务和模块的appid
    		var selectAppId = serviceCheckedIds.concat(moduleCheckedIds);

	    	var datas = {
	    		// 应用名称
	    		name: $('#appName').val(),
	    		// 应用标识
	    		appFlag: '',
	    		// 热门程度
	    		hotsCount: 0,
	    		// logourl
	    		logoUrl: $("#logoUrl").val(),
	    		// 描述
	    		desc: $('#desc').val(),
	    		// 业务场景
	    		bizConfigId: parseInt($('#case input:checked').val()),
	    		// 平台和应用
	    		selectMenuAppId: selectMenuAppId,
	    		// 服务和模块
	    		selectAppId: selectAppId,

	    	};
	    	return datas;
	    }

	    function findAllApp () {
	    	ajaxHengyun({
				type: 'POST',
				url: _GATE_URL + '/api/developer/fastapplication/findAllApp',
				success: function (res) {
					initCount++;
					if (res && res.data) {
						var application = res.data.application;
	                    for (var i = 0; i < application.length; i++) {
	                    	var code = application[i].code;
	                    	var list = application[i].application;
	                    	var name = application[i].name;
	                    	var id = '';
	                    	switch (code) {
	                    		// 平台
	                    		case APP_CODE.TYPT:
	                    			id = '#platform';
	                    			break;
	                    		// 应用
	                    		case APP_CODE.GXYY:
	                    			id = '#application';
	                    			break;
	                    		// 服务
	                    		case APP_CODE.GXFW:
	                    			id = '#service';
	                    			break;
	                    		// 模块
	                    		case APP_CODE.GXMK:
	                    			id = '#module';
	                    			break;
	                    	}
	                    	if (id) {
	                    		pushCheckbox(name, list, id);
	                    	}
	                    }
	                    for (var i = 0; i < DEFAULT_SELECT_APPID.length; i++) {
	                    	$('input[value=' + DEFAULT_SELECT_APPID[i] + ']').trigger('click');
	                    }
					}
                }
			});
	    }

	    function updateCheckbox () {
	    	$('#service input:checkbox').prop('checked', false);
			$('#module input:checkbox').prop('checked', false);
	    	for (prop in relation) {
	    		if (relation[prop].checked) {
	    			var checkedList = relation[prop].ids;
	    			for (var i = 0; i < checkedList.length; i++) {
			    		$('input[value=' + checkedList[i].bizId + ']').prop('checked', true);
			    	}
	    		}
	    	}
	    }

	    function findAppRelation (appId) {
	    	ajaxHengyun({
				type: 'POST',
				url: _GATE_URL + '/api/developer/fastapplication/findAppRelation',
				data: {
					appId: appId
				},
				success: function (res) {
	                // 选出某个appid对应的所有模块和服务
					var application = res.data.application;
					for (var i = 0; i < application.length; i++) {
						if(application[i].code == APP_CODE.GXFW || application[i].code ==  APP_CODE.GXMK) {
							relation[appId] = relation[appId] || {};
							relation[appId].checked = true;
							relation[appId].ids = relation[appId].ids || [];
							relation[appId].ids = relation[appId].ids.concat(application[i].application);
						}
					}
					updateCheckbox();
                }
			})
	    }

	    //保存新应用
		function saveApplication (data) {
			ajaxHengyun({
				type: 'POST',
				contentType: 'application/json',
				data: JSON.stringify(data),
				url: _GATE_URL + '/api/developer/fastapplication/save',
				success:function (res) {
					if (res && res.errcode != 0) {
		                layer.alert(res.errmsg);
		                return;
					}
					window.location.href = 'appList';
	            }
			})
	    }

	    // 更新应用
	    function updateApplication (data) {
	    	data.appId = editAppId;
	    	data.id = getQuery('id');
	    	ajaxHengyun({
				type: 'POST',
				contentType: 'application/json',
				data: JSON.stringify(data),
				url: _GATE_URL + '/api/developer/fastapplication/update',
				success:function (res) {
					if (res && res.errmsg == 'ok') {
						window.location.href = 'appList';
					} else {
						layer.alert(res.errmsg);
					}
	            }
			})
	    }

	    function bindEvent () {
	    	// 业务场景选择
	    	$('#case').on('change', 'input:radio', function () {
	    		gotoStep(STEP.CASE_SELECTED);
	    	});

	    	// 应用选择
	    	$('#application').on('click', 'input:checkbox', function () {
	    		var vals = getCheckedValues('application');
	    		var appId = $(this).val();
	    		var checked = $(this).prop('checked');
	    		// 已经拉取过数据
	    		if (relation[appId]) {
	    			if (checked) {
	    				// 选中
	    				relation[appId].checked = true;
	    			} else {
	    				// 不选中
	    				relation[appId].checked = false;
	    			}
	    			updateCheckbox();
	    		} else {
	    			// 未拉取过数据
	    			findAppRelation(appId);
	    		}
	    	});

	    	// 服务选择
	    	$('#service').on('click', 'input:checkbox', function () {
	    		var vals = getCheckedValues('service');
	    		console.log(vals);
	    	});

	    	// 模块选择
	    	$('#module').on('click', 'input:checkbox', function () {
	    		var vals = getCheckedValues('module');
	    		console.log(vals);
	    	});

	    	// 下一步
    		$('#next').valid({
	            form: '#appForm',
	            showAllError: true,
	            checkpassed: function () {
	                gotoStep(STEP.NEXT_STEP);
	            }
		        });

	    	// 上一步
	    	$('#preStep').on('click', function () {
	    		gotoStep(STEP.CASE_SELECTED);
	    	});

	    	// 新增保存
	    	$('#save').on('click', function () {
	    		var datas = getAllDatas();
	    		// 如果能够获得id的值，那就是来自修改
		    	var id = getQuery('id');
		    	if (id) {
		    		updateApplication(datas);
		    		return;
		    	}
	    		saveApplication(datas);
	    	});

	    	// 取消新增回到首页
	    	$('#cancel').on('click', function () {
	    		window.top.location.reload();
	    	});
	    }

	    function getDetailById (id) {
	    	ajaxHengyun({
	    		type: 'GET',
	    		data: {
	    			id: id
	    		},
	    		url: _GATE_URL + '/api/developer/fastapplication/getById',
	    		success: function (res) {
	    			var lazyload = setInterval(function () {
	    				if (initCount == 2) {
	    					clearInterval(lazyload);
	    					var data = res.data;
	    					$('#appName').val(data.name);
	    					if (data.logoUrl) {
	    						$('#logoUrl').val(data.logoUrl);
	    						$('#dndArea').css("background-image", "url(" + data.logoUrl + ")");
	    						$('#logo-line').addClass('logo-line');
	    					}
	    					$('#desc').val(data.desc);
	    					$('input[value=' + data.bizConfigId + ']').prop('checked', true);
	    					for (var i = 0; i < data.application.length; i++) {
	    						var application = data.application[i];
	    						var code = application.code;
	    						// 如果不是服务或者模块，就触发点击事件
	    						if (code != APP_CODE.GXFW && code != APP_CODE.GXMK) {
	    							for (var j = 0; j < application.application.length; j++) {
		    							var fastAppId = application.application[j].fastAppId;
		    							$('input[value=' + fastAppId + ']').trigger('click');
		    						}
	    						}
	    					}
	    					editAppId = data.appId;
	    				}
	    			}, 500);
	    		}
	    	});
	    }

	    /* 上传 logo */
	    function initUpload () {
	    	var token = $.cookie("_token");
		    var folderId="-1";
		    var dataType="IMAGE";
	        fileUpload = new FileUpload({
	            "filePicker" : "filePicker",
	            "dndArea" : "dndArea",
	            "uploader" : "uploader",
	            "jxButton" : "jxButton",
	            "folderId": folderId,
	            "dataType": dataType,
	            "token": token,
	            "_isAdmin": true
	        });
	    }

	    function init () {
	    	initUpload();
	    	findAllApp();
	    	getCase();
	    	bindEvent();
	    	// 如果能够获得id的值，那就是来自修改
	    	var id = getQuery('id');
	    	if (id) {
	    		gotoStep(STEP.CASE_SELECTED);
	    		getDetailById(id);
	    	}
	    }

	    init();
	});
})();

/* logo上传成功 */
function successUpload(json) {
    var url = json.data.list[0].url;
    $("#dndArea").css("background-image", "url(" + url + ")");
    $("#logoUrl").val(url);
    $('#logo-line').addClass('logo-line');
};