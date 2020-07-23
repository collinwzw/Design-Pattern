package prototype_copy_contructor;


class Address{
	public String streetAddress, city, country;
	public Address(String streetAddress, String city, String country) {
		this.streetAddress = streetAddress;
		this.city = city;
		this.country = country;
	}
	
	public Address(Address other) {
		this.streetAddress = other.streetAddress;
		this.city = other.city;
		this.country = other.country;
	}
	
	@Override
	public String toString() {
		return "Address{" + "street address='" + streetAddress + '\'' + ", city='" + city +'\'' +", country='" + country + '\'' +'}'; 
	}
}

class Employee{
	public String name;
	public Address address;
	
	public Employee(String name, Address address) {
		this.name = name;
		this.address = address;
		
	}
	
	public Employee(Employee other) {
		name = other.name;
		address = new Address(other.address);
	}
	@Override
	public String toString() {
		return "Employee{" + "name='" + name + '\'' + ", address='" + address +'}'; 
	}
}

class Demo{
	public static void main(String[] args) {
		Employee john = new Employee("John", new Address("123 Test Road", "New York", "USA")); 
		Employee chris = new Employee(john);
		chris.name = "Chris";
		chris.address.city = "Montreal";
		chris.address.country = "Canada";
		System.out.println(john);
		System.out.println(chris);
		// limitation: we have to build copy contructor for every single type we have. 
	}
	
}