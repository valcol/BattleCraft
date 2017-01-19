/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package battleengine.test;


import battleengine.soldier.ages.AgeFutureFactory;
import battleengine.soldier.ages.AgeMiddleFactory;
import battleengine.soldier.core.AgeAbstractFactory;
import battleengine.soldier.core.Unit;
import battleengine.soldier.core.UnitGroup;
import battleengine.soldier.core.UnitVisitor;
import battleengine.soldier.util.AddSimpleUnitObserver;
import battleengine.soldier.util.DeadUnitCounterObserver;
import battleengine.soldier.util.WeaponCounterVisitor;

public class MainFightTwoAges {

	public static Unit createTeam(AgeAbstractFactory fact, String prefix)  {
		UnitGroup sg = new UnitGroup(prefix + "Animals");
		UnitGroup bl  = new UnitGroup(prefix + "Worms");
		bl.addUnit(fact.infantryUnit(prefix + "nicky"));
		bl.addUnit(fact.infantryUnit(prefix + "tomy"));
		sg.addUnit(bl);
		bl.addEquipment(fact.attackWeapon());
		bl.addEquipment(fact.defenseWeapon());
		bl.addEquipment(fact.attackWeapon());
		UnitGroup pig = new UnitGroup(prefix + "Pigs");
		pig.addUnit(fact.riderUnit(prefix + "jenny"));
		pig.addUnit(fact.riderUnit(prefix + "kenny"));
		sg.addUnit(pig);
		pig.addEquipment(fact.defenseWeapon());
		pig.addEquipment(fact.defenseWeapon());
		pig.addEquipment(fact.attackWeapon());
		return sg;
	}
	
	public static void main(String[] args) {
		
		AgeAbstractFactory age1 = new AgeMiddleFactory();
		AgeAbstractFactory age2 = new AgeFutureFactory();

		Unit team1 = createTeam(age1, "Team1::"); 
		Unit team2 = createTeam(age2, "Team2::"); 
		
		UnitVisitor visitor = new AddSimpleUnitObserver(new DeadUnitCounterObserver());

		team1.accept(visitor);
		team2.accept(visitor);

		WeaponCounterVisitor c1 = new WeaponCounterVisitor();
		team1.accept(c1);
		System.out.println(team1.getName() + " has got " + c1.attWeapon + " attack weapons and "  + c1.defWeapon + " defense weapon");
		c1.clear();
		team2.accept(c1);
		System.out.println(team2.getName() + " has got " + c1.attWeapon + " attack weapons and "  + c1.defWeapon + " defense weapon");
		
		int round = 0;
		while(team1.alive() && team2.alive()) {
			System.out.println("Round  #" + round++);
			float st1 = team1.strike();
			System.out.println(team1.getName() + " attack with force : " + st1);
			team2.parry(st1);
			float st2 = team2.strike();
			System.out.println(team2.getName() + " attack with force : " + st2);
			team1.parry(st2);
		}
		System.out.println("The end ... " + (team1.alive() ? team1.getName() : team2.getName()) + " won." );
	}

}
