package game;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import card.Card;

public class Player {
	private String name;
	private int population;
	private Vector<Card> hand;
	private Vector<Card> improvements;

	public Player(String name){
		this.name = name;
		this.population = 50;
		this.hand = new Vector<Card>(6);
		this.improvements = new Vector<Card>(3);
	}
	
	public void printPerson(){
		int handCount = hand.size();
		int impCount = improvements.size();
		System.out.println(name+" : pp= "+population+"; inPlay? "+ this.inPlayToString()+
				"; Has "+handCount+ " cards in hand; "+impCount+" improvements out");
	}
	
	public void printHand(){
		for(int i=0; i<hand.size(); i++){
			hand.get(i).printDescription();
		}
	}
	
	private void printHandChoice(){
		for(int i=0; i<hand.size(); i++){
			System.out.print(i+ "-");
			hand.get(i).printDescription();
		}
		int ind = hand.size()-1;
		System.out.println("Which card do you want to play/discard? "+"0-"+ind+"> ");
	}
	
	public Card pickCard(Scanner in){
		int choice;
		do{	
			printHandChoice();
			choice = in.nextInt();
		}while(!(choice>=0&&choice<hand.size()));
		Card c = hand.get(choice);
		hand.remove(choice);
		return c;
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
	
	public int roll(){
		Random roll = new Random();
		int amount = roll.nextInt(6)+1;
		return amount;
	}
	
	public void rollPP(boolean plague){
		int raw = roll()+roll();
		int numImp = improvements.size();
		int total = raw;
		if(plague){
			total = raw-numImp;
		}else{
			total = raw+numImp;
		}
		System.out.println("You rolled a "+raw+" plus "+numImp+" for a total roll of "+ total);
		if(plague){
			if(total <=3){
				System.out.println("No losses, Jackpot!");
			}else if(total <=5){
				System.out.println("Lose 5PP");
				this.population = this.population-5;
			}else if(total <=8){
				System.out.println("Lose 10PP");
				this.population = this.population-10;
			}else if(total <= 11){
				System.out.println("Lose 15PP");
				this.population = this.population-15;
			}else{
				System.out.println("Lose 20PP, Bummer!");
				this.population = this.population-20;
			}
		}else{
			if(total <=3){
				System.out.println("No gain, bummer!");
			}else if(total <=5){
				System.out.println("Gain 5PP");
				this.population = this.population+5;
			}else if(total <=8){
				System.out.println("Gain 10PP");
				this.population = this.population+10;
			}else if(total <= 11){
				System.out.println("Gain 15PP");
				this.population = this.population+15;
			}else{
				System.out.println("Gain 20PP, Jackpot!");
				this.population = this.population+20;
			}
		}
	}
	
	public int addPop(int pp){
		this.population = this.population+pp;
		return this.population;
	}
	
	public int subPop(int pp){
		this.population = this.population-pp;
		return this.population;
	}
	public String inPlayToString(){
		if(population > 0){
			return "yes";
		}else{
			return "no";
		}
	}
	public boolean inPlay(){
		return population > 0;
	}
	
	public boolean play(Card c){
		return hand.remove(c);
	}

}
