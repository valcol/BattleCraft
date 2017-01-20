package battlecraft;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import gameframework.core.GameMovable;
import gameframework.core.Movable;
import gameframework.moves_rules.MoveStrategy;
import gameframework.moves_rules.SpeedVector;
import gameframework.moves_rules.SpeedVectorDefaultImpl;

public class MoveStrategyStub implements MoveStrategy {

	protected SpeedVector speedVector = new SpeedVectorDefaultImpl(new Point(0, 0));
	private Rectangle boundingBox;
	private Movable unit;
	private Point destination;

	public MoveStrategyStub(GameMovable m) {
		unit = m;
		boundingBox = unit.getBoundingBox();
	}

	public SpeedVector getSpeedVector() {
		setupVectorToGo(destination);
		return speedVector;
	}

	public void setupVectorToGo(Point e) {
		if (e == null)
			return;

		Point unitPosition = unit.getPosition();
		int x = 0, y = 0;

		if (e.getX() > unitPosition.getX() + boundingBox.getWidth()) {
			x = 1;
		} else if (e.getX() < unitPosition.getX()) {
			x = -1;
		}

		if (e.getY() > unitPosition.getY() + boundingBox.getHeight()) {
			y = 1;
		} else if (e.getY() < unitPosition.getY()) {
			y = -1;
		}

		if (x == 0 && y == 0) {
			destination = null;
		}

		speedVector.setDirection(new Point(x, y));
	}

	public void setDestionation(Point e) {
		this.destination = e;
	}
}