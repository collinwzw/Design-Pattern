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
