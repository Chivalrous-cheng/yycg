<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/base/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 引用jquery easy ui的js库及css -->
<LINK rel="stylesheet" type="text/css"
	href="${baseurl}js/easyui/styles/default.css">
<%@ include file="/WEB-INF/jsp/base/common_css.jsp"%>
<%@ include file="/WEB-INF/jsp/base/common_js.jsp"%>
<title>按医院统计</title>

<script type="text/javascript">
	//datagrid列定义
	var columns_v = [ [ {
		field : 'cgyymc',//对应json中的key
		title : '采购医院' ,
		width : 120 
	}, {
		field : 'cgzt',//对应json中的key
		title : '采购状态',
		width : 100
	}, {
		field : 'cgl',//对应json中的key
		title : '采购量',
		width : 120
	}, {
		field : 'cgje',//对应json中的key
		title : '采购金额',
		width : 120
	}, {
		field : 'rkl',//对应json中的key
		title : '入库量',
		width : 120
	}, {
		field : 'rkje',//对应json中的key
		title : '入库金额',
		width : 120
	}, {
		field : 'thl',//对应json中的key
		title : '退货量',
		width : 120
	}, {
		field : 'thje',//对应json中的key
		title : '退货金额',
		width : 120
	}, {
		field : 'jsl',//对应json中的key
		title : '结算量',
		width : 50
	}, {
		field : 'jsje',//对应json中的key
		title : '结算金额',
		width : 100
	} ] ];


	//加载datagrid

	$(function() {
		$('#hospitallist').datagrid({
			title : '采购单查询',//数据列表标题
			nowrap : true,//单元格中的数据不换行，如果为true表示不换行，不换行情况下数据加载性能高，如果为false就是换行，换行数据加载性能不高
			striped : true,//条纹显示效果
			url : '${baseurl}tjfx/hospital_result.action',//加载数据的连接，引连接请求过来是json数据
			idField : 'id',//此字段很重要，数据结果集的唯一约束(重要)，如果写错影响 获取当前选中行的方法执行
			loadMsg : '',
			columns : columns_v,
			pagination : true,//是否显示分页
			rownumbers : true,//是否显示行号
			pageList:[15,30,50]
		});
	});
	
	//查询方法
	function querypurchaseorders(){
		//datagrid的方法load方法要求传入json数据，最终将 json转成key/value数据传入action
		//将form表单数据提取出来，组成一个json
		var formdata = $("#hospitalqueryForm").serializeJson();
		$('#hospitallist').datagrid('load',formdata);
	}
	
</script>

</head>
<body>

	<!-- html的静态布局 -->
  <form id="hospitalqueryForm">
	<!-- 查询条件 -->
	<TABLE class="table_search">
		<TBODY>
			<TR>
				<TD class="left">年份：</td>
				<td><INPUT type="text" name="businesscoustomer.year" /></TD>
				<TD class="left">采购医院：</td>
				<td><INPUT type="text" name="businesscoustomer.cgyymc" /></TD>
				<TD class="left">开始时间：</td>
				<td><INPUT id="startDate" class="Wdate" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')||\'new Date()\'}'})" type="text" name="businesscoustomer.cgtimebegin" /></TD>
				<!-- <td><INPUT id="startDate" class="Wdate" onFocus="WdatePicker({lang:'zh-cn'})" type="text" name="businesscoustomer.cgtimebegin" /></TD> -->
				<TD class="left">结束时间：</td>
				<!-- <td><INPUT id="endDate" class="Wdate" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'startdate\')}',maxDate:new Date()})" type="text" name="businesscoustomer.cgtimeend" /></TD> -->
				<td><INPUT id="endDate" class="Wdate" onFocus="WdatePicker({lang:'zh-cn'})" type="text" name="businesscoustomer.cgtimeend" /></TD>
				<TD class="left">采购状态：</td>
					<td><select name="businesscoustomer.cgzt">
						<option value="">请选择</option>
						<!--<option value="1">未确认送货</option>
						<option value="2">已发货</option>
						<option value="3">已入库</option>
						<option value="0">全部</option> -->
						<c:forEach items="${cgztgroupList}" var="dictinfo">
						   <option value="${dictinfo.dictcode }">${dictinfo.info}</option>
						</c:forEach>
						<option value="5">全部</option>
					</select></TD>
			</tr>
			<TR>
					<TD class="left">退货状态：</td>
					<td><select name="businesscoustomer.thzt">
						<option value="">请选择</option>
						<!--<option value="1">未确认送货</option>
						<option value="2">已发货</option>
						<option value="3">已入库</option>
						<option value="0">全部</option> -->
						<c:forEach items="${thztgroupList}" var="dictinfo">
						   <option value="${dictinfo.dictcode }">${dictinfo.info}</option>
						</c:forEach>
						<option value="5">全部</option>
					</select></TD>
					<TD class="left">结算状态：</td>
					<td><select name="businesscoustomer.jszt">
						<option value="">请选择</option>
						<!--<option value="1">未确认送货</option>
						<option value="2">已发货</option>
						<option value="3">已入库</option>
						<option value="0">全部</option> -->
						<c:forEach items="${jsztgroupList}" var="dictinfo">
						   <option value="${dictinfo.dictcode }">${dictinfo.info}</option>
						</c:forEach>
						<option value="5">全部</option>
					</select></TD>
				<td><a id="btn" href="#" onclick="querypurchaseorders()"
					class="easyui-linkbutton" iconCls='icon-search'>查询</a></td>
			</TR>
		</TBODY>
	</TABLE>

	<!-- 查询列表 -->
	<TABLE border=0 cellSpacing=0 cellPadding=0 width="99%" align=center>
		<TBODY>
			<TR>
				<TD>
					<table id="hospitallist"></table>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
</form>
</body>
</html>