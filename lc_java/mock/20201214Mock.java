// package whatever; // don't place package name!

import java.io.*;
import java.util.*;
/*
207. Course Schedule
Medium


There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, 
is it possible for you to finish all courses?

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 
*/

class MyCode {
  
  public static boolean checkPrerequest(int numCourses, int[][] prerequisite){
    // 1. loop through the prerequsite array to get all the course relationship
    // we can store this relation into the HashMap, the key is the course index, value is the prerequeisite
    
    Map<Integer,List<Integer>> preReq = new HashMap<>();
    
    //initialize hashmap
    for (int i = 0; i<numCourses; i++){
      preReq.put(i,new ArrayList<Integer>());
      } 
    
    //adding pre req courses to hashmap
    for(int i=0; i < prerequisite.length; i++){
      List<Integer> tempList = preReq.get(prerequisite[i][0]);
      tempList.add(prerequisite[i][1]);
      preReq.put(prerequisite[i][0],tempList);
    }

    // 2. we firstly pick one course that does not have prerequiste, if we can't find any, then it 
    // means it's impossible to finish all course
    // if we are able to find one, starting from that course
    int courseTaken = 0;
    Queue<Integer> courseCanBeTake = new LinkedList<>();
    for (Integer course : preReq.keySet() ){
      if (preReq.get(course).size() == 0){
        courseCanBeTake.offer(course);
      }
    }
    
    while (!courseCanBeTake.isEmpty()){
      int currCourse = courseCanBeTake.poll();
      courseTaken++;
      //System.out.println("Taking course " + Integer.toString(currCourse));
      //System.out.println(preReq.get(2));
      for (Integer course : preReq.keySet() ){
        if (preReq.get(course).contains(currCourse)){
          List<Integer> curList = preReq.get(course);
          for (int i = 0; i < curList.size(); i++){
            if (curList.get(i) == currCourse){
              curList.remove(i);
            }
          }

          preReq.put(course, curList);
          if (preReq.get(course).size() == 0){
            courseCanBeTake.offer(course);
            
          }
        }
        
      }
    }
    
    return courseTaken == numCourses;
  }
  
	public static void main (String[] args) {
		int numCourses = 4;
    int[][] prerequisite = new int[][] {{1,0},{2,0},{2,1},{3,2}};
    System.out.println(checkPrerequest(numCourses,prerequisite ));
    
	}
}
