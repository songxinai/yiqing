<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	setInterval("time.innerHTML='当前时间:'+new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);  
</script>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<div id="time">
</div>
</body>
</html>