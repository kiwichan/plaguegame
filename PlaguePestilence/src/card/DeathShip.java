package card;

import game.Player;

import java.util.Scanner;
import java.util.Vector;

public class DeathShip extends Card {

	public DeathShip(){
		super(CardName.DEATHSHIP, "-10pp, Begin Plague", CardType.DEATH);
	}

	@Override
	public boolean play(Vector<Player> players, Player currPlayer, Scanner in) {
		// TODO Auto-generated method stub
		System.out.println("The DEATH SHIP HAS ARRIVED!!!");
		return false;
	}

}
