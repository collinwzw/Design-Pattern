class Solution915 {
    public int partitionDisjoint(int[] A) {
        // two pointer
        // p1 starting from left and recording the maximum value in left part
        // p2 starting from right and recording the min value in right part
        // we can put it in an array
        // finnaly we just loop through array to find where the difference is
        int[] max = new int [A.length];
        int[] min = new int [A.length];
        
        max[0] = A[0];
        min[A.length - 1] = A[A.length - 1];
        for(int i = 1; i<A.length; i++)
        {
            max[i] = Math.max(A[i], max[i-1]);
            min[A.length - i - 1] = Math.min(A[A.length - i - 1], min[A.length - i]);
        }
    	System.out.print('[');
        for(int i = 0; i<A.length ; i++)
        {
        	System.out.print(min[i] + ", ");
        }
    	System.out.println(']');
    	
        for (int result = 0; result <A.length;result++)
        {
            if (max[result] < min[result] + 1)
            {
                return result + 1;
            }
        }
        
        return 0;
    }
}
class Demo915
{
	public static void main(String[] args)
	{	
		
		int[] input = {5,0,3,8,6};
		Solution915 s = new Solution915();


		int r =s.partitionDisjoint(input);
		System.out.println(r);
	}
}