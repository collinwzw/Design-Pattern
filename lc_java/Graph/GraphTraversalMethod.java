package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class GraphTraversalMethod
{
	public GraphTraversalMethod()
	{
		
	}
	
	public void DFSInterative(Map<Integer,List<Integer>> graph, int startingVertice)	//iterative
	{
		Stack<Integer> s = new Stack();
		int verticesNumber = graph.keySet().size();
		boolean[] visited= new boolean[verticesNumber];
		
		for(int i = 0; i < visited.length;i++)
		{
			visited[i] = false;
		}
		
		s.add(startingVertice);
		int temp;
		while (s.size() > 0)
		{
			temp = s.pop();
			System.out.println("visiting the vertex " + temp + ".");
			for(Integer dest: graph.get(temp))
			{
				if(visited[dest] == false) // the vertex is not visited yet
				{
					visited[dest] = true;
					s.push(dest);
				}
			}
		}
	}
	
	public void DFSRecursive(Map<Integer,List<Integer>> graph, int startingVertice, boolean[] visited)
	{
		System.out.println("visiting the vertex " + startingVertice + ".");
		for(Integer dest: graph.get(startingVertice))
		{
			if(visited[dest] == false) // the vertex is not visited yet
			{
				visited[dest] = true;
				DFSRecursive(graph,dest,visited);
			}
		}
	}
	
	public boolean DFSRecursiveDetectCycle(Map<Integer,List<Integer>> graph, int startingVertice, boolean[] visited, boolean[] cycle)
	{
		System.out.println("visiting the vertex " + startingVertice + ".");
		for(Integer dest: graph.get(startingVertice))
		{	
			if (cycle[dest] == true)
			{
				return true;
			}
			
			if(visited[dest] == false) // the vertex is not visited yet
			{
				cycle[dest] =true;
				visited[dest] = true;
				if (DFSRecursiveDetectCycle(graph,dest,visited,cycle))
				{
					return true;
				}
				visited[dest] = false;
			}
			
		}
		return false;
	}
	public void BFSInterative(Map<Integer,List<Integer>> graph, int startingVertice)	//iterative
	{
		Queue<Integer> q = new LinkedList<>();
		int verticesNumber = graph.keySet().size();
		boolean[] visited= new boolean[verticesNumber];
		
		for(int i = 0; i < visited.length;i++)
		{
			visited[i] = false;
		}
		
		q.add(startingVertice);
		int temp;
		while (q.size() > 0)
		{
			temp = q.poll();
			System.out.println("visiting the vertex " + temp + ".");
			for(Integer dest: graph.get(temp))
			{
				if(visited[dest] == false) // the vertex is not visited yet
				{	
					//System.out.println("vertex " + dest + "is being added to queue");
					visited[dest] = true;
					q.add(dest);
				}
			}
		}
	}
}