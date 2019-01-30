package org.dao;

import java.util.Collection;

import org.core.model.Book;
import org.dao.exception.DuplicatedBookEntryException;
import org.dao.exception.EntryNotFoundExpcetion;


/**
 * Data Access Object 
 * CREATE
 * READ
 * UPDATE
 * DELETE
 */

public interface BookDAO {
	
void createBook(Book book) throws DuplicatedBookEntryException;
	
	Collection<Book> readBooks();
	
	void updateBook(Book book) throws EntryNotFoundExpcetion;
	void deleteBook(Book book) throws EntryNotFoundExpcetion;

}
