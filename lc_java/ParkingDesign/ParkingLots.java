package ParkingDesign;

import java.util.HashMap;
import java.util.Map;

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
	public Map<Integer,ParkingLevel> LevelMap= new HashMap<>();
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
	
	
}

class Parkinglot
{
	public int ID;
	public boolean parked = false;
	public Size size;
	
	public Parkinglot(int id, Size size)
	{
		this.ID = id;
		this.size = size;
	}
}

class ParkingLevel
{	
	public int level;
	public boolean full = false;
	public Map<Integer,Parkinglot> IDMap= new HashMap<>();
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
}