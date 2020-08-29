package ParkingDesign;

enum Color
{
	Red,
	Blue,
	Yellow	
}

abstract class Vehicle
{
	public Color color;
	public String license;
}

class Motocycle extends Vehicle
{
	public Motocycle(Color color, String license)
	{
		this.color = color;
		this.license = license;
	}	
}

class Cars extends Vehicle
{
	public Cars(Color color, String license)
	{
		this.color = color;
		this.license = license;
	}	
}

class Truck extends Vehicle
{
	public Truck(Color color, String license)
	{
		this.color = color;
		this.license = license;
	}	
}

class Bus extends Vehicle
{
	public Bus(Color color, String license)
	{
		this.color = color;
		this.license = license;
	}	
}

class VehicleFactory
{
	public static Vehicle newMocycle(Color color, String license)
	{
		return new Motocycle( color,  license);
	}
	public static Vehicle newCars(Color color, String license)
	{
		return new Cars( color,  license);
	}
	public static Vehicle newTruck(Color color, String license)
	{
		return new Truck( color,  license);
	}
	public static Vehicle newBus(Color color, String license)
	{
		return new Bus( color,  license);
	}
}
