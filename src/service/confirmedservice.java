package service;

import java.util.List;

import dao.WorldDao;
import entity.confirmed;

public class confirmedservice {
    WorldDao tDao=new WorldDao();
    
    public List<confirmed> search(String Date,String Province,String Confirmed_num) 
    {
        return tDao.search(Date, Province,Confirmed_num);
    }
    
    public List<confirmed> search1(String Date,String Confirmed_num) 
    {
        return tDao.search11(Date,Confirmed_num);
    }
}
