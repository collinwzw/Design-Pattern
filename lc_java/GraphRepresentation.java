import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import lc1319;

class Graph // assume input is list of int[] vertices
{
	public Map buildDirectedGraphWithoutWeight(int[][] edges) // No weight
	{
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		for(int[] edge: edges)
		{
			if (!map.containsKey(edge[0]))
			{
				map.put(edge[0],new ArrayList<>());
			}
			map.get(edge[0]).add(edge[1]);

		}
		return map;
	}
	
	public Map buildUndirectedGraphWithoutWeight(int[][] edges) // No weight
	{
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		for(int[] edge: edges)
		{
			if (!map.containsKey(edge[0]))
			{
				map.put(edge[0],new ArrayList<>());
			}
			if (!map.containsKey(edge[1]))
			{
				map.put(edge[1],new ArrayList<>());
			}
			map.get(edge[0]).add(edge[1]);
			map.get(edge[1]).add(edge[0]);

		}
		return map;
	}
	
	public Map buildWeightedDirectedGraph(int[][] edges) //  weighted
	{
		Map<Integer, List<int[]>> map = new HashMap<>();
		
		for(int[] edge: edges)
		{
			if (!map.containsKey(edge[0]))
			{
				map.put(edge[0],new ArrayList<>());
			}
			map.get(edge[0]).add(new int[] {edge[1],edge[2]});
			
		}
		return map;
	}
	
    static void printUnweightedGraph(Map<Integer,List<Integer> > graph) 
    { 
        for (Integer i:  graph.keySet()) { 
            System.out.println("\nAdjacency list of vertex" + i); 
            System.out.print("head"); 
            for (int j = 0; j < graph.get(i).size(); j++) { 
                System.out.print(" -> "+graph.get(i).get(j)); 
            } 
            System.out.println(); 
        } 
    } 
    static void printWeightedGraph(Map<Integer,List<int[]> > graph) 
    { 
        for (Integer i:  graph.keySet()) { 
            System.out.println("\nAdjacency list of vertex" + i); 
            System.out.print("head"); 
            for (int j = 0; j < graph.get(i).size(); j++) { 
                System.out.print(" -> "+graph.get(i).get(j)[0] + "(" + graph.get(i).get(j)[1] + ')'); 
            } 
            System.out.println(); 
        } 
    } 
}



class DemoGraph
{
	public static void main(String[] args)
	{
		Graph g = new Graph();
		
		int[][] directedUnweightedEdges = {{0,1},{1,2}, {2,3}, {3,4}};
		Map directedUnweightedgraph = g.buildDirectedGraphWithoutWeight(directedUnweightedEdges);

		int[][] undirectedUnweightedEdges = {{0,1},{1,2}, {2,3}, {3,4}};
		Map undirectedUnweightedgraph = g.buildUndirectedGraphWithoutWeight(directedUnweightedEdges);

		int[][] directedWeightedEdges = {{0,1,5},{1,2,10}, {2,3,3}, {3,4,9}};
		Map directedWeightedGraph = g.buildWeightedDirectedGraph(directedWeightedEdges);
		g.printWeightedGraph(directedWeightedGraph);
	}
}






