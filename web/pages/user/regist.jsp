<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<%--静态包含--%>
	<%@ include file="/pages/common/head.jsp"%>
<title>EddieVim's BookStore会员注册页面</title>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
	<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		$(function () {
			//提交单击事件
			$("#sub_btn").click(function () {

				//验证用户名：必须由字母，数字下划线组成，并且长度为 5 到 12 位
				//1获取输入框的值
				const username = $("#username").val();
				//2创建正则表达式
				const patt = /^\w{5,12}$/;
				//3test验证
				if(!patt.test(username)){
					//4提示
					$("span.errorMsg").text("用户名不合法");
					return false;
				}

				//验证密码：必须由字母，数字下划线组成，并且长度为 5 到 12 位

				//1获取输入框的值
				const password = $("#password").val();
				//2test验证
				if(!patt.test(password)){
					//3提示
					$("span.errorMsg").text("密码不合法");
					return false;
				}

				//验证确认密码：和密码相同
				const repwd =$("#repwd").val();

				if(repwd !== password){
					$("span.errorMsg").text("两次密码输入不一致");
					return false;
				}

				//邮箱验证：xxxxx@xxx.com
				//1获取邮箱
				const email = $("#email").val();
				//2创建正则
				const emailPatt = /^([a-zA-Z0-9_-]+)@([a-zA-Z0-9_-]+).com$/;
				//3test验证
				if(!emailPatt.test(email)) {
					//4输出信息
					$("span.errorMsg").text("email格式错误");
					return false;
				}


				//验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
				let code = $("#code").val();

				code = $.trim(code);

				if(code == null || code === ""){
					$("span.errorMsg").text("验证码不能为空！");
					return false;
				}


				//清空提示区域信息
				$("span.errorMsg").text("");
			});
		});
	</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word"></span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册BookStore会员</h1>
								<span class="errorMsg">
									${requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off"
										   value="${requestScope.username}"
										   tabindex="1" name="username" id="username"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
										   value="${requestScope.email}"
										   autocomplete="off" tabindex="1" name="email" id="email"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code" id="code"/>
									<img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%--页脚	--%>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>