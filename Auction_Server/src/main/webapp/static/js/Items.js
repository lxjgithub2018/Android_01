/**
 * 商品管理模块用到的js代码
 */

//删除按钮的监听方法
function removeConfirm(){
	var row = $('#dg').datagrid('getSelected');//获得表格选中的行
    if (row){
    	$.messager.confirm('信息提示', '确认要删除吗?', function(r){
            if (r){
            	$.get(contextPath+"/items_delete?itemId="+row.itemId,null,
					function(data,state){
            			var dt=eval("("+data+")");//把json字符串转换成对象
            			if(dt.status==1){
							$.messager.alert('信息提示','删除成功');
							$('#dg').datagrid('reload');//刷新
						}else{
							$.messager.alert('信息提示','删除失败');
						}
					}
				);
            	 
            }
        });
        
    }else{
    	$.messager.alert('信息提示','请选择一条数据进行删除');
    }
    
}

//修改按钮的监听方法，加载准备要修改的数据
function loadRemote(){
	var row = $('#dg').datagrid('getSelected');//获得表格中选中的行
    if (row){
        $('#edit').dialog({
    		onLoad :function(){
    			//回显数据
    			$('#editForm').form('load', contextPath+'/items_update?itemId='+row.itemId);
    			if(row.kinds){//类别
    				$("#edit_edit_kindId").combobox('select', row.kinds.kindId);
    			}
    			if(row.states){//状态
    				$("#edit_edit_stateId").combobox('select', row.states.stateId);
    			}
    		}
    	}).dialog('open');
    }else{
    	$.messager.alert('信息提示','请选择一条数据进行修改');
    }
}

//添加对话框中的保存按钮的监听方法
$(function(){//保存添加
	$("#add-save-button").click(
		function(){
			var datas=$("#addForm").serialize();//表单数据项
			//alert(datas);
			$.messager.confirm('信息提示', '确认要保存吗?', function(r){
   	            if (r){
   	            	$.post(contextPath+"/items_addSave",datas,
						function(data,state){
	   	            		var dt=eval("("+data+")");//把json字符串转换成对象
	            			if(dt.status==1){
								$.messager.alert('信息提示','保存成功');
								$('#addForm').form('clear');//清空表单数据
								$('#dg').datagrid('reload');//刷新
								$('#add').dialog('close');
							}else{
								$.messager.alert('信息提示','保存失败');
							}
						}
					);
   	            }
   	        });
		}	

	)
}); 	

//修改对话框中的保存按钮的监听方法     
$(function(){//保存修改
	$("#edit-save-button").click(
		function(){
			var datas=$("#editForm").serialize();//表单数据项
			$.messager.confirm('信息提示', '确认要保存吗?', function(r){
   	            if (r){
   	            	$.post(contextPath+"/items_updateSave",datas,
						function(data,state){
	   	            		var dt=eval("("+data+")");//把json字符串转换成对象
	            			if(dt.status==1){
								$.messager.alert('信息提示','保存成功');
								$('#editForm').form('clear');//清空表单数据
								$('#dg').datagrid('reload');//刷新
								$('#edit').dialog('close');
							}else{
								$.messager.alert('信息提示','保存失败');
							}
						}
					);
   	            }
   	        });
		}	

	)
});


//查询对话框中查询按钮监听方法
$(function(){//查询
	$("#search-save-button").click(
		function(){
			var datas=$("#searchForm").serializeArray();//表单数据项
			var serializeObj={};
            $(datas).each(function(){
                if(serializeObj[this.name]){
                    if($.isArray(serializeObj[this.name])){
                        serializeObj[this.name].push(this.value);
                    }else{  
                        serializeObj[this.name]=[serializeObj[this.name],this.value];
                    }
                }else{
                    serializeObj[this.name]=this.value;
                }
            });
			$('#dg').datagrid('reload',serializeObj);//查询刷新
			$('#search').dialog('close');
		}

	)
});

//表格数据翻页栏设置
$(function(){

    $('#dg').datagrid({
    	columns:[[
			{field:'itemId',title:'编号', width:80},
			{field:'itemName',title:'商品名', width:160},
			{field:'itemRemark',title:'商品备注', width:160},
			{field:'itemDesc',title:'商品描述', width:160},
			{field:'addTime',title:'添加时间', width:160},
			{field:'endTime',title:'结束竞拍时间', width:160},
			{field:'initPrice',title:'初始价格', width:160},
			{field:'maxPrice',title:'最高价格', width:160},
			{field:'kindId',title:'类别编号', width:160,
			formatter: function(value,row,index){//复杂数据类型需要写这个转换方法
				if (row.kinds){
					return row.kinds.kindId;
				} else {
					return value;
				}
			}
		},
		{field:'kindName',title:'类别名称', width:160,
			formatter: function(value,row,index){//复杂数据类型需要写这个转换方法
				if (row.kinds){
					return row.kinds.kindName;
				} else {
					return value;
				}
			}
		},
		{field:'stateName',title:'状态', width:160,
			formatter: function(value,row,index){//复杂数据类型需要写这个转换方法
				if (row.states){
					return row.states.stateName;
				} else {
					return value;
				}
			}
		},
		{field:'ownId',title:'发布者编号', width:160,
			formatter: function(value,row,index){//复杂数据类型需要写这个转换方法
				if (row.ownerUsers){
					return row.ownerUsers.userId;
				} else {
					return value;
				}
			}
		},
		{field:'ownName',title:'发布者', width:160,
			formatter: function(value,row,index){//复杂数据类型需要写这个转换方法
				if (row.ownerUsers){
					return row.ownerUsers.userName;
				} else {
					return value;
				}
			}
		},
		{field:'winerId',title:'赢取者编号', width:160,
			formatter: function(value,row,index){//复杂数据类型需要写这个转换方法
				if (row.winerUsers){
					return row.winerUsers.userName;
				} else {
					return value;
				}
			}
		},
		{field:'winName',title:'赢取者', width:160,
			formatter: function(value,row,index){//复杂数据类型需要写这个转换方法
				if (row.winerUsers){
					return row.winerUsers.userName;
				} else {
					return value;
				}
			}
		}
    	]]
    });
    
    var pager = $('#dg').datagrid('getPager');//获得表格的页对象
    pager.pagination({//给页对象设置按钮组
        buttons:[{
            iconCls:'icon-add',
            handler:function(){
            	$('#add').dialog('open');//打开添加对话框
            }
        },{
            iconCls:'icon-search',
            handler:function(){
            	$('#search').dialog('open');//打开查询对话框
            }
        },{
            iconCls:'icon-edit',
            handler:function(){
            	loadRemote();//打开修改对话框
            }
        },{
            iconCls:'icon-remove',
            handler:function(){
            	removeConfirm();//打开删除对话框
            }
        }]
    }); 
});