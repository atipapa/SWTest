package org.core.service;

import org.core.model.Book;
import org.core.service.exception.BookAlreadyExistsException;
import org.core.service.exception.BookDoesNotExistsException;;;

public interface BookManagerService {

		void recordBook(Book book) throws BookAlreadyExistsException;
		void updateBook(Book book) throws BookDoesNotExistsException;
}
