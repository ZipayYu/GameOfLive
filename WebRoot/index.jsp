<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>生命游戏</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        table tbody tr td {
            width: 30px;
            height: 30px;
            background-color: white;
            border: black;
        }

        input {
            width: 30px;
        }
    </style>

</head>

<body>
    行数：<input type="text" id="r"> 
    列数：<input type="text" id="c">
    <button id="init">生成随机细胞阵列</button>
    <button id="start">开始演化</button>
    <button id="stop">停止演化</button>
    <script>
    $(document).ready(function(){
    	var str1;
    	var str2;
    	var timer;
    	$("#stop").attr('disabled',true);
    	$("#start").attr('disabled',true);
    	

        
    	<!--发送数据并初始化-->
      $("#init").click(function () {
    	  clearInterval(timer);
      	var value2 = $("#c").val();
        var value1 = $("#r").val();
        if((/^(\+|-)?\d+$/.test( value1 ))&&value1>2&&value1<51&&(/^(\+|-)?\d+$/.test( value2 ))&&value2>2&&value1<51){
      	  $("#start").html("开始演化").attr('disabled',false);
          $.post("extern.jsp",{
            method:"init",
            row:$("#r").val(),
            col:$("#c").val()
          },
          function(data,status){
            str1=data;
            $("#result").html(str1);
          });
        }else{
            alert("请在行数和列数中输入3~50内的整数！");
        };

        });
		
      <!--更新下一代细胞状态-->
        function fun() {
        $.post("extern.jsp",{
          method:"cont",
        },
        function(data,status){
          str2=data;
          $("#result").html(data);
          if(str1==str2)
        	  {
        	  alert("演化达到固定状态");
        	  $("#start").html("开始演化");
        	  clearInterval(timer);
        	  
        	  }
          else{str1=str2;}
        });
        
        };

        <!--开始演化-->
       $("#start").click(function(){
    	   $("#start").attr('disabled',true);
    	   $("#stop").attr('disabled',false);
    	   timer = setInterval(fun, 1000);
    });
       
       <!--暂停演化-->
       $("#stop").click(function(){
    	   clearInterval(timer);
    	   $("#start").html("继续演化").attr('disabled',false);
    	   
    });
    })
    </script>
    <div id="result">

    </div>

    <a></a>



</body>

</html>