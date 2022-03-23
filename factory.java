//Factory
package Creational_Design_Patterns;
interface Transport
{
	public void transportGoods();
}
class Train implements Transport
{
	public void transportGoods()
	{
		System.out.println("Transporting goods through train");
	}
}
class Ship implements Transport
{
	public void transportGoods()
	{
		System.out.println("Transporting goods through Ship");
	}
}
class TransportFactory {
    public Transport createTransport(String channel)
    {
        if (channel == null || channel.isEmpty())
            return null;
        if ("Train".equals(channel))
            return new Train();
        else if ("Ship".equals(channel)) 
            return new Ship();
        return null;
    }
}
public class factory {
public static void main(String args[])
{
	TransportFactory t=new TransportFactory();
	Transport obj=t.createTransport("Train");
	obj.transportGoods();
}
}
