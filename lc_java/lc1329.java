import java.util.*;

class Solution1329 {
    public int[][] diagonalSort(int[][] mat) {
        //sort diagonally , mat[i][j],mat[i+1][j+1]£¬mat[i+2][j+2]£¬... mat[i+k][j+k] where i+k < n or j+k < m
        //sort using list of priority queue
    	//ArrayList<Queue<Integer>> list = new ArrayList<Queue<Integer>>();
    	int m = mat.length;
    	int n = mat[0].length;
    	//list.set(0,new PriorityQueue<Integer>((a, b) -> a - b));
    	HashMap<Integer, List<Integer>> map = new HashMap();
        for(int i = -m + 1 ; i < n ; i++){
            List<Integer> tmp = new ArrayList<>();
            map.put(i,tmp);
        }
    	for (int i = 0; i< m; i++)
    	{
    		for (int j = 0; j <n; j++)
    		{

    			map.get(j-i).add(mat[i][j]);
    			
    		}
    	}
    	 for (Map.Entry<Integer, List<Integer>> pair : map.entrySet()) {
             Collections.sort(pair.getValue());
             System.out.println(pair);
         }
    	
    	int[][] matrix = new int[m][n];
    	for (int i = 0; i< m; i++)
    	{
    		for (int j = 0; j <n; j++)
    		{

    			matrix[i][j] = map.get(j-i).get(0);
    			map.get(j-i).remove(0);
    			
    		}
    	}
        return matrix;
    }
}


class Demo1329
{
	public static void main(String[] args)
	{	
		int[][] matrix = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
		Solution1329 s = new Solution1329();
		int[][] result = s.diagonalSort(matrix);
		System.out.println(result);
		}
}