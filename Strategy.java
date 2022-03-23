package Behavioral_Design_Patterns;
interface Strategy1
{
	   public int doOperation(int num1, int num2);
}
class OperationAdd implements Strategy1
{
	   public int doOperation(int num1, int num2) 
	   {
	      return num1 + num2;
	   }
}
class OperationSub implements Strategy1
{
	   public int doOperation(int num1, int num2) 
	   {
	      return num1 - num2;
	   }
}
class OperationMul implements Strategy1
{
	   public int doOperation(int num1, int num2) 
	   {
	      return num1 * num2;
	   }
}
class Context
{
	   private Strategy1 strategy;

	   public Context(Strategy1 strategy){
	      this.strategy = strategy;
	   }

	   public int executeStrategy(int num1, int num2){
	      return strategy.doOperation(num1, num2);
	   }
}
public class Strategy {
	public static void main(String[] args) {
	      Context context = new Context(new OperationAdd());		
	      System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

	      context = new Context(new OperationSub());		
	      System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

	      context = new Context(new OperationMul());		
	      System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
	   }

}
