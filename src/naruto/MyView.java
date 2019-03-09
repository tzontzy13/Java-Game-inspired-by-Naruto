package naruto;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import city.cs.engine.*;
import java.awt.Point;

/**
 * extended view
 */
public class MyView extends UserView {
    CharacterNaruto player;
    private Naruto game;
    
    private Image background;
    
    /**
     * the view constructor for the game
     * @param world the world of the game
     * @param game the game
     * @param player the main player in the view
     * @param width the view width
     * @param height the view height
     */
    public MyView(World world, CharacterNaruto player, int width, int height, Naruto game) {
        super(world, width, height);
        this.game = game;
        this.player = player;
        this.background = new ImageIcon("data/background3.png").getImage();
    }
    
    /**
     * paint the background for each level
     * @param g draw images on the background
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        if(game.getLevel()==1){
        g.drawImage(background, 0, 0, this);
        } 
        if(game.getLevel()==2) {
        background = new ImageIcon("data/background2.png").getImage();
        g.drawImage(background, 0, 0, this);
        } 
        if(game.getLevel()==3){
        background = new ImageIcon("data/Finalvalley.jpg").getImage();
        g.drawImage(background, 0, 0, this);
        
        }
    }

    /**
     * paint the foreground of the world
     * @param g draw text on the foreground
     */
    @Override
    protected void paintForeground(Graphics2D g) {
        g.drawString("score:  "+ game.getPlayer().getCoinCount(), 5, 15);
        g.drawString("life:  "+ game.getPlayer().getLiveCount(), 5, 40);
        g.drawString("kills:  "+ game.getPlayer().getKillCount(), 5, 65);
        if(game.getPlayer().getLiveCount()==0){
            g.drawString("GAME OVER",440,320);
            game.pause();
        }
    }
    
}

