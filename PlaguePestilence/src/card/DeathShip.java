package card;

import game.Player;

public class DeathShip extends Card {

	public DeathShip(){
		super(CardName.DEATHSHIP, "-10pp, Begin Plague", CardType.DEATH);
	}
	@Override
	public boolean play(Player p) {
		// TODO Auto-generated method stub
		return false;
	}

}
