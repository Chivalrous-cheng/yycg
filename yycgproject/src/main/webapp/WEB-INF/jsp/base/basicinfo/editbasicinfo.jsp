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
<title>修改系统配置项</title>
<script type="text/javascript">
  function basicinfosave(){
	
	  jquerySubByFId('basicinfoform',basicinfosave_callback,null,"json");
	  
  }
  //ajax调用的回调函数，ajax请求完成调用此函数，传入的参数是action返回的结果
  function basicinfosave_callback(data){
	 
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
 

<form id="basicinfoform" action="${baseurl}basicinfo/editbasicinfosubmit.action" method="post">
<!-- 更新用户的id -->
<input type="hidden" name="basicinfocoustomer.id" value="${basicinfocoustomer.id}"/>
<TABLE border=0 cellSpacing=0 cellPadding=0 width="100%" bgColor=#c4d8ed>

   <TBODY>
   <TR>
				<TD background=images/r_0.gif width="100%">
					<TABLE cellSpacing=0 cellPadding=0 width="100%">
						<TBODY>
							<TR>
								<TD>&nbsp;系统配置项信息</TD>
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
								<TD height=30 width="10%" align=right >配置项：</TD>
								<TD class=category width="30%">
								<div>
								<input type="text" id="basicinfocoustomer.name" name="basicinfocoustomer.name" value="${basicinfocoustomer.name}"  />
								</div>
								<!-- sysuser_useridTip用于显示提示信息，提示div的id等于校验input的id+Tip -->
								<div id="basicinfocoustomer.nameTip"></div>
								</TD>
								<TD height=30 width="10%" align=right >配置值：</TD>
								<TD class=category width="30%">
								<div>
								<input type="text" id="basicinfocoustomer.value" name="basicinfocoustomer.value" value="${basicinfocoustomer.value}" />
								</div>
								<div id="basicinfocoustomer.valueTip"></div>
								</TD>
							</TR>
							<TR>
								<TD height=30 width="10%" align=right >类型：</TD>
								<TD class=category width="30%">
								<div>
									<input type="text" id="basicinfocoustomer.type" name="basicinfocoustomer.type" value="${basicinfocoustomer.type}" />
								</div>
								<div id="basicinfocoustomer.typeTip"></div>
								</TD>
								<TD height=30 width="10%" align=right >标签：</TD>
								<TD class=category width="30%">
								<div>
									<input name="basicinfocoustomer.tag" id="basicinfocoustomer.tag" value="${basicinfocoustomer.tag}" />
								</div>
								</TD>
								<TD height=30 width="10%" align=right >是否生效：</TD>
								<td><select name="basicinfocoustomer.isalive">
											<option value="是">是</option>
											<option value="否">否</option>
									</select></td>
							</TR>
							<tr>
							  <td colspan=4 align=center class=category>
								<a id="submitbtn"  class="easyui-linkbutton"   iconCls="icon-ok" href="#" onclick="basicinfosave()">提交</a>
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