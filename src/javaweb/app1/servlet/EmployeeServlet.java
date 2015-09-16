package javaweb.app1.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaweb.app1.beans.Location;
import javaweb.app1.dao.DAO;


@WebServlet("/employeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String methodName = request.getParameter("method");
		
		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	private DAO baseDao = new DAO();
	
	protected void listLocations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String sql = "SELECT locationID , city FROM locations";

		System.out.println(sql);
		List<Location> locations = baseDao.getForList(sql, Location.class);
		
//		for(Location lo:locations){
//			System.out.println(lo.getLocationID() +": "+lo.getCity());
//			
//		}
		
		request.setAttribute("locations", locations);
		
		request.getRequestDispatcher("/WEB-INF/pages/employees.jsp").forward(request, response);
	}
	

}
