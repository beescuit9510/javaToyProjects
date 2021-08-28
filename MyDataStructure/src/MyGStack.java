import java.lang.reflect.Array;

public class MyGStack<T> {
	private int max;
	private int ptr;
	private T[] stk;
	


	@SuppressWarnings("unchecked")
	public MyGStack(Class<T> clazz, int max) {

		if (max > 50) {
			this.max = 50;
		} else {
			this.max = max;
		}
		stk = (T[]) Array.newInstance(clazz, this.max);

	}

	public void push(T val) {
		if (ptr >= max)
			return;

		stk[ptr++] = val;

	}

	public T pop() {
		if (ptr - 1 < 0)
			return null;
		T popped = stk[--ptr];
		stk[ptr] = null;
		return popped;
	}

	public int indexOf(T target) {
		for (int i = ptr - 1; i >= 0; i--) {
			if (stk[i].equals(target))
				return i;
		}
		return -1;
	}

	public T peak() {
		return stk[ptr - 1];
	}

	@SuppressWarnings("unchecked")
	public void clear() {
		stk = (T[]) Array.newInstance(stk.getClass(), this.max);
	}

	public int capacity() {
		return max;
	}

	public int size() {
		return ptr;
	}

	public boolean isEmpty() {
		return ptr <= 0;
	}

	public boolean isFull() {
		return ptr >= max;
	}

	@Override
	public String toString() {
		String str = "[";

		for (T element : stk)
			if (element == null) {
				continue;

			} else {
				str += element.toString() + "\t";
			}

		return str + "]";
	}

}
