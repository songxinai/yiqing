package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.City;
import entity.Info;
import dao.InfoDao;
import com.google.gson.Gson;

/**
 * Servlet implementation class proServlet
 */
@WebServlet("/CityServlet")
public class CityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    InfoDao dao = new InfoDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	 
           response.setContentType("text/html;charset=utf-8");
        
           response.setCharacterEncoding("UTF-8");
            String method = request.getParameter("method");
            if(method.equals("d")) {
                try {
                    d(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                }else if(method.equals("city")) {
                    try {
                        city(request, response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
        }
            /**
             * @param request
             * @param response
             */
            private void d(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
                // TODO Auto-generated method stub
            	String Date=request.getParameter("date");
            	String City = request.getParameter("city");	
                String Province = request.getParameter("province");
                String Confirmed_num = request.getParameter("confirmed_num");
                String Dead_num=request.getParameter("dead_num");
                String Cured_num=request.getParameter("cured_num");
                String Yisi_num=request.getParameter("yisi_num");
                List<Info> list = dao.search1(Date,Province, City,Confirmed_num,Dead_num,Cured_num,Yisi_num);
                List<City> data = new ArrayList<City>();
                for(int i=1; i<list.size();i++) {
                    City city = new City();
                    city.setProvince(list.get(i).getCity());
                    city.setConfirmed_num(list.get(i).getConfirmed_num());
                    data.add(city);
                }
                Gson gson = new Gson();
                String json = gson.toJson(data);
                response.getWriter().write(json);
            }

            /**
             * @param request
             * @param response
             */
            private void city(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
                // TODO Auto-generated method stub
            	String Date=request.getParameter("date");
                String Province = request.getParameter("province");
            	String City = request.getParameter("city");
                String Confirmed_num = request.getParameter("confirmed_num");
                String Dead_num=request.getParameter("dead_num");
                String Cured_num=request.getParameter("cured_num");
                String Yisi_num=request.getParameter("yisi_num");
                List<Info> list = dao.search1(Date,Province, City,Confirmed_num,Dead_num,Cured_num,Yisi_num);
           
                List<City> data = new ArrayList<City>();
                for(int i=1; i<list.size();i++) {
                    City city = new City();
                    city.setProvince(list.get(i).getCity());
                    city.setConfirmed_num(list.get(i).getConfirmed_num());
                    data.add(city);
                }
                Gson gson = new Gson();
                String json = gson.toJson(data);
                request.setAttribute("json", json);
                request.setAttribute("province", Province);
                request.getRequestDispatcher("ditu1.jsp").forward(request, response);
            }

      
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
