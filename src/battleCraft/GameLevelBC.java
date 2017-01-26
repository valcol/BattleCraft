package battlecraft;

import java.awt.Canvas;
import java.awt.Point;
import java.util.ArrayList;

import battlecraft.entity.EntityFactory;
import battlecraft.entity.environment.Environment;
import battlecraft.entity.structure.House;
import battlecraft.entity.unit.Soldier;
import battlecraft.entity.unit.Worker;
import battlecraft.rule.MoveBlockers;
import battlecraft.rule.OverlapRules;
import battlecraft.soldier.builder.Builder;
import battlecraft.soldier.builder.SoldierBuilder;
import gameframework.core.CanvasDefaultImpl;
import gameframework.core.Game;
import gameframework.core.GameEntity;
import gameframework.core.GameLevelDefaultImpl;
import gameframework.core.GameMovableDriverDefaultImpl;
import gameframework.core.GameUniverseDefaultImpl;
import gameframework.core.GameUniverseViewPortDefaultImpl;
import gameframework.moves_rules.MoveBlockerChecker;
import gameframework.moves_rules.MoveBlockerCheckerDefaultImpl;
import gameframework.moves_rules.MoveStrategy;
import gameframework.moves_rules.MoveStrategyRandom;
import gameframework.moves_rules.MoveStrategyStraightLine;
import gameframework.moves_rules.OverlapProcessor;
import gameframework.moves_rules.OverlapProcessorDefaultImpl;
import pacman.rule.GhostMovableDriver;

public class GameLevelBC extends GameLevelDefaultImpl {

	Canvas canvas;
	EntityFactory efactoryBlue;
	EntityFactory efactoryRed;
	ArrayList<Environment> environmentList = new ArrayList<Environment>();

	MoveStrategySelect selectStr;
	HouseStrategySelect selectHouse;
	Builder b;
	
	private int NB_ROWS;
	private int NB_COLUMNS;
	private int SPRITE_SIZE;
	public static final int NUMBER_OF_GHOSTS = 5;

	public GameLevelBC(Game g) {
		super(g);
		SPRITE_SIZE = GameBC.SPRITE_SIZE;
		NB_COLUMNS = GameBC.NB_COLUMNS;
		NB_ROWS = GameBC.NB_ROWS;
		canvas = g.getCanvas();
	}

	@Override
	protected void init() {

		OverlapProcessor overlapProcessor = new OverlapProcessorDefaultImpl();

		MoveBlockerChecker moveBlockerChecker = new MoveBlockerCheckerDefaultImpl();
		moveBlockerChecker.setMoveBlockerRules(new MoveBlockers());

		OverlapRules overlapRules = new OverlapRules(new Point(14 * SPRITE_SIZE, 17 * SPRITE_SIZE),
				new Point(14 * SPRITE_SIZE, 15 * SPRITE_SIZE), life[0], score[0], endOfGame);
		overlapProcessor.setOverlapRules(overlapRules);

		universe = new GameUniverseDefaultImpl(moveBlockerChecker, overlapProcessor);
		selectStr = new MoveStrategySelect();
		selectHouse = new HouseStrategySelect();

		overlapRules.setUniverse(universe);
		overlapRules.setStrategy(selectStr);

		gameBoard = new GameUniverseViewPortDefaultImpl(canvas, universe);
		((CanvasDefaultImpl) canvas).setDrawingGameBoard(gameBoard);

		efactoryBlue = new EntityFactory(Teams.BLUE);
		efactoryRed = new EntityFactory(Teams.RED);

		canvas.addMouseListener(selectStr);
		canvas.addMouseMotionListener(selectStr);
		canvas.addMouseListener(selectHouse);
		canvas.addMouseMotionListener(selectHouse);
		selectStr.setCanvas(canvas);
		selectHouse.setCanvas(canvas);
		selectHouse.setUniverse(universe);
		selectHouse.setEntityFactory(efactoryBlue);
		selectHouse.setMoveBlockerChecker(moveBlockerChecker);
		selectHouse.setMoveStrategySelect(selectStr);

		placeTiles();
		placeStructures();
		placeRessources();

		// Pacman definition and inclusion in the universe
		/*
		 * Soldier myPac = (Soldier) efactory.createSoldier(canvas);
		 * GameMovableDriverDefaultImpl pacDriver = new
		 * GameMovableDriverDefaultImpl(); MoveStrategyStub stubStr = new
		 * MoveStrategyStub(myPac); pacDriver.setStrategy(stubStr);
		 * pacDriver.setmoveBlockerChecker(moveBlockerChecker);
		 * myPac.setDriver(pacDriver); selectStr.addUnit(myPac, stubStr);
		 * myPac.setPosition(new Point(14 * SPRITE_SIZE, 17 * SPRITE_SIZE));
		 * universe.addGameEntity(myPac);
		 * 
		 * Soldier myPac2 = (Soldier) efactory.createSoldier(canvas);
		 * GameMovableDriverDefaultImpl pacDriver2 = new
		 * GameMovableDriverDefaultImpl(); MoveStrategyStub stubStr2 = new
		 * MoveStrategyStub(myPac2); pacDriver2.setStrategy(stubStr2);
		 * pacDriver2.setmoveBlockerChecker(moveBlockerChecker);
		 * myPac2.setDriver(pacDriver2); selectStr.addUnit(myPac2, stubStr2);
		 * myPac2.setPosition(new Point(15 * SPRITE_SIZE, 10 * SPRITE_SIZE));
		 * universe.addGameEntity(myPac2);
		 */
		b = new SoldierBuilder(efactoryBlue, moveBlockerChecker, new GameMovableDriverDefaultImpl(), selectStr, canvas,
				new Point(14 * SPRITE_SIZE, 17 * SPRITE_SIZE));
		universe.addGameEntity(b.getResult());
		b = new SoldierBuilder(efactoryBlue, moveBlockerChecker, new GameMovableDriverDefaultImpl(), selectStr, canvas,
				new Point(15 * SPRITE_SIZE, 10 * SPRITE_SIZE));
		universe.addGameEntity(b.getResult());
		b = new SoldierBuilder(efactoryRed, moveBlockerChecker, new GameMovableDriverDefaultImpl(), selectStr, canvas,
				new Point(14 * SPRITE_SIZE, 4 * SPRITE_SIZE));
		universe.addGameEntity(b.getResult());
		//for (int t = 0; t < NUMBER_OF_GHOSTS; ++t) {
			GameMovableDriverDefaultImpl ghostDriv = new GameMovableDriverDefaultImpl();
			Soldier myPac3 = (Soldier) efactoryRed.createSoldier(canvas);
		MoveStrategyStub ranStr = new MoveStrategyStub(myPac3);
			ranStr.setDestionation(new Point(2 * SPRITE_SIZE, 10 * SPRITE_SIZE));
			//MoveStrategyRandom ranStr = new MoveStrategyRandom();
			ghostDriv.setStrategy(ranStr);
			ghostDriv.setmoveBlockerChecker(moveBlockerChecker);
			myPac3.setDriver(ghostDriv);
			myPac3.setPosition(new Point(21 * SPRITE_SIZE, 5 * SPRITE_SIZE));
			universe.addGameEntity(myPac3);
			(overlapRules).addSoldier(myPac3);
		//}
			
			GameMovableDriverDefaultImpl ghostDriv1 = new GameMovableDriverDefaultImpl();
			Worker myPac31 = (Worker) efactoryRed.createWoodWorker(canvas);
			WorkerMoveStrategy ranStr1 = new WorkerMoveStrategy(environmentList, myPac31);
			//MoveStrategyRandom ranStr = new MoveStrategyRandom();
			ghostDriv1.setStrategy(ranStr1);
			ghostDriv1.setmoveBlockerChecker(moveBlockerChecker);
			myPac31.setDriver(ghostDriv1);
			myPac31.setPosition(new Point(21 * SPRITE_SIZE, 5 * SPRITE_SIZE));
			universe.addGameEntity(myPac31);
			
			GameMovableDriverDefaultImpl ghostDriv11 = new GameMovableDriverDefaultImpl();
			Worker myPac311 = (Worker) efactoryRed.createRockWorker(canvas);
			WorkerMoveStrategy ranStr11 = new WorkerMoveStrategy(environmentList, myPac311);
			//MoveStrategyRandom ranStr = new MoveStrategyRandom();
			ghostDriv11.setStrategy(ranStr11);
			ghostDriv11.setmoveBlockerChecker(moveBlockerChecker);
			myPac311.setDriver(ghostDriv11);
			myPac311.setPosition(new Point(21 * SPRITE_SIZE, 5 * SPRITE_SIZE));
			universe.addGameEntity(myPac311);
	}

