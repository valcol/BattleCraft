package battlecraft;

import java.awt.Canvas;
import java.awt.Point;
import java.util.ArrayList;

import com.sun.glass.ui.Window.Level;

import battlecraft.entity.EntityFactory;
import battlecraft.entity.environment.Environment;
import battlecraft.entity.structure.Barrack;
import battlecraft.entity.unit.Soldier;
import battlecraft.entity.unit.Worker;
import battlecraft.rule.MoveBlockers;
import battlecraft.rule.OverlapRules;
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

		
		LevelManager.init();
		LevelManager.getInstance().setBarracksMenu(selectHouse);
		LevelManager.getInstance().setMoveBlockerChecker(moveBlockerChecker);
		LevelManager.getInstance().setMoveStrat(selectStr);
		LevelManager.getInstance().setUniverse(universe);

		placeTiles();
		placeStructures();
		placeRessources();

		Soldier myPac3 = (Soldier) efactoryRed.createSoldier(canvas, new Point(21 * SPRITE_SIZE, 5 * SPRITE_SIZE));
		LevelManager.getInstance().addIARandomSoldier(myPac3);

		
		Worker myPac31 = (Worker) efactoryBlue.createWoodWorker(canvas, new Point(21 * SPRITE_SIZE, 5 * SPRITE_SIZE));
		LevelManager.getInstance().addWorker(myPac31);
		
		Soldier myPac311 = (Soldier) efactoryRed.createSoldier(canvas, new Point(21 * SPRITE_SIZE, 5 * SPRITE_SIZE));
		LevelManager.getInstance().addIAToCastleSoldier(myPac311);
			
		
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
		Barrack h = null;
		for (int i = 0; i < NB_ROWS; ++i) {
			for (int j = 0; j < NB_COLUMNS; ++j) {
				// House

				if ((j == 2) && (i == 5)) {
					h = (Barrack) efactoryBlue.createHouseSoldier(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE));
					selectHouse.addUnit(h);
					universe.addGameEntity(h);
				}
				if ((j == 7) && (i == 2)) {
					h = (Barrack) efactoryBlue.createHouseWorker(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE));
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
					LevelManager.getInstance().addEnvironment((Environment) r);
				}

			}
		}
	}

	public void remove() {

	}

}
