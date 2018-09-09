<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/exp/plugin/back/others/js/echarts.js"></script>
  <script type="text/javascript" src="/exp/plugin/back/others/js/esl.js" ></script>
   <script type="text/javascript" charset="utf-8" src="/exp/plugin/back/js/jquery-3.2.1.min.js"></script>
   
   
</head>
<body>
<div id="main" style="height:600px;width:100%"></div>
</body>
<script type="text/javascript">
        // 路径配置
        require.config({
            paths:{ 
                'echarts' :'/exp/plugin/back/others/js/echarts',
                'echarts/chart/line':'/exp/plugin/back/others/js/echarts',
                'echarts/chart/bar':'/exp/plugin/back/others/js/echarts'
            }
        });
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/line',
                'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
            ],
            drewEcharts
        );
         function drewEcharts(ec) {
                // 基于准备好的dom，初始化echarts图表
                myChart = ec.init(document.getElementById('main')); 
                var option = {
                    tooltip: {
                        show: true
                    },
                    color:['#6FBCE0','#F7F7F7','#F7F7F7','#F7F7F7','#F7F7F7','#F7F7F7','#F7F7F7','#F7F7F7','#F7F7F7','#F7F7F7','#F7F7F7','#F7F7F7'],  
                    legend: {
                        data:['类别']
                    },
                    toolbox: {
                        show : true,
                        feature : {
                           
                            restore : {show: true}
                            
                        }
                    },
                    

                    xAxis : [
                        {
                            type : 'category',
                            data : (function(){
                                    var arr=[];
                                        $.ajax({
                                        type : "post",
                                        async : false, //同步执行
                                        url : "/exp/XJsonServlet",
                                        data : {},
                                        dataType : "json", //返回数据形式为json
                                        success : function(result) {
                                        if (result) {
                                               for(var i=0;i<result.length;i++){
                                                  console.log(result[i].name);
                                                  arr.push(result[i].name);
                                                }    
                                        }
                                        
                                    },
                                    error : function(errorMsg) {
                                        alert("不好意思，大爷，图表请求数据失败啦!");
                                        myChart.hideLoading();
                                    }
                                   })
                                   return arr;
                                })() 
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value'
                        }
                    ],
                    series : [
                        {
                            "name":"类别",
                            "type":"bar",
                            "data":(function(){
                                        var arr=[];
                                        $.ajax({
                                        type : "post",
                                        async : false, //同步执行
                                        url : "/exp/XJsonServlet",
                                        data : {},
                                        

                                        dataType : "json", //返回数据形式为json
                                        success : function(result) {
                                        if (result) {
                                               for(var i=0;i<result.length;i++){
                                                  console.log(result[i].num);
                                                  arr.push(result[i].num);
                                                }  
                                        }
                                    },
                                    error : function(errorMsg) {
                                        alert("不好意思，大爷，图表请求数据失败啦!");
                                        myChart.hideLoading();
                                    }
                                   })
                                  return arr;
                            })()
                            
                        }
                    ]
                };               
                // 为echarts对象加载数据 
                myChart.setOption(option);  
                
            }
    </script>

</html>