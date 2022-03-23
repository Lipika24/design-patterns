package Structural_Design_Patterns;
import java.util.*;
interface Shape1
{
	public void fillColor(String col);
}
class Square implements Shape1 //leaf class
{
	public void fillColor(String col)
	{
		System.out.println("Filled the square with "+col);
	}
}
class Rectangle implements Shape1 //leaf class
{
	public void fillColor(String col)
	{
		System.out.println("Filled the rectangle with "+col);
	}
}
class Component implements Shape1 //composite class
{
	ArrayList<Shape1> al=new ArrayList<>();
	public void add(Shape1 s)
	{
		al.add(s);
	}
	public void remove(Shape1 s)
	{
		al.remove(s);
	}
	public void fillColor(String s)
	{
		for(Shape1 es:al)
			es.fillColor(s);			
	}
}
public class Composite {
	public static void main(String args[])
	{
		Shape1 square = new Square();
		Shape1 rectangle = new Rectangle();
 
		Component fillColorObj = new Component();
		fillColorObj.add(square);
		fillColorObj.add(rectangle);		
		fillColorObj.fillColor("Red");
 
		fillColorObj.remove(rectangle);
 
		fillColorObj.fillColor("Blue");
	}

}
