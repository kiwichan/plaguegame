package game;

import java.util.Vector;

public class PlayerController {

	private Vector<Player> players;
	private Player currPlayer;
	
	public PlayerController(int numPlayers){
		players = new Vector<Player>(6);
		if(numPlayers < 2){
			System.out.println("Not enough players to play Plague and Pestilence. Need more than 2");
		}
		else{
			initializePlayers(numPlayers);
			currPlayer = getStartPlayer();
		}
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
			int newRoll = currP.roll(2);
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
}
