
package naruto;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Level 1 of the game
 */
public class Level1 extends GameLevel {

    private static final int NUM_COINS = 3;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Naruto game) {
        super.populate(game);

        // make the ground
        Shape groundShape = new BoxShape(15, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -12.5f));
        ground.addImage(new BodyImage("data/grass4.jpeg", 1f));
        ground.addCollisionListener(new Pickup(getPlayer()));
        

        // make a platform
        Shape platformShape = new BoxShape(7, 0.5f);
        Shape platformShape2 = new BoxShape(2, 0.5f);

        
        /*Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-12, -2f));
        platform1.setAngleDegrees(150);
        
        Body platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(12, 0.5f));
        platform2.setAngleDegrees(30);*/
        
        Body platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(-1, 2f));
        platform3.addCollisionListener(new Pickup(getPlayer()));

        
        /*Body platform4 = new StaticBody(this, platformShape2);
        platform4.setPosition(new Vec2(17,7f));
        
        Body platform5 = new StaticBody(this, platformShape2);
        platform5.setPosition(new Vec2(-15, 8.5f));*/
        

        // make a character
          
        
        Body character2 = new CharacterSasuke(this);
        character2.setPosition(new Vec2(6,6));
        character2.addCollisionListener(new Pickup(getPlayer()));
        
        /*Body character3 = new CharacterShooter(this);
        character3.setPosition(new Vec2(17,11));
        
        Body character4 = new CharacterShooter2(this);
        character4.setPosition(new Vec2(-15,10));*/
        
                
        // walls
        Shape wallShape = new BoxShape(0.5f, 6);
        
        Body leftWall = new StaticBody(this, wallShape);
        leftWall.setPosition(new Vec2(-18.5f, -8f));
        leftWall.setAngleDegrees(40);
        leftWall.addCollisionListener(new Pickup(getPlayer()));

        
        Body rightWall = new StaticBody(this, wallShape);
        rightWall.setPosition(new Vec2(18.5f, -8f));
        rightWall.setAngleDegrees(140);
        rightWall.addCollisionListener(new Pickup(getPlayer()));

        
        
        
        //coins
        for (int i = 0; i < 3; i++) {
            Body coin = new Coin(this);
            coin.setPosition(new Vec2(i*3-5, 10));
            coin.addCollisionListener(new Pickup(getPlayer()));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(2, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-11.6f, -10.6f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getCoinCount() >= NUM_COINS;
    }
    
    
}
