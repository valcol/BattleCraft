package battlecraft;

import java.awt.Canvas;
import java.awt.Point;
import java.util.ArrayList;

import battlecraft.entity.environment.Environment;
import battlecraft.entity.structure.Barrack;
import battlecraft.entity.structure.Castle;
import battlecraft.entity.unit.Soldier;
import battlecraft.entity.unit.Worker;
import battlecraft.strategy.BarrackStrategy;
import battlecraft.strategy.MoveStrategySelect;
import battlecraft.strategy.MoveStrategyToPoint;
import battlecraft.strategy.WorkerMoveStrategy;
import gameframework.core.GameEntity;
import gameframework.core.GameMovableDriverDefaultImpl;
import gameframework.core.GameUniverse;
import gameframework.moves_rules.MoveBlockerChecker;
import gameframework.moves_rules.MoveStrategyRandom;

public class LevelManager {

    private static LevelManager instance;
    
	ArrayList<Environment> environmentList = new ArrayList<Environment>();

	MoveStrategySelect moveStrat;
	BarrackStrategy houseStrategySelect;
	MoveBlockerChecker moveBlockerChecker;
	GameUniverse universe;
	Canvas canvas;
	Player player;

    private LevelManager() {

    }

    public static LevelManager getInstance() {
        return instance;
    }

    public static void init() {
        instance = new LevelManager();
    }

	public MoveStrategySelect getMoveStrat() {
		return moveStrat;
	}

	public void setMoveStrat(MoveStrategySelect moveStrat) {
		this.moveStrat = moveStrat;
	}

	public BarrackStrategy getBarracksMenu() {
		return houseStrategySelect;
	}

	public void setBarracksMenu(BarrackStrategy barracksMenu) {
		this.houseStrategySelect = barracksMenu;
	}

	public MoveBlockerChecker getMoveBlockerChecker() {
		return moveBlockerChecker;
	}

	public void setMoveBlockerChecker(MoveBlockerChecker moveBlockerChecker) {
		this.moveBlockerChecker = moveBlockerChecker;
	}

	public GameUniverse getUniverse() {
		return universe;
	}

	public void setUniverse(GameUniverse universe) {
		this.universe = universe;
	}
	
	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public void addIAToCastleSoldier(Soldier s){
		GameMovableDriverDefaultImpl ghostDriv = new GameMovableDriverDefaultImpl();
		MoveStrategyToPoint ranStr = new MoveStrategyToPoint(s);
		ranStr.setDestionation(new Point(155, 315));
		ghostDriv.setStrategy(ranStr);
		ghostDriv.setmoveBlockerChecker(moveBlockerChecker);
		s.setDriver(ghostDriv);
		universe.addGameEntity(s);
	}
	
	public void addIARandomSoldier(Soldier s){
		GameMovableDriverDefaultImpl ghostDriv = new GameMovableDriverDefaultImpl();
		MoveStrategyRandom ranStr = new MoveStrategyRandom();
		ghostDriv.setStrategy(ranStr);
		ghostDriv.setmoveBlockerChecker(moveBlockerChecker);
		s.setDriver(ghostDriv);
		universe.addGameEntity(s);
	}
	
	public void addIADefensiveSoldier(Soldier s){
		GameMovableDriverDefaultImpl ghostDriv = new GameMovableDriverDefaultImpl();
		ghostDriv.setmoveBlockerChecker(moveBlockerChecker);
		s.setDriver(ghostDriv);
		universe.addGameEntity(s);
	}
	
	public void addPlayerSoldier(Soldier s){
		GameMovableDriverDefaultImpl ghostDriv = new GameMovableDriverDefaultImpl();
		MoveStrategyToPoint ranStr = new MoveStrategyToPoint(s);
		ghostDriv.setStrategy(ranStr);
		moveStrat.addUnit(s, ranStr);
		ghostDriv.setmoveBlockerChecker(moveBlockerChecker);
		s.setDriver(ghostDriv);
		universe.addGameEntity(s);
	}
	
	public void addWorker(Worker w){
		GameMovableDriverDefaultImpl ghostDriv1 = new GameMovableDriverDefaultImpl();
		WorkerMoveStrategy ranStr1 = new WorkerMoveStrategy(environmentList, w);
		ghostDriv1.setStrategy(ranStr1);
		ghostDriv1.setmoveBlockerChecker(moveBlockerChecker);
		w.setDriver(ghostDriv1);
		universe.addGameEntity(w);
	}
	
	
	public void addPlayerCastle(Castle c){
		universe.addGameEntity(c);
	}
	
	public void addIACastle(Castle c){
		universe.addGameEntity(c);
	}
    
	public void addBarracks(Barrack h){
		BarrackStrategy b = new BarrackStrategy(h, player);
		canvas.addMouseListener(b);
		universe.addGameEntity(h);
	}
	
	public void addEnvironment(Environment e){
		environmentList.add(e);
		universe.addGameEntity(e);
	}
	
	public void addTile(GameEntity t){
		universe.addGameEntity(t);
	}

	public void setPlayer(Player p) {
		// TODO Auto-generated method stub
		this.player = p;
	}
    
}