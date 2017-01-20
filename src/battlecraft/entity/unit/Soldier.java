package battlecraft.entity.unit;

import gameframework.core.Drawable;
import gameframework.core.DrawableImage;
import gameframework.core.GameEntity;
import gameframework.core.GameMovable;
import gameframework.core.Overlappable;
import gameframework.core.SpriteManager;
import gameframework.core.SpriteManagerDefaultImpl;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.entity.Selectable;
import battlecraft.entity.SpriteStore;
import battlecraft.entity.Utils;

public class Soldier extends GameMovable implements Drawable, GameEntity,
		Overlappable, Selectable {
	protected DrawableImage image;
	public static final int RENDERING_SIZE = 32;
	protected boolean movable = false;
	protected boolean vulnerable = false;
	protected int vulnerableTimer = 0;
	public Rectangle BOUNDING_BOX;
	private boolean selected = false;

	public Soldier(Canvas defaultCanvas, String imagePath, Rectangle BOUNDING_BOX) {
		this.image = SpriteStore.getInstance().getSprite(imagePath, defaultCanvas);
		this.BOUNDING_BOX = BOUNDING_BOX;
	}

	public void setInvulnerable(int timer) {
		vulnerableTimer = timer;
	}

	public boolean isVulnerable() {
		return (vulnerableTimer <= 0);
	}

	public void draw(Graphics g) {
		String spriteType = "";
		Point tmp = getSpeedVector().getDirection();
		movable = true;
		if (!isVulnerable()) {
			spriteType += "invulnerable-";
		}

		if (tmp.getX() == 1) {
			spriteType += "right";
		} else if (tmp.getX() == -1) {
			spriteType += "left";
		} else if (tmp.getY() == 1) {
			spriteType += "down";
		} else if (tmp.getY() == -1) {
			spriteType += "up";
		} else {
			movable = false;
		}
		g.drawImage(image.getImage(), (int) getPosition().getX()-RENDERING_SIZE/4,
				(int) getPosition().getY()-RENDERING_SIZE/4, RENDERING_SIZE, RENDERING_SIZE,
				null);
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		if (movable) {
			if (!isVulnerable()) {
				vulnerableTimer--;
			}
		}
	}

	public Rectangle getBoundingBox() {
		return Utils.computeBoundingBox(getPosition(), BOUNDING_BOX, 32);
	}

	@Override
	public void select() {
		this.selected = true;
	}

	@Override
	public void deselect() {
		this.selected = false;
	}

	@Override
	public boolean isSelected() {
		return selected;
	}
}
