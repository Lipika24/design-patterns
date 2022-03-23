package Structural_Design_Patterns;
import java.util.*;
interface Food
{
	public String FoodType();
	public double FoodPrice();
}
class VegFood implements Food
{
	public String FoodType()
	{
		return "Veg Food";
	}
	public double FoodPrice()
	{
		return 500.0;
	}
}
class FoodDecorator implements Food
{
	private Food f;  
    public FoodDecorator(Food f) 
    {  
        this.f=f;  
    }   
    public String FoodType()
    {  
        return f.FoodType();   
    }  
    public double FoodPrice()
    {  
        return f.FoodPrice();  
    }  
}  
class NonVegFood extends FoodDecorator
{
	public NonVegFood(Food f) 
	{  
        super(f);  
    }  
    public String FoodType()
    {  
        return super.FoodType() +" With Kadai Chiken and Rumali Roti";   
    }  
    public double FoodPrice()   
    {  
        return super.FoodPrice()+1500.0;  
    }  
}
class ChineseFood extends FoodDecorator
{
	public ChineseFood(Food f) 
	{  
        super(f);  
    }  
    public String FoodType()
    {  
        return super.FoodType() +" With chow mein and Manchurian";   
    }  
    public double FoodPrice()   
    {  
        return super.FoodPrice()+500.0;  
    }  
}
public class Decorator {
	public static void main(String args[])
	{
		 int ch;
		do
		{
			System.out.println("Food menu");
			System.out.println("1. Veg food\n 2. Non veg Food\n 3. Chinese Food\n 4. Exit");
			System.out.println("Enter your choice");
			Scanner s=new Scanner(System.in);
			ch=s.nextInt();
			switch(ch)
			{
			case 1:
			{
				VegFood vf=new VegFood();  
	            System.out.println(vf.FoodType());  
	            System.out.println( vf.FoodPrice());  
			}
			break;
			case 2:
			{
				Food f1=new NonVegFood((Food) new VegFood());  
                System.out.println(f1.FoodType());  
                System.out.println( f1.FoodPrice());  
			}
			break;
			case 3:
			{
				Food f1=new ChineseFood((Food) new VegFood());  
                System.out.println(f1.FoodType());  
                System.out.println( f1.FoodPrice());  
			}
			break;
			default:
				System.out.println("No other food items available");		
			}
		}while(ch!=4);
	}

}
