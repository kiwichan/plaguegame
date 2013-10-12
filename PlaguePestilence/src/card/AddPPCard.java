package card;

import game.Player;

import java.util.Scanner;
import java.util.Vector;

public class AddPPCard extends Card {
	public AddPPCard(CardName name){
		super(name, "+10pp", CardType.SUN);
		if(name == CardName.BUMPER){
			super.updateAction("+5pp");
		}
		
	}

	@Override
	public boolean play(Vector<Player> players, Player currPlayer, Scanner in) {
		// TODO Auto-generated method stub
		if(super.name == CardName.BUMPER){
			currPlayer.addPop(5);
		}else{
			currPlayer.addPop(10);
		}
		return true;
	}

}
