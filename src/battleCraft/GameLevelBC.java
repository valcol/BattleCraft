package battlecraft;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import battlecraft.entity.EntityFactory;
import battlecraft.entity.environment.Environment;
import battlecraft.entity.structure.Barrack;
import battlecraft.entity.structure.Castle;
import battlecraft.entity.unit.Soldier;
import battlecraft.entity.unit.Worker;
import battlecraft.enums.Teams;
import battlecraft.rule.MoveBlockers;
import battlecraft.rule.OverlapRules;
import battlecraft.strategy.BarrackStrategy;
import battlecraft.strategy.MoveStrategySelect;
import gameframework.core.CanvasDefaultImpl;
import gameframework.core.Game;
import gameframework.core.GameEntity;
import gameframework.core.GameLevelDefaultImpl;
import gameframework.core.GameUniverseDefaultImpl;
import gameframework.core.GameUniverseViewPortDefaultImpl;
import gameframework.core.ObservableValue;
import gameframework.moves_rules.MoveBlockerChecker;
import gameframework.moves_rules.MoveBlockerCheckerDefaultImpl;
import gameframework.moves_rules.OverlapProcessor;
import gameframework.moves_rules.OverlapProcessorDefaultImpl;

public class GameLevelBC extends GameLevelDefaultImpl {

	Canvas canvas;
	EntityFactory efactoryBlue;
	EntityFactory efactoryRed;
	ArrayList<Environment> environmentList = new ArrayList<Environment>();

	MoveStrategySelect selectStr;
	BarrackStrategy selectHouse;

	private int NB_ROWS;
	private int NB_COLUMNS;
	private int SPRITE_SIZE;
	public static final int NUMBER_OF_GHOSTS = 5;
	private Player p;
	private IA ia;

	public GameLevelBC(GameBC g) {
		super(g);
		SPRITE_SIZE = g.SPRITE_SIZE;
		NB_COLUMNS = g.NB_COLUMNS;
		NB_ROWS = g.NB_ROWS;
		canvas = g.getCanvas();
		
		p = new Player();
		ia = new IA();
		
		p.setOre(g.ore());
		p.setRock(g.rock());
		p.setWood(g.wood());
		
		ia.setOre(0);
		ia.setRock(0);
		ia.setWood(20);
	}

