package com.pmf.codejam.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.*;

import com.pmf.codejam.adapter.social.SocialListener;
import com.pmf.codejam.exception.SocialConnectionException;
import com.pmf.codejam.util.EjbConstants;

@Entity
@Table(name=EjbConstants.TABLE_SPECIALS)
@NamedQueries({@NamedQuery(name = "specials.findById", query = "SELECT d FROM Specials d where d.id=:id")})
public class Specials implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="description")
	private String description;		 	 	 	 	 	 	 
	@Column(name="summary")
	private String summary;
	@Column(name="expiration_date")
	private Date expirationDate;
	@Column(name="creation_date")
	private Date creationDate;
	
	private List<SocialListener> socialListeners;
	
	public Specials(){
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<SocialListener> getSocialListeners() {
		return socialListeners;
	}

	public void setSocialListeners(List<SocialListener> socialListeners) {
		this.socialListeners = socialListeners;
	}

	@Override
	public String toString() {
		return "Specials [id=" + id + ", description=" + description
				+ ", summary=" + summary + ", expirationDate=" + expirationDate
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((expirationDate == null) ? 0 : expirationDate.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Specials other = (Specials) obj;
		if (expirationDate == null) {
			if (other.expirationDate != null)
				return false;
		} else if (!expirationDate.equals(other.expirationDate))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	public boolean isCurrent() {
		Calendar expirationCalendar = Calendar.getInstance();
		expirationCalendar.setTime(this.getExpirationDate());
		return Calendar.getInstance().before(expirationCalendar);
	}
	
	public void addSocialListener(SocialListener socialListener) {
		socialListeners.add(socialListener);
		
	}
	
	public void notifyListeners() {
		Iterator<SocialListener> listeners = socialListeners.iterator();
		while(listeners.hasNext()) {
			SocialListener listener = listeners.next();
			try {
				listener.authenticate();
				listener.post();
			} catch (SocialConnectionException ex) {
				//do whatever u want...
			}
		}

	}
	
	public boolean removeSocialListener(SocialListener socialListener) {
		return socialListeners.remove(socialListener);
	}
	
	
	
}
