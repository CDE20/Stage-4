package com.cognizant.portal.exception;

/**
 * Whenever the medicine not found then we will throw this exception and it
 * extends RuntimeException.

 */
public class MedicineNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * No-arg constructor of {@link MedicineNotFoundException}
	 */
	public MedicineNotFoundException() {
		super();
	}

	/**
	 * All-arg constructor of {@link MedicineNotFoundException}
	 */
	public MedicineNotFoundException(String message) {
		super(message);
	}

}
