/**
	 * 因为localStorage可以跨多个窗口共享数据，而sessionStorage是单窗口共享数据。
	 * 而localStorage是关闭浏览器依然存在，不会被删除的。
	 * 而sessionStorage是关闭浏览器就消除了的。
	 * 故我这里间接的实现localStorage在关闭浏览器后失效的功能。
	 * 
	 */
$(function (){
	
	function BrowserIsReopen(){
		
		return document.cookie.indexOf("rsdf125w5s21d1_3g5v3b9t9y5f") < 0;
	}
	
	function FlagBrowserNotIsReopen(){
		document.cookie = "rsdf125w5s21d1_3g5v3b9t9y5f=0;path=/;";
	}
	
	var browserIsReopen = BrowserIsReopen();
	if(browserIsReopen){
		window.localStorage.clear();
		FlagBrowserNotIsReopen();
	}
});

/**
 *  消息js
 */

$(function (){

    var msgContentHaloder = {};
	//加载消息数量
	msgContentHaloder.loadMsgCount = function (){

		if(this.competeLoadMsgCountLock()){;
			msgContentHaloder.loadNotReadMsg(5, msgContentHaloder.saveGlobalMsgInfoAndHandlerMsg);
		} else {
			msgContentHaloder.getGlobalMsgInfoAndHandlerMsg();
		}
	}
	msgContentHaloder.competeLoadMsgCountLock = function (){
		
		var cur_window_flag = sessionStorage.getItem("cur_window_flag");
		if(!cur_window_flag){
			sessionStorage.setItem("cur_window_flag",1+Math.random());
			cur_window_flag = sessionStorage.getItem("cur_window_flag");
		}
		var msg_compete_lock = window.localStorage.getItem("msg_compete_lock");
		if(!msg_compete_lock){
			window.localStorage.setItem("msg_compete_lock",cur_window_flag);
			return true;
		}
		return msg_compete_lock == cur_window_flag;
	}
	msgContentHaloder.clearCompeteLoadMsgCountLock = function(){
		
		if(msgContentHaloder.competeLoadMsgCountLock){
			window.localStorage.removeItem("msg_compete_lock");
		}
	}
	msgContentHaloder.saveGlobalMsgInfoAndHandlerMsg = function (res){
		
		window.localStorage.setItem("msg_count_",JSON.stringify(res));
		msgContentHaloder.handlerMsg(res);
	}
	msgContentHaloder.getGlobalMsgInfoAndHandlerMsg = function (){
		
		var msg = window.localStorage.getItem("msg_count_");
		if(msg){
			var msgData = eval("("+msg+")");
			msgContentHaloder.handlerMsg(msgData);
		}
	}
	
	
	
	msgContentHaloder.handlerMsg = function (res){
		  if(res.data){
			  if(res.data.total=="0"){
				  $("#msgElement").css("display","none");
			  }else{
				  $("#msgElement").css("display","inline-block");
				  if(Number(res.data.total)<=99){
				  	$("#msgElement").text( res.data.total);
				  }else{
                      $("#msgElement").text( "99+");
				  }
			  };
			  msgContentHaloder.showMsgList(res.data);
		  }else{
              $("#msgElement").css("display","none");
		  }
	}
	
	msgContentHaloder.loadNotReadMsg = function (pageSize,success){
		if(!userId && userId != 0){
			msgContentHaloder.clearCompeteLoadMsgCountLock();
		}
		var data={
            "data": {
                "conditions":"all",
                    "userId": userId
            },
            "pageNo": 1,
                "pageSize": pageSize
        };
		ajaxHengyun({
			type: "POST",
			url:gateUrl+"/api/msgs/bbs/msg/getNotReadMsg",
			data:JSON.stringify(data),
			dataType: "json",
			contentType:"application/json",
		   success: success
		});
	}
	

	//展示消息列表
	msgContentHaloder.showMsgList = function (msgList){
        popoverHtml="";
		if(!msgList){
			msgList=[];
		}

		var popoverHtml="";
		if(msgList.list){
            popoverHtml+="<ul class='popoverCss'>"
			for(var i in msgList.list){
                popoverHtml+='<li onclick="getUrl(\''+msgList.list[i].recId+'\')">';
                popoverHtml+='<p class="ptitle" style="width: 300px;white-space: normal;" title="'+msgList.list[i].content+'">('+msgList.list[i].detailedTypeDesc+')'+ msgList.list[i].content+'</p>';
                popoverHtml+='<p class="clearfix"><span class="pull-left">'+ msgList.list[i].createTime+'</span><span class="pull-right">'+ msgList.list[i].appName+'</span></p>';
            	popoverHtml+="</li>";
			};
            popoverHtml+='<li style="text-align: center"><a href="'+gateUrl+'/gxqpt-center/admin/home?type=all" target="_blank" style="display: inline-block; width: 100%">查看全部消息</a></li>';
            popoverHtml+="</ul>";
            if(msgList.list.length>0){
            	$("#conclusionShow").attr("data-content",popoverHtml);
			}else{
                $("#conclusionShow").attr("data-content","无未读消息");
			}
		};
	}
	
	//进入消息,去处理
	msgContentHaloder.toHandlerMsg = function(recvMsgId){
		
		ajaxHengyun({
			type: "GET",
			url:gateUrl+"/api/msgs/bbs/msg/flagReadedAndGetUrl",
			data:"recvMsgId="+recvMsgId,
			dataType: "json",
		    success: function (res){
		    	if(res.data && res.errcode == 0){
		    		window.open(res.data);
		    	}
		    }
		});
	}
	
	window.msgContentHaloder = msgContentHaloder;
	
	window.setInterval("msgContentHaloder.loadMsgCount()",60*1000);

	msgContentHaloder.loadMsgCount();
	window.onunload = function (){
		msgContentHaloder.clearCompeteLoadMsgCountLock();
	}
});
function getUrl(id){
	ajaxHengyun({
		type: 'get',
		url: gateUrl+'/api/msgs/bbs/msg/flagReadedAndGetUrl',
		data: {recvMsgId:id},
		success: function (res) {
			if (res.errmsg=="ok") {
				window.open(res.data);
			}
		}
	})
}
