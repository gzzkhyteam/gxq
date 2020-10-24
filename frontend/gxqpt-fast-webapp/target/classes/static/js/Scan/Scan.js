AddCssFile();
//初始化高拍仪
$('body').off('click', '.uploadByCamera').on('click', '.uploadByCamera', function () {
    var uploaderlistcontainer = $(this).attr('uploader-list');
    var fileType = $(this).attr('fileType');
    var relId = $(this).attr('relId');
    var html = '<div style="padding:15px;position:relative;">'

        + '<div style="clear:both;">'
        + '     <div style="float:left;width:68%;margin-right:10px;">'
        + '         <div style="background:url('+getRootPath_web()+'/statics/js/Scan/reviewfield.png) no-repeat center #ddd;margin-bottom:10px;">'
        + '<object classid="clsid:090457CB-DF21-41EB-84BB-39AAFC9E271A" id="ScanCtrl" codebase="*.cab#version=1,0,0,1" width="100%" height="364"></object></div>'
        + '         <div><a href="#" class="btnCamera btnCamera0 takePhoto">获取图片</a></div>'
        + '         <div><a href="#" class="changeCamera">切换摄像头</a>　<span style="float:right;">可以通过鼠标滚轮查看预览细节</span></div>'
        + '     </div>'

        + '     <div style="float:left;width:30%;">'
        + '         <ul class="preuploadlist" style="height:365px;margin-bottom:10px;"><div class="preuploadfieldnotice">无待上传文件</div></ul>'
        + '           <a href="#" class="btnCamera btnCamera1 uploadDirect" style="margin-right:12px;" data-fileType="'+fileType+'" data-relId="'+relId+'" data-uploaderlistcontainer="' + uploaderlistcontainer + '">直接上传</a> '
        + '           <a href="#" class="btnCamera btnCamera1 uploadAsPDF" data-fileType="'+fileType+'" data-relId="'+relId+'"  data-uploaderlistcontainer="' + uploaderlistcontainer + '">合并为PDF上传</a>'
        + '     </div>'
        + '</div>'

        + '     <div class="successnotice">上传成功</div>'
        + '</div>';

    layer.open({
        type: 1,
        title: '高拍仪操作',
        area: ['740px', '525px'], //宽高
        content: html,
        success: function (layero, index) {
            setTimeout(function () {
                //检测高拍仪是否连接
                if (ScanCtrl.IsConnect() == false) {
                    alert('高拍仪未连接，请连接好之后重试');
                    layer.closeAll();
                } else {
                    ScanCtrl.StartPreview();
                    ScanCtrl.SetVideoRotate(90);
                }
            }, 500);
        }
    });

    return false;
});
//判断待上传区域是否为空
function checkEmpty(obj) {
    if ($(obj).find('li').size() == 0) {
        $(obj).html('<div class="preuploadfieldnotice">无待上传文件</div>');
    } else {
        $('.preuploadfieldnotice').remove();
    }
}
//成功提示
function showsucc() {
    $('.successnotice').fadeIn('fast');
    setTimeout(function () {
        $('.successnotice').fadeOut();
    }, 1000);
}
//单文件上传
function ScanFileUpload(obj, filesrc, uploadListContainer,fileType,relId) {
	var url ='http://222.85.152.59:9527/gywsb-bg-webapp/document/uploader2.do' ;
	if(fileType){
		url += "?fileType="+encodeURI(fileType) ;
		if(relId){
			url +="&relId="+relId ;
		}
	}else{
		if(relId){
			url +="?relId="+relId ;
		}
	}
    reval = ScanCtrl.UploadFileOfHTTP2(url, filesrc, filesrc);
    reval = reval.substring(0, reval.length - 5);
    gpyFiles_(reval,fileType) ;
    gpyFiles2_(reval,fileType,uploadListContainer) ;
    
    reval = eval('(' + reval + ')');
    temp = '<div id="WU_FILE_' + Math.random().toString().replace('.', '') + '" class="item">'
        + '<span class="infos">' + reval.file.name + '.jpg</span>'
        + '<span class="state"></span>'
        + '<button style="margin-left: 20px;" class="btn remove remove_' + reval.file.id + '" type="button" title="删除"></button>'
        + '</div>';
    //绑定删除事件
    $('body').on('click', '.remove_' + reval.file.id, function () {
        $(this).parent().remove();
    });
    //写入已上传列表
    $(uploadListContainer).find('.uploader-list').append(temp);
    //删除已上传成功的本地文件
    if (reval.errcode == 0) {
        showsucc();
        ScanCtrl.DeleteMyFile(filesrc);
        //清空已上传成功的预上传列表
        obj.remove();
        checkEmpty('.preuploadlist');
    }
}
//切换摄像头
var cameraNo=0;
$('body').off('click','.changeCamera').on('click','.changeCamera',function(){
    if(cameraNo==1){
        ScanCtrl.SlectDevice(0);
        ScanCtrl.SetCurDev(0);
        cameraNo=0;
    }else {
        ScanCtrl.SlectDevice(1);
        ScanCtrl.SetCurDev(1);
        cameraNo=1;
    }
});
//拍照
$('body').off('click', '.takePhoto').on('click', '.takePhoto', function () {
    var imgsrc = 'C:\\Users\\Public\\Pictures\\' + get_name() + '.jpg';
    var base64data = ScanCtrl.ScanBase64(imgsrc);
    if (base64data != '') {
        var tempimg = $('<li data-imgsrc="' + imgsrc + '"><img src="data:image/jpg;base64,' + ScanCtrl.ScanBase64(imgsrc) + '" />'
            + '<a href="#" title="删除" class="DelPreUploadFile" data-imgsrc="' + imgsrc + '">×</a></li>');
        $('.preuploadlist').append(tempimg);
        checkEmpty('.preuploadlist');
    } else {
        alert('无法获取图像，请稍候再试');
    }
    return false;
});
//依次上传图片文件
$('body').off('click', '.uploadDirect').on('click', '.uploadDirect', function () {
    var reval;
    var temp;
    var uploadListContainer = $(this).attr('data-uploaderlistcontainer');
    var fileType = $(this).attr('data-fileType');
    var relId = $(this).attr('data-relId');
    if ($('.preuploadlist li').size() > 0) {
        $('.preuploadlist li').each(function () {
            ScanFileUpload($(this), $(this).attr('data-imgsrc'), uploadListContainer,fileType,relId);
        });
    } else {
        alert('无待上传文件');
    }
});
//把图片文件列表合并为PDF之后上传
$('body').off('click', '.uploadAsPDF').on('click', '.uploadAsPDF', function () {
    var pdfurl = 'C:\\Users\\Public\\Pictures\\' + get_name() + '.pdf';
    var fileArray = getFileArray();
    var uploadListContainer = $(this).attr('data-uploaderlistcontainer');
    var fileType = $(this).attr('data-fileType');
    var relId = $(this).attr('data-relId');
    if (fileArray.length > 0) {
        for (var i in fileArray) {
            if (fileArray[i] == '' || fileArray[i] == null || fileArray[i] == undefined) {
                continue;
            }
            ScanCtrl.PDF_AddFile(fileArray[i]);
        }
        var IsOk = ScanCtrl.PDF_Create(pdfurl);
        if (IsOk) {
            ScanFileUpload($('.preuploadlist > li'), pdfurl, uploadListContainer,fileType,relId);
            ScanCtrl.DeleteMyFile(pdfurl);
            for (var i in fileArray) {
                ScanCtrl.DeleteMyFile(fileArray[i]);
            }
            checkEmpty('.preuploadlist');
            showsucc();
        }
    } else {
        alert('无待上传文件');
    }
});
//删除上传列表文件
$('body').off('click', '.DelPreUploadFile').on('click', '.DelPreUploadFile', function () {
    if (confirm('确认删除这个准备上传的文件？')) {
        $(this).parent().animate({'margin-right': '0', 'width': '0', 'opacity': '0'}, function () {
            ScanCtrl.DeleteMyFile($(this).attr('data-imgsrc'));
            $(this).remove();
            checkEmpty('.preuploadlist');
        });
    }
    return false;
});
//获取文件列表array
function getFileArray() {
    var filelist = new Array();
    $('.preuploadlist li').each(function () {
        filelist.push($(this).attr('data-imgsrc'));
    });
    return filelist;
}
var filename;
function get_name() {
    var date = new Date();
    var yy = date.getFullYear().toString();
    var mm = (date.getMonth() + 1).toString();
    var dd = date.getDate().toString();
    var hh = date.getHours().toString();
    var nn = date.getMinutes().toString();
    var ss = date.getSeconds().toString();
    var mi = date.getMilliseconds().toString();
    var picName = yy + mm + dd + hh + nn + ss + mi;
    return picName;
}

function AddCssFile() {
    $("head").append("<link>");
    css = $("head").children(":last");
    css.attr({
        rel: "stylesheet",
        type: "text/css",
        href: getRootPath_web() + "/statics/js/Scan/Scan.css"
    });
}

setUploaderWidth();
$(window).resize(function () {
    setUploaderWidth();
});

var width = 0;
function setUploaderWidth() {
    setTimeout(function () {
        //width = $('body').width() - 200;
        width='100%';
        $(".uploader").css("width", width);
        $(".uploader-list").css("width", width);
    }, 0);
}

function getRootPath_web() {
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht = curWwwPath.substring(0, pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    return (localhostPaht + projectName);
}

//获取高拍仪上传成功后返回的对象
function gpyFiles_(reval,fileType){
}
function gpyFiles2_(reval,fileType,thisList){
	
}