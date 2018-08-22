package com.library.app.order.exception;

import javax.ejb.ApplicationException;

@ApplicationException
public class OrderStatusCannotBeChangedException extends RuntimeException {
	private static final long serialVersionUID = -37439605945843644L;

	public OrderStatusCannotBeChangedException(final String message) {
		super(message);
	}

}