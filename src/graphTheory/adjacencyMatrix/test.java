package graphTheory.adjacencyMatrix;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		AdjacencyMatrix am = new AdjacencyMatrix(9);
		
		am.addUndirectedUnweightedEdge(1, 2);
		am.addUndirectedUnweightedEdge(1, 8);
		am.addUndirectedUnweightedEdge(1, 6);
		
		am.addUndirectedUnweightedEdge(2,3);
		am.addUndirectedUnweightedEdge(8,3);
		am.addUndirectedUnweightedEdge(6,7);
		
		am.addUndirectedUnweightedEdge(3,4);
		am.addUndirectedUnweightedEdge(3,9);
		am.addUndirectedUnweightedEdge(7,9);
		am.addUndirectedUnweightedEdge(7,5);
		
		am.addUndirectedUnweightedEdge(9,5);
		am.addUndirectedUnweightedEdge(4,5);
		
		
		ArrayList<ArrayList<Integer>> bfs = am.BFS(1);
		
		int level = 0;
		
		for (ArrayList<Integer> nodes : bfs){
			System.out.println("level : " + level);
			for (Integer node : nodes){
				System.out.println(node);
			}
			level++;
		}

	}

}
