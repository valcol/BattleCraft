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

import battlecraft.entity.SelectableHouse;
import gameframework.core.GameUniverse;
import gameframework.moves_rules.ObjectWithBoundedBox;

public class HouseStrategySelect extends MouseAdapter implements MouseMotionListener {
	private Point startPoint, endPoint;
	private Canvas canvas;
	private boolean dragMouse;
	private ArrayList<SelectableHouse> house = new ArrayList<SelectableHouse>();
	private int numberOfSelected;
	private GameUniverse universe;
	public HouseStrategySelect() {
		numberOfSelected = 0;
		dragMouse = true;
	}

	public void addUnit(SelectableHouse h) {
		house.add(h);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			startPoint = e.getPoint();
			dragMouse = true;
		}
		if (e.getButton() == MouseEvent.BUTTON3) {
			dragMouse = false;
		}

		System.out.println("click pressed House");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			endPoint = e.getPoint();
			if (numberOfSelected == 1)
				deselectUnits();
			else
				selectUnits();
		}
		System.out.println("click released House");
	}

	public void mouseDragged(MouseEvent e) {
		if (dragMouse) {
			System.out.println(e.getPoint());
			Rectangle selection = new Rectangle();
			selection.setFrameFromDiagonal(startPoint, e.getPoint());
			Graphics g = canvas.getGraphics();
			g.setColor(new Color(109, 109, 109));
			g.drawRect(selection.x, selection.y, selection.width, selection.height);
		}
	}

	private void selectUnits() {
		Rectangle selection = new Rectangle();
		selection.setFrameFromDiagonal(startPoint, endPoint);
		if (selection.contains(((ObjectWithBoundedBox) house.get(0)).getBoundingBox())) {
			house.get(0).selectH();
			System.out.println("select " + house.get(0).hashCode());
			universe.addGameEntity(house.get(0).createSoldier(canvas));
			numberOfSelected++;
		}
	}

	private void deselectUnits() {
		house.get(0).deselectH();
		numberOfSelected--;

	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public void setUniverse(GameUniverse universe) {
		this.universe = universe;
	}

}