package servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.confirmedservice;
import entity.confirmed;

@WebServlet("/confirmedservlet")
public class confirmedservlet extends HttpServlet{
	
    private static final long serialVersionUID = 1L;
    confirmedservice service = new confirmedservice();
    /**
     * 方法选择
     */
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        
        if ("search".equals(method)) {
            search(req, resp);
        } else if("search1".equals(method)) {
            search1(req, resp);
        } 
    }
    
    private void search(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.setCharacterEncoding("utf-8");
        String Date=req.getParameter("date");
        //String City = req.getParameter("city");
        
        String Province = req.getParameter("province");
        String Confirmed_num = req.getParameter("confirmed_num");
     
        List<confirmed> tens = service.search(Date,Province,Confirmed_num);
        if(tens==null)
        {
            req.setAttribute("message", "没有该信息");
            req.getRequestDispatcher("confirm.jsp").forward(req,resp);
        }
        else {
        req.setAttribute("tens", tens);
        req.getRequestDispatcher("confirm.jsp").forward(req,resp);
        }
    }
    
        private void search1(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
            req.setCharacterEncoding("utf-8");
            String Date=req.getParameter("date");
            //String City = req.getParameter("city");
            String Confirmed_num = req.getParameter("confirmed_num");
         
            List<confirmed> tens = service.search1(Date,Confirmed_num);
            if(tens==null)
            {
                req.setAttribute("message", "没有该信息");
                req.getRequestDispatcher("qushi.jsp").forward(req,resp);
            }
            else {
            req.setAttribute("tens", tens);
            req.getRequestDispatcher("qushi.jsp").forward(req,resp);
            }
    }
    
    
    
}