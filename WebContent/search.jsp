<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<%
          Object message = request.getAttribute("message");
          if(message!=null && !"".equals(message)){
      
     %>
          <script type="text/javascript">
               alert("<%=request.getAttribute("message")%>");
          </script>
     <%} %>
<h>查找</h>
    <div class="content">
        <div class="main">
       
        <br><br>
        <form name="form" action="yiqingservlet?method=search" method="post" ">
            <a>时间</a>&nbsp;&nbsp;<input type="text" name="date" /><br/>
             <a>地区</a>&nbsp;&nbsp;<input type="text" name="diqu" />
            <br><br>
            <input type="submit" value="查找" /></td>
        </form>
        </div>
    </div>
</body>
</html>