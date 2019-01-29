package org.core.model;

public enum BookModel {
	A_HALOTTAK_ELEN(Publisher.Libri),
	JANOS_VITEZ(Publisher.Muszaki);
	
	private final Publisher publisher;
	
	private BookModel(Publisher publisher) {
		this.publisher = publisher;
	}
	public Publisher getPublisher() {
		return publisher;
	}
}
