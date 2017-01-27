package battlecraft.entity.structure;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.Age;
import battlecraft.entity.SpriteStore;
import battlecraft.enums.Teams;
import gameframework.core.DrawableImage;

public class Castle extends StructureAbstract {
	protected DrawableImage imageb, imaget;
	protected Point position;
	public int RENDERING_SIZE = 32;
	public Rectangle BOUNDING_BOX;
	private int initialHealth = 10000;
	private int health = 10000;

	public Castle(Canvas defaultCanvas, Point position, String spritePathBottom, String spritePathTop, Rectangle BOUNDING_BOX, Teams team) {
		super(defaultCanvas, position, null, BOUNDING_BOX, team);
		this.imageb = SpriteStore.getInstance().getSprite(spritePathBottom, defaultCanvas);
		this.imaget = SpriteStore.getInstance().getSprite(spritePathTop, defaultCanvas);
		this.position = position;
		this.BOUNDING_BOX = BOUNDING_BOX;
	}

	public void draw(Graphics g) {

		int totalLifeBarWidth = 30;
		int lifeBarWidth = (int) ((health * totalLifeBarWidth) / initialHealth);
		int x = (int) position.getX();
		int y = (int) position.getY() - 30;

		g.setColor(new Color(0, 0, 0));
		g.fillRect(x, y, totalLifeBarWidth, 3);

		if (team == Teams.BLUE)
			g.setColor(new Color(0, 250, 100));
		else
			g.setColor(new Color(198, 37, 37));

		g.fillRect(x, y, lifeBarWidth, 3);

		g.setColor(new Color(17, 95, 50));

		g.drawRect(x, y, totalLifeBarWidth, 3);

		g.drawImage(imageb.getImage(), (int) position.getX(), (int) position.getY()-RENDERING_SIZE, RENDERING_SIZE,
				RENDERING_SIZE, null);
		g.drawImage(imaget.getImage(), (int) position.getX(), (int) position.getY(), RENDERING_SIZE,
				RENDERING_SIZE, null);
	}

	public void takeDamages(float damages) {
		this.health -= damages;
		
	}

	public Teams getTeam() {
		return team;
	}
	public int getHealth(){
		return this.health;
	}
}
