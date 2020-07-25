package Singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



class Serialization_Problem{
	
	static void saveToFile(BasicSingleton bs, String filename) throws Exception
	{
		try(FileOutputStream fileOut= new FileOutputStream(filename);
				ObjectOutputStream out= new ObjectOutputStream(fileOut)){
			out.writeObject(bs);
		}
	}
	
	static BasicSingleton readFromFile(String filename) throws Exception
	{
		try(FileInputStream fileIn= new FileInputStream(filename);
				ObjectInputStream in= new ObjectInputStream(fileIn)){
			return (BasicSingleton) in.readObject();
		}
				
	}
	
	public static void main(String[] args) throws Exception
	{
		BasicSingleton bs = BasicSingleton.getInstance();
		bs.setValue(111);
		String filename = "singleton.bin";
		saveToFile(bs,filename);
		
		bs.setValue(222);
		BasicSingleton bs2 = readFromFile(filename);
		
		System.out.println(bs == bs2);
		
		System.out.println(bs.getValue());

		System.out.println(bs2.getValue());
		//example of creating the singleton object through the serialization
	}
}