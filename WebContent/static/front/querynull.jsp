<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d" %>
<!DOCTYPE html>
<html >
<head>
<meta  charset="utf-8" />
<title>query</title>

<link href="/exp/plugin/front/css/drop-down.css" rel="stylesheet" type="text/css"/>
<link href="/exp/plugin/front/css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/exp/plugin/front/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/exp/plugin/front/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="/exp/plugin/front/js/select-widget-min.js"></script>
<style type="text/css">
	#ul{
		position: absolute;
		font-family: "宋体";
		font-size: 30px;
		padding-left: 500px;
		padding-top: 100px;
	}
	.button {
    background-color: #1bbef9;
    color: white;
    padding: 15px 15px;
    text-align: center;
    text-decoration: none;
    border-radius: 12px;
  /*  display: inline-block;*/
    font-size: 15px;
    margin: 4px 2px;
   /* cursor: pointer;*/
}
</style>
</head>

<body>
<div class="top"></div>
<div class="header">
	<div class="nayouhuo_logo"><img src="/exp/plugin/front/img/logo.jpg" width="380" height="100" /></div>
	<div id="ul">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您的满意我们的宗旨!</div>
    <div class="search">
    	<form action="" method="get">
        	
            
            <div class="select_city">
            <div class="top_bg"></div>
       	  
                
            </div>
        </form>
    </div>
</div>
<div class="show_content" id="show">
	<div class="location"><span>北京-大兴区</span>
		<a href="/exp/static/front/frontmain.jsp" class="button">上一页</a>
	</div>
    <div class="show_list">
    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="400" align="center" valign="middle" class="title_bg">对不起</td>
          </tr>
          <tr>
            <td height="400" align="center">${requestScope.ordererror}</td>
          </tr>
           
        </table>
    </div>
</div>
<div class="cha-soucang"><a href="javascript:void(0);"><img src="/exp/plugin/front/img/iconfont-shoucang.png" /></a></div>
<div class="nyh_footer">
	<div class="nyh_footer_nav">
    	<a href="#" target="_blank">关于我们</a><a href="#" target="_blank">优速官网</a><a href="#" target="_blank">快速咨询</a><a href="#" target="_blank">优惠政策</a><a href="#" target="_blank">公司公告</a><a href="#" target="_blank">服务公告</a><a href="#" target="_blank">CPS广告联盟</a>

    </div>
    <div class="nyh_copyright">北京大兴区亦庄经济开发区，大族企业湾</div>
</div>
</body>
</html>