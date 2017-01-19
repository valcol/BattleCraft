package battlecraft.entity.tile;

import gameframework.core.Drawable;
import gameframework.core.DrawableImage;
import gameframework.core.GameEntity;
import gameframework.moves_rules.MoveBlocker;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.entity.SpriteStore;
import battlecraft.entity.Utils;

public class Tile implements Drawable, GameEntity {
	protected DrawableImage image;
	protected Point position;
	public int RENDERING_SIZE = 32;

	public Tile(Canvas defaultCanvas, Point position, String spritePath) {
		this.image = SpriteStore.getInstance().getSprite(spritePath, defaultCanvas);
		this.position = position;
	}

	public void draw(Graphics g) {
		g.drawImage(image.getImage(), (int)position.getX(), (int)position.getY(), RENDERING_SIZE, RENDERING_SIZE,
				null);
	}

	public Point getPos() {
		return (position);
	}
}
