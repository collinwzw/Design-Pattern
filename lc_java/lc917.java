import java.util.Arrays;
class Solution917 {
    public String reverseOnlyLetters(String S) {
        char[] char_array = S.toCharArray();
    	int length = char_array.length;
    	int left = 0;
    	int right = length-1;
    	
    	while (left < right)
    	{
    		if (Character.isLetter(char_array[left])&&(Character.isLetter(char_array[right])))
    		{
    			char temp = char_array[left];
    			char_array[left] = char_array[right];
    			char_array[right] = temp;
    			left++;
    			right--;
    		}
    		else
    		{
    			if(!Character.isLetter(char_array[left]))
    			{
    				left++;
    			}
    			if(!Character.isLetter(char_array[right]))
    			{
    				right--;
    			}
    		}
    	}
    	
    	String result = new String(char_array);
    	return result;
    }
}



class Demo917
{
	public static void main(String[] args)
	{	

		Solution917 s = new Solution917();

		String string = "a-bC-dEf-ghIj";

		String r =s.reverseOnlyLetters(string);
		System.out.println(r);
	}
}