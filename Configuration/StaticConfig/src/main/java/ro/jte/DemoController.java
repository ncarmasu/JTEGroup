package ro.jte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	private TestBean testBean;
	
	@Autowired
	public DemoController(Environment environment, TestBean testBean){
		this.testBean=testBean;
		this.testBean.setFirstField(environment.getProperty("firstField"));
		
	}
	@RequestMapping("/test")
	public TestBean test(){
		return testBean;
	}
}
