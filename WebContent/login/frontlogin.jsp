<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html> 
<html lang="en"> 
<head> 
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <title>登录界面</title> 
    <link href="/exp/plugin/front/css/base2.css" rel="stylesheet">
    <link href="/exp/plugin/front/css/login.css" rel="stylesheet">
     <link href="/exp/plugin/jsp/css/slide-unlock.css" rel="stylesheet">
 <style type="text/css">
 	img{
 		position: absolute;
 		padding-left: 200px;
 		padding-top: 50px;
 		width: 400px;
 		height: 400px;
 	}
  #gezilogo{
  	position: absolute;
  	padding-left: 180px;
  	width: 70px;
  	height: 70px;
  	padding-top:0;
  }
  
 </style>
 <script src="/exp/plugin/front/js/jquery-3.2.1.min.js"></script>
</head> 
<body>
	<div class="login-hd">
		<div class="left-bg"></div>
		<div class="right-bg"></div>
		<div class="hd-inner">
			<span class="logo"><img alt="logo" src="/exp/plugin/front/img/gezi.png" id="gezilogo" onClick="javascript:window.location='/exp/static/front/frontmain.jsp'"></span>
			<span class="split"></span>
			<span class="sys-name" onClick="javascript:window.location='/exp/static/front/frontmain.jsp'">优速登录</span>
		</div>
	</div>
	<div class="login-bd">
		<img alt="左图片"src="/exp/plugin/front/img/deliver.jpg"/>
		<div class="bd-inner">
			<div class="inner-wrap"> 
				<div class="lg-zone">
					<div class="lg-box">
						<div class="lg-label"><h4>用户登录</h4></div>
						<form action="/exp/frontlogin" method="post">
							<div class="lg-username input-item clearfix">
								<i class="iconfont">&#xe60d;</i>
								<input type="text" id="account" name="account" placeholder="账号">
							</div>
							<div class="lg-password input-item clearfix">
								<i class="iconfont">&#xe634;</i>
								<input type="password" id="password" name="password" placeholder="请输入密码">
							</div>
							 <div id="slider" style="margin:0px auto">
						    <div id="slider_bg"></div>
						    <span id="label"></span> <span id="labelTip">拖动滑块验证</span> </div>
							<div class="tips clearfix">
								<label><input type="checkbox" checked="checked">记住用户名</label>
								<a href="javascript:window.location='/exp/static/front/register.html'" class="register">立即注册</a>
								<a href="javascript:;" class="forget-pwd">忘记密码？</a>
							</div>
							<div class="enter">
								<a href="javascript:void(0)" class="purchaser" onClick="login()" id="btn" disabled="true">登录</a>
								<a href="javascript:;" class="supplier" onClick="javascript:window.location='/exp/static/front/register.html'">注册</a>
							</div>
						</form>
					</div>
				</div>
				<div class="lg-poster"></div>
			</div>
		</div>
	</div>
	<div class="login-ft">
		<div class="ft-inner">
			<div class="about-us">
				<a href="javascript:;">关于我们</a>
				<a href="javascript:;">法律声明</a>
				<a href="javascript:;">服务条款</a>
				<a href="javascript:;">联系方式</a>
			</div>
			<div class="address">地址：北京北京市大兴区亦庄经济开发区&nbsp;邮编：000000&nbsp;&nbsp;Copyright&nbsp;©&nbsp;2015&nbsp;-&nbsp;2017&nbsp;</div>
			<div class="other-info">建议使用IE8及以上版本浏览器&nbsp;京ICP备&nbsp;8888888号&nbsp;E-mail：yousu@163.com</div>
		</div>
	</div>
	
	<script src="/exp/plugin/jsp/js/jquery-1.12.1.min.js"></script> 
	<script src="/exp/plugin/jsp/js/jquery.slideunlock.js"></script> 
	<script type="text/javascript">
		function login(){
			$(function(){
	    	    $.ajax({
        			url:'/exp/front/login.jhtml',
        			type:'POST',
        			data:{'account':$('#account').val(),
        				  'password':$('#password').val()},
        			success:function(data){
        				if (data.code==200){
        					window.location.href="/exp/static/front/frontmain.jsp";
                        }else{
                            alert("登陆失败");  // reload the user data
                        }
        			}
        		});
			})
		}
		
		$(function () {
	        var slider = new SliderUnlock("#slider",{
					successLabelTip : "验证成功"	
				},function(){
					$("#btn").attr("disabled", false); 
	        	});
	        slider.init();
	    })
		
	</script>
</body> 
</html>
