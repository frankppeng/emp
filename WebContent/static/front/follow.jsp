<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="/exp/plugin/back/bootstrap/css/bootstrap.css" />
    <script type="text/javascript" src="/exp/plugin/back/bootstrap/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="/exp/plugin/front/js/jquery.js" ></script>
    <title>follow</title>
    <style>
        #ordertrack td {
            vertical-align: top;
        }
 
        table {
            empty-cells: show;
        }
 
        #odlist, #orderstate, #process, #ordertrack, #orderinfo {
            color: #333;
        }
 
 
        body {
            color: #666;
            font: 12px/150% Arial,Verdana,"宋体";
        }
 
        #mohe-kuaidi_new .mh-icon-new {
            background-position: 0 -58px;
            height: 18px;
            left: -20px;
            margin-left: -41px;
            margin-top: -9px;
            position: absolute;
            top: 1.5em;
            width: 41px;
        }
 
        #mohe-kuaidi_new .mh-icon {
            background: url("http://p9.qhimg.com/d/inn/f2e20611/kuaidi_new.png") no-repeat scroll 0 0 rgba(0, 0, 0, 0);
        }
 
        h1, h2, h3, h4, h5, h6, input, textarea, select, cite, em, i, b, strong, th {
            font-size: 100%;
            font-style: normal;
        }
 
        #mohe-kuaidi_new .mh-list-wrap .mh-list li.first {
            color: #3eaf0e;
        }
 
        #mohe-kuaidi_new .mh-list-wrap .mh-list li {
            color: #666;
        }
 
        ol, ul, li{
        	position:absolute ;
            list-style: outside none none;
		     margin-left: 250px;
        }
 
        .result .res-list, .result-d .res-d-list {
            font-size: 13px;
            line-height: 20px;
        }
 
 
        body, th, td {
            font-family: arial;
            color: #333;
        }
        #myButtons2{
                	position: absolute;
                	top:100px;
                	left: 100px;
                }
        
    </style>
    <style class="firebugResetStyles" type="text/css" charset="utf-8">
        /* See license.txt for terms of usage */
        /** reset styling **/
        .firebugResetStyles {
            z-index: 2147483646   ;
            top: 0   ;
            left: 0   ;
            display: block   ;
            border: 0 none   ;
            margin: 0   ;
            padding: 0   ;
            outline: 0   ;
            min-width: 0   ;
            max-width: none   ;
            min-height: 0   ;
            max-height: none   ;
            position: fixed   ;
            transform: rotate(0deg)   ;
            transform-origin: 50% 50%   ;
            border-radius: 0   ;
            box-shadow: none   ;
            background: transparent none   ;
            pointer-events: none   ;
            white-space: normal   ;
        }
 
        style.firebugResetStyles {
            display: none   ;
        }
 
        .firebugBlockBackgroundColor {
            background-color: transparent   ;
        }
 
        .firebugResetStyles:before, .firebugResetStyles:after {
            content: ""   ;
        }
        /**actual styling to be modified by firebug theme**/
        .firebugCanvas {
            display: none   ;
        }
 
        /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
        .firebugLayoutBox {
            width: auto   ;
            position: static   ;
        }
 
        .firebugLayoutBoxOffset {
            opacity: 0.8   ;
            position: fixed   ;
        }
 
        .firebugLayoutLine {
            opacity: 0.4   ;
            background-color: #000000   ;
        }
 
        .firebugLayoutLineLeft, .firebugLayoutLineRight {
            width: 1px   ;
            height: 100%   ;
        }
 
        .firebugLayoutLineTop, .firebugLayoutLineBottom {
            width: 100%   ;
            height: 1px   ;
        }
 
        .firebugLayoutLineTop {
            margin-top: -1px   ;
            border-top: 1px solid #999999   ;
        }
 
        .firebugLayoutLineRight {
            border-right: 1px solid #999999   ;
        }
 
        .firebugLayoutLineBottom {
            border-bottom: 1px solid #999999   ;
        }
 
        .firebugLayoutLineLeft {
            margin-left: -1px   ;
            border-left: 1px solid #999999   ;
        }
 
        /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
        .firebugLayoutBoxParent {
            border-top: 0 none   ;
            border-right: 1px dashed #E00   ;
            border-bottom: 1px dashed #E00   ;
            border-left: 0 none   ;
            position: fixed   ;
            width: auto   ;
        }
 
        .firebugRuler {
            position: absolute   ;
        }
 
        . {
            top: -15px ;
            left: 0 ;
            width: 100% ;
            height: 14px ;
            background: url("data:image/png) repeat-x   ;
            border-top: 1px solid #BBBBBB ;
            border-right: 1px dashed #BBBBBB ;
            border-bottom: 1px solid #000000 ;
        }
 
        .firebugRulerV {
            top: 0 ;
            left: -15px ;
            width: 14px ;
            height: 100% ;
            background: url("data:image/png") repeat-y ;
            border-left: 1px solid #BBBBBB ;
            border-right: 1px solid #000000 ;
            border-bottom: 1px dashed #BBBBBB ;
        }
 
        .overflowRulerX > .firebugRulerV {
            left: 0 ;
        }
 
        .overflowRulerY > .firebugRulerH {
            top: 0 ;
        }
 
        /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
        .fbProxyElement {
            position: fixed ;
            pointer-events: auto;
        }
    </style>
</head>
<body id="list">
    <style>
    
    	/*body{
    		margin: 0;
    		padding: 0;
    		background-image: url(img/12.jpg);
    		width: 100%;
    		height: 700px;
    		
    	}*/
        /*#mohe-kuaidi_new ::-webkit-scrollbar {
            width: 10px;
        }
 
        #mohe-kuaidi_new ::-webkit-scrollbar-track-piece {
            background-color: #eee;
        }
 
        #mohe-kuaidi_new ::-webkit-scrollbar-thumb {
            background-color: #ccc;
            border: 1px solid #ccc;
        }*/
 
        #mohe-kuaidi_new .mh-wrap {
            margin: 6px 0;
        }
 
            #mohe-kuaidi_new .mh-wrap a {
                text-decoration: none;
            }
 
                #mohe-kuaidi_new .mh-wrap a:hover {
                    text-decoration: underline;
                }
 
        #mohe-kuaidi_new .mh-form-wrap {
            padding: 5px 15px;
        }
 
            #mohe-kuaidi_new .mh-form-wrap p {
                margin: 10px 0;
            }
 
                #mohe-kuaidi_new .mh-form-wrap p label {
                    margin-right: 10px;
                    vertical-align: middle;
                    padding: 6px 0;
                }
 
                #mohe-kuaidi_new .mh-form-wrap p input, #mohe-kuaidi_new .mh-form-wrap p select {
                    width: 186px;
                    line-height: normal;
                    border: 1px solid #ccc;
                    padding: 6px;
                    box-sizing: border-box;
                    margin: 0;
                }
 
                #mohe-kuaidi_new .mh-form-wrap p button {
                    width: 80px;
                    height: 28px;
                    border: 1px solid #ccc;
                    margin-left: 10px;
                    text-align: center;
                    color: #333;
                    font-family: "Microsoft Yahei";
                    font-size: 14px;
                    cursor: pointer;
                    background: #f7f7f7;
                    background: -moz-linear-gradient(top,#f7f7f7,#ececec);
                    background: -webkit-gradient(linear,left top,left bottom,color-stop(#f7f7f7),color-stop(#ececec));
                    background: -ms-linear-gradient(top,#f7f7f7,#ececec);
                    background: linear-gradient(to bottom,#f7f7f7,#ececec);
                    filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#f7f7f7',endColorstr='#ececec',GradientType=0);
                }
 
                    #mohe-kuaidi_new .mh-form-wrap p button:hover {
                        background: -moz-linear-gradient(top,#ececec,#f7f7f7);
                        background: -webkit-gradient(linear,left top,left bottom,color-stop(#ececec),color-stop(#f7f7f7));
                        background: -ms-linear-gradient(top,#ececec,#f7f7f7);
                        background: linear-gradient(to bottom,#ececec,#f7f7f7);
                        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ececec',endColorstr='#f7f7f7',GradientType=0);
                    }
 
                    #mohe-kuaidi_new .mh-form-wrap p button:active {
                        background: -moz-linear-gradient(top,#f3f3f3,#fff);
                        background: -webkit-gradient(linear,left top,left bottom,color-stop(#f3f3f3),color-stop(#fff));
                        background: -ms-linear-gradient(top,#f3f3f3,#fff);
                        background: linear-gradient(to bottom,#f3f3f3,#fff);
                        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#f3f3f3',endColorstr='#ffffff',GradientType=0);
                    }
 
            #mohe-kuaidi_new .mh-form-wrap form.mh-loading p button {
                position: relative;
                color: transparent;
                pointer-events: none;
            }
 
                #mohe-kuaidi_new .mh-form-wrap form.mh-loading p button::after {
                    background: url(http://p1.qhimg.com/d/inn/1b1cc057/loading_s.gif) no-repeat center;
                    content: '';
                    display: inline-block;
                    width: 4em;
                    height: 20px;
                    position: absolute;
                    left: 50%;
                    top: 50%;
                    margin-left: -2em;
                    margin-top: -10px;
                }
 
            #mohe-kuaidi_new .mh-form-wrap .mh-error {
                display: none;
                color: #c00;
            }
 
                #mohe-kuaidi_new .mh-form-wrap .mh-error label {
                    visibility: hidden;
                }
 
        #mohe-kuaidi_new .mh-list-wrap {
            max-height: 0;
            _height: 0;
            --overflow: hidden;
        }
 
            #mohe-kuaidi_new .mh-list-wrap.mh-unfold {
                max-height: 281px;
                _height: 281px;
            }
 
            #mohe-kuaidi_new .mh-list-wrap .mh-list {
                border-top: 1px solid #eee;
                margin: 0 15px;
                padding: 15px 0;
            }
 
                #mohe-kuaidi_new .mh-list-wrap .mh-list ul {
                    max-height: 255px;
                    _height: 255px;
                    padding-left: 75px;
                    padding-right: 20px;
                    --overflow: auto;
                    height: 626px;
                }
 
                #mohe-kuaidi_new .mh-list-wrap .mh-list li {
                    position: relative;
                    border-bottom: 1px solid #f5f5f5;
                    margin-bottom: 8px;
                    padding-bottom: 8px;
                    color: #666;
                }
 
                    #mohe-kuaidi_new .mh-list-wrap .mh-list li.first {
                        color: #3eaf0e;
                    }
 
                    #mohe-kuaidi_new .mh-list-wrap .mh-list li p {
                        line-height: 20px;
                    }
 
                    #mohe-kuaidi_new .mh-list-wrap .mh-list li .before {
                        position: absolute;
                        left: -13px;
                        top: 2.2em;
                        height: 82%;
                        width: 0;
                        border-left: 2px solid #ddd;
                    }
 
                    #mohe-kuaidi_new .mh-list-wrap .mh-list li .after {
                        position: absolute;
                        left: -16px;
                        top: 1.2em;
                        width: 8px;
                        height: 8px;
                        background: #ddd;
                        border-radius: 6px;
                    }
 
                    #mohe-kuaidi_new .mh-list-wrap .mh-list li.first .after {
                        background: #3eaf0e;
                    }
 
        #mohe-kuaidi_new .mh-kd-wrap {
            position: relative;
            border-top: 1px solid #eee;
            padding: 15px;
            padding-bottom: 25px;
            background: #fafafa;
        }
 
            #mohe-kuaidi_new .mh-kd-wrap li {
                display: none;
            }
 
                #mohe-kuaidi_new .mh-kd-wrap li.mh-selected {
                    display: block;
                }
 
            #mohe-kuaidi_new .mh-kd-wrap .mh-img-wrap {
                float: left;
                width: 50px;
                height: 50px;
                margin-right: 10px;
                overflow: hidden;
            }
 
                #mohe-kuaidi_new .mh-kd-wrap .mh-img-wrap img {
                    width: 50px;
                }
 
            #mohe-kuaidi_new .mh-kd-wrap .mh-info-wrap {
                font-size: 13px;
                margin-left: 60px;
            }
 
                #mohe-kuaidi_new .mh-kd-wrap .mh-info-wrap p {
                    margin-bottom: 8px;
                }
 
                #mohe-kuaidi_new .mh-kd-wrap .mh-info-wrap .mh-info-name {
                    font-family: "Microsoft Yahei";
                    font-size: 14px;
                }
 
                #mohe-kuaidi_new .mh-kd-wrap .mh-info-wrap .mh-info-link a {
                    text-decoration: none;
                    margin-right: 10px;
                    padding: 2px 10px;
                    border: 1px solid #ccc;
                    color: #333;
                }
 
                    #mohe-kuaidi_new .mh-kd-wrap .mh-info-wrap .mh-info-link a:hover {
                        background: white;
                    }
 
                    #mohe-kuaidi_new .mh-kd-wrap .mh-info-wrap .mh-info-link a:active {
                        background: -moz-linear-gradient(top,#f3f3f3,#fff);
                        background: -webkit-gradient(linear,left top,left bottom,color-stop(#f3f3f3),color-stop(#fff));
                        background: -ms-linear-gradient(top,#f3f3f3,#fff);
                        background: linear-gradient(to bottom,#f3f3f3,#fff);
                        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#f3f3f3',endColorstr='#ffffff',GradientType=0);
                    }
 
        #mohe-kuaidi_new .mh-slogan {
            position: absolute;
            right: 20px;
            bottom: 0;
            cursor: pointer;
        }
 
        #mohe-kuaidi_new .mh-slogan-hover {
            color: #3eaf0e;
        }
 
        #mohe-kuaidi_new .mh-slogan span {
            vertical-align: middle;
        }
 
        #mohe-kuaidi_new .mh-qrcode-wrap {
            position: absolute;
            right: 0;
            bottom: -1px;
            width: 96px;
            margin-right: -110px;
            border: 1px solid #d6d6d6;
            color: #999;
            padding: 6px;
            box-shadow: 0 1px 1px #efefef;
        }
 
        #mohe-kuaidi_new .mh-icon {
            background: url(http://p9.qhimg.com/d/inn/f2e20611/kuaidi_new.png) no-repeat 0 0;
        }
 
        #mohe-kuaidi_new .mh-icon-qr {
            background-position: 0 -17px;
            display: inline-block;
            *zoom: 1;
            width: 13px;
            height: 13px;
            vertical-align: middle;
            margin-left: 10px;
        }
 
        #mohe-kuaidi_new .mh-slogan-hover .mh-icon-qr {
            background-position: 0 0;
        }
 
        #mohe-kuaidi_new .mh-icon-t {
            position: absolute;
            left: -9px;
            bottom: 14px;
            width: 10px;
            height: 16px;
            background-position: 0 -34px;
            background-color: white;
        }
 
        #mohe-kuaidi_new .mh-icon-new {
            position: absolute;
            left: -20px;
            top: 1.5em;
            width: 41px;
            height: 18px;
            margin-left: -41px;
            margin-top: -9px;
            background-position: 0 -58px;
        }
 
        #mohe-kuaidi_new .mh-wrap .mb-search {
            text-decoration: underline;
            margin-left: 20px;
        }
 
            #mohe-kuaidi_new .mh-wrap .mb-search .mh-new {
                display: inline-block;
                width: 21px;
                height: 9px;
                margin: -1px 0 0 3px;
                background: url(http://p0.qhimg.com/t01a3bd62f6db66463c.png) no-repeat;
            }
 
        #mohe-kuaidi_new .mh-identcode {
            border-top: 1px solid #f5f5f5;
            padding: 10px 15px;
            display: none;
        }
 
            #mohe-kuaidi_new .mh-identcode .mh-img-wrap {
                float: left;
                width: 54px;
                height: 54px;
                padding: 6px;
                border: 1px solid #ccc;
                overflow: hidden;
            }
 
                #mohe-kuaidi_new .mh-identcode .mh-img-wrap img {
                    width: 54px;
                }
 
            #mohe-kuaidi_new .mh-identcode .mh-img-tip {
                margin-left: 78px;
            }
 
            #mohe-kuaidi_new .mh-identcode .mh-tip-txt {
                font-size: 13px;
                line-height: 38px;
                color: #666;
            }
 
            #mohe-kuaidi_new .mh-identcode .mh-btn-install {
                text-decoration: none;
                margin-right: 10px;
                padding: 2px 10px;
                border: 1px solid #ccc;
                color: #333;
            }
 
                #mohe-kuaidi_new .mh-identcode .mh-btn-install:hover {
                    text-decoration: none;
                }
                #number{
                	position: absolute;
                	top: 200px;
                	left: 100px;
                	font-family: "宋体";
                	font-size: 15px;
                }
                #list{
                	background-image: url(/exp/plugin/front/img/back.jpg);
                	background-size: 100%;
                }
                 #myButtons1{
                	position: absolute;
                	top: 300px;
                	left: 200px;
                }
                
    </style>
    
   <div data-mohe-type="kuaidi_new" class="g-mohe " id="mohe-kuaidi_new">
        <div id="mohe-kuaidi_new_nucom">
            <div class="mohe-wrap mh-wrap" >
                <div class="mh-cont mh-list-wrap mh-unfold"  >
                    <div class="mh-list" >
<!--                     	<div style="width: 40%;height: 100%;" id="number" >
                    		请输入订单号：<input id="in" type="text" class="form-control" style="width: 200px;height: 30px; color: rosybrown;" placeholder="订单号 " />                    	
                    	</div>
                    	<button  id="myButtons1" class="btn btn-primary">queiinf</button>
 -->                    	<div style="width: 50%;height: 100%;color: aquamarine;">
						    <ul id="ul">
						        <li class="first">
						            <span class="before"></span>
						            <span class="after">
						            	<i class="mh-icon mh-icon-new"></i>
						            </span>
						         </li>
						      <f:forEach items="${log}" var="top">
						        <li>
						            <p>时间：${top['log_date']}&nbsp地点：${top['log_address']}&nbsp${top['log_status']}</p>
						            <span class="before"></span>
						             <span class="after"></span>
						         </li>
						         </f:forEach>
						    </ul>
						   </div>
						  <a href="/exp/static/front/frontmain.jsp" id="myButtons2" class="btn btn-info btn-lg" role="button">返回首页</a>

						   
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
    	
		$("#myButtons1").click(function(){
			var val = $("#in").val();
			$.ajax({
				url : "/exp/front/logistics/query.jhtml",
				type : "POST",
				data : {orderId:val},
				success : function(data) {
					alert(data)
				}
			})
	});
    </script>
 </body>
</html>

