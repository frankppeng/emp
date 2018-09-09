<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="e"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>个人资料</title>

		<link href="css/admin.css" rel="stylesheet" type="text/css">
		<link href="css/amazeui.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="css/index.css" />
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/wangEditor.css" />
		<link href="css/personal.css" rel="stylesheet" type="text/css">
		<link href="css/infstyle.css" rel="stylesheet" type="text/css">
		<script src="css/jquery.min.js" type="text/javascript"></script>
		<script src="css/amazeui.js" type="text/javascript"></script>
		<script type="text/javascript" src="js/select-widget-min.js" ></script>
		<script type="text/javascript" src="js/wangEditor.js" ></script>
		<script type="text/javascript" src="js/wangEditor.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
	
		
		<style type="text/css">
			.fv{
				float: left;
			}
			.toolbar {
            border: 1px solid #ccc;
        }
        .text {
            border: 1px solid #ccc;
            height: 100px;
        }
        /*#imgheader{
        	position: absolute;
        	padding-left: 20px;
        }*/
		</style>
			
	</head>

	<body>
		<!--头 -->
		<header>
			<article>
				<div class="mt-logo">
					<!--顶部导航条 -->
					<div class="am-container header">
						
						<div class="nav white">
							<div class="logoBig">
								<li><img src="img/logo.png.png" /></li>
							</div>
							<h1 align="center"style="font-family: '宋体';font-size: 25px;padding-top: 20px;">优速快递值得信赖！</h1>
						</div>
						
						</div>

						<!--悬浮搜索框-->


						<div class="clear"></div>
					</div>
				</div>
			</article>
		</header>
            <div class="nav-table">
					   <div class="long-title"><span class="all-goods">个人中心</span></div>
					   <div class="nav-cont">
							<ul>
								<li class="index"><a href="/exp/static/front/frontmain.jsp">首页</a></li>
                                <li class="qc"><a href="#">管理</a></li>
                                <li class="qc"><a href="#">消息</a></li>
                                <li class="qc"><a href="#">安全认证</a></li>
                                <li class="qc last"><a href="#">其他</a></li>
							</ul>
						    <!--<div class="nav-extra">
						    	<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的福利
						    	<i class="am-icon-angle-right" style="padding-left: 10px;"></i>
						    </div>-->
						</div>
			</div>
			<b class="line"></b>
		<div class="center">
			<div class="col-main">
				<div class="main-wrap">

					<div class="user-info"style="background-color: #FFFFCC;">
						<!--标题 
						<div class="am-cf am-padding" align="center">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">个人资料</strong> / <small>Personal&nbsp;information</small></div>
						</div>
						<hr/>

						<!--头像 -->
						 <div class="user-infoPic" >
							<div  class="user-left"style="width: 25%;height:100%;background-color: #0087E5;float: left;">
								<div class="left-top" style="width: 100%;height: 40%;">
									<div class="filePic"align="center" style="align-content: center;">
								<img id="imgheader" style="align-content: center;padding-left: 20px;" class="am-circle am-img-thumbnail" src="img/a0.jpg" alt="header"  />
								<!--<input type="file" class="inputPic" allowexts="gif,jpeg,jpg,png,bmp" accept="image/*">-->
							</div>
							<!-- <div style="width: 100%;height: 20%;float: left;">
									<button id="mybutton" type="file" onclick="updata()">更换头像</button>
									<button id="btn" type="save" style="float: right;"onclick="save()" >保存</button>
									</div> -->
								</div>
								<div class="left-low" style="width: 100%;height: 60%;background-color: papayawhip;">
										<div class="fv"style="font-family: '宋体';font-size: 20px;">个性签名：
										<div id="div1" class="text">我就是我 </div>
										<button class="btn  btn-info" data-toggle="modal" data-target="#2myModal">
  											修改
										</button>
										<div class="modal fade" id="2myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
															&times;
															</button>
														
														</div>
														<div class="modal-body">
															
															<!-- 添加富文本编译器-->
														
															<div  id="div1" style="padding: 5px 0; color:black">
																
															</div>
   
 												        	   <button id="btn2" class="btn btn-default" data-dismiss="modal">确定</button>
															
														</div>
													</div><!-- /.modal-content -->
												</div><!-- /.modal -->
											</div>
								</div>
								</div>
							</div>
							<div class="user-right" style="width: 70%;height:100%;float: right;">
								<div class="info-m"align="center">
								<div class="fv" >
								<table class="table"  style="font-size: 25px; font-family: '微软雅黑';">
							<!--thead style="text-align: center">
								<tr class="tableHead">
								</tr>
							</thead>-->
							<e:set var="session_value" value='<%=session.getAttribute("frontlogin")%>' />
							<tbody >
								<tr>
									<th style="vertical-align:middle ;font-size: 20px;">用户姓名：</th>
									<td style="vertical-align:middle ;font-size: 20px;">${session_value.name}</td>
								</tr>

								<tr>
									<th style="vertical-align:middle ;font-size: 20px;">账号：</th>
									<td style="vertical-align:middle ;font-size: 20px;">${session_value.account}</td>
								</tr>

								<tr>
									<th style="vertical-align:middle ;font-size: 20px;">电话：</th>
									<td style="vertical-align:middle ;font-size: 20px;"><div id="telphone"></div>
										<button class="btn btn-info " data-toggle="modal" data-target="#myModal" disaabled="false"  id="rz1">
  											认证手机号
										</button>
										<!--
                                        	作者：1131547578@qq.com
                                        	时间：2017-08-31
                                        	描述：弹出静态框
                                        -->
										<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
															&times;
															</button>
														
														</div>
														<div class="modal-body">
															 <input type="text"style="width: 200px;height: 30px;" id="tel"/>
															    请输入手机号&nbsp;<button type="button" onclick="tel()" >&nbsp;&nbsp;确&nbsp;定&nbsp;</button>
															  <div><input type="text"style="width: 200px;height: 30px;" id="code"/>
															    请输入验证码！
															   </div>
														</div>
														<div class="modal-footer">
															
															<button type="button" class="btn btn-default"  onclick="code()" disabled="true" id="btn1">
															确认
															</button>
														</div>
													</div><!-- /.modal-content -->
												</div><!-- /.modal -->
											</div>
									</td>
								</tr>
								<tr>
								<th style="vertical-align:middle ;font-size: 20px;">身份证号&nbsp;：</th>
								    <td style="vertical-align:middle ;font-size: 20px;">${session_value.idcard}</td>
								</tr>
								<tr>
									<th style="vertical-align:middle ;font-size: 20px;">性别：</th>
									<td style="vertical-align:middle ;font-size: 20px;">${session_value.sex}</td>
								</tr>
								<tr>
									<th style="vertical-align:middle ;font-size: 20px;">地址：</th>
									<td style="vertical-align:middle ;font-size: 20px;">${session_value.addressid}</td>
								</tr>
								<tr>
									<th style="vertical-align:middle ;font-size: 20px;">邮箱：</th>
									<td style="vertical-align:middle ;font-size: 20px;"><div id="emaill"></div>
									<button class="btn btn-info" data-toggle="modal" data-target="#1myModal" disaabled="false"  id="rz2"><!-- disaabled="false"  id="rz2" -->
  											激活邮箱
										</button>
										<div class="modal fade" id="1myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
															&times;
															</button>
														
														</div>
														<div class="modal-body">
															 &nbsp;&nbsp;&nbsp;邮&nbsp;箱：<input type="text"style="width: 200px;height: 30px;" id="email"/><!-- id="email" -->
																	<button type="button" onclick="send()">&nbsp;&nbsp;发&nbsp;送&nbsp;</button>		<!-- onclick="send()" -->													   
															  <div>验证码：<input type="text"style="width: 200px;height: 30px;display: none;" id="ecode"/>
															    请输入验证码！
															   </div>
														</div>
														<div class="modal-footer">
															
															<button type="button" class="btn btn-default"   disabled="true" id="btn9" onclick="email()"> <!--onclick="eamil()" disabled="true" id="btn2" -->
															确认
															</button>
														</div>
													</div><!-- /.modal-content -->
												</div><!-- /.modal -->
											</div>
									
									</td>
								</tr>
								<tr>
									<th style="vertical-align:middle ;font-size: 20px;">会员等级：</th>
									<td style="vertical-align:middle ;font-size: 20px;">钻石会员</td>
								</tr>
									<tr >
									<th style="vertical-align:middle ;font-size: 20px;">账号安全：</th>
									<td style="vertical-align:middle ;font-size: 20px;">90</td>
								</tr>
								
							</tbody>
						</table>
						</div>
							</div>
							</div>
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
						<a href="#">个人中心</a>
					</li>
					<li class="person">
						<a href="#">个人资料</a>
						<ul>
							<li class="active"> <a href="information.jsp">个人信息</a></li>
							<li> <a href="#">安全设置</a></li>
							<li> <a href="#">收货地址</a></li>
						</ul>
					</li>
					<li class="person">
						<a href="#">我的记录</a>
						<ul>
							<li><a href="#">寄件记录</a></li>
							<li> <a href="#">收件记录</a></li>
						</ul>
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
						<a href="#">我的足迹</a>
						<ul>
							<li> <a href="#">收藏</a></li>
							<li> <a href="#">足迹</a></li>
							<li> <a href="#">快递评价</a></li>
							<li> <a href="#">未读消息</a></li>
						</ul>
					</li>

				</ul>

			</aside>
			<aside class="menu">
				<ul>
					<li class="person">
						<a href="#">个人中心</a>
					</li>
				</ul>
				</aside>
		</div>

	</body>
	 <script type="text/javascript">
        var E = window.wangEditor
        /*var editor1 = new E('#div1', '#div2')  // 两个参数也可以传入 elem 对象，class 选择器
        editor1.create()*/
      var editor = new E('#div1')
    
        editor.create()
     document.getElementById('btn2').addEventListener('click', function () {
        // 读取 text
        //alert($("#div1").text())
        document.getElementById('div1').innerHTML =editor.txt.text();
        //alert(editor.txt.text())
    }, false)
		function tel(){
			$(function(){
	    	    $.ajax({
        			url:'/exp/duanxin',
        			type:'POST',
        			data:{'tel':$('#tel').val(), },
        			success:function(data){
        				var data = eval('(' + data + ')');
        				if (data.code==200){
        					alert("发送成功")
        					$("#btn1").attr("disabled",false)
                        }else{
                            alert("请输入正确的手机号码");  // reload the user data
                        }
    					
        			}
        		});
			})
			}
        function code(){
			$(function(){
	    	    $.ajax({
        			url:'/exp/yanzheng',
        			type:'POST',
        			data:{'tel':$('#tel').val(),
        				  'code':$('#code').val(), },
        			success:function(data){
        				var data = eval('(' + data + ')');
        				if (data.code==200){
        					alert("验证码正确,已绑定手机");
        					document.getElementById('telphone').innerHTML =$('#tel').val();
        					
                        }else {
                            alert("验证码错误!");  // reload the user data
                        }
        			}
        		});
			})
			}
       function send(){
			$(function(){
	    	    $.ajax({
        			url:'/exp/emailsend',
        			type:'POST',
        			data:{'email':$('#email').val() },
        			success:function(data){
        				var data = eval('(' + data + ')');
        				if (data.code==200){
        					alert("邮箱发送成功");
        					$("#btn9").attr("disabled",false)
                        }else {
                            alert("该邮箱不存在!");  // reload the user data
                        }
    					
        			}
        		});
			})
			}
       function email(){
			$(function(){
	    	    $.ajax({
        			url:'/exp/validemail',
        			type:'POST',
        			data:{'ecode':$('#ecode').val() },
        			success:function(data){
        				var data = eval('(' + data + ')');
        				if (data.code==200){
        					alert("邮箱绑定成功");
        					document.getElementById('emaill').innerHTML =$('#email').val();
        					
                        }else {
                            alert("邮箱绑定失败!");  // reload the user data
                        }
    					
        			}
        		});
			})
			}
       
       
       
             
        
    </script>
</html>