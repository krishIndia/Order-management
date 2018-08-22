package com.library.app.order.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.library.app.book.model.Book;

@Embeddable
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 3520003746949600860L;

	@ManyToOne
	@JoinColumn(name = "book_id")
	@NotNull
	private Book book;

	@NotNull
	private Integer quantity;

	@NotNull
	private Double price;

	public OrderItem() {
	}

	public OrderItem(final Book book, final Integer quantity) {
		this.book = book;
		this.quantity = quantity;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(final Book book) {
		this.book = book;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(final Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(final Double price) {
		this.price = price;
	}

	public void calculatePrice() {
		if (book != null && quantity != null) {
			price = book.getPrice() * quantity;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final OrderItem other = (OrderItem) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderItem [book=" + book + ", quantity=" + quantity + ", price=" + price + "]";
	}

}