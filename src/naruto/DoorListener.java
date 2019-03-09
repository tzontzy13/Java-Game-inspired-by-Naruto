package naruto;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Listener for collision with a door.  When the player collides with a door,
 * if the current level is complete the game is advanced to the next level. 
 */
public class DoorListener implements CollisionListener {
    private Naruto game;
    private SoundClip sound;
    
    /**
     *
     * @param game the level in which the door collision is checked for
     */
    public DoorListener(Naruto game) {
        this.game = game;
    }

    /**
     * if the level is completed and the player is colliding with the door
     * the player advances in level
     * @param e the mouse event
     */
    @Override
    public void collide(CollisionEvent e) {
        CharacterNaruto player = game.getPlayer();
        if (e.getOtherBody() == player && game.isCurrentLevelCompleted()) {
            System.out.println("Going to next level...");
            game.goNextLevel();
            try {
            sound = new SoundClip("data/nextLevel.mp3");
            System.out.println("Loading SOUND DOOR");
            sound.play();
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException f) {
            System.out.println(e);
            }
        }
    }
}
