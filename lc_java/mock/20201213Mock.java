// package whatever; // don't place package name!

import java.io.*;
import java.util.*;


/*
23. Merge k Sorted Lists
Hard

Add to List

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
*/

// brute force: go over all the list and put it into a hashmap
// then iterate hash map key and generate the result.
// n number of list   m: average number of element in each list
// O( n * m + n * m) = O(2 * n * m) = O( n * m  )
// n * m 
// 1
// O( n * m * n)                         
// for (Integer key: map.keySet()){
//  
// }

// 1.number of transaction in any given second < 3
// 2.number of transaction in any 10 seconds < 20
// 3.number of transaction in any 60 secconds < 60 
class MyCode {
  
  public static int calculateDroppedRequest(int num, List<Integer> requestTime){
    
    // initialize a queue1
    // initialize a queue2
    // initialize a queue3
    // loop through the list reuqestTime,
    // according to the current element in the requestTime, we have to do the check in the queue
    // to eliminate 
    // for each element in requestTime, we check 3 conditions.
    // if any of them is not satisify, we increment the count.
    // if it satisify all conditions, we then add it to queue 
    // 
    
    // hashmap + two pointer
    // 
    // initialize three queues
    Queue<Integer> secondQueue  = new LinkedList<>();
    Queue<Integer> tenSecondQueue  = new LinkedList<>();    
    Queue<Integer> minuteQueue  = new LinkedList<>();    
    
    // loop thorugh the requestTime
    int dropCount = 0;
    for (int i = 0; i < requestTime.size(); i++){
      
      //System.out.println(secondQueue);
      //System.out.println(tenSecondQueue);
      if (!secondQueue.isEmpty() && secondQueue.peek()!= requestTime.get(i)){
        secondQueue.clear();
      }
      while (!tenSecondQueue.isEmpty() && tenSecondQueue.peek() - requestTime.get(i) >= 10){
        tenSecondQueue.poll();
      } 
      while (!minuteQueue.isEmpty() && minuteQueue.peek() - requestTime.get(i) >= 60){
        minuteQueue.poll();
      } 
      
      if (secondQueue.size() < 3 && tenSecondQueue.size() < 20 && minuteQueue.size() < 60 ){
        // satisify all three conditions.

        secondQueue.offer(requestTime.get(i));
        tenSecondQueue.offer(requestTime.get(i));
        minuteQueue.offer(requestTime.get(i));
      }
      else{
        dropCount++;
      }

    }
    return dropCount;
  }
  
	public static void main (String[] args) {
		//List<Integer> r = List.of(1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,11,11,11,11,);
    List<Integer> r = List.of(1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,12,12,12,12);
    int dropcount = calculateDroppedRequest(r.size(), r);
    System.out.println(dropcount);
	}
}



