<!DOCTYPE html>
 <html layout:decorator="fregments/layout">
 <head>
<meta charset="UTF-8" />

<script type="text/javascript" src="http://localhost:8080/resource/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
var checkboxValue= new Array();
 checkboxValue.push(1);
 checkboxValue.push(2);
  $.ajax({
 	 type : "POST",
   	 url :  "/implicitTerrorists2/updtaControlState",
	 dataType: "json", 
        data:JSON.stringify(checkboxValue),
        contentType: 'application/json;charset=UTF-8',
        success : function(jsonData) {  console.log("ok"); },
        error : function(errorMsg) { 
        	console.log("err");
        }
		});
</script>
<title> 测试页面com.demomodel.mysqlcontroller.controller.ImplicitTerroristController</title>
	
</head>
<body>
	<h2>Hello World!ImplicitTerroristController  thymeleaf</h2>
</body>
</html> 

