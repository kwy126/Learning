package com.circle.reflection.dynamicproxy;

import com.circle.reflection.Book;

/**
 * @Author KeWeiYang
 * @Date 2018/2/28 14:03
 * @DES
 */
public class BookDaoImpl implements BookDao {

    @Override
    public void addBook(String id, String name) {
        System.out.println("增加一本书，name= " + name);
    }

    @Override
    public Book getBook(String id) {
        return new Book(id, "Thinking in Java");
    }
}
