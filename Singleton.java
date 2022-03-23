//Singleton
package Creational_Design_Patterns;
class Animal
{
	private static Animal inst;
	private Animal() 
	{
		System.out.println("In animal class private constructor");
	}//constructor
   public static Animal getInstance()
   {//static method
	   if(inst==null)
	   {
		   synchronized (Animal.class) //double check locking
	        {
	            inst = new Animal();
	            System.out.println("Object created");
	        }
	   }
	        return inst;
    }
}
public class Singleton {
	public static void main(String args[])
	{
		Thread t1=new Thread(new Runnable() {
				public void run()
				{
					Animal a=Animal.getInstance();
				}
				});
		t1.start();
		//Animal a =Animal.getInstance();
		//Animal a1=Animal.getInstance();
		//System.out.println(a);
		//System.out.println(a1);
	}
}


