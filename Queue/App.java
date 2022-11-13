package Queue;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Queue<Integer> queue = new Queue<Integer>();
		
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		
		System.out.println(queue.dequeue());
		
		System.out.println(queue.size());

	}

}
