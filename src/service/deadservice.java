package service;

import java.util.List;

import dao.WorldDao;
import entity.dead;

public class deadservice {
	  WorldDao tDao=new WorldDao();
	    
	    public List<dead> search1(String Date,String Province,String dead_num) 
	    {
	        return tDao.search1(Date, Province,dead_num);
	    }
}
