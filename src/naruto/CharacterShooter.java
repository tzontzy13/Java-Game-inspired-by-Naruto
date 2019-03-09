/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naruto;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *a character that interacts with others for passing a level
 * @author razvangututui
 */
public class CharacterShooter extends DynamicBody{
    
    /**
     * the constructor for a character that interacts with others for passing a level
     * @param world the world in which the shooter is created
     */
    public CharacterShooter(World world){
    super(world);
        
    Shape shooter = new PolygonShape(
    0.954f,-1.084f, -0.798f,-1.084f, -0.879f,1.137f, 0.921f,1.083f);
    SolidFixture shooterFixture = new SolidFixture(this, shooter, 10);
        
        addImage(new BodyImage("data/green.gif", 3f));
    
    Shape gunShape = new PolygonShape(
    -0.93f,0.217f, -0.148f,0.219f, -0.173f,-0.289f, -0.897f,-0.258f);
    SolidFixture gunFixture = new SolidFixture(this, gunShape, 3);
        
        addImage(new BodyImage("data/uzi.gif", 2f));
       
    }
    
}
