package Singleton;



class ChiefExecutiveOfficer
{
	private static String name;
	private static int age;
	
	public String getName()
	{
		return ChiefExecutiveOfficer.name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAge()
	{
		return this.age;
	}
	public void setAge(int age) 
	{
		ChiefExecutiveOfficer.age = age;
	}
	
	@Override
	public String toString() 
	{
		return "ChiefExecutiveOfficer{" +
				"name='" + name +'\'' +", age=" + age + "}"; 
	}
	
	
}

class Demo_MonoState{
	public static void main(String[] args)
	{
		ChiefExecutiveOfficer ceo = new ChiefExecutiveOfficer();
		ceo.setName("Collin");
		ceo.setAge(27);
		
		ChiefExecutiveOfficer ceo2 = new ChiefExecutiveOfficer();
		System.out.println(ceo2);

		ceo2.setName("Annie");
		ceo.setAge(28);
		
		System.out.println(ceo);
	}
}

//it's only behaviour like singleton in terms of data storage.'
// the data are shared in between any instance of the CEO
// the data is not safe
// only useful in some degree that we onyl want single data storage 