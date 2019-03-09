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
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 * A MouseListener that shoots a bullet on each mouse press.
 */
public class Shooter extends MouseAdapter {

    private GameLevel world;
    private SoundClip sound;

    /**
     * Construct a listener.
     * @param world the world in which the listener will be implemented
     */
    public Shooter(GameLevel world) {
        this.world = world;
    }

    /**
     * Create a bullet at the current mouse position and shoot it.
     * @param e event object containing the mouse position
     */
    @Override
    public void mousePressed(MouseEvent e) {
        Bullet projectile = new Bullet(world);
        projectile.setGravityScale(0);
        projectile.setPosition(new Vec2(world.getPlayer().getPosition().x, world.getPlayer().getPosition().y+1.5f));
        projectile.setLinearVelocity(new Vec2(world.getGame().getView().viewToWorld(e.getPoint()).x-world.getPlayer().getPosition().x,world.getGame().getView().viewToWorld(e.getPoint()).y-world.getPlayer().getPosition().y));
        try {
            sound = new SoundClip("data/shoot.mp3");
            System.out.println("Loading SOUND BULLET");
            sound.play();
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException f) {
            System.out.println(e);
            }
    }

}
