package battlecraft;

import battlecraft.enums.Ressources;
import gameframework.core.ObservableValue;

public class IA {
	
	//TODO: ajouter les barraks de l'ia dans liste et dès qu'il y a ajout de ressources, generer des soldats/workers}
	
	protected int wood;
	protected int ore;
	protected int rock;

	public IA()
	{}
    
	public int getWood() {
		return wood;
	}

	public void setWood(int wood) {
		this.wood = wood;
	}

	public int getOre() {
		return ore;
	}

	public void setOre(int ore) {
		this.ore = ore;
	}


	public int getRock() {
		return rock;
	}

	public void setRock(int rock) {
		this.rock = rock;
	}

	public int getQuantityFromRessource(Ressources r){
		if (r == Ressources.ORE)
			return ore;
		else if (r == Ressources.ROCK)
			return rock;
		else 
			return wood;
	}

	public void removeFromRessources(Ressources r, int cost) {
		if (r == Ressources.ORE)
			ore-=cost;
		else if (r == Ressources.ROCK)
			rock-=cost;
		else 
			wood-=cost;
	}
}