package observer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

class Event<TArgs>
{
	private int count = 0;
	private Map<Integer,TArgs> handlers = new HashMap<>();
	
	public Subscription addHandler(TArgs handler)
	{
		int i = count;
		handlers.put(count++, handler);
		return new Subscription(this,i);
		
	}
	
	public void fire(TArgs args)
	{
		for(Map.Entry handler : handlers.entrySet())
		{
			System.out.println("Person's " + handler + " has changed.");
		}
	}
	
	public class Subscription implements AutoCloseable
	{
		private Event<TArgs> event;
		private int id;
		
		public Subscription(Event<TArgs> event, int id)
		{
			this.event = event;
			this.id = id;
		}
		@Override
		public void close() //throws Exception {
		{
			// TODO Auto-generated method stub
			event.handlers.remove(id);
			
		}
	}
}

class PropertyChangedEventArgs
{
	public Object source;
	public String propertyName;
	public PropertyChangedEventArgs(Object source, String propertyName)
	{
		this.source = source;
		this.propertyName = propertyName;
	}
}

class Person 
{
	public Event<PropertyChangedEventArgs> propertyChanged = new Event<>();
	
	private int age;
	
	public int getAge() 
	{
		return this.age;
	}
	
	public void setAge(int age) 
	{
		if (this.age == age) return;
		
		this.age = age;
		propertyChanged.fire(new PropertyChangedEventArgs(this, "age"));
	}
}

class Demo_Observer_Event
{
	public static void main(String[] args)
	{
		Person person = new Person();
		Event<PropertyChangedEventArgs>.Subscription sub = person.propertyChanged.addHandler();
		
		person.setAge(20);
		person.setAge(22);
		person.setAge(21);
		sub.close();
		person.setAge(21);

		
		
		
	}
}