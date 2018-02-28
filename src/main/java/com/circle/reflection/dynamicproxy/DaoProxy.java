package com.circle.reflection.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  @Author KeWeiYang
 */
public class DaoProxy implements InvocationHandler {
    private Object target;

    private static final String METHOND_NAME = "addBook";

    public Object bind(Object target){
        this.target = target;

        System.out.println(target.getClass().getClassLoader().toString());
        System.out.println(target.getClass().getInterfaces().toString());
        Object retValue = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
        System.out.println(retValue);

        return retValue;
    }

    /**
     *
     * @param proxy
     * @param method 被代理对象的方法，比如说是BookDAOImpl中的addBook方法和getBook方法
     * @param args 方法参数A
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{

        Object result = null;

        if (METHOND_NAME.equals(method.getName())) {
            System.out.println("事务开始！");
            // 反射
            result = method.invoke(proxy, args);
            System.out.println("事务结束！");
        }

        return result;
    }

}
