package battlecraft.soldier.builder;

import java.awt.Canvas;
import java.awt.Point;

import battlecraft.MoveStrategySelect;
import battlecraft.MoveStrategyStub;
import battlecraft.entity.EntityFactory;
import battlecraft.entity.unit.Soldier;
import gameframework.core.GameEntity;
import gameframework.core.GameMovableDriverDefaultImpl;
import gameframework.moves_rules.MoveBlockerChecker;

public class SoldierBuilder implements Builder {
	EntityFactory e;
	GameMovableDriverDefaultImpl driver;
	MoveStrategyStub strStub;
	MoveStrategySelect selectStr;
	Soldier s;
	MoveBlockerChecker obst;
	Point p;
	Canvas c;
	public SoldierBuilder(EntityFactory e,	MoveBlockerChecker obst, GameMovableDriverDefaultImpl driver,
			MoveStrategySelect selectStr,Canvas c, Point p) {
		this.e=e;
		this.driver=driver;
		this.selectStr=selectStr;
		this.obst = obst;
		this.p =p;
		this.c =c;
	}

	@Override
	public void createSoldier() {
		s =(Soldier) e.createSoldier(c);
		s.setDriver(driver);
		s.setPosition(p);
	}

	@Override
	public void createGameMovableDriver() {
		// TODO Auto-generated method stub
		driver.setStrategy(strStub);
		driver.setmoveBlockerChecker(obst);
	}

	@Override
	public void createMoveStrategy() {
		strStub = new MoveStrategyStub(s);
	}

	@Override
	public void addSelectable() {
		selectStr.addUnit(s, strStub);
	}
	
	public GameEntity getResult(){
		createSoldier();
		createMoveStrategy();
		createGameMovableDriver();
		addSelectable();
		return s;
	}

}
