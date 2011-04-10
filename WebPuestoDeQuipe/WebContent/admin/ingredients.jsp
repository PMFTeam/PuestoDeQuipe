<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	<s:form action="grabarIngredientes" namespace="/admin" method="POST" theme="css_xhtml">
	<h1>Ingredientes de: <s:property value="product" /></h1>
		<table>
			<s:iterator value="ingredientsList">
				<tr>
					<td><s:property value="ingredientId" /></td>
					<td><s:property value="ingredientName" /></td>
				</tr>
			</s:iterator>
		</table>
		<s:select name="ingredientToAdd" list="ingredientsList" listKey="ingredientId" listValue="ingredientName" headerKey="0" headerValue="" />
		<s:textfield name="quantity" size="3"></s:textfield>
		<input type="submit" />
	</s:form>