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
		        	  align:'center'
		          },{
		        	  field:'userName',
		        	  title:'用户名称',
		        	  align:'center',
		        	  editable:{
		        		  type: 'text'
		        	  }
		          },{
		        	  field:'roleName',
		        	  title:'角色列表',
		        	  align:'center'
		          },{
		        	  field:'className',
		        	  title:'班级',
		        	  align:'center'
		          },{
		        	  field:'lastModifyTime',
		        	  title:'最近修改时间',
		        	  align:'center'
		          },{
		        	  field:'operation',
		        	  title:'操作',
		        	  align:'center',
		        	  formatter:function(value,row,index){
		        		  return operation("user",row);
		        	  }
		          }		          
		];

classColumns=[
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
	        	  field:'classId',
	        	  title:'班级ID',
	        	  align:'center',
	          },{
	        	  field:'className',
	        	  title:'班级',
	        	  align:'center',
	          }	,{
	        	  field:'lastModifyTime',
	        	  title:'最近修改时间',
	        	  align:'center',
	          },{
	        	  field:'operation',
	        	  title:'操作',
	        	  align:'center'
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
		$("#addBtn").attr('data-target','');
		$("#pathDel").attr('onclick','');
	}
	if(type=='user'){
		$(obj).addClass("active");
		$("#addBtn").attr('data-target','#addUserModal');
		$("#pathDel").attr('onclick','pathDelUser()');
		$('#admin-table').bootstrapTable('destroy');
		loadTable(userColumns,'/user/getUserList');
	}else if(type=='class'){
		$(obj).addClass("active");
		$("#addBtn").attr('data-target','#addClassModal');
		$("#pathDel").attr('onclick','pathDelClass()');
		$('#admin-table').bootstrapTable('destroy');
		loadTable(classColumns,'/class/getClassList');
	}else if(type=='role'){
		$(obj).addClass("active");
		$("#addBtn").attr('data-target','#addRoleModal');
		$("#pathDel").attr('onclick','pathDelRole()');
		$('#admin-table').bootstrapTable('destroy');
		loadTable(roleColumns,'/user/getUserList');
	}else if(type='permission'){
		$(obj).addClass("active");
		$("#addBtn").attr('data-target','#addPermissionModal');
		$("#pathDel").attr('onclick','pathDelPermission()');
		$('#admin-table').bootstrapTable('destroy');
		loadTable(roleColumns,'/user/getUserList');
	}
	
}

function pathDelUser(){
	var rows=$('#admin-table').bootstrapTable('getSelections');
	delUserIds=[];
	if(rows.length==0){
		alert("请选择删除行");
	}else{
		for(var i=0;i<row.length;i++){
			delIds.push(row.userId);
		}
	}
	console.log(rows.length);
}

function loadTable(tableColumn,url){	
	$("#admin-table").bootstrapTable({
		ajax:function(request){
			$.ajax({
				type:"GET",
                url:$tools.ctx +url,
                contentType:'application/json;charset=utf-8',
                dataType:'json',
                success:function (data) {
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

var delOneUser=function (row){
	$.ajax({
		url:$tools.ctx+'/user/delOneUser?userId='+row.userId+'&classId='+row.classId+'&userRoleId='+row.userRoleId,
		success:function(data){
			if(data==1){
				alert("删除用户成功！");
				changeTo('user');
			}
		},
		error:function(e){
			alert("error:"+e);
		}
	});
}

//根据不同的菜单进行不同的操作：如编辑用户或编辑角色
function operation(type,row){	
	row=JSON.stringify(row).replace(/\"/g,"'");
	var html='';
	if(type=='user'){
		html='<div ng-app="editUserApp" ng-controller="editUserController">'
			+'<input type="button" class="btn btn-primary btn-sm" value="角色"> '
			+'<input type="button" class="btn btn-info btn-sm" value="状态"> '
			+'<input type="button" class="btn btn-success btn-sm" value="编辑" id="editBtn"ng-click="editOne('+row+')"data-toggle="modal" data-target="#editUserModal"> '
			+'<input type="button" class="btn btn-danger btn-sm" value="删除" onclick="delOneUser('+row+')">'
			+'</div>';
	}
	return html;
}


changeTo('user');
