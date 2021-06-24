package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Info;
import util.DBUtil;

public class ditudao {
  
	 public List<Info> search(String date,String province,String confirmed_num,String cured_num,String dead_num)
     {
         String sql = "select * from info1 where ";
         if (date != "") {
             sql += "date like '%" +date+ "%'";
         }
         List<Info> list = new ArrayList<>();
         Connection conn = DBUtil.conn();
         Statement state = null;
         ResultSet rs = null;
         Info bean = null;
         try {
             state = conn.createStatement();
             rs = state.executeQuery(sql);
             while (rs.next()) {
                 String Date2=rs.getString("date");
                 String Province2=rs.getString("province");
                 String Confirmed_num2=rs.getString("confirmed_num");
                 String Dead_num2 = rs.getString("dead_num");
                 String Cured_num2=rs.getString("cured_num");
                 bean =new Info(Date2, Province2,Confirmed_num2,Dead_num2,Cured_num2);
                 list.add(bean);
             }
         } catch (SQLException e) {
             e.printStackTrace();
         } finally {
             DBUtil.close(rs, state, conn);
         }
         
         return list;
     }
  
}