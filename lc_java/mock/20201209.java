// package whatever; // don't place package name!

import java.io.*;
import java.util.*;

// "I want to buy a shirt. One shirt costs $24.80."
// -> "One shirt costs. $19.84"

//


class MyCode {
  // public static String changePrice(String sentence){
    
  //   int i = 0;
  //   while(sentence.charAt(i) != '$'){
  //     i++;
  //   }
  //   System.out.println("here");
  //   int count = i + 1;
  //   while (Character.isDigit(sentence.charAt(count)) || sentence.charAt(count) == '.'){
  //     if (count == sentence.length() - 1){
  //       break;
  //     }
  //     count ++;
  //   }
    
  //   System.out.println("here2");
  //   String priceString = sentence.substring(i+1, count); 
  //   char[] priceArray = new char[priceString.length()];
  //   priceArray = priceString.toCharArray();
    
  //   double price = 0;
  //   boolean flag = false;
  //   int dicimalCount = 1;
  //   for (int j =0; j<priceArray.length; j++){
  //     System.out.println(price);
  //     if (!flag){
  //       if(priceArray[j] == '.'){
  //         flag = true;
  //       }
  //       else price = 10 * price + Character.getNumericValue(priceArray[j]);
  //     }
  //     else{
  //       if(priceArray[j] != '.'){
  //         price = price + Math.pow(0.1,dicimalCount) * Character.getNumericValue(priceArray[j]);
  //         dicimalCount++;
  //       }
  //     }
  //   }
  //   double finalPrice = price * 0.8;
  //   flag = false;
  //   dicimalCount = 1;
    
  //   String finalPriceString = Double.toString(finalPrice);
  //   System.out.println(finalPriceString);
  //   String decimalPartString = finalPriceString.split('.',1);
  //   boolean noDecimal;
  //   if (decimalPartString.charAt(0) == 0 && decimalPartString.charAt(1) == 0){
  //     noDecimal = true;
  //   }
    
  //   String newSentence = sentence.substring(0, i);
  //   if (noDecimal){
  //     sentence.replace(priceString , finalPriceString.split('.',0));
  //   }
  //   else{
  //     sentence.replace(priceString ,finalPriceString.split('.',0) + '.' + finalPriceString.split('.',1).substring(0, 1));
  //   }
    
  //   System.out.println(sentence);

    
    
  //   return sentence;
  // }
  
  
	public static void main (String[] args) {
		String s = "I want to buy a shirt. One shirt costs $24.80.";
    String[] stringArray = s.split("$",0);
    System.out.println(Double.valueOf("10.14"));
    System.out.println(Double.toString(10.14));
    //String r = changePrice(s);
	}
}



