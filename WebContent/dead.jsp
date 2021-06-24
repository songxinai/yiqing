<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
  <div class="search" style="background:black">
        <form name="form" action="deadservlet?method=search" method="post">
            <a>时间</a>&nbsp;&nbsp;<input type="text" name="date" />
            <input type="submit" value="查询" />
        </form>
  </div>
  
  <div class="list" style="background:black;color:white">
        <table>
            <tr>
                <th>日期</th>
                <th>国家</th>
                <th>死亡人数</th>
            <tr>
            
            <c:forEach items="${tens}" var="item">
                <tr>
                	<td>${item.date}</td>
                	<td>${item.province}</td>
                    <td>${item.dead_num}</td>
                </tr>
           </c:forEach>
       </table>
    </div>
</body>
</html>