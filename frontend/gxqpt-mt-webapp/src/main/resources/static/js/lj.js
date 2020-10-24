//获取项目的全路径
var strFullPath = window.document.location.href;
var strPath = window.document.location.pathname;
var pos = strFullPath.indexOf(strPath);
var prePath = strFullPath.substring(0, pos);
var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
var webPath = prePath + postPath;
/*document.write("<script src='"+webPath+"/statics/js/lib/viewer/js/viewer.js' type='text/javascript'></script>");
 document.write('<link type="text/css" rel="stylesheet"  href="'+webPath+'/statics/js/lib/viewer/js/viewer.css">');
 document.write("<script src="+webPath+"'/statics/js/lib/webuploader/webuploader.min.js' type='text/javascript'></script>");
 document.write('<link type="text/css" rel="stylesheet"  href='+webPath+'"/statics/js/lib/webuploader/webuploader.css">');
 document.write('<link type="text/css" rel="stylesheet"  href="'+webPath+'/statics/css/uploader.css">');*/
//js利用class属性得到对象
function getByClass(oParent, sClass) {
    var aEle = oParent.getElementsByTagName('*');
    var aResult = [];
    var re = new RegExp('\\b' + sClass + '\\b', 'i');
    var i = 0;

    for (i = 0; i < aEle.length; i++) {
        //if(aEle[i].className==sClass)
        //if(aEle[i].className.search(sClass)!=-1)
        if (re.test(aEle[i].className)) {
            aResult.push(aEle[i]);
        }
    }

    return aResult;
}

//图片放大预览设置
var index = 0;
//初始化图片展示控件
function newviewer(uploadDivId) {
    var upload = document.getElementById(uploadDivId);
    var $viewer = getByClass(upload, 'viewer')[0];
    var viewer = new Viewer($viewer, {
//		url:"data-original",
//		navbar :false,
//		tooltip :true,
    });
//	$('.viewer').viewer({
////		url:"data-original",
//		navbar :false,
//		tooltip :true,
//	});

    return viewer;
}

//重新加载图片控件
function reloadViewer(viewer) {
    viewer.destroy();
    viewer.init();
}

//表单数据转换为obj
function serializeFormToObject(form) {
    var o = {};
    $.each(form.serializeArray(), function (index) {
        if (o[this['name']]) {
            o[this['name']] = o[this['name']] + "," + this['value'];
        } else {
            o[this['name']] = this['value'];
        }
    });
    return o;
}
//table 内input元素转换为对象数组
//objs结果数组，table表格对象
function tableToObjectArray(table) {
    var objs = new Array();
    table.find(" tbody tr ").each(function () {
        if ($(this).find(" td input").length == 0) return true;
        var obj = new Object();
        $(this).find(" td input").each(function () {
            obj[this.name] = this.value;
        });
        objs.push(obj);
    });
    return objs;
}

//form表单转换为json
//var data = JSON.stringify($("#form").serializeObject());
$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};


//动态生成表格
function addRow(table, collNames, datas) {
    for (var i = 0; i < datas.length; i++) {
        var row = "";
        row += "<tr>";
        for (var j = 0; j < collNames.length; j++) {
            row += "<td>";
            row += datas[i][collNames[j]];
            row += "</td>";
        }
//		row +='<td><button class="detailBtn" type="button" onclick="" title="详情"></button><button class="delBtn" type="button" onclick="" title="删除"></button></td>' ;
        row += "</tr>";
        table.before(row);
    }
}

