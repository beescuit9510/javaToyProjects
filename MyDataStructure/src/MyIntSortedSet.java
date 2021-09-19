import java.util.Arrays;

public class MyIntSortedSet extends MyIntSet {

	public MyIntSortedSet(int capacity) {
		super(capacity);
	}

	@Override
	public boolean add(int target) {
		boolean r = super.add(target);
		int[] set1 = super.getSet();
		Arrays.sort(set1);

		this.clear();

		for (int n : set1) {
			super.add(n);
		}

		return r;
	}

	@Override
	public boolean add(MyIntSet set) {
		boolean r = super.add(set);
		int[] set1 = super.getSet();
		Arrays.sort(set1);

		this.clear();

		for (int n : set1) {
			super.add(n);
		}

		return r;
	}

}
