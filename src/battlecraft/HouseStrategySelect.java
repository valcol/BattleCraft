package battlecraft;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import battlecraft.entity.Selectable;
import gameframework.moves_rules.ObjectWithBoundedBox;

public class HouseStrategySelect extends MouseAdapter implements MouseMotionListener {
	private Point point;
	private Canvas canvas;
	private ArrayList<Selectable> house = new ArrayList<Selectable>();
	private int numberOfSelected;

	public HouseStrategySelect() {
		numberOfSelected = 0;

	}

	public void addUnit(Selectable h) {
		house.add(h);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			point = e.getPoint();
		System.out.println("click pressed");
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		if (numberOfSelected == 1)
			deselectUnits();
		else
			selectUnits();

		System.out.println("click released");
	}

	private void selectUnits() {
		Rectangle selection = new Rectangle();
		Point end = point;
		Point start = point;
		end.x = (int) (end.getX() + 15);
		end.y = (int) (end.getY() + 15);
		start.x = (int) (start.getX() - 15);
		start.y = (int) (start.getY() - 15);
		selection.setFrameFromDiagonal(start, end);

		if (selection.contains(((ObjectWithBoundedBox) house.get(0)).getBoundingBox())) {
			house.get(0).select();
			System.out.println("select " + house.get(0).hashCode());
			numberOfSelected++;
		}
	}

	private void deselectUnits() {
		house.get(0).deselect();
		numberOfSelected--;

	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

}
