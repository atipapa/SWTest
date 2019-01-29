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
		if(publicationYear < 1950) {
			throw new InvalidPublicationYearException();
		}
		this.model = model;
		this.publisher = model.getPublisher();
		this.writer = writer;
		this.publicationYear = publicationYear;
		this.ID = ID;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	
	public BookModel getModel() {
		return model;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public int getPublicationYear() {
		return publicationYear;
	}
	
	public int getID() {
	return ID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + publicationYear;
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((writer == null) ? 0 : writer.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (ID != other.ID)
			return false;
		if (model != other.model)
			return false;
		if (publicationYear != other.publicationYear)
			return false;
		if (publisher != other.publisher)
			return false;
		if (writer == null) {
			if (other.writer != null)
				return false;
		} else if (!writer.equals(other.writer))
			return false;
		return true;
	}
}