/*

 var stmp = "rcinn.cn";
 //使用一个参数
 alert(stmp.slice(3));//从第4个字符开始,截取到最后个字符;返回"nn.cn"
 alert(stmp.substring(3));//从第4个字符开始,截取到最后个字符;返回"nn.cn"
 //使用两个参数
 alert(stmp.slice(1,5))//从第2个字符开始，到第5个字符；返回"cinn"
 alert(stmp.substring(1,5));//从第2个字符开始，到第5个字符；返回"cinn"
 //如果只用一个参数并且为0的话，那么返回整个参数
 alert(stmp.slice(0));//返回整个字符串
 alert(stmp.substring(0));//返回整个字符串
 //返回第一个字符
 alert(stmp.slice(0,1));//返回"r"
 alert(stmp.substring(0,1));//返回"r"
 //在上面的例子中我们可以看出slice()和substring()的用法是相同的
 //返回的值也是一样的，但当参数为负数时，他们的返回值却不一样，看下面的例子
 alert(stmp.slice(2,-5));//返回"i"
 alert(stmp.substring(2,-5));//返回"rc"
 //从上面两个例子可以看出slice(2,-5)实际上是slice(2,3)
 //负5加上字符串长度8转换成正3(若第一位数字等于或大于第二位数字,则返回空字符串);
 //而substring(2,-5)实际上是substring(2,0),负数转换为0,substring总是把较小的数作为起始位置。
 alert(stmp.substring(1,5))//从第2个字符开始，到第5个字符；返回"cinn"
 alert(stmp.substr(1,5));//从第2个字符开始，截取5个字符；返回"cinn."
 * 
 */

//渲染上传控件
//id:触发控件的id
//$list:上传文件的展示列表
//url：文件上传路径
//type:是否自动上传(true/false)
var FILE_TYPE = new Array();//定义一个全局变量为为上传文件类型
function getUploader(id, $list, url) {
    return getUploader(id, $list, url, false);
}


function getUploader(id, $list, url, type) {
    var thumbnailWidth = 100;   //缩略图高度和宽度 （单位是像素），当宽高度是0~1的时候，是按照百分比计算，具体可以看api文档--%>
    var thumbnailHeight = 100;
//  	var viewer= newviewer (id) ;//初始化视图控件
    var uploader = WebUploader.create({
        auto: type,
        // swf文件路径
        swf: '<%=basePath%>statics/js/lib/webuploader/Uploader.swf',
        // 文件接收服务端。
        server: url,//'http://webuploader.duapp.com/server/fileupload.php',
        // 选择文件的按钮。可选。
        pick: '#' + id,
        // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
        resize: false
    });
    // 当有文件添加进来的时候
    uploader.on('fileQueued', function (file) {  // webuploader事件.当选择文件后，文件被加载到文件队列中，触发该事件。等效于 uploader.onFileueued = function(file){...} ，类似js的事件定义。
        var $li = $(
                '<div id="' + file.id + '" class="file-item thumbnail">' +
                '<img>' +
                '<div class="infos">' + file.name + '</div>' +
                '</div>'
            ),

            $img = $li.find('img');
        // $list为容器jQuery实例
        $list.append($li);
//		reloadViewer(viewer) ;
        // 创建缩略图
        // 如果为非图片文件，可以不用调用此方法。
        // thumbnailWidth x thumbnailHeight 为 100 x 100
        uploader.makeThumb(file, function (error, src) {   //webuploader方法
            if (error) {
                $img.replaceWith('<span>不能预览</span>');
                return;
            }

            $img.attr('src', src);
        }, thumbnailWidth, thumbnailHeight);
    });
    // 文件上传过程中创建进度条实时显示。
    uploader.on('uploadProgress', function (file, percentage) {
        var $li = $('#' + file.id),
            $percent = $li.find('.progress span');

        // 避免重复创建
        if (!$percent.length) {
            $percent = $('<p class="progress"><span></span></p>')
                .appendTo($li)
                .find('span');
        }

        $percent.css('width', percentage * 100 + '%');
    });

    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
    uploader.on('uploadSuccess', function (file, json) {
        FILE_TYPE.push(json);
        $('#' + file.id).addClass('upload-state-done');
    });

    // 文件上传失败，显示上传出错。
    uploader.on('uploadError', function (file) {
        var $li = $('#' + file.id),
            $error = $li.find('div.error');

        // 避免重复创建
        if (!$error.length) {
            $error = $('<div class="error"></div>').appendTo($li);
        }

        $error.text('上传失败');
    });

    // 完成上传完了，成功或者失败，先删除进度条。
    uploader.on('uploadComplete', function (file) {
        $('#' + file.id).find('.progress').remove();
    });
    return uploader;
}


