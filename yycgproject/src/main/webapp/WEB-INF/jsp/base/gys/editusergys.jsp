<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/base/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK rel="stylesheet" type="text/css" href="${baseurl}js/easyui/styles/default.css">
<%@ include file="/WEB-INF/jsp/base/common_css.jsp"%>
<%@ include file="/WEB-INF/jsp/base/common_js.jsp"%>
<title>修改供货商</title>
<script type="text/javascript">
  function usergyssave(){
	
	  jquerySubByFId('userform',usergyssave_callback,null,"json");
	  
  }
  //ajax调用的回调函数，ajax请求完成调用此函数，传入的参数是action返回的结果
  function usergyssave_callback(data){
	 
	  message_alert(data);
	  //如果成功，自动关闭
	 if(data.resultInfo.type =='1'){
		 //延迟1秒执行关闭方法
		 setTimeout("parent.closemodalwindow()", 1000);
		 parent.location.reload();
	 }
	/*  parent.location.replace(document.referrer); */
	 
  }
  
</script>
</head>
<body>
 

<form id="userform" action="${baseurl}gys/editsysusergyssubmit.action" method="post">
<!-- 更新用户的id -->
<input type="hidden" name="usergyscoustomer.id" value="${userGysCustomer.id}"/>
<TABLE border=0 cellSpacing=0 cellPadding=0 width="100%" bgColor=#c4d8ed>

   <TBODY>
   <TR>
				<TD background=images/r_0.gif width="100%">
					<TABLE cellSpacing=0 cellPadding=0 width="100%">
						<TBODY>
							<TR>
								<TD>&nbsp;供应商信息</TD>
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
								<TD height=30 width="15%" align=right >企业名称：</TD>
								<TD class=category width="35%">
								<div>
								<input type="text" id="usergys_mc" name="usergyscoustomer.mc" value="${userGysCustomer.mc}"  />
								</div>
								<!-- sysuser_useridTip用于显示提示信息，提示div的id等于校验input的id+Tip -->
								<div id="usergys_mcTip"></div>
								</TD>
								<TD height=30 width="15%" align=right >企业类别：</TD>
								<TD class=category width="35%">
								<div>
								<input type="text" id="usergys_lb" name="usergyscoustomer.lb" value="${userGysCustomer.lb}"  />
								</div>
								<div id="usergys_lbTip"></div>
								</TD>
							</TR>
							<TR>
								<TD height=30 width="15%" align=right >企业联系人：</TD>
								<TD class=category width="35%">
								<div>
									<input type="text" id="usergys_lxr" name="usergyscoustomer.lxr" value="${userGysCustomer.lxr}"  />
								</div>
								<div id="usergys_lxrTip"></div>
								</TD>
								<TD height=30 width="15%" align=right >企业联系电话：</TD>
								<TD class=category width="35%">
								<div>
								<input type="text"  name="usergyscoustomer.dh" id="usergys_dh" value="${userGysCustomer.dh}"  />
								</div>
								<div id="usergys_dhTip"></div>
								</TD>
							</TR>
							<TR>
							    <TD height=30 width="15%" align=right >企业地址：</TD>
								<TD class=category width="35%">
								<input type="text" name="usergyscoustomer.lxdz" value="${userGysCustomer.lxdz}"  />
								</TD>
								<TD height=30 width="15%" align=right>网址：</TD>
								<TD class=category width="35%">
								<div>
								<input type="text"  name="usergyscoustomer.wz" id="usergys_wz" value="${userGysCustomer.wz}"  />
								</div>
								<div id="usergys_dhTip"></div>
								</TD>
							</TR>
							<TR>
							    <TD height=30 width="15%" align=right >简介：</TD>
								<TD class=category width="35%">
								<input type="text" name="usergyscoustomer.jj" value="${userGysCustomer.jj}"  />
								</TD>
								<TD height=30 width="15%" align=right>备注：</TD>
								<TD class=category width="35%">
								<div>
								<input type="text"  name="usergyscoustomer.bz" id="usergys_bz" value="${userGysCustomer.bz}"  />
								</div>
								<div id="usergys_dhTip"></div>
								</TD>
							</TR>
							<tr>
							  <td colspan=4 align=center class=category>
								<a id="submitbtn"  class="easyui-linkbutton"   iconCls="icon-ok" href="#" onclick="usergyssave()">提交</a>
								<a id="closebtn"  class="easyui-linkbutton" iconCls="icon-cancel" href="#" onclick="parent.closemodalwindow()">关闭</a>
							  </td>
							</tr>
						
							</TBODY>
						</TABLE>
					</TD>
				</TR>
   </TBODY>
</TABLE>
</form>
</body>
</html>