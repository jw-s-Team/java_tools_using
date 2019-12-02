/**
 * 
 */
window.$tools={};
window.$tools.path = '/xy_gurs_www';
window.$tools.ctx = '/jw_class_sys';
loadUserTable();
var changeTo=function(type){
	if(type=='user'){
		loadUserTable();
	}else if(type=='role'){
		loadRoleTable();
	}else if(type='permission'){
		loadPermTable();
	}
}

function loadUserTable(){
	$("#admin-table").bootstrapTable({
		/*url:'/admin/getUserList',*/
		ajax:function(){
			$.ajax({
				type:"GET",
                url:$tools.ctx +'/admin/getUserList',
                contentType:'application/json;charset=utf-8',
                dataType:'json',
                success:function (data) {
                	console.log(data);
                	row:data
                    $('#admin-table').bootstrapTable('load',data);
                },
                error:function(error){
                    console.log(error);
                }
			});
		},
		contentType:'application/x-www-form-urlencoded',
		method: 'get',
		datatype:'json',
		toolbar: '#admin-toolbar',
		cache: false,
		pagination: true,
		pageNumber:1,
		paginationVAlign:"bottom",
		pagesize:20,
		pageList:[10,20,50,100],
		sidePagination:'client',
		height:$(window).height,
		columns: [
		          {
		        	  field:'userId',
		        	  title:'用户ID'
		          },{
		        	  field:'userName',
		        	  title:'用户名称'
		          }		          
		]
		
	});
}

