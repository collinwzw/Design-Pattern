// package whatever; // don't place package name!

import java.io.*;
import java.util.*;
class Solution {
  
/*
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
*/
 
 // result
 // recusive function  input ( List<Integer> l, List<Integer> temp_result  )
 // base case  l.isEmpty == true: result.add(temp_result);
 // for (Integer element: l){
 //   temp_result.add(element);
//    l.remove(element);   
 //    recrusion()
//    l.add(element);
    // temp_result.remove(element);
 // }
 
 public static List<List<Integer>> permutation( List<Integer> nums){
   List<List<Integer>> result = new ArrayList<>();
   List<Integer> temp_result = new ArrayList<>();
   helper(new ArrayList<>(nums),temp_result,result );
   //backtracking(temp_result, result, nums);
   return result;
 }
 
 public static void helper(List<Integer> remain, List<Integer> temp_result, List<List<Integer>> result){
   //base case
   if (remain.isEmpty()){
     result.add(new ArrayList<>(temp_result));
     return;
   } 
   
   for (int i = 0; i<remain.size(); i++){ // i = 0, i = 1 
     System.out.println(remain);
     //Collections.sort(remain);  
     int x = remain.get(i);
     temp_result.add(x);
     //List<Integer> temp_copy = new ArrayList<> (remain);
     remain.remove(i);
     helper(remain, temp_result, result);
     temp_result.remove(temp_result.size()-1);
     remain.add(i, x);   
   } 
 }
 
 public static void backtracking(List<Integer> temp, List<List<Integer>> res, List<Integer> nums) {
   if (temp.size() == nums.size()) {
     res.add(new ArrayList<>(temp));
     return;
   }
   
   for (int i = 0; i < nums.size(); i++) {
     if (temp.contains(nums.get(i))) continue;
     
     temp.add(nums.get(i));
     backtracking(temp, res, nums);
     temp.remove(temp.size() - 1);
   }
 }
 
 public static void main(String[] args){
   
   List<Integer> nums = List.of(1,3,2);
   List<List<Integer>> result = permutation(nums);
   System.out.println(result);
 }
}
