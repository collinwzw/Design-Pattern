import java.util.*;

class Solution1319 {
    public int makeConnected(int n, int[][] connections) {
        // if
        if (connections.length < n-1) return  -1;
        
        //we have to traverse the connections to see how many computer are not connected.
        HashMap<Integer, List<Integer>> map = new HashMap();
        for (int i=0; i<n; i++)
        {
            List<Integer> tmp = new ArrayList<>();
            map.put(i,tmp);
        }
        
        for(int[] connection: connections)
        {
            map.get(connection[0]).add(connection[1]);
            map.get(connection[1]).add(connection[0]);
        }
        boolean visited[] = new boolean[n];
        int result = 0;

        for (int i =0; i<n; i++)
        {
        	if (visited[i] == true)
        	{
        		continue;
        	}
        	else
        	{
                Queue<Integer> q = new LinkedList<>(); 
                q.add(i);
                
                while (q.size()!= 0)
                {
                	int s = q.poll();
                	Iterator<Integer> k = map.get(s).listIterator();
                	while (k.hasNext())
                	{
                		int m = k.next();
                		if (!visited[m])
                		{
                			visited[m] = true;
                			q.add(m);			
                		}
                	}
                }
                result++;
        	}
        }
        return result - 1;
    }
}

class Demo1319
{
	public static void main(String[] args)
	{	
		int[][] matrix = {{0,1},{0,2},{1,2}};
		Solution1319 s = new Solution1319();
		int result = s.makeConnected(4,matrix);
		System.out.println(result);
		}
}