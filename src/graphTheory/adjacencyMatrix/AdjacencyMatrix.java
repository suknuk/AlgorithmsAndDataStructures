package graphTheory.adjacencyMatrix;

import java.util.ArrayList;

/*
 * Graph theory with java
 * Nodes and edges
 */

public class AdjacencyMatrix {

	/*
	 * the adjacency matrix
	 */
	private int[][] matrix;

	/*
	 * constructor
	 */
	public AdjacencyMatrix(int dimension) {
		// +1 because i'm lazy
		this.matrix = new int[dimension+1][dimension+1];
	}

	/*
	 * showing connected nodes and their weight
	 */
	public ArrayList<Entry> connectedNodes(int fromNode){
		ArrayList<Entry> connected = new ArrayList<Entry>();
		
		for (int x = 0; x < matrix.length; x++){
			if (matrix[x][fromNode] != 0){
				connected.add(new Entry(x,matrix[x][fromNode]));
			}
		}
		
		return connected;
	}
	
	/*
	 * Adding directed edges
	 */
	public void addDirectedWeightedEdge(int fromNode, int toNode, int weight) {
		this.matrix[toNode][fromNode] = weight;
	}

	public void addDirectedUnweightedEdge(int fromNode, int toNode) {
		this.addDirectedWeightedEdge(fromNode, toNode, 1);
	}

	/*
	 * adding undirected edges
	 */
	public void addUndirectedWeightedEdge(int node1, int node2, int weight) {
		this.addDirectedWeightedEdge(node1, node2, weight);
		this.addDirectedWeightedEdge(node2, node1, weight);
	}

	public void addUndirectedUnweightedEdge(int node1, int node2) {
		this.addUndirectedWeightedEdge(node1, node2, 1);
	}
	
	/*
	 * removing directed and undirected edges
	 */
	public void removeDirectedEdge(int fromNode, int toNode){
		this.addDirectedWeightedEdge(fromNode, toNode, 0);
	}
	
	public void removeUndirectedEdge(int node1, int node2){
		this.removeDirectedEdge(node1, node2);
		this.removeDirectedEdge(node2, node1);
	}
	
	public ArrayList<ArrayList<Integer>> BFS(int startNode){
		ArrayList<ArrayList<Integer>> search = new ArrayList<ArrayList<Integer>>();
		
		boolean [] visited = new boolean[matrix.length];
		visited[startNode] = true;
		int visited_nr = 1;
		
		ArrayList<Integer> currentLevel = new ArrayList<Integer>();
		currentLevel.add(startNode);
		search.add(currentLevel);
		
		boolean searching = true;
		
		/*
		 * until all nodes are found at least once
		 */
		while (searching) {
			
			ArrayList<Integer> nextLevel = new ArrayList<Integer>();
			// iterate every node on the current level
			for (Integer node : currentLevel){
				// find every connected node of that node
				ArrayList<Entry> connected = this.connectedNodes(node);
				for (Entry entry : connected){
					if (visited[entry.getNodeNumber()] == false){
						visited[entry.getNodeNumber()] = true;
						visited_nr++;
						nextLevel.add(entry.getNodeNumber());
					}
				}
			}
			
			search.add(nextLevel);
			currentLevel = nextLevel;
			
			if (visited_nr == matrix.length - 1){
				searching = false;
			}
		}
		
		return search;
	}
}
