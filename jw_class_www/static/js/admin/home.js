/**
 * 
 */
function changeTo(type){
	if(type=='user'){
		$(".admin-content").src='../../html/admin/admin_user.html';
	}
}

function IFrameResize(){
	$(".admin-content").height=1000+"px";
}