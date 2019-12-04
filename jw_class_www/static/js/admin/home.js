/**
 * 
 */

var userColumns=[
		          {
		        	  checkbox: true,  
		        	  visible: true
		          },{
		        	  field:'rowNum',
		        	  title:'序号',
		        	  align:'center',
		        	  formatter:function(value,row,index){
		        		  return index+1;
		        	  }
		        	  
		          },{
		        	  field:'userId',
		        	  title:'用户ID',
		        	  align:'center',
		          },{
		        	  field:'userName',
		        	  title:'用户名称',
		        	  align:'center',
		          },{
		        	  field:'password',
		        	  title:'密码',
		        	  align:'center',
		          },{
		        	  field:'salt',
		        	  title:'盐',
		        	  align:'center',
		          }	,{
		        	  field:'lastModifyTime',
		        	  title:'最近修改时间',
		        	  align:'center',
		          }	,{
		        	  field:'roleName',
		        	  title:'角色列表',
		        	  align:'center',
		          },{
		        	  field:'operation',
		        	  title:'操作',
		        	  align:'center',
		        	  formatter:'operation'
		          }		          
		];

var roleColumns=[
		          {
		        	  checkbox: true,  
		        	  visible: true
		          },{
		        	  field:'rowNum',
		        	  title:'序号',
		        	  align:'center',
		        	  formatter:function(value,row,index){
		        		  return index+1;
		        	  }
		        	  
		          },{
		        	  field:'userId',
		        	  title:'用户ID',
		        	  align:'center',
		          },{
		        	  field:'userName',
		        	  title:'用户名称',
		        	  align:'center',
		          }		          
		];

var permissionColumns=[
		          {
		        	  checkbox: true,  
		        	  visible: true
		          },{
		        	  field:'rowNum',
		        	  title:'序号',
		        	  align:'center',
		        	  formatter:function(value,row,index){
		        		  return index+1;
		        	  }
		        	  
		          },{
		        	  field:'userId',
		        	  title:'用户ID',
		        	  align:'center',
		          },{
		        	  field:'userName',
		        	  title:'用户名称',
		        	  align:'center',
		          }		          
		];

function changeTo(type,obj){
	if(obj){
		$(".menuClass").removeClass("active");
	}
	if(type=='user'){
		$(obj).addClass("active");
		$('#admin-table').bootstrapTable('destroy');
		loadTable(userColumns,'/user/getUserList');
	}else if(type=='role'){
		$(obj).addClass("active");
		$('#admin-table').bootstrapTable('destroy');
		loadTable(roleColumns,'/role/getRoleList');
	}else if(type='permission'){
		$(obj).addClass("active");
		$('#admin-table').bootstrapTable('destroy');
		loadTable(roleColumns,'/role/getRoleList');
	}
	
}

//遍历按钮组，如果当前点击==遍历的按钮，则添加class=active,否则remove
/*var liList=$(".nav").children();
for(var i=0;i<liList.length;i++){
	liList[i].removeClass('active');
	if(x==liList[i]){
		liList[i].addClass('active');
	}
}*/


function loadTable(tableColumn,url){	
	$("#admin-table").bootstrapTable({
		ajax:function(request){
			$.ajax({
				type:"GET",
                url:$tools.ctx +url,
                contentType:'application/json;charset=utf-8',
                dataType:'json',
                success:function (data) {
                	console.log(data);
                	request.success({
                		row:data
                	});              	
                    $('#admin-table').bootstrapTable('load',data);
                },
                error:function(){
    				alert("错误");
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
		height:$(window).height()-150,
		columns: tableColumn		
	});
}

//根据不同的菜单进行不同的操作：如编辑用户或编辑角色
function operation(){
	var html='<input type="button" class="btn btn-primary btn-sm" value="角色"> '
		+'<input type="button" class="btn btn-info btn-sm" value="状态"> '
		+'<input type="button" class="btn btn-success btn-sm" value="编辑"> '
		+'<input type="button" class="btn btn-danger btn-sm" value="删除">';
	return html;
}


changeTo('user');
