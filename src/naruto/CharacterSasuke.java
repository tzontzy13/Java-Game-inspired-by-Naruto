/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naruto;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.jbox2d.common.Vec2;

/**
 * the secondary character in the game
 * 
 * 
 * @author razvangututui
 */
public class CharacterSasuke extends Walker {
    
    private int liveCount;
    private static SoundClip deathSound;
    
    private static final Shape hero = new PolygonShape(
    0.954f,-1.084f, -0.798f,-1.084f, -0.879f,1.137f, 0.921f,1.083f);
    
    private static final BodyImage image =
            new BodyImage("data/sasuke_standing.gif", 2.75f);
    
    /**
     * the constructor of the sasuke body
     * @param world the world in which the character will be created
     */
    public CharacterSasuke(World world){
        super(world, hero);
        addImage(image);
    }
    
    /**
     * getter for the lives count
     * @return the live count
     */
    public int getLiveCount() {
        return liveCount;
    }

    /**
     * decrements the lives count
     */
    public void decrementLiveCount() {
        liveCount = liveCount - 20;
        System.out.println("Enemy Lives " + liveCount);
    }
    
    static {
        try {
           deathSound = new SoundClip("data/death.mp3");
           System.out.println("Loading DEATH SOUND");
         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         }        
    }
    
    /**
     * destroy character and play a sound
     */
    @Override
    public void destroy()
    {
    deathSound.play();
    super.destroy();
    }
}
