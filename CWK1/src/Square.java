public class Square extends Shape{
	private Point topLeft;
	private double width;
	
	public Square(String name, Point topLeft, double width) {
		super(name);
		this.topLeft = topLeft;
		this.width = width;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return this.width * this.width;
	}

	@Override
	public String toString() {
		return "Square [topLeft=" + topLeft + ", width=" + width + "]";
	}
	public double getWidth( ) {
		return width;
	}
	public void setWidth(double newWidth) {
		width = newWidth;
	}
	public Point setTopLeft() {
		return topLeft;
		
	}
	public void getTopLeft(Point newTopLeft) {
		topLeft = newTopLeft;
	}
	
	
	
}
