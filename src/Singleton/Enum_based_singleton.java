package Singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

enum EnumBasedSingletom
{
	INSTANCE;
	
	EnumBasedSingletom()
	{
		value = 42;
	}
	private int value;
	public int getValue() {
		return value;
	}
	public void setValue(int value)
	{
		this.value = value;
	}
}

class Demo2
{
	static void saveToFile(EnumBasedSingletom bs, String filename) throws Exception
	{
		try(FileOutputStream fileOut= new FileOutputStream(filename);
				ObjectOutputStream out= new ObjectOutputStream(fileOut)){
			out.writeObject(bs);
		}
	}
	
	static EnumBasedSingletom readFromFile(String filename) throws Exception
	{
		try(FileInputStream fileIn= new FileInputStream(filename);
				ObjectInputStream in= new ObjectInputStream(fileIn)){
			return (EnumBasedSingletom) in.readObject();
		}
				
	}
	
	public static void main(String[] args) throws Exception
	{
		String filename = "myfile.bin";
		
//		EnumBasedSingletom singleton = EnumBasedSingletom.INSTANCE;
//		singleton.setValue(111);
//		saveToFile(singleton,filename);
		
		EnumBasedSingletom singleton2 = readFromFile(filename);
		System.out.println(singleton2.getValue());
	}
}

// all the field is not serialized. and we can not inherite from this enum approach