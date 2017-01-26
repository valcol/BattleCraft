package battlecraft.entity.structure;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.Teams;
import gameframework.core.GameEntity;

public class StructureFactory implements IStructureFactory {
	
	private Teams team;

	public StructureFactory(Teams team) {
		super();
		this.team = team;
	}

	@Override
	public GameEntity createHouseSoldier(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(0, 0, 100, 70);
		String imagePath = "images/Medieval/Structure/19.png";
		return new BarrackSoldier(defaultCanvas, position, imagePath, boundingBox, team);
	}

	@Override
	public GameEntity createCastleTop(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(0, 0, 0, 0);
		String imagePath = "images/Medieval/Structure/2.png";
		return new MoveBlockerStructure(defaultCanvas, position, imagePath, boundingBox);
	}

	@Override
	public GameEntity createCastleBottom(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(0, -50, 100, 30);
		String imagePath = "images/Medieval/Structure/6.png";
		return new Castle(defaultCanvas, position, imagePath, boundingBox, team);
	}

	@Override
	public GameEntity createHouseWorker(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		Rectangle boundingBox = new Rectangle(0, 0, 100, 70);
		String imagePath = "images/Medieval/Structure/21.png";
		return new BarrackRockWorker(defaultCanvas, position, imagePath, boundingBox, team);
	}

}
