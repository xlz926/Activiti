<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="login_page">
<head>

 <link href="${pageContext.request.contextPath}/style/bootstrap/css/bootstrap.min.css" rel="stylesheet" >
 <link href="${pageContext.request.contextPath}/style/css/common.css" rel="stylesheet"  >
 
<style type="text/css">

.login_page {overflow:auto}
		.login_page body {height:100%;max-width:inherit;margin:0 20px}
		.login_page .login_box {position:relative;top:50%;width:380px;margin:0 auto 24px;background:#fff;border:1px solid #ccc;-webkit-border-radius: 6px;-moz-border-radius: 6px;-ms-border-radius: 6px;border-radius: 6px;-webkit-box-shadow: 0 0 6px rgba(0,0,0,0.2);-moz-box-shadow: 0 0 6px rgba(0,0,0,0.2);-ms-box-shadow: 0 0 6px rgba(0,0,0,0.2);box-shadow: 0 0 6px rgba(0,0,0,0.2)}
		.login_page .top_b {text-shadow:0 1px 0 rgba(255,255,255,.5);font: 100 18px/42px 'PT Sans', sans-serif;height:42px;padding:0 20px;background: #e0e0e0;border-bottom:1px solid #ccc;-moz-border-radius-topleft: 6px;-moz-border-radius-topright: 6px;-moz-border-radius-bottomright: 0px;-moz-border-radius-bottomleft: 0px;-webkit-border-radius: 6px 6px 0px 0px;border-radius: 6px 6px 0px 0px;font-size:15px}
		.login_page .cnt_b {padding:30px 0;width:66%;margin:0 auto}
		.login_page form {margin-bottom:0}
		.login_page .btm_b {padding:12px 20px;border-top:1px solid #e7e7e7;background:#f7f7f7;-moz-border-radius-topleft: 0px;-moz-border-radius-topright: 0px;-moz-border-radius-bottomright: 6px;-moz-border-radius-bottomleft: 6px;-webkit-border-radius: 0px 0px 6px 6px;border-radius: 0px 0px 6px 6px}
		.login_page .links_b {width:100%;font-size:11px;text-align:center;position:absolute;bottom:-24px}
		.login_page .link_reg {font-size:11px;padding:5px 0 0;display:block}
		.alert-login {margin:10px 10px 0}
</style>



</head>
<body>
<body>
		<div class="login_box" style="margin-top: -173.5px;">
			<form id="login_form" method="post" action="login" >
				<div class="top_b">工作流程管理系统登录</div>    
				<div class="cnt_b">
					<div class="formRow">
						<div class="input-prepend">
							<span class="add-on"><i class="icon-user"></i></span><input type="text" value="kermit" placeholder="Username" name="username" id="username">
						</div>
					</div>
					<div class="formRow">
						<div class="input-prepend">
							<span class="add-on"><i class="icon-lock"></i></span><input type="password" value="kermit" placeholder="Password" name="password" id="password">
						</div>
					</div>
					<div class="formRow clearfix">
						<label class="checkbox"><input type="checkbox"> 记住用户名</label>
					</div>
				</div>
				<div class="btm_b clearfix">
					<button type="submit" class="btn btn-inverse pull-right">登录</button>
				</div>  
			</form>
			
			<form style="display:none" id="pass_form" method="post" action="http://tzd-themes.com/gebo_admin/index.php?uid=1&amp;page=dashboard">
				<div class="top_b">Can't sign in?</div>    
					<div class="alert alert-info alert-login">
					Please enter your email address. You will receive a link to create a new password via email.
				</div>
				<div class="cnt_b">
					<div class="formRow clearfix">
						<div class="input-prepend">
							<span class="add-on">@</span><input type="text" placeholder="Your email address">
						</div>
					</div>
				</div>
				<div class="btm_b tac">
					<button type="submit" class="btn btn-inverse">Request New Password</button>
				</div>  
			</form>
			
			<form style="display:none" id="reg_form" method="post" action="http://tzd-themes.com/gebo_admin/index.php?uid=1&amp;page=dashboard">
				<div class="top_b">Sign up to Gebo Admin</div>
				<div class="alert alert-login">
					By filling in the form bellow and clicking the "Sign Up" button, you accept and agree to <a href="#terms" data-toggle="modal">Terms of Service</a>.
				</div>
				<div style="display:none" class="modal hide fade" id="terms">
					<div class="modal-header">
						<a data-dismiss="modal" class="close">×</a>
						<h3>Terms and Conditions</h3>
					</div>
					<div class="modal-body">
						<p>
							Nulla sollicitudin pulvinar enim, vitae mattis velit venenatis vel. Nullam dapibus est quis lacus tristique consectetur. Morbi posuere vestibulum neque, quis dictum odio facilisis placerat. Sed vel diam ultricies tortor egestas vulputate. Aliquam lobortis felis at ligula elementum volutpat. Ut accumsan sollicitudin neque vitae bibendum. Suspendisse id ullamcorper tellus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vestibulum at augue lorem, at sagittis dolor. Curabitur lobortis justo ut urna gravida scelerisque. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aliquam vitae ligula elit.
							Pellentesque tincidunt mollis erat ac iaculis. Morbi odio quam, suscipit at sagittis eget, commodo ut justo. Vestibulum auctor nibh id diam placerat dapibus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Suspendisse vel nunc sed tellus rhoncus consectetur nec quis nunc. Donec ultricies aliquam turpis in rhoncus. Maecenas convallis lorem ut nisl posuere tristique. Suspendisse auctor nibh in velit hendrerit rhoncus. Fusce at libero velit. Integer eleifend sem a orci blandit id condimentum ipsum vehicula. Quisque vehicula erat non diam pellentesque sed volutpat purus congue. Duis feugiat, nisl in scelerisque congue, odio ipsum cursus erat, sit amet blandit risus enim quis ante. Pellentesque sollicitudin consectetur risus, sed rutrum ipsum vulputate id. Sed sed blandit sem. Integer eleifend pretium metus, id mattis lorem tincidunt vitae. Donec aliquam lorem eu odio facilisis eu tempus augue volutpat.
						</p>
					</div>
					<div class="modal-footer">
						<a href="#" class="btn" data-dismiss="modal">Close</a>
					</div>
				</div>
				<div class="cnt_b">
					
					<div class="formRow">
						<div class="input-prepend">
							<span class="add-on"><i class="icon-user"></i></span><input type="text" placeholder="Username">
						</div>
					</div>
					<div class="formRow">
						<div class="input-prepend">
							<span class="add-on"><i class="icon-lock"></i></span><input type="text" placeholder="Password">
						</div>
					</div>
					<div class="formRow">
						<div class="input-prepend">
							<span class="add-on">@</span><input type="text" placeholder="Your email address">
						</div>
						<small>The e-mail address is not made public and will only be used if you wish to receive a new password.</small>
					</div>
					 
				</div>
				<div class="btm_b tac">
					<button type="submit" class="btn btn-inverse">Sign Up</button>
				</div>  
			</form>
			
			<div class="links_b links_btm clearfix">
				<span class="linkform"><a href="#pass_form">忘记密码</a></span>
			</div>
			
		</div>
   
</body>
</html>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery/jquery.min.js"></script>