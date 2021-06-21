// package whatever; // don't place package name!

import java.io.*;
import java.util.*;


class Solution684 {
    public static int[] findRedundantConnection(int[][] edges) {
        // assumption: ...
        
        // 1. edges convert to graph using hashmap
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 1; i<=edges.length; i++){
          map.put(i, new ArrayList<>());
        }
        
        HashSet<Integer> visited = new HashSet<>();
        // 3. if cycle is detected, we know we need to remove a edge inside of this cycle
        
        for(int[] edge : edges){
          if (map.get(edge[0]).size() != 0 && map.get(edge[1]).size() != 0 && dfs(edge[0], edge[1], map, visited)){
            return edge;
          }
          else{
            visited.clear();
            //update map
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
          }
        }
        
        return null;

        //  we assign each node to a parent node that the node has access to
        // input [[1,2],[1,3],[2,3]]
        // [null, 1 , 1, 1, ]
    }
    
    
    // 2. doing graph traversal to the built graph (DFS) and found if there is a cycle or not
    public static boolean dfs(Integer source , Integer dest, Map<Integer, List<Integer>> map, HashSet<Integer> visited){
      if (!visited.contains(source)){
        visited.add(source);
        //base case: find source is equal to target, we exist dfs 
        if (source == dest) return true;
        for (Integer node: map.get(source)){
          if (dfs(node, dest, map, visited)) return true;

        }
        
      }
      // otherwise this is a cycle
      return false;
    }
    
    public static void main(String[] args){
      

      
      int[][] arr = {{3,4},{1,2},{2,4},{3,5},{2,5}};
      
      int[] output = findRedundantConnection(arr);
      System.out.println(Arrays.toString(output));
}     
}
  // [null, null, null, null, null, null]
  // [null, null, null, 3, 3, null]
  // [null, 1, 1, 3, 3, null]   
  // [null, 1, 1, 3, 3, null, 3]  4 is not null, union 2 sets , find(4) -> index 3, go to index 3 update to 1
  // [null, 1, 1, 1, 1, null, 3] edge = [ 5, 6]
  // [null, 1, 1, 1, 1, 1, 3]
    // [null, 1, 1, 1, 1, 1] find a cycle
    
    
  // find (index)
  // if array[index] == array[array[index]]
  // else (update )