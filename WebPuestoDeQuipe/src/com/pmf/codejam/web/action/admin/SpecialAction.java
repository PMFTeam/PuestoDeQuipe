package com.pmf.codejam.web.action.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import com.opensymphony.xwork2.ActionSupport;
import com.pmf.codejam.util.Constants;

public class SpecialAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	private static final long serialVersionUID = 1L;
	
	private HttpServletResponse response;
	private HttpServletRequest request;
	private String description;
	private String summary;
	private String expirationDate;
	private List<String> socialNetworks;
	private String social;

	public SpecialAction() {
		socialNetworks = new ArrayList<String>();
		socialNetworks.add(Constants.SOCIAL_FACEBOOK);
		socialNetworks.add(Constants.SOCIAL_TWITTER);
	}
	public String save() throws Exception {
		
		System.out.println("Social: " + social);
		System.out.println("SocialList: " + socialNetworks.toString());
		
		return SUCCESS;
	}
	
	
	public String execute() throws Exception {
		
		return SUCCESS;
	}
	
	
	
	
	public List<String> getSocialNetworks() {
		return socialNetworks;
	}
	public void setSocialNetworks(List<String> socialNetworks) {
		this.socialNetworks = socialNetworks;
	}
	public String getSocial() {
		return social;
	}
	public void setSocial(String social) {
		this.social = social;
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
