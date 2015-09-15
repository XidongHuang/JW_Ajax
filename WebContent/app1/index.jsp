<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 
1. Import JQuery lib
2. Gain name="username" node: username
3. Add "change" function into username
3.1 Gain username's value, git rid of space at the beginning and the end. Prepare to send Ajax request
3.2 Send Ajax request to check username can be used or not
3.3 Http server responses a html fragment: <font color="red">This user name exits already</font>
3.4 In client side, browser add the html fragment into #message
 -->

<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-1.7.2.js"></script>
<script type="text/javascript">

	$(function(){
		$(":input[name='username']").change(function(){
			var val = $(this).val();
			val = $.trim(val);
			
			
			if(val != ""){
				var url="${pageContext.request.contextPath }/valiateUserName";
				var args = {"userName" : val, "time": new Date()};
				
				$.post(url, args, function(data){
					$("#message").html(data);
					
				});
				
			}
			
			
		});
		
		
		
	});
	
	



</script>

</head>
<body>
<form action="" method="post"></form>
	UserName:<input type="text" name="username"/>
	<br>
	<div id = "message"></div>
	
	<br>
	<input type="submit" value="Submit"/>

</body>
</html>