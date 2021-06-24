package service;
import java.util.List;

import dao.yiqingdao;
import entity.yiqing;
public class yiqingservice {
    yiqingdao tDao=new yiqingdao();
   
    public List<yiqing> search(String Date,String Province,String Confirmed_num,String Yisi_num,String Cured_num,String Dead_num) {
        return tDao.search(Date, Province,Confirmed_num,Yisi_num,Cured_num,Dead_num);
    }
}