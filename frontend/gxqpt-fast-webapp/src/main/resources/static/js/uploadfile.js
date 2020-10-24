function getUploader(id,$list,url,fileinfos,fileType){
	var thumbnailWidth = 100;   //缩略图高度和宽度 （单位是像素），当宽高度是0~1的时候，是按照百分比计算，具体可以看api文档--%>
	var thumbnailHeight = 100;
	var uploader = WebUploader.create({
		auto: true,
		// swf文件路径
		swf: '${ctxStatic }/webupload/Uploader.swf',
		// 文件接收服务端。
		server :url,//'http://webuploader.duapp.com/server/fileupload.php',
		// 选择文件的按钮。可选。
		pick : '#'+id,
		// 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
		resize : false,
		//只允许选择图片文件。
		/*accept: {
		 title: 'Images',
		 extensions: 'gif,jpg,jpeg,bmp,png',
		 mimeTypes: 'image/*'
		 },*/
		method:'POST',
	});
	// 当有文件添加进来的时候
	uploader.on( 'fileQueued', function( file ) {  // webuploader事件.当选择文件后，文件被加载到文件队列中，触发该事件。等效于 uploader.onFileueued = function(file){...} ，类似js的事件定义。
		var $li = $(
				'<div id="' + file.id + '" class="file-item">' +
				'<div class="info" title="' + file.name + '">' + file.name + '</div>' +
				'<button class="btn remove" type="button" ></button>' +
				/*'<img>' +*/
				'</div>'
			),
			$img = $li.find('img');


		// $list为容器jQuery实例
		$list.append( $li );

		// 创建缩略图
		// 如果为非图片文件，可以不用调用此方法。
		// thumbnailWidth x thumbnailHeight 为 100 x 100
		uploader.makeThumb( file, function( error, src ) {   //webuploader方法
			/*if ( error ) {
			 $img.replaceWith('<span>不能预览</span>');
			 return;
			 }*/

			$img.attr( 'src', src );
		}, thumbnailWidth, thumbnailHeight );


		//删除
		$("#"+file.id).find(".remove").on( 'click', function() {
			uploader.removeFile(file) ;
			$(this).parent().remove();
			FILE_NUM--;
		});
	});

	// 文件上传过程中创建进度条实时显示。
	/*uploader.on( 'uploadProgress', function( file, percentage ) {
	 var $li = $( '#'+file.id ),
	 $percent = $li.find('.progress span');

	 // 避免重复创建
	 if ( !$percent.length ) {
	 $percent = $('<p class="progress"><span></span></p>')
	 .appendTo( $li )
	 .find('span');
	 }

	 $percent.css( 'width', percentage * 100 + '%' );
	 });*/

	// 文件上传成功，给item添加成功class, 用样式标记上传成功。
	uploader.on( 'uploadSuccess', function( file,json ) {
		if(json!=null&&json!=undefined){
			json.fileType = fileType;
			console.log("=123"+json);
		}
		fileinfos.push(json);
		$( '#'+file.id ).addClass('upload-state-done');
	});

	// 文件上传失败，显示上传出错。
	uploader.on( 'uploadError', function( file ) {
		var $li = $( '#'+file.id ),
			$error = $li.find('div.info');

		// 避免重复创建
		if ( !$error.length ) {
			$error = $('<div class="error"></div>').appendTo( $li );
		}

		//$error.text('上传失败');
		$li.addClass("error");
		$li.attr('title','上传失败');
		$error.attr('title','');
	});

	// 完成上传完了，成功或者失败，先删除进度条。
	uploader.on( 'uploadComplete', function( file ) {
		$( '#'+file.id ).find('.progress').remove();
	});
	console.log("---------------------"+fileinfos);
	return fileinfos;
}

/**
 * 列表中的多个文件上传
 * @param id
 * @param $list
 * @param url
 * @param fileinfos
 * @param fileType
 * @returns
 */
