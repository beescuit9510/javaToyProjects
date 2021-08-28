import java.lang.reflect.Array;

public class MyGQueue<T> {
	private int max;
	private int front;
	private int rear;
	private int num;
	private T[] que;

	@SuppressWarnings("unchecked")
	public MyGQueue(Class<T> clazz, int max) {
		if (max > 50)
			this.max = 50;
		else
			this.max = max;

		que = (T[]) Array.newInstance(clazz, max);
	}

	public void enque(T val) {
		if(num>=max)
			return;
		que[rear] = val;
		
		rear++;
		num++;
		
		if(rear >= max) {
			rear = 0;
		}

	}

	public T deque() {
		if(num<=0)
			return null;
		T r = que[front];
		que[front] = null;
		
		front++;
		num--;
		
		if(front >= max) {
			rear = 0;
		}

		return r;

	}

	public T peak() {
		return que[front];

	}
	
	public int indexOf(T val) {
		for(int i=0; i<num;i++) {
			int idx = (i+front)%max;
			if(que[idx].equals(val))
				return idx;
		}
		return -1;
	}
	
	public int search(T val) {
		for(int i=0; i<num;i++) {
			int idx = (i+front)%max;
			if(que[idx].equals(val))
				return i;
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	public void clear() {
		front = rear = num = 0;
		que = (T[]) Array.newInstance(que.getClass(), max);
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
		for (T t: que) {
			if(t==null)
				str += "empty"+"\t";
			else
				str += t.toString() + "\t";
		}
		return str + "]";
	}

}
