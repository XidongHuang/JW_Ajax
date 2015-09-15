<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- 
1. Gain current page every "a" node, and add every "a" node onclick function, meanwhile cancel default action
2. Prepare to send Ajax request: url(a node's href value); args(time stamp)
3. Response a "JSON", including: bookName, totalBookNumber, taotal money
4. Add relatived value into responsive position

-->
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-1.7.2.js"></script>
<script type="text/javascript">


	$(function(){
		
		var isHasCart = "${sessionScope.sc == null}";
		//alert(isHasCart);
		
		if(isHasCart == "true"){
			$("#cartstatus").hide();
			
		} else {
			
			$("#cartstatus").show();
			
			$("#bookName").text("${sessionScope.sc.bookName}");
			$("#totalBookNumber").text("${sessionScope.sc.totalBookNumber}");
			$("#totalMoney").text("${sessionScope.sc.totalMoney}");
			
		}
		
		
		
		$("a").click(function(){
			$("#cartstatus").show();
			
			var url = this.href;
			var args = {"time":new Date()};
			
			$.getJSON(url, args, function(data){
				$("#bookName").text(data.bookName);
				$("#totalBookNumber").text(data.totalBookNumber);
				$("#totalMoney").text(data.totalMoney);
								
				
			});
			return false;
		});
	});
	

</script>

</head>
<body>

	<div id="cartstatus">
		You added&nbsp;<span id="bookName"></span> &nbsp; into cart. <br>
		&nbsp;<span id="totalBookNumber"></span> &nbsp; books are in the cart.<br> 
		Total price is: &nbsp;<span id="totalMoney"></span> &nbsp;
	</div>
	<br><br>

	Java &nbsp;&nbsp;<a href="${pageContext.request.contextPath }/addToCartServlet?id=java&price=100">Add in cart</a>
	<br><br>

	Oracle&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/addToCartServlet?id=oracle&price=200">Add in cart</a>
	<br><br>

	Struts2&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/addToCartServlet?id=struts2&price=100">Add in cart</a>
	<br><br>

</body>
</html>