
public class MyIntQueue {
	private int max;
	private int front;
	private int rear;
	private int num;
	private int[] que;

	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {
		}
	}

	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {
		}
	}

	public MyIntQueue(int max) {

		if (max > 50) {
			this.max = 50;
		} else {
			this.max = max;
		}

		que = new int[this.max];

	}

	public boolean enque(int val) {
		if (max <= num) {
			throw new OverflowIntQueueException();
		}
		que[rear] = val;
		num++;
		rear++;

		if (rear >= max) {
			rear = 0;
		}
		return true;
	}

	public int deque() {
		if (num <= 0)
			throw new EmptyIntQueueException();

		int r = que[front];
		que[front] = 0;
		num--;
		front++;

		if (front == max) {
			front = 0;
		}

		return r;
	}

	public int peak() {
		if (num <= 0)
			throw new EmptyIntQueueException();
		return que[front];
	}

	
	public int indexOf(int val) {
		for (int i = 0; i < num; i++) {
			int idx = (i+front)%max;
//			스캔시작점은 front 이기때문에 font+i
//			max를 넘어가면 max 만큼 빼줘야함 %max 
			if (que[idx] == val) {
				return idx;
			}

		}
		return -1;
	}
	public int search(int val) {
		for (int i = 0; i < num; i++) {
			int idx = (i+front)%max;
			if (que[idx] == val) {
				return i;
			}
			
		}
		return -1;
	}

	public void clear() {
		front = rear = num = 0;
		que = new int[max];
	}

	public int capacity() {
		return max;
	}

	public int size() {
		return num;
	}

	public boolean isEmpty() {
		return num <= 0;
	}

	public boolean isFull() {
		return num >= max;
	}

	@Override
	public String toString() {
		String str = "[";
		for(int i=0; i<max; i++) {
			str += que[i]+"\t";
		}
		return str+"]";
	}
	
	

}
