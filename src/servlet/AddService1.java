package servlet;

import java.sql.Connection;
import java.sql.Statement;

import util.DBUtil;

public class AddService1 {
    public void add(String table,String sheng,String xinzeng,String leiji,String zhiyu,String dead,String time) {
        String sql = "insert into "+table+" (Province,Newconfirmed_num ,Confirmed_num,Cured_num,Dead_num,Date) values('" + sheng + "','" + xinzeng +"','" + leiji +"','" + zhiyu + "','" + dead+ "','" + time+"')";
        System.out.println(sql);
        Connection conn = DBUtil.conn();
        Statement state = null;
        int a = 0;
        try {
            state = conn.createStatement();
            a=state.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(state, conn);
        }        
    }
}