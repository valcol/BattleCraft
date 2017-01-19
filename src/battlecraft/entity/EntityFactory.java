package battlecraft.entity;

import java.awt.Canvas;
import java.awt.Point;

import battlecraft.entity.environment.IEnvironmentFactory;
import battlecraft.entity.structure.IStructureFactory;
import battlecraft.entity.structure.StructureFactory;
import battlecraft.entity.tile.ITileFactory;
import battlecraft.entity.tile.TileFactory;
import battlecraft.entity.unit.IUnitFactory;
import battlecraft.entity.unit.UnitFactory;
import gameframework.core.GameEntity;

public class EntityFactory implements ITileFactory, IStructureFactory, IUnitFactory {
	
	TileFactory tfactory = new TileFactory();
	StructureFactory sfactory = new StructureFactory();
	UnitFactory ufactory = new UnitFactory();



	@Override
	public GameEntity createForestTile(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return tfactory.createForestTile(defaultCanvas, position);
	}

	@Override
	public GameEntity createLandTile(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return tfactory.createLandTile(defaultCanvas, position);
	}

	@Override
	public GameEntity createSoldier(Canvas defaultCanvas) {
		// TODO Auto-generated method stub
		return ufactory.createSoldier(defaultCanvas);
	}

	@Override
	public GameEntity createHouse(Canvas defaultCanvas, Point position, int number) {
		// TODO Auto-generated method stub
		return sfactory.createHouse(defaultCanvas, position, number);
	}

	@Override
	public GameEntity createCastle(Canvas defaultCanvas, Point position, int number) {
		// TODO Auto-generated method stub
		return sfactory.createCastle(defaultCanvas, position, number);
	}
	

}
