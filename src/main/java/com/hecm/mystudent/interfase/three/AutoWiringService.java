package com.hecm.mystudent.interfase.three;

public class AutoWiringService {
    private AutoWiringDao autoWiringDao;
    public void setAutoWiringDao(AutoWiringDao autoWiringDao){
        this.autoWiringDao=autoWiringDao;
    }
        public void say(String agr){
        autoWiringDao.say(agr);
        }
}
