import java.util.ArrayList;
import java.util.Stack;

public class BasicExercises13
{ 
 
	static ArrayList<Node> nodes=new ArrayList<>();
	static class Node
	{
		int data;
		boolean visited;
 
		Node(int data)
		{
			this.data=data;
 
		}
	}
 
	// find neighbors of node using adjacency matrix
	// if adjacency_matrix[i][j]==1, then nodes at index i and index j are connected
	public ArrayList<Node> findNeighbours(int adjacency_matrix[][],Node x)
	{
		int nodeIndex=-1;
 
		ArrayList<Node> neighbours=new ArrayList<>();
		for (int i = 0; i < nodes.size(); i++) {
			if(nodes.get(i).equals(x))
			{
				nodeIndex=i;
				break;
			}
		}
 
		if(nodeIndex!=-1)
		{
			for (int j = 0; j < adjacency_matrix[nodeIndex].length; j++) {
				if(adjacency_matrix[nodeIndex][j]==1)
				{
					neighbours.add(nodes.get(j));
				}
			}
		}
		return neighbours;
	}
 
 
	// Recursive DFS
	public  void dfs(int adjacency_matrix[][], Node node)
	{
 
		System.out.print(node.data + " ");
		ArrayList<Node> neighbours=findNeighbours(adjacency_matrix,node);
        node.visited=true;
		for (int i = 0; i < neighbours.size(); i++) {
			Node n=neighbours.get(i);
			if(n!=null && !n.visited)
			{
				dfs(adjacency_matrix,n);
			}
		}
	}
 
	    // Iterative DFS using stack
	public  void dfsUsingStack(int adjacency_matrix[][], Node node)
	{
		Stack<Node> stack=new  Stack<>();
		stack.add(node);
 
		while (!stack.isEmpty())
		{
			Node element=stack.pop();
			if(!element.visited)
			{
				System.out.print(element.data + " ");
				element.visited=true;
			}
 
			ArrayList<Node> neighbours=findNeighbours(adjacency_matrix,element);
			for (int i = 0; i < neighbours.size(); i++) {
				Node n=neighbours.get(i);
				if(n!=null &&!n.visited)
				{
					stack.add(n);
				}
			}
		}
	}
 
	public static void main(String arg[])
	{
 
		Node node10 =new Node(10);
		Node node20 =new Node(20);
		Node node30 =new Node(30);
		Node node40 =new Node(40);
 
		nodes.add(node10);
		nodes.add(node20);
		nodes.add(node30);
		nodes.add(node40);

		int adjacency_matrix[][] = {
				{0,1,1,1},  // Node 1: 10
				{1,0,0,0},  // Node 2: 20
				{1,1,0,0},  // Node 3: 30
				{1,0,0,0},  // Node 4: 40

		};
 
		BasicExercises13 DFS = new BasicExercises13();
 
		System.out.println("The DFS traversal of the graph using stack ");
		DFS.dfsUsingStack(adjacency_matrix, node10);
 
		System.out.println();
 
		clearVisitedFlags();
 
		System.out.println("The DFS traversal of the graph using recursion ");
		DFS.dfs(adjacency_matrix, node10);
 
	}
 
	public static void clearVisitedFlags()
	{
		for (int i = 0; i < nodes.size(); i++) {
			nodes.get(i).visited=false;
		}
	}
}
