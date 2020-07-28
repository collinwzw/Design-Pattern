package Singleton;


class LazySingleton
{
	private static LazySingleton instance;
	
	private LazySingleton()
	{
		System.out.println("initializing a lazy singleton");
	}
	
	public static LazySingleton getInstance()
	{
		if (instance == null)
		{
			instance = new LazySingleton();
		}
		return instance;
	}
}

// if multiple thread create this object (race condition)
// this singleton is sensitive to this problem

//Solution 1: add synchronized for getInstance() method
//Solution 2: Double-checked locking
//public static LazySingleton getInstance()
//{
//	if (instance == null)
//	{
//		synchronized (Lazysingleton.class)
//		{
//			if (instance == null)
//			{
//				instance = new LazySingleton();
//			}
//		}
//	}
//	return instance;
//}