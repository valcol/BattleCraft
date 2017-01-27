package battlecraft.entity;

import java.awt.Canvas;
import java.awt.Point;

import battlecraft.entity.environment.EnvironmentFactory;
import battlecraft.entity.environment.IEnvironmentFactory;
import battlecraft.entity.structure.IStructureFactory;
import battlecraft.entity.structure.StructureFactory;
import battlecraft.entity.tile.ITileFactory;
import battlecraft.entity.tile.TileFactory;
import battlecraft.entity.unit.IUnitFactory;
import battlecraft.entity.unit.MiddleAgeUnitFactory;
import battlecraft.enums.Teams;
import gameframework.core.GameEntity;

public class EntityFactory implements ITileFactory, IStructureFactory, IUnitFactory, IEnvironmentFactory {

	TileFactory tfactory;
	StructureFactory sfactory;
	MiddleAgeUnitFactory ufactory;
	EnvironmentFactory efactory;

	public EntityFactory(Teams team) {
		super();
		tfactory = new TileFactory();
		sfactory = new StructureFactory(team);
		ufactory = new MiddleAgeUnitFactory(team);
		efactory = new EnvironmentFactory();
	}

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
	public GameEntity createSoldier(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return ufactory.createSoldier(defaultCanvas, position);
	}

	@Override
	public GameEntity createWoodWorker(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return ufactory.createWoodWorker(defaultCanvas, position);
	}

	@Override
	public GameEntity createOreWorker(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return ufactory.createOreWorker(defaultCanvas, position);
	}

	@Override
	public GameEntity createRockWorker(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return ufactory.createRockWorker(defaultCanvas, position);
	}

	@Override
	public GameEntity createHouseSoldier(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return sfactory.createHouseSoldier(defaultCanvas, position);
	}

	@Override
	public GameEntity createBarrackWoodWorker(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return sfactory.createBarrackWoodWorker(defaultCanvas, position);
	}

	@Override
	public GameEntity createBarrackRockWorker(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return sfactory.createBarrackRockWorker(defaultCanvas, position);
	}
	
	@Override
	public GameEntity createBarrackOreWorker(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return sfactory.createBarrackOreWorker(defaultCanvas, position);
	}

	@Override
	public GameEntity createCastle(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return sfactory.createCastle(defaultCanvas, position);
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
	public GameEntity createYellowRock(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return efactory.createYellowRock(defaultCanvas, position);
	}

	@Override
	public GameEntity createGreyRock(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return efactory.createGreyRock(defaultCanvas, position);
	}

	@Override
	public GameEntity createCopperOre(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return efactory.createCopperOre(defaultCanvas, position);
	}

	@Override
	public GameEntity createGoldOre(Canvas defaultCanvas, Point position) {
		// TODO Auto-generated method stub
		return efactory.createGoldOre(defaultCanvas, position);
	}

}
