package battlecraft.entity;

import java.awt.Canvas;
import java.awt.Point;

import battlecraft.entity.environment.IEnvironmentFactory;
import battlecraft.entity.structure.IStructureFactory;
import battlecraft.entity.tile.ITileFactory;
import battlecraft.entity.tile.TileFactory;
import battlecraft.entity.unit.IUnitFactory;
import battlecraft.entity.unit.UnitFactory;
import gameframework.core.GameEntity;

public class EntityFactory implements ITileFactory, IUnitFactory {
	
	TileFactory tfactory = new TileFactory();
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
	

}
