public class Queue extends HidingLinkedList {	
	class EmptyQueueException extends RuntimeException{
		public EmptyQueueException ()
		{ super("Queue is empty"); }
		}

	public Queue() {
		super();
	}

	public void enqueue(Object item) {
		if (head == null) {
			head = new Node(item);
			tail = head;
		} else {
			tail.setNext(new Node(item));
			tail = tail.getNext();
		}
	}

	public Object dequeue() throws EmptyQueueException{
		Object item = null;
		
		if (empty())
			throw new EmptyQueueException();
		

		if (head == null)
			return null;
		item = head.getData();
		head = head.getNext();
		if (head == null)
			tail = null;
		return item;
	}

	public boolean empty() {
		return (head == null);
	}

}
