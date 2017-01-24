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
	private int team = 0;
	private Unit unit;

	public Worker(Canvas defaultCanvas, String imagePath, Rectangle BOUNDING_BOX) {
		this.image = SpriteStore.getInstance().getSprite(imagePath, defaultCanvas);
		this.BOUNDING_BOX = BOUNDING_BOX;
		this.unit = new UnitCenturion("");
	}

	public void draw(Graphics g) {
		int totalLifeBarWidth = 5;
		int lifeBarWidth = (int) ((unit.getHealthPoints()*totalLifeBarWidth)/unit.getInitialHealth());
		int x = (int) getPosition().getX();
		int y = (int) getPosition().getY()-7;
		
		g.setColor(new Color(0,0,0));
		g.fillRect(x, y, totalLifeBarWidth, 3);
		
		if (team == 0)
			g.setColor(new Color(0,250,100));
		else
			g.setColor(new Color(198,37,37));
		
		g.fillRect(x,y, lifeBarWidth, 3);
		g.drawRect(x,y, totalLifeBarWidth, 3);

		g.drawImage(image.getImage(), (int) getPosition().getX() - RENDERING_SIZE / 4,
				(int) getPosition().getY() - RENDERING_SIZE / 4, RENDERING_SIZE, RENDERING_SIZE, null);
	}

	@Override
	public void oneStepMoveAddedBehavior() {

	}

	public Rectangle getBoundingBox() {
		return Utils.computeBoundingBox(getPosition(), BOUNDING_BOX, 32);
	}

	public int getTeam() {
		return team;
	}

	public void setTeam(int team) {
		this.team = team;
	}

}
