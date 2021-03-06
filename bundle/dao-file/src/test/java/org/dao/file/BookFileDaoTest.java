package org.dao.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.core.model.Book;
import org.core.model.BookModel;
import org.core.model.InvalidPublicationYearException;
import org.core.model.Publisher;
import org.dao.BookDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BookFileDaoTest {
	private static File DEFAULT_DB_STATE;
	
	private File temporalDB;
	private BookDAO dao;

	@BeforeClass
	public static void beforeClass() {
		DEFAULT_DB_STATE = new File("src/resources/bookDB.csv");
	}
	@Before
	public void setUp() throws IOException{
		temporalDB = File.createTempFile("bookDB", "csv");
		InputStream is = null;
		OutputStream os = null;
		try {
			
			is = new FileInputStream(DEFAULT_DB_STATE);
			os = new FileOutputStream(temporalDB);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} finally {
			is.close();
			os.close();
		}
		this.dao = new BookFileDAO(temporalDB);
	}
	@Test
	public void testReadBooksFromDefaultDB() throws InvalidPublicationYearException {
		List<Book> expected = Arrays.asList(
				new Book(Publisher.MUSZAKI, BookModel.JANOSVITEZ, "Petőfi Sándor", 1845, 123456),
				new Book(Publisher.LIBRI, BookModel.AHALOTTAKELEN, "Ady Endre", 1918, 123789));
		Collection<Book> actual = dao.readBooks();
		Assert.assertEquals(expected.size(), actual.size());
		for (Book book : expected) {
			Assert.assertFalse(actual.contains(book));
		
		}
	}

}
