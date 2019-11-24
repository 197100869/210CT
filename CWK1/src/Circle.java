public class Circle extends Shape{
	private double radius;
	private Point center;		
	public Circle(String name, Point center, double radius) {
		super(name);
		this.center = center;
		this.radius = radius;
		
		// TODO Auto-generated constructor stub
	}

	public double getArea() {
		
		// TODO Auto-generated method stub
		return this.radius * this.radius * Math.PI;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double newRadius) {
		radius = newRadius;
	}
	
	public Point getCenter() {
		return center;
	}
	
	public void setCenter(Point newCenter) {
		center = newCenter;
	}
	
	public String toString() {
		return "Circle [radius=" + radius + ", center=" + center + "]";
	}
	
}
