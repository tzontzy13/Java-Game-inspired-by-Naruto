/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naruto;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * a character that interacts with others for passing a level
 * @author razvangututui
 */
public class CharacterShooter2 extends DynamicBody {
    
    public static final Shape shooter = new PolygonShape(
    -1.25f,-1.44f, 1.7f,-1.45f, 1.77f,0.15f, -0.11f,1.23f, -1.41f,0.79f);
    
    private static final BodyImage image =
            new BodyImage("data/red.gif", 2.9f);
    
    /**
     * the constructor for the shooter
     * @param world the world in which the shooter is created
     */
    public CharacterShooter2(World world){
        super(world, shooter);
        addImage(image);
    }
    
}
