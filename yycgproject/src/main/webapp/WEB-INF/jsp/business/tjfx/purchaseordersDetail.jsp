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
<title>采购单详细信息</title>
</head>
<body>

	<!-- html的静态布局 -->
  <form>

	<!-- 详细列表 -->
	<TABLE border=0 cellSpacing=0 cellPadding=0 width="100%" bgColor=#c4d8ed>

   <TBODY>
   <TR>
				<TD background=images/r_0.gif width="100%">
					<TABLE cellSpacing=0 cellPadding=0 width="100%">
						<TBODY>
							<TR>
								<TD>&nbsp;采购单详细信息</TD>
								<TD align=right>&nbsp;</TD>
							</TR>
						</TBODY>
					</TABLE>
				</TD>
			</TR>
			
			<TR>
				<TD>
					<TABLE class="toptable grid" border=1 cellSpacing=1 cellPadding=4
						align=center>
						<TBODY>
							<TR>
								<TD height=30 width="10%" align=right > 采购医院：</TD>
								<TD class=category width="20%">${businesscoustomer.cgyymc}</TD>
								<TD height=30 width="10%" align=right >采购单号 ：</TD>
								<TD class=category width="20%">${businesscoustomer.yycgdid}</TD>
								<TD height=30 width="10%" align=right > 采购单名称：</TD>
								<TD class=category width="20%">${businesscoustomer.cgdmc}</TD>
							</TR>
							<TR>
								<TD height=30 width="10%" align=right > 流水号：</TD>
								<TD class=category width="20%">${businesscoustomer.bm}</TD>
								<TD height=30 width="10%" align=right > 通用名：</TD>
								<TD class=category width="20%">${businesscoustomer.mc}</TD>
								<TD height=30 width="10%" align=right > 剂型：</TD>
								<TD class=category width="20%">${businesscoustomer.jx}</TD>
							</TR>
							<TR>
								<TD height=30 width="10%" align=right > 规格：</TD>
								<TD class=category width="20%">${businesscoustomer.gg}</TD>
								<TD height=30 width="10%" align=right > 转换系数：</TD>
								<TD class=category width="20%">${businesscoustomer.zhxs}</TD>
								<TD height=30 width="10%" align=right > 生产企业：</TD>
								<TD class=category width="20%">${businesscoustomer.scqymc}</TD>
							</TR>
							<TR>
								<TD height=30 width="10%" align=right > 商品名：</TD>
								<TD class=category width="20%">${businesscoustomer.spmc}</TD>
								<TD height=30 width="10%" align=right > 中标价：</TD>
								<TD class=category width="20%">${businesscoustomer.zbjg}</TD>
								<TD height=30 width="10%" align=right > 交易价：</TD>
								<TD class=category width="20%">${businesscoustomer.jyjg}</TD>
							</TR>
							<TR>
								<TD height=30 width="10%" align=right > 采购量：</TD>
								<TD class=category width="20%">${businesscoustomer.cgl}</TD>
								<TD height=30 width="10%" align=right > 采购金额：</TD>
								<TD class=category width="20%">${businesscoustomer.cgje}</TD>
								<TD height=30 width="10%" align=right > 采购状态：</TD>
								<TD class=category width="20%">${businesscoustomer.cgzt}</TD>
							</TR>
							<TR>
								<TD height=30 width="10%" align=right > 入库量：</TD>
								<TD class=category width="20%">${businesscoustomer.rkl}</TD>
								<TD height=30 width="10%" align=right > 入库金额：</TD>
								<TD class=category width="20%">${businesscoustomer.rkje}</TD>
								<TD height=30 width="10%" align=right > 退货量：</TD>
								<TD class=category width="20%">${businesscoustomer.thl}</TD>
							</TR>
							<TR>
								<TD height=30 width="8%" align=right > 退货金额：</TD>
								<TD class=category width="17%">${businesscoustomer.thje}</TD>
								<TD height=30 width="8%" align=right > 结算量：</TD>
								<TD class=category width="17%">${businesscoustomer.jsl}</TD>
								<TD height=30 width="8%" align=right > 结算金额：</TD>
								<TD class=category width="17%">${businesscoustomer.jsje}</TD>
							</TR>
							<TR>
								<TD height=30 width="8%" align=right > 结算状态：</TD>
								<TD class=category width="17%">${businesscoustomer.jszt}</TD>
							</TR>
							</TBODY>
						</TABLE>
					</TD>
				</TR>
   </TBODY>
</TABLE>
</form>
</body>
</html>