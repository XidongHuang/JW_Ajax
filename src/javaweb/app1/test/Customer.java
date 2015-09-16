package javaweb.app1.test;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonIgnore;
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
	
	@JsonIgnore
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
		
		
		//1. 导入 jar 包
		//2. 创建 ObjectMapper 对象
		ObjectMapper mapper = new ObjectMapper();
		
		//3. 调用 mapper 的 writeValueAsString() 方法把一个对象转为一个 JSON 字符串
		Customer customer = new Customer("Tony", "1001");
		
		String jsonStr = mapper.writeValueAsString(customer); 
		
		System.out.println(jsonStr);
		
		//4. 注意: JackSon 使用 getter 方法定位 JSON 对象的属性!
		//5. 可以通过添加注释 org.codehaus.jackson.annotate.JsonIgnore
		//忽略某一个 getter 定义的属性
		
		
	}
	
}
