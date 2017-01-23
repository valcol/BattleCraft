package battlecraft.entity.structure;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.entity.SpriteStore;
import gameframework.core.DrawableImage;

public class Castle extends StructureAbstract {
	protected DrawableImage image;
	protected Point position;
	public int RENDERING_SIZE = 32;
	public Rectangle BOUNDING_BOX;
	private int team;
	private int initialHealth = 10000;
	private int health = 10000;

	public Castle(Canvas defaultCanvas, Point position, String spritePath, Rectangle BOUNDING_BOX, int team) {
		super(defaultCanvas, position, spritePath, BOUNDING_BOX);
		this.image = SpriteStore.getInstance().getSprite(spritePath, defaultCanvas);
		this.position = position;
		this.BOUNDING_BOX = BOUNDING_BOX;
		this.team = team;
	}

	public void draw(Graphics g) {

		int totalLifeBarWidth = 30;
		int lifeBarWidth = (int) ((health * totalLifeBarWidth) / initialHealth);
		int x = (int) position.getX();
		int y = (int) position.getY() - 30;

		g.setColor(new Color(0, 0, 0));
		g.fillRect(x, y, totalLifeBarWidth, 3);

		if (team == 0)
			g.setColor(new Color(0, 250, 100));
		else
			g.setColor(new Color(198, 37, 37));

		g.fillRect(x, y, lifeBarWidth, 3);

		g.setColor(new Color(17, 95, 50));

		g.drawRect(x, y, totalLifeBarWidth, 3);

		g.drawImage(image.getImage(), (int) position.getX(), (int) position.getY(), RENDERING_SIZE, RENDERING_SIZE,
				null);
	}

	public void takeDamages(float damages) {
		this.health -= damages;
	}

	public int getTeam() {
		return team;
	}
}
