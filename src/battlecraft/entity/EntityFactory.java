package battlecraft.entity;

import java.awt.Canvas;
import java.awt.Point;

import battlecraft.entity.environment.IEnvironmentFactory;
import battlecraft.entity.structure.IStructureFactory;
import battlecraft.entity.structure.StructureFactory;
import battlecraft.entity.tile.ITileFactory;
import battlecraft.entity.tile.TileFactory;
import battlecraft.entity.unit.IUnitFactory;
import gameframework.core.GameEntity;

public class EntityFactory implements ITileFactory, IStructureFactory {
	
	TileFactory tfactoty = new TileFactory();
	StructureFactory sfactory = new StructureFactory();

	@Override
	public GameEntity createForestTile(Canvas defaultCanvas, Point position, int number) {
		// TODO Auto-generated method stub
		return tfactoty.createForestTile(defaultCanvas, position, number);
	}

	@Override
	public GameEntity createLandTile(Canvas defaultCanvas, Point position, int number) {
		// TODO Auto-generated method stub
		return tfactoty.createLandTile(defaultCanvas, position, number);
	}

	@Override
	public GameEntity createHouse(Canvas defaultCanvas, Point position, int number) {
		// TODO Auto-generated method stub
		return sfactory.createHouse(defaultCanvas, position, number);
	}
	

}
