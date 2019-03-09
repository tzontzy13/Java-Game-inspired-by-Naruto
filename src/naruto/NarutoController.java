/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naruto;

/**
 *
 * @author razvangututui
 */
import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import city.cs.engine.World;

/**
 * Key handler to control an Walker.
 */
public class NarutoController extends KeyAdapter {
    private static final float JUMPING_SPEED = 15;
    private static float WALKING_SPEED = 9;
    
    private Walker body;
    
    /**
     * the controllable character in the world
     * @param body what body will be cotrolled in the game
     */
    public NarutoController(Walker body) {
        this.body = body;
    }
    
    /**
     * Handle key press events for walking and jumping.
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_W) { // W = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
        } else if (code == KeyEvent.VK_A) {
            body.startWalking(-WALKING_SPEED); // A = walk left
            body.removeAllImages();
            body.addImage(new BodyImage("data/naruto_running.gif",3.9f));
        } else if (code == KeyEvent.VK_D) {
            body.startWalking(WALKING_SPEED); // D = walk right
            body.removeAllImages();
            body.addImage(new BodyImage("data/naruto_running.gif",3.9f));

        } else if (code == KeyEvent.VK_S) {
            body.startWalking(0);             // S = stop walking
        } else if (code == KeyEvent.VK_P){
            WALKING_SPEED = 15;
        }
        
        
       
    }
    
    /**
     * Handle key release events (stop walking).
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            body.stopWalking();
            body.removeAllImages();
            body.addImage(new BodyImage("data/naruto_standing.gif",3.2f));

        } else if (code == KeyEvent.VK_D) {
            body.stopWalking();
            body.removeAllImages();
            body.addImage(new BodyImage("data/naruto_standing.gif",3.2f));

        }
    }
    
    /**
     * set the body to be controlled in the game
     * @param body what body will be controlled in the game
     */
    public void setBody(Walker body) {
        this.body = body;
    }
    
}
