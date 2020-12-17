import java.util.*;

class Solution787 {
    
    static class Edge {
        int source;
        int destination;
        int weight;
    

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
        
    	@Override
        public String toString()
        {
        	return "the source is = " + source + ". the desitination is = " + destination + ". And the weight is = " + weight + ".";
        }
    }
    
    static class Tuple{
        public int price,stops;
        public Tuple(int price, int stops)
        {
            this.price = price;
            this.stops = stops;
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

//    	HashMap<Integer, ArrayList<Edge>> map = new HashMap();
//    	for(int i = 0; i < n; i++) map.put(i, new ArrayList<Edge>());
//    	for (int[] f : flights) {
//    		ArrayList<Edge> list = map.get(f[0]);
//            list.add(new Edge(f[0],f[1],f[2]));
//        	//System.out.println(map.get(f[0]));
//        }

        
//        //BFS
//        Tuple[] visited = new Tuple[n];
//        for (int i =0; i < visited.length; i++) visited[i] = new Tuple(99999999,0);
//        LinkedList<Integer> queue = new LinkedList<Integer>(); 
//        visited[src].price = 0; 
//        queue.add(src);
//
//        while (queue.size() != 0) 
//        { 
//            // Dequeue a vertex from queue and print it 
//            int s = queue.poll(); 
//            for(int i=0; i<map.get(s).size();i++)
//            {
//                System.out.println(map.get(s));
//                if (visited[map.get(s).get(i).destination].price == 99999999)
//                {
//                    queue.add(map.get(s).get(i).destination);
//                }
//                visited[map.get(s).get(i).destination] = new Tuple(Math.min((visited[s].price + map.get(s).get(i).weight),
//                		visited[map.get(s).get(i).destination].price),Math.min(visited[s].stops + 1,visited[map.get(s).get(i).destination].stops));
//                System.out.println(queue);
//            }
//        }       
//        if (visited[dst].stops > K) return -1;
//        else return visited[dst].price;
        // Comparing on the basis of weights
        HashMap<Integer, List<int[]>> map = new HashMap();
        for(int i = 0; i < n; i++) map.put(i, new ArrayList<int[]>());
        for (int[] f : flights) {
            List<int[]> list = map.get(f[0]);
            list.add(new int[]{f[1], f[2]});
        }
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.offer(new int[] {src, 0, -1});
        
        // A new node is made of {destination, weight, stops}
        // Adding new node to queue only if stops <= K
        while (!q.isEmpty()) {
           int[] city = q.poll();
           if(city[0] == dst) return city[1];
           for(int[] nei: map.get(city[0])) {
               if(city[2] + 1 > K) continue;
               int[] new_node = new int[] {nei[0], city[1] + nei[1], city[2] + 1};
           		System.out.println("the desitination is=" + nei[0] + " and the price is " + (city[1] + nei[1]) + " with " + (city[2] + 1) + " stops");

               q.offer(new_node);
           }
        }
        return -1;
    }


}


class Demo787
{
	public static void main(String[] args)
	{	
		int[][] graph = {{0,1,100},{1,2,100},{0,2,500}};
		Solution787 s = new Solution787();
		int result = s.findCheapestPrice(3,graph,0,2,1);
		System.out.println(result);
		}
}


//import java.util.*;
//class Solution {
//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
//        // 1. store the vertices as key of hash map, value is the vertices that can connect
//        // to plus the prices List<int[]>
//        int[] dp = new int[n];
//        for(int i = 0; i < n; i++) dp[i] = 9999999;
//        
//        Map<Integer, List<int[]>> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            List<int[]> l = new ArrayList<>();
//            map.put(i, l);
//        }
//        
//        for (int i = 0; i< flights.length; i++){
//                map.get(flights[i][0]).add(new int[] {flights[i][1], flights[i][2]});
//        }
//        //System.out.println(map.toString());
//        
//        Queue<int[]> s = new LinkedList<>();
//        s.offer(new int[] {src,0 , -1});
//        dp[src] = 0;
//        while (s.size() > 0){
//
//            int[] curr = s.poll();
//            //System.out.println("popping " + Arrays.toString(curr));
//            int curr_city = curr[0];
//            int curr_price = curr[1];
//            int curr_stops = curr[2];
//            
//            if (curr_stops < K+ 1){
//                dp[curr_city] = Math.min(dp[curr_city], curr_price);
//            }
//            else{
//                break;
//            }
//            
//            for(int[] dest: map.get(curr_city)){
//                
//                int dest_city = dest[0];
//                int dest_price = dest[1];
//                if ( dp[dest_city] > curr_price + dest_price  ){
//                    //System.out.println(Arrays.toString(dest));
//                    //System.out.println(Arrays.toString(curr));
//                    s.offer(new int[] {dest_city, curr_price + dest_price, curr_stops + 1});
//                }
//            }
//        }
//        // 
//        if (dp[dst] == 9999999 ) return -1;
//        return dp[dst];
//    }
//}