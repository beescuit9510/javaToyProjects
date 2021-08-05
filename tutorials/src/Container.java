
public class Container<i1, i2> {
	
	i1 item;
	i2 item2;
	
	
	
	public Container(i1 item, i2 item2) {
		this.item = item;
		this.item2 = item2;
	}



	public i1 getItem() {
		return item;
	}



	public void setItem(i1 item) {
		this.item = item;
	}



	public i2 getItem2() {
		return item2;
	}



	public void setItem2(i2 item2) {
		this.item2 = item2;
	}



	@Override
	public String toString() {
		return "Container [item=" + item + ", item2=" + item2 + "]";
	}
	
	

}
