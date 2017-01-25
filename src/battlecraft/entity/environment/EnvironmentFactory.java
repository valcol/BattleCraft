package battlecraft.entity.environment;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.Ressources;
import gameframework.core.GameEntity;

public class EnvironmentFactory implements IEnvironmentFactory {

	
	@Override
	public GameEntity createNormalPineTree(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(32,32,45,45);
		String imagePathFull = "images/Medieval/Environment/3.png";
		String imagePathEmpty = "images/Medieval/Environment/2.png";
		return new Environment(defaultCanvas, position, imagePathFull, imagePathEmpty, boundingBox, Ressources.WOOD);
	}

	@Override
	public GameEntity createNormalTree(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(32,32,45,45);
		String imagePathFull = "images/Medieval/Environment/3.png";
		String imagePathEmpty = "images/Medieval/Environment/2.png";
		return new Environment(defaultCanvas, position, imagePathFull, imagePathEmpty, boundingBox, Ressources.WOOD);
	}

	@Override
	public GameEntity createSmallTree(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(32,32,45,45);
		String imagePathFull = "images/Medieval/Environment/3.png";
		String imagePathEmpty = "images/Medieval/Environment/2.png";
		return new Environment(defaultCanvas, position, imagePathFull, imagePathEmpty, boundingBox, Ressources.WOOD);
	}

	@Override
	public GameEntity createSmallPineTree(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(32,32,45,45);
		String imagePathFull = "images/Medieval/Environment/3.png";
		String imagePathEmpty = "images/Medieval/Environment/2.png";
		return new Environment(defaultCanvas, position, imagePathFull, imagePathEmpty, boundingBox, Ressources.WOOD);
	}

	@Override
	public GameEntity createSmallRock(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(32,32,45,45);
		String imagePathFull = "images/Medieval/Environment/3.png";
		String imagePathEmpty = "images/Medieval/Environment/2.png";
		return new Environment(defaultCanvas, position, imagePathFull, imagePathEmpty, boundingBox, Ressources.WOOD);
	}

	@Override
	public GameEntity createNormalRock(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(32,32,45,45);
		String imagePathFull = "images/Medieval/Environment/3.png";
		String imagePathEmpty = "images/Medieval/Environment/2.png";
		return new Environment(defaultCanvas, position, imagePathFull, imagePathEmpty, boundingBox, Ressources.WOOD);
	}

	@Override
	public GameEntity createBigRock(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(32,32,45,45);
		String imagePathFull = "images/Medieval/Environment/3.png";
		String imagePathEmpty = "images/Medieval/Environment/2.png";
		return new Environment(defaultCanvas, position, imagePathFull, imagePathEmpty, boundingBox, Ressources.WOOD);
	}

	@Override
	public GameEntity createSmallMineral(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(32,32,45,45);
		String imagePathFull = "images/Medieval/Environment/3.png";
		String imagePathEmpty = "images/Medieval/Environment/2.png";
		return new Environment(defaultCanvas, position, imagePathFull, imagePathEmpty, boundingBox, Ressources.WOOD);
	}

	@Override
	public GameEntity createNormalMineral(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(32,32,45,45);
		String imagePathFull = "images/Medieval/Environment/3.png";
		String imagePathEmpty = "images/Medieval/Environment/2.png";
		return new Environment(defaultCanvas, position, imagePathFull, imagePathEmpty, boundingBox, Ressources.WOOD);
	}

	@Override
	public GameEntity createBigMineral(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(32,32,45,45);
		String imagePathFull = "images/Medieval/Environment/3.png";
		String imagePathEmpty = "images/Medieval/Environment/2.png";
		return new Environment(defaultCanvas, position, imagePathFull, imagePathEmpty, boundingBox, Ressources.WOOD);
	}

}
