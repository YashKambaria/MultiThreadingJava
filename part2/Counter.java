package part2;

public class Counter {
	private int count;
	
	public void increament(){
		synchronized (this) {
			count++;
		}
	}
	public int get(){
		return count;
	}
}
