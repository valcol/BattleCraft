package battleCraft;

import java.awt.Canvas;
import java.awt.Point;
import java.util.Random;

import battleCraft.entities.Arbre;
import battleCraft.entities.House;
import gameframework.core.CanvasDefaultImpl;
import gameframework.core.Game;
import gameframework.core.GameLevelDefaultImpl;
import gameframework.core.GameUniverseDefaultImpl;
import gameframework.core.GameUniverseViewPortDefaultImpl;
import gameframework.moves_rules.MoveBlockerChecker;
import gameframework.moves_rules.MoveBlockerCheckerDefaultImpl;
import gameframework.moves_rules.OverlapProcessor;
import gameframework.moves_rules.OverlapProcessorDefaultImpl;
import pacman.entity.Wall;

public class GameLevelBC extends GameLevelDefaultImpl {
	public static final int SPRITE_SIZE = 32;
	Canvas canvas;
	public int NB_HOUSE = 4;

	public GameLevelBC(Game g) {
		super(g);
		canvas = g.getCanvas();
	}

	@Override
	protected void init() {
		OverlapProcessor overlapProcessor = new OverlapProcessorDefaultImpl();
		MoveBlockerChecker moveBlockerChecker = new MoveBlockerCheckerDefaultImpl();
		universe = new GameUniverseDefaultImpl(moveBlockerChecker, overlapProcessor);
		gameBoard = new GameUniverseViewPortDefaultImpl(canvas, universe);
		((CanvasDefaultImpl) canvas).setDrawingGameBoard(gameBoard);
		Random rand = new Random();

		// Filling up the universe with basic non movable entities and inclusion
		// in the universe
		for (int row = 0; row < 43; ++row) {
			for (int col = 0; col < 57; ++col) {
				// G�n�rer un entier al�atoire compris entre 0 inclus et l'entier
				// pass� en param�tre exclus. En ajoutant 1 et en enlevant le
				// minimum dans l'entier en param�tre, puis en ajoutant le
				// nombre minimum au r�sultat, on arrive � obtenir un nombre
				// al�atoire compris entre les deux valeurs
				if (NB_HOUSE != 0 && (rand.nextInt(57 - row + 1) + row) == row + col) {
					universe.addGameEntity(new House(canvas, new Point(col * SPRITE_SIZE, row * SPRITE_SIZE)));
					--NB_HOUSE;
				} else
					universe.addGameEntity(new Arbre(canvas, col * SPRITE_SIZE, row * SPRITE_SIZE));

			}
		}
	}

}
