<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://cdn.bootcss.com/echarts/4.2.1-rc1/echarts.min.js"></script>
<script src="jquery.js"></script>
</head>
<body> 
<div class="search" style="background:black">
        <form name="form" action="confirmedservlet?method=search1" method="post">
            <a>时间</a>&nbsp;&nbsp;<input type="text" name="date" />
            <input type="submit" value="查询" />
        </form>
        <br/>
</div>

<div id="line" style="width: 600px;height:400px;border:1px solid #ccc;background:black"></div> 
  <script type="text/javascript">
// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('line'));
var arr = new Array();
var index = 0;
<c:forEach items="${tens}" var="goods">
    arr[index++] = ${goods.confirmed_num};
</c:forEach>
// 指定图表的配置项和数据
var option = {
    title: {
        text: '确诊人数随时间变化'
    },
    toolbox:{
        show:true,
        feature:{
            saveAsImage:{
                show:true
            }
        }
    },
    legend: {
        data:['确诊人数']
    },
    xAxis: [
        {
            type : 'category',
            
            data : [
                <c:forEach items="${tens}" var="g">
                ["${g.date}"],
                </c:forEach>
            ]
        }
    ],

    yAxis : {},
    series: [{
        name: '确诊人数',
        type: 'line',
        data: arr,
        itemStyle:{
            normal:{
              // 拐点上显示数值
              label : {
              show: true
              },
              borderColor:'red',  // 拐点边框颜色
              lineStyle:{                 
                width:1,  // 设置线宽
                type:'solid'  //'dotted'虚线 'solid'实线
              }
            }
          }
    }]
};
// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);
    </script>
</body>
</html>