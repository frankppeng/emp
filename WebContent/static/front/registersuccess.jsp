<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*" import="com.exp.modle.Client" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="en-US">

	<head>
		<title>register页面</title>
		<meta charset="UTF-8">
		<meta name="keywords">
		<meta name="description">
		<link type="text/css" href="/exp/plugin/front/themes/css/v3/reset.css" rel="stylesheet">
		<link type="text/css" href="/exp/plugin/front/themes/css/v3/public.css" rel="stylesheet">
		<link type="text/css" href="/exp/plugin/front/themes/css/v3/register.css" rel="stylesheet">
		<link rel="shortcut icon" href="favicon.ico" />
		<script src="/exp/plugin/front/themes/js/jquery.min.js" type="text/javascript"></script>
		<script src="/exp/plugin/front/themes/js/jquery.form.js" type="text/javascript"></script>
		<script src="/exp/plugin/front/themes/js/json.parse.js" type="text/javascript"></script>

		<style type="text/css">
			.input_div span {
				background: #FFF;
			}
			
			.header {
				background-color: pink;
			}
			
			.register img {
				position: absolute;
				padding-left: 200px;
				padding-top: 0;
				width: 100px;
				height: 100px;
			}
			
			.font {
				position: absolute;
				font-family: "宋体";
				font-size: 26px;
				padding-left: 300px;
			}
			
			.register1 img {
				position: absolute;
				padding-left: 0;
				width: 80px;
				height: 80px;
			}
			
			.table {
				width: 500px;
				height: 100px;
			}
			
			.font1 {
				position: absolute;
				font-family: "宋体";
				font-size: 26px;
				padding-left: 100px;
				padding-top: 20px;
			}
		</style>

	</head>

	<body>
		<div id="header">
			<div class="header">
				<div class="register">
					<img alt="注册" src="/exp/plugin/front/themes/images/gezi.png">
					<span class="split"></span>
					<span class="font">优速注册</span>

				</div>

				<a class="png_bg" href="/exp/static/front/frontmain.jsp">返回主页</a>
			</div>
		</div>

		<div class="register_content">

			<ul class="step_ul step1 clear">
				<li class="li1">02、注册成功</li>

			</ul>

			<form name="registerForm" id='registerForm' style="padding:60px 40px 88px 40px;font-family:Microsoft Yahei">
				<table class="table" style="font-family: '宋体';font-size: 20px;padding-left: 100px;" border="1px">
					<tbody>
						<tr>
							<th style="vertical-align:middle">用户姓名</th>
							<td>${requestScope.client.name }</td>
						</tr>
						<tr>
							<th style="vertical-align:middle">账号</th>
							<td>${requestScope.client.account }</td>
						</tr>
						<tr>
							<th style="vertical-align:middle">密码</th>
							<td>${requestScope.client.pass }</td>
						</tr>
						<tr>
							<th style="vertical-align:middle">电话</th>
							<td>${requestScope.client.tel }</td>
						</tr>
						<tr>
							<th style="vertical-align:middle">身份证号</th>
							<td>${requestScope.client.idcard }</td>
						</tr>
						<tr>
							<th style="vertical-align:middle">性别</th>
							<td>${requestScope.client.sex }</td>
						</tr>

					</tbody>
				</table>
				<div>&emsp;</div>
				<div>&emsp;</div>

			</form>

			<div class="reg_login">
				<p>已有帐号？</p>
				<a class="btn2" href="/exp/login/frontlogin.jsp">登录</a>
			</div>
			<div class="bg"></div>
		</div>

		<!-- footer start -->
		<div id="footer" class="clear">
			<div class="register1">
				<img alt="注册" src="/exp/plugin/front/themes/images/gezi.png">
				<span class="font1">优速快递官网</span>

			</div>
			<div class="friendLink clear">
				<a href="#" target="_blank" title="隐私政策" rel="nofollow">隐私政策</a>
				<a href="#" target="_blank" rel="nofollow">服务条款</a>
				<a href="#" target="_blank" rel="nofollow">关于我们</a>
				<a href="#" target="_blank" rel="nofollow">合作咨询</a>
				<a href="#" target="_blank" rel="nofollow">联系我们</a>
				<a href="#" target="_blank" rel="nofollow">友情链接</a>
			</div>
			<p>北京市大兴区亦庄经济开发区</p>
			<div class="weixin">
				<img src="/exp/plugin/front/themes/images/erwei.jpg" alt="二维码" id="erweima" />
				<h3>关注官网微信</h3>
			</div>
		</div>

		</script>
	</body>

