public class MyLinkedList {

	public static void main(String[] args) {
		MyLinkedListClass list = new MyLinkedListClass();
		list.add(1);
		list.add(2);
		list.add(3);		list.add(4);
		list.add(5);
		list.add(6);

		System.out.println(list.head.val);
		System.out.println(list.head.next.val);
		System.out.println(list.head.next.next.val);
		System.out.println(list.find(2));
		System.out.println(list.delete(4));
		System.out.println(list.head.val);
		System.out.println(list.head.next.val);
		System.out.println(list.head.next.next.val);
		System.out.println(list.head.next.next.next.val);
		System.out.println(list.head.next.next.next.next.val);
	}

	public static class MyLinkedListClass {

		Node head;
		Node tail;
		int size;

		public MyLinkedListClass() {
			super();
		}

		public void add(int val) {

			Node node = new Node(val);

			if (head == null) {
				head = node;
				tail = node;
			} else {
				tail.next = node;
				tail = node;
			}

			size++;

		}

		public Node delete(int val) {

			Node node = find(val);
			Node deleted = null;

			if (node != null && head != null) {

				if (node == head) {
					deleted = head;
					head = head.next;
				}

				if (node == tail) {
					deleted = tail;
					tail = null;
				}

				Node nodeToDelete = head.next;
				Node nodeBeforeToDelete = nodeBeforeToDelete(val);

				while (nodeToDelete != null) {
					if (nodeToDelete == node) {
						deleted = nodeToDelete;
						nodeBeforeToDelete.next = nodeToDelete.next;
					}
					nodeToDelete = nodeToDelete.next;
				}

				size--;
			}

			return deleted;

		}

		public Node nodeBeforeToDelete(int val) {

			Node node = head;

			while (node.next != null) {
				if (node.next.val == val)
					return node;
				else
					node = node.next;
			}
			return null;

		}

		public Node find(int val) {
			if (head == null)
				return null;

			if (head.val == val) {
				return head;
			}

			if (tail.val == val) {
				return tail;
			}

			Node node = head;

			while (node.next != null) {
				node = node.next;

				if (node.val == val) {
					return node;
				}
			}

			return null;

		}

	}

	public static class Node {
		int val;
		Node prev;
		Node next;

		public Node() {
			super();
		}

		public Node(int val) {
			super();
			this.val = val;
			this.prev = null;
			this.next = null;
		}

		public Node(int val, Node prev, Node next) {
			super();
			this.val = val;
			this.prev = prev;
			this.next = next;
		}

		@Override
		public String toString() {
			return "val :" + val;
		}

	}
}