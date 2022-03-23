package Structural_Design_Patterns;
import java.util.*;
interface Pen 
{ 
  public void setColor(String color);
  public void draw(String content); 
}
class ThickPen implements Pen 
{
	   
	  final String brushSize = "THICK";  //intrinsic state - shareable
	  private String color = null;          //extrinsic state - supplied by client
	   
	  public void setColor(String color) 
	  {
	    this.color = color;
	  }
	  public void draw(String content) 
	  {
	    System.out.println("Drawing THICK content in color : " + color);
	  }
	}
class ThinPen implements Pen 
{
	   
	  final String brushSize = "THIN";
	  private String color = null; 
	   
	  public void setColor(String color) 
	  {
	    this.color = color;
	  }
	  public void draw(String content)
	  {
	    System.out.println("Drawing THIN content in color : " + color);
	  }
	}
class PenFactory 
{
  private static final HashMap<String, Pen> pensMap = new HashMap<>();
 
  public static Pen getThickPen(String color) 
  {
    String key = color + "-THICK";
     
    Pen pen = pensMap.get(key);
     
    if(pen != null) 
    {
      return pen;
    } 
    else
    {
      pen = new ThickPen();
      pen.setColor(color);
      pensMap.put(key, pen);
    }
     
    return pen;
  }
   
  public static Pen getThinPen(String color) 
  {
    String key = color + "-THIN";
     
    Pen pen = pensMap.get(key);
     
    if(pen != null) 
    {
      return pen;
    } else
    {
      pen = new ThinPen();
      pen.setColor(color);
      pensMap.put(key, pen);
    }
     
    return pen;
  }
}  
public class Flyweight {
	public static void main(String[] args) 
	  {
	    Pen BlueThinPen1 = PenFactory.getThinPen("BLUE");  //created new pen
	    BlueThinPen1.draw("Hello World !!");
	     
	    Pen RedThickPen = PenFactory.getThickPen("RED");  //created new pen
	    RedThickPen.draw("Hello World !!");
	     
	    Pen blackThinPen2 = PenFactory.getThinPen("Black");   //pen is shared
	    blackThinPen2.draw("Hello World !!");
	     
	    System.out.println(BlueThinPen1.hashCode());
	    System.out.println(blackThinPen2.hashCode());
	     
	    System.out.println(RedThickPen.hashCode());
	  }
}
