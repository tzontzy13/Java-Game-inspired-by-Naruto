/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naruto;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.Color;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * the coin class
 * @author razvangututui
 */
public class Coin extends DynamicBody {
    private static final Shape shape = new CircleShape(0.5f);
    private static final BodyImage image =
            new BodyImage("data/coin.gif", 1.3f);
    private static SoundClip coinSound;
    
    /**
     * coin constructor
     * @param world the world in which the coin is created
     */
    public Coin(World world) {
        super(world, shape);
        addImage(image);
    }
    
    static {
        try {
           coinSound = new SoundClip("data/coin.mp3");
           System.out.println("Loading COIN SOUND");
         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         }        
    }
    
    /**
     * destroy method which also plays a sound
     */
    @Override
public void destroy()
{
    coinSound.stop();
    coinSound.play();
    super.destroy();
}
}
