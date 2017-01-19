package battlecraft.entity.structure;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.core.GameEntity;

public class StructureFactory implements IStructureFactory {

	@Override
	public GameEntity createHouse(Canvas defaultCanvas, Point position, int number) {
		Rectangle boundingBox = new Rectangle(0, 0, 1, 1);
		String imagePath = "images/Medieval/Structure/"+String.valueOf(number)+".png";
		return new MoveBlockerStructure(defaultCanvas, position, imagePath, boundingBox);
	}

	@Override
	public GameEntity createCastle(Canvas defaultCanvas, Point position, int number) {
		Rectangle boundingBox = new Rectangle(0, 0, 1, 1);
		String imagePath = "images/Medieval/Structure/"+String.valueOf(number)+".png";
		return new MoveBlockerStructure(defaultCanvas, position, imagePath, boundingBox);
	}

}
