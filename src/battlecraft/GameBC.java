package battlecraft;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import gameframework.core.CanvasDefaultImpl;
import gameframework.core.Game;
import gameframework.core.GameLevel;
import gameframework.core.GameLevelDefaultImpl;
import gameframework.core.ObservableValue;

/**
 * Create a basic game application with menus and displays of lives and score
 */
public class GameBC implements Game, Observer {
	protected static final int NB_ROWS = 25;
	protected static final int NB_COLUMNS = 41;
	protected static final int SPRITE_SIZE = 32;
	public static final int MAX_NUMBER_OF_PLAYER = 1;
	public static final int NUMBER_OF_LIVES = 1;

	protected CanvasDefaultImpl defaultCanvas = null;
	protected ObservableValue<Integer> score[] = new ObservableValue[MAX_NUMBER_OF_PLAYER];
	protected ObservableValue<Integer> life[] = new ObservableValue[MAX_NUMBER_OF_PLAYER];

	protected ObservableValue<Integer> wood[] = new ObservableValue[1];
	protected ObservableValue<Integer> ore[] = new ObservableValue[1];
	protected ObservableValue<Integer> rock[] = new ObservableValue[1];

	// initialized before each level
	protected ObservableValue<Boolean> endOfGame = null;

	private Frame f;

	private GameLevelDefaultImpl currentPlayedLevel = null;
	protected int levelNumber;
	protected ArrayList<GameLevel> gameLevels;

	protected Label woodText, oreText, rockText;
	protected Label woodValue, oreValue, rockValue;

	protected Label information;
	protected Label informationValue;
	protected Label lifeValue;
	protected Label currentLevel;
	protected Label currentLevelValue;

	public GameBC() {
		for (int i = 0; i < MAX_NUMBER_OF_PLAYER; ++i) {
			score[i] = new ObservableValue<Integer>(0);
			life[i] = new ObservableValue<Integer>(0);
		}
		wood[0] = new ObservableValue<Integer>(0);
		ore[0] = new ObservableValue<Integer>(0);
		rock[0] = new ObservableValue<Integer>(0);
		woodText = new Label("Wood:");
		oreText = new Label("Ore:");
		rockText = new Label("Rock:");

		information = new Label("State:");
		informationValue = new Label("Playing");
		currentLevel = new Label("Level:");
		createGUI();
	}

	public void createGUI() {
		f = new Frame("Default Game");
		f.dispose();

		createMenuBar();
		Container c = createStatusBar();

		defaultCanvas = new CanvasDefaultImpl();
		defaultCanvas.setSize(SPRITE_SIZE * NB_COLUMNS, SPRITE_SIZE * NB_ROWS);
		f.add(defaultCanvas);
		f.add(c, BorderLayout.NORTH);
		f.pack();
		f.setVisible(true);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("images/cursor.gif");
		Cursor cu = toolkit.createCustomCursor(image, new Point(f.getX(), f.getY()), "img");
		f.setCursor(cu);

		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	
	}

