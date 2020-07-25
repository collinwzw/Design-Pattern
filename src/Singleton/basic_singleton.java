package Singleton;
import java.io.*;

class BasicSingleton implements Serializable{
	private BasicSingleton() {
		
	}
	
	private static final BasicSingleton INSTANCE = new BasicSingleton();
	public static BasicSingleton getInstance() {
		return INSTANCE;
	}
	
	private int value = 0;
	
	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}

class Demo{
	public static void main(String[] args) {
		BasicSingleton bs = BasicSingleton.getInstance();
		bs.setValue(123);
		System.out.println(bs.getValue());
		
	}
}

// Two Problem with this method:
// 1.reflection
// 2.serilization. JVM does not care about the private constructor