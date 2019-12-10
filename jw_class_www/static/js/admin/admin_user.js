/**
 * 
 */
function addUser(){
	var valiResult=userAddValidate();
	if(valiResult){
		$.ajax({
			method:'POST',
			url:$tools.ctx+'/user/addOneUser',
			data:{
				userName:$("#userName").val(),
				password:$("#password").val(),
				remark:$("#remark").val(),
				roleId:$("#userRole").val()
			},
			success:function(data){
				if(data=="success"){
					alert("添加成功！");
					 location.reload() ;
				}		
			},
			error:function(data){
				alert("系统出错，请联系相关人员！")
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
	return result;
}

