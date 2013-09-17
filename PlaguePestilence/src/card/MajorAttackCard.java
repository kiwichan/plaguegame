package card;

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
	public boolean play(Player p) {
		// TODO Auto-generated method stub
		return false;
	}

}
