package battlecraft.entity.structure;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.entity.SelectableHouse;
import battlecraft.entity.unit.IUnitFactory;
import battlecraft.entity.unit.UnitFactory;
import gameframework.core.GameEntity;

public abstract class House extends StructureAbstract implements SelectableHouse{
	private boolean selected = false;
	private IUnitFactory unit= new UnitFactory();
	public House(Canvas defaultCanvas, Point position, String spritePath, Rectangle BOUNDING_BOX) {
		super(defaultCanvas, position, spritePath, BOUNDING_BOX);
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

	public GameEntity createSoldier(Canvas defaultCanvas) {
		return unit.createSoldier(defaultCanvas);
	}
	
	public GameEntity createWorker(Canvas defaultCanvas) {
		return unit.createWorker(defaultCanvas);
	}
}