	private void createMenuBar() {
		MenuBar menuBar = new MenuBar();
		Menu file = new Menu("file");
		MenuItem start = new MenuItem("new game");
		MenuItem save = new MenuItem("save");
		MenuItem restore = new MenuItem("load");
		MenuItem quit = new MenuItem("quit");
		Menu game = new Menu("game");
		MenuItem pause = new MenuItem("pause");
		MenuItem resume = new MenuItem("resume");
		menuBar.add(file);
		menuBar.add(game);
		
		f.setMenuBar(menuBar);

		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		restore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restore();
			}
		});
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		pause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pause();
			}
		});
		resume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resume();
			}
		});

		file.add(start);
		file.add(save);
		file.add(restore);
		file.add(quit);
		game.add(pause);
		game.add(resume);
	}

	private Container createStatusBar() {
		JPanel c = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		c.setLayout(layout);
		lifeValue = new Label(Integer.toString(life[0].getValue()));
		currentLevelValue = new Label(Integer.toString(levelNumber));
		woodValue = new Label(Integer.toString(wood[0].getValue())+ "     ");
		oreValue = new Label(Integer.toString(ore[0].getValue())+ "     ");
		rockValue = new Label(Integer.toString(rock[0].getValue())+ "     ");

		c.add(woodText);
		c.add(woodValue);
		c.add(oreText);
		c.add(oreValue);
		c.add(rockText);
		c.add(rockValue);
		c.add(currentLevel);
		c.add(currentLevelValue);
		c.add(information);
		c.add(informationValue);
		c.repaint();
		return c;
	}

	public Canvas getCanvas() {
		return defaultCanvas;
	}

	public void start() {
		for (int i = 0; i < MAX_NUMBER_OF_PLAYER; ++i) {
			score[i].addObserver(this);
			life[i].addObserver(this);
			life[i].setValue(NUMBER_OF_LIVES);
			score[i].setValue(0);
		}
		wood[0].addObserver(this);
		ore[0].addObserver(this);
		rock[0].addObserver(this);
		levelNumber = 0;
		for (GameLevel level : gameLevels) {
			endOfGame = new ObservableValue<Boolean>(false);
			endOfGame.addObserver(this);
			try {
				if (currentPlayedLevel != null && currentPlayedLevel.isAlive()) {
					currentPlayedLevel.interrupt();
					currentPlayedLevel = null;
				}
				currentPlayedLevel = (GameLevelDefaultImpl) level;
				levelNumber++;
				currentLevelValue.setText(Integer.toString(levelNumber));
				currentPlayedLevel.start();
				currentPlayedLevel.join();
			} catch (Exception e) {
			}
		}

	}

	public void restore() {
		System.out.println("restore(): Unimplemented operation");
	}

	public void save() {
		System.out.println("save(): Unimplemented operation");
	}

	public void pause() {
		System.out.println("pause(): Unimplemented operation");
		// currentPlayedLevel.suspend();
	}

	public void resume() {
		System.out.println("resume(): Unimplemented operation");
		// currentPlayedLevel.resume();
	}

	public ObservableValue<Integer>[] score() {
		return score;
	}

	public ObservableValue<Integer>[] life() {
		return life;
	}

	public ObservableValue<Boolean> endOfGame() {
		return endOfGame;
	}

	public ObservableValue<Integer> wood() {
		return wood[0];
	}

	public ObservableValue<Integer> ore() {
		return ore[0];

	}

	public ObservableValue<Integer> rock() {
		return rock[0];

	}

	public void setLevels(ArrayList<GameLevel> levels) {
		gameLevels = levels;
	}

	public static int getNbRows() {
		return NB_ROWS;
	}

	public static int getNbColumns() {
		return NB_COLUMNS;
	}

	public static int getSpriteSize() {
		return SPRITE_SIZE;
	}

	public void update(Observable o, Object arg) {
		if (o == endOfGame) {
			if (endOfGame.getValue()) {
				informationValue.setText("You win");
				currentPlayedLevel.interrupt();
				currentPlayedLevel.end();
			}
		} else {
			for (ObservableValue<Integer> lifeObservable : life) {
				if (o == lifeObservable) {
					int lives = ((ObservableValue<Integer>) o).getValue();
					lifeValue.setText(Integer.toString(lives));
					if (lives == 0) {
						informationValue.setText("Defeat");
						currentPlayedLevel.interrupt();
						currentPlayedLevel.end();
					}
				}
			}
			if (o == wood()) {
				woodValue.setText(Integer.toString(((ObservableValue<Integer>) o).getValue()));
			}
			if (o == rock()) {
				rockValue.setText(Integer.toString(((ObservableValue<Integer>) o).getValue()));
			}
			if (o == ore()) {
				oreValue.setText(Integer.toString(((ObservableValue<Integer>) o).getValue()));
			}

		}
	}
}
