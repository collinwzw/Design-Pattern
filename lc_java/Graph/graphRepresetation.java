package Graph;

import java.util.Map;
import java.util.Stack;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


class Graph // assume input is list of int[] vertices
{
	public Map<Integer, List<Integer>> buildDirectedGraphWithoutWeight(int[][] edges) // No weight
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

		}
		return map;
	}
	
	public Map<Integer, List<Integer>> buildUndirectedGraphWithoutWeight(int[][] edges) // No weight
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
	
	public Map<Integer, List<int[]>> buildWeightedDirectedGraph(int[][] edges) //  weighted
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
	
    public static void printUnweightedGraph(Map<Integer,List<Integer>> graph) 
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
    public static void printWeightedGraph(Map<Integer,List<int[]> > graph) 
    { 
        for (Integer i:  graph.keySet()) { 
            System.out.println("\nAdjacency list of vertex " + i); 
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
		
		boolean[] visited= new boolean[6];
		boolean[] cycle= new boolean[6];
		for(int i = 0; i < visited.length;i++)
		{
			visited[i] = false;
			cycle[i] = false;
		}
		
		int[][] directedUnweightedEdges = {{0,1},{1,2}, {2,3}, {1,4},{3,4},{1,5},{2,5},{3,5},{4,5}};
		GraphTraversalMethod gtm = new GraphTraversalMethod();
		Map<Integer, List<Integer>> directedUnweightedgraph = g.buildDirectedGraphWithoutWeight(directedUnweightedEdges);
		//g.printUnweightedGraph(directedUnweightedgraph);
		//gtm.DFSRecursive(directedUnweightedgraph, 0, visited);
		//gtm.DFSInterative(directedUnweightedgraph, 0);
		TopologicSorting ts = new TopologicSorting();
		if (!gtm.DFSRecursiveDirectedGraphDetectCycle(directedUnweightedgraph, 0, visited, cycle)) //detect cycle
		{
			Stack<Integer> r = ts.topologicSorting(directedUnweightedgraph);
			System.out.print(r);
		}

		
		
		int[][] undirectedUnweightedEdges = {{0,1},{1,2}, {2,3}, {3,4}};
		Map<Integer, List<Integer>> undirectedUnweightedgraph = g.buildUndirectedGraphWithoutWeight(undirectedUnweightedEdges);
		//g.printUnweightedGraph(undirectedUnweightedgraph);
		//System.out.println(gtm.DFSRecursiveUndirectedGraphDetectCycle(undirectedUnweightedgraph, 0,visited,cycle,0));


		int[][] directedWeightedEdges = {{0,1,5},{1,2,10}, {2,3,3}, {3,4,9}};
		Map directedWeightedGraph = g.buildWeightedDirectedGraph(directedWeightedEdges);


	}
}






