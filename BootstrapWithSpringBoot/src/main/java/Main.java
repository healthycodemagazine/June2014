import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan; 
import org.springframework.context.ApplicationContext;
import com.healthycode.service.*;
import com.healthycode.web.*;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.healthycode")
public class Main{
	public static void main(String[] args){
		ApplicationContext context = SpringApplication.run(Main.class,args);
		/*ProductService productService = context.getBean("productService",ProductService.class);
		productService.addProduct("Moto G","Black, with 16GB",13999);
		System.out.println("Done");*/
	}
}