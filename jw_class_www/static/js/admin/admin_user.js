/**
 * 
 */
function addUser(){
	var valiResult=userAddValidate();
	if(valiResult){
		$.ajax({
			method:'POST',
			dataType:"json",
			url:$tools.ctx+'/user/addOneUser',
			data:{
				userName:$("#userName").val(),
				password:$("#password").val(),
				remark:$("#remark").val(),
				role:$("#userRole").val()
			},
			success:function(data){
				alert("添加成功");
				//跳转至用户管理页面，刷新页面
			}
		});
	}
}

function  userAddValidate(){
	var result=true;
	if($("#userName").val()==''){
		$(".userNameReq").show();
		result=false;
	}else{
		$(".userNameReq").hide();
	}
	if($("#password").val()==''){
		$(".passwordReq").show();
		result=false;
	}else{
		$(".passwordReq").hide();
	}
	console.log(result);
	return result;
}