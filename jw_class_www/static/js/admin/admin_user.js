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
				roleId:$("#userRole").val()
			},
			success:function(status){
				console.log(status);
				if(status=="success"){
					window.location.href='html/welcome.html';	
				}		
			},
			error:function(status){
				console.log(status);
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