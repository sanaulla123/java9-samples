package com.packt.mongodb;

import com.packt.spi.BookServiceProvider;
import com.packt.mongodb.service.MongoDbBookService;

public class MongoDbBookServiceProvider implements BookServiceProvider{

	@Override
	public BookService getBookService(){
		return new MongoDbBookService();
	}
}