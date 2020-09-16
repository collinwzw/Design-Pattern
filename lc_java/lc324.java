import java.util.Arrays;
import java.util.Collections;
class Solution324 {
    public void wiggleSort(int[] nums) {
    	
    }
    
    public void partition(int[] array, int low, int high)
    {
    	int pivot = array[high];
    	int j = low;
    	for (int i = low; i < high; i ++ )
    	{
    		if (array[i] < pivot)
    		{
    			j++;
    			swap(array,i,j);
    		}
    	}
    }
    
    
    public void swap(int[] array, int i, int j)
    {	
    	int temp = array[i];
    	array[i] = array[j];
    	array[j] = temp;
    }
}


class Demo324
{
	public static void main(String[] args)
	{	
		int[] input = {3,5,22,11,9,5,7};
		Solution324 s = new Solution324();
		s.wiggleSort(input);
		System.out.println();
		System.out.println("answer");
		for (int element: input)
		{
			System.out.print(element + " ,");
		}
	}
	
	
}