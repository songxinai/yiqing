package servlet; 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException; 
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.SQLException; 
import java.util.ArrayList; 
import java.util.List; 
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
class Point{ 
	private String province; 	
	private int xinzeng; 
	private int confirmed_num;
	private int cured_num;
	private int dead_num; 	
	public String getProvince()
	{ 	
		return province; 
	} 
	public void setProvince(String province)
	{ 		
		this.province = province; 	
	} 	
	public int getXinzeng()
	{ 	
		return xinzeng; 
	} 	
	public void setXinzeng(int xinzeng) 
	{ 		
		this.xinzeng = xinzeng; 	
	} 	
	public int getConfirmed_num()
	{ 	
		return confirmed_num; 
	} 
	public void setConfirmed_num(int confirmed_num)
	{ 	
		this.confirmed_num =confirmed_num ; 
	} 	
	public int getCured_num()
	{ 	
		return cured_num; 
	} 
	public void setCured_num(int cured_num)
	{ 	
		this.cured_num =cured_num ; 
	} 	
	public int getDead_num()
	{ 	
		return dead_num; 
	} 
	public void setDead_num(int dead_num)
	{ 	
		this.dead_num =dead_num ; 
	} 	
	public Point() 
	{ 		
		super(); 
	} 	
	public Point(String province, int xinzeng, int confirmed_num, int cured_num, int dead_num)
	{ 		
		super(); 
		this.province = province; 
		this.xinzeng = xinzeng; 
		this.confirmed_num = confirmed_num; 	
		this.cured_num = cured_num; 	
		this.dead_num = dead_num; 
		}
	}
public class ss 
{ 	 
	public static String getContent(String urlStr, String s)
	{ 		
		StringBuilder sb = new StringBuilder(); 	
		URL url; 	
		try { 		
			url = new URL(urlStr); 	
			BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), s)); 	
			String temp = ""; 	
			while((temp=bf.readLine())!=null)
			{ 		
				sb.append(temp); 		
			} 
		} catch (MalformedURLException e) 
		{ 		
			e.printStackTrace(); 
		} catch (UnsupportedEncodingException e) { 	
			e.printStackTrace(); 	
		} catch (IOException e) { 
			e.printStackTrace(); 	
		} 	
		return sb.toString(); 	
	} 	 	
	public static List<Point> getStr(String des, String regex)
	{ 	
		Pattern p = Pattern.compile(regex); 	
		Matcher m = p.matcher(des);
		List<Point> list = new ArrayList<Point>(); 		
		while(m.find()) { 		
			Point pp = new Point(m.group(1),Integer.parseInt(m.group(2)),Integer.parseInt(m.group(3)),Integer.parseInt(m.group(4)),Integer.parseInt(m.group(5))); 
			list.add(pp); 	
		} 	
		return list; 	
	} 	 	
	public static void mySql(String sql,List<Point> list) 
	{ 	
		String jdbc = "com.mysql.jdbc.Driver"; 	
		String user = "root"; 
		String password = "123456"; 	
		String url = "jdbc:mysql://localhost/t_user"; 	
		Connection con = null; 
		PreparedStatement ps = null; 	
		try { 		
			Class.forName(jdbc); 	
			con = DriverManager.getConnection(url, user, password); 
			ps = con.prepareStatement(sql); 
			for(int i = 0; i<list.size();i++) { 
				ps.setString(1,list.get(i).getProvince()); 
				ps.setInt(2,list.get(i).getXinzeng()); 	
				ps.setInt(3,list.get(i).getConfirmed_num()); 
				ps.setInt(4,list.get(i).getCured_num()); 	
				ps.setInt(5,list.get(i).getDead_num()); 			
				ps.executeUpdate(); 	
				} 			
			} catch (ClassNotFoundException e) 
		{ 	
				e.printStackTrace(); 	
		} catch (SQLException e) { 	
			e.printStackTrace(); 
			}finally { 		
				try { 			
					ps.close(); 	
					}catch (Exception e) { 
						e.printStackTrace(); 	
						} 		
				try { 		
							con.close(); 	
					}catch (Exception e) { 
						e.printStackTrace(); 		
						} 		
				} 	
		} 	
	public static String prt(Point p) 
	{ 	
		return "省份: "+p.getProvince()+" 新增病例: "+p.getXinzeng()+" 确诊人数: "+p.getConfirmed_num()+" 治愈人数: "+p.getCured_num()+" 死亡人数: "+p.getDead_num();
	} 	 
	public static void main(String[] args) throws IOException
	{ 		
		String des = getContent("https://gisanddata.maps.arcgis.com/apps/opsdashboard/index.html#/bda7594740fd40299423467b48e9ecf6", "utf-8"); 	
		System.out.println(des); 
		PrintStream ps = new PrintStream("D:\\auditlog.txt");
		System.setOut(ps);
		System.out.println(des);
		List<Point> list = getStr(des, ""); 	
		mySql("insert into info(province,xinzeng,confirmed_num,cured_num,dead_num,)values(?,?,?,?,?)",list); 
		for(Point temp: list) 
		{
			System.out.println(prt(temp)); 	
		}
	} 
}