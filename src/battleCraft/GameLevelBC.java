package battlecraft;

import gameframework.core.CanvasDefaultImpl;
import gameframework.core.Game;
import gameframework.core.GameLevelDefaultImpl;
import gameframework.core.GameMovableDriverDefaultImpl;
import gameframework.core.GameUniverseDefaultImpl;
import gameframework.core.GameUniverseViewPortDefaultImpl;
import gameframework.moves_rules.MoveBlockerChecker;
import gameframework.moves_rules.MoveBlockerCheckerDefaultImpl;
import gameframework.moves_rules.MoveStrategyRandom;
import gameframework.moves_rules.OverlapProcessor;
import gameframework.moves_rules.OverlapProcessorDefaultImpl;

import java.awt.Canvas;
import java.awt.Point;

import battlecraft.entity.EntityFactory;
import battlecraft.entity.unit.Soldier;
import battlecraft.rule.MoveBlockers;
import battlecraft.rule.OverlapRules;
import pacman.entity.Ghost;
import pacman.rule.GhostMovableDriver;
import pacman.rule.PacmanMoveBlockers;
import pacman.rule.PacmanOverlapRules;

public class GameLevelBC extends GameLevelDefaultImpl {

	Canvas canvas;
	EntityFactory efactory;
	MoveStrategySelect selectStr;
	
	private int NB_ROWS;
	private int NB_COLUMNS;
	private int SPRITE_SIZE;
	public static final int NUMBER_OF_GHOSTS = 5;

	// 0 : Pacgums; 1 : Walls; 2 : SuperPacgums; 3 : Doors; 4 : Jail; 5 : empty
	// Note: teleportation points are not indicated since they are defined by
	// directed pairs of positions
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
		overlapRules.setUniverse(universe);
		overlapRules.setStrategy(selectStr);

		gameBoard = new GameUniverseViewPortDefaultImpl(canvas, universe);
		((CanvasDefaultImpl) canvas).setDrawingGameBoard(gameBoard);

		efactory = new EntityFactory();
		canvas.addMouseListener(selectStr);
		canvas.addMouseMotionListener(selectStr);
		selectStr.setCanvas(canvas);
		
		placeTiles();
		placeStructures();
		placeRessources();

		// Pacman definition and inclusion in the universe
		Soldier myPac = (Soldier) efactory.createSoldier(canvas);
		GameMovableDriverDefaultImpl pacDriver = new GameMovableDriverDefaultImpl();
		MoveStrategyStub stubStr = new MoveStrategyStub(myPac);
		pacDriver.setStrategy(stubStr);
		pacDriver.setmoveBlockerChecker(moveBlockerChecker);
		myPac.setDriver(pacDriver);
		selectStr.addUnit(myPac, stubStr);
		myPac.setPosition(new Point(14 * SPRITE_SIZE, 17 * SPRITE_SIZE));
		universe.addGameEntity(myPac);
		
		Soldier myPac2 = (Soldier) efactory.createSoldier(canvas);
		GameMovableDriverDefaultImpl pacDriver2 = new GameMovableDriverDefaultImpl();
		MoveStrategyStub stubStr2 = new MoveStrategyStub(myPac2);
		pacDriver2.setStrategy(stubStr2);
		pacDriver2.setmoveBlockerChecker(moveBlockerChecker);
		myPac2.setDriver(pacDriver2);
		selectStr.addUnit(myPac2, stubStr2);
		myPac2.setPosition(new Point(15 * SPRITE_SIZE, 10 * SPRITE_SIZE));
		universe.addGameEntity(myPac2);
		
		for (int t = 0; t < NUMBER_OF_GHOSTS; ++t) {
			GameMovableDriverDefaultImpl ghostDriv = new GhostMovableDriver();
			MoveStrategyRandom ranStr = new MoveStrategyRandom();
			Soldier myPac3 = (Soldier) efactory.createSoldier(canvas);
			ghostDriv.setStrategy(ranStr);
			ghostDriv.setmoveBlockerChecker(moveBlockerChecker);
			myPac3.setDriver(ghostDriv);
			myPac3.setTeam(1);
			myPac3.setPosition(new Point(21 * SPRITE_SIZE, 5 * SPRITE_SIZE));
			universe.addGameEntity(myPac3);
			(overlapRules).addSoldier(myPac3);
		}
	}

	public void placeTiles() {
		for (int i = 0; i < NB_ROWS; ++i) {
			for (int j = 0; j < NB_COLUMNS; ++j) {
				if ((j == 0) || (i == 0) || (i == NB_ROWS - 1) || (j == NB_COLUMNS - 1))
					universe.addGameEntity(
							efactory.createForestTile(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE)));
				else
					universe.addGameEntity(
							efactory.createLandTile(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE)));
			}
		}
	}

	public void placeStructures() {
		for (int i = 0; i < NB_ROWS; ++i) {
			for (int j = 0; j < NB_COLUMNS; ++j) {
				//House
				if ((j == 5) && (i == 5) )
					universe.addGameEntity(
							efactory.createHouse(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE)));
				if ((j == 6) && (i == 5) )
					universe.addGameEntity(
							efactory.createHouse(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE)));
				if ((j == 4) && (i == 5) )
					universe.addGameEntity(
							efactory.createHouse(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE)));
				//Castle
				if ((j == 4) && (i == 10))
					universe.addGameEntity(
							efactory.createCastleBottom(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE)));
				if ((j == 4) && (i == 9))
					universe.addGameEntity(
							efactory.createCastleTop(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE)));
			}
		}
	}

	public void placeRessources() {
		
		for (int i = 0; i < NB_ROWS; ++i) {
			for (int j = 0; j < NB_COLUMNS; ++j) {
				if ((j == 10) && (i == 12) )
					universe.addGameEntity(efactory.createBigMineral(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE)));
				if ((j == 12) && (i == 12) )
					universe.addGameEntity(efactory.createBigRock(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE)));
				if ((j == 12) && (i == 10) )
					universe.addGameEntity(efactory.createNormalPineTree(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE)));
				if ((j == 10) && (i == 10) )
					universe.addGameEntity(efactory.createNormalTree(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE)));
			}
		}
	}
	
	public void remove(){
		
	}

}
