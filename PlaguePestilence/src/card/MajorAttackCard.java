package card;

import java.util.Scanner;
import java.util.Vector;

import game.Player;


//Famine, Flood, Drought, Crusade, Viking Raid, Pest
public class MajorAttackCard extends Card {
	
	public MajorAttackCard(CardName n){
		super();
		//super(name, "-10pp", CardType.MAJORATTACK);
		super.name = n;
		super.type = CardType.MAJORATTACK;
		if(name == CardName.PEST){
			super.action = "-5pp";
		}else{
			super.action = "-10pp";
		}
	}

	@Override
	public boolean play(Vector<Player> players, Player currPlayer, Scanner in) {
		// TODO Auto-generated method stub
		int choice;
		do {
			System.out.println("Who do you want to play it on? select #");
			for(int i = 0; i< players.size(); i++){
				Player p = players.get(i);
				if(!p.equals(currPlayer) && p.inPlay()){
					System.out.print(i+"- ");
					p.printPerson();
				}
			}
			System.out.print(">");
			choice = in.nextInt();
		}while (!(choice >= 0 && choice < players.size()));
		Player p = players.get(choice);
		switch (name){
			case DROUGHT:
				// check for Aqueduct,
				boolean hasAqu = false;
				if(hasAqu){
					//do nothing
					System.out.println("This player has aqueduct, nothing happens");
				}else{
					p.subPop(10);
				}
				break;
			case FLOOD:
				// check for Sewer
				boolean hasSewer = false;
				if(hasSewer){
					System.out.println("This player has Sewer. Nothing happens");
				}else{
					p.subPop(10);
				}
				break;
			case VIKING:
				//check for City Wall
				boolean hasWall = false;
				if(hasWall){
					System.out.println("This player has city wall. Nothing happens");					}else{
					p.subPop(10);
				}
			case PEST:
				p.subPop(5);
				break;
			default:
				p.subPop(10);
				break;
		}
		return true;
	}
	


}
