/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naruto;

import city.cs.engine.BodyImage;
import city.cs.engine.CircleShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.World;
import java.awt.Color;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * the bullet class
 * @author razvangututui
 */
public class Bullet extends DynamicBody {
    
    private static SoundClip sound;
    private static final Shape shape = new PolygonShape(-0.718f,0.032f, -0.015f,0.234f, 0.72f,-0.024f, -0.013f,-0.204f);
    /**
     * the bullet constructor
     * @param world the world in which the bullet is created
     */
    public Bullet(World world) {
        super(world, shape);
        addImage(new BodyImage("data/bullet.png", 2f));
        
    }
}
