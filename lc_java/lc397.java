class Solution397 {
    public int integerReplacement(int n) {
        
    	int count = 0;
    	
    	while(n>1)
    	{
    		if (n%2 == 0)
    		{
    			count++;
    		}
    		else
    		{
    			count += 2;
    		}
    		n = n/2;
    	}
    	return count;
    }
}


class Demo397
{
	public static void main(String[] args)
	{	

		Solution397 s = new Solution397();



		int r =s.integerReplacement(25);
		System.out.println(r);
	}
}


