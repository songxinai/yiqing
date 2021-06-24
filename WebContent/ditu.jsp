<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%">

<head>
<meta charset="utf-8">
<base>
<title>地图阶段二</title>
<script src="js/jquery.js" type="text/javascript"></script>
<script type="text/javascript" src="js/echarts.js"></script>
<script type="text/javascript" src="js/china.js"></script>
</head>
<body style="height: 100%; margin: 0">
    <div class="row" style="background-color: silver; height: 50px">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日期 <input type="text" name="date"
            id="date" placeholder="yyyy-MM-dd hh:mm:ss"> <input
            type="button" value="查询" onclick="tu()">
    </div>
    <div id="main" style="width:1000px;height:800px"></div>
</body>
<script type="text/javascript">
    function randomData() {
        return Math.round(Math.random() * 500);
    }
    var dt;
    var mydata1 = new Array(0);
   
    function tu() {
        date = $("#date").val();
        //alert(time.substring(0, 2));
        $.ajax({
            url : "InfoServlet?method=tu",
            async : true,
            type : "POST",
            data : {
                "date" : date
            },
            success : function(data) {
                dt = data;
             
                for (var i = 0; i < 33; i++) {
                    var d = {
                        
                    };
                    
                    d["name"] = dt[i].province;//.substring(0, 2);
                    d["value"] = dt[i].confirmed_num;
                    d["dead_num"] = dt[i].dead_num;
                    d["cured_num"] = dt[i].cured_num;
                    d["yisi_num"] = dt[i].yisi_num;
                    mydata1.push(d);
                }
                
                //var mdata = JSON.stringify(mydata1);
                var optionMap = {
                    backgroundColor : '#FFFFFF',
                    title : {
                        text : '全国地图大数据',
                        subtext : '',
                        x : 'center'
                    },
                    tooltip : {
                          trigger: 'item',
                        formatter : function(params) {
                            return params.name + '<br/>' + '确诊人数 : '
                                    + params.value + '<br/>' + '死亡人数 : '
                                    + params['data'].dead_num + '<br/>' + '治愈人数 : '
                                    + params['data'].cured_num + '<br/>'+ '疑似患者人数 : '
                                    + params['data'].yisi_num;
                        }//数据格式化
                    },

                    //左侧小导航图标
                    visualMap : {
                        min : 0,
                        max : 35000,
                        text : [ '多', '少' ],
                        realtime : false,
                        calculable : true,
                        inRange : {
                            color : [ 'lightskyblue', 'yellow', 'orangered' ]
                        }
                    },
          
                    //配置属性
                    series : [ {
                        type : 'map',
                        mapType : 'china',
                        label : {
                            show : true
                        },
                        data : mydata1,
                        nameMap : 
                        {
                            '南海诸岛' : '南海诸岛',
                            '西藏' : '西藏自治区'
                        }
                    }]
                };
                //初始化echarts实例
                var myChart = echarts.init(document.getElementById('main'));
                myChart.on('click',function(params)
                {
                    url="CityServlet?method=city&date="+date+"&province="+params.name;
                    window.location.href=url;
                    });
                //使用制定的配置项和数据显示图表
                myChart.setOption(optionMap);
            },
            error : function() {
                alert("请求失败");
            },
            dataType : "json"
        });
    }
</script>
</html>