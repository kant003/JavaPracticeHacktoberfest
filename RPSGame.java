import java.util.*;
public class RPSGame {
	
	static void startthegame()
	{
		Random rand = new Random();
		Scanner sc= new Scanner(System.in);
		
		List<String> list = new ArrayList<String>();
		list.add("Rock");
		list.add("Paper");
		list.add("Scissors");
		
		int userscore=0,botscore=0;
		String userchoice, botchoice, nextgamechoice;
		boolean play = false;
		boolean playagain=true;
		while (playagain == true) {
			play=true;
			userscore=0; botscore=0;
		while(play == true) {
			System.out.println("Enter your choice");
			userchoice = sc.nextLine();
			botchoice = list.get(rand.nextInt(list.size()));
			
	        //System.out.println("User choice: "+userchoice);
		   //System.out.println("Bot choice: "+botchoice);
			
		A:
		if(userchoice.equals("Rock") && botchoice.equals("Paper"))
			botscore+=1;
		else if(userchoice.equals("Rock") && botchoice.equals("Scissors"))
			userscore+=1;
		else if(userchoice.equals("Paper") && botchoice.equals("Rock"))
			userscore+=1;
		else if(userchoice.equals("Paper") && botchoice.equals("Scissors"))
			botscore+=1;
		else if(userchoice.equals("Scissors") && botchoice.equals("Rock"))
			botscore+=1;
		else if(userchoice.equals("Scissors") && botchoice.equals("Paper"))
			userscore+=1;
		/*else if( !userchoice.equals("Rock") && !userchoice.equals("Paper") && !userchoice.equals("Scissors") )
		{
			System.out.println("Enter your choice again");
			userchoice = sc.nextLine();
			continue A;
		}*/
		else if(userchoice.equals("Stop"))
			play = false;
		}
		System.out.println();
		System.out.println("Computer score: "+botscore);
		System.out.println("Your score: "+ userscore);
		System.out.println();
		if(botscore > userscore) {
			System.out.println("Computer has won the game");
			System.out.println("I hope you knock on wood next time!");
		}
		else if(userscore > botscore)
			System.out.println("You won! Congratulations");
		else if(userscore == botscore)
			System.out.println("Its a tie!!");
		System.out.println();
		System.out.println("If you would like to play again, enter 'YES' otherwise enter 'NO'");
		nextgamechoice = sc.nextLine();
		
		if(nextgamechoice.equals("NO"))
			playagain=false;
		
		}
		System.out.println("Thank you for playing, we hope to see you again soon");
		System.out.println("Bye!");
		System.exit(0);
		
	}
	public static void main(String args[])
	{
		Random rand = new Random();
		Scanner sc= new Scanner(System.in);
		Gamemanual obj = new Gamemanual();
		
		String usermanualchoice;
		
		System.out.println("Welcome to Rock Paper Scissors Game!");
		System.out.println("Once if you start the game you cannot stop it!");
		System.out.println("If you would like to refer user manaul enter 'YES' else 'NO'");
		System.out.println();
		usermanualchoice = sc.nextLine();
		 
		if(usermanualchoice.equals("YES"))
			obj.refermanual();
		else
			startthegame();
		
		
	}

}
