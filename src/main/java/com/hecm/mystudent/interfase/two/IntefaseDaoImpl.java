package com.hecm.mystudent.interfase.two;

public class IntefaseDaoImpl implements IntefaseDao{
    @Override
    public void save(String arg) {
        System.out.println("保存数据+"+arg);
    }
}
