package com.pmf.codejam.adapter.social;


import com.pmf.codejam.adapter.AdapterStatus;
import com.pmf.codejam.exception.SocialConnectionException;

public interface SocialListener {
	public void post() throws SocialConnectionException;
	public void authenticate() throws SocialConnectionException;
	public AdapterStatus getStatus();
	public void setStatus(AdapterStatus status);
}