function getListUploader(id,$list,url,fileinfos,fileType){
	var thumbnailWidth = 100;   //缩略图高度和宽度 （单位是像素），当宽高度是0~1的时候，是按照百分比计算，具体可以看api文档--%>
	var thumbnailHeight = 100;
	var uploader = WebUploader.create({
		auto: true,
		// swf文件路径
		swf: '${ctxStatic }/webupload/Uploader.swf',
		// 文件接收服务端。
		server :url,//'http://webuploader.duapp.com/server/fileupload.php',
		// 选择文件的按钮。可选。
		pick : '#'+id,
		// 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
		resize : false,
		// 只允许选择图片文件。
		/*accept: {
		 title: 'Images',
		 extensions: 'gif,jpg,jpeg,bmp,png',
		 mimeTypes: 'image/*'
		 },*/
		method:'POST',
	});
	// 当有文件添加进来的时候
	uploader.on( 'fileQueued', function( file ) {  // webuploader事件.当选择文件后，文件被加载到文件队列中，触发该事件。等效于 uploader.onFileueued = function(file){...} ，类似js的事件定义。
		var $li = $(
				'<div id="' + file.id + '" class="file-item">' +
				'<div class="info" title="' + file.name + '">' + file.name + '</div>' +
				'<button class="btn remove" type="button" ></button>' +
				/*'<img>' +*/
				'</div>'
			),
			$img = $li.find('img');


		// $list为容器jQuery实例
		$list.append( $li );

		// 创建缩略图
		// 如果为非图片文件，可以不用调用此方法。
		// thumbnailWidth x thumbnailHeight 为 100 x 100
		uploader.makeThumb( file, function( error, src ) {   //webuploader方法
			/*if ( error ) {
			 $img.replaceWith('<span>不能预览</span>');
			 return;
			 }*/

			$img.attr( 'src', src );
		}, thumbnailWidth, thumbnailHeight );


		//删除
		$("#"+file.id).find(".remove").on( 'click', function() {
			uploader.removeFile(file) ;
			$(this).parent().remove();
			FILE_NUM--;
		});
	});

	// 文件上传成功，给item添加成功class, 用样式标记上传成功。
	uploader.on( 'uploadSuccess', function( file,json ) {
		var applyIdLength = id.length;
		if(applyIdLength>8){
			var applyId = id.substr(6,applyIdLength-6);
			json.applyId = applyId;
		}
		if(json!=null&&json!=undefined){
			json.fileType = fileType;
		}
		fileinfos.push(json);
		console.log(json);
		$( '#'+file.id ).addClass('upload-state-done');
	});

	// 文件上传失败，显示上传出错。
	uploader.on( 'uploadError', function( file ) {
		var $li = $( '#'+file.id ),
			$error = $li.find('div.error');

		// 避免重复创建
		if ( !$error.length ) {
			$error = $('<div class="error"></div>').appendTo( $li );
		}

		$error.text('上传失败');
	});

	// 完成上传完了，成功或者失败，先删除进度条。
	uploader.on( 'uploadComplete', function( file ) {
		$( '#'+file.id ).find('.progress').remove();
	});
	return fileinfos;
}

