public abstract class Shape {
   protected String name;

   public Shape(String n) {
     name = new String(n);
   }

   public abstract double getArea();

   public String getName() {return name;}

}