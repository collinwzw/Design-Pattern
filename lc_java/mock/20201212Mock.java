// package whatever; // don't place package name!

import java.io.*;
import java.util.*;
/*
78. Subsets
Medium

Add to List

Given an integer array nums, return all possible subsets (the power set).

The solution set must not contain duplicate subsets.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
*/


class Subset {
  // brute force 
  // set 
  // recusion function (index, int[] list) 
  //   //base case if index == nums.length() if the list is in the set? if it's already in, we ignore, 
  // otherwise we add 
      // recursion function (index + 1, list.add(nums[index]));
      // recusion function (index + 1, list);
  // starting from i = 0, go through all the index > i untill the end 
  // 


  
  // public static List<List<Integer>> subsets(int[] nums) {
  //   //Set<int[]> s = new HashSet();
  //   List<List<Integer>> answer = new ArrayList<>();
    
  //   for (int i = 0; i< nums.length; i++){
  //     List<Integer> tempList = new ArrayList<>();
  //     helper(nums, i, tempList, answer);
  //   }   
  //   return answer;    
  // }
  
  // public static void helper(int[] nums, int index, List<Integer> tempList, List<List<Integer>> answer){
  //   //base case
  //   if (index == nums.length - 1){
  //     // we already reached the end of list
 
  //     if( !answer.contains(tempList) ) answer.add(new ArrayList<Integer>(tempList)); // we don't take the last element in the nums;
  //     tempList.add(nums[index]);
  //     if( !answer.contains(tempList) ) answer.add(tempList);
  //   }
  //   else{
  //     List<Integer> l  = new ArrayList<Integer>(tempList);
  //     l.add(nums[index]);
  //     helper(nums, index + 1, l, answer); // l = [1]
  //     helper(nums, index + 1, new ArrayList<Integer>(tempList), answer); // templist = []
  //   } 
  // }
  public static void main (String[] args) {
		int[] nums = new int[] {1,2,3};
    List<List<Integer>> l = subsets2(nums);
    System.out.println(l);
	}
  
  public static List<List<Integer>> subsets2(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    helper(0, new ArrayList<Integer>(), ans, nums);
    return ans;
  }
  
  public static void helper(int index, List<Integer> tempList, List<List<Integer>> ans, int[] nums) {
    ans.add(new ArrayList<Integer>(tempList));
    
    for(int i = index; i < nums.length; i++){
      tempList.add(nums[i]);
      helper(i+1, tempList, ans, nums);
      tempList.remove(tempList.size()-1);
    }
    
  }
  
}
