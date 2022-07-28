package com.varxyz.jvx331.exception;

public class EntityNotFoundException extends RuntimeException{
	
	public EntityNotFoundException(long id) {
		super(id + " does not exist.");
	}
	
	public EntityNotFoundException(String str) {
		super(str + " does not exist");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3758264061177691435L;

}
