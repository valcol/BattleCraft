package battlecraft.entity.structure;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.entity.SpriteStore;
import battlecraft.entity.Utils;
import battlecraft.enums.Teams;
import gameframework.core.Drawable;
import gameframework.core.DrawableImage;
import gameframework.core.GameEntity;
import gameframework.moves_rules.MoveBlocker;
import sun.security.x509.IssuingDistributionPointExtension;

public abstract class StructureAbstract implements  Drawable, MoveBlocker, GameEntity  {
	protected DrawableImage image;
	protected Point position;
	public int RENDERING_SIZE = 32;
	public Rectangle BOUNDING_BOX;
	protected Teams team;

	public StructureAbstract(Canvas defaultCanvas, Point position, String spritePathMiddleAge, Rectangle BOUNDING_BOX, Teams team) {
		this.image = SpriteStore.getInstance().getSprite(spritePathMiddleAge, defaultCanvas);
		this.position = position;
		this.BOUNDING_BOX = BOUNDING_BOX;
		this.team = team;
	}

	public void draw(Graphics g) {
		g.drawImage(image.getImage(), (int)position.getX(), (int)position.getY(), RENDERING_SIZE, RENDERING_SIZE,
					null);
	}

	public Point getPos() {
		return (position);
	}

	public Rectangle getBoundingBox() {
		return Utils.computeBoundingBox(position ,BOUNDING_BOX, RENDERING_SIZE);
	}
}
