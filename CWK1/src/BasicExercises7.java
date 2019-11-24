import miscLib.SimpleInput;
import miscLib.GenLib;
public class BasicExercises7 {

    public static void main(String[] args) {
		Queue q = new Queue();		
		int n;
		do {
			n = SimpleInput.getInteger("How many to enqueue? ");
			for (int i = 0; i < n; i++) {
				q.enqueue(new Integer(GenLib.genInt(1, 100)));
				System.out.println(q);
			}
			n = SimpleInput.getInteger("How many to dequeue? ");
			for (int i = 0; i < n; i++) {
				if (q.empty()) {
					System.out.println("Queue is now empty, dequeue ignored.");
					break;
				} else {
					System.out.println("dequeued:"+q.dequeue());
					System.out.println(q);
				}
			}
		} while (SimpleInput.getChar("more (y/n)? ") == 'y');

		System.out.println("Bye now.");
		System.exit(0);
    }

} // class Queue