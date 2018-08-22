package com.library.app.book.exception;

import javax.ejb.ApplicationException;

@ApplicationException
public class BookNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -5009782478373385127L;

}