package com.pmf.codejam.ejb;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import com.pmf.codejam.util.JPAUtil;

/**
 */
@Stateless(name="ProductService", mappedName="ejb/ProductServiceJNDI")
public class ProductService implements ProductServiceLocal {
	@PersistenceUnit(name="PuestoDeQuipeService")
	public EntityManager em;

    public ProductService() {
    	em = new JPAUtil().getEMF().createEntityManager();
    }
    
    public String sayHello(String name) { 	
        return "Hello " + name + "!"; 	
    }     
}
