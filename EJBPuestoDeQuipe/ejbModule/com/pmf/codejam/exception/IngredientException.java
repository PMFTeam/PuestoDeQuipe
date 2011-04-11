package com.pmf.codejam.exception;
/**
 * 
 * @author fpimentel
 *
 */
public class IngredientException extends Exception{
private static final long serialVersionUID = 5597479021623884190L;	
	public IngredientException() {
	
	}
	public IngredientException(String arg0) {
		super(arg0);
	}
	public IngredientException(Throwable arg0) {
		super(arg0);
	}	
	public IngredientException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
}
