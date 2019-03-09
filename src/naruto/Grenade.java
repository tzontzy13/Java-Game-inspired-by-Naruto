/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naruto;

import city.cs.engine.BodyImage;
import city.cs.engine.CircleShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.World;
import java.awt.Color;

/**
 * grenade class
 * an object that will be created in the game
 * @author razvangututui
 */
public class Grenade extends DynamicBody {
    
    private static final Shape shape = new CircleShape(0.5f);
    
    /**
     * the grenade shape and image
     * @param world the world in which the grenade will be created
     */
    public Grenade(World world) {
        super(world, shape);
        addImage(new BodyImage("data/grenade.png", 2f));
        
    }
    
}
