import java.util.HashMap;
import java.util.Map;

class Solution413 {
    Map<Integer, Integer> dp = new HashMap<>();
    
	public void compute_dp_value(int i)
	{	
		System.out.println("computing dp for" + i);
		if (!dp.containsKey(i-1))
		{
			compute_dp_value(i-1);
		}

		dp.put(i, dp.get(i-1) + i - 2);

	}
	
    public int numberOfArithmeticSlices(int[] A) {

    	

        dp.put(3,1);

        
        int result = 0;
        
        int count = 2;
        for (int i =0; i< A.length - 2; i++)
        {	
        	System.out.println("index i= " + i + ". And count = " + count);
        	if(A[i+1]-A[i] == A[i+2]-A[i+1])
        	{
        		count ++;
        		if (i == A.length - 3 && count >= 3)
        		{
        			if (!dp.containsKey(count))
        			{
        				compute_dp_value(count);
        			}
        			
        			result += dp.get(count);
        			
        		}
        		
        	}
        	else
        	{
        		if (count >= 3)
        		{
        			if (!dp.containsKey(count))
        			{
        				compute_dp_value(count);
        			}
        			result += dp.get(count);
        		}
        		count = 2;
        		
        	}
        }
        
        return result;
    }
}

class Demo413
{
	public static void main(String[] args)
	{	
		int[] matrix = {1,2,3,4,5,4,3,2,1};
		Solution413 s = new Solution413();
		int result = s.numberOfArithmeticSlices(matrix);
		System.out.println(result);
		}
}