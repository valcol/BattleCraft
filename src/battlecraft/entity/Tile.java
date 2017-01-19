package battlecraft.entity;

import gameframework.core.Drawable;
import gameframework.core.DrawableImage;
import gameframework.core.GameEntity;
import gameframework.moves_rules.MoveBlocker;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Tile implements Drawable, MoveBlocker, GameEntity {
	protected DrawableImage image;
	protected Point position;
	public int RENDERING_SIZE = 32;
	boolean solid;

	public Tile(Canvas defaultCanvas, Point position, String spritePath, boolean solid) {
		this.image = SpriteStore.getInstance().getSprite(spritePath, defaultCanvas);
		this.position = position;
		this.solid = solid;
	}

	public void draw(Graphics g) {
		g.drawImage(image.getImage(), (int)position.getX(), (int)position.getY(), RENDERING_SIZE, RENDERING_SIZE,
				null);
	}

	public Point getPos() {
		return (position);
	}

	public Rectangle getBoundingBox() {
		if (solid)
			return (new Rectangle((int)position.getX(), (int)position.getY(), RENDERING_SIZE, RENDERING_SIZE));
		else
			return (new Rectangle(0, 0, 0, 0));
	}
}
