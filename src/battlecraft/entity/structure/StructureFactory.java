package battlecraft.entity.structure;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.core.GameEntity;

public class StructureFactory implements IStructureFactory {

	@Override
	public GameEntity createHouse(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(0, 0, 100, 70);
		String imagePath = "images/Medieval/Structure/9.png";
		return new House(defaultCanvas, position, imagePath, boundingBox);
	}

	@Override
	public GameEntity createCastleTop(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(0, 50, 100, 50);
		String imagePath = "images/Medieval/Structure/2.png";
		return new MoveBlockerStructure(defaultCanvas, position, imagePath, boundingBox);
	}
	
	@Override
	public GameEntity createCastleBottom(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(0, 0, 100, 30);
		String imagePath = "images/Medieval/Structure/6.png";
		return new Castle(defaultCanvas, position, imagePath, boundingBox, 1);
	}

}
