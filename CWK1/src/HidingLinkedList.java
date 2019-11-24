class Node {
	private Object data;
	private Node next;

	public Node(Object o) {
		data = o;
		next = null;
	}

	public Node(Object o, Node nextNode) {
		data = o;
		next = nextNode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object o) {
		data = o;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

} // class Node

class EmptyListException extends RuntimeException {
	public EmptyListException() {
		super("List is empty");
	}
} // class EmptyListException

public class HidingLinkedList {

	protected Node head;
	protected Node tail;
	protected int length;

	public HidingLinkedList() {
		head = tail = null;
		length = 0;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addToHead(Object item) {
		if (isEmpty())
			head = tail = new Node(item);
		else
			head = new Node(item, head);
		length++;
	}

	public void addToTail(Object item) {
		if (isEmpty())
			head = tail = new Node(item);
		else {
			tail.setNext(new Node(item));
			tail = tail.getNext();
		}
		length++;
	}

	public Object removeFromHead() throws EmptyListException {
		Object item = null;
		if (isEmpty())
			throw new EmptyListException();
		item = head.getData();
		if (head == tail)
			head = tail = null;
		else
			head = head.getNext();
		length--;
		return item;
	}

	public Object removeFromTail() throws EmptyListException {
		Object item = null;
		if (isEmpty())
			throw new EmptyListException();
		item = tail.getData();
		if (head == tail)
			head = tail = null;
		else {
			Node current = head;
			while (current.getNext() != tail)
				current = current.getNext();
			tail = current;
			current.setNext(null);
		}
		length--;
		return item;
	}

	public String toString() {
		String str = "[ ";
		Node current = head;
		while (current != null) {
			str = str + current.getData() + " ";
			current = current.getNext();
		}
		return str + " ]";
	}

	public int count() {
		return length;
	}

	public Object remove(int n) {
		Object item = null;
		if (n <= length) { // make sure there is nth node to remove
			// special treatment for first and last nodes
			if (n == 1)
				return removeFromHead();
			if (n == length)
				return removeFromTail();
			// removal of nth node which has nodes in front and behind
			Node current = head;
			Node previous = null;
			for (int i = 1; i < n; i++) { // current will point to nth node
				previous = current;
				current = current.getNext();
			}
			// data to be returned
			item = current.getData();
			// remove the node by adjusting two pointers (object reference)
			previous.setNext(current.getNext());
		}
		length--;
		return item;
	}

	public void add(int n, Object item) {
		// special treatment for insert as first node
		if (n == 1) {
			addToHead(item);
			return;
		}
		// special treatment for insert as last node
		if (n > length) {
			addToTail(item);
			return;
		}
		// locate the n-1th node
		Node current = head;
		for (int i = 1; i < n - 1; i++) // current will point to n-1th node
			current = current.getNext();
		// create new node and insert at nth position
		current.setNext(new Node(item, current.getNext()));
		length++;
	}

	public Object get(int n) {
		// n is too big, no item can be returned
		if (length < n)
			return null;
		// locate the nth node
		Node current = head;
		for (int i = 1; i < n; i++)
			current = current.getNext();
		return current.getData();
	}

}