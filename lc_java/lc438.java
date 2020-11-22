import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        // brute force method: get all the combinition from the string s of length p.length O(p.length * N)
        // check if each of them are anagram of string p O(p.length)
        //  so it will be O(p.length^2 N)
        
        // better solution?
        // we can improve second part
        // we can put each character of p into a hash table
        // we can have a set which recording the letters inside of sliding window
        // and we use length of the set to varify if we really get the anagram.
        
        Map<Character, Integer> characterInp = new HashMap<>();
        
        for(int i = 0; i < p.length(); i++)
        {
        	characterInp.put(p.charAt(i), characterInp.getOrDefault(p.charAt(i), 0) + 1);
        }
        int counter = characterInp.size();

        List<Integer> result = new ArrayList<>();
        int begin = 0, end = 0;
        
        int len = Integer.MAX_VALUE; 
        
		 while(end < s.length()){
		            
		            char c = s.charAt(end);//get a character
		            
		            if( characterInp.containsKey(c) ){
		            	characterInp.put(c, characterInp.get(c)-1);// plus or minus one
		                if(characterInp.get(c) == 0) counter--;//modify the counter according the requirement(different condition).
		            }
		            end++;
		            
		            //increase begin pointer to make it invalid/valid again
		            while(counter == 0 /* counter condition. different question may have different condition */){
		                
		                char tempc = s.charAt(begin);//***be careful here: choose the char at begin pointer, NOT the end pointer
		                if(characterInp.containsKey(tempc)){
		                	characterInp.put(tempc, characterInp.get(tempc) + 1);//plus or minus one
		                    if(characterInp.get(tempc) > 0) counter++;//modify the counter according the requirement(different condition).
		                }
		                
		                /* save / update(min/max) the result if find a target*/
		                // result collections or result int value
		                if(end-begin == p.length()){
		                    result.add(begin);
		                }
		                
		                begin++;
		            }
		        }

        return result;
        
    }
}

class Demo438
{
	public static void main(String[] args)
	{	
		String s1 = "cbaebabacd";
		String p = "abc";
		Solution438 s = new Solution438();
		List<Integer> result = s.findAnagrams(s1,p);
		System.out.println(result);
		}
}