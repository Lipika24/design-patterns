package Behavioral_Design_Patterns;
abstract class Game 
{
	   abstract void initialize();
	   abstract void startPlay();
	   abstract void endPlay();
	   public final void play()
	   {
	      initialize();
	      startPlay();
	      endPlay();
	   }
}
class Cricket extends Game
{
	   void endPlay()
	   {
	      System.out.println("Cricket Game Finished!");
	   }
	   void initialize() 
	   {
	      System.out.println("Cricket Game Initialized! Start playing.");
	   }
	   void startPlay() {
	      System.out.println("Cricket Game Started. Enjoy the game!");
	   }
}
class Hockey extends Game
{
	   void endPlay()
	   {
	      System.out.println("Hockey Game Finished!");
	   }
	   void initialize() 
	   {
	      System.out.println("Hockey Game Initialized! Start playing.");
	   }
	   void startPlay() {
	      System.out.println("Hockey Game Started. Enjoy the game!");
	   }
}
public class Template {
	public static void main(String[] args)
	{
	      Game game = new Cricket();
	      game.play();
	      System.out.println();
	      game = new Hockey();
	      game.play();		
	   }
}
