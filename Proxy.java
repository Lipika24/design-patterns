package Structural_Design_Patterns;
interface Image 
{
	   void display();
}
class RealImage implements Image
{
		private String fileName;
	   public RealImage(String fileName)
	   {
	      this.fileName = fileName;
	      loadFromDisk(fileName);
	   }
	   public void display() 
	   {
	      System.out.println("Displaying " + fileName);
	   }

	   private void loadFromDisk(String fileName)
	   {
	      System.out.println("Loading " + fileName);
	   }
	}
class ProxyImage implements Image
{

	   private RealImage realImage;
	   private String fileName;

	   public ProxyImage(String fileName)
	   {
	      this.fileName = fileName;
	   }
	   public void display() 
	   {
	      if(realImage == null)
	      {
	         realImage = new RealImage(fileName);
	      }
	      realImage.display();
	   }
	}
public class Proxy {
	public static void main(String[] args) 
	{
	      Image image = new ProxyImage("epam.jpg");

	      //image will be loaded from disk
	      image.display(); 
	      System.out.println("");
	      
	      //image will not be loaded from disk
	      image.display(); 	
	   }
	}

