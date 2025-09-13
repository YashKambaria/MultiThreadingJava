package part2;

public class Counter {
	private int count;
	
	public synchronized void increament(){
		count++;
	}
	public int get(){
		return count;
	}
}
