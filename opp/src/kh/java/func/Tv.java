package kh.java.func;

public class Tv {
	
	
	private int size;
	private int ch;
	private int vol;
	private boolean power;
	
	
	public Tv() {
		
	}
	
	public Tv(int size) {
		this.size = size;
	}
	
	public Tv(int ch, int size, int vol, boolean power) {
		this.ch = ch;
		this.size = size;  
		this.vol = vol;
		this.power = power;
	}
	
	
	public void main() {
		
	}
	
	public void onOff() {
		power=!power;
		System.out.println(power? "������ �������ϴ�":"������ �������ϴ�.");
	}
	
	public void channelUP() {
		ch++;
		System.out.printf("���� ä�� : %d%n", ch);
	}
	public void channelDown() {
		ch =  ch==0? ch:--ch;
		System.out.printf("���� ä�� : %d%n", ch);
	}
	public void volUP() {
		vol++;
		System.out.printf("���� ���� : %d%n", vol);
	}
	public void volDown() {
		vol =  vol==0? vol:--vol;
		System.out.printf("���� ���� : %d%n", vol);
	}
	
	public int getVol() {
		return vol;
	}
	
	public int getCh() {
		return ch;
	}
	
	public boolean getPower() {
		return power;
	}
	public int getSize() {
		return size;
	}
	public void setVol(int vol) {
		this.vol = vol;
	}
	public void setCh(int ch) {
		this.ch = ch;
	}
	
	public void setPower(boolean power) {
		this.power = power;
	}
	

}
