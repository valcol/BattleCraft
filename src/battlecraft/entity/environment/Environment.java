package battlecraft.entity.environment;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.entity.SpriteStore;
import battlecraft.entity.Utils;
import battlecraft.enums.Ressources;
import gameframework.core.Drawable;
import gameframework.core.DrawableImage;
import gameframework.core.GameEntity;
import gameframework.core.GameMovable;
import gameframework.core.Overlappable;

public class Environment extends GameMovable implements Drawable, GameEntity, Overlappable {
	protected DrawableImage imageFull;
	protected DrawableImage imageEmpty;
	protected Point position;
	public int RENDERING_SIZE = 32;
	protected Ressources type;
	public int health = 100;
	public int timer = 0;
	public Rectangle BOUNDING_BOX;
	

	public Environment(Canvas defaultCanvas, Point position, String spriteFullPath, String spriteEmptyPath,
			Rectangle BOUNDING_BOX, Ressources type) {
		this.imageFull = SpriteStore.getInstance().getSprite(spriteFullPath, defaultCanvas);
		this.imageEmpty = SpriteStore.getInstance().getSprite(spriteEmptyPath, defaultCanvas);
		this.BOUNDING_BOX = BOUNDING_BOX;
		this.position = position;
		this.type = type;
	}

	public void draw(Graphics g) {
		if (health>0)
			g.drawImage(imageFull.getImage(), (int) position.getX(), (int) position.getY(), RENDERING_SIZE, RENDERING_SIZE,
				null);
		else 
			g.drawImage(imageEmpty.getImage(), (int) position.getX(), (int) position.getY(), RENDERING_SIZE, RENDERING_SIZE,
					null);
	}

	public Point getPos() {
		return (position);
	}

	@Override
	public Rectangle getBoundingBox() {
		return Utils.computeBoundingBox(getPosition(), BOUNDING_BOX, 32);
	}

	@Override
	public Point getPosition() {
		return position;
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		if (health <= 0){
			timer++;
		}
		if (timer > 100){
			health = 100;
			timer = 0;
		}
	}
	
	public void takeDamages(float damages) {
		this.health -= damages;
	}

	public Ressources getType() {
		return type;
	}

	public void setType(Ressources type) {
		this.type = type;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	

}
