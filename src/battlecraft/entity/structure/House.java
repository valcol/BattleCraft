package battlecraft.entity.structure;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.entity.Selectable;

public class House extends StructureAbstract implements Selectable {
	private boolean selected = false;

	public House(Canvas defaultCanvas, Point position, String spritePath, Rectangle BOUNDING_BOX) {
		super(defaultCanvas, position, spritePath, BOUNDING_BOX);
	}

	@Override
	public void select() {
		this.selected = true;
	}

	@Override
	public void deselect() {
		this.selected = false;
	}

	@Override
	public boolean isSelected() {
		return selected;
	}

}
