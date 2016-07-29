package graphTheory.adjacencyMatrix;

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
		this.matrix = new int[dimension][dimension];
	}

	/*
	 * Adding directed edges
	 */
	public void addDirectedWeightedEdge(int fromNode, int toNode, int weight) {
		this.matrix[fromNode][toNode] = weight;
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
}
