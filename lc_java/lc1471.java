import java.util.*;
class Solution1471 {
    public int[] getStrongest(int[] arr, int k) {
    	
    	int m_index = (arr.length - 1)/2;
    	Arrays.sort(arr);
    	
    	int m = arr[m_index];
    	int[] result = new int[k];
    	int p_s = 0;
    	int p_e = arr.length - 1;
    	
    	int index = 0;
    	while(index < k)
    	{
    		int left = Math.abs(arr[p_s] - m);
    		int right = Math.abs(arr[p_e] - m);
    		
    		if (left > right) 
    		{
    			result[index] = arr[p_s];

    			p_s++;
    		}
    		else
    		{
    			result[index] = arr[p_e];
    			p_e--;
    		}
			index++;

    	}
        return result; 
    }
}



class Demo1471
{
	public static void main(String[] args)
	{	
		int[] arr = new int[] {1,3,2,5,4};
		int k = 2;
		Solution1471 s = new Solution1471();
		int[] r = s.getStrongest(arr, k);
    	for (int element: r)
    	{
    		System.out.print(element + ", ");
    	}
	}
}