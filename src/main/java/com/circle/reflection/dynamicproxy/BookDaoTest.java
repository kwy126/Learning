package com.circle.reflection.dynamicproxy;

/**
 * @Author KeWeiYang
 */
public class BookDaoTest {

    public static void main(String[] args) {
        /*BookDao dao = new BookDaoImpl();
        dao.addBook("1", "Thinking in Java!");*/

        BookDao dao = new BookDaoImpl();
        DaoProxy proxy = new DaoProxy();
        BookDao bookProxy = (BookDao) proxy.bind(dao);

        bookProxy.addBook("1", "Thinking in Java!");
    }
}
