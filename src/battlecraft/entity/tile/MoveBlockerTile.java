package battlecraft.entity.tile;

import gameframework.core.Drawable;
import gameframework.core.DrawableImage;
import gameframework.core.GameEntity;
import gameframework.moves_rules.MoveBlocker;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.entity.SpriteStore;
import battlecraft.entity.Utils;

public class MoveBlockerTile implements Drawable, MoveBlocker, GameEntity {
	protected DrawableImage image;
	protected Point position;
	public int RENDERING_SIZE = 32;
	public Rectangle BOUNDING_BOX;

	public MoveBlockerTile(Canvas defaultCanvas, Point position, String spritePath, Rectangle BOUNDING_BOX) {
		this.image = SpriteStore.getInstance().getSprite(spritePath, defaultCanvas);
		this.position = position;
		this.BOUNDING_BOX = BOUNDING_BOX;
	}

	public void draw(Graphics g) {
		g.drawImage(image.getImage(), (int)position.getX(), (int)position.getY(), RENDERING_SIZE, RENDERING_SIZE,
				null);
	}

	public Point getPos() {
		return (position);
	}

	public Rectangle getBoundingBox() {
		return Utils.computeBoundingBox(position ,BOUNDING_BOX, RENDERING_SIZE);
	}
}
