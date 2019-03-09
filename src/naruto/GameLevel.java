package naruto;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * A level of the game.
 */
public abstract class GameLevel extends World {
    private CharacterNaruto player;
    private Naruto game;
    
    /**
     * getter for the player in the current level
     * @return the main player in the actual level
     */
    public CharacterNaruto getPlayer() {
        return player;
    }
    
    
    /**
     * Populate the world of this level.
     * Child classes should this method with additional bodies.
     * @param game the world that will be populated
     */
    public void populate(Naruto game) {
        this.game = game;
        player = new CharacterNaruto(this);
        player.setPosition(startPosition());
        
        Door door = new Door(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new DoorListener(game));
        
    }
    
    /** The initial position of the player.
     * @return  */
    public abstract Vec2 startPosition();
    
    /** The position of the exit door.
     * @return  */
    public abstract Vec2 doorPosition();
    
    /** Is this level complete?
     * @return  */
    public abstract boolean isCompleted();
    
    /**
     * the game
     * @return the game level
     */
    public Naruto getGame(){
        return game;
    }
    
    
}
