<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ui/jquery.ui.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ui/jquery.ui.widget.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ui/minified/jquery.ui.dialog.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ui/minified/jquery.ui.position.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ui/jquery.ui.datepicker.js"></script>
<script src="<%=request.getContextPath()%>/js/grid.locale-sp.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/css/ui.jqgrid.css" />
<script type="text/javascript">
	$(function() {
		setCurrentMenu("especiales");
		$("#expirationDate").datepicker({minDate: 0});
	});
	
	function printMe(id) {
		var ref = opennormalpopup('<%=request.getContextPath()%>/admin/printerObject.jsp', 'printer', 400, 400);
        var diva = $("#infoMessage").clone();
        ref.document.open();
        //ref.document.write('<html><head><title>Especial</title></head>');
        //ref.document.write('<body id="popup_body">');
        ref.document.write($(diva).html());
        //ref.document.write('</body></html>');
        ref.document.close();
        ref.print(); 
//        return ref;
	}
</script>
<br />
<br />
	<s:actionerror theme="css_xhtml" />
	<s:actionmessage theme="css_xhtml" />
	
<s:form action="ProcesarEspeciales" namespace="/admin" method="POST" theme="css_xhtml" validate="false">
<div align="center">
<div id="infoMessage" class="ui-widget" align="center" style="width:400px;height:400px;background-image:url(/WebPuestoDeQuipe/images/Bordered.png);">
	<div align="center" style="padding:12px;">
	<br />
		<h1>Especial del d&iacute;a</h1>
		<br /><br />
		<s:property value="description" />
		<br />
		<s:property value="summary" />
		<br />
		<br />
		Expira en: <s:property value="expirationDate" />
		<br /><br />
		Twitter: <a href="http://twitter.com/#!/PuestoQuipePMF">@PuestoDeQuipe</a>;  Facebook: <a href="http://www.facebook.com/puestodequipe">facebook.com/PuestoDeQuipe</a>
				
	</div>
</div>
<br />
<h2><a href="#"><img src="/WebPuestoDeQuipe/images/printer.png" onclick="printMe('infoMessage')" border="0"/></a></h2>

<a href="<%=request.getContextPath()%>/admin/Especiales.do">&lg;&lg; Regresar</a>
</div> 


</s:form>


