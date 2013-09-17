package game;

import java.lang.String;

public abstract class Card {
	
	public enum Type{SUN, RAT, UNKOWN} 
	private String name;
	private String action;
	private Type type;
	
	public Card(){
		name = "";
		action = "";
		type = Type.UNKOWN;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getAction(){
		return this.action;
	}
	
	public void printDescription(){
		System.out.println(name+": "+action);
	}
	
	//override equals
	public boolean equals(Card other){
		return this.name.equals(other.getName());
	}
	public abstract boolean play();

}
