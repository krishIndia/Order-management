package com.library.app.order.exception;

import javax.ejb.ApplicationException;

@ApplicationException
public class OrderNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -2133792760482435181L;

}