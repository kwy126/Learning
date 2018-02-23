package com.circle.reflection.dynamicproxy;

public class BookDAOTest {

    public static void main(String[] args) {
        BookDAO dao = new BookDAOImpl();
        //dao.addBook("1", "Thinking in Java!");

        BookDAOProxy proxy = new BookDAOProxy();
        BookDAO bookProxy = (BookDAO) proxy.bind(dao);
        bookProxy.addBook("1","Thinking in Java!");
    }
}
