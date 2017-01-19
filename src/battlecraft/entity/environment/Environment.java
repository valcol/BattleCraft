package battlecraft.entity.environment;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;

import battlecraft.entity.SpriteStore;
import gameframework.core.Drawable;
import gameframework.core.DrawableImage;
import gameframework.core.GameEntity;

public class Environment implements Drawable, GameEntity {
	protected DrawableImage image;
	protected Point position;
	public int RENDERING_SIZE = 32;

	public Environment(Canvas defaultCanvas, Point position, String spritePath) {
		this.image = SpriteStore.getInstance().getSprite(spritePath, defaultCanvas);
		this.position = position;
	}

	public void draw(Graphics g) {
		g.drawImage(image.getImage(), (int) position.getX(), (int) position.getY(), RENDERING_SIZE, RENDERING_SIZE,
				null);
	}

	public Point getPos() {
		return (position);
	}

}
