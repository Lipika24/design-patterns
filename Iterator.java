package Behavioral_Design_Patterns;
interface Iterator1
{
	   public boolean hasNext();
	   public Object next();
}
interface Container 
{
	   public Iterator1 getIterator();
}
class NameRepository implements Container 
{
	   public String names[] = {"Robert", "John","James","Lisa"};
	   public Iterator1 getIterator() 
	   {
	      return new NameIterator();
	   }
	   private class NameIterator implements Iterator1
	   {
	      int index;
	      public boolean hasNext() 
	      {
	         if(index < names.length)
	         {
	            return true;
	         }
	         return false;
	      }
	      public Object next() 
	      {     
	         if(this.hasNext())
	         {
	            return names[index++];
	         }
	         return null;
	      }		
	   }
	}
public class Iterator {
	public static void main(String[] args) 
	{
	      NameRepository namesRepository = new NameRepository();
	      for(Iterator1 i = namesRepository.getIterator();i.hasNext();)
	      {
	         String name = (String)i.next();
	         System.out.println("Name : " + name);
	      } 	
	   }
}