	@Override
	protected void init() {

		OverlapProcessor overlapProcessor = new OverlapProcessorDefaultImpl();

		MoveBlockerChecker moveBlockerChecker = new MoveBlockerCheckerDefaultImpl();
		moveBlockerChecker.setMoveBlockerRules(new MoveBlockers(endOfGame));

		OverlapRules overlapRules = new OverlapRules();
		overlapProcessor.setOverlapRules(overlapRules);

		universe = new GameUniverseDefaultImpl(moveBlockerChecker, overlapProcessor);
		selectStr = new MoveStrategySelect();

		overlapRules.setUniverse(universe);
		overlapRules.setStrategy(selectStr);
		overlapRules.setCanvas(canvas);
		overlapRules.setPlayer(p);
		overlapRules.setIA(ia);
		
		gameBoard = new GameUniverseViewPortDefaultImpl(canvas, universe);
		((CanvasDefaultImpl) canvas).setDrawingGameBoard(gameBoard);

		efactoryBlue = new EntityFactory(Teams.BLUE);
		efactoryRed = new EntityFactory(Teams.RED);

		canvas.addMouseListener(selectStr);
		canvas.addMouseMotionListener(selectStr);
		canvas.addMouseListener(selectHouse);
		canvas.addMouseMotionListener(selectHouse);
		selectStr.setCanvas(canvas);

		LevelManager.init();
		LevelManager.getInstance().setBarracksMenu(selectHouse);
		LevelManager.getInstance().setMoveBlockerChecker(moveBlockerChecker);
		LevelManager.getInstance().setMoveStrat(selectStr);
		LevelManager.getInstance().setUniverse(universe);
		LevelManager.getInstance().setCanvas(canvas);
		LevelManager.getInstance().setPlayer(p);
		LevelManager.getInstance().setIa(ia);

		placeTiles();
		placeStructures();
		placeRessources();

		Worker wb = (Worker) efactoryBlue.createWoodWorker(canvas, new Point(21 * SPRITE_SIZE, 5 * SPRITE_SIZE));
		LevelManager.getInstance().addWorker(wb);
		
		Worker wr = (Worker) efactoryRed.createWoodWorker(canvas, new Point(25 * SPRITE_SIZE, 5 * SPRITE_SIZE));
		LevelManager.getInstance().addWorker(wr);
		
		placeIAGardian();

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
		Castle c = null;
		for (int i = 0; i < NB_ROWS; ++i) {
			for (int j = 0; j < NB_COLUMNS; ++j) {
				if ((j == 2) && (i == 5)) {
					h = (Barrack) efactoryBlue.createHouseSoldier(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE));
					LevelManager.getInstance().addPlayerBarrack(h);
				}
				if ((j == 7) && (i == 2)) {
					h = (Barrack) efactoryBlue.createBarrackRockWorker(canvas,
							new Point(j * SPRITE_SIZE, i * SPRITE_SIZE));
					LevelManager.getInstance().addPlayerBarrack(h);
				}
				if ((j == 2) && (i == 2)) {
					h = (Barrack) efactoryBlue.createBarrackWoodWorker(canvas,
							new Point(j * SPRITE_SIZE, i * SPRITE_SIZE));
					LevelManager.getInstance().addPlayerBarrack(h);
				}
				// RED
				if ((j == 37) && (i == 5)) {
					h = (Barrack) efactoryRed.createBarrackSoldierIA(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE));
					LevelManager.getInstance().addIABarrack(h);

				}
				if ((j == 32) && (i == 2)) {
					h = (Barrack) efactoryRed.createBarrackRockWorker(canvas,
							new Point(j * SPRITE_SIZE, i * SPRITE_SIZE));
					LevelManager.getInstance().addIABarrack(h);
				}
				if ((j == 37) && (i == 2)) {
					h = (Barrack) efactoryRed.createBarrackWoodWorker(canvas,
							new Point(j * SPRITE_SIZE, i * SPRITE_SIZE));
					LevelManager.getInstance().addIABarrack(h);
				}
				// Castle
				if ((j == 4) && (i == 10)) {
					c = (Castle) efactoryBlue.createCastle(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE));
					LevelManager.getInstance().addPlayerCastle(c);
				}
				if ((j == 35) && (i == 10)) {
					c = (Castle) efactoryRed.createCastle(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE));
					LevelManager.getInstance().addIACastle(c);
				}
			}
		}
	}

	public void placeRessources() {
		
		Rectangle r1 = new Rectangle(SPRITE_SIZE*NB_COLUMNS/3, SPRITE_SIZE*NB_ROWS/3, SPRITE_SIZE*NB_COLUMNS/3, SPRITE_SIZE*NB_ROWS/3);
		
		for (int i = 0;i<100;i++){
			GameEntity r = null;
			
			int random = (int)(Math.random() * (100));
			
			double randomx = (int)(Math.random() * (r1.width*2)) - r1.width;
			double randomy = (int)(Math.random() * (r1.height));
			
			Point p = new Point((int)(r1.getCenterX()+randomx), (int)(r1.getCenterY()+randomy));
			
			if (random > 95)
				r = efactoryBlue.createCopperOre(canvas, p);
			else if (random > 90)
				r = efactoryBlue.createGoldOre(canvas, p);
			else if (random > 70)
				r = efactoryBlue.createGreyRock(canvas, p);
			else if (random > 80)
				r = efactoryBlue.createYellowRock(canvas, p);
			else if (random > 60)
				r = efactoryBlue.createNormalPineTree(canvas, p);
			else if (random > 40)
				r = efactoryBlue.createNormalTree(canvas, p);
			else if (random > 20)
				r = efactoryBlue.createSmallTree(canvas, p);
			else
				r = efactoryBlue.createSmallPineTree(canvas, p);
			
			LevelManager.getInstance().addEnvironment((Environment) r);
			
		}
	}

	public void placeIAGardian() {
		for (int i = 0; i < 8; ++i) {
			if (i >= 4) {
				Soldier myPac4 = (Soldier) efactoryRed.createSoldier(canvas,
						new Point(34 * SPRITE_SIZE, (7 * SPRITE_SIZE) + (i*16)));
				LevelManager.getInstance().addIADefensiveSoldier(myPac4);
			}
			if (i < 4) {
				Soldier myPac4 = (Soldier) efactoryRed.createSoldier(canvas,
						new Point(33 * SPRITE_SIZE, (7 * SPRITE_SIZE) + ((i+4)*16)));
				LevelManager.getInstance().addIADefensiveSoldier(myPac4);
			}
		}
	}

	public void remove() {

	}

}
