<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="static/bootstrap-4.3.1-dist/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<title>登录页面</title>
</head>
<body>
<!--登录注册二选一弹出框-->
<div id="loginOrRegister">
	<!-- 标题 -->
	<div class="title">
		<span class="login colorRed" onClick="goLogin()">登录</span>
		<span class="register" onClick="goRegister()">注册</span>
	</div>
	<!-- 具体信息 -->
	<div  >
		<!-- 登录界面 -->
		<form class="loginForm" onsubmit="doLogin()">
			<ul class="box box1">
				<li>
					<label for="account">账号</label>
					<input type="text" placeholder="请输入您的账号" class="account" id="account" required oninvalid="setCustomValidity('请输入账号');" oninput="setCustomValidity('');"/>
				</li>
				<li>
					<label for="password">密码</label>
					<input type="password" class="password" id="password" placeholder="请输入密码" required oninvalid="setCustomValidity('请输入密码');" oninput="setCustomValidity('');"//>
				</li>
				<li>
					<label for="authCode">验证码</label>
					<input type="text" class="sradd photokey" id="authCode" placeholder="请输入验证码" required oninvalid="setCustomValidity('请输入验证码');" oninput="setCustomValidity('');"//>
					<span class="add authCode"></span>
					<span class="error"></span>
				</li>
			</ul>
			<div>
			
			</div>
			<div class="checkbox" style="display:inline;margin-left:-40px;margin-right:10px;">
				<label>
					<input type="checkbox"> 记住我
				</label>
			</div>
			<div class="submit" style="display:inline;margin-left:-40px;">
				<input type="submit" value="立即登录"/>
			</div>
		</form>
		<!-- 注册界面 -->
		<form action="www.baidu.com" method="post" class="registerForm" >
			<ul class="box box2">
				<li>
					<label for="phone">手机</label>
					<input type="text" placeholder="请输入您的手机号码" id="phone" maxlength="11" />
					<span class="error"></span>
				</li>
				<li>
					<label for="authCode2">验证码</label>
					<input type="text" class="sradd phonekey" id="authCode2" placeholder="请输入收到的验证码" />
					<span class="add sendaAuthCode">发送验证码</span>
					<span class="error"></span>
				</li>
				<li>
					<label for="password2">密码</label>
					<input type="password" class="password" id="password2" placeholder="请输入密码" />
					<span class="error"></span>
				</li>
				<li>
					<label for="password3">确认密码</label>
					<input type="password" class="email" id="password3" placeholder="请再次输入密码" />
					<span class="error">验证码输入错误！</span>
				</li>
			</ul>
			<div class="submit">
				<input type="submit" value="立即注册" />
			</div>
		</form>
	</div>
</div>
</body>
</html>
<script src="static/jquery/jquery-3.4.1.min.js"></script>
<script src="static/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
<script src="js/index.js" type="text/javascript" charset="utf-8"></script>
<script src="js/login.js" type="text/javascript" charset="utf-8"></script>
<script src="js/register.js" type="text/javascript" charset="utf-8"></script>