package com.pmf.codejam.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.*;

import com.pmf.codejam.util.EjbConstants;

/**
 *
 * @author Garis Suero
 */
@Entity
@Table(name = EjbConstants.TABLE_SPECIALS)
@NamedQueries({
    @NamedQuery(name = "Special.findAll", query = "SELECT s FROM Special s"),
    @NamedQuery(name = "Special.findById", query = "SELECT s FROM Special s WHERE s.id = :id"),
    @NamedQuery(name = "Special.findByDescription", query = "SELECT s FROM Special s WHERE s.description = :description"),
    @NamedQuery(name = "Special.findBySummary", query = "SELECT s FROM Special s WHERE s.summary = :summary"),
    @NamedQuery(name = "Special.findByCreationDate", query = "SELECT s FROM Special s WHERE s.creationDate = :creationDate"),
    @NamedQuery(name = "Special.findByExpirationDate", query = "SELECT s FROM Special s WHERE s.expirationDate = :expirationDate"),
    @NamedQuery(name = "Special.count", query = "select count(s) from Special as s")})

public class Special implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "DESCRIPTION", nullable = false, length = 500)
    private String description;
    @Column(name = "SUMMARY", length = 140)
    private String summary;
    @Basic(optional = false)
    @Column(name = "CREATION_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Column(name = "EXPIRATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    public Special() {
    }


    public Special(String description, Date creationDate) {
        this.description = description;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Special)) {
            return false;
        }
        Special other = (Special) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pmf.codejam.entity.Special[id=" + id + "]";
    }
    
    public boolean isCurrent() {
    	Calendar thisExpirationDate = Calendar.getInstance();
    	thisExpirationDate.setTime(getExpirationDate());
    	return Calendar.getInstance().before(thisExpirationDate);
    }

}
