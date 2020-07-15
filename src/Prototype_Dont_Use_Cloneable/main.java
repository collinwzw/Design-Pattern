package Prototype_Dont_Use_Cloneable;

import java.util.Arrays;

class Address implements Cloneable{
	public String streetname;
	public int housenumber;
	public Address(String streetname, int housenumber) {
		this.streetname = streetname;
		this.housenumber = housenumber;
	}
	
	@Override
	public String toString() {
		return "Address{" + "streetname='" + this.streetname + '\''+ ", housenumber=" + this.housenumber + '}';
	}
	
	//deep copy
	@Override
	public Object clone() {
		return new Address(streetname,housenumber);
	}
}

class Person implements Cloneable {
	public String[] names;
	public Address address;
	public Person(String[] names, Address address) {
		this.address = address;
		this.names = names;
	}
	@Override
	public String toString() {
		return "Person{" + "name='" + Arrays.deepToString(names) + ", address=" + this.address + '}';
	}
	@Override
	public Object clone() {
		return new Person(names.clone(),(Address) address.clone());
	}

}

class Demo{
	public static void main(String[] args) {
		Person john = new Person(new String[] {"John","Smith"}, new Address("London Road", 123));
		Person jane = (Person) john.clone(); //Don't use cloneable
		jane.names[0] = "Jane";
		jane.address.housenumber = 124;
		System.out.println(john);
		System.out.println(jane);
		
	}
}