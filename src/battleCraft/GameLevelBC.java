package battlecraft;

import gameframework.core.CanvasDefaultImpl;
import gameframework.core.Game;
import gameframework.core.GameLevelDefaultImpl;
import gameframework.core.GameMovableDriverDefaultImpl;
import gameframework.core.GameUniverseDefaultImpl;
import gameframework.core.GameUniverseViewPortDefaultImpl;
import gameframework.moves_rules.MoveBlockerChecker;
import gameframework.moves_rules.MoveBlockerCheckerDefaultImpl;
import gameframework.moves_rules.MoveStrategyKeyboard;
import gameframework.moves_rules.MoveStrategyRandom;
import gameframework.moves_rules.OverlapProcessor;
import gameframework.moves_rules.OverlapProcessorDefaultImpl;

import java.awt.Canvas;
import java.awt.Point;

import battlecraft.entity.EntityFactory;
import battlecraft.entity.structure.IStructureFactory;
import battlecraft.entity.tile.ITileFactory;
import battlecraft.entity.unit.Soldier;
import pacman.entity.Ghost;
import pacman.entity.Pacman;
import pacman.rule.GhostMovableDriver;
import pacman.rule.PacmanMoveBlockers;
import pacman.rule.PacmanOverlapRules;

public class GameLevelBC extends GameLevelDefaultImpl {

	Canvas canvas;
	EntityFactory efactory;
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
		moveBlockerChecker.setMoveBlockerRules(new PacmanMoveBlockers());

		PacmanOverlapRules overlapRules = new PacmanOverlapRules(new Point(14 * SPRITE_SIZE, 17 * SPRITE_SIZE),
				new Point(14 * SPRITE_SIZE, 15 * SPRITE_SIZE), life[0], score[0], endOfGame);
		overlapProcessor.setOverlapRules(overlapRules);

		universe = new GameUniverseDefaultImpl(moveBlockerChecker, overlapProcessor);
		overlapRules.setUniverse(universe);

		gameBoard = new GameUniverseViewPortDefaultImpl(canvas, universe);
		((CanvasDefaultImpl) canvas).setDrawingGameBoard(gameBoard);

		efactory = new EntityFactory();

		placeTiles();
		placeStructures();
		overlapRules.setTotalNbGums(0);

		// Pacman definition and inclusion in the universe
		Soldier myPac = (Soldier) efactory.createSoldier(canvas);
		GameMovableDriverDefaultImpl pacDriver = new GameMovableDriverDefaultImpl();
		MoveStrategyKeyboard keyStr = new MoveStrategyKeyboard();
		pacDriver.setStrategy(keyStr);
		pacDriver.setmoveBlockerChecker(moveBlockerChecker);
		canvas.addKeyListener(keyStr);
		myPac.setDriver(pacDriver);
		myPac.setPosition(new Point(14 * SPRITE_SIZE, 17 * SPRITE_SIZE));
		universe.addGameEntity(myPac);

		// Ghosts definition and inclusion in the universe
		Ghost myGhost;
		for (int t = 0; t < NUMBER_OF_GHOSTS; ++t) {
			GameMovableDriverDefaultImpl ghostDriv = new GhostMovableDriver();
			MoveStrategyRandom ranStr = new MoveStrategyRandom();
			ghostDriv.setStrategy(ranStr);
			ghostDriv.setmoveBlockerChecker(moveBlockerChecker);
			myGhost = new Ghost(canvas);
			myGhost.setDriver(ghostDriv);
			myGhost.setPosition(new Point(14 * SPRITE_SIZE, 15 * SPRITE_SIZE));
			universe.addGameEntity(myGhost);
			(overlapRules).addGhost(myGhost);
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
				if ((j == 5) && (i == 5))
					universe.addGameEntity(
							efactory.createHouse(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE), 17));
				if ((j == 4) && (i == 10))
					universe.addGameEntity(
							efactory.createCastle(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE), 6));
				if ((j == 4) && (i == 9))
					universe.addGameEntity(
							efactory.createCastle(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE), 2));
			}
		}
	}

	public void placeRessources() {
		// TODO
	}

}
