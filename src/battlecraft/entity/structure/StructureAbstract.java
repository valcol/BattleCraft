package battlecraft.entity.structure;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.Age;
import battlecraft.entity.SpriteStore;
import battlecraft.entity.Utils;
import gameframework.core.Drawable;
import gameframework.core.DrawableImage;
import gameframework.core.GameEntity;
import gameframework.moves_rules.MoveBlocker;

public abstract class StructureAbstract implements  Drawable, MoveBlocker, GameEntity  {
	protected DrawableImage imageMA, imageSF;
	protected Point position;
	public int RENDERING_SIZE = 32;
	public Rectangle BOUNDING_BOX;

	public StructureAbstract(Canvas defaultCanvas, Point position, String spritePathMiddleAge, String spritePathScifi, Rectangle BOUNDING_BOX) {
		this.imageMA = SpriteStore.getInstance().getSprite(spritePathMiddleAge, defaultCanvas);
		this.imageSF = SpriteStore.getInstance().getSprite(spritePathScifi, defaultCanvas);
		this.position = position;
		this.BOUNDING_BOX = BOUNDING_BOX;
	}

	public void draw(Graphics g) {
		if (Age.AGE == "MiddleAge")
		g.drawImage(imageMA.getImage(), (int)position.getX(), (int)position.getY(), RENDERING_SIZE, RENDERING_SIZE,
				null);
		if (Age.AGE == "Scifi")
			g.drawImage(imageSF.getImage(), (int)position.getX(), (int)position.getY(), RENDERING_SIZE, RENDERING_SIZE,
					null);
	}

	public Point getPos() {
		return (position);
	}

	public Rectangle getBoundingBox() {
		return Utils.computeBoundingBox(position ,BOUNDING_BOX, RENDERING_SIZE);
	}
}
