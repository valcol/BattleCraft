package battlecraft.strategy;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import battlecraft.Player;
import battlecraft.entity.Selectable;
import battlecraft.entity.structure.Barrack;
import gameframework.moves_rules.ObjectWithBoundedBox;

public class BarrackStrategy extends MouseAdapter implements MouseMotionListener {
	
		private Rectangle boundingBox;
	    private Barrack barrack;
	    private Rectangle boundingBoxBtnUpdate;
	    private Rectangle boundingBoxBtnAdd;
	    private Player player;

	    public BarrackStrategy(Barrack b, Player player) {
	    	barrack = b;
	        boundingBox = b.getBoundingBox();
	        boundingBoxBtnUpdate = b.getBoundingBoxBtnUpdate();
	        boundingBoxBtnAdd = b.getBoundingBoxBtnAdd();
	        this.player = player;
	    }


	    public boolean isOnBoundingBox(Point e, Rectangle boundingBox) {
	        Point unitPosition = barrack.getPos();
	        System.out.println(unitPosition.toString());
	        System.out.println(e.toString());
	        System.out.println(boundingBox.x);
	        System.out.println( e.getX() >= boundingBox.x );
	        return e.getX() >=  boundingBox.x 
	        	&& e.getY() >=  boundingBox.y
	            && e.getX() <=  boundingBox.x+boundingBox.width
	            && e.getY() <=  boundingBox.y+boundingBox.height;
	    }


	    @Override
	    public void mouseClicked(MouseEvent e) {
	        if (e.getButton() == MouseEvent.BUTTON1){
	        	System.out.println("clikkkkk");
		        if (isOnBoundingBox(e.getPoint(), boundingBox)) {
		        	System.out.println("ok");
		        	refreshBouttons();
		            barrack.select();
		        } else if (barrack.isSelected() && isOnBoundingBox(e.getPoint(), boundingBoxBtnUpdate) && barrack.isShowUpgardeBtn()) {
		            barrack.upgrade();
		            player.removeFromRessources(barrack.getCost().getUpgradeRessource(), barrack.getCost().getUpgradeCost());
		            refreshBouttons();
		        } else if (barrack.isSelected() && isOnBoundingBox(e.getPoint(), boundingBoxBtnAdd) && barrack.isShowAddBtn()) {
		            barrack.createUnit();
		            player.removeFromRessources(barrack.getCost().getAddRessource(), barrack.getCost().getAddCost());
		            refreshBouttons();
		        } else if (barrack.isSelected()) {
		        	barrack.deselect();
		        }
	        }
	    }
	    
	    public void refreshBouttons(){
        	barrack.setShowUpgardeBtn(player.getQuantityFromRessource(barrack.getCost().getUpgradeRessource()).getValue() 
        			>= barrack.getCost().getUpgradeCost());
        	barrack.setShowAddBtn(player.getQuantityFromRessource(barrack.getCost().getAddRessource()).getValue() 
        			>= barrack.getCost().getAddCost());
	    }

}