﻿/**
 * 理财产品起始募集金额份额表
 * @author zhangxd
 * @since 2012-12-18
 */
Ext.onReady(function() {
	//产品类型
	var pdTypeStore = new Ext.data.ArrayStore({
		fields:['key','value'],
	    data:[['1','聚财宝'],['2','青花十二生肖']]
	});
	
/**********************************************************/
    var qForm = new Ext.form.FormPanel({
    	id : "qfrom",
    	labelWidth : 100, // 标签宽度
    	labelAlign : 'middle', // 标签对齐方式
    	buttonAlign : 'center',
    	height:100,
    	items :[{
    		layout : 'column',
    		border : false,
    		items :[  
    		        {
    		        	layout : 'form',
    		        	columnWidth : 1,
    		        	border : false,
    		        	items : [
    		        	         {
    		        	        	 xtype : 'combo',
    									fieldLabel : '产品名称',
    									id:'pdname',
    									name:'pdname',
    									store : pdTypeStore,
    									labelStyle : 'text-align:right;',
    									valueField : 'key',
    									displayField : 'value',
    									triggerAction : 'all',
    									mode:'local',
    									editable : false,
    									emptyText : '请选择',
    									anchor : '90%'
    		        	         }
    		        	         ]	
    		        }
    		        ]
    	}],
    	buttonAlign : 'center',
    	buttons : [
    	           {
    	        	   text : '查询',
    	        	   handler : function() {
    	        	   if(!qForm.getForm().isValid()){
    	        		   Ext.Msg.alert("提醒","请填写必填项");
    	        		   return false;
    	        	   }
    	        	   select();
    	        	   var parameters = qForm.getForm().getValues(false);
    	           }
    	           }, {
    	        	   text : '重置',
    	        	   handler : function() {
    	        	   qForm.getForm().reset();
    	           }
    	           } ] 	     
    });
    function select(){
    	var name = qForm.getForm().findField('pdname').getValue();
    	if(name==''){
    		Ext.Msg.alert("提醒","请填写必填项");
    		return;
    	}
    	var winWidth = screen.width - 10;
    	var winHeight = screen.height - 60;
    	var winFeatures = "toolbar=no,location=no,directories=no,status=yes,menubar=no,scrollbars=yes,resizable=yes,";
    	winFeatures += "top=0,left=0,height="
    		+ winHeight + ",width=" + winWidth;
    	if(name =='1')
    	{
    		qForm.getForm().findField('pdname').setValue('');
    		var url=basepath+'/reportJsp/showReport.jsp?raq=/report_8.1.raq&PRODNAME='+'聚财宝';
    	}
    	else if (name == '2'){
    		qForm.getForm().findField('pdname').setValue('');
    		var url=basepath+'/reportJsp/showReport.jsp?raq=/report_8.1.raq&PRODNAME='+'青花十二生肖';
    	}

    	var winOpen = window.open(url,'chat' + new Date().getTime(),winFeatures);
    }
    var fpanel = new Ext.Panel({
    	id : "fpanel",
    	frame : true, //是否渲染表单面板背景色
    	labelAlign : 'middle', // 标签对齐方式
    	buttonAlign : 'center',
    	items :[qForm]
			        });
    // 布局模型
    var viewport = new Ext.Panel({
    	title:'理财报表统计->附件银行个人理财产品->理财产品起始募集金额份额表',
    	renderTo : 'viewport_center',
    	width:600,
    	height:150,
    	frame : true,
    	items: [{   
    		hidden:false,
    		margins: '0 0 0 0',
    		items:[fpanel]
    	}] 
    });
	
}); 