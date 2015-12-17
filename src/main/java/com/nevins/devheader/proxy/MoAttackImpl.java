package com.nevins.devheader.proxy;

/**
 * Created by Administrator on 2015/12/17.
 */
public class MoAttackImpl implements IMoAttack {
    @Override
    public String cityGuardAsk() {
        System.out.println("who?");
        return "who?";
    }

    @Override
    public String geliReponse() {
        System.out.println("geli.");
        return "geli.";
    }
}
