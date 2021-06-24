package servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.yiqing;
import service.yiqingservice;
@WebServlet("/yiqingservlet")
public class yiqingservlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    yiqingservice service = new yiqingservice();
    
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
        String Confirmed_num = req.getParameter("confirmed_num");
        String Dead_num=req.getParameter("dead_num");
        String Yisi_num=req.getParameter("yisi_num");
        String Cured_num=req.getParameter("cured_num");
        String code=req.getParameter("code");
        List<yiqing> tens = service.search(Date,Province,Confirmed_num,Yisi_num,Cured_num,Dead_num);
        if(tens==null)
        {
            req.setAttribute("message", "没有该信息");
            req.getRequestDispatcher("search.jsp").forward(req,resp);
        }
        else {
        req.setAttribute("tens", tens);
        req.getRequestDispatcher("list2.jsp").forward(req,resp);
        }
    }
    
    
    
}