package servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.curedservice;
import entity.cured;

@WebServlet("/curedservlet")
public class curedservlet extends HttpServlet{
	
    private static final long serialVersionUID = 1L;
    curedservice service = new curedservice();
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
        String cured_num = req.getParameter("cured_num");
     
        List<cured> tens = service.search2(Date,Province,cured_num);
        if(tens==null)
        {
            req.setAttribute("message", "没有该信息");
            req.getRequestDispatcher("cure.jsp").forward(req,resp);
        }
        else {
        req.setAttribute("tens", tens);
        req.getRequestDispatcher("cure.jsp").forward(req,resp);
        }
    }
    
    
    
}