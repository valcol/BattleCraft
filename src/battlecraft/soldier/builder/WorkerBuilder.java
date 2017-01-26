package battlecraft.soldier.builder;

import java.awt.Canvas;
import java.awt.Point;

import battlecraft.MoveStrategyStub;
import battlecraft.entity.EntityFactory;
import battlecraft.entity.unit.Worker;
import gameframework.core.GameEntity;
import gameframework.core.GameMovableDriverDefaultImpl;
import gameframework.moves_rules.MoveBlockerChecker;

public class WorkerBuilder implements Builder {
	EntityFactory e;
	GameMovableDriverDefaultImpl driver;
	MoveStrategyStub strStub;
	Worker s;
	MoveBlockerChecker obst;
	Point p;
	Canvas c;

	public WorkerBuilder(EntityFactory e, MoveBlockerChecker obst, GameMovableDriverDefaultImpl driver, Canvas c,
			Point p) {
		this.e = e;
		this.driver = driver;
		this.obst = obst;
		this.p = p;
		this.c = c;
	}

	@Override
	public void createUnit() {
		s = (Worker) e.createWoodWorker(c);
		s.setDriver(driver);
		s.setPosition(p);
	}

	@Override
	public void createGameMovableDriver() {
		driver.setStrategy(strStub);
		driver.setmoveBlockerChecker(obst);
	}

	@Override
	public void createMoveStrategy() {
		strStub = new MoveStrategyStub(s);
	}

	@Override
	public void addSelectable() throws UnsupportedOperationException{
	}

	public GameEntity getResult() {
		createUnit();
		createMoveStrategy();
		createGameMovableDriver();
		return s;
	}

}
