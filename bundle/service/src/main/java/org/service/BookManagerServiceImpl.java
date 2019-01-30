package org.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.core.model.Book;
import org.core.model.Publisher;
import org.core.service.BookManagerService;
import org.core.service.exception.BookAlreadyExistsException;
import org.core.service.exception.BookDoesNotExistsException;
import org.dao.BookDAO;
import org.dao.exception.DuplicatedBookEntryException;
import org.dao.exception.EntryNotFoundExpcetion;

public class BookManagerServiceImpl implements BookManagerService{
	
	private BookDAO bookDAO;

	public BookManagerServiceImpl() {
		super ();
		this.bookDAO = bookDAO;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void recordBook(Book book) throws BookAlreadyExistsException {
		try {
			bookDAO.createBook(book);
		} catch (DuplicatedBookEntryException e) {
			throw new BookAlreadyExistsException(e);
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBook(Book book) throws BookDoesNotExistsException {
		try {
			bookDAO.updateBook(book);
		} catch (EntryNotFoundExpcetion e) {
			throw new BookDoesNotExistsException(e);
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Book> listBooks() {
		// TODO Auto-generated method stub
		return bookDAO.readBooks();
	}

	@Override
	public Collection<Book> listBooksByPublisher(Publisher publisher) {
		Set<Book> result = new HashSet<Book>();
		for (Book book : listBooks()) {
			if(book.getPublisher() == publisher) {
				result.add(book);
			}
			
		}
		// TODO Auto-generated method stub
		return result;
	}

}
