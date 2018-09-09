<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- Google Chrome Frame也可以让IE用上Chrome的引擎: -->
		<meta http-equiv="X-UA-Compatible" content="IE=edge;chrome=1">
		<link href="/favicon.ico" type="image/x-icon" rel=icon>
		<link href="/favicon.ico" type="image/x-icon" rel="shortcut icon">
		<meta name="renderer" content="webkit">
		<title>登录－优速后台管理系统</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet"	href="/exp/plugin/back/css/min.css">
		<link rel="stylesheet"	href="/exp/plugin/back/css/login.css">
		<script src="/exp/plugin/back/js/jquery/jquery.js"></script> 
		<script src="/exp/plugin/back/js/layer.js"></script>
		<link	href="/exp/plugin/back/css/css.css"	rel="stylesheet" type="text/css">
		<!--[if lt IE 9]> 
			<script src="/exp/plugin/back/js/jquery/ie/html5shiv.js"></script> 
			<script src="/exp/plugin/back/js/jquery/ie/respond.min.js"></script>
		<![endif]-->
	</head>
	<body onload="javascript:to_top()" 
		style="background-image: url('/exp/plugin/back/img/9.jpg');margin-top:0px;background-repeat:no-repeat;background-size: 100% auto;">
		<iframe id="fancybox-frame" name="fancybox-frame1504008702162" frameborder="0" scrolling="no" hspace="0"  src="http://i.tianqi.com/index.php?c=code&a=getcode&id=42&h=54&w=214"></iframe>
		<div id="loginbox" style="padding-top: 10%;">
			<form id="loginform" name="loginform" class="form-vertical"
			style="background-color: rgba(0, 0, 0, 0.5) !important; background: #000; filter: alpha(opacity = 50); 
			*background: #000; *filter: alpha(opacity = 50); /*黑色透明背景结束*/ 
			color: #FFF; bottom: 0px; right: 0px; border: 1px solid #000;"
			action="/exp/back/backlogin.jhtml"
			method="post">
				<div class="control-group normal_text">
					<table style="width: 100%">
						<tr>
							<td align="left"><img src="/exp/plugin/back/img/logo_left.png" alt="Logo"></td>
							<td align="center" style="font-weight: bold;color: gray;">欢迎登陆优速快递公司后台</td>
							<td align="right"><img src="/exp/plugin/back/img/logo_left.png" alt="Logo"></td>
						</tr>
					</table>
	
				</div>
				<div class="control-group">
					<div class="controls">
						<div class="main_input_box">
							<span class="add-on bg_ly" style="background: #28b779"><img src="/exp/plugin/back/img/account_1.png"  alt="请输入账号.."></span>
							<input type="text" placeholder="username" name="name" value="" style="height: 32px; margin-bottom: 0px;"/>
						</div>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<div class="main_input_box">
							<span class="add-on bg_ly"> <img src="/exp/plugin/back/img/lock_1.png" alt="请输入密码.."> </span>
							<input type="password" placeholder="password" name="password" value="" style="height: 32px; margin-bottom: 0px;"/>
						</div>
					</div>
				</div>				
				<div class="form-actions">
				<span class="pull-left">
	            <%
					String msg = (String) request.getAttribute("backloginerror");
					if(msg != null){
					%>
						<p>
						<%=msg %>
						</p>
					<%								
					}
				%>
	            </span>
				<span class="pull-right">
						 <input type="submit" href="javascript:void(0)" class="btn btn-success" value="login">
					</input></span>
				</div>
			</form>
		</div>
		
		
		<script type="text/javascript">
		
			/* if ("" != "") {
				alert("");
			}; */
			function checkUserForm() {
				document.loginform.submit();
			}

			function to_top(){
				if(window != top){
			        top.location.href=location.href;
			    }
			}
			
		</script>
	</body>
</html>