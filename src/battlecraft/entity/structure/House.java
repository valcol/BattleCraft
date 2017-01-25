package battlecraft.entity.structure;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.Teams;
import battlecraft.entity.SelectableHouse;
import battlecraft.entity.unit.IUnitFactory;
import battlecraft.entity.unit.UnitFactory;
import gameframework.core.GameEntity;

public abstract class House extends StructureAbstract implements SelectableHouse{
	private boolean selected = false;
	protected IUnitFactory unit;
	public House(Canvas defaultCanvas, Point position, String spritePath, Rectangle BOUNDING_BOX, Teams team) {
		super(defaultCanvas, position, spritePath, BOUNDING_BOX);
		unit = new UnitFactory(team);
	}

	@Override
	public void selectH() {
		this.selected = true;
	}

	@Override
	public void deselectH() {
		this.selected = false;
	}

	@Override
	public boolean isSelectedH() {
		return selected;
	}
}
