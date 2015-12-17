package com.nevins.devheader.proxy;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2015/12/17.
 */
public class Boss {

    static void poMethod(){
        System.out.println("old man.begin");
        IMoAttack iMoAttack=new MoAttackImpl();
        iMoAttack.cityGuardAsk();
        iMoAttack.geliReponse();
        System.out.println("old man..end");
    }

    static void proxyMethod(){
        IMoAttack moAttack=new MoAttackImpl();
        MoProxyHandler<IMoAttack> moProxyHandler=new MoProxyHandler<IMoAttack>(moAttack);

        IMoAttack iMoAttack=
                (IMoAttack)Proxy.newProxyInstance(moAttack.getClass().getClassLoader(),moAttack.getClass().getInterfaces(),moProxyHandler);

        System.out.println(iMoAttack.cityGuardAsk());
        System.out.println(iMoAttack.geliReponse());
    }

    static void cglibMethod(){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(MoAttack.class);
        enhancer.setCallback(new MyMethodInterceptor());
        MoAttack moAttack=(MoAttack)enhancer.create();
        System.out.println(moAttack.cityGuardAsk("new parameter"));
    }

    public static void main(String[] args){
        //poMethod();
        //proxyMethod();
        cglibMethod();
    }
}
