/*让数字动起来*/
$(function() {
		numAnimate($('.num-group .contain span'))
})

function numAnimate(jqueryElem){
	
	$.each(jqueryElem, function(index, value) {
		var currObj = $(value);
		var height = currObj.height();
		var parentObj = currObj.parent();
		maxnum = Number(currObj.text());
		for(i = 0; i <= maxnum; i++) {
			parentObj.append('<span>' + i + '</span>');
		}
		startAnimate(parentObj, height * (maxnum + 1));
	});
}
/*计数html拼接方法*/
function buildI(jquerySelector, num) {
    if (num < 0) {
        return;
    }
    var html = "";
    var numStr = num + "";
    
    for (var i = 0; i < numStr.length; i++) {

        html += '<div class="num">'
            + '<div class="contain">'
            + '<span class="original">' + numStr[i] + '</span>'
            + '</div>'
            + '</div>';
    }
    $(jquerySelector).prepend(html);
    numAnimate($(jquerySelector + " .contain span"));
}
/*计数html拼接方法*/
function buildIndex(jquerySelector, num) {
    if (num < 0) {
        return;
    }
    var html = "";
    var numStr = num + "";
    $(jquerySelector).siblings('.icon_number_bg').remove();
    for (var i = 0; i < numStr.length; i++) {

        html += '<div class="icon_number_bg">'
            + '<div class="contain">'
            + '<span class="original">' + numStr[i] + '</span>'
            + '</div>'
            + '</div>';
    }
    $(jquerySelector).after(html);
    numAnimate($(jquerySelector).siblings().find(" .contain span"));
}

function startAnimate(obj, height) {
    obj.animate({
        marginTop: -height,
    }, 1000, function () {
        obj.find('span:not(:last)').remove();
        obj.css('margin-top', 0);
    });
}function fmtDateTime(obj){//时间格式化为YY-MM-DD HH:MM:SS;
    if(!obj) return "";
    var date =  new Date(obj);
    var y = date.getFullYear();
    var m = "0"+(date.getMonth()+1);
    var d = "0"+date.getDate();
    var h = "0"+date.getHours();
    var minutes = "0"+date.getMinutes();
    var s = "0"+date.getSeconds();
    return y+"-"+m.substring(m.length-2,m.length)+"-"+d.substring(d.length-2,d.length)+" "+h.substring(h.length-2,h.length)+":"+minutes.substring(minutes.length-2,minutes.length)+":"+s.substring(s.length-2,s.length);
}

//统一控制字符串的长度
function initStrLong() {
    if($('.flong').length){
        $.each($('.flong'),function(idx,val){
            var l = parseInt($(val).attr('data-flong'));
            if($(val).text().trim().length > l){
                $(val).attr('title',$(val).text());
                $(val).text($(val).text().substr(0,l)+'...');
            }
        })
    }
}