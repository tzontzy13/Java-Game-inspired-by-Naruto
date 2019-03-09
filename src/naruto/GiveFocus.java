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
import city.cs.engine.CircleShape;
import city.cs.engine.Shape;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A mouse listener that gives the keyboard focus to a specified component.
 */
public class GiveFocus extends MouseAdapter {
    private Component target;
    
    /**
     * Initialize the listener.
     * @param target the component to be given the focus on mouseEntered().
     */
    public GiveFocus(Component target) {
        this.target = target;
    }
    
    /**
     * Called when the mouse enters a component.
     * @param e description of the mouse event
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        target.requestFocus();
        System.out.println("mouse entered");
    }
    
    /**
     * Called when the mouse clicks a component.
     * @param e description of the mouse event
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouse clicked");
    }
    
    /**
     * Called when the mouse presses a component.
     * @param e description of the mouse event
     */
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mouse pressed");
    }
    
    /**
     * Called when the mouse releases a component.
     * @param e description of the mouse event
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouse released");
    }

    /**
     * Called when the mouse exists the view.
     * @param e description of the mouse event
     */
    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouse exited");
    }
}
