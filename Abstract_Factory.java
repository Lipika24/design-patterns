//Abstract Factory
package Creational_Design_Patterns;
import java.util.*;
interface Furniture
{
	public void getFurnitureName();
}
class Chair implements Furniture
{
	public void getFurnitureName()
	{
		System.out.println("It is chair");
	}
}
class CoffeeTable implements Furniture
{
	public void getFurnitureName()
	{
		System.out.println("It is Coffee Table");
	}
}

abstract class FurnitureType
{
	abstract void getFurnitureType();
}
class Modern extends FurnitureType
{
	void getFurnitureType()
	{
		System.out.println("The furniture type is modern");
	}
}
class Victorian extends FurnitureType
{
	void getFurnitureType()
	{
		System.out.println("The furniture type is Victorian");
	}
}

abstract class AbstractFactory
{  
	  public abstract Furniture getFurnitureName(String f);  
	  public abstract FurnitureType getFurnitureType(String ft);  
} 
class FurnitureFactory extends AbstractFactory
{  
	   public Furniture getFurnitureName(String f)
	   {  
	      if(f == null)
	         return null;  
	      if(f.equalsIgnoreCase("Chair"))  
	         return new Chair(); 
	      else if(f.equalsIgnoreCase("CoffeeTable"))  
	         return new CoffeeTable();  
	      return null;  
	   }  
	  public FurnitureType getFurnitureType(String ft) {  
	      return null;  
	   }
}
class FurnitureTypeFactory extends AbstractFactory
{  
	   public FurnitureType getFurnitureType(String ft)
	   {  
	      if(ft == null)
	         return null;  
	      if(ft.equalsIgnoreCase("Modern"))  
	         return new Modern(); 
	      else if(ft.equalsIgnoreCase("Victorian"))  
	         return new Victorian();  
	      return null;  
	   }  
	  public Furniture getFurnitureName(String f) {  
	      return null;  
	   }
}

class FactoryCreator 
{  
    public static AbstractFactory getFactory(String choice)
    {  
     if(choice.equalsIgnoreCase("Furniture")) 
        return new FurnitureFactory();  
      else if(choice.equalsIgnoreCase("FurnitureType")) 
        return new FurnitureTypeFactory();      
     return null;  
  }  	
}
public class Abstract_Factory {
public static void main(String args[])
{
	Scanner s=new Scanner(System.in);
	System.out.println("Enter the name of the furniture you wanna purchase");
	String f=s.next();
	System.out.println("Enter the type of the furniture you wanna purchase");
	String ft=s.next();
	
	AbstractFactory FurnitureFactory = FactoryCreator.getFactory("Furniture");  
	Furniture fur=FurnitureFactory.getFurnitureName(f);  
	fur.getFurnitureName();
	
	AbstractFactory FurnitureTypeFactory = FactoryCreator.getFactory("FurnitureType");  
	FurnitureType furt=FurnitureTypeFactory.getFurnitureType(ft); 
	furt.getFurnitureType();
}
}
