package battlecraft;

import java.util.ArrayList;

import gameframework.core.GameLevel;

public class Main {

	public static void main(String[] args) {
		GameBC g = new GameBC();
		ArrayList<GameLevel> levels = new ArrayList<>();

		levels.add(new GameLevelBC(g));
		
		g.setLevels(levels);
		g.start();
	}

}
