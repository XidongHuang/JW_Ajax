package javaweb.app1.test;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Customer {

	private String name;
	private String id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCity(){
		return "BeiJing";
	}
	
	public String getBirth(){
		return "1990-12-12";
	}
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	

	
	public Customer(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	public static void main(String[] args) throws JsonMappingException, IOException{
		
		ObjectMapper mapper = new ObjectMapper();
		
		Customer customer = new Customer("Tony", "1001");
		
		String jsonStr = mapper.writeValueAsString(customer); 
		
		System.out.println(jsonStr);
		
	}
	
}
