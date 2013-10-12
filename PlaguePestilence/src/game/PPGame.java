package game;

import java.util.Scanner;

public class PPGame {
	
	public static void main(String[] args) {
		System.out.println("Welcome to Plague and Pestilence");
		//for now we'll assume 3 players for ease
		PlayerController playCtrl = new PlayerController(3);
		playCtrl.printPlayers();
		Scanner in = new Scanner(System.in);
		//boolean exit = false;
		/**while(!exit){
			System.out.print("Play - 1, Exit - 2 >");
			int rs = in.nextInt();
			if(rs == 2){
				System.out.println("Good Bye!");
				exit = true;
			}else if( rs == 1){
				System.out.println("Starting Play...");
				playCtrl.takeTurn(in);
				exit=true;
			}else{
				System.out.println("Not a valid option try one of the following options");
			}
			
		}*/
		playCtrl.takeTurn(in);
		//playCtrl.printPlayers();
		in.close();
		
		
	}
	
	

}
