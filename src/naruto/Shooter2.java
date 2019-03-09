/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naruto;

import city.cs.engine.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.jbox2d.common.Vec2;
import java.awt.Component;
import java.awt.Point;


/**
 * A MouseListener that shoots a grenade on each mouse press.
 */
public class Shooter2 extends MouseAdapter {

    private GameLevel world;

    /**
     * Construct a listener.
     * @param world the world in which the listener will be implemented
     */
    public Shooter2(GameLevel world) {
        this.world = world;
    }

    /**
     * Create a grenade at the current mouse position and throw it.
     * @param e event object containing the mouse position
     */
    @Override
    public void mousePressed(MouseEvent e) {
        Grenade projectile = new Grenade(world);
        projectile.setGravityScale(1);
        projectile.setPosition(new Vec2(world.getPlayer().getPosition().x, world.getPlayer().getPosition().y+1.5f));
        if(world.getPlayer().getPosition().x<world.getGame().getView().viewToWorld(e.getPoint()).x){
            projectile.setLinearVelocity(new Vec2(4,8));
        } else {
            projectile.setLinearVelocity(new Vec2(-4,8));
        }
        projectile.applyTorque(20);
    }

}
