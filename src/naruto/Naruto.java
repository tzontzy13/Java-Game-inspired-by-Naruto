
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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics2D;
import static java.awt.SystemColor.window;
import java.io.IOException;
import java.util.List;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.JFrame;
import org.jbox2d.common.Vec2;

/**
 * The computer game.
 */
public class Naruto {

    /** The World in which the bodies move and interact. */
    private GameLevel world;

    /** A graphical display of the world (a specialised JPanel). */
    private MyView view;
    
    private int level;
    
    private NarutoController controller;
    
    private SoundClip sound;
    
    private Naruto naruto;
    
    
    /** Initialise a new Game. */
    public Naruto() {

        // make the world
        level = 1;
        world = new Level1();
        world.populate(this);

        view = new MyView(world, world.getPlayer(), 950, 565, this);
                
        // make a view
        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        // display the view in a frame
        JFrame frame = new JFrame("Naruto Game");
        
        Container buttons = new ControlPanel(this);
        frame.add(buttons, BorderLayout.SOUTH);

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));
        
        //JFrame debugView = new DebugViewer(world, 500, 500);
        
        controller = new NarutoController(world.getPlayer());
        frame.addKeyListener(controller);
        
        
        try {
           sound = new SoundClip("data/dailyLife.mp3");
           System.out.println("Loading SOUND 1");
           sound.play();
         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         }
        
               
        // start!
        world.start();
    }
        
    /**
     * the view of the game
     * @return the current view
     */
    public MyView getView(){
        return view;
    }  
        
        
       /** The player in the current level.
     * @return the player in the level  */
    public CharacterNaruto getPlayer() {
        return world.getPlayer();
    }
    
    /**
     * freeze the game
     */
    public void pause(){
        world.stop();
    }
    
    public void restart(){
            sound.stop();
            try {
            sound = new SoundClip("data/dailyLife.mp3");
            System.out.println("Loading SOUND 1");
            sound.play();
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
            }
            level=1;
            // get a new world
            world = new Level1();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            
            world.start();
            System.out.println("level is:" + level);
    }
    
    /**
     * unfreeze the game
     */
    public void resume(){
        world.start();
    }
    
    
    /** Is the current level of the game finished?
     * @return finished or not finished level */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }
    
    /**
     * the current level of the world
     * @return what level the world is on
     */
    public int getLevel(){
        return level;
    }
    
    
    /**
     * the current sound of the world
     * @return what sound is playing
     */
    public SoundClip getSound(){
        return sound;
    }
    
    /** Advance to the next level of the game. */
    public void goNextLevel() {
        world.stop();
        
        CharacterNaruto naruto = world.getPlayer();
        
        if (level == 3) {
            System.exit(0);
        } else if (level == 1){
            sound.stop();
            try {
            sound = new SoundClip("data/sadnessAndSorrow.mp3");
            System.out.println("Loading SOUND 2");
            sound.play();
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
            }
            level++;
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            world.getPlayer().setCoinCount(naruto.getCoinCount());
            world.getPlayer().setKillCount();
            world.getPlayer().setLives(naruto.getLiveCount());
            // show the new world in the view
            view.setWorld(world);
            
            
            view.addMouseListener(new Shooter2(world));


            world.start();
        } else if( level == 2){
            
            sound.stop();
            try {
            sound = new SoundClip("data/mainTheme.mp3");
            System.out.println("Loading SOUND 3");
            sound.play();
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
            }
            level++;
            // get a new world
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            world.getPlayer().setCoinCount(naruto.getCoinCount());
            world.getPlayer().setLives(naruto.getLiveCount());
            // show the new world in the view
            view.setWorld(world);
            
            view.addMouseListener(new Shooter(world));
            

            world.start();
        }
    }


    /** Run the game.
     * @param args */
    public static void main(String[] args) {
        new Naruto();
     
        
    }
}
