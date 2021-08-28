public class MyIntStack {
	private int max;
	private int ptr;
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
		if (ptr >= max)
			throw new OverflowIntStackException();

		stk[ptr++] = i;
		return true;
	}

	public int pop() throws EmptyIntStackException{
		if (--ptr < 0)
			throw new EmptyIntStackException();

		int popped = stk[ptr];
		stk[ptr] = 0;
		return popped;
	}
	
	public int peak() throws EmptyIntStackException{
		if(ptr <= 0) {
			throw new EmptyIntStackException();
		}
		
		return stk[ptr-1];
	}

	public int indexOf(int target) {
		for(int i=this.ptr-1;i>-1;i--) {
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
