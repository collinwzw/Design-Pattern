

class NumArray {
    final static int MAX = 1000;      
    static int[] arr;
    static int BITree[] = new int[MAX];
    static int n;
    public NumArray(int[] nums) {
         n = nums.length;
         arr = nums;
        for(int i = 0; i < n; i++) 
        {
        	add(i,nums[i]);

        }
    }
    
    public void add(int i, int val) 
    { 
       // index in BITree[] is 1 more than  
       // the index in arr[] 
       i = i + 1; 
     
       // Traverse all ancestors and add 'val' 
       while(i <= n) 
       { 
       // Add 'val' to current node of BIT Tree 
       BITree[i] += val; 
     
       // Update index to that of parent  
       // in update View 
       i += i & (-i); 
       } 
   }
    
    public void update(int i, int val) 
     { 
        // index in BITree[] is 1 more than  
        // the index in arr[] 
    	int previous = arr[i];
    	add(i,-previous);
    	add(i,val);

    }
    
    public int sumRange(int i, int j) {
        //System.out.println(getSum(j));
        //System.out.println(getSum(i));
        
        if (i == 0)
        {
            return getSum(j);
        }
        else{
                    return getSum(j) - getSum(i);

        }
    }
    
    public int getSum(int index) 
    { 
        int sum = 0; // Iniialize result 
      
        // index in BITree[] is 1 more than 
        // the index in arr[] 
        index = index + 1; 
      
        // Traverse ancestors of BITree[index] 
        while(index>0) 
        { 
            // Add current element of BITree  
            // to sum 
            sum += BITree[index]; 
      
            // Move index to parent node in  
            // getSum View 
            index -= index & (-index); 
        } 
        return sum; 
    } 
}


class Demo307
{
	public static void main(String[] args)
	{	
		int[] array = {-1}; 
		NumArray NA = new NumArray(array);
		//System.out.println(NA.sumRange(0,2));
		System.out.println(NA.sumRange(0,0));

		NA.update(0, 1);
		//for (int element: NA.BITree) { System.out.println(element); }
		System.out.println(NA.sumRange(0,0));
		}
}