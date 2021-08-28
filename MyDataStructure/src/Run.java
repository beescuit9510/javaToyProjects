
public class Run {
	
	public static void main(String[] args) {
		
		MyIntRingBuffer rb = new MyIntRingBuffer(5);
		
		rb.enque(1);
		rb.enque(2);
		rb.enque(3);
		rb.enque(4);
		rb.enque(5);
		rb.enque(6);
		rb.enque(7);
		rb.enque(8);
		rb.enque(9);
		rb.enque(10);
		rb.enque(11);
		System.out.println(rb);
		System.out.println(rb.deque());
		
	}

}
