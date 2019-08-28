package com.hecm.mystudent.interfase.two;

public class IntefaseServiceImpl implements IntefaseService {

    private IntefaseDao intefaseDao;

    public IntefaseServiceImpl(IntefaseDaoImpl intefaseDao) {
        this.intefaseDao=intefaseDao;
    }

    public void setIntefaseDao(IntefaseDao intefaseDao){
        this.intefaseDao=intefaseDao;
    }
    @Override
    public void save(String arg) {
        System.out.println("service接收"+arg);
        arg=arg+":"+this.hashCode();
        intefaseDao.save(arg);
    }
}
