package javaweb.app1.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/valiateUserName")
public class ValiateUserName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<String> userNames = Arrays.asList("AAA", "BBB", "CCC");
		
		String userName = request.getParameter("userName");
		String result = null;
		if(userNames.contains(userName)){
			result = "<font color='red'>This user name exists already</font>";
		} else {
			
			result = "<font color='green'>This user name can be used</font>";
		}
	
		response.setContentType("text/html");
	
		response.getWriter().println(result);
	}

}
