import java.util.Arrays;
import java.util.Collections;
class Solution215 {
	
    public int findKthLargest(int[] nums, int k) {
    	return partition(nums,0,nums.length - 1,nums.length - k);

    }
    
    public int partition(int[] array, int low, int high, int k)
    {
    	int pivot = array[high];
    	int left = low;
    	for (int i = low; i < high; i ++ )
    	{
    		if (array[i] <= pivot)
    		{
    			

    			swap(array,i,left++);
    		}
    	}

    	swap(array,high,left);
		for (int element: array)
		{
			System.out.print(element + " ,");
		}
		System.out.println();
		
    	if (left == k)
    	{
    		return array[left];
    	}
    	else if(left <k)
    	{
    		return partition(array,left+1,high,k);
    	}
    	else
    	{
    		return partition(array,low,left-1,k);
    	}
    	
    }
    
    
    public void swap(int[] array, int i, int j)
    {	
    	int temp = array[i];
    	array[i] = array[j];
    	array[j] = temp;
    }
}


class Demo215
{
	public static void main(String[] args)
	{	
		int[] input = {3,2,3,1,2,4,5,5,6};
		Solution215 s = new Solution215();
		int r = s.findKthLargest(input, 2);
		
		System.out.println();
		System.out.println("answer = " + r);
		for (int element: input)
		{
			System.out.print(element + " ,");
		}
	}
	
	
}