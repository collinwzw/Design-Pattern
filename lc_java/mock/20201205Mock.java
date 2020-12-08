// package whatever; // don't place package name!

import java.io.*;


interface ParkingLotDesign{
  
  boolean isFull();
  
}

class ParkingLot implements ParkingLotDesign{
  ParkingSpace[] parkingspace;
  private int capacity;
  private int entered;
  
  public ParkingLot(int capacity){
    this.capacity = capacity;
    this.ParkingSpace = new ParkingSpace[this.capacity];
    for (int i = 0; i <capacity; i ++){
      this.ParkingSpacep[i] = new ParkingSpace(i);
    }
    this.entered = 0;
  }
  
  public boolean addCar(){
    if (this.isFull()){
      return false;
    }
    this.entered++;
    return true;
  }
  
  public void removeCar(){
    this.entered--;
  }
  
  @Override
  public bollean isFull(){
    return this.entered == this.capacity;
  }
}


interface ParkingSapceDesign{
  public void parked();
  
}

class ParkingSpace implements ParkingSapceDesign{
  int id;
  boolean parked;

  public ParkingSpace(id) {
    this.id = id;
  }
}