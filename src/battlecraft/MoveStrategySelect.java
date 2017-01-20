package battlecraft;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import battlecraft.entity.Selectable;
import gameframework.core.GameMovable;
import gameframework.core.Movable;
import gameframework.moves_rules.MoveStrategy;
import gameframework.moves_rules.ObjectWithBoundedBox;
import gameframework.moves_rules.SpeedVector;
import gameframework.moves_rules.SpeedVectorDefaultImpl;

/**
 * {@link MoveStrategy} which listens to the mouse and answers new
 * {@link SpeedVector speed vectors} based on what the user typed.
 */
public class MoveStrategySelect extends MouseAdapter implements MouseMotionListener {
	protected HashMap<Selectable, MoveStrategyStub> strategies = new HashMap<Selectable, MoveStrategyStub>();
	protected HashMap<Selectable, MoveStrategyStub> selectedUnits = new HashMap<Selectable, MoveStrategyStub>();
	private boolean isSelected;
	private Point startPoint;
	private Point endPoint;
	private Canvas canvas;

	public MoveStrategySelect() {
		isSelected = false;
	}

	public void setupVectorToGo(Point point) {
		strategies.forEach((unit,strategy)->{	
			if (unit.isSelected())
				strategy.setDestionation(point);
		});
	}
	
	public void addUnit(Selectable unit, MoveStrategyStub strategy){
		strategies.put(unit, strategy);
	}
	
	public void removeUnit(Movable unit){
		strategies.remove(unit);
	}

	
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			startPoint = e.getPoint();
		}
		
		System.out.println("click pressed");
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			endPoint = e.getPoint();
			if (isSelected){
				deselectUnits();
			}
			
			selectUnits();
		}
		
		if (e.getButton() == MouseEvent.BUTTON3) {
			if (isSelected)
				setupVectorToGo(e.getPoint());
		}
		
		System.out.println("click released");
	}
	
	@Override
	public void mouseDragged(MouseEvent e){
		System.out.println(e.getPoint());
		Rectangle selection = new Rectangle();
		selection.setFrameFromDiagonal(startPoint, e.getPoint());
		 Graphics g = canvas.getGraphics();
		 g.setColor(new Color(255,255,255));
		 g.drawRect(selection.x, selection.y, selection.width, selection.height);
	}


	private void selectUnits() {
		
		Rectangle selection = new Rectangle();
		selection.setFrameFromDiagonal(startPoint, endPoint);
		
		for (Entry<Selectable, MoveStrategyStub> entry : strategies.entrySet()) {
	        if (selection.contains(((ObjectWithBoundedBox) entry.getKey()).getBoundingBox())){
	        	entry.getKey().select();
	        	System.out.println("select "+entry.getKey().hashCode());
	        	isSelected = true;
	        }
	    }
		
	}


	private void deselectUnits() {
		strategies.forEach((unit,strategy)->{	
			unit.deselect();
		});
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
}