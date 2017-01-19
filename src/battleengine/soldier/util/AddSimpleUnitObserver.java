/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package battleengine.soldier.util;

import java.util.Iterator;

import battleengine.observer_util.Observer;
import battleengine.soldier.core.Unit;
import battleengine.soldier.core.UnitGroup;
import battleengine.soldier.core.UnitInfantry;
import battleengine.soldier.core.UnitRider;
import battleengine.soldier.core.UnitVisitor;

public class AddSimpleUnitObserver implements UnitVisitor {
	Observer<Unit> obs;

	public AddSimpleUnitObserver(Observer<Unit> obs) {
		this.obs = obs;
	}

	@Override
	public void visit(UnitGroup g) {
		for (Iterator<Unit> it = g.subUnits(); it.hasNext(); it.next().accept(
				this))
			;
	}

	@Override
	public void visit(UnitRider ur) {
		if (ur.alive())
			ur.addObserver(obs);
	}

	@Override
	public void visit(UnitInfantry ui) {
		if (ui.alive())
			ui.addObserver(obs);
	}
}