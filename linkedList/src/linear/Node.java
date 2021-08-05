package linear;

public class Node {
	
	private String name;
	private int point;
	private Node next;
	


	public Node(String name, Node next) {
		this.name = name;
		this.next = next;
	}

	public int getPoint() {
		return point;
	}

	public void addPoint(int point) {
		this.point += point;
	}
	
	
	
}
