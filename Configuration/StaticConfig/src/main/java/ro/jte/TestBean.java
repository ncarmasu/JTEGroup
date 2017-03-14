package ro.jte;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestBean {

	
	String firstField;
	
	@Value("${secondField}")
	int secondField;
	
	public String getFirstField() {
		return firstField;
	}

	public void setFirstField(String firstField) {
		this.firstField = firstField;
	}

	public int getSecondField() {
		return secondField;
	}

	public void setSecondField(int secondField) {
		this.secondField = secondField;
	}

}
