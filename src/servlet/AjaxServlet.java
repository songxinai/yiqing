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

import entity.Info;
import dao.ditudao;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
	ditudao dao = new ditudao();
 
    public AjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");
        if(method.equals("ditu")) {
            try {
                ditu(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void ditu(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
   	    String Date=request.getParameter("date");        
        String Province = request.getParameter("province");
        String Confirmed_num = request.getParameter("confirmed_num");
        String Dead_num=request.getParameter("dead_num");
        String Cured_num=request.getParameter("cured_num");
        List<Info> list = dao.search(Date,Province,Confirmed_num,Dead_num,Cured_num);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.print(json);
        response.getWriter().write(json);
   }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}