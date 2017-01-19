/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package battleengine.soldier.weapon;

import battleengine.soldier.core.WeaponAttack;
import battleengine.soldier.core.WeaponDefense;

public interface WeaponVisitor {
	void visit(WeaponAttack s);

	void visit(WeaponDefense s);
}
