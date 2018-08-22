package com.library.app.order.repository;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.library.app.common.model.PaginatedData;
import com.library.app.common.repository.GenericRepository;
import com.library.app.order.model.Order;
import com.library.app.order.model.filter.OrderFilter;

@Stateless
public class OrderRepository extends GenericRepository<Order> {

	@PersistenceContext
	EntityManager em;

	@Override
	protected Class<Order> getPersistentClass() {
		return Order.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	public Order findById(final Long id) {
		final Order order = super.findById(id);
		if (order != null) {
			order.getItems().size();
			order.getHistoryEntries().size();
		}
		return order;
	}

	public PaginatedData<Order> findByFilter(final OrderFilter orderFilter) {
		final StringBuilder clause = new StringBuilder("Where e.id is not null");
		final Map<String, Object> queryParameters = new HashMap<>();
		if (orderFilter.getStatus() != null) {
			clause.append(" And e.currentStatus = :status");
			queryParameters.put("status", orderFilter.getStatus());
		}
		if (orderFilter.getCustomerId() != null) {
			clause.append(" And e.customer.id = :customerId");
			queryParameters.put("customerId", orderFilter.getCustomerId());
		}
		if (orderFilter.getStartDate() != null) {
			clause.append(" And e.createdAt >= :startDate");
			queryParameters.put("startDate", orderFilter.getStartDate());
		}
		if (orderFilter.getEndDate() != null) {
			clause.append(" And e.createdAt <= :endDate");
			queryParameters.put("endDate", orderFilter.getEndDate());
		}

		return findByParameters(clause.toString(), orderFilter.getPaginationData(), queryParameters, "createdAt Desc");
	}

}