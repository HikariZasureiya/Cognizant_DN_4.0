package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    BookRepository brepo;

    public void setBrepo(BookRepository brepo) {
        this.brepo = brepo;
    }

    public void printbook() {
        brepo.printBook();
    }
}
