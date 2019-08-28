package com.hecm.mystudent.interfase.one;

public class OnInterfaceImpl implements OneInterface {

    @Override
    public String hello(String word) {
        return "这是返回的结果:++"+word;
    }
}
