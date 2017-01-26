package battlecraft.entity.unit;

import gameframework.core.Drawable;
import gameframework.core.DrawableImage;
import gameframework.core.GameEntity;
import gameframework.core.GameMovable;
import gameframework.core.Overlappable;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import battlecraft.Ressources;
import battlecraft.entity.SpriteStore;
import battlecraft.entity.Utils;
import battleengine.soldier.core.Unit;
import battleengine.soldier.units.UnitCenturion;

public class Worker extends GameMovable implements Drawable, GameEntity, Overlappable {
	protected DrawableImage image;
	public static final int RENDERING_SIZE = 32;
	protected boolean movable = false;
	protected int timerCooldown = 0;
	public Rectangle BOUNDING_BOX;
	private int cooldown = 2;
	private int strenght = 3;
	private Ressources type;
	private boolean isGathering = false;

	public Worker(Canvas defaultCanvas, String imagePath, Rectangle BOUNDING_BOX, Ressources type) {
		this.image = SpriteStore.getInstance().getSprite(imagePath, defaultCanvas);
		this.BOUNDING_BOX = BOUNDING_BOX;
		this.type = type;
	}

	public void draw(Graphics g) {
		int totalLifeBarWidth = 5;
		int lifeBarWidth = (int) ((10*totalLifeBarWidth)/10);
		int x = (int) getPosition().getX();
		int y = (int) getPosition().getY()-7;
		
		g.setColor(new Color(0,0,0));
		g.fillRect(x, y, totalLifeBarWidth, 3);
		
		g.setColor(new Color(198,37,37));
		
		g.fillRect(x,y, lifeBarWidth, 3);
		g.drawRect(x,y, totalLifeBarWidth, 3);

		g.drawImage(image.getImage(), (int) getPosition().getX() - RENDERING_SIZE / 4,
				(int) getPosition().getY() - RENDERING_SIZE / 4, RENDERING_SIZE, RENDERING_SIZE, null);
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		timerCooldown = (timerCooldown > 0) ? timerCooldown-1 : 0;
	}

	public Rectangle getBoundingBox() {
		return Utils.computeBoundingBox(getPosition(), BOUNDING_BOX, 32);
	}
	
	public float gather() {
		if (timerCooldown == 0){
			timerCooldown = cooldown;
			return strenght;
		}
		else
			return 0;
	}

	public Ressources getType() {
		return type;
	}

	public void setType(Ressources type) {
		this.type = type;
	}

	public boolean isGathering() {
		return isGathering;
	}

	public void setGathering(boolean isGathering) {
		this.isGathering = isGathering;
	}
	

}
