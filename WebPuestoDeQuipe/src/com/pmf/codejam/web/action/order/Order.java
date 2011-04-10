package com.pmf.codejam.web.action.order;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.pmf.codejam.util.ProductView;

public class Order extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(Order.class.getName());
	
	private HttpServletResponse httpServletResponse;
	private HttpServletRequest httpServletRequest;
	
	private List<ProductView> products;
	private String product;
	
	public String execute() throws Exception {
		log.info("My log message. LOGGGGEER");
		
		products = new ArrayList<ProductView>();
		
		products.add(new ProductView(1,"Quipe de Pollo",new Double(10.5)));
		products.add(new ProductView(2,"Quipe de Queso",new Double(5.5)));
		products.add(new ProductView(3,"Empanada de Pollo",new Double(12.5)));
		products.add(new ProductView(4,"Empanada de Queso",new Double(15.5)));

		System.out.println("Prueba de LOG de GLASSFISH SYSOUT");
		return SUCCESS;
	}
	
	
	public String processOrder() throws Exception {
		
		String name = httpServletRequest.getParameter("name");
		log.info("My log message. LOGGGGEER");
		
		System.out.println("Prueba de LOG de GLASSFISH SYSOUT");
		return SUCCESS;
	}

	@Override
	public void setServletResponse(HttpServletResponse httpServletResponse) {
		this.httpServletResponse = httpServletResponse;
	}

	@Override
	public void setServletRequest(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}


	public List<ProductView> getProducts() {
		return products;
	}


	public void setProducts(List<ProductView> products) {
		this.products = products;
	}


	public String getProduct() {
		return product;
	}


	public void setProduct(String product) {
		this.product = product;
	}
	
	
}
