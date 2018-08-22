package com.library.app.commontests.order;

import com.library.app.order.model.Order.OrderStatus;

public class OrderTestUtils {

	public static String getStatusAsJson(final OrderStatus status) {
		return String.format("{\"status\":\"%s\"}", status);
	}

}