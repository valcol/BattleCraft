package battlecraft.entity.structure;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.core.Drawable;
import gameframework.core.DrawableImage;
import gameframework.core.GameEntity;
import gameframework.moves_rules.MoveBlocker;

public class House implements Drawable, MoveBlocker, GameEntity {
	protected static DrawableImage image = null;
	protected Point position;

	public static final int RENDERING_SIZE = 16;
	public static final int BOUDING_SIZE = 16;

	public House(Canvas defaultCanvas, Point point) {
		image = new DrawableImage("images/Medieval/Environment/8.png", defaultCanvas);
		position = point;
	}


	public Point getPosition() {
		return position;
	}

	public void draw(Graphics g) {
		g.drawImage(image.getImage(), (int) getPosition().getX(),
				(int) getPosition().getY(), RENDERING_SIZE, RENDERING_SIZE,
				null);

	}

	public Rectangle getBoundingBox() {
		return (new Rectangle((int) position.getX(), (int) position.getY(),
				RENDERING_SIZE, RENDERING_SIZE));
	}

}
