package servlet;

import java.sql.Connection;
import java.sql.Statement;

import util.DBUtil;

public class AddService {
    public void add(String table,String sheng,String xinzeng,String leiji,String zhiyu,String dead,String time,int Kind) {
        String sql = "insert into "+table+" (ProvinceName,Newconfirmed_num ,confirmedCount,curedCount,deadCount,Date,Kind) values('" + sheng + "','" + xinzeng +"','" + leiji +"','" + zhiyu + "','" + dead+ "','" + time+ "','" + Kind +"')";
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