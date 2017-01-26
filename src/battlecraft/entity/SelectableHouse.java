package battlecraft.entity;

import java.awt.Canvas;

public interface SelectableHouse {
	void selectH();
	void deselectH();
	boolean isSelectedH();
	void createUnit(Canvas c);
}
