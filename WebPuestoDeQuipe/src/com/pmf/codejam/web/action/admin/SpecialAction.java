package com.pmf.codejam.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import com.opensymphony.xwork2.ActionSupport;

public class SpecialAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	private static final long serialVersionUID = 1L;
	
	private HttpServletResponse response;
	private HttpServletRequest request;
	private String description;
	private String summary;
	private String expirationDate;

	public String save() throws Exception {
		
		
		return SUCCESS;
	}
	
	
	public String execute() throws Exception {

		return SUCCESS;
	}
	
	
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}




	public String getExpirationDate() {
		return expirationDate;
	}




	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
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
	@Override
	public void setServletResponse(HttpServletResponse httpServletResponse) {
		this.response = httpServletResponse;
	}

	@Override
	public void setServletRequest(HttpServletRequest httpServletRequest) {
		this.request = httpServletRequest;
	}
}
