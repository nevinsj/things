package com.nevins.devheader.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2015/12/17.
 */
public class MoProxyHandler<T> implements InvocationHandler {
    /**
     * 代理处理器,
     * @param proxy 创建的代理类
     * @param method 方法名
     * @param args 方法参数
     * @return
     * @throws Throwable
     */
    private T obj;

    public MoProxyHandler(){}

    public MoProxyHandler(T obj){
        this.obj=obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       /*
       * proxy.getClass().getName();
        method.getName();

       * */
        Object o=method.invoke(obj,args);
         return o.toString()+"_new";
    }
}
