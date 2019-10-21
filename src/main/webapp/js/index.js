/**
 * 
 */
// 切换登录
jhkn;
function goLogin() {
	$(".loginForm").css("display", "block");
	$(".registerForm").css("display", "none");
	$(".login").addClass("colorRed");
	$(".register").removeClass("colorRed");
}
// 切换注册
function goRegister() {
	$(".registerForm").css("display", "block");
	$(".loginForm").css("display", "none");
	$(".register").addClass("colorRed");
	$(".login").removeClass("colorRed");
}