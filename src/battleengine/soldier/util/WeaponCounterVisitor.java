/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package battleengine.soldier.util;

import java.util.Iterator;

import battleengine.soldier.core.Unit;
import battleengine.soldier.core.UnitGroup;
import battleengine.soldier.core.UnitInfantry;
import battleengine.soldier.core.UnitRider;
import battleengine.soldier.core.UnitVisitor;
import battleengine.soldier.core.Weapon;
import battleengine.soldier.core.WeaponAttack;
import battleengine.soldier.core.WeaponDefense;
import battleengine.soldier.weapon.WeaponVisitor;

public class WeaponCounterVisitor implements UnitVisitor {
	public int attWeapon = 0;
	public int defWeapon = 0;

	WeaponVisitor weaponVisitor = new WeaponVisitor() {
		@Override
		public void visit(WeaponAttack s) {
			++attWeapon;
		}

		@Override
		public void visit(WeaponDefense s) {
			++defWeapon;
		}
	};

	public void clear() {
		attWeapon = 0;
		defWeapon = 0;
	}

	@Override
	public void visit(UnitGroup g) {
		for (Iterator<Unit> it = g.subUnits(); it.hasNext(); it.next().accept(
				this))
			;
	}

	@Override
	public void visit(UnitRider ur) {
		for (Iterator<Weapon> it = ur.getWeapons(); it.hasNext(); it.next()
				.accept(weaponVisitor))
			;
	}

	@Override
	public void visit(UnitInfantry ui) {
		for (Iterator<Weapon> it = ui.getWeapons(); it.hasNext(); it.next()
				.accept(weaponVisitor))
			;
	}

}