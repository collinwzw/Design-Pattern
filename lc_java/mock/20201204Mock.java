import java.io.*;
import java.util.*;

interface FileFolder{
  String name;
  
  public boolean find(String filename);
}

class File implements FileFolder{
  String extension;
  public File(String name, String extension){
    this.name = name;
    this.extension = extension;
  }
  
  @Override
  public boolean find(String filename){
    if(filename.equals(this.name)) return true;
    else return false;
  }
}

class Folder implements FileFolder{
  List<FileFolder> subDirectory;
  
  public Folder(String name){
    this.name = name;
    this.subDirectory = new ArrayList<>();
  }
  
    @Override
  public boolean find(String filename){
    
    boolean fileExist = false;
    
    for(FileFolder filefolder : subDirectory){
      fileExist = fileExist || (filefolder.find(filename));
    }   
    return fileExist;
  } 
}



// 

//S: Single-responsibility principle
//O: Open-closed principle
//L: Liskov substitution principle
//I: Interface segregation principle
//D: Dependency inversion principle



