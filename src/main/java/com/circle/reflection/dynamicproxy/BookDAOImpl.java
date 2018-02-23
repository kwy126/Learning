package com.circle.reflection.dynamicproxy;

import com.circle.reflection.Book;

public class BookDAOImpl implements BookDAO {
    public void addBook(String id, String name) {
        System.out.println("增加一本书，name= "+ name);
    }

    public Book getBook(String id) {
        return new Book(id, "Thinking in Java");
    }
}
