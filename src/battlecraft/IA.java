package battlecraft;

import java.util.ArrayList;

import battlecraft.entity.structure.Barrack;
import battlecraft.entity.structure.BarrackOreWorker;
import battlecraft.entity.structure.BarrackRockWorker;
import battlecraft.entity.structure.BarrackWoodWorker;
import battlecraft.enums.Ressources;

public class IA {
		
	protected int wood;
	protected int ore;
	protected int rock;
	protected ArrayList<Barrack> barracks = new ArrayList<Barrack>();
	protected int numberOfWoodWorkers = 0;
	protected int numberOfRockWorkers = 0;
	protected int numberOfOreWorkers = 0;
	protected int numberOfWorkersMax = 5;

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
	
	public void addToRessources(Ressources r, int cost) {
		this.removeFromRessources(r, -cost);
		this.behavior();
	}
	
	private void behavior() {
		for (Barrack barrack: barracks){

			if (barrack instanceof BarrackWoodWorker){
				if (numberOfWoodWorkers < numberOfWorkersMax)
					if (tryToBuildAndUpdate(barrack))
						numberOfWoodWorkers++;
			}
			else if (barrack instanceof BarrackRockWorker){
				if (numberOfRockWorkers < numberOfWorkersMax)
					if (tryToBuildAndUpdate(barrack))
						numberOfRockWorkers++;
			}
			else if (barrack instanceof BarrackOreWorker){
				if (numberOfOreWorkers < numberOfWorkersMax)
					if (tryToBuildAndUpdate(barrack))
						numberOfOreWorkers++;
			}
			else
				tryToBuildAndUpdate(barrack);
		}
	}

	public void addBarrack(Barrack b){
		barracks.add(b);
	}
	
	public boolean tryToBuildAndUpdate(Barrack barrack){
		barrack.setShowUpgardeBtn(this.getQuantityFromRessource(barrack.getCost().getUpgradeRessource()) 
    			>= barrack.getCost().getUpgradeCost());
    	barrack.setShowAddBtn(this.getQuantityFromRessource(barrack.getCost().getAddRessource())
    			>= barrack.getCost().getAddCost());
    	
    	if (barrack.isShowUpgardeBtn()) {
            barrack.upgrade();
            this.removeFromRessources(barrack.getCost().getUpgradeRessource(), barrack.getCost().getUpgradeCost());
        }
    	
    	if (barrack.isShowAddBtn()) {
            barrack.createUnit();
            this.removeFromRessources(barrack.getCost().getAddRessource(), barrack.getCost().getAddCost());
            return true;
    	}
    	
    	return false;
	}
}