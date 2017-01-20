package battlecraft.entity.environment;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.entity.tile.Tile;
import gameframework.core.GameEntity;

public class EnvironmentFactory implements IEnvironmentFactory {

	
	@Override
	public GameEntity createNormalPineTree(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(0, 0, 0, 0);
		String imagePath = "images/Medieval/Environment/3.png";
		return new MoveBlockerEnvironment(defaultCanvas, position, imagePath, boundingBox);
	}

	@Override
	public GameEntity createNormalTree(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(0, 0, 0, 0);
		String imagePath = "images/Medieval/Environment/1.png";
		return new MoveBlockerEnvironment(defaultCanvas, position, imagePath, boundingBox);
	}

	@Override
	public GameEntity createSmallTree(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(0, 0, 0, 0);
		String imagePath = "images/Medieval/Environment/21.png";
		return new MoveBlockerEnvironment(defaultCanvas, position, imagePath, boundingBox);
	}

	@Override
	public GameEntity createSmallPineTree(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(0, 0, 0, 0);
		String imagePath = "images/Medieval/Environment/2.png";
		return new MoveBlockerEnvironment(defaultCanvas, position, imagePath, boundingBox);
	}

	@Override
	public GameEntity createSmallRock(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(0, 0, 1, 1);
		String imagePath = "images/Medieval/Environment/6.png";
		return new MoveBlockerEnvironment(defaultCanvas, position, imagePath, boundingBox);
	}

	@Override
	public GameEntity createNormalRock(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(0, 0, 1, 1);
		String imagePath = "images/Medieval/Environment/8.png";
		return new MoveBlockerEnvironment(defaultCanvas, position, imagePath, boundingBox);
	}

	@Override
	public GameEntity createBigRock(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(0, 0, 1, 1);
		String imagePath = "images/Medieval/Environment/9.png";
		return new MoveBlockerEnvironment(defaultCanvas, position, imagePath, boundingBox);
	}

	@Override
	public GameEntity createSmallMineral(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(0, 0, 1, 1);
		String imagePath = "images/Medieval/Environment/13.png";
		return new MoveBlockerEnvironment(defaultCanvas, position, imagePath, boundingBox);
	}

	@Override
	public GameEntity createNormalMineral(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(0, 0, 1, 1);
		String imagePath = "images/Medieval/Environment/18.png";
		return new MoveBlockerEnvironment(defaultCanvas, position, imagePath, boundingBox);
	}

	@Override
	public GameEntity createBigMineral(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(0, 0, 1, 1);
		String imagePath = "images/Medieval/Environment/17.png";
		return new MoveBlockerEnvironment(defaultCanvas, position, imagePath, boundingBox);
	}

}
