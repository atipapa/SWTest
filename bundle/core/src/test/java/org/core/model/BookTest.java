package org.core.model;


import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

public class BookTest {

	private static final String JANOSVITEZWRITER = "Petőfi Sándor";
	
	private Book book;
	
	@Before
	public void setUp() {
	try {
		this.book = new Book(Publisher.MUSZAKI, BookModel.JANOSVITEZ, JANOSVITEZWRITER, 1845, 123456);
	} catch (InvalidPublicationYearException e) {
		Assume.assumeNoException(e);
	}
	}
	@Test
	public void testPublisherWithPetofiSandor() {
		Publisher expected = Publisher.MUSZAKI;
		Publisher actual = book.getPublisher();
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void testModelWithPetofiSandor() {
		BookModel expected = BookModel.JANOSVITEZ;
		BookModel actual = book.getModel();
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void testwriterWithPetofiSandor() {
		String expected = JANOSVITEZWRITER;
		String actual = book.getWriter();
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void testPublicationYearWithPetofiSandor() {
		int expected = 1845;
		int actual = book.getPublicationYear();
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void testIDwithPetofiSandor () {
		int expected = 123456;
		int actual = book.getID();
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void testInvalidPublicationYear() throws InvalidPublicationYearException{
	book = new Book(Publisher.MUSZAKI, BookModel.JANOSVITEZ, "Petőfi Sándor", 1845, 123456);
	}
}