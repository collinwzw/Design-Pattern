import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

class Solution93 {
    public List<String> restoreIpAddresses(String s) {
    	   List<String> result = new ArrayList<String>();
    	   List<String> current = new ArrayList<String>();

    	   helper(0, current , s, result);
    	   return result;
    	
    }
    
    public void helper(int i, List<String> current, String s, List<String> result)
    {
        // if we have completed 4 octets of IPv4 and we reached end of the string, then add into result
        if (i == s.length() && current.size() == 4) 
        {
           // add result into res
           result.add(String.join(".", current));
           return;
        }   

        // means we have still string left to cover so this is not valid IP result
        if (current.size() == 4) return;
      
        // constructing current octet
        for (int k = 1; k <= 3 && (i + k) <= s.length(); k++) 
        {
           // special case to skip, since in case of 0, we cannot permit values like 01, 010,
           // only 0 allowed as valid value for 1 of the octet
           if (s.charAt(i) == '0' && k > 1) continue;

           String token = s.substring(i, i + k); 
           // check for valid value
           if (Integer.parseInt(token) <= 255) 
           {
              current.add(token);
              helper(i + k, current, s, result);
              // necessary for backtracking after we are done
              current.remove(current.size() - 1); 
           }   
        }
    }
}



class Demo93
{
	public static void main(String[] args)
	{	

		Solution93 s = new Solution93();

		String string = "1111";

		String string2 = "101023";
		
		List<String> r = new ArrayList<String>();
		r =s.restoreIpAddresses(string2);
		System.out.println(r);
	}
}