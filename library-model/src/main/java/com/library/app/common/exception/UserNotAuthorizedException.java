package com.library.app.common.exception;

import javax.ejb.ApplicationException;

@ApplicationException
public class UserNotAuthorizedException extends RuntimeException {
	private static final long serialVersionUID = -1449722059595947793L;

}