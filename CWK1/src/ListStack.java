import java.util.EmptyStackException;

public class ListStack extends HidingLinkedList {
	public ListStack() { 
		super();
	}
	public boolean empty() {
		if (isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public Object push(Object item) {
		addToHead(item);
		return item;
	}

	public Object pop() throws EmptyStackException{
		if (isEmpty())
			throw new EmptyStackException();
		Object item = removeFromHead();
		return item;
	}

	public Object peek() throws EmptyStackException{
		if (isEmpty())
			throw new EmptyStackException();
		Object item = get(0);
		return item;
	}

	public int search(Object item) {
		Node current = head;
		int num = -1;
		for (int i = 0; i < length; i++) {
			if (item.equals(current.getData())) {
				return i;
			} else {
				current = current.getNext();
			}
		}
		return num;
	}

}
