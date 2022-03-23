package Structural_Design_Patterns;
interface Human
{
	public void speak();
	public void feel();
}
class John implements Human
{
	public void speak()
	{
		System.out.println("I'm a man");
	}
	public void feel()
	{
		System.out.println("I can feel pain and pleasure");
	}
}
class Kate implements Human
{
	public void speak()
	{
		System.out.println("I'm a woman");
	}
	public void feel()
	{
		System.out.println("I can feel pain and pleasure and peace");
	}
}
interface Barbie
{
	public void walk();
}
class PlasticBarbie implements Barbie
{
	public void walk()
	{
		System.out.println("I can walk but not feel like human");
	}
}
class ManAdapter implements Barbie
{
	Human human;
	public ManAdapter(Human human)
	{
		this.human=human;
	}
	public void walk()
	{
		human.feel();
	}
}
public class Adapter {
public static void main(String args[])
{
	Kate k=new Kate();
	Barbie b=new PlasticBarbie();
	Barbie m=new ManAdapter(k);//wrapping a woman to barbie so that barbie acts like woman
	System.out.println("Kate..");
	k.speak();
	k.feel();
	System.out.println("Barbie..");
	b.walk();
	System.out.println("Adapter..");
	m.walk();//barbie behaves like kate
	
}
}
