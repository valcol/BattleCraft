package battlecraft.entity.structure;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.enums.Teams;
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
		String imagePathMiddleAge = "images/Medieval/Structure/19.png";
		String imagePathSciFi = "images/Scifi/Structure/4.png";
		return new BarrackSoldier(defaultCanvas, position, imagePathMiddleAge,imagePathSciFi, boundingBox, team);
	}

	@Override
	public GameEntity createCastle(Canvas defaultCanvas, Point position) {
		Rectangle boundingBox = new Rectangle(0, -50, 80, 80);
		String imagePathTop = "images/Medieval/Structure/6.png";
		String imagePathBottom = "images/Medieval/Structure/2.png";
		return new Castle(defaultCanvas, position, imagePathBottom, imagePathTop, boundingBox, team);
	}

	@Override
	public GameEntity createBarrackWoodWorker(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		Rectangle boundingBox = new Rectangle(0, 0, 100, 70);
		String imagePathMiddleAge = "images/Medieval/Structure/21.png";
		String imagePathSciFi = "images/Scifi/Structure/8.png";
		return new BarrackWoodWorker(defaultCanvas, position, imagePathMiddleAge,imagePathSciFi, boundingBox, team);
	}
	
	@Override
	public GameEntity createBarrackRockWorker(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		Rectangle boundingBox = new Rectangle(0, 0, 100, 70);
		String imagePathMiddleAge = "images/Medieval/Structure/20.png";
		String imagePathSciFi = "images/Scifi/Structure/9.png";
		return new BarrackRockWorker(defaultCanvas, position, imagePathMiddleAge,imagePathSciFi, boundingBox, team);
	}

	@Override
	public GameEntity createBarrackOreWorker(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		Rectangle boundingBox = new Rectangle(0, 0, 100, 70);
		String imagePathMiddleAge = "images/Medieval/Structure/20.png";
		String imagePathSciFi = "images/Scifi/Structure/9.png";
		return new BarrackOreWorker(defaultCanvas, position, imagePathMiddleAge,imagePathSciFi, boundingBox, team);
	}

}
