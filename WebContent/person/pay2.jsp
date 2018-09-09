<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta charset="utf-8">
    <meta http-equiv="Cache-Control" content="no-siteapp">
    <title>支付</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="css/iconfont.css" rel="stylesheet"/>
    <link href="css/common.css" rel="stylesheet"/>
    <link href="css/cart.css" rel="stylesheet"/>
</head>
<body class="graybg-theme">
    <!--头部-->
        <div class="topper">
            <div class="wrapper">
               <!-- <div class="left-bar">
                    <div class="back-home divider">
                        <em></em><a href="index.html">商城首页</a>
                    </div>
                    <div class="item"><a href="">商家中心</a></div>
                </div>-->
                <div class="right-bar">
                    <div class="login-user sub-menu">
                        <a class="menu-hd" href="#">李彬<em></em></a>
                        <!--<div class="down">
                            <a href="">内容</a>
                            <a href="">内容</a>
                            <a href="">内容</a>
                        </div>-->
                    </div>
                  <!--  <div class="item"><a href="">消息（<span class="txt-theme">0</span>）</a></div>
                    <div class="logout divider"><a href="">退出</a></div>-->
                    <span class=""></span>
                   <!-- <div class="cart"><em></em><a href="">购物车<span class="txt-theme">2</span>件</a></div>-->
                    <div class="order"><em></em><a href="#">我的寄件</a></div>
                   <!-- <div class="fav"><em></em><a href="">我的收藏</a></div>-->
                    <div class="help"><em></em><a href="#">帮助中心</a></div>
                </div>
            </div>
        </div>
        <div class="cart-header wrapper">
            <div class="logo">
                <a href="index.html"><img src="img/logo.png" alt="logo" /></a>
            </div>
            <div class="step-box">
                <div class="row">
                    <div class="step first active col-3">
                        <span class="num">1</span><span class="line"></span><span class="label">我要寄件</span>
                    </div>
                    <div class="step active col-3">
                        <span class="num">2</span><span class="line"></span><span class="label">确认订单信息</span>
                    </div>
                   <!-- <div class="step active col-3">
                        <span class="num">3</span><span class="line"></span><span class="label">完成订单并付款</span>
                    </div>-->
                    <div class="step active col-3">
                        <span class="num">3</span><span class="line"></span><span class="label">完成付款</span>
                    </div>
                </div>
            </div>
        </div>
    <!--头部-->

    <div class="wrapper">
        <div class="pay-wrap">
            <div class="order-result">
                <div class="section clearfix">
                    <img src="img/order-success.jpg" class="ico" />
                    <div class="titbox">
                        <div class="tit">订单提交成功，应付金额 ${order.expprice}元</div>
                        <div class="stit">订单号：${order.id}请您在 1 日 内完成支付，否则订单会被自动取消</div>
                    </div>
                    <div class="mt20">
                        <div class="meta">
                            <div class="hd">收货地址</div>
                            <div class="bd">${order.getaddid}  (${order.getname} 收) ${order.gettel} </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="pay-wrap-tit">
            在线支付
        </div>
        <!--<div class="pay-wrap">
            <div class="pay-way">-->
                <!--<div class="row">
                    <div class="col col-3">
                        <label><input class="check" type="radio" name="a" /><img src="img/ELogo.jpg"style="width: 133px;height: 38px;" /></label>
                    </div>
                    <div class="col col-3">
                        <label><input class="check" type="radio" name="a" /><img src="img/pay/weixin.jpg" /></label>
                    </div>
                </div>-->
               <!-- <div class="row">
                    <div class="col col-3">
                        <label><input class="check" type="radio" name="a" /><img class="bd" src="img/pay/zgyh.jpg" /></label>
                    </div>
                    <div class="col col-3">
                        <label><input class="check" type="radio" name="a" /><img class="bd" src="img/pay/jsyh.jpg" /></label>
                    </div>
                    <div class="col col-3">
                        <label><input class="check" type="radio" name="a" /><img class="bd" src="img/pay/nyyh.jpg" /></label>
                    </div>
                    <div class="col col-3">
                        <label><input class="check" type="radio" name="a" /><img class="bd" src="img/pay/gsyh.jpg" /></label>
                    </div>
                    <div class="col col-3">
                        <label><input class="check" type="radio" name="a" /><img class="bd" src="img/pay/jtyh.jpg" /></label>
                    </div>
                    <div class="col col-3">
                        <label><input class="check" type="radio" name="a" /><img class="bd" src="img/pay/zsyh.jpg" /></label>
                    </div>
                    <div class="col col-3">
                        <label><input class="check" type="radio" name="a" /><img class="bd" src="img/pay/yzcxyh.jpg" /></label>
                    </div>
                    <div class="col col-3">
                        <label><input class="check" type="radio" name="a" /><img class="bd" src="img/pay/xyyy.jpg" /></label>
                    </div>
                </div>-->
       <!--     </div>
        </div>-->
        <div class="bottom-panel">
            <a href="/exp/order/yeepay.jhtml" class="go-next ui-btn-theme">下一步</a>
        </div>
    </div>

    <!--脚部-->
    <div class="fatfooter">

    </div>
    <!--脚部-->
</body>
<script src="js/jquery.js"></script>
<link rel="stylesheet" href="css/style.css"/>
<script src="js/icheck.min.js"></script>
<script src="js/global.js"></script>
<script>
    $('.check').iCheck({
            radioClass: 'sty1-radio'
    });
</script>
</html>