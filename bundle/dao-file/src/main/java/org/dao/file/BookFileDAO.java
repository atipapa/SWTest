package org.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.core.model.Book;
import org.core.model.BookModel;
import org.core.model.InvalidPublicationYearException;
import org.core.model.Publisher;
import org.dao.BookDAO;
import org.dao.exception.DuplicatedBookEntryException;
import org.dao.exception.EntryNotFoundException;


public class BookFileDAO implements BookDAO {
	
	private File database;
	private static final String FIELD_SEPARATOR = ";";
	

	public BookFileDAO(String databasePath) {
		super ();
		this.database = new File(databasePath);
	}	
	
	public BookFileDAO(File database) {
		super();
		this.database = database;
	}
	public void createBook(Book book) throws DuplicatedBookEntryException {
		Collection<Book> books=readBooks(); 
			if(books.contains(book)) {
				throw new DuplicatedBookEntryException(book.toString());
		}
	books.add(book);
	overrideDatabase(books);
	}

	public Collection<Book> readBooks(){
		Collection<Book> result = new ArrayList<Book>();
		String line = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(database));
			while((line=br.readLine()) !=null) {
				String[] fields = line.split(FIELD_SEPARATOR);
				if(fields.length!= 5) {
					continue;
				}
				Publisher publisher = Publisher.valueOf(fields[0]);
				BookModel model = BookModel.valueOf(fields[1]);
				String writer = fields[2];
				int publicationYear = Integer.parseInt(fields[3]);
				int ID = Integer.parseInt(fields[4]);
				result.add(new Book(publisher, model, writer, publicationYear, ID));
			}
			} 
		catch (IOException e) {
		System.out.println(e);
		} catch (InvalidPublicationYearException e){
			e.printStackTrace();
		}
	return result;
	}
	
	public void updateBook(Book book) throws EntryNotFoundException {
		
	}
	public void deleteBook(Book book) throws EntryNotFoundException {
		Collection<Book> books = readBooks();
		if (books.contains(book) == false) {
			throw new EntryNotFoundException(book.toString());
		}
		books.remove(book);
		overrideDatabase(books);
	}
	private String marshal2record(Book book) {
		return ""+
				book.getPublisher().toString()+FIELD_SEPARATOR+
				book.getModel().toString()+FIELD_SEPARATOR+
				book.getWriter()+FIELD_SEPARATOR+
				book.getPublicationYear()+FIELD_SEPARATOR+
				book.getID()+FIELD_SEPARATOR;
	}
	
	private void overrideDatabase(Collection<Book> books) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(new FileWriter(database, false));
			for(Book book : books) {
				writer.println(marshal2record(book)+"\n");
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
	

	