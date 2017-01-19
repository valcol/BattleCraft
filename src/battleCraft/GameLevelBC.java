package battlecraft;

import java.awt.Canvas;
import java.awt.Point;
import java.util.Random;

import battlecraft.entity.MedievalFactory;
import battlecraft.entity.environment.Arbre;
import battlecraft.entity.structure.House;
import battlecraft.entity.tile.ITileFactory;
import gameframework.core.CanvasDefaultImpl;
import gameframework.core.Game;
import gameframework.core.GameLevelDefaultImpl;
import gameframework.core.GameUniverseDefaultImpl;
import gameframework.core.GameUniverseViewPortDefaultImpl;
import gameframework.moves_rules.MoveBlockerChecker;
import gameframework.moves_rules.MoveBlockerCheckerDefaultImpl;
import gameframework.moves_rules.OverlapProcessor;
import gameframework.moves_rules.OverlapProcessorDefaultImpl;

public class GameLevelBC extends GameLevelDefaultImpl {
	public static final int SPRITE_SIZE = 32;
	Canvas canvas;
	public int NB_HOUSE = 4;

	public GameLevelBC(Game g) {
		super(g);
		canvas = g.getCanvas();
	}
	
	static int[][] landtiles = { 
		    { 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49 },
			{ 49, 49, 48, 59, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 48, 49, 49 },
			{ 49, 48, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 59, 59, 59, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 48, 49 },
			{ 49, 58, 59, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 59, 58, 58, 58, 59, 58, 58, 58, 58, 58, 58, 59, 58, 58, 58, 58, 58, 58, 49 },
			{ 49, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 59, 58, 58, 58, 58, 58, 58, 58, 49 },
			{ 49, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 49 },
			{ 49, 58, 59, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 49 },
			{ 49, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 59, 58, 58, 58, 58, 58, 59, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 59, 58, 58, 49 },
			{ 49, 58, 58, 58, 59, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 59, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 49 },
			{ 49, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 59, 58, 58, 58, 58, 58, 58, 58, 49 },
			{ 49, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 59, 58, 58, 58, 58, 59, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 49 },
			{ 49, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 59, 58, 58, 58, 58, 58, 58, 58, 58, 58, 49 },
			{ 49, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 59, 58, 58, 58, 58, 58, 58, 58, 1, 58, 58, 58, 58, 58, 58, 58, 58, 59, 58, 58, 49 },
			{ 49, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 59, 58, 58, 59, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 49 },
			{ 49, 58, 58, 59, 58, 59, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 59, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 49 },
			{ 49, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 49 },
			{ 49, 58, 58, 58, 59, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 49 },
			{ 49, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 59, 58, 58, 58, 58, 58, 58, 58, 58, 58, 49 },
			{ 49, 58, 58, 58, 59, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 59, 58, 58, 58, 58, 58, 58, 58, 58, 49 },
			{ 49, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 59, 58, 58, 58, 58, 58, 58, 58, 59, 58, 58, 58, 58, 58, 58, 58, 49 },
			{ 49, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 59, 58, 58, 58, 58, 58, 58, 58, 58, 59, 58, 58, 58, 49 },
			{ 49, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 59, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 49 },
			{ 49, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 59, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 59, 58, 58, 58, 58, 49 },
			{ 49, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 59, 58, 59, 58, 58, 58, 58, 49 },
			{ 49, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 59, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 49 },
			{ 49, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 49 },
			{ 49, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 59, 58, 58, 58, 58, 59, 58, 58, 49 },
			{ 49, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 59, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 59, 58, 58, 58, 49 },
			{ 49, 48, 58, 58, 59, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 59, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 48, 49 },
			{ 49, 49, 48, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 48, 49, 49 },
			{ 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49 } };

	@Override
	protected void init() {
		OverlapProcessor overlapProcessor = new OverlapProcessorDefaultImpl();
		MoveBlockerChecker moveBlockerChecker = new MoveBlockerCheckerDefaultImpl();
		universe = new GameUniverseDefaultImpl(moveBlockerChecker, overlapProcessor);
		gameBoard = new GameUniverseViewPortDefaultImpl(canvas, universe);
		((CanvasDefaultImpl) canvas).setDrawingGameBoard(gameBoard);
		Random rand = new Random();
		
		ITileFactory tfactory = new MedievalFactory();

		for (int i = 0; i < landtiles.length; ++i) {
			for (int j = 0; j < landtiles[0].length; ++j) {
				universe.addGameEntity(tfactory.createTile(canvas, new Point(j * SPRITE_SIZE, i * SPRITE_SIZE), landtiles[i][j]));
			}
		}

		// Filling up the universe with basic non movable entities and inclusion
		// in the universe
		for (int row = 0; row < landtiles.length; row++) {
			for (int col = 0; col < landtiles[0].length; col++) {
				// Générer un entier aléatoire compris entre 0 inclus et l'entier
				// passé en paramètre exclus. En ajoutant 1 et en enlevant le
				// minimum dans l'entier en paramètre, puis en ajoutant le
				// nombre minimum au résultat, on arrive à obtenir un nombre
				// aléatoire compris entre les deux valeurs
				if (NB_HOUSE != 0 && (rand.nextInt(57 - row + 1) + row) == row + col) {
					universe.addGameEntity(new House(canvas, new Point(col * SPRITE_SIZE, row * SPRITE_SIZE)));
					--NB_HOUSE;
				} 

			}
		}
	}

}