//任务文件上传
function getUploaderOtherCertificate(id, $list, url, fileinfos, fileType, index) {
	var thumbnailWidth = 100;   //缩略图高度和宽度 （单位是像素），当宽高度是0~1的时候，是按照百分比计算，具体可以看api文档--%>
	var thumbnailHeight = 100;
	var uploader = WebUploader.create({
		auto: true,
		// swf文件路径
		swf: '${ctxStatic }/webupload/Uploader.swf',
		// 文件接收服务端。
		server: url,//'http://webuploader.duapp.com/server/fileupload.php',
		// 选择文件的按钮。可选。
		pick: '#' + id,
		// 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
		resize: false,
		// 只允许选择图片文件。
		/*accept: {
		 title: 'Images',
		 extensions: 'gif,jpg,jpeg,bmp,png',
		 mimeTypes: 'image/*'
		 },*/
		method: 'POST',
	});
	// 当有文件添加进来的时候
	uploader.on('fileQueued', function (file, json) {
		// webuploader事件.当选择文件后，文件被加载到文件队列中，触发该事件。等效于 uploader.onFileueued = function(file){...} ，类似js的事件定义。
		var $li = $(
			'<div id="' + file.id + '" class="file-item">' +
			/*'<img>' +*/
			'<div class="info">' + file.name + '</div>' +
			'<button class="btn remove" type="button" ></button>' +
			'</div>'
		);
		//$img = $li.find('img');


		// $list为容器jQuery实例
		$list.append($li);

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
		uploadSuccess(file,json);
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
	return fileinfos;
}

/**
 * 文件上传包括功能的删除
 * @param id
 * @param $list
 * @param url
 * @param fileinfos
 * @param fileType
 * @returns
 */
function getUploaderAndUpdate(id,$list,url,fileinfos,fileType){
	var thumbnailWidth = 100;   //缩略图高度和宽度 （单位是像素），当宽高度是0~1的时候，是按照百分比计算，具体可以看api文档--%>
	var thumbnailHeight = 100;
	var uploader = WebUploader.create({
		auto: true,
		// swf文件路径
		swf: '${ctxStatic }/webupload/Uploader.swf',
		// 文件接收服务端。
		server :url,//'http://webuploader.duapp.com/server/fileupload.php',
		// 选择文件的按钮。可选。
		pick : '#'+id,
		// 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
		resize : false,
		// 只允许选择图片文件。
		/*accept: {
		 title: 'Images',
		 extensions: 'gif,jpg,jpeg,bmp,png',
		 mimeTypes: 'image/*'
		 },*/
		method:'POST',
	});
	// 当有文件添加进来的时候
	uploader.on( 'fileQueued', function( file ) {  // webuploader事件.当选择文件后，文件被加载到文件队列中，触发该事件。等效于 uploader.onFileueued = function(file){...} ，类似js的事件定义。

	});
	// 文件上传过程中创建进度条实时显示。
	uploader.on( 'uploadProgress', function( file, percentage ) {
		var $li = $( '#'+file.id ),
			$percent = $li.find('.progress span');

		// 避免重复创建
		if ( !$percent.length ) {
			$percent = $('<p class="progress"><span></span></p>')
				.appendTo( $li )
				.find('span');
		}

		$percent.css( 'width', percentage * 100 + '%' );
	});

	// 文件上传成功，给item添加成功class, 用样式标记上传成功。
	uploader.on( 'uploadSuccess', function( file,json ) {

		$list.append('<div id="' + file.id + '" class="item">'
			+ '<span class="info">' + file.name  + '</span>'+ '<span class="state"></span>'
			+ '<button style="margin-left: 20px;" class="btn btn-primary upload" type="button" >下载</button>'
			+ '<button style="margin-left: 20px;" class="btn btn-primary remove" type="button" >删除</button>'
			+'</div>');

		$("#"+file.id).find(".upload").on( 'click', function() {
			downLoadAttachment(json.id) ;
		});
		$("#"+file.id).find(".remove").on( 'click', function() {
			removeFile(json) ;
			$(this).parent().remove();
		});

		if(json!=null&&json!=undefined){
			json.fileType = fileType;
		}
		fileinfos.push(json);
		$( '#'+file.id ).addClass('upload-state-done');
	});

	// 文件上传失败，显示上传出错。
	uploader.on( 'uploadError', function( file ) {
		var $li = $( '#'+file.id ),
			$error = $li.find('div.error');

		// 避免重复创建
		if ( !$error.length ) {
			$error = $('<div class="error"></div>').appendTo( $li );
		}

		$error.text('上传失败');
	});

	// 完成上传完了，成功或者失败，先删除进度条。
	uploader.on( 'uploadComplete', function( file ) {
		$( '#'+file.id ).find('.progress').remove();
	});
	return fileinfos;
}

var strFullPath=window.document.location.href;
var strPath=window.document.location.pathname;
var pos=strFullPath.indexOf(strPath);
var prePath=strFullPath.substring(0,pos);
var postPath=strPath.substring(0,strPath.substr(1).indexOf('/')+1);
var webPath=prePath+postPath;

function removeFile( file ) {
	var $li = $('#'+file.id);
	delFile(file.id) ;
	delete percentages[ file.id ];
	updateTotalProgress();
	$li.off().find('.file-panel').off().end().remove();
}

/**
 * 单个文件下载
 * @param file
 */
function downLoadAttachment(id){
	window.location.href=webPath+"/yx/comm/file/downFileById.do?id="+id;
}
//删除附件
function delFile(id){
	$.ajax({
		url: webPath+"/yx/comm/file/delFile.do?id="+id
	}) ;

}

//
//单文件上传
//夏金晶改
//
function getSingleUploaderFile(id, $list, url, fileinfos, fileType, uploadMutiple) {
	var thumbnailWidth = 100;   //缩略图高度和宽度 （单位是像素），当宽高度是0~1的时候，是按照百分比计算，具体可以看api文档--%>
	var thumbnailHeight = 100;
	var uploader = WebUploader.create({
		auto: true,
		// swf文件路径
		swf: '${ctxStatic }/webupload/Uploader.swf',
		// 文件接收服务端。
		server: url,//'http://webuploader.duapp.com/server/fileupload.php',
		// 选择文件的按钮。可选。
		pick: {
			id: '#' + id,
			multiple: uploadMutiple
		},
		// 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
		resize: false,
		// 只允许选择图片文件。
		accept: {
			title: 'Images',
			extensions: 'gif,jpg,jpeg,png',
			mimeTypes: 'image/*'
		},
		method: 'POST',
		duplicate:true
	});

	var tempstr = $('#' + id).find('.webuploader-pick').text();

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

		$('#' + id).find('.webuploader-pick').text('上传中[' + percentage * 100 + '%]');

		//$percent.css('width', percentage * 100 + '%');
	});
// 文件上传成功，给item添加成功class, 用样式标记上传成功。
	uploader.on('uploadSuccess', function (file, json) {
		/*fileinfo = {name:json.oldName,size:json.fileSize,
		 type:json.fileType,fileUrl:json.filePath,createDate:json.createTime,
		 fileType:fileType,userId:json.createby};*/
		//console.log(json);
		if (json != null && json != undefined) {
			json.fileType = fileType;
			fileinfos.push(json);
		}

		$('#' + id).find('.webuploader-pick').text(tempstr);
		$('#' + id).parent().parent().find('.nopic').attr('src', '/gysfj-yx-webapp/yx/comm/file/downLoadAttachment.do?url=' + json.fileUrl);
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

		alert('图片上传失败')
		//$error.text('上传失败');
	});

// 完成上传完了，成功或者失败，先删除进度条。
	uploader.on('uploadComplete', function (file) {
		$('#' + file.id).find('.progress').remove();
	});
	return fileinfos;
}

