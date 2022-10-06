import java.util.*;
public class Gamemanual {
	static void refermanual()
	{
		RPSGame obj = new RPSGame();
		Scanner sc = new Scanner(System.in);
		String playthegame = "";
		
		System.out.println();
		System.out.println("Hello!");
		System.out.println("The rules of this game are simple");
		System.out.println("The computer and you will make a choice in your respective turns");
		System.out.println();
		
		System.out.println("rock vs rock score:0");
		System.out.println("paper vs paper score=0");
		System.out.println("scissors vs scissors score=0");
		System.out.println();
		
		System.out.println("rock vs paper score:1 to the one who chose 'paper'");
		System.out.println("rock vs scissors score:1 to the one who chose 'rock'");
		System.out.println("scissors vs rock score:1 to the one who chose 'rock'");
		System.out.println("scissors vs paper score:1 to the one who chose 'scissors'");
		System.out.println();
		
		System.out.println("Enter 'YES' to start the game else enter 'NO'");
		playthegame=sc.nextLine();
	//	System.out.println(playthegame);
	   if(playthegame.equals("YES"))
		   obj.startthegame();
	   else
		  System.exit(0);
	}

}
