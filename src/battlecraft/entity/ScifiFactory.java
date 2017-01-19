package battlecraft.entity;

import java.awt.Canvas;
import java.awt.Point;
public class ScifiFactory extends AbstractAgeFactory {
	
	static String path = "images/Scifi/";

	public ScifiFactory() {
		super(path);
	}

	@Override
	public Tile createNormalPineTree(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tile createNormalTree(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tile createSmallTree(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tile createSmallPineTree(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tile createTile(Canvas defaultCanvas, Point position, int number) {
		// TODO Auto-generated method stub
		return tfactory.createTile(defaultCanvas, position, number);
	}

	
	


}
