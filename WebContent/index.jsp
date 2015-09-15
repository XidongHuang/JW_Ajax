<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	window.onload = function(){
		//1. Gain node a, and add function on "onclick"
		document.getElementsByTagName("a")[0].onclick= function(){
			
			//3. Create XMLHttpRequest Object
			var request = new XMLHttpRequest();
			
			
			//4. Prapare to send requests' data: url
			var url = this.href +"?time=" + new Date();
			var method = "POST";
			
			//5. Invoke XMLHttpRequest Object's open method
			request.open(method, url);
			
			request.setRequestHeader("ContentType", "application/x-www-form-urlencoded");
			
			//6. Invoke XMLHttpRequest Object's send method
			request.send("name='Tony'");
			
			
			//7. Add XMLHttpRequest Object a function called onreadystatechange function
			request.onreadystatechange = function(){
			//8. Judge the response if finished or not: XMLHttpRequest Object's readyState value is 4
				if(request.readyState == 4){
			//9. Judge it can be used or not: XMLHttpRequest Object status value is 200
					if(request.status == 200 || request.status == 403)
					//10. Print response result: responseText
					
					alert(request.responseText);
					
				}
				
				
			}
			
			
			
			
			
			
			
			
			
			//2. cancle default action
			return false;
		}
		
		
	}


</script>


</head>
<body>

	<a href="helloAjax.txt">HelloAjax</a>
</body>
</html>