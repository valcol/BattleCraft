package battlecraft.entity;

import java.awt.Canvas;

import gameframework.core.GameEntity;

public interface SelectableHouse {
	void selectH();
	void deselectH();
	boolean isSelectedH();
	GameEntity createSoldier(Canvas c);
}
