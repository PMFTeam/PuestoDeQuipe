package com.pmf.codejam.ejb;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import javax.persistence.*;
import com.pmf.codejam.entity.Product;
import com.pmf.codejam.exception.*;
import com.pmf.codejam.util.JPAUtil;
import java.util.*;

/**
 * 
 * @author fpimentel
 *
 */
@Stateless(name="ProductService", mappedName="ejb/ProductServiceJNDI")
public class ProductService implements ProductServiceLocal {
	@PersistenceUnit(name="PuestoDeQuipeService")
	public EntityManager em;

    public ProductService() {
    	em = new JPAUtil().getEMF().createEntityManager();
    }
    public void addProduct(Product product){
    	try {
    			em.getTransaction().begin();
    			em.persist(product);
    			em.flush();
    			em.getTransaction().commit();    
    		} 
    		catch (NullPointerException ex) {    		    
    		}
    		catch (Exception ex) {
    			System.out.println("[EXCEPCION]!\n" + ex.getMessage());
    			ex.printStackTrace();
    		}    		
    }
    public boolean updateProduct(int idProduct,String name, double price)  throws ProductException{
    	boolean result = true;
        try {
        	Query query = em.createNamedQuery("Product.findById");
            query.setParameter("id", idProduct);
            List<Product> productList = query.getResultList();
            if (productList.size() > 0) {
            Product product = productList.get(0);
            product.setName(name);
            product.setPrice(price);
        	em.getTransaction().begin();
	        em.flush();
	        em.getTransaction().commit();
            }
        } 
        catch (Exception ex) 
        {
        	throw new ProductException(ex.getMessage());
        }
        return result;
    	}
    public void deleteProduct(int productId) throws ProductException{
    	try {
    		Query query = em.createNamedQuery("Product.findById");
            query.setParameter("id", productId);
            List<Product> productList = query.getResultList();
            if (productList.size() > 0) {
            Product product = productList.get(0);
    		em.getTransaction().begin();
    		em.remove(product);
    		em.flush();
    		em.getTransaction().commit();
    		     } 
    	}catch (NullPointerException ex) {
    		     throw new ProductException ("Algo anda mal, no hay entity manager");
    	} catch (Exception ex) {
    		     throw new ProductException ("Algo anda mal : " + ex.getMessage());
    		     }    
    }

}