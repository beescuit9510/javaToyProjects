package linkedList;


public class Node {
	
	String name;
	double point = 0;
	Node nextNode;
	
	public Node() {
		
	}
	
	public Node(String name) {
		this.name = name;
	}
	
	
	public void addPoint(double point) {
		this.point+=point;
	}
	
	public double getPoint() {
		return point;
	}
	
//	public int getData() {
//		return data;
//	}
//	public void setData(int data) {
//		this.data = data;
//	}
//	public Node getNextNode() {
//		return nextNode;
//	}
//	public void setNextNode(Node nextNode) {
//		this.nextNode = nextNode;
//	}

}
