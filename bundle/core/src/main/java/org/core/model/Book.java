package org.core.model;

public class Book {
	
	private Publisher publisher;
	private BookModel model;
	private String writer;
	private int publicationYear;
	private int ID;
	
	public Book(BookModel model, String writer, int publicationYear, int ID)
throws InvalidPublicationYearException{
		super();
		if(publicatonYear < 1950) {
			throw new InvalidPublicationYearException();
		}
		this.model = model;
		this.Publisher = model.getPublisher();
		this.writer = writer;
		this.publicationYear = publicationYear;
		this.ID = ID;
	}
public Publisher getPublisher() {
	return publisher;
}

}