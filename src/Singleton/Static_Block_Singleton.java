package Singleton;

import java.io.File;

class StaticBlockSingleton
{
	private StaticBlockSingleton() throws Exception
	{
		System.out.println("Singleton is initializing");
		File.createTempFile(".", ".");
		
	}
	
	private static StaticBlockSingleton instance;
	
	static	// this static block is example when we need to throw exception in singleton constructor  
	{
		try
		{
			instance = new StaticBlockSingleton();
		}
		catch(Exception e)
		{
			System.err.println("failed to create object");
		}
				
	}
	public static StaticBlockSingleton getInstance()
	{
		return instance;
	}
}