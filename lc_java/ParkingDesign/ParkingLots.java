package ParkingDesign;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

enum Size
{
	Small,
	Medium,
	Large,
	ExtraLarge
}


class ParkingBuilding
{
	public int buildingID;
	private Map<Integer,ParkingLevel> LevelMap= new HashMap<>();
	public ParkingBuilding(int buildingID)
	{
		this.buildingID = buildingID;
	}
	
	public void newLevel(int level)
	{
		if (LevelMap.containsKey(level))
		{
			System.out.println("the level" + level +  "has been created");
		}
		else
		{
			ParkingLevel newlevel = new ParkingLevel(level);
			LevelMap.put(level, newlevel);
		}
	}
	
	public ParkingLevel getLevel(int level) 
	{
		if (!LevelMap.containsKey(level))
		{
			throw new NoSuchElementException("the parking level is not exist");
		}
		else
		{
			return LevelMap.get(level);
		}
	}
	
	
}

class Parkinglot
{
	private int ID;
	private boolean parked = false;
	private Size size;
	
	public Parkinglot(int id, Size size)
	{
		this.ID = id;
		this.size = size;
	}
	
	public boolean isParked()
	{
		return this.parked;
	}
	
	public int getID()
	{
		return this.ID;
	}
	
	public Size getSize()
	{
		return this.size;
	}
	
	@Override
	public String toString()
	{
		if (this.parked == true){
			return "The parking ID = " + this.ID + " with size = " + this.size + " already has a car ";

		}
		else
		{
			return "The parking ID = " + this.ID + " with size = " + this.size + " is empty ";

		}
	}
}

class ParkingLevel
{	
	private int level;
	public boolean full = false;
	private Map<Integer,Parkinglot> IDMap= new HashMap<>();
	public ParkingLevel(int level)
	{
		this.level = level;
	}
	
	public void newParkinglot(int id, Size size)
	{
		if (IDMap.containsKey(id))
		{
			System.out.println("the parking with id" + id + "is created");
			
		}
		else
		{
			Parkinglot newParkingLot = new Parkinglot(id, size);
			
			IDMap.put(id, newParkingLot);

		}
	}
	
	public Parkinglot getParkinglot(int id)
	{
		if (!IDMap.containsKey(id))
		{
			throw new NoSuchElementException("the parking lot is not exist");

		}
		else
		{
			return IDMap.get(id);
		}
	}
	
}

class ParkingDemo
{
	public static void main(String[] args)
	{
		ParkingBuilding pb = new ParkingBuilding(1);
		pb.newLevel(1);
		pb.getLevel(1).newParkinglot(1, Size.Small);
		System.out.println(pb.getLevel(1).getParkinglot(1).isParked());
		
	}
}