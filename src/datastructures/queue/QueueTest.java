package datastructures.queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue q = new Queue(5);
		q.enqueue(0);
		q.enqueue(2);
		q.enqueue(4);
		q.enqueue(3);
		q.enqueue(5);
		q.printQueue();
		System.out.println("Queue Size: " + q.getQueueSize());

		q.enqueue(1);

		q.dequeue();
		q.printQueue();
		System.out.println("Queue Size: " + q.getQueueSize());

		q.dequeue();
		q.printQueue();
		System.out.println("Queue Size: " + q.getQueueSize());
	}

}
