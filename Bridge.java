package Structural_Design_Patterns;
interface Draw
{
	public void drawCircle(int radius);
}
class RedCircle implements Draw
{
	public void drawCircle(int radius)
	{
		System.out.println("Drawing red circle of radius "+radius);
	}
}
class GreyCircle implements Draw
{
	public void drawCircle(int radius)
	{
		System.out.println("Drawing Grey circle of radius "+radius);
	}
}
abstract class Shape
{
	protected Draw draw;//using interface in an abstract method as a bridge
	   
	   protected Shape(Draw draw){
	      this.draw = draw;
	   }
	   public abstract void draws();	
}
class Circle extends Shape
{
	private int radius;

	   public Circle(int radius, Draw draw) {
	      super(draw);
	      this.radius = radius;
	   }
	public void draws()
	{
		draw.drawCircle(radius);
	}
}
public class Bridge {
public static void main(String args[])
{
	Shape redCircle = new Circle( 10, new RedCircle());
    Shape greyCircle = new Circle(15, new GreyCircle());

    redCircle.draws();
    greyCircle.draws();
}
}
