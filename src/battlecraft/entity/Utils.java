package battlecraft.entity;

import java.awt.Point;
import java.awt.Rectangle;

public class Utils {
	
	public static Rectangle computeBoundingBox(Point position, Rectangle BOUNDING_BOX, int RENDERING_SIZE){
		return new Rectangle(
				(int)(position.getX()+((BOUNDING_BOX.x*0.01)*RENDERING_SIZE)),
				(int)(position.getY()+((BOUNDING_BOX.y*0.01)*RENDERING_SIZE)),
				(int)(BOUNDING_BOX.getWidth()*0.01*RENDERING_SIZE),
				(int)(BOUNDING_BOX.getHeight()*0.01*RENDERING_SIZE)
				);

	}

}
