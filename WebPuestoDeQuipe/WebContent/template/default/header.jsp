<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set name="user" value="USER" scope="session"/>

<table id="tableHeader" border="0">
	<tr>
	<td width="30%" valign="top" align="left">
		<h2>PuestoDeQuipe.com</h2>
	</td>
	<td width="50%" valign="top" height="5px">

	</td>
	<td width="146px" valign="top" height="5px">
		<div id="headerLinks">
		<s:if test="#session.USER != null">
			Bienvenido <s:property value="#session.USER" />
			(<a href="<%=request.getContextPath()%>/admin/Salir.do" >Salir</a>)
		</s:if>
		</div>
	</td>
	</tr>
</table>
