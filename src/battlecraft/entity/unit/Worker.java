package battlecraft.entity.unit;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.entity.SpriteStore;
import battlecraft.entity.Upgradable;
import battlecraft.entity.Utils;
import battlecraft.enums.Ressources;
import battlecraft.enums.Teams;
import gameframework.core.Drawable;
import gameframework.core.DrawableImage;
import gameframework.core.GameEntity;
import gameframework.core.GameMovable;
import gameframework.core.Overlappable;

public class Worker extends GameMovable implements Drawable, GameEntity, Overlappable, Upgradable {
	protected DrawableImage imageMA, imageSF;
	public static final int RENDERING_SIZE = 32;
	protected boolean movable = false;
	protected int timerCooldown = 0;
	public Rectangle BOUNDING_BOX;
	private int cooldown = 5;
	private int strenght = 3;
	private Ressources type;
	private boolean isGathering = false;
	private Teams team;
	private boolean isUpgraded = false;

	public Worker(Canvas defaultCanvas, String imagePathMiddleAge, String imagePathScifi, Rectangle BOUNDING_BOX,
			Ressources type, Point position, Teams team) {
		this.imageMA = SpriteStore.getInstance().getSprite(imagePathMiddleAge, defaultCanvas);
		this.imageSF = SpriteStore.getInstance().getSprite(imagePathScifi, defaultCanvas);
		this.BOUNDING_BOX = BOUNDING_BOX;
		this.type = type;
		this.setPosition(position);
		this.team = team;
	}

	public void draw(Graphics g) {
		int totalLifeBarWidth = 5;
		int lifeBarWidth = (int) ((10 * totalLifeBarWidth) / 10);
		int x = (int) getPosition().getX();
		int y = (int) getPosition().getY() - 7;

		g.setColor(new Color(0, 0, 0));
		g.fillRect(x, y, totalLifeBarWidth, 3);

		g.setColor(new Color(198, 37, 37));

		g.fillRect(x, y, lifeBarWidth, 3);
		g.drawRect(x, y, totalLifeBarWidth, 3);

		if (!isUpgraded)
			g.drawImage(imageMA.getImage(), (int) getPosition().getX() - RENDERING_SIZE / 4,
					(int) getPosition().getY() - RENDERING_SIZE / 4, RENDERING_SIZE, RENDERING_SIZE, null);
		else
			g.drawImage(imageSF.getImage(), (int) getPosition().getX() - RENDERING_SIZE / 4,
					(int) getPosition().getY() - RENDERING_SIZE / 4, RENDERING_SIZE, RENDERING_SIZE, null);
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		timerCooldown = (timerCooldown > 0) ? timerCooldown - 1 : 0;
	}

	public Rectangle getBoundingBox() {
		return Utils.computeBoundingBox(getPosition(), BOUNDING_BOX, 32);
	}

	public float gather() {
		if (timerCooldown == 0) {
			timerCooldown = cooldown;
			return strenght;
		} else
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

	public Teams getTeam() {
		return team;
	}

	public void setTeam(Teams team) {
		this.team = team;
	}

	@Override
	public void upgrade() {
		cooldown = 7;
		strenght = 10;
	}

	@Override
	public boolean isUpgraded() {
		return isUpgraded;
	}
	
	

}
