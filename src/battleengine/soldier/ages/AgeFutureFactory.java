/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package battleengine.soldier.ages;

import battleengine.soldier.core.AgeAbstractFactory;
import battleengine.soldier.core.Unit;
import battleengine.soldier.core.Weapon;
import battleengine.soldier.units.UnitBikerMan;
import battleengine.soldier.units.UnitRobot;
import battleengine.soldier.weapon.WeaponGun;
import battleengine.soldier.weapon.WeaponShield;

public class AgeFutureFactory implements AgeAbstractFactory {

	@Override
	public Unit infantryUnit(String name) {
		return new UnitRobot(name);
	}

	@Override
	public Unit riderUnit(String name) {
		return new UnitBikerMan(name);
	}

	@Override
	public Weapon attackWeapon() {
		return new WeaponGun();
	}

	@Override
	public Weapon defenseWeapon() {
		return new WeaponShield();
	}
}
