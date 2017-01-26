package battlecraft.entity.unit;

import gameframework.core.Drawable;
import gameframework.core.DrawableImage;
import gameframework.core.GameEntity;
import gameframework.core.GameMovable;
import gameframework.core.Overlappable;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.Age;
import battlecraft.Teams;
import battlecraft.entity.Selectable;
import battlecraft.entity.SpriteStore;
import battlecraft.entity.Utils;
import battleengine.soldier.ages.AgeFutureFactory;
import battleengine.soldier.ages.AgeMiddleFactory;
import battleengine.soldier.core.AgeAbstractFactory;
import battleengine.soldier.core.Unit;
import battleengine.soldier.units.UnitCenturion;

public class Soldier extends GameMovable implements Drawable, GameEntity, Overlappable, Selectable {
	protected DrawableImage imageMA, imageSF;
	public static final int RENDERING_SIZE = 32;
	protected boolean movable = false;
	protected int timerHeal = 0;
	protected int timerCooldown = 0;
	public Rectangle BOUNDING_BOX;
	private boolean selected = false;
	private boolean combat = false;
	private Teams team;
	private int healPerSecond = 1;
	private int cooldown = 2;
	private Unit unit;
	private AgeAbstractFactory scifi;
	private AgeAbstractFactory middleAge;

	public Soldier(Canvas defaultCanvas, String imagePathMiddleAge, String imagePathScifi, Rectangle BOUNDING_BOX,
			Teams team, Point position) {
		this.imageMA = SpriteStore.getInstance().getSprite(imagePathMiddleAge, defaultCanvas);
		this.imageSF = SpriteStore.getInstance().getSprite(imagePathScifi, defaultCanvas);
		this.BOUNDING_BOX = BOUNDING_BOX;
		this.team = team;
		this.scifi = new AgeFutureFactory();
		this.middleAge = new AgeMiddleFactory();
		if (Age.AGE == "MiddleAge")
			this.unit = middleAge.infantryUnit("");
		if (Age.AGE == "Scifi")
			this.unit = scifi.infantryUnit("");
		this.setPosition(position);
	}

	public void draw(Graphics g) {

		int totalLifeBarWidth = 15;
		int lifeBarWidth = (int) ((unit.getHealthPoints() * totalLifeBarWidth) / unit.getInitialHealth());
		int x = (int) getPosition().getX();
		int y = (int) getPosition().getY() - 7;

		g.setColor(new Color(0, 0, 0));
		g.fillRect(x, y, totalLifeBarWidth, 3);

		if (team == Teams.BLUE)
			g.setColor(new Color(0, 250, 100));
		else
			g.setColor(new Color(198, 37, 37));

		g.fillRect(x, y, lifeBarWidth, 3);

		if (selected)
			g.setColor(new Color(255, 255, 255));
		else
			g.setColor(new Color(17, 95, 50));

		g.drawRect(x, y, totalLifeBarWidth, 3);

		if (Age.AGE == "MiddleAge")
			g.drawImage(imageMA.getImage(), (int) getPosition().getX() - RENDERING_SIZE / 4,
					(int) getPosition().getY() - RENDERING_SIZE / 4, RENDERING_SIZE, RENDERING_SIZE, null);
		if (Age.AGE == "Scifi") {
			g.drawImage(imageSF.getImage(), (int) getPosition().getX() - RENDERING_SIZE / 4,
					(int) getPosition().getY() - RENDERING_SIZE / 4, RENDERING_SIZE, RENDERING_SIZE, null);
		}
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		if (timerHeal >= 10) {
			heal(healPerSecond);
			timerHeal = 0;
		}
		timerHeal++;

		timerCooldown = (timerCooldown > 0) ? timerCooldown - 1 : 0;

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

	public Teams getTeam() {
		return team;
	}

	public void setTeam(Teams team) {
		this.team = team;
	}

	public boolean isCombat() {
		return combat;
	}

	public void setCombat(boolean combat) {
		this.combat = combat;
	}

	public boolean alive() {
		// TODO Auto-generated method stub
		return unit.alive();
	}

	public void heal(float point) {
		// TODO Auto-generated method stub
		unit.heal(point);
	}

	public float parry(float force) {
		// TODO Auto-generated method stub
		return unit.parry(force);
	}

	public float strike() {
		if (timerCooldown == 0) {
			timerCooldown = cooldown;
			return unit.strike();
		} else
			return 0;
	}

}
