package game;

import java.util.Random;
import java.util.Vector;

public class Player {
	private String name;
	private int population;
	private Vector<Card> hand;
	private Vector<Card> improvements;
	private boolean inPlay;

	public Player(String name){
		this.name = name;
		this.population = 50;
		this.hand = new Vector<Card>(6);
		this.improvements = new Vector<Card>(3);
		this.inPlay = true;
	}
	
	public void printPerson(){
		int handCount = hand.size();
		int impCount = improvements.size();
		System.out.println(name+" : pp= "+population+"; inPlay? "+ inPlay+
				"; Has "+handCount+ " cards in hand; "+impCount+" improvements out");
	}
	
	public Vector<Card> getHand(){
		return hand;
	}
	
	public String getName(){
		return this.name;
	}
	public boolean hasImprov(Card c){
		return improvements.contains(c);
	}
	
	public boolean pickUpCard(Card c){
		if(hand.size() < 6){
			return hand.add(c);
		}else{
			System.out.println("Already have 6 cards in hand.");
			return false;
		}
	}
	
	public int roll(int numDice){
		Random roll = new Random();
		int amount = roll.nextInt(numDice*6)+1;
		return amount;
	}
	
	public int addPop(int pp){
		this.population = this.population+pp;
		return this.population;
	}
}
