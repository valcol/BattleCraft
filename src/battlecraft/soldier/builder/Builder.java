package battlecraft.soldier.builder;

import gameframework.core.GameEntity;

public interface Builder {
	public void createSoldier();
	public void createGameMovableDriver();
	public void createMoveStrategy();
	public void addSelectable();
	public GameEntity getResult();
}
