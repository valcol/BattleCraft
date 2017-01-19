package battleCraft;

import java.util.ArrayList;

import gameframework.core.GameDefaultImpl;
import gameframework.core.GameLevel;

public class Main {

	public static void main(String[] args) {
		GameDefaultImpl g = new GameDefaultImpl();
		ArrayList<GameLevel> levels = new ArrayList<>();

		levels.add(new GameLevelBC(g));
		
		g.setLevels(levels);
		g.start();
	}

}
