package prototype_copy_through_serialization;

import java.io.Serializable;
import org.apache.commons.lang3.SerializationUtils;

class Foo implements Serializable{
	public int stuff;
	public String whatever;
	
	public Foo(int stuff, String whatever) {
		this.stuff = stuff;
		this.whatever = whatever;
	}
	
	@Override
	public String toString() {
		return "Foo{" + "stuff= " + stuff + "; whatever=' " + whatever + '\'' + '}'; 
	}
}
class Demo{
	public static void main(String[] args) {
		Foo foo = new Foo(42,"life");
		Foo foo2 = SerializationUtils.roundtrip(foo);
		foo2.stuff = 41;
		System.out.println(foo);
		System.out.println(foo2); 
		//

	}
}