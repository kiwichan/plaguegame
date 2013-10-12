package card;

import game.Player;

import java.util.Scanner;
import java.util.Vector;

public abstract class Card {
	
	 CardName name;
	 String action;
	 CardType type;
	
	public Card(CardName n, String a, CardType t){
		this.name = n;
		this.action = a;
		this.type = t;
	}
	
	public Card(){
	}
	
	public String getName(){
		return name.toString();
	}
	
	public String getAction(){
		return this.action;
	}
	
	public void printDescription(){
		System.out.println(name+": "+action);
	}
	
	public CardType getType(){
		return this.type;
	}
	//override equals
	public boolean equals(Card other){
		return this.name.equals(other.getName());
	}
	
	protected void updateAction(String act){
		this.action = act;
	}
	//public abstract boolean play(Player p);

	public abstract boolean play(Vector<Player> players, Player currPlayer, Scanner in);

}
