package com.pmf.codejam.ejb;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import com.pmf.codejam.entity.Ingredient;
import com.pmf.codejam.entity.InventoryItem;
import com.pmf.codejam.entity.Product;
import com.pmf.codejam.exception.IngredientException;
import com.pmf.codejam.exception.ProductException;
import com.pmf.codejam.util.JPAUtil;

/**
 * 
 * @author fpimentel
 *
 */
@Stateless(name="ProductService", mappedName="ejb/ProductServiceJNDI")
public class IngredientServices  implements IngredientServiceLocal{
	@PersistenceUnit(name="PuestoDeQuipeService")
	public EntityManager em;
	 public IngredientServices() {
	    	em = new JPAUtil().getEMF().createEntityManager();
	    }
	@Override
	public void addIngredient(int productId, int ingredientId, int quantity) throws IngredientException {
		Product product = null;
		Set<Ingredient> ingredients = null;
		Query query = em.createNamedQuery("Product.findById");
        query.setParameter("id", productId);
        List<Product> products = query.getResultList();
        if (products.size() > 0) {
        	product = products.get(0);
        	Query query2 = em.createNamedQuery("InventoryItem.findById");
            query.setParameter("id", ingredientId);
            List<InventoryItem> inventoryItems = query.getResultList();
            InventoryItem inventoryItem = inventoryItems.get(0);
            if (products.size() > 0) {
            	Ingredient newIngredient = new Ingredient();
            	newIngredient.setProduct(product);
            	newIngredient.setQuantityNedded(quantity);
            	newIngredient.setInventoryItem(inventoryItem);
            	product.getIngredients().add(newIngredient);
    	        em.getTransaction().begin();
    	    	em.persist(products);
    	    	em.flush();
    	    	em.getTransaction().commit(); 
            }        		        	 	        	           	          
        }
				
	}
	@Override
	public boolean updateIngredient(int idIngredient,int idProducto,int quantityNeeded)	throws IngredientException {
		Product product = null;
		Set<Ingredient> ingredients = null;
		Query query = em.createNamedQuery("Product.findById");
        query.setParameter("id", idProducto);
        List<Product> products = query.getResultList();
        if (products.size() > 0) {
        	product = products.get(0);
        	ingredients = (Set<Ingredient>) product.getIngredients();
	        	for (Ingredient  ingredient : ingredients)         	   
	        	 if(ingredient.getInventoryItem().getId() == idIngredient)
	        		 ingredient.setQuantityNedded(quantityNeeded);	        	 	        	           	          	
        }
        product.setIngredients(ingredients);        
    	em.getTransaction().begin();
    	em.persist(product);
        em.flush();
        em.getTransaction().commit();
		return true;
	}
	@Override
	public boolean deleteIngredient(int productId, int ingredientId) throws IngredientException {
		try {
			Product product = null;
			Set<Ingredient> ingredients = null;
			Query query = em.createNamedQuery("Product.findById");
	        query.setParameter("id", productId);
	        List<Product> products = query.getResultList();
	        if (products.size() > 0) {
	        	product = products.get(0);
	        	ingredients = (Set<Ingredient>) product.getIngredients();
		        	for (Ingredient  ingredient : ingredients)         	   
		        	 if(ingredient.getInventoryItem().getId() == ingredientId)
		        		 product.getIngredients().remove(ingredient);		        	 	        	           	          	
	        }	               
	    	em.getTransaction().begin();
	    	em.persist(product);
	        em.flush();
	        em.getTransaction().commit();
			return true;
    	}catch (NullPointerException ex) {
    		     throw new IngredientException ("Algo anda mal, no hay entity manager");
    	} catch (Exception ex) {
    		     throw new IngredientException ("Algo anda mal : " + ex.getMessage());
    		     }   
		
	}

}
