package com.circle.reflection.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BookDAOProxy implements InvocationHandler {
    private Object target;

    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    /**
     *
     * @param proxy
     * @param method 被代理对象的方法，比如说是BookDAOImpl中的addBook方法和getBook方法
     * @param args 方法参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = null;

        if ("addBook".equals(method.getName())) {
            System.out.println("事务开始！");
            // 反射
            result = method.invoke(proxy, args);
            System.out.println("事务结束！");
        }

        return result;
    }
}
