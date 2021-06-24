package servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.deadservice;
import entity.dead;

@WebServlet("/deadservlet")
public class deadservlet extends HttpServlet{
	
    private static final long serialVersionUID = 1L;
    deadservice service = new deadservice();
    /**
     * 方法选择
     */
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        
        if ("search".equals(method)) {
            search(req, resp);
        } 
    }
    
    private void search(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.setCharacterEncoding("utf-8");
        String Date=req.getParameter("date");
        //String City = req.getParameter("city");
        
        String Province = req.getParameter("province");
        String dead_num = req.getParameter("dead_num");
     
        List<dead> tens = service.search1(Date,Province,dead_num);
        if(tens==null)
        {
            req.setAttribute("message", "没有该信息");
            req.getRequestDispatcher("dead.jsp").forward(req,resp);
        }
        else {
        req.setAttribute("tens", tens);
        req.getRequestDispatcher("dead.jsp").forward(req,resp);
        }
    }
    
    
    
}