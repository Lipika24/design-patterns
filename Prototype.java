package Creational_Design_Patterns;
import java.util.Scanner;
interface Proto
{
	public Proto getClone();
}
class Student implements Proto
{
	private String sname;
	private int sid;
	private int age;
	public Student(String name,int id,int a)
	{
		sname=name;
		sid=id;
		age=a;
	}
	public void display()
	{
		System.out.println(sid+"\t"+sname+"\t"+age+"\t");
	}
	public Proto getClone()
	{
		return new Student(sname,sid,age);  
	}
}
public class Prototype {
public static void main(String args[])
{
	Scanner s=new Scanner(System.in);
	System.out.println("Enter Student name");
	String name=s.next();
	System.out.println("Enter Student id");
	int id=s.nextInt();
	System.out.println("Enter Student age");
	int age=s.nextInt();
	Student st=new Student(name,id,age);
	st.display();
	Student stu=(Student)st.getClone();
	stu.display();
	
}
}
