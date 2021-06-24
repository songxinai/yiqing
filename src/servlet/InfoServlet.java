package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import dao.InfoDao;
import entity.Info;


@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    InfoDao dao = new InfoDao();
    public InfoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");
        if(method.equals("tu")) {
            try {
                tu(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    private void tu(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
    	 String Date=request.getParameter("date");
         String Province = request.getParameter("province");
         String Confirmed_num = request.getParameter("confirmed_num");
         String Dead_num=request.getParameter("dead_num");
         String Cured_num=request.getParameter("cured_num");
         String Yisi_num=request.getParameter("yisi_num"); 
         List<Info> list = dao.search(Date,Province,Confirmed_num,Dead_num,Cured_num,Yisi_num);
         Gson gson = new Gson();
         String json = gson.toJson(list);
         System.out.print(json);
         response.getWriter().write(json);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}