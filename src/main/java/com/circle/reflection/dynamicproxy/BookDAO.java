package com.circle.reflection.dynamicproxy;

import com.circle.reflection.Book;

public interface BookDAO {
    public void addBook(String id, String name);

    public Book getBook(String id);

}
