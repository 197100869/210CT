public class BasicExercises3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle circle;
		Square square;
		//circle = new Circle("Circle", new Point(22, 8), 3.5 );
	    //square = new Square("Square", new Point(7.5, 2), 18 );
	    circle = new Circle("Circle", new Point(2, 4), 2 );
	    square = new Square("Square", new Point(0, 9), 5 );

	    System.out.print(circle.getName() +
	                            ": " + circle.toString());
	    System.out.println("; Area = " + circle.getArea());

	    System.out.print(square.getName() +
	                            ": " + square.toString());
	    System.out.println("; Area = " + square.getArea());
	}
}
