package game;

import java.util.Collections;
import java.util.Vector;

import card.*;

public class CardController {
	private Vector<Card> deck;
	private Vector<Card> discard;
	
	public CardController(){
		deck = new Vector<Card>(66);
		discard = new Vector<Card>(66);
		startDeck();
	}
	
	
	public void initializeDeck(){
		//Create Start Deck
		startDeck();
		Collections.shuffle(deck);
	}
	
	public Card dealCard(){
		//if deck is empty from use
		Card d;
		if(deck.isEmpty()){
			if(!discard.isEmpty()){
				deck.addAll(discard);
				discard.clear();
				Collections.shuffle(deck);
				d=deck.firstElement(); 
				deck.remove(d);
			}else{
				System.out.println("Oh Oh, no more cards available for pick up");
				d=null;
			}
		}else{
			d = deck.firstElement();
			deck.remove(d);
		}
		return d;
	}
	
	public void shuffleDS(){
		deck.add(new DeathShip());
		Collections.shuffle(deck);
	}
	private void startDeck(){
	 int j = 0;
	 while(deck.size()< 40){
		deck.add(new MajorAttackCard(CardName.FAMINE));
		deck.add(new MajorAttackCard(CardName.FLOOD));
		deck.add(new MajorAttackCard(CardName.DROUGHT));
		deck.add(new MajorAttackCard(CardName.PEST));
		
		for(int i = 0; i<2; i++){
			deck.add(new AddPPCard(CardName.TCE));
			deck.add(new AddPPCard(CardName.BUMPER));
		}
		j++;
	 }
		
		Collections.shuffle(deck);
	}
	
	public void printDeck(){
		int size = deck.size();
		Card c;
		System.out.println("There are "+size+" cards in the deck");
		for(int i=0; i<size; i++){
			c = deck.get(i);
			System.out.print(c.getName() + "; ");
		}
		System.out.println("");
		System.out.println(Global.DELIM);
	}
}
