package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class TopologicSorting
{
	public TopologicSorting()
	{
		
	}
	public Stack<Integer> topologicSorting(Map<Integer, List<Integer>> graph)
	{	
		int verticesNumber = graph.keySet().size();
		boolean[] visited= new boolean[verticesNumber];

		for(int i = 0; i < visited.length;i++)
		{
			visited[i] = false;

		}
		
		Stack<Integer> s = new Stack<>();
		
		for(Integer vertice: graph.keySet())
		{
			if (visited[vertice] == true)
			{
				continue;
			}
			topologicSortingRecrusive(graph,visited,s, vertice);

		}
		
		return s;
	}
	
	public void topologicSortingRecrusive(Map<Integer, List<Integer>> graph, boolean[] visited,Stack<Integer> s, int startingVertex )
	{	
		
		GraphTraversalMethod gtm = new GraphTraversalMethod();



		visited[startingVertex] = true;
		for(int v: graph.get(startingVertex))
		{
			if (!visited[v])
			{
				topologicSortingRecrusive(graph,visited,s, v);
			}
		}
		s.push(startingVertex);
				
	}
	
	
}