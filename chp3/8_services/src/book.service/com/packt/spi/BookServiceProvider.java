package com.packt;

import com.packt.service.BookService;

public interface BookServiceProvider{
	public BookService getBookService();
}