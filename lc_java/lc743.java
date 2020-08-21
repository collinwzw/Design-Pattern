import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution743 {
    public int networkDelayTime(int[][] times, int N, int K) {
        // first build a map for storing all networks
        // travese map using the node K (BFS) and store the largest time w
        
        Map<Integer,List<int[]>> map = new HashMap<>();
        
        for(int i = 1; i <N+1; i ++)
        {
            map.put(i, new ArrayList<>());
        }
        
        for (int[] time: times)
        {
            map.get(time[0]).add(new int[] {time[1],time[2]});
        }
        Queue<Integer> q = new PriorityQueue<>();
        q.add(K);
        int[] r = new int[N];
        int temp = 0;
        while (q.size()>0)
        {
            temp = q.poll();
            
            for(int[] time: map.get(temp))
            {
                if (time[0] == K) continue;
                
                q.add(time[0]);
                
                if (r[time[0]] == 0)    // the node is not visited yet
                {
                    r[time[0]] =r[temp] + time[1];
                }
                else
                {
                    r[time[0]] =Math.min(r[time[0]],r[temp] + time[1]);
                }
            }
        }
        int result = 0;
        for(int i = 0; i<r.length; i++)
        {
            if (i!=K &&r[i] == 0){
                return -1;
            }
            result = Math.max(result, r[i]);
        }
        // for(Integer key: map.keySet())
        // {
        //     System.out.println(map.get(key));
        // }
        return result;
    }
}