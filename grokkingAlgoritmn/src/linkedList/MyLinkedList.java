package linkedList;
import linkedList.*;

public class MyLinkedList {

	Node head;
	Node tail;
	int size = 0;

	public void add(String name) {

		Node node = new Node(name);

		if (tail == null) {
			head = node;
			tail = node;

		} else {
			tail.nextNode = node;
			tail = node;

		}
		size ++;

	}

	public Node delete(String name) {
		
		
		if(size==0) {
			return null;
		}
		if(size==1) {
			head = null;
			tail = null;
			size--;
			return null;
		}

		Node nodeBeforeNodetoDelete = findNodeBefore(name);
		
		if(nodeBeforeNodetoDelete.name==null) {
			head = head.nextNode;
			size--;
		}
		else if (nodeBeforeNodetoDelete != null) {

			if (tail.name.equalsIgnoreCase(name)) {
				nodeBeforeNodetoDelete.nextNode=null;
				tail = nodeBeforeNodetoDelete;

			}else {
				nodeBeforeNodetoDelete.nextNode = nodeBeforeNodetoDelete.nextNode.nextNode;
			}
			size--;

		}
		return null;
	}
	
	
	
	public Node findNodeBefore(String name) {

		if (head.name.equalsIgnoreCase(name)) {
			return new Node();
		}

		Node node = head;

		while (node.nextNode != null) {

			if(node.nextNode.name.equalsIgnoreCase(name)) {
				return node;
			}
			node = node.nextNode;

		}
		System.out.println("확인되지 않는 회원 입니다.");
		return null;
	}

	
	
	public Node find(String name) {

		if (head == null) {
			return null;
		}

		if (head.name.equalsIgnoreCase(name)) {
			return head;
		}

		Node node = head;

		while (node.nextNode != null) {

			node = node.nextNode;
			if (node.name.equalsIgnoreCase(name)) {
				return node;
			}

		}
		return null;
	}


	public boolean printMember(String name) {
		Node node = find(name);
		if (node == null) {
			System.out.println("확인되지 않는 회원 입니다.");
			System.out.println("다시 입력 해주세요.");
			return false;
		} else {
			System.out.println(node.name + "\t" + node.point);
			return true;
		}
	}

	public void addPoint(String name, double point) {
		Node node = find(name);
		if (node == null) {
			System.out.println("확인되지 않는 회원 입니다.");
		} else {
			node.addPoint(point);;
		}

	}

	public boolean signUp(String name) {
		Node node = find(name);

		if (node == null) {
			add(name);
			return false;
		} else {
			System.out.println("이미 있는 회원 입니다.");
			System.out.println("다시 입력 해주세요.");
			return true;
		}

	}
	
	public void deleteMember(String name) {
		delete(name);
	}

}
