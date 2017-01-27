package battlecraft;

import battlecraft.enums.Ressources;
import gameframework.core.ObservableValue;

public class Player {
	
	protected ObservableValue<Integer> wood;
	protected ObservableValue<Integer> ore;
	protected ObservableValue<Integer> rock;

	public Player()
	{}

	public ObservableValue<Integer> getWood() {
		return wood;
	}

	public void setWood(ObservableValue<Integer> wood) {
		this.wood = wood;
	}

	public ObservableValue<Integer> getOre() {
		return ore;
	}

	public void setOre(ObservableValue<Integer> ore) {
		this.ore = ore;
	}

	public ObservableValue<Integer> getRock() {
		return rock;
	}

	public void setRock(ObservableValue<Integer> rock) {
		this.rock = rock;
	}
    
	public ObservableValue<Integer> getQuantityFromRessource(Ressources r){
		if (r == Ressources.ORE)
			return ore;
		else if (r == Ressources.ROCK)
			return rock;
		else 
			return wood;
	}

	public void removeFromRessources(Ressources r, int cost) {
		if (r == Ressources.ORE)
			ore.setValue(ore.getValue()-cost);
		else if (r == Ressources.ROCK)
			rock.setValue(rock.getValue()-cost);
		else 
			wood.setValue(wood.getValue()-cost);
	}
	
	public void addToRessources(Ressources r, int cost) {
		removeFromRessources(r, -cost);
	}
}