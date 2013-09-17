package game;

import java.util.Scanner;

public class PPGame {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Plague and Pestilence");
		//for now we'll assume 3 players for ease
		PlayerController playCtrl = new PlayerController(3);
		CardController cardCtrl = playCtrl.getCardCtrl();
		playCtrl.printPlayers();
		Scanner in = new Scanner(System.in);
		boolean exit = false;
		Player cp = playCtrl.getCurrPlayer();
		while(!exit){
			System.out.print("Play - 1, Exit - 2 >");
			int rs = in.nextInt();
			if(rs == 2){
				System.out.println("Good Bye!");
				exit = true;
			}else if( rs == 1){
				System.out.println("Starting Play...");
				boolean winnerFound = false;
				while(!winnerFound){
					playCtrl.takeTurn(in);
					//winnerFound = playCtrl.winnerFound();
					winnerFound = true;
				}
				exit=true;
			}else{
				System.out.println("Not a valid option try one of the following options");
			}
			
		}
		playCtrl.printPlayers();
		in.close();
		
		
	}
	
	

}
