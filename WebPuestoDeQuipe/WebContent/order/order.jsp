<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="/WebPuestoDeQuipe/js/order.js"></script>



<s:form action="procesarOrden" validate="false">

	<s:textfield name="name" label="Nombre" />
	<s:textfield name="email" label="E-mail" />
	<s:textfield name="phone" label="Telefono" />
	<s:textfield name="address" label="Direccion" />
	
				<s:select name="product"
		list="products"
		id="product"
		listKey="productId"
		listValue="productName"
		headerKey="0" headerValue="" />	
		
		<s:textfield name="quantity"
			id="quantity"
			label="Cantidad"
			maxlength="3"
			size="3" />
		
	
	<input type="button" value="Agregar a Factura" onclick="addToBill()" align="left"/>
			
	<s:textarea name="bill" id="bill" label="Factura" />
	
	<input type="hidden" name="productsSelected"
			id="productsSelected"
			type="hidden" />
	
	<s:submit value="%{'Enviar'}" align="left"/>
</s:form>
