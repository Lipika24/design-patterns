package Behavioral_Design_Patterns;
//dispensing the currency in an ATM in 500rs,200rs,100rs notes
import java.util.*;
interface ATM
{
	void setNextChain(ATM nextChain);
	void dispense(Currency cur);
}
class Currency
{
	private int amount;
	public Currency(int amt)
	{
		this.amount=amt;
	}
	
	public int getAmount()
	{
		return this.amount;
	}
}
class Dispenser500rs implements ATM 
{
	private ATM chain;
	public void setNextChain(ATM nextChain)
	{
		this.chain=nextChain;
	}
	public void dispense(Currency cur) 
	{
		if(cur.getAmount() >= 500)
		{
			int num = cur.getAmount()/500;
			int remainder = cur.getAmount() % 500;
			System.out.println("Dispensing "+num+" 500rs note");
			if(remainder !=0) 
				this.chain.dispense(new Currency(remainder));
		}
		else
		{
			this.chain.dispense(cur);
		}
	}
}
class Dispenser200rs implements ATM 
{
	private ATM chain;
	public void setNextChain(ATM nextChain)
	{
		this.chain=nextChain;
	}
	public void dispense(Currency cur) 
	{
		if(cur.getAmount() >= 200)
		{
			int num = cur.getAmount()/200;
			int remainder = cur.getAmount() % 200;
			System.out.println("Dispensing "+num+" 200rs note");
			if(remainder !=0) 
				this.chain.dispense(new Currency(remainder));
		}
		else
		{
			this.chain.dispense(cur);
		}
	}
}
class Dispenser100rs implements ATM 
{
	private ATM chain;
	public void setNextChain(ATM nextChain)
	{
		this.chain=nextChain;
	}
	public void dispense(Currency cur) 
	{
		if(cur.getAmount() >= 100)
		{
			int num = cur.getAmount()/100;
			int remainder = cur.getAmount() % 100;
			System.out.println("Dispensing "+num+" 100rs note");
			if(remainder !=0) 
				this.chain.dispense(new Currency(remainder));
		}
		else
		{
			this.chain.dispense(cur);
		}
	}
}
public class CoR {
		private ATM c1;

		public CoR() {
			// initialize the chain
			this.c1 = new Dispenser500rs();
			ATM c2 = new Dispenser200rs();
			ATM c3 = new Dispenser100rs();

			// set the chain of responsibility
			c1.setNextChain(c2);
			c2.setNextChain(c3);
		}
		public static void main(String args[])
		{
			CoR atmDispenser = new CoR();
			while (true) 
			{
				int amount = 0;
				System.out.println("Enter amount to dispense");
				Scanner s = new Scanner(System.in);
				amount = s.nextInt();
				if (amount % 10 != 0) {
					System.out.println("Amount should be in multiple of 10s.");
					return;
				}
				// process the request
				//atmdispenser for invoking main class constructor
				//c1 for invoking 500rs chain class
				atmDispenser.c1.dispense(new Currency(amount));
				
			}

		}


}
