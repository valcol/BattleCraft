/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package battleengine.soldier.core;

import battleengine.soldier.weapon.WeaponVisitor;

public interface Weapon extends Cloneable {
	String getName();

	BehaviorSoldier createExtension(BehaviorSoldier s);

	void accept(WeaponVisitor v);

	Weapon clone();
}
