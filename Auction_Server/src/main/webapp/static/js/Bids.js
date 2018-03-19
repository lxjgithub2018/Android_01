/**
 * 商品竞拍管理模块用到的js代码
 */
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
			{field:'bidId',title:'编号', width:80},
			{field:'bidDate',title:'竞拍时间', width:160},
			{field:'bidPrice',title:'竞拍价格', width:160},
			{field:'userId',title:'用户编号', width:160,
			formatter: function(value,row,index){
				if (row.users){
					return row.users.userId;
				} else {
					return value;
				}
			}
		},
		{field:'userName',title:'用户名称', width:160,
			formatter: function(value,row,index){
				if (row.users){
					return row.users.userName;
				} else {
					return value;
				}
			}
		},
		{field:'itemId',title:'商品编号', width:160,
			formatter: function(value,row,index){
				if (row.items){
					return row.items.itemId;
				} else {
					return value;
				}
			}
		},
		{field:'itemName',title:'商品名称', width:160,
			formatter: function(value,row,index){
				if (row.items){
					return row.items.itemName;
				} else {
					return value;
				}
			}
		},
    	]]
    });
    
    var pager = $('#dg').datagrid('getPager');//获得表格的页对象
    pager.pagination({//给页对象设置按钮组
        buttons:[{
            iconCls:'icon-search',
            handler:function(){
            	$('#search').dialog('open');//打开查询对话框
            }
        }]
    }); 
});
    