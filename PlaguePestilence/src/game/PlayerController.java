package game;

import java.util.Scanner;
import java.util.Vector;

import card.*;

public class PlayerController {

	private Vector<Player> players;
	private Player currPlayer;
	private CardController cardCtrl;
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
	

	public int numInPlay(){
		int num = 0;
		for(int i=0; i<players.size(); i++){
			if(players.get(i).inPlay()){
				num++;
			}
		}
		return num;
	}
	
	private Player getWinner(){
		int i=0;
		while(i<players.size()){
			if(players.get(i).inPlay()){
				return players.get(i);
			}
			i++;
		}
		return null;
	}

	public void takeTurn(Scanner in) {
		while(numInPlay() > 1){
			System.out.println(currPlayer.getName());
			currPlayer.rollPP(plague);
			if(currPlayer.inPlay()){
				//only pick card to play if not deathship
				if(!pickedUpDeath(in)){
					Card c = currPlayer.pickCard(in);
					System.out.println("Play or Discard "+c.getName()+"? P/D");
					//String r = in.next();
					String r = "P";
					if("P".equalsIgnoreCase(r)){
						//removes from players hand. And play the card.
						currPlayer.play(c);
						c.play(players, currPlayer, in);
						
					}else{
						System.out.println("Discarding "+ c.getName());
					}
					cardCtrl.discard(c);
				}
				//we don't update player because we've already updated player in Death.
				printPlayers();
				System.out.println(Global.DELIM);
			}else{
				System.out.println("I'm dead");
			}
			currPlayer = getNextPlayer();
		}
		System.out.println(getWinner().getName()+" is the winner!");
	}


	//pick up cards. Returns whether deathship was picked up.
	private boolean pickedUpDeath(Scanner in){
		int numCIH = currPlayer.getHand().size();
		do{
			Card c = cardCtrl.dealCard();
			//play deathship right away.
			if(c instanceof DeathShip){
				//Player next = getNextPlayer();
				//currPlayer = next;
				c.play(players, currPlayer, in);
				currPlayer = getNextPlayer();
				plague = true;
				return true;
				
			}else{
				if(!currPlayer.pickUpCard(c)){
					System.out.println("Oh Oh, didn't add card into hand");
				}
			}
			numCIH++;
		}while(numCIH < 6);
		return false;
	}
	
	//pre-cond: there are more than 1 player in play.
	private Player getNextPlayer(){
		int currInd = players.indexOf(this.currPlayer);
		int nextInd = currInd;
		int endInd = players.size()-1;
		Player next;
		//iterate through 
		do{	
			nextInd++;
			if(nextInd > endInd){
			nextInd = 0;
			}
			next = players.get(nextInd);
		}while(!next.inPlay());
		return next;
	}
	
	
}
