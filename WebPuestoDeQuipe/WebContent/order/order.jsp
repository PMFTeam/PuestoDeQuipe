Fausto primer JSP
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:form action="sendOrder" validate="false">

	
	<s:select name="product"
		list="products"
		id="product"
		listKey="productId"
		listValue="productName"
		headerKey="0" headerValue="" />
	
	
	
	<input type="submit" value="Enviar">
</s:form>
