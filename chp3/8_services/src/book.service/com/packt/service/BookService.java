package com.packt.service;

import com.packt.model.Book;
import com.packt.spi.BookServiceProvider;
import java.io.Closeable;
import java.util.Iterator;
import java.util.ServiceLoader;

public interface BookService{
	public void create(Book book);
	public void read(String id);
	public void update(Book book);
	public void delete(String id);

	default static BookService getInstance(){
		ServiceLoader<BookServiceProvider> sl
            = ServiceLoader.load(BookServiceProvider.class);
        Iterator<BookServiceProvider> iter = sl.iterator();
        if (!iter.hasNext())
            throw new RuntimeException("No service providers found!");
        BookServiceProvider provider = iter.next();
        return provider.getBookService();
	}
}