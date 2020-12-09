// package whatever; // don't place package name!

import java.io.*;

class Solution {
  //dp 2D DP, 
  // [0,1,2,3]
  // [0,0,0,4]
  // [0,0,0,5]
  
  //boundary check before this function
  // dp[x][y] = Math.max(dp[x-1][y], dp[x][y-1]);
  
  // return dp[N-1][N-1];
  
  
  public int findMaximumGold( int[][] map){
    // starting from index 0,0
    // end at index N,N
    return helper( map, 0,  0,  0);
  }
  
  public int helper(int[][] map, int currentGold, int x, int y){
    if (x >= map[0].length || y >= map.length){
      return currentGold;
    }    
    return Math.max(helper(map, currentGold + map[x][y], x+1 ,y), helper(map, currentGold + map[x][y], x ,y+1));
  }
  
  
	public static void main (String[] args) {
		int[][] map = {{0,1,2,3},{0,0,0,4},{0,0,0,5},{0,0,0,6}};
    
    Solution s = new Solution();
    int result = s.findMaximumGold(map);
    System.out.println(result);
    
    String a = "abc";
    String b = "abd";
    
    b = b.replace("d", "c");
    
    System.out.println(b);
    System.out.println(a.equals(b));
	}

}




//package whatever; // don't place package name!

import java.io.*;



//array  [[time interval], [time interval] ]
//    [starting time, end time]


class Solution{

public List<int[]> mergeInterval (List<int[]> schedule){
 // [3, 5], [4, 6], [4, 7], [5, 8]  -> [3, 8]
 
 // 
 
 
 
 // Input: intervals = [[1,16],[2,6],[8,10],[15,18]] -> [1, 18]
 //Input: intervals = [[1,18],[2,6],[8,10],[15,16]]  -> [1, 18]
 // Output: [[1,6],[8,10],[15,18]]
 
 // [3, 4]  [4, 6] -> [3, 6]
 // case # 3: [3, 4]  [5, 6] -> [3, 4] [5, 6]
 // not sorted
 
 // in place sort -> [4,6], [3, 5], [10 ,12]
 //            [3,5] [4,6] [10,12]
 
 // brute force : read all the starting time to an startingtime list
 //ead all the ending time to an ending time list
 // sort those two list
 // starting time [1 , 2 , 8, 15]
 // ending time [6, 10, 15, 18]  startingtime[i + 1] <= endingtime[i]   -> overlap
 
 // 1. whenever there is startime, there should a ending coressponding it
 // 2. starting  < ending in given inteval
 // 3. if we stand in the index i, if startingTime[i+1] <= endingTIme[i] ->  
 // starting[i] = 0   endingTime[i] = 6  [] 
 
 https://leetcode.com/problems/merge-intervals/
 
 // starting time [1 , 2 , 8, 15]
 // ending time [6, 10, 15, 18]  startingtime[i + 1] <= endingtime[i]   -> overlap
 
 // starting time [3 , 5]
 // ending time [4, 6]  startingtime[i + 1] > endingtime[i]   -> nonoverlap  [3, 4]
 
 int[] startingTime = new int[schedule.size()];
 int[] endingTime = new int[schedule.size()];
 for (int i = 0; i < schedule.size(); i++){
   startingTime[i] = schedule.get(i)[0];
   endingTime[i] = schedule.get(i)[1];
 }
 
 Array.sort(startingTime);
 Array.sort(endingTime);
 
 List<int[]> result = new ArrayList<>();
 for (int i = 0; i < schedule.size(); i ++){
   int currentIndex = i;
   while(startingTime[currentIndex+1] <= endingTime[currentIndex] && currentIndex < schedule.size() - 1){
     currentIndex++;
   }
   //non-overlap
   List.add(new int[startingTime[i], endingTime[currentIndex]]);
   i = currentIndex + 1;
 }
 
 
 return result
}

public static void main(String[] args){
 List<int[]> input = new ArrayList<>();
 
}
}




