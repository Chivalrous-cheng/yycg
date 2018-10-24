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
$(document).ready(function () {
	$("#dictinfocoustomer_typecode").change(function () {

        if ($(this).val() != "") {
            $.ajax({

                url: "${baseurl}dictinfo/querytypename.action" + "?typecode=" + $(this).val() + "",
                type: "get",
                async: "true",
                dataType: "Json",
                success: function (data) {
                	$("#dictinfocoustomer_typename").val(data);
                }

            });
        }

    });
}); 

function dictinfosave(){
	
	  jquerySubByFId('dictinfoform',dictinfosave_callback,null,"json");
	  
  }
  //ajax调用的回调函数，ajax请求完成调用此函数，传入的参数是action返回的结果
  function dictinfosave_callback(data){
	 
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
 

<form id="dictinfoform" action="${baseurl}dictinfo/editdictinfosubmit.action" method="post">
<!-- 更新用户的id -->
<input type="hidden" name="dictinfocoustomer.id" value="${dictinfocoustomer.id}"/>
<TABLE border=0 cellSpacing=0 cellPadding=0 width="100%" bgColor=#c4d8ed>

   <TBODY>
   <TR>
				<TD background=images/r_0.gif width="100%">
					<TABLE cellSpacing=0 cellPadding=0 width="100%">
						<TBODY>
							<TR>
								<TD>&nbsp;数据字典信息</TD>
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
								<TD height=30 width="10%" align=right >数据字典代码：</TD>
								<TD class=category width="30%">
								<div>
								<input type="text" id="dictinfocoustomer_dictcode" name="dictinfocoustomer.dictcode" value="${dictinfocoustomer.dictcode}"  />
								</div>
								<!-- dictinfocoustomer.dictcodeTip用于显示提示信息，提示div的id等于校验input的id+Tip -->
								<div id="dictinfocoustomer.dictcodeTip"></div>
								</TD>
								<TD height=30 width="10%" align=right >信息：</TD>
								<TD class=category width="30%">
								<div>
									<input type="text" id="dictinfocoustomer_info" name="dictinfocoustomer.info" value="${dictinfocoustomer.info}" />
								</div>
								<div id="dictinfocoustomer.infoTip"></div>
								</TD>
							</TR>
							<TR>
								<TD height=30 width="10%" align=right >字典类型代码：</TD>
								<TD class=category width="30%">
								<div>
									<input type="text" id="dictinfocoustomer_typecode" name="dictinfocoustomer.typecode" value="${dictinfocoustomer.typecode}" />
								</div>
								<div id="dictinfocoustomer.typecodeTip"></div>
								</TD>
								<TD height=30 width="10%" align=right >字典类型名称：</TD>
								<TD class=category width="30%">
								<div>
									<input type="text" id="dictinfocoustomer_typename" name="dictinfocoustomer.typename" value="${dictinfocoustomer.typename}" />
								</div>
								<div id="dictinfocoustomer.typenameTip"></div>
								</TD>
							</TR>
							<TR>
								<TD height=30 width="10%" align=right >备注：</TD>
								<TD class=category width="30%">
								<div>
									<input name="dictinfocoustomer.remark" id="dictinfocoustomer_remark" value="${dictinfocoustomer.remark}" />
								</div>
								</TD>
								<TD height=30 width="10%" align=right >排序：</TD>
								<TD class=category width="30%">
								<div>
									<input name="dictinfocoustomer.dictsort" id="dictinfocoustomer_dictsort" value="${dictinfocoustomer.dictsort}" />
								</div>
								</TD>
							</TR>
							<TR>
								<TD class="left">是否启用：</TD>
								<td>
									<div>
										<input name="dictinfocoustomer.isenable" id="dictinfocoustomer_isenable" value="${dictinfocoustomer.isenable}" />
									</div>
								</TD>
								<TD height=30 width="10%" align=right >值类型：</TD>
								<TD class=category width="30%">
								<div>
									<input name="dictinfocoustomer.valuetype" id="dictinfocoustomer_valuetype" value="${dictinfocoustomer.valuetype}" />
								</div>
								</TD>
							</TR>
							<tr>
							  <td colspan=4 align=center class=category>
								<a id="submitbtn"  class="easyui-linkbutton"   iconCls="icon-ok" href="#" onclick="dictinfosave()">提交</a>
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