package javaweb.app1.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import javaweb.app1.beans.ShoppingCart;

@WebServlet("/addToCartServlet")
public class AddToCartServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. Gain request values: id, price
		String id = request.getParameter("id");
		int price = Integer.parseInt(request.getParameter("price"));
		
		//2. Gain Shopping Cart Object
		HttpSession session = request.getSession();
		ShoppingCart sc = (ShoppingCart)session.getAttribute("sc");
		
		if(sc == null){
			sc = new ShoppingCart();
			session.setAttribute("sc",sc);
		}
		
		
		//3. Add the clicked item into shopping cart
		sc.addToCart(id, price);
		
		
		//4. Prepare response JSON object
		//if JSON string comes from server side to client side, attributes must be ""
		//StringBuilder result = new StringBuilder();
//		result.append("{")
//			  .append("\"bookName\":\""+id+"\"")
//			  .append(",")
//			  .append("\"totalBookNumber\":"+sc.getTotalBookNumber())
//			  .append(",")
//			  .append("\"totalMoney\":"+sc.getTotalMoney())
//			  .append("}");
			
		ObjectMapper mapper = new ObjectMapper();
		
		String result = mapper.writeValueAsString(sc);
		System.out.println(result);
		
		//5. Response JSON
		response.setContentType("text/javascript");
		response.getWriter().print(result);
	}

}
