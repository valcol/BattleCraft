package battlecraft.entity.unit;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.Ressources;
import battlecraft.Teams;
import gameframework.core.GameEntity;

public class UnitFactory implements IUnitFactory {

	private Teams team;
	Rectangle boundingBox = new Rectangle(32, 32, 30, 30);

	public UnitFactory(Teams team) {
		super();
		this.team = team;
	}

	@Override
	public GameEntity createSoldier(Canvas defaultCanvas, Point position) {
		String imagePathMiddleAge = "images/Medieval/Unit/" + team.toString() + "/4.png";
		String imagePathScifi = "images/Scifi/Unit/" + team.toString() + "/4.png";
		return new Soldier(defaultCanvas, imagePathMiddleAge, imagePathScifi, boundingBox, team, position);
	}

	@Override
	public GameEntity createRockWorker(Canvas defaultCanvas, Point position) {
		String imagePathMiddleAge = "images/Medieval/Unit/" + team.toString() + "/1.png";
		String imagePathScifi = "images/Scifi/Unit/" + team.toString() + "/1.png";
		return new Worker(defaultCanvas, imagePathMiddleAge, imagePathScifi, boundingBox, Ressources.ROCK, position);
	}

	@Override
	public GameEntity createWoodWorker(Canvas defaultCanvas, Point position) {
		String imagePathMiddleAge = "images/Medieval/Unit/" + team.toString() + "/1.png";
		String imagePathScifi = "images/Scifi/Unit/" + team.toString() + "/1.png";
		return new Worker(defaultCanvas, imagePathMiddleAge, imagePathScifi, boundingBox, Ressources.WOOD, position);
	}

	@Override
	public GameEntity createOreWorker(Canvas defaultCanvas, Point position) {
		String imagePathMiddleAge = "images/Medieval/Unit/" + team.toString() + "/1.png";
		String imagePathScifi = "images/Scifi/Unit/" + team.toString() + "/1.png";
		return new Worker(defaultCanvas, imagePathMiddleAge, imagePathScifi, boundingBox, Ressources.ORE, position);
	}

}
