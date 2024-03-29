<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta name="decorator" content="/template/template18.jsp">
<script type="text/javascript">
	var dialog;
	var custId = "${custId}";
	url = "${ctx}/ecif/perrisk/perbusiinsurance/list.json?custId=" + custId;
	$(function() {

		grid = $("#maingrid").ligerGrid({
			columns : [ {
				display : '源系统流水号',
				name : 'serialNo',
				align : 'center',
				width : 100,
				minWidth : 80
			}, {
				display : '保险名称',
				name : 'biname',
				align : 'left',
				width : 100,
				minWidth : 80
			}, {
				display : '保险类型',
				name : 'bitype',
				align : 'center',
				width : 100,
				minWidth : 80
			}, {
				display : '保障金额',
				name : 'insuredsum',
				align : 'center',
				width : 120,
				minWidth : 120
			}, {
				display : '到期日期',
				name : 'maturity',
				align : 'center',
				width : 100,
				minWidth : 80,
				type : "date"
			} , {
				display : '客户编号',
				name : 'customerid',
				align : 'center',
				width : 100,
				minWidth : 80
			}, {
				display : '承保公司',
				name : 'underwriter',
				align : 'center',
				width : 100,
				minWidth : 80
			}, {
				display : '投保日期',
				name : 'insuredate',
				align : 'center',
				width : 100,
				minWidth : 80,
				type : "date"
			}, {
				display : '现金价值',
				name : 'cashvalue',
				align : 'center',
				width : 100,
				minWidth : 80
			}, {
				display : '退保日期',
				name : 'canceldate',
				align : 'center',
				width : 100,
				minWidth : 80,
				type : "date"
			}],
			checkbox : false,
			usePager : true,
			isScroll : false,
			rownumbers : true,
			alternatingRow : true,//附加奇偶行效果行
			colDraggable : true,
			dataAction : 'server',//从后台获取数据
			method : 'post',
			url : url,
			sortName : 'custId',//第一次默认排序的字段
			sortOrder : 'asc', //排序的方式
			pageParmName : 'page',
			pagesizeParmName : 'pagesize',
			toolbar : {}
		});

	});
</script>
</head>
<body>
</body>
</html>