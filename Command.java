package Behavioral_Design_Patterns;
import java.util.*;
interface ICommand
{
	public void execute();
}
class OnCommand implements ICommand 
{
	private HomeElectronics homeElectronics;
	public OnCommand (HomeElectronics homeElc)
	{
		this.homeElectronics = homeElc;
	}
	public void execute() 
	{
		homeElectronics.on();
	}
}
class OffCommand implements ICommand 
{	 
	List<HomeElectronics> homeElecList;
	public OffCommand (List<HomeElectronics> homeElcList)
	{
		this.homeElecList = homeElcList;
	}
	public void execute()
	{
		for (HomeElectronics homeElec : homeElecList) 
		{
			homeElec.off();
		}
	}
}
interface HomeElectronics
{
	public void on();
	public void off();
}
class LightSystemReceiver implements HomeElectronics 
{
	public void on() 
	{
		System.out.println("Light System is on!");
	}
	public void off() 
	{
		System.out.println("Light System is off!"); 
	}
}
class AirconditionReceiver implements HomeElectronics
{
	public void on() 
	{
		System.out.println("Aircondition is on!");
	}
	public void off() 
	{
		System.out.println("Aircondition is off!");
	}
}
class UniversalRemote 
{
	public static HomeElectronics getActiveDeviceL() 
	{
// here we will have a complex electronic circuit that will maintain current device
		LightSystemReceiver ls = new LightSystemReceiver();
		return ls;
	}
	public static HomeElectronics getActiveDeviceA()
	{
		AirconditionReceiver ac=new AirconditionReceiver();
		return ac;
	}
}
class ButtonInvoker
{
	ICommand c;
	public ButtonInvoker(ICommand c)
	{
		this.c = c;
	}
	public void click()
	{
		c.execute();
	}
}
public class Command {
	public static void main(String[] args) 
	{
		// OnCommand is instantiated based on active device supplied by Remote
		HomeElectronics ce = UniversalRemote.getActiveDeviceL();
		OnCommand onCommand = new OnCommand(ce);
		HomeElectronics ca = UniversalRemote.getActiveDeviceA();
		OnCommand onCommand1 = new OnCommand(ca);
		ButtonInvoker onButton = new ButtonInvoker(onCommand);
		onButton.click();
		ButtonInvoker onButton1 = new ButtonInvoker(onCommand1);
		onButton1.click();
		 
		LightSystemReceiver ls = new LightSystemReceiver();
		AirconditionReceiver ac = new AirconditionReceiver();
		List<HomeElectronics> all = new ArrayList<HomeElectronics>();
		all.add(ls);
		all.add(ac);
		OffCommand offAll = new OffCommand(all);
		ButtonInvoker offAllButton = new ButtonInvoker(offAll);
		offAllButton.click();
		}
}
