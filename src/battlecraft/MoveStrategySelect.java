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


public class MoveStrategySelect extends MouseAdapter implements MouseMotionListener {
	
	protected HashMap<Selectable, MoveStrategyStub> strategies = new HashMap<Selectable, MoveStrategyStub>();
	protected HashMap<Selectable, MoveStrategyStub> selectedUnits = new HashMap<Selectable, MoveStrategyStub>();

	private Point startPoint;
	private Point endPoint;
	private Canvas canvas;
	private int numberOfSelected;

	public MoveStrategySelect() {
		numberOfSelected = 0;
	}

	public void setupVectorToGo(Point point) {
		
		strategies.forEach((unit,strategy)->{	
			
			Random rand = new Random();
			
			int y = rand.nextInt(41) - 20;
			int x = rand.nextInt(41) - 20;
			
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
			if (numberOfSelected>0){
				deselectUnits();
			}
			
			selectUnits();
		}
		
		if (e.getButton() == MouseEvent.BUTTON3) {
			if (numberOfSelected>0)
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
		 g.setColor(new Color(109,109,109));
		 g.drawRect(selection.x, selection.y, selection.width, selection.height);
	}


	private void selectUnits() {
		
		Rectangle selection = new Rectangle();
		selection.setFrameFromDiagonal(startPoint, endPoint);
		
		for (Entry<Selectable, MoveStrategyStub> entry : strategies.entrySet()) {
	        if (selection.contains(((ObjectWithBoundedBox) entry.getKey()).getBoundingBox())){
	        	entry.getKey().select();
	        	System.out.println("select "+entry.getKey().hashCode());
	        	numberOfSelected++;
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