//获取上传控件
//id 控件div id
//url 文件上传路径
//readyUrl 控件加载初始文件加载路径
//type 是否是独立上传还是统一上传.默认独立上传，或者自动上传当type=1
function setUploader(id, url, readyUrl, type) {
    var pick = id + "_pick";
//获取选择按钮名称
    var title = $.trim($("#" + id).text());
    if ($("#" + id).is(":hidden"))return;//判断是否隐藏
    if ($('#' + id).find(".queueList .viewer").length > 0) return;
    if ($("#" + pick).length == 0) {
        var template =
            '<div class="queueList">' +
            '<div  class="placeholder">' +
            '<div id="' + pick + '" class="webuploader-container">' +
            '</div>' +
            '<p >或将照片拖到这里，单次最多可选300张</p>' +
            '</div>' +
            '<ul class="filelist"></ul>' +
            '</div>' +
            '<div class="statusBar" style="display:none;">' +
            '<div class="progress" style="display: none;">' +
            '<span class="text">0%</span> ' +
            '<span class="percentage" style="width: 0%;"></span>' +
            '</div>' +
            '<div class="infos">共0张（0B），已上传0张</div>' +
            '<div class="btns_to">' +
            '<div id="' + pick + '2"  class="webuploader-container filePicker2">' +
            '<div class="webuploader-pick">继续添加' + title + '</div>' +
            '</div>' +
            '<div style="display:none;" class="uploadBtn state-pedding">开始上传</div>' +
            '</div>' +
            '</div>';
        $("#" + id).html(template);
    } else {
        title = "";
    }
    if (!type) {
        $("#" + id + " .uploadBtn").css('display', 'block');
    } else {
        $("#" + id + " .uploadBtn").css('display', 'none');
    }
    return setUpload(id, pick, url, title, readyUrl, type);
}


//初始化上传控件
//uploadDivId 控件div id
//pick 选择按钮
//url 文件上传路径
//title 选择按钮名称
//readyUrl 控件加载初始文件加载路径
function setUpload(uploadDivId, pick, url, title, readyUrl, type) {
    var lableName = "";
    if (title) {
        lableName = title;
    }
    var autoType = false;
    if (type) {
        if (type == "1") {
            autoType = true;
        }
    }
    var $ = jQuery,    // just in case. Make sure it's not an other libaray.

        $wrap = $('#' + uploadDivId),

        // 图片容器
        $queue = $('<ul class="filelist viewer"></ul>')
            .appendTo($wrap.find('.queueList')),

        // 状态栏，包括进度和控制按钮
        $statusBar = $wrap.find('.statusBar'),

        // 文件总体选择信息。
        $info = $statusBar.find('.infos'),

        // 上传按钮
        $upload = $wrap.find('.uploadBtn'),
//        $upload = $('.uploadBtn'),

        // 没选择文件之前的内容。
        $placeHolder = $wrap.find('.placeholder'),

        // 总体进度条
        $progress = $statusBar.find('.progress').hide(),

        // 添加的文件数量
        fileCount = 0,

        // 添加的文件总大小
        fileSize = 0,

        // 优化retina, 在retina下这个值是2
        ratio = window.devicePixelRatio || 1,

        // 缩略图大小
        thumbnailWidth = 110 * ratio,
        thumbnailHeight = 110 * ratio,

        // 可能有pedding, ready, uploading, confirm, done.
        state = 'pedding',

        // 所有文件的进度信息，key为file id
        percentages = {},

        supportTransition = (function () {
            var s = document.createElement('p').style,
                r = 'transition' in s ||
                    'WebkitTransition' in s ||
                    'MozTransition' in s ||
                    'msTransition' in s ||
                    'OTransition' in s;
            s = null;
            return r;
        })(),

        // WebUploader实例
        uploader;
    var viewer = newviewer(uploadDivId);//初始化视图控件

    if (!WebUploader.Uploader.support()) {
        alert('Web Uploader 不支持您的浏览器！如果你使用的是IE浏览器，请尝试升级 flash 播放器');
        throw new Error('WebUploader does not support the browser you are using.');
    }

    // 实例化
    uploader = WebUploader.create({
        auto: autoType,
        pick: {
            id: '#' + pick,
//            id: '#filePicker',
            label: '点击选择' + lableName + '图片'
        },
        dnd: '#' + uploadDivId + ' .queueList',
//        paste: document.body,

        accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png',
            mimeTypes: 'image/*'
        },

        // swf文件路径
        swf: "<%=basePath%>statics/js/lib/webuploader/Uploader.swf",

        disableGlobalDnd: true,

        chunked: true,
        // server: 'http://webuploader.duapp.com/server/fileupload.php',
//        server: 'http://2betop.net/fileupload.php',
        server: url,
//        fileNumLimit: 300,
//        fileSizeLimit: 5 * 1024 * 1024,    // 200 M
//        fileSingleSizeLimit: 1 * 1024 * 1024    // 50 M
    });

    // 添加“添加文件”的按钮，
    uploader.addButton({
        id: '#' + pick + '2',
//        id: '.filePicker2',
        label: '继续添加' + lableName
    });

    // 当有文件添加进来时执行，负责view的创建
    function addFile(file) {
        var $li = $('<li class="li_lj" id="' + file.id + '">' +
                '<p class="title">' + file.name + '</p>' +
                '<p class="imgWrap"></p>' +
                '<p class="progress"><span></span></p>' +
                '</li>'),

            $btns = $('<div class="file-panel">' +
                '<span class="cancel">删除</span>' +
                '<span class="rotateRight">向右旋转</span>' +
                '<span class="rotateLeft">向左旋转</span></div>').appendTo($li),
            $prgress = $li.find('p.progress span'),
            $wrap = $li.find('p.imgWrap'),
            $info = $('<p class="error"></p>'),

            showError = function (code) {
                switch (code) {
                    case 'exceed_size':
                        text = '文件大小超出';
                        break;

                    case 'interrupt':
                        text = '上传暂停';
                        break;

                    default:
                        text = '上传失败，请重试';
                        break;
                }

                $info.text(text).appendTo($li);
            };

        if (file.getStatus() === 'invalid') {
            showError(file.statusText);
        } else {
            // @todo lazyload
            $wrap.text('预览中');
            uploader.makeThumb(file, function (error, src) {
                if (error) {
                    $wrap.text('不能预览');
                    return;
                }

                var img = $('<img data-original="' + src + '" src="' + src + '">');
                $wrap.empty().append(img);
                reloadViewer(viewer);
            }, thumbnailWidth, thumbnailHeight);

            percentages[file.id] = [file.size, 0];
            file.rotation = 0;
        }

        file.on('statuschange', function (cur, prev) {
            if (prev === 'progress') {
                $prgress.hide().width(0);
            } else if (prev === 'queued') {
                $li.off('mouseenter mouseleave');
                $btns.remove();
            }

            // 成功
            if (cur === 'error' || cur === 'invalid') {
                console.log(file.statusText);
                showError(file.statusText);
                percentages[file.id][1] = 1;
            } else if (cur === 'interrupt') {
                showError('interrupt');
            } else if (cur === 'queued') {
                percentages[file.id][1] = 0;
            } else if (cur === 'progress') {
                $info.remove();
                $prgress.css('display', 'block');
            } else if (cur === 'complete') {
                $li.append('<span class="success"></span>');
            }

            $li.removeClass('state-' + prev).addClass('state-' + cur);
        });

        $li.on('mouseenter', function () {
            $btns.stop().animate({height: 30});
        });

        $li.on('mouseleave', function () {
            $btns.stop().animate({height: 0});
        });

        $btns.on('click', 'span', function () {
            var index = $(this).index(),
                deg;

            switch (index) {
                case 0:
                    uploader.removeFile(file);
                    return;

                case 1:
                    file.rotation += 90;
                    break;

                case 2:
                    file.rotation -= 90;
                    break;
            }

            if (supportTransition) {
                deg = 'rotate(' + file.rotation + 'deg)';
                $wrap.css({
                    '-webkit-transform': deg,
                    '-mos-transform': deg,
                    '-o-transform': deg,
                    'transform': deg
                });
            } else {
                $wrap.css('filter', 'progid:DXImageTransform.Microsoft.BasicImage(rotation=' + (~~((file.rotation / 90) % 4 + 4) % 4) + ')');
            }


        });

        $li.appendTo($queue);
    }

    //添加初始文件时候执行
    // 当有文件添加进来时执行，负责view的创建
    function addFile2(file) {
        var $li = $('<li class="li_lj" id="' + file.id + '">' +
                '<p class="title">' + file.name + '</p>' +
                '<p class="imgWrap"></p>' +
                '<p class="progress"><span></span></p>' +
                '</li>'),

            $btns = $('<div class="file-panel">' +
                '<span class="cancel">删除</span>' +
                '<span class="rotateRight">向右旋转</span>' +
                '<span class="rotateLeft">向左旋转</span></div>').appendTo($li),
            $prgress = $li.find('p.progress span'),
            $wrap = $li.find('p.imgWrap'),
            $info = $('<p class="error"></p>'),

            showError = function (code) {
                switch (code) {
                    case 'exceed_size':
                        text = '文件大小超出';
                        break;

                    case 'interrupt':
                        text = '上传暂停';
                        break;

                    default:
                        text = '上传失败，请重试';
                        break;
                }

                $info.text(text).appendTo($li);
            };

        if (file.getStatus() === 'invalid') {
            showError(file.statusText);
        } else {
            // @todo lazyload
            $wrap.text('预览中');
            uploader.makeThumb(file, function (error, src) {
                var img = $('<img data-original="' + webPath + '/document/downLoadAttachment.do?url=' + file.ret + '" src="' + webPath + '/document/downLoadAttachment.do?url=' + file.ret + '" alt=""> ');
                $wrap.empty().append(img);
            }, thumbnailWidth, thumbnailHeight);

            percentages[file.id] = [file.size, 0];
            file.rotation = 0;
        }
        $li.on('mouseenter', function () {
            $btns.stop().animate({height: 30});
        });

        $li.on('mouseleave', function () {
            $btns.stop().animate({height: 0});
        });

        $btns.on('click', 'span', function () {
            var index = $(this).index(),
                deg;

            switch (index) {
                case 0:
                    uploader.removeFile(file);
                    return;

                case 1:
                    file.rotation += 90;
                    break;

                case 2:
                    file.rotation -= 90;
                    break;
            }

            if (supportTransition) {
                deg = 'rotate(' + file.rotation + 'deg)';
                $wrap.css({
                    '-webkit-transform': deg,
                    '-mos-transform': deg,
                    '-o-transform': deg,
                    'transform': deg
                });
            } else {
                $wrap.css('filter', 'progid:DXImageTransform.Microsoft.BasicImage(rotation=' + (~~((file.rotation / 90) % 4 + 4) % 4) + ')');
            }


        });

        $li.appendTo($queue);
    }

    // 负责view的销毁
    function removeFile(file) {
        var $li = $('#' + file.id);
        delFile(file.id);
        delete percentages[file.id];
        updateTotalProgress();
        $li.off().find('.file-panel').off().end().remove();
    }

    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
    uploader.on('uploadSuccess', function (file, json) {
        if (FILE_TYPE.indexOf(json) == -1) {
            FILE_TYPE.push(json);
        }
        uploadSuccess(file, json);
    });

    function updateTotalProgress() {
        var loaded = 0,
            total = 0,
            spans = $progress.children(),
            percent;

        $.each(percentages, function (k, v) {
            total += v[0];
            loaded += v[0] * v[1];
        });

        percent = total ? loaded / total : 0;

        spans.eq(0).text(Math.round(percent * 100) + '%');
        spans.eq(1).css('width', Math.round(percent * 100) + '%');
        updateStatus();
    }

    function updateStatus() {
        var text = '', stats;

        if (state === 'ready') {
            text = '选中' + fileCount + '张图片，共' +
                WebUploader.formatSize(fileSize) + '。';
        } else if (state === 'confirm') {
            stats = uploader.getStats();
            if (stats.uploadFailNum) {
                text = '已成功上传' + stats.successNum + '张照片至XX相册，' +
                    stats.uploadFailNum + '张照片上传失败，<a class="retry" href="#">重新上传</a>失败图片或<a class="ignore" href="#">忽略</a>';
            }
        } else {
            stats = uploader.getStats();
            text = '共' + fileCount + '张（' +
                WebUploader.formatSize(fileSize) +
                '），已上传' + stats.successNum + '张';

            if (stats.uploadFailNum) {
                text += '，失败' + stats.uploadFailNum + '张';
            }
        }

        $info.html(text);
    }

    function setState(val) {
        var file, stats;

        if (val === state) {
            return;
        }

        $upload.removeClass('state-' + state);
        $upload.addClass('state-' + val);
        state = val;

        switch (state) {
            case 'pedding':
                $placeHolder.removeClass('element-invisible');
                $queue.parent().removeClass('filled');
                $queue.hide();
                $statusBar.addClass('element-invisible');
                uploader.refresh();
                break;

            case 'ready':
                $placeHolder.addClass('element-invisible');
                if (!autoType) {
                    $('#' + pick + '2').removeClass('element-invisible');
                }
                $queue.parent().addClass('filled');
                $queue.show();
                $statusBar.removeClass('element-invisible');
                uploader.refresh();
                break;

            case 'uploading':
                if (!autoType) {
                    $('#' + pick + '2').addClass('element-invisible');
                }
                $progress.show();
                $upload.text('暂停上传');
                break;

            case 'paused':
                $progress.show();
                $upload.text('继续上传');
                break;

            case 'confirm':
                $progress.hide();
                $upload.text('开始上传').addClass('disabled');

                stats = uploader.getStats();
                if (stats.successNum && !stats.uploadFailNum) {
                    setState('finish');
                    return;
                }
                break;
            case 'finish':
                stats = uploader.getStats();
                if (stats.successNum) {
                    //alert( '上传成功' );
                } else {
                    // 没有成功的图片，重设
                    state = 'done';
                    location.reload();
                }
                break;
        }

        updateStatus();
    }

    uploader.onUploadProgress = function (file, percentage) {
        var $li = $('#' + file.id),
            $percent = $li.find('.progress span');

        $percent.css('width', percentage * 100 + '%');
        percentages[file.id][1] = percentage;
        updateTotalProgress();
    };
    //加载的时候，页面加载的时候模拟文件加入队列进行图片的编辑回显
    uploader.on('ready', function () {
        if (!readyUrl)return;
        $.ajax({
//    		url:"${_cp}/cg/document/findFilesByApplyIdAndFileType.do?applyId=xxx&fileType=xxx",//数据库获取文件信息
            url: readyUrl,//数据库获取文件信息
            type: 'get',
            async: false,
            success: function (files) {
                var files = eval('(' + files + ')');
                for (var i = 0; i < files.length; i++) {
                    var obj = {};
                    statusMap = {};
                    fileCount++;
                    fileSize += files[i].size;
                    if (fileCount === 1) {
//                    	$placeholder.addClass( 'element-invisible' );
                        $wrap.find('.placeholder').addClass('element-invisible');
                        $statusBar.show();
                    }
                    FILE_TYPE.push(files[i].fileType);
                    obj.id = files[i].id;
                    obj.name = files[i].name;
                    obj.type = files[i].type;
                    obj.size = 0;
                    obj.ret = files[i].fileUrl;
                    obj.source = this;
                    obj.flog = true;
                    obj.status = 'complete',
                        obj.getStatus = function () {
                            return '';
                        }
                    obj.version = WebUploader.Base.version;
                    obj.statusText = '';
                    obj.setStatus = function () {
                        var prevStatus = statusMap[this.id];
                        typeof text !== 'undefined' && (this.statusText = text);
                        if (status !== prevStatus) {
                            statusMap[this.id] = status;
                            //文件状态设置为已完成
                            uploader.trigger('statuschage', status, prevStatus);
                        }
                    }
//                    addFile( obj,uploader,queue);
                    addFile2(obj);
//                    setState( 'ready' ,uploader,placeholder,queue,statusBar,jxfilePicker);
                    setState('ready');
//                    updateStatus('ready',info,fileCount,fileSize);
                    updateStatus();
                }
            }
        });
        reloadViewer(viewer);
    });
    uploader.onFileQueued = function (file) {
        fileCount++;
        fileSize += file.size;

        if (fileCount === 1) {
            $placeHolder.addClass('element-invisible');
            $statusBar.show();
        }

        addFile(file);
        setState('ready');
        updateTotalProgress();
    };

    uploader.onFileDequeued = function (file) {
        fileCount--;
        fileSize -= file.size;

        if (!fileCount) {
            setState('pedding');
        }

        removeFile(file);
        updateTotalProgress();

    };

    uploader.on('all', function (type) {
        var stats;
        switch (type) {
            case 'uploadFinished':
                setState('confirm');
                break;

            case 'startUpload':
                setState('uploading');
                break;

            case 'stopUpload':
                setState('paused');
                break;

        }
    });

    uploader.onError = function (code) {
        //alert( 'Eroor: ' + code );
    };

    $upload.on('click', function () {
        if ($(this).hasClass('disabled')) {
            return false;
        }

        if (state === 'ready') {
            uploader.upload();
        } else if (state === 'paused') {
            uploader.upload();
        } else if (state === 'uploading') {
            uploader.stop();
        }
    });

    $info.on('click', '.retry', function () {
        uploader.retry();
    });

    $info.on('click', '.ignore', function () {
        //alert( 'todo' );
    });

    $upload.addClass('state-' + state);
    updateTotalProgress();
    //返回上传控件
    return uploader;
}

//删除附件
function delFile(id) {
    $.ajax({
        url: webPath + "/document/delFile.do?id=" + id
    });

}
//获取不展示图片的上传控件
//上传文件数
var FILE_NUM = 0;
function getNoImgUploader(id, url) {

    var template =
        '<div id="' + id + '_picker"  class="selFlie ">选择文件</div><div id="' + id + '_thelist" class="uploader-list"></div>'
    ;
    $("#" + id).html(template);

    var $list = $("#" + id + "_thelist");
    var uploader = WebUploader.create({
        auto: false,
        // swf文件路径
        swf: '<%=basePath%>statics/js/lib/webuploader/Uploader.swf',
        // 文件接收服务端。
        server: url,//'http://webuploader.duapp.com/server/fileupload.php',
        // 选择文件的按钮。可选。
        pick: "#" + id + '_picker',
        // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
        resize: false,
        fileSingleSizeLimit: 10 * 1024 * 1024//单个文件大小限制
    });
    uploader.on('fileQueued', function (file) {
        FILE_NUM++;
        $list.append('<div id="' + file.id + '" class="item">'
            + '<span class="infos">' + file.name + '</span>' + '<span class="state"></span>'
            + '<button style="margin-left: 20px;" class="btn remove" type="button" title="删除"></button>'
            + '</div>');
        $("#" + file.id).find(".remove").on('click', function () {
            uploader.removeFile(file);
            $(this).parent().remove();
            FILE_NUM--;
        });
    });
    uploader.on('uploadSuccess', function (file, json) {
//	    $( '#'+file.id ).find('span.state').text('已上传');
//	    $( '#'+file.id ).find('input').val(json);
        uploadSuccess(file, json);
    });
    /**
     * 验证文件格式以及文件大小
     */
    uploader.on("error", function (type) {
        /* if (type=="Q_TYPE_DENIED"){
         dialogMsg("myModal","messageP","请上传JPG、PNG格式文件");
         }else */
        if (type == "F_EXCEED_SIZE") {
            layer.alert("文件大小不能超过10M");
        }
    });
    return uploader;
}

function uploadSuccess(file, json) {
    $('#' + file.id).find('span .state').text('已上传');
}