</html>

<html lang="en" class="app js no-touch no-android chrome no-firefox no-iemobile no-ie no-ie10 no-ie11 no-ios no-ios7 ipad">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Google Chrome Frame也可以让IE用上Chrome的引擎: -->
	<meta http-equiv="X-UA-Compatible" content="IE=edge;chrome=1">
	<link href="/favicon.ico" type="image/x-icon" rel=icon>
	<link href="/favicon.ico" type="image/x-icon" rel="shortcut icon">
	<meta name="renderer" content="webkit">
	<title>登录－NumberOne管理系统</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/min.css">
	<link rel="stylesheet" href="css/login.css">
	<script src="js/jquery/jquery.js"></script>
	<script src="js/layer.js"></script>
	<link href="css/css.css" rel="stylesheet" type="text/css">
	<!--[if lt IE 9]> 
	<script src="/js/jquery/ie/html5shiv.js"></script> 
	<script src="/js/jquery/ie/respond.min.js"></script>
<![endif]-->
</head>

<body onload="javascript:to_top()" style="background-image: url('/numberone-auth/admin_files/9.jpg');margin-top:0px;background-repeat:no-repeat;background-size: 100% auto;">
	<div id="loginbox" style="padding-top: 10%;">
		<form id="loginform" name="loginform" class="form-vertical" style="background-color: rgba(0, 0, 0, 0.5) !important; background: #000; filter: alpha(opacity = 50); *background: #000; *filter: alpha(opacity = 50); /*黑色透明背景结束*/ color: #FFF; bottom: 0px; right: 0px; border: 1px solid #000;" action="/numberone-auth/login.shtml" method="post">
			<div class="control-group normal_text">
				<table style="width: 100%">
					<tr>
						<td align="left"><img src="/numberone-auth/admin_files/logo_left.png" alt="Logo"></td>
						<td align="center" style="font-weight: bold;color: gray;">NumberOne管理系统</td>
						<td align="right"><img src="/numberone-auth/admin_files/logo_left.png" alt="Logo"></td>
					</tr>
				</table>

			</div>
			<div class="control-group">
				<div class="controls">
					<div class="main_input_box">
						<span class="add-on bg_ly" style="background: #28b779"><img
							src="/numberone-auth/admin_files/account_1.png"
							alt="请输入账号.."></span><input type="text" placeholder="username" name="username" value="admin" style="height: 32px; margin-bottom: 0px;" />
					</div>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<div class="main_input_box">
						<span class="add-on bg_ly"><img
							src="/numberone-auth/admin_files/lock_1.png"
							alt="请输入密码.."></span><input type="password" placeholder="password" name="password" value="123456" style="height: 32px; margin-bottom: 0px;" />
					</div>
				</div>
			</div>
			<div class="form-actions">
				<span class="pull-left" style="width: 33%"><a href="#"
					class="flip-link btn btn-info" id="to-recover">忘记密码？</a></span>
				<span class="pull-left" style="width: 33%"><a href="install.shtml"
					class="flip-link btn btn-danger" id="to-recover">一键初始化</a></span>
				<span class="pull-right"><a type="submit"
					href="javascript:checkUserForm()" class="btn btn-success">登&nbsp;&nbsp;录</a></span>
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

		function to_top() {
			if(window != top) {
				top.location.href = location.href;
			}
		}
		$(document).ready(function() {
			layer.open({
				type: 1,
				title: false ,//不显示标题栏
				closeBtn: false,
				area: '600px;',
				shade: 0.8,
				id: 'LAY_layuipro', //设定一个id，防止重复弹出
				resize: false,
				btn: ['前往官方店铺购买', '关闭'],
				btnAlign: 'c',
				moveType: 1 ,//拖拽模式，0或者1
				content: '<img src="http://numberone.360ifish.com/numberone.png"  alt="NumberOne专业开发" />',
				success: function(layero) {
					var btn = layero.find('.layui-layer-btn');
					btn.find('.layui-layer-btn0').attr({
						href: 'https://item.taobao.com/item.htm?id=538008716770',
						target: '_blank'
					});
					btn.find('.layui-layer-btn1').attr({
						href: 'https://item.taobao.com/item.htm?id=538008716770',
						target: '_blank'
					});
				}
			});
		});
	</script>
</body>

</html>