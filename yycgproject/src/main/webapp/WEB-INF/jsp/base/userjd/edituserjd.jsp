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
<title>修改监督单位</title>
<script type="text/javascript">
  function sysusersave(){
	
	  jquerySubByFId('userform',sysusersave_callback,null,"json");
	  
  }
  //ajax调用的回调函数，ajax请求完成调用此函数，传入的参数是action返回的结果
  function sysusersave_callback(data){
	 
	  message_alert(data);
	  //如果成功，自动关闭
	 if(data.resultInfo.type =='1'){
		 //延迟1秒执行关闭方法
		 setTimeout("parent.closemodalwindow()", 1000);
		 parent.location.reload();
	 }
	 
  }
  
</script>
</head>
<body>
 

<form id="userform" action="${baseurl}userjd/edituserjdsubmit.action" method="post">
<!-- 更新用户的id -->
<input type="hidden" name="userjd.id" value="${userjd.id}"/>
<TABLE border=0 cellSpacing=0 cellPadding=0 width="100%" bgColor=#c4d8ed>

   <TBODY>
   <TR>
				<TD background=images/r_0.gif width="100%">
					<TABLE cellSpacing=0 cellPadding=0 width="100%">
						<TBODY>
							<TR>
								<TD>&nbsp;监督单位信息</TD>
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
								<TD height=30 width="15%" align=right >机构名称：</TD>
								<TD class=category width="30%">
								<div>
								<input type="text" id="userjd_mc" name="userjd.mc" value="${userjd.mc}" />
								</div>
								<!-- sysuser_useridTip用于显示提示信息，提示div的id等于校验input的id+Tip -->
								<div id="userjd_mcTip"></div>
								</TD>
								<TD height=30 width="8%" align=right >地址：</TD>
								<TD class=category width="30%">
								<div>
								<input type="text" id="userjd_dz" name="userjd.dz" value="${userjd.dz}"  />
								</div>
								<div id="userjd_dzTip"></div>
								</TD>
								<TD height=30 width="20%" align=right >邮政编码：</TD>
								<TD class=category width="30%">
									<input type="text" id="userjd_yzbm" name="userjd.yzbm" />
								</TD>
							</TR>
							<TR>
								<TD height=30 width="15%" align=right >联系人：</TD>
								<TD class=category width="30%">
									<input type="text" id="userjd_lxr" name="userjd.lxr" />
									</TD>
							    <TD height=30 width="8%" align=right >电话：</TD>
								<TD class=category width="30%">
								<input type="text" name="userjd_dh" value="${userjd.dh}"/>
								</TD>
								<TD height=30 width="50%" align=right>传真：</TD>
								<TD class=category width="30%">
								<input type="text" name="userjd_cz" value="${userjd.cz}"/>
								</TD>
							</TR>
							<TR>
							    <TD height=30 width="15%" align=right >电子邮箱：</TD>
								<TD class=category width="30%">
								<input type="text" name="userjd_dzyx" value="${userjd.dzyx}"/>
								</TD>
								<TD height=30 width="8%" align=right>网址：</TD>
								<TD class=category width="30%">
								<input type="text" name="userjd_wz" value="${userjd.wz}"/>
								</TD>
							
							    <TD height=30 width="20%" align=right >地区：</TD>
								<TD class=category width="30%">
								<input type="text" name="userjd_dq" value="${userjd.dq}"/>
								</TD>
							</TR>
							<tr>
							  <td colspan=4 align=center class=category>
								<a id="submitbtn"  class="easyui-linkbutton"   iconCls="icon-ok" href="#" onclick="sysusersave()">提交</a>
								<a id="closebtn"  class="easyui-linkbutton" iconCls="icon-cancel" href="#" onclick="parent.closemodalwindow()">关闭</a>
							  	<a id="closebtn" display="true class="easyui-linkbutton" iconCls="icon-cancel" href="#" onclick=""></a>
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