package battlecraft.entity;

import java.awt.Point;
import java.awt.Rectangle;

public class Utils {
	
	public static Rectangle computeBoundingBox(Point position, Rectangle BOUNDING_BOX, int RENDERING_SIZE){
		System.out.println(BOUNDING_BOX.getHeight());
		return new Rectangle(
				(int)(position.getX()+((BOUNDING_BOX.x/100)*RENDERING_SIZE)),
				(int)(position.getY()+((BOUNDING_BOX.y/100)*RENDERING_SIZE)),
				(int)(BOUNDING_BOX.getWidth()*0.01*RENDERING_SIZE),
				(int)(BOUNDING_BOX.getHeight()*0.01*RENDERING_SIZE)
				);

	}
	
	public static Rectangle computeBotundingBox(Point position, Rectangle BOUNDING_BOX, int RENDERING_SIZE){
		return new Rectangle(
				(int)(position.getX()+RENDERING_SIZE*0.2),
				(int)(position.getY()+RENDERING_SIZE*0.2),
				(int)(RENDERING_SIZE/2),
				(int)(RENDERING_SIZE/2)
				);
	}

}
