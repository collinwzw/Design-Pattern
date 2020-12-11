// package whatever; // don't place package name!

import java.io.*;
import java.util.*;
/*
Given a string s which consists of lowercase or uppercase letters, 
return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

example1:

Input: s = "abccccdd"
Output: 7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.


example 2:

Input: s = "a"
Output: 1


example 3:

Input: s = "bb"
Output: 2
*/



class MyCode {
  
  public static int findLongestPalindrome(String s){
    // firstly put all the character count into an array
    // Secondly, we iterate this array:
    // initialize a int object result = 0;  flag = flase;
    // if arrayp[i] is even number, then  result = result + array[i]
    // else array[i] is odd number, then result = result + array[i] - 1; , flag = true
    
    // if flag == true:
    // return result + 1;
    // otherwise, return result;
    
    // firstly put all the character count into an map
    Map<Character, Integer> count = new HashMap<>();
    for (int i = 0; i< s.length(); i++ ){
      char curr = s.charAt(i);
      if (!count.containsKey(curr)){
        // the key is not present in the map
        count.put(curr, 1);
      }
      else{
        // the key is inside the map, we just need to increment the value 
        count.put(curr, count.get(curr) + 1);
      }
    }
    
    // Secondly, we iterate this map:  
    //List<Character> keyList = count.entrySet();
    int result = 0;
    boolean flag = false;
    for(Character c : count.keySet()) {
      if (count.get(c)%2 == 0){
        // even number
        result = result + count.get(c);
      }
      else{
        // odd case
        result = result + count.get(c) - 1;
        flag = true;
      }
    }
    
    if (flag == true){
      return result + 1;
    }
  
    return result;
  }
  
	public static void main (String[] args) {
		String s = "ccCcddda";
    int answer = findLongestPalindrome(s);
    System.out.println(answer);
	}
}




abakkwy -> aba

abakkay -> akka

bbbbbbb -> bbbbbbb
// left == right != i  aba
// left == right == i  b1b2b3  ??  
//b1b2  
//b2b3  
//b2 

b1b2b3, aba
ab -> a



5 1 3 2 0 6  -> if we stand in 6, index 5, maxStack
