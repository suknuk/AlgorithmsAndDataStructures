package graphTheory.adjacencyMatrix;

/*
 * an entry in the matrix
 */
public class Entry {
	private int nodeNumber;
	private int nodeValue;
	
	public Entry(int nr, int val){
		this.nodeNumber = nr;
		this.nodeValue = val;
	}
	
	public int getNodeNumber() {
		return nodeNumber;
	}

	public int getNodeValue() {
		return nodeValue;
	}

	@Override
	public String toString() {
		return "Entry [nodeNumber=" + nodeNumber + ", nodeValue=" + nodeValue + "]";
	}
}
