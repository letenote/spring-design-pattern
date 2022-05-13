package letenote.designpattern.singleton;

public class Counter {
	private Long counter = 0L;

	public Long getValueCounter() {
		return this.counter;
	}

	public void resetCounter(){
		this.counter = 0L;
	}

	public void incrementCounter(){
		this.counter++;
	}

	public synchronized void incrementCounterMutableResolver(){
		this.counter++;
	}
}
