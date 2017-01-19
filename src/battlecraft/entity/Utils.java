package battlecraft.entity;

import java.awt.Point;
import java.awt.Rectangle;

public class Utils {
	
	public static Rectangle computeBoundingBox(Point position, Rectangle BOUNDING_BOX, int RENDERING_SIZE){
		return (new Rectangle((int)position.getX()+(BOUNDING_BOX.x*RENDERING_SIZE),
				(int)position.getY()+(BOUNDING_BOX.y*RENDERING_SIZE), BOUNDING_BOX.width*RENDERING_SIZE, BOUNDING_BOX.height*RENDERING_SIZE));
	}

}
