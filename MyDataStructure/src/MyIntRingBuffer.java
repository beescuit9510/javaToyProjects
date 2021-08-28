
public class MyIntRingBuffer {
	private int max;
	private int front;
	private int rear;
	private int num;
	private int[] que;
	
	
	
	
	
	public MyIntRingBuffer(int max) {
		super();
		this.max = max;
		que = new int[this.max];
	}

	public void enque(int val) {
		
		que[rear] = val;	
		rear++;
		num++;

		if(rear >= max) {
			rear = 0;
		}

	}
	
	public int deque() {
		int x = que[(front+num)%max];
		que[front] = 0;
		return x;

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
