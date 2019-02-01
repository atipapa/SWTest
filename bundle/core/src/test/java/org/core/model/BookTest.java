package org.core.model;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;


public class BookTest {

	private static final String JANOS_VITEZ_WRITER = "Petőfi Sándor";
	
	private Book book;
	
	@Before
	public void setUp() {
	try {
		this.book = new Book(BookModel.JANOS_VITEZ, JANOS_VITEZ_WRITER, 1845, 123456);
	} catch (InvalidPublicationYearException e) {
		Assume.assumeNoException(e);
	}
	}
	@Test
	public void testPublisherWithPetofiSandor() {
		Publisher expected = Publisher.Muszaki;
		Publisher actual = book.getPublisher();
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void testModelWithPetofiSandor() {
		BookModel expected = BookModel.JANOS_VITEZ;
		BookModel actual = book.getModel();
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void testWriterWithPetofiSandor() {
		String expected = JANOS_VITEZ_WRITER;
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
	public void testIDWithPetofiSandor () {
		int expected = 123456;
		int actual = book.getID();
		Assert.assertEquals(expected, actual);
	}
	@Test(expected=InvalidPublicationYearException.class)
	public void testInvalidPublicationYear() throws InvalidPublicationYearException{
	Book book = new Book(BookModel.JANOS_VITEZ, "Petőfi Sándor", 1885, 123456);
	}
}