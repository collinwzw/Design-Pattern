import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

class Solution73 {
    public void setZeroes(int[][] matrix) {
        // first go through matrix row by row
        // once find a zero, record the coordination in an array
        // then do the zero thing
    	List<int[]> l = new ArrayList<>();
    	for(int row = 0; row < matrix.length; row++) 
    	{
    		for (int col = 0; col < matrix[0].length; col++)
    		{
    			if (matrix[row][col] == 0)
    			{	
    				int[] temp = {row,col};
    				l.add(temp);
    			}
    		}
    	}
    	
    	for (int[] element: l)
    	{
    		//row constant
    		int c_row = element[0];
    		for (int col = 0; col < matrix[0].length; col++)
    		{
    			if (matrix[c_row][col] != 0)
    			{	
    				matrix[c_row][col] = 0;
    			}
    		}
    		
    		int c_col = element[1];
    		for (int row = 0; row < matrix.length; row++)
    		{
    			if (matrix[row][c_col] != 0)
    			{	
    				matrix[row][c_col] = 0;
    			}
    		}
    	}
    }
}


class Demo73
{
	public static void main(String[] args)
	{
		int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
		Solution73 s = new Solution73();
		s.setZeroes(matrix);
		
    	for(int row = 0; row < matrix.length; row++) 
    	{
    		for (int col = 0; col < matrix[0].length; col++)
    		{
    				
    			System.out.print(matrix[row][col]);
    			
    		}
    		System.out.println();
    	}
	}
}