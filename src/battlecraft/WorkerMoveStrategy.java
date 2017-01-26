package battlecraft;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import battlecraft.entity.environment.Environment;
import battlecraft.entity.unit.Worker;
import gameframework.moves_rules.MoveStrategy;
import gameframework.moves_rules.SpeedVector;
import gameframework.moves_rules.SpeedVectorDefaultImpl;


public class WorkerMoveStrategy implements MoveStrategy {
	
	protected SpeedVector speedVector = new SpeedVectorDefaultImpl(new Point(0, 0));
	protected ArrayList<Environment> ressources;
	private Worker worker = null;
	private Rectangle boundingBox;

	public WorkerMoveStrategy(ArrayList<Environment> ressources, Worker w) {
		 this.ressources = ressources;
		 this.worker = w;
		 this.boundingBox = w.getBoundingBox();
	}

	public void setupVectorToGo() {
		
		if (!worker.isGathering()){
			
			Point wloc = worker.getPosition();
			
			double min_dist = Double.MAX_VALUE;
			Point nearestRessource = worker.getPosition();
			
			for (Environment ressource : ressources) {
				if (ressource.health == 100 && worker.getType() == ressource.getType()){
					Point rloc = ressource.getBoundingBox().getLocation();
					double dist = Point.distance(rloc.getX(), rloc.getY(), wloc.getX(), wloc.getY());
					
					if (dist < min_dist){
						min_dist = dist;
						nearestRessource = rloc;
					}
				}
			}
			
			int x = 0, y = 0;
			
			if (nearestRessource.getX() > wloc.getX() + boundingBox.getWidth()) {
				x = 1;
			} else if (nearestRessource.getX() < wloc.getX()) {
				x = -1;
			}

			if (nearestRessource.getY() > wloc.getY() + boundingBox.getHeight()) {
				y = 1;
			} else if (nearestRessource.getY() < wloc.getY()) {
				y = -1;
			}

			speedVector.setDirection(new Point(x, y));
		}
		else 
			speedVector.setDirection(new Point(0, 0));
	}
	
	public SpeedVector getSpeedVector() {
		setupVectorToGo();
		return speedVector;
	}
}