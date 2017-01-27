package battlecraft.entity.environment;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.enums.Ressources;
import gameframework.core.GameEntity;

public class EnvironmentFactory implements IEnvironmentFactory {

	
	@Override
	public GameEntity createNormalPineTree(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(32,32,45,45);
		String imagePathFull = "images/Medieval/Environment/3.png";
		String imagePathEmpty = "images/Medieval/Environment/4.png";
		return new Environment(defaultCanvas, position, imagePathFull, imagePathEmpty, boundingBox, Ressources.WOOD);
	}

	@Override
	public GameEntity createNormalTree(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(32,32,45,45);
		String imagePathFull = "images/Medieval/Environment/1.png";
		String imagePathEmpty = "images/Medieval/Environment/4.png";
		return new Environment(defaultCanvas, position, imagePathFull, imagePathEmpty, boundingBox, Ressources.WOOD);
	}

	@Override
	public GameEntity createSmallTree(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(32,32,45,45);
		String imagePathFull = "images/Medieval/Environment/21.png";
		String imagePathEmpty = "images/Medieval/Environment/4.png";
		return new Environment(defaultCanvas, position, imagePathFull, imagePathEmpty, boundingBox, Ressources.WOOD);
	}

	@Override
	public GameEntity createSmallPineTree(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(32,32,45,45);
		String imagePathFull = "images/Medieval/Environment/2.png";
		String imagePathEmpty = "images/Medieval/Environment/4.png";
		return new Environment(defaultCanvas, position, imagePathFull, imagePathEmpty, boundingBox, Ressources.WOOD);
	}

	@Override
	public GameEntity createGreyRock(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(32,32,45,45);
		String imagePathFull = "images/Medieval/Environment/7.png";
		String imagePathEmpty = "images/Medieval/Environment/6.png";
		return new Environment(defaultCanvas, position, imagePathFull, imagePathEmpty, boundingBox, Ressources.ROCK);
	}
	
	@Override
	public GameEntity createYellowRock(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(32,32,45,45);
		String imagePathFull = "images/Medieval/Environment/14.png";
		String imagePathEmpty = "images/Medieval/Environment/13.png";
		return new Environment(defaultCanvas, position, imagePathFull, imagePathEmpty, boundingBox, Ressources.ROCK);
	}

	@Override
	public GameEntity createGoldOre(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(32,32,45,45);
		String imagePathFull = "images/Medieval/Environment/18.png";
		String imagePathEmpty = "images/Medieval/Environment/16.png";
		return new Environment(defaultCanvas, position, imagePathFull, imagePathEmpty, boundingBox, Ressources.ORE);
	}
	
	@Override
	public GameEntity createCopperOre(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(32,32,45,45);
		String imagePathFull = "images/Medieval/Environment/10.png";
		String imagePathEmpty = "images/Medieval/Environment/9.png";
		return new Environment(defaultCanvas, position, imagePathFull, imagePathEmpty, boundingBox, Ressources.ORE);
	}

}
