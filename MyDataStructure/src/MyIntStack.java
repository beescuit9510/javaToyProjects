public class MyIntStack {
	private int max;
	private int ptr = -1;
	private int[] stk;

	public MyIntStack(int max) {

		try {

			if (max > 50) {
				throw new OutOfMemoryError();
			}else {
				stk = new int[max];
				this.max = max;				
			}

		} catch (OutOfMemoryError e) {
			e.printStackTrace();
		}

	}
	
	public class EmptyIntStackException extends RuntimeException{
		public EmptyIntStackException() {}
	}

	public class OverflowIntStackException extends RuntimeException{
		public OverflowIntStackException() {}
	}

	public boolean push(int i) throws OverflowIntStackException{
		if (++ptr >= max)
			throw new OverflowIntStackException();

		stk[ptr] = i;
		return true;
	}

	public int pop() throws EmptyIntStackException{
		if (ptr <= 0)
			throw new EmptyIntStackException();

		int popped = stk[ptr];
		stk[ptr] = 0;
		ptr--;
		return popped;
	}
	
	public int peak() throws EmptyIntStackException{
//		if(ptr <= -1 || ptr >= this.max) {
//			throw new EmptyIntStackException();
//		}
		
		return stk[ptr];
	}

	public int indexOf(int target) {
		for(int i=this.ptr;i>-1;i--) {
			if(stk[i]==target)
				return i;
		}
		return -1;
	}
	
	public void clear() {
		ptr = 0;
		this.stk = new int[max];
	}
	
	public int capacity() {
		return max;
	}
	public int size() {
		return ptr;
	}

	
	public boolean isEmpty() {
		return ptr<=0;
	}
	
	public boolean isFull() {
		return ptr>=max;
	}
	
	
	@Override
	public String toString() {
		String str = "[";
		
		for (int i : stk)
			str += i + "\t";
		
		return str+"]";
	}

}
