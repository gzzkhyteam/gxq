function Pop(options) {
	this.options = {
		title: '标题',
		width: '50%',
		//		height: '50%',
		src: '',
		animateTime: 300,
	};
	this.htmlStr = '';
}
var pop = new Pop();
Pop.prototype.init = function(options) {
	$.extend(this.options, options);
	var width, height, scale=1, whc = 0.618;
	if(this.options.width.indexOf('%') > 0) {
		scale = Number(this.options.width.replace('%', '')) / 100;
		this.options.width = window.screen.width * scale;
	} else if(this.options.width.indexOf('px') > 0) {
		this.options.width = Number(this.options.width.replace('px', ''));
	} else if(Number(this.options.width) == NAN) {
		alert('请输入正确的值');
		return false;
	}
	this.options.width = Math.max(this.options.width,500);
	this.options.height = this.options.width * whc;
	this.htmlStr = '<div class="pop-bg">' +
		'<div class="pop-box" style="width:' + 0 + ';height:' + 0 + ';">' +
		'<div class = "close-btn" ></div>' +
		'<div class = "text-title plot_title" >' +
		'    <span>' + this.options.title + '</span>' +
		'</div >' +
		'<iframe name="popFrame" src = "' + this.options.src + '" > < /iframe>' +
		'</div>' +
		'</div>';
	$('.pop-box').remove();
	$('body').append(this.htmlStr);
	this.bindEvent();
	this.startAnimate();
}
Pop.prototype.close = function() {
	$('.pop-box').animate({
		width: 0,
		height: 0,
	}, this.options.animateTime, function() {
		$('.pop-bg').remove();
	});
}
Pop.prototype.bindEvent = function() {
	var self = this;
	$('.pop-box').on('click', '.close-btn', function() {
		self.close();
	})
};
Pop.prototype.startAnimate = function() {
	//	$('.pop-box iframe').contentWindow.document.body.('scroll','no');
	$('.pop-box iframe');
	$('.pop-box').animate({
		width: this.options.width,
		height: this.options.height,
	}, this.options.animateTime);
}