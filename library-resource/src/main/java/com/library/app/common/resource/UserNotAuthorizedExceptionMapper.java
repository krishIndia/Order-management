package com.library.app.common.resource;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.library.app.common.exception.UserNotAuthorizedException;
import com.library.app.common.model.HttpCode;

@Provider
public class UserNotAuthorizedExceptionMapper implements ExceptionMapper<UserNotAuthorizedException> {

	@Override
	public Response toResponse(final UserNotAuthorizedException exception) {
		return Response.status(HttpCode.FORBIDDEN.getCode()).build();
	}

}