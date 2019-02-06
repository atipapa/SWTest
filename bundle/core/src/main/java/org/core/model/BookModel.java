package org.core.model;

public enum BookModel {
	AHALOTTAKELEN(Publisher.LIBRI),
	JANOSVITEZ(Publisher.MUSZAKI);
	
	private final Publisher publisher;
	
	private BookModel(Publisher publisher) {
		this.publisher = publisher;
	}
	public Publisher getPublisher() {
		return publisher;
	}
}
