<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>订单提交成功</title>

		<link href="/exp/plugin/front/css/admin.css" rel="stylesheet" type="text/css">
		<link href="/exp/plugin/front/css/amazeui.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" href="/exp/plugin/front/css/index.css" />
		<link href="/exp/plugin/front/css/personal.css" rel="stylesheet" type="text/css">
		<link href="/exp/plugin/front/css/infstyle.css" rel="stylesheet" type="text/css">
		<script src="/exp/plugin/front/css/jquery.min.js" type="text/javascript"></script>
		<script src="/exp/plugin/front/css/amazeui.js" type="text/javascript"></script>
			
	</head>

	<body>
		<!--头 -->
		<header>
		</header>
            <div class="nav-table">
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
					   <div class="nav-cont">
							<ul>
								<li class="index"><a href="/exp/static/front/frontmain.jsp">首页</a></li>
                                <li class="qc"><a href="#">寄件</a></li>
                                <li class="qc"><a href="#">收件</a></li>
                                <li class="qc"><a href="#">记录</a></li>
                                <li class="qc last"><a href="#">优惠券</a></li>
							</ul>
						    <!--<div class="nav-extra">
						    	<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的足迹
						    	<i class="am-icon-angle-right" style="padding-left: 10px;"></i>
						    </div>-->
						</div>
			</div>
			<b class="line"></b>
		<div class="center">
			<div class="col-main">
				<div class="main-wrap">

					<div class="user-info">
						<!--标题 -->
					  <!--<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">提交成功！</strong></div>
						</div>-->
						<hr/>

					
						<div class="user-infoPic">

							<div class="info-m"align="center">
								<h1 class="font" style="font-family: '宋体';font-size: 25px;">&nbsp;&nbsp;&nbsp;恭喜您订单提交成功!</h1>
       							<div>&emsp;</div>
       							<h2 class="font"style="font-family: '宋体';font-size: 18px;"> 我们会尽快为您安排快递员进行派送！请注意物流信息</h2>
								
							</div>
						</div>
						<!--个人信息 -->
						<div class="info-main">
						<d:set var="cour" value='<%=session.getAttribute("cour")%>' />
						<d:set var="order" value='<%=session.getAttribute("order")%>' />
						<d:choose>
							<d:when test="${cour.account != null}">
		 						<div><h2 align="center">您的快递编号为：${order.id}</h2></div>	 
								<div><h2 align="center">快递员：${cour.account}号${cour.name}将为您服务，请耐心等待</h2></div>
								<div><h2 align="center">联系电话：${cour.tel}</h2></div>
								<div><h2 align="center">请您保持电话畅通</h2></div>
							</d:when>
							<d:otherwise>
							</d:otherwise>
						</d:choose>
						
						
 
 							<h2 align="center">	
								<img alt="deliver" align="center" src="/exp/plugin/front/img/client.jpg" width="40%" height="300px"/>
							</h2>
							<form class="am-form am-form-horizontal">
								
								<div class="info-btn">
									<div class="am-btn am-btn-danger" id = "info-save"><a href="/exp/static/front/frontmain.jsp">返回</div>
									<div class="am-btn am-btn-danger" id = "info"><a href="/exp/person/pay2.jsp">立即支付</a></div>
								</div>
							</form>
						</div>

					</div>

				</div>
				<!--底部-->
				<div class="nyh_footer">
				<div class="nyh_footer_nav">
    			<a href="#" target="_blank">关于我们</a><a href="#" target="_blank">优速官网</a><a href="#" target="_blank">快速咨询</a><a href="#" target="_blank">优惠政策</a><a href="#" target="_blank">公司公告</a><a href="#" target="_blank">服务公告</a><a href="#" target="_blank">CPS广告联盟</a>

    		</div>
    		<div class="nyh_copyright">北京大兴区亦庄经济开发区，大族企业湾</div>
   		 </div>
			</div>

			<aside class="menu">
				<ul>
					<li class="person">
						<a href="information.html">个人中心</a>
					</li>
					
					<li class="person">
						<a href="#">我的资产</a>
						<ul>
							<li> <a href="#">优惠券 </a></li>
							<li> <a href="#">红包</a></li>
							<li> <a href="#">账单明细</a></li>
						</ul>
					</li>

					<li class="person">
						<a href="#">我的快递</a>
						<ul>
							<li> <a href="#">历史</a></li>
							<li> <a href="#">足迹</a></li>
							<li> <a href="#">评价</a></li>
							<li> <a href="#">消息</a></li>
						</ul>
					</li>

				</ul>

			</aside>
		</div>

	</body>

</html>