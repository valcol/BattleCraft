/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package battleengine.soldier.ages;

import battleengine.soldier.core.AgeAbstractFactory;
import battleengine.soldier.core.Unit;
import battleengine.soldier.core.Weapon;
import battleengine.soldier.units.UnitCenturion;
import battleengine.soldier.units.UnitHorseMan;
import battleengine.soldier.weapon.WeaponShield;
import battleengine.soldier.weapon.WeaponSword;

public class AgeMiddleFactory implements AgeAbstractFactory {

	@Override
	public Unit infantryUnit(String name) {
		return new UnitCenturion(name);
	}

	@Override
	public Unit riderUnit(String name) {
		return new UnitHorseMan(name);
	}

	@Override
	public Weapon attackWeapon() {
		return new WeaponSword();
	}

	@Override
	public Weapon defenseWeapon() {
		return new WeaponShield();
	}
}
