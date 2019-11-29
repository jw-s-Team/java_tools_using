/**
 * 
 */
function searchUser(){
	$.ajax({
		url:$tools.ctx+"/user/getUserList",
		type:'get',
		success:function(){
			
		}
	});
	
}