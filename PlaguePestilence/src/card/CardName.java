package card;


public enum CardName {
	DEATHSHIP("DeathShip"),
	MINORWAR("Minor War"),
	MAJORWAR("Major War"),
	POPE("Pope"),
	PEST("Pestilence"),
	FAMINE("Famine"),
	FLOOD("Flood"),
	DROUGHT("Drought"),
	EARTHQUAKE("Earthquake"),
	FIRE("Fire"),
	CRUSADE("Crusade)"),
	VIKING("Viking Raid"),
	MONGRAD("Mongrail Raid"),
	TACADV("Tatical Advantage"),
	AQUDCT("Aqueduct"),
	SEWER("Sewer"),
	CITYWALL("City Wall"),
	PIEDPIPER("Pied Piper"),
	MASSMIGRATE("Mass Migration"),
	BUMPER("Bumper Harvest"),
	TCE("Trade Center Established");
	
	private String name;
	private CardType type;
	
	private CardName(String ns){
		name = ns;
	}
	
	public String toString(){
		return name;
	}
}
