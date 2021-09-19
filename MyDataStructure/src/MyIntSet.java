import java.util.Arrays;

public class MyIntSet {
	private int max; // set length
	private int size;
	private int[] set;

	
	public MyIntSet(int capacity) {
		super();
		this.size = 0;
		this.max = capacity;
		try {
			set = new int[max];
		} catch (OutOfMemoryError e) {
			e.printStackTrace();
		}
	}
	
	public int[] getSet() {
		return Arrays.copyOf(set, size);
	}

	public int capacity() {
		return max;
	}

	public int size() {
		return size;
	}

	public int indexOf(int target) {
		int r = -1;

		for (int i = 0; i < size; i++) {
			r = target == set[i] ? i : r;
		}

		return r;
	}

	public boolean contains(int target) {
		return indexOf(target) > -1;

	}

	public boolean add(int target) {
		if (max <= size || contains(target)) {
			return false;
		}
		set[size++] = target;
		return true;

	}

	public boolean add(MyIntSet set) {
		int max = set.size + this.size;
		if (max > this.max) {
			return false;
		}

		for (int i = 0; i < set.size; i++) {
			add(set.set[i]);
		}
		return true;

	}

	public boolean remove(int target) {
		int idx = indexOf(target);
		if (size <= 0 || idx == -1) {
			return false;
		}
		set[idx] = set[--size];
		return true;

	}

	public boolean remove(MyIntSet set) {
		if (set.size == 0) {
			return false;
		}
		for (int n : set.set) {
			remove(n);
		}
		return true;

	}

	public boolean retain(MyIntSet set) {
		MyIntSet newSet = new MyIntSet(this.max);

		if (set.size <= 0 || this.size <= 0) {
			this.size = 0;
			this.set = new int[Math.max(set.max, this.max)];
			return true;
		}

		for (int n : set.set) {
			if (contains(n)) {
				newSet.add(n);
			}
		}
		for (int n : this.set) {
			if (set.contains(n)) {
				newSet.add(n);
			}
		}

		this.size = newSet.size;
		this.set = newSet.set;
		
		return true;

	}

	public void copyTo(MyIntSet s) {
		int max = s.max < this.size ? s.max : this.size;
		for (int i = 0; i < max; i++) {
			s.set[i] = this.set[i];
		}
		s.size = max;
	}

	public void copyFrom(MyIntSet s) {
		int max = this.max < s.size ? this.max : s.size;
		for (int i = 0; i < max; i++) {
			this.set[i] = s.set[i];
		}
		this.size = max;

	}

	public boolean equalTo(MyIntSet s) {
		if (this.size != s.size) {
			return false;
		}
		for (int i = 0; i < this.size; i++) {
			int j = 0;
			for (; j < s.size; j++) {
				if (this.set[i] == s.set[j])
					break;
			}
			if (j >= s.size) {
				return false;
			}
		}

		return true;
	}

	public void unionOf(MyIntSet a, MyIntSet b) {
		copyFrom(a);
		for (int i = 0; i < b.size; i++) {
			add(b.set[i]);
		}
	}

	public void intersectionOf(MyIntSet a, MyIntSet b) {
		copyFrom(a);
		retain(b);
	}
	
	public void differenceOf(MyIntSet a, MyIntSet b) {
		MyIntSet intersection =  new MyIntSet(Math.max(a.max, b.max));
		intersectionOf(a, b);
		intersection.copyFrom(this);
		
		unionOf(a, b);
		remove(intersection);
		
	}
	
	public boolean isSubsetOf(MyIntSet set) {
		if (this.size > set.size) {
			return false;
		}
		for (int i = 0; i < this.size; i++) {
			if (!set.contains(this.set[i])) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isProperSubsetOf(MyIntSet set) {
		if (this.size > set.size) {
			return false;
		}
		for (int i = 0; i < this.size; i++) {
			if (!set.contains(this.set[i])) {
				return false;
			}
		}
		return this.size!=set.size;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(" { ");
		for (int i = 0; i < this.size; i++) {
			sb.append(this.set[i] + " ");
		}
		sb.append(" } ");
		return sb.toString();
	}

	public boolean isEmpty() {
		return this.size <= 0;
	}

	public boolean isFull() {
		return this.size >= this.max;
	}

	public void clear() {
		this.set = new int[this.max];
		this.size = 0;
	}

}