	public void placeTiles() {
		for (int i = 0; i < NB_ROWS; ++i) {
			for (int j = 0; j < NB_COLUMNS; ++j) {
				if ((j == 0) || (i == 0) || (i == NB_ROWS - 1) || (j == NB_COLUMNS - 1))
					universe.addGameEntity(
							efactoryBlue.createForestTile(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE)));
				else
					universe.addGameEntity(
							efactoryBlue.createLandTile(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE)));
			}
		}
	}

	public void placeStructures() {
		House h = null;
		for (int i = 0; i < NB_ROWS; ++i) {
			for (int j = 0; j < NB_COLUMNS; ++j) {
				// House

				if ((j == 2) && (i == 5)) {
					h = (House) efactoryBlue.createHouseSoldier(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE));
					selectHouse.addUnit(h);
					universe.addGameEntity(h);
				}
				if ((j == 7) && (i == 2)) {
					h = (House) efactoryBlue.createHouseWorker(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE));
					selectHouse.addUnit(h);
					universe.addGameEntity(h);
				}
				// Castle
				if ((j == 4) && (i == 10))
					universe.addGameEntity(
							efactoryBlue.createCastleBottom(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE)));
				if ((j == 4) && (i == 9))
					universe.addGameEntity(
							efactoryBlue.createCastleTop(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE)));
				
				if ((j == 35) && (i == 10))
					universe.addGameEntity(
							efactoryRed.createCastleBottom(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE)));
				if ((j == 35) && (i == 9))
					universe.addGameEntity(
							efactoryBlue.createCastleTop(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE)));
			}
		}
	}

	public void placeRessources() {

		for (int i = 0; i < NB_ROWS; ++i) {
			for (int j = 0; j < NB_COLUMNS; ++j) {
				GameEntity r = null;
				if ((j == 10) && (i == 12))
					r = efactoryBlue.createCopperOre(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE));
				if ((j == 12) && (i == 12))
					r = efactoryBlue.createGreyRock(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE));
				if ((j == 12) && (i == 10))
					r = efactoryBlue.createNormalPineTree(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE));
				if ((j == 10) && (i == 10))
					r = efactoryBlue.createNormalTree(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE));
				if ((j == 15) && (i == 12))
					r = efactoryBlue.createYellowRock(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE));
				if (r != null){
					environmentList.add((Environment) r);
					universe.addGameEntity(r);
				}

			}
		}
	}

	public void remove() {

	}

}
