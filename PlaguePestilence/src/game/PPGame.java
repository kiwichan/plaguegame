package game;

public class PPGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Plague and Pestilence");
		//for now we'll assume 3 players for ease
		PlayerController playCtrl = new PlayerController(3);
		String currPlayName = playCtrl.getCurrPlayer().getName();
		playCtrl.printPlayers();
		System.out.println(currPlayName+" is the startPlayer.");
		

	}

}
