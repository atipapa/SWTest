package org.core.service;

import java.util.Collection;

import org.core.model.Book;
import org.core.model.Publisher;
import org.core.service.exception.BookAlreadyExistsException;;;

public interface BookManagerService {

		void recordBook(Book book) throws BookAlreadyExistsException;
		void updateBook(Book book) throws BookDoes
}
