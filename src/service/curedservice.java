package service;

import java.util.List;

import dao.WorldDao;
import entity.cured;

public class curedservice {
	  WorldDao tDao=new WorldDao();
	    
	    public List<cured> search2(String Date,String Province,String cured_num) 
	    {
	        return tDao.search2(Date, Province,cured_num);
	    }
}
