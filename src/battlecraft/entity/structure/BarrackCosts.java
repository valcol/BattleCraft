package battlecraft.entity.structure;

import battlecraft.enums.Ressources;

public class BarrackCosts {

	private Ressources upgradeRessource;
	private int upgradeCost;
	private Ressources addRessource;
	private int addCost;
	
	public BarrackCosts(Ressources upgradeRessource, int upgradeCost, Ressources addRessource, int addCost) {
		super();
		this.upgradeRessource = upgradeRessource;
		this.upgradeCost = upgradeCost;
		this.addRessource = addRessource;
		this.addCost = addCost;
	}

	public Ressources getUpgradeRessource() {
		return upgradeRessource;
	}

	public void setUpgradeRessource(Ressources upgradeRessource) {
		this.upgradeRessource = upgradeRessource;
	}

	public int getUpgradeCost() {
		return upgradeCost;
	}

	public void setUpgradeCost(int upgradeCost) {
		this.upgradeCost = upgradeCost;
	}

	public Ressources getAddRessource() {
		return addRessource;
	}

	public void setAddRessource(Ressources addRessource) {
		this.addRessource = addRessource;
	}

	public int getAddCost() {
		return addCost;
	}

	public void setAddCost(int addCost) {
		this.addCost = addCost;
	}
	
	
	
	
}
