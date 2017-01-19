package battlecraft.entity;

import battlecraft.entity.environment.IEnvironmentFactory;
import battlecraft.entity.structure.IStructureFactory;
import battlecraft.entity.tile.ITileFactory;
import battlecraft.entity.tile.TileFactory;
import battlecraft.entity.unit.IUnitFactory;

public abstract class AbstractAgeFactory implements IEnvironmentFactory, ITileFactory {
	
	public IEnvironmentFactory efactory;
	public ITileFactory tfactory;
	public IStructureFactory sfactory;
	public IUnitFactory ufactory;
	
	public AbstractAgeFactory(String path) {
		super();
		tfactory = new TileFactory(path);
	}
}
