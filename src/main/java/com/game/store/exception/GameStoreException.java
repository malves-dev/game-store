package com.game.store.exception;

/**
 * @author malves
 */
public class GameStoreException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5493738268172581550L;

	public GameStoreException(Exception e) {
		super(e); 
	}

}
