import java.util.HashSet;

public class Application {

	public static void main(String[] args) {
		Container<Integer, String> container = new Container<Integer, String>(1, "hello");
		int val = container.getItem();
		String val2 = container.getItem2();
		
	}
	
	public static Set union(Set set1, Set set2) {
		Set result = new HashSet(set1);
	}
	

}
