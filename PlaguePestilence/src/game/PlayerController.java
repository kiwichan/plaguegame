package game;

import java.util.Scanner;
import java.util.Vector;

import card.Card;

public class PlayerController {

	private Vector<Player> players;
	private Player currPlayer;
	private CardController cardCtrl;
	private int numInPlay;
	private boolean plague;
	
	public PlayerController(int numPlayers){
		players = new Vector<Player>(6);
		if(numPlayers < 2 ){
			System.out.println("Not enough players to play Plague and Pestilence. Need more than 2");
		}else if (numPlayers > 6){
			System.out.println("Max of 6 players. Try again");
		}
		else{
			initializePlayers(numPlayers);
			numInPlay = players.size();
			currPlayer = getStartPlayer();
			cardCtrl = new CardController();
			System.out.println("Dealing hand out");
			dealStartHand();
			System.out.println("Shuffling in Death Ship");
			cardCtrl.shuffleDS();
		}
		plague = false;
	}
	
	//pre-condition: numPlayers >=2
	private void initializePlayers(int numPlayers){
		//for now we'll assume players will be 1+etc
		System.out.println("Initializing players...");
		for(int i=0; i<numPlayers; i++){
			int ind = i+1;
			Player temp = new Player("Player"+ind);
			boolean success = players.add(temp);
			if(!success){
				System.out.println("Oh Oh, something happened adding player "+temp.getName());
			}
		}		
	}
	
	private Player getStartPlayer(){
		int maxRoll = 0;
		Player start = players.firstElement();
		for(int i = 0; i< players.size(); i++){
			Player currP = players.get(i);
			int newRoll = currP.roll()+currP.roll();
			if(newRoll > maxRoll){
				maxRoll = newRoll;
				start = currP;
			}
		}
		return start;
	}
	
	public Vector<Player> getPlayers(){
		return players;
	}
	
	public void printPlayers(){
		int numPlayers = players.size();
		System.out.println("There are "+numPlayers+" in game");
		for(int i =0; i < numPlayers; i++){
			players.get(i).printPerson();
		}
	}
	
	public Player getCurrPlayer(){
		return currPlayer;
	}
	
	public CardController getCardCtrl(){
		return cardCtrl;
	}
	
	private void dealStartHand(){
		//starting hand of 5;
		for(int i =0; i<5; i++){
			for(int j=0; j<players.size(); j++){
				Player curr = players.get(j);
				curr.pickUpCard(cardCtrl.dealCard());
			}
		}
	}
	
	public boolean winnerFound(){
		return (this.numInPlay <= 1);
	}

	public void takeTurn(Scanner in) {
		// TODO Auto-generated method stub
		roll();
		if(currPlayer.inPlay()){
			pickUp();
			
		}
	}
	
	private void pickUp(){
		int numCIH = currPlayer.getHand().size();
		while(numCIH < 6){
			Card c = cardCtrl.dealCard();
			if(!currPlayer.pickUpCard(c)){
				System.out.println("Oh Oh, didn't add card into hand");
			}
			numCIH++;
		}
	}
	
	private void roll(){
		int r = currPlayer.roll(plague);
		if(plague){
			if(r <=3){
				System.out.println("No losses, Jackpot!");
			}else if(r <=5){
				System.out.println("Lose 5PP");
				currPlayer.subPop(5);
			}else if(r <=8){
				System.out.println("Lose 10PP");
				currPlayer.subPop(10);
			}else if(r <= 11){
				System.out.println("Lose 15PP");
				currPlayer.subPop(15);
			}else{
				System.out.println("Lose 20PP, Bummer!");
				currPlayer.subPop(20);
			}
		}else{
			if(r <=3){
				System.out.println("No gain, bummer!");
			}else if(r <=5){
				System.out.println("Gain 5PP");
				currPlayer.addPop(5);
			}else if(r <=8){
				System.out.println("Gain 10PP");
				currPlayer.addPop(10);
			}else if(r <= 11){
				System.out.println("Gain 15PP");
				currPlayer.addPop(15);
			}else{
				System.out.println("Gain 20PP, Jackpot!");
				currPlayer.addPop(20);
			}
		}
	}
	
	
}
