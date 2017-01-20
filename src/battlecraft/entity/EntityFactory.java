package battlecraft.entity;

import java.awt.Canvas;
import java.awt.Point;

import battlecraft.entity.environment.Environment;
import battlecraft.entity.environment.EnvironmentFactory;
import battlecraft.entity.environment.IEnvironmentFactory;
import battlecraft.entity.structure.IStructureFactory;
import battlecraft.entity.structure.StructureFactory;
import battlecraft.entity.tile.ITileFactory;
import battlecraft.entity.tile.TileFactory;
import battlecraft.entity.unit.IUnitFactory;
import battlecraft.entity.unit.UnitFactory;
import gameframework.core.GameEntity;

public class EntityFactory implements ITileFactory, IStructureFactory, IUnitFactory, IEnvironmentFactory {
	
	TileFactory tfactory = new TileFactory();
	StructureFactory sfactory = new StructureFactory();
	UnitFactory ufactory = new UnitFactory();
	EnvironmentFactory efactory = new EnvironmentFactory();



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
	public GameEntity createHouse(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return sfactory.createHouse(defaultCanvas, position);
	}

	@Override
	public GameEntity createCastleBottom(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return sfactory.createCastleBottom(defaultCanvas, position);
	}
	
	@Override
	public GameEntity createCastleTop(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return sfactory.createCastleTop(defaultCanvas, position);
	}

	@Override
	public GameEntity createNormalPineTree(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return efactory.createNormalPineTree(defaultCanvas, position);
	}

	@Override
	public GameEntity createNormalTree(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return efactory.createNormalTree(defaultCanvas, position);
	}

	@Override
	public GameEntity createSmallTree(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return efactory.createSmallTree(defaultCanvas, position);
	}

	@Override
	public GameEntity createSmallPineTree(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return efactory.createSmallPineTree(defaultCanvas, position);
	}

	@Override
	public GameEntity createSmallRock(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return efactory.createSmallRock(defaultCanvas, position);
	}

	@Override
	public GameEntity createNormalRock(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return efactory.createNormalRock(defaultCanvas, position);
	}

	@Override
	public GameEntity createBigRock(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return efactory.createBigRock(defaultCanvas, position);
	}

	@Override
	public GameEntity createSmallMineral(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return efactory.createSmallMineral(defaultCanvas, position);
	}

	@Override
	public GameEntity createNormalMineral(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return efactory.createNormalMineral(defaultCanvas, position);
	}

	@Override
	public GameEntity createBigMineral(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return efactory.createBigMineral(defaultCanvas, position);
	}
	

}
