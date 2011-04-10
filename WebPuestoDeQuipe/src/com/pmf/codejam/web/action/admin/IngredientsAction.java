package com.pmf.codejam.web.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.pmf.codejam.util.DataLayerUtil;
import com.pmf.codejam.util.IngredientView;
import com.pmf.codejam.util.ProductView;

public class IngredientsAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	private static final long serialVersionUID = 1L;
	
	private HttpServletResponse response;
	private HttpServletRequest request;
	
	private List<IngredientView> productIngredients;
	private List<IngredientView> ingredientsList;
	private String product;
	private String quantity;
	private String productToAdd;
	private String ingredientToAdd;
	
	private void fillLists() {
		ingredientsList = DataLayerUtil.getAllIngredients();		
	}
	public String grabarIngrediente() throws Exception {
		System.out.println("Product " + productToAdd);
		System.out.println("Ingredient " + ingredientToAdd);
		System.out.println("Quantity " + quantity);
		
		// Whatever we need to do to save an ingredient as part of a product...
		fillLists();
		return SUCCESS;
	}
	public String execute() throws Exception {

		String id = (request.getParameter("productId")+"").trim();
		int productId = (id != null && id.length() > 0 ? new Long(id).intValue() : 0);
		productIngredients = DataLayerUtil.getIngredientsByProductId(productId);
		ProductView productView = DataLayerUtil.getProductById(productId);
		product = productView.getProductName();
		productToAdd = productView.getProductId()+ ""; 
		fillLists();
		
		return SUCCESS;
	}
	
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getProductToAdd() {
		return productToAdd;
	}
	public void setProductToAdd(String productToAdd) {
		this.productToAdd = productToAdd;
	}
	public String getIngredientToAdd() {
		return ingredientToAdd;
	}
	public void setIngredientToAdd(String ingredientToAdd) {
		this.ingredientToAdd = ingredientToAdd;
	}
	@Override
	public void setServletResponse(HttpServletResponse httpServletResponse) {
		this.response = httpServletResponse;
	}

	@Override
	public void setServletRequest(HttpServletRequest httpServletRequest) {
		this.request = httpServletRequest;
	}

	public String getProduct() {
		return product;
	}


	public void setProduct(String product) {
		this.product = product;
	}
	public List<IngredientView> getProductIngredients() {
		return productIngredients;
	}
	public void setProductIngredients(List<IngredientView> productIngredients) {
		this.productIngredients = productIngredients;
	}
	public List<IngredientView> getIngredientsList() {
		return ingredientsList;
	}
	public void setIngredientsList(List<IngredientView> ingredientsList) {
		this.ingredientsList = ingredientsList;
	}
	
	
}
