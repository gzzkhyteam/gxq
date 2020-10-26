<%@page import="org.jasig.cas.authentication.principal.Principal"%>
<%@page import="org.springframework.webflow.execution.RequestContext"%>
<%@page import="org.springframework.webflow.context.ExternalContextHolder"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
		
<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title></title>
    <link href="Content/Images/Default.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="Content/Scripts/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="Content/Scripts/layer/layer.js"></script>
    <script type="text/javascript">
        $(function () {
            setbgheight();
            $(window).resize(function () {
                setbgheight();
            });

            function setbgheight() {
                if ($(window).width() <= 1300) {
                    $('.mingbg').css('width', '1300px');
                } else {
                    $('.mingbg').css('width', '100%');
                }
                $('.mingbg').css('height', $(document).height()-3);
            }
        });
    </script>
    <style type="text/css">
    	.animated {
			-webkit-animation-duration:1.5s;
			animation-duration:1.5s;
			-webkit-animation-fill-mode:both;
			animation-fill-mode:both
		}
		.animated.infinite {
			-webkit-animation-iteration-count:infinite;
			animation-iteration-count:infinite
		}
    	@-webkit-keyframes fadeOutDown {
			0% {
			opacity:1;
			-webkit-transform:translateY(0);
			transform:translateY(0)
			}
			100% {
			opacity:0;
			-webkit-transform:translateY(13px);
			transform:translateY(13px)
			}
		}
		@keyframes fadeOutDown {
			0% {
			opacity:1;
			-webkit-transform:translateY(0);
			-ms-transform:translateY(0);
			transform:translateY(0)
			}
			100% {
			opacity:0;
			-webkit-transform:translateY(13x);
			-ms-transform:translateY(13px);
			transform:translateY(13px)
			}
		}
		@-webkit-keyframes rotate {
			0% {
			-webkit-transform:rotate(0);
			transform:rotate(0);
			}
			25% {
			-webkit-transform:rotate(90deg);
			transform:rotate(90deg);
			}
			50% {
			-webkit-transform:rotate(180deg);
			transform:rotate(180deg);
			}
			75% {
			-webkit-transform:rotate(270deg);
			transform:rotate(270deg);
			}
			100% {
			-webkit-transform:rotate(360deg);
			transform:rotate(360deg);
			}
		}
		@keyframes rotate {
			0% {
			-webkit-transform:rotate(0);
			transform:rotate(0);
			}
			25% {
			-webkit-transform:rotate(90deg);
			transform:rotate(90deg);
			}
			50% {
			-webkit-transform:rotate(180deg);
			transform:rotate(180deg);
			}
			75% {
			-webkit-transform:rotate(270deg);
			transform:rotate(270deg);
			}
			100% {
			-webkit-transform:rotate(360deg);
			transform:rotate(360deg);
			}
		}
        body { position: relative; background: #0d4262; }
        .mingbg { position: absolute; left: 0; top: 0; z-index: -1; height: 102%; }
        .maincontainer { }
            .maincontainer .header { margin-bottom: 0px; background: url(Content/Images/protal/protal_top.png) no-repeat 0 -15px; background-size: 100% 100%; height: 105px; }
                .maincontainer .header .logo { height: 80px; float: left; width: 50%; background: url(Content/Images/logo_qx.png) no-repeat 20px 10px; background-size: 380px; }
                .maincontainer .header .top_nav { float: left; width: 50%; }

        .top_nav ul { float: right; padding-top: 10px; }
            .top_nav ul li { float: left; width: 64px; margin-right: 5px; cursor: pointer; text-align:center; }
                .top_nav ul li img { width: 34px; }
                .top_nav ul li span { display: block; text-align: center; font-size: 12px; color: #49d9fe; }

        .mainbody .container { }
            .mainbody .container .cont { margin: 0 auto; background: url(Content/Images/protal/bg_kuang.png) no-repeat center; background-size: 100% 100%; width: 1300px; padding-bottom: 30px; }
            @media screen and (min-width: 1442px) {
			    .mainbody .container .cont { width: 93%; padding-bottom:10%}
			     .mainbody .container .cont .tp ul li { margin-bottom:20px; }
			}
                /* .mainbody .container .cont .tp { margin-bottom: 50px; } */
                    .mainbody .container .cont .tp ul { padding: 56px 120px 0 120px; }
                    @media screen and (min-width: 1442px) {
					    .mainbody .container .cont .tp ul { padding: 6% 120px 0 120px; }
					}
                        .mainbody .container .cont .tp ul li { width: 25%; float: left; height: 224px; position: relative; color: #fff; text-decoration: none; font-size: 18px; margin-top: 14px;}
                            .mainbody .container .cont .tp ul li a{width: 100%; height: 100%; display: inline-block; position: absolute; z-index: 999;}
                            .mainbody .container .cont .tp ul li .bgImg { width: 200px; height: 200px; background: url(Content/Images/protal/xz1_1.png) no-repeat center; display: block; line-height: 186px; text-align: center; margin:auto;}
                            .rotate { -moz-animation:rotate 5.4s linear infinite; -webkit-animation:rotate 5.4s linear infinite; animation:rotate 5.4s linear infinite; }
                            .mainbody .container .cont .tp ul li:hover .bgImg { width: 200px; height: 200px; background: url(Content/Images/protal/xz1_2.png) no-repeat center;}
                                .mainbody .container .cont .tp ul li:hover .tp_li_title { font-weight: bold; color: #49d9fe; cursor:pointer;}
                            .mainbody .container .cont .tp ul li .tp_li_title{ position: absolute; top: 90px; width: 100%; text-align: center;}
                            .mainbody .container .cont .tp ul li .shadow { background: url(Content/Images/protal/dh.png) no-repeat center; width:100%; margin-top:-72px; margin-left:-2px; height: 13px; -webkit-animation-name:fadeOutDown; animation-name:fadeOutDown }
                			.mainbody .container .cont .tp ul li .lineShadow { background: url(Content/Images/protal/xz02.png) no-repeat center; width:100%; margin-top:63px; margin-left:-4px; height: 15px; display:none;}
                .mainbody .container .cont .bm .section { padding: 0 160px; }
                    .mainbody .container .cont .bm .section .item { background: url(Content/Images/protal/22_link.png) no-repeat center; background-size: 265px; width: 33%; height: 100px; float: left; }
                        .mainbody .container .cont .bm .section .item a { background-position: 25% 22px; background-repeat: no-repeat; height: inherit; text-align: left; display: block; color: #fff; padding: 30px 18% 0 144px; font-size: 14px; text-decoration: none; background-size: 50px; }
                .mainbody .container .cont .bm a.ico1 { background-image: url(Content/Images/protal/ico_1_2.png); }
                .mainbody .container .cont .bm a.ico2 { background-image: url(Content/Images/protal/ico_2_2.png); }
                .mainbody .container .cont .bm a.ico3 { background-image: url(Content/Images/protal/ico_3_2.png); }
                .mainbody .container .cont .bm a.ico4 { background-image: url(Content/Images/protal/ico_4_2.png); }
                .mainbody .container .cont .bm a.ico5 { background-image: url(Content/Images/protal/ico_5_2.png); }
                .mainbody .container .cont .bm a.ico6 { background-image: url(Content/Images/protal/ico_6_2.png); }
                .mainbody .container .cont .bm a.ico7 { background-image: url(Content/Images/protal/ico_7_2.png); }
                .mainbody .container .cont .bm a.ico8 { background-image: url(Content/Images/protal/ico_8_2.png); }
                .mainbody .container .cont .bm a.ico9 { background-image: url(Content/Images/protal/ico_9_2.png); }

                .mainbody .container .cont .bm .section .item_hover { background: url(Content/Images/protal/22_hover.png) no-repeat center; background-size: 265px; }
                    .mainbody .container .cont .bm .section .item_hover a { color: #49d9fe; }
                .mainbody .container .cont .bm .item_hover a.ico1 { background-image: url(Content/Images/protal/ico_1_1.png); }
                .mainbody .container .cont .bm .item_hover a.ico2 { background-image: url(Content/Images/protal/ico_2_1.png); }
                .mainbody .container .cont .bm .item_hover a.ico3 { background-image: url(Content/Images/protal/ico_3_1.png); }
                .mainbody .container .cont .bm .item_hover a.ico4 { background-image: url(Content/Images/protal/ico_4_1.png); }
                .mainbody .container .cont .bm .item_hover a.ico5 { background-image: url(Content/Images/protal/ico_5_1.png); }
                .mainbody .container .cont .bm .item_hover a.ico6 { background-image: url(Content/Images/protal/ico_6_1.png); }
                .mainbody .container .cont .bm .item_hover a.ico7 { background-image: url(Content/Images/protal/ico_7_1.png); }
                .mainbody .container .cont .bm .item_hover a.ico8 { background-image: url(Content/Images/protal/ico_8_1.png); }
                .mainbody .container .cont .bm .item_hover a.ico9 { background-image: url(Content/Images/protal/ico_9_1.png); }

                .mainbody .container .cont .bm .section .item_disabled { background: url(Content/Images/protal/33_disable.png) no-repeat center; background-size: 265px; background-size: 265px; width: 33%; height: 100px; float: left; margin-bottom: 15px; }
                    .mainbody .container .cont .bm .section .item_disabled a { background-position: 25% 22px; background-repeat: no-repeat; height: inherit; text-align: left; display: block; color: #fff; padding: 30px 18% 0 144px; font-size: 14px; text-decoration: none; background-size: 50px; color: #ddd; cursor: default; }
                .mainbody .container .cont .bm .item_disabled a.ico1 { background-image: url(Content/Images/protal/ico_1_3.png); }
                .mainbody .container .cont .bm .item_disabled a.ico2 { background-image: url(Content/Images/protal/ico_2_3.png); }
                .mainbody .container .cont .bm .item_disabled a.ico3 { background-image: url(Content/Images/protal/ico_3_3.png); }
                .mainbody .container .cont .bm .item_disabled a.ico4 { background-image: url(Content/Images/protal/ico_4_3.png); }
                .mainbody .container .cont .bm .item_disabled a.ico5 { background-image: url(Content/Images/protal/ico_5_3.png); }
                .mainbody .container .cont .bm .item_disabled a.ico6 { background-image: url(Content/Images/protal/ico_6_3.png); }
                .mainbody .container .cont .bm .item_disabled a.ico7 { background-image: url(Content/Images/protal/ico_7_3.png); }
                .mainbody .container .cont .bm .item_disabled a.ico8 { background-image: url(Content/Images/protal/ico_8_3.png); }
                .mainbody .container .cont .bm .item_disabled a.ico9 { background-image: url(Content/Images/protal/ico_9_3.png); }

        .footer { color: #fff; text-align: center; line-height: 30px; padding: 20px 0 0 0; }
    </style>
</head>
<body>
    <div class="mingbg">
        <img src="Content/Images/protal/protal_bj.jpg" width="100%" height="100%" />
    </div>
    <div class="maincontainer clearfix">
        <div class="header clearfix">
            <div class="logo"></div>
            <div class="top_nav">
                <ul>
                    <!--<li>
                        <a href="1权力配置/1_04权力清单.html">
                            <img src="Content/Images/ico_1.png" />
                            <span>主页</span></a>
                    </li>-->
                    <li>
                        <img src="Content/Images/ico_2.png" />
                        <span style="letter-spacing: -1px;">${loginEmp.empName}</span>
                    </li>
                    <li>
                        <a href="logout">
                            <img src="Content/Images/ico_4.png" />
                            <span>退出</span>
                       </a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="mainbody">
            <div class="container">
                <div class="cont clearfix">
                    <div class="tp clearfix">
                        <ul>
                            <li>
                                <a href="http://192.168.1.35:9526/gydbdc-oa-webapp"></a>
                                <div class="bgImg rotate"></div>
                                <div class="tp_li_title">综合业务</div>
                                <div class="shadow"></div>
                                <div class="lineShadow"></div>
                            </li>
                            <li>
                                <a href="http://192.168.1.35:9526/gydbdc-dbdc-webapp"></a>
                                <div class="bgImg rotate"></div>
                                <div class="tp_li_title">督办督查</div>
                                <div class="shadow"></div>
                                <div class="lineShadow"></div>
                            </li>
                            <li>
                                <a href="#"></a>
                                <div class="bgImg rotate"></div>
                                <div class="tp_li_title">目标管理</div>
                                <div class="shadow"></div>
                                <div class="lineShadow"></div>
                            </li>
                            <li>
                                <a href="http://192.168.1.35:9526/gydbdc-tl-webapp"></a>
                                <div class="bgImg rotate"></div>
                                <div class="tp_li_title">数据铁笼</div>
                                <div class="shadow"></div>
                                <div class="lineShadow"></div>
                            </li>
                            <li>
                                <a href="http://192.168.1.35:9526/gydbdc-system-webapp"></a>
                                <div class="bgImg rotate"></div>
                                <div class="tp_li_title">用户中心</div>
                                <div class="shadow"></div>
                                <div class="lineShadow"></div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        /* $('.mainbody .container .cont .bm .section .item').mouseenter(function () {
            $(this).addClass('item_hover');
        }).mouseleave(function () {
            $(this).removeClass('item_hover');
        }); */
        $('.tp ul li').mouseenter(function () {
        	$(this).find(".bgImg").removeClass('rotate');
            $(this).find(".shadow").addClass('animated infinite');
            $(this).find(".lineShadow").css('display','block');
            
        }).mouseleave(function () {
        	$(this).find(".bgImg").addClass('rotate');
        	$(this).find(".shadow").removeClass('animated infinite');
        	$(this).find(".lineShadow").css('display','none');
        });
    </script>
</body>
</html>


