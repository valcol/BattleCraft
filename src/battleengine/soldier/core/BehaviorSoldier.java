/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Universit� Bordeaux.
 */
package battleengine.soldier.core;

public interface BehaviorSoldier {
	public float getHealthPoints();

	public boolean alive();

	public void heal();

	public float parry(float force);

	public float strike();
}
