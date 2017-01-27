package battlecraft.entity.structure;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import battlecraft.Age;
import battlecraft.entity.Selectable;
import battlecraft.entity.SpriteStore;
import battlecraft.entity.Upgradable;
import battlecraft.entity.Utils;
import battlecraft.entity.unit.IUnitFactory;
import battlecraft.entity.unit.MiddleAgeUnitFactory;
import battlecraft.entity.unit.ScifiUnitFactory;
import battlecraft.enums.Ressources;
import battlecraft.enums.Teams;
import gameframework.core.DrawableImage;

public abstract class Barrack extends StructureAbstract implements Selectable, Upgradable {
	private boolean selected = false;
	protected IUnitFactory unit;
	protected boolean showUpgardeBtn = false;
	protected boolean showAddBtn = false;
	protected boolean isUpgraded = false;
	protected DrawableImage imageSF;
	protected DrawableImage btnAdd;
	protected DrawableImage btnAddg;
	protected DrawableImage btnUpdate;
	protected DrawableImage btnUpdateg;
	
	protected BarrackCosts cost = new BarrackCosts(Ressources.WOOD, 0, Ressources.WOOD, 0); 
	
	Canvas defaultCanvas;

	public Barrack(Canvas defaultCanvas, Point position, String spritePathMiddleAge, String spritePathScifi,
			Rectangle BOUNDING_BOX, Teams team, BarrackCosts cost) {
		super(defaultCanvas, position, spritePathMiddleAge, BOUNDING_BOX, team);
		unit = new MiddleAgeUnitFactory(team);
		this.btnAdd = SpriteStore.getInstance().getSprite("images/btn_add.png", defaultCanvas);
		this.btnAddg = SpriteStore.getInstance().getSprite("images/btn_addg.png", defaultCanvas);
		this.btnUpdate = SpriteStore.getInstance().getSprite("images/btn_update.png", defaultCanvas);
		this.btnUpdateg = SpriteStore.getInstance().getSprite("images/btn_updateg.png", defaultCanvas);
		this.imageSF = SpriteStore.getInstance().getSprite(spritePathScifi, defaultCanvas);
		this.defaultCanvas = defaultCanvas;
		this.cost = cost;
	}

	@Override
	public void select() {
		this.selected = true;
	}

	@Override
	public void deselect() {
		this.selected = false;
	}

	@Override
	public boolean isSelected() {
		return selected;
	}
	
	@Override
	public void upgrade() {
		unit = new ScifiUnitFactory(team);	
		isUpgraded = true;
	}

	
	@Override
	public void draw(Graphics g) {
		if (!isUpgraded)
			g.drawImage(image.getImage(), (int)position.getX(), (int)position.getY(), RENDERING_SIZE, RENDERING_SIZE,
				null);
		else
			g.drawImage(imageSF.getImage(), (int)position.getX(), (int)position.getY(), RENDERING_SIZE, RENDERING_SIZE,
					null);
		
		if (selected){
			if (showAddBtn)
				g.drawImage(btnAdd.getImage(), (int)position.getX()+20, (int)position.getY()+7, RENDERING_SIZE, RENDERING_SIZE,
					null);
			else
				g.drawImage(btnAddg.getImage(), (int)position.getX()+20, (int)position.getY()+7, RENDERING_SIZE, RENDERING_SIZE,
						null);
			
			if (showUpgardeBtn)
				g.drawImage(btnUpdate.getImage(), (int)position.getX()+20, (int)position.getY()-7, RENDERING_SIZE, RENDERING_SIZE,
					null);
			else
				g.drawImage(btnUpdateg.getImage(), (int)position.getX()+20, (int)position.getY()-7, RENDERING_SIZE, RENDERING_SIZE,
						null);
		}
	}
	
	public boolean isUpgraded(){
		return isUpgraded;
	}

	public void setShowUpgardeBtn(boolean showUpgardeBtn) {
		this.showUpgardeBtn = showUpgardeBtn;
	}

	public boolean isShowAddBtn() {
		return showAddBtn;
	}

	public void setShowAddBtn(boolean showAddBtn) {
		this.showAddBtn = showAddBtn;
	}

	public boolean isShowUpgardeBtn() {
		return showUpgardeBtn;
	}

	public void createUnit() {
		// TODO Auto-generated method stub
		
	}

	public Rectangle getBoundingBoxBtnUpdate() {
		Rectangle bb = Utils.computeBoundingBox(new Point((int)position.getX()+20, (int)position.getY()-7) ,
				new Rectangle(30,30,30,30), RENDERING_SIZE);
		return bb;
	}
	
	public Rectangle getBoundingBoxBtnAdd() {
		Rectangle bb = Utils.computeBoundingBox(new Point((int)position.getX()+20, (int)position.getY()+7) ,
				new Rectangle(30,30,30,30), RENDERING_SIZE);
		return bb;
	}
	
	public BarrackCosts getCost(){
		return cost;
	}
	
	
}
