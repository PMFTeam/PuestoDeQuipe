<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ui/jquery.ui.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ui/jquery.ui.widget.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ui/minified/jquery.ui.dialog.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ui/minified/jquery.ui.position.min.js"></script>
<script src="<%=request.getContextPath()%>/js/grid.locale-sp.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/css/ui.jqgrid.css" />
<br />
<br />
<s:form action="ProcesarEspeciales" namespace="/admin" method="POST" theme="css_xhtml">
<h1>Especiales</h1>
Crear Especial
	private String description;
	private String summary;
	private String expirationDate;
	
<table class="normalTable" width="450px" id="specialForm">
<tr>
	<td>Descripci&oacute;n: </td>
	<td></td>
	<td></td>
</tr>
<tr>
	<td>Oferta: </td>
	<td></td>
	<td></td>
</tr>
<tr>
	<td>Fecha expiraci&oacute;n: </td>
	<td></td>
	<td></td>
</tr>
</table>
</s:form>

