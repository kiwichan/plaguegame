package card;

import game.Player;

public class AddPPCard extends Card {
	public AddPPCard(CardName name){
		super(name, "+10pp", CardType.SUN);
		if(name == CardName.BUMPER){
			super.updateAction("+5pp");
		}
		
	}
	@Override
	public boolean play(Player p) {
		// TODO Auto-generated method stub
	
		return false;
	}

}
