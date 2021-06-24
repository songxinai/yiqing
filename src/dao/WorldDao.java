package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.confirmed;
import entity.dead;
import entity.cured;
import util.DBUtil;

public class WorldDao {
	  //≤È’“
    public List<confirmed> search(String date,String province,String confirmed_num)
    {
        String sql = "select * from info1 where ";
        if (date != "") {
            sql += "date like '%" +date+ "%'";
        }
        List<confirmed> list = new ArrayList<>();
        Connection conn = DBUtil.conn();
        Statement state = null;
        ResultSet rs = null;
        confirmed bean = null;
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                String Date2=rs.getString("date");
                String Province2=rs.getString("province");
                String Confirmed_num2=rs.getString("confirmed_num");
                bean =new confirmed(Date2, Province2,Confirmed_num2);
                list.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, state, conn);
        }
        
        return list;
    }
 
    public List<confirmed> search11(String date,String confirmed_num)
    {
        String sql = "select * from info1 where ";
        if (date != "") {
            sql += "date like '%" +date+ "%'";
        }
        List<confirmed> list = new ArrayList<>();
        Connection conn = DBUtil.conn();
        Statement state = null;
        ResultSet rs = null;
        confirmed bean = null;
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                String Date2=rs.getString("date");
                String Confirmed_num2=rs.getString("confirmed_num");
                bean =new confirmed(Date2,Confirmed_num2);
                list.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, state, conn);
        }
        
        return list;
    }
    
    public List<dead> search1(String date,String province,String dead_num)
    {
        String sql = "select * from info1 where ";
        if (date != "") {
            sql += "date like '%" +date+ "%'";
        }
        List<dead> list = new ArrayList<>();
        Connection conn = DBUtil.conn();
        Statement state = null;
        ResultSet rs = null;
        dead bean = null;
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
            
                String Date2=rs.getString("date");
                String Province2=rs.getString("province");
                String Dead_num2 = rs.getString("dead_num");
                bean =new dead(Date2, Province2, Dead_num2);
                list.add(bean);
                System.out.print(list);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, state, conn);
        }            
        return list;
    }
    
    public List<cured> search2(String date,String province,String cured_num)
    {
        String sql = "select * from info1 where ";
        if (date != "") {
            sql += "date like '%" +date+ "%'";
        }
        List<cured> list = new ArrayList<>();
        Connection conn = DBUtil.conn();
        Statement state = null;
        ResultSet rs = null;
        cured bean = null;
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
            
                String Date2=rs.getString("date");
                String Province2=rs.getString("province");
                String Cured_num2=rs.getString("cured_num");
                bean =new cured(Date2, Province2, Cured_num2);
                list.add(bean);
                System.out.print(list);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, state, conn);
        }            
        return list;
    }
}
