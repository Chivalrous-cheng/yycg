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
<title>添加系统配置项</title>
<script type="text/javascript">
  function basicinfosave(){
	  //准备使用jquery 提供的ajax Form提交方式
	  //将form的id传入，方法自动将form中的数据组成成key/value数据，通过ajax提交，提交方法类型为form中定义的method，
	  //使用ajax form提交时，不用指定url，url就是form中定义的action
	  //此种方式和原始的post方式差不多，只不过使用了ajax方式
	  
	  //第一个参数：form的id
	  //第二个参数：sysusersave_callback是回调函数，sysusersave_callback当成一个方法的指针
	  //第三个参数：传入的参数， 可以为空
	  //第四个参数：dataType预期服务器返回的数据类型,这里action返回json
	  //根据form的id找到该form的action地址
	  jquerySubByFId('basicinfoform',basicinfosave_callback,null,"json");
	  
  }
  //ajax调用的回调函数，ajax请求完成调用此函数，传入的参数是action返回的结果
 function basicinfosave_callback(data){
	  
	  message_alert(data);
	 // alert(data.message);
	  /* if(data.type=='0'){
		  $.messager.alert('提示信息',data.message,'success');
	  }else{
		  $.messager.alert('提示信息',data.message,'error');
	  } */
	 
	  //action返回的是json数据
	  //如果是成功显示一个对号
	  
	  //如果是错误信息
	  
	//提交结果类型
	//data中存放的是action返回Resultinfo，有一个type
		/* var type=data.resultInfo.type;
		//结果提示信息
		var message=data.resultInfo.message;
		//alert(message);
		if(type==0){
			//如果type等于0表示失败，调用 jquery easyui的信息提示组件
			$.messager.alert('提示信息',message,'error');
		}else if(type==1){
			$.messager.alert('提示信息',message,'success');
		}else if(type==2){
			$.messager.alert('提示信息',message,'warning');
		}else if(type==3){
			$.messager.alert('提示信息',message,'info');
		}
	   */
	   
	   if(data.resultInfo.type =='1'){
		   parent.location.reload();
	   }

  }
 
</script>
</head>
<body>


<form id="basicinfoform" action="${baseurl}basicinfo/addbasicinfosubmit.action" method="post">
<TABLE border=0 cellSpacing=0 cellPadding=0 width="100%" bgColor=#c4d8ed>

   <TBODY>
   <TR>
				<TD background=images/r_0.gif width="100%">
					<TABLE cellSpacing=0 cellPadding=0 width="100%">
						<TBODY>
							<TR>
								<TD>&nbsp;系统配置参数信息</TD>
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
								<input type="text" id="basicinfocoustomer.name" name="basicinfocoustomer.name" />
								</div>
								<!-- sysuser_useridTip用于显示提示信息，提示div的id等于校验input的id+Tip -->
								<div id="basicinfocoustomer.nameTip"></div>
								</TD>
								<TD height=30 width="10%" align=right >配置值：</TD>
								<TD class=category width="30%">
								<div>
								<input type="text" id="basicinfocoustomer.value" name="basicinfocoustomer.value" />
								</div>
								<div id="basicinfocoustomer.valueTip"></div>
								</TD>
							</TR>
							<TR>
								<TD height=30 width="10%" align=right >类型：</TD>
								<TD class=category width="30%">
								<div>
									<input type="text" id="basicinfocoustomer.type" name="basicinfocoustomer.type" />
								</div>
								<div id="basicinfocoustomer.typeTip"></div>
								</TD>
								<TD height=30 width="10%" align=right >标签：</TD>
								<TD class=category width="30%">
								<div>
									<input name="basicinfocoustomer.tag" id="basicinfocoustomer.tag" />
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