package Structural_Design_Patterns;
import java.util.*;
interface Mobile
{
	public String ModelName();
	public double Price();
}
class Iphone implements Mobile
{
	public String ModelName()
	{
		return "Iphone";
	}
	public double Price()
	{
		return 120000.0;
	}
}
class Redmi implements Mobile
{
	public String ModelName()
	{
		return "Redmi";
	}
	public double Price()
	{
		return 20000.0;
	}
}
class Samsung implements Mobile
{
	public String ModelName()
	{
		return "Samsung";
	}
	public double Price()
	{
		return 40000.0;
	}
}
class ShopKeeper 
{  
    private Mobile iphone;  
    private Mobile samsung;  
    private Mobile mi;  
      
    public ShopKeeper()
    {  
        iphone= new Iphone();  
        samsung=new Samsung();  
        mi=new Redmi();  
    }  
    public void iphoneSale()
    {  
        System.out.println(iphone.ModelName());  
        System.out.println(iphone.Price());  
    }  
    public void samsungSale()
    {  
    	System.out.println(samsung.ModelName());  
        System.out.println(samsung.Price());  
    }
   public void miSale()
   {  
	   System.out.println(mi.ModelName());  
       System.out.println(mi.Price());  
    }  
}  
public class Facade {
	public static void main(String args[])
	{
		int ch;
		do
		{
			System.out.println("Mobile menu");
			System.out.println("1. Iphone\n 2. Samsung\n 3. Redmi\n 4. Exit");
			System.out.println("Enter your choice");
			Scanner s=new Scanner(System.in);
			ch=s.nextInt();
			ShopKeeper sk=new ShopKeeper();  
			switch(ch)
			{
			case 1: 
			{   
                sk.iphoneSale();  
            }  
        break;  
			case 2:  
			{  
				sk.samsungSale();        
            }  
        break;    
			case 3:  
			{  
			    sk.miSale();  
			}  
		break;     
			default:  
			{    
			    System.out.println("You purchased nothing");  
			}         
		return;  
	 }  
			      
			}while(ch!=4);  
	}

}
