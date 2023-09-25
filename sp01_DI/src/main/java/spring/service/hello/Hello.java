package spring.service.hello;

/*
 * FileName : Hello.java
 * ?�� package / private Field(property) / Constructor / getter,setter / ?��?��?�� Method 
 * ?���? 갖는 �? 규약?�� �??�� ?��반적?�� Bean ::  POJO(Plain Old Java Object)
 */
public class Hello{
	
	///Field
	private String message = "Container 란 ?????";
	
	///Constructor Method
	public Hello() {
	}
	public Hello(String message) {
		this.message = message;
	}

	///Method
	//==> getter / setter Method definition
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	//==> message를 출력하는 Method  
	public void printMessage() {
		System.out.println("\n"+getClass().getName()+"=>"+message);
	}
	
}//end of class