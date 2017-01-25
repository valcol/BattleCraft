package battlecraft;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

import battlecraft.entity.Selectable;
import gameframework.core.Movable;
import gameframework.moves_rules.ObjectWithBoundedBox;


public class WorkerMoveStrategy {
	
	protected HashMap<Selectable, MoveStrategyStub> strategies = new HashMap<Selectable, MoveStrategyStub>();
	protected HashMap<Selectable, MoveStrategyStub> selectedUnits = new HashMap<Selectable, MoveStrategyStub>();

	private Point startPoint;
	private Point endPoint;
	private Canvas canvas;
	private int numberOfSelected;
	private boolean dragMouse; 

	public WorkerMoveStrategy() {
		numberOfSelected = 0;
		dragMouse = true;
	}

	public void setupVectorToGo(Point point) {
		
		int offset = numberOfSelected*3;
		
		strategies.forEach((unit,strategy)->{	
			
			Random rand = new Random();
			
			int y = rand.nextInt((offset*2)+1) - offset;
			int x = rand.nextInt((offset*2)+1) - offset;
			
			Point newPoint = new Point((int)(point.getX()+x), (int)(point.getY()+y));
			
			if (unit.isSelected())
				strategy.setDestionation(newPoint);
		});
	}
	
	public void addUnit(Selectable unit, MoveStrategyStub strategy){
		strategies.put(unit, strategy);
	}
	
	public void removeUnit(Movable unit){
		strategies.remove(unit);
	}
}