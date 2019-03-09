/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naruto;

import city.cs.engine.*;
import java.awt.Point;
import org.jbox2d.common.Vec2;

/**
 * the main controllable character in the game
 * @author razvangututui
 */
public class CharacterNaruto extends Walker {
    
    private static final Shape hero = new PolygonShape(
    -0.87f,-1.485f, 0.651f,-1.485f, 0.279f,0.486f, -0.735f,0.564f, -1.044f,-0.474f);
    
    private static final BodyImage image =
            new BodyImage("data/naruto_standing.gif", 3.2f);
    
    private int coinCount;
    private int liveCount;
    private int killCount;
    private Bullet bullet;
    
    /**
     * the character constructor
     * @param world in the world in which the character is constructed
     */
    public CharacterNaruto(World world){
        super(world, hero);
        addImage(image);
        coinCount = 0;
        liveCount = 100;
    }
    
    /**
     * getter for the coins
     * @return the coin count
     */
    public int getCoinCount() {
        return coinCount;
    }

    /**
     * the coin count goes up by one
     */
    public void incrementCoinCount() {
        coinCount++;
        System.out.println("Rich!  Coin count = " + coinCount);
    }
    
    /**
     * set the number of coins
     * @param coins the number of coins
     */
    public void setCoinCount(int coins){
        coinCount = coins;
    }
    
    
    /**
     *  getter for the number of lives
     * @return the number of lives
     */
    public int getLiveCount() {
        return liveCount;
    }

    /**
     * decrement the number of lives
     */
    public void decrementLiveCount() {
        liveCount = liveCount - 15;
        System.out.println("You're bad, live: " + liveCount);
    }
    
    /** 
     * getter for the kill count
     * 
     * 
     * @return the number of kills
     */
    public int getKillCount(){
        return killCount;
    }
    
    /**
     *set the number of kills
     */
    public void setKillCount(){
        killCount = killCount + 1;
        System.out.println("Kill count: "+ killCount);
    }
    
    /**
     * set the number of lives to a specific integer
     * 
     * @param lives the number of lives
     */
    public void setLives(int lives){
        liveCount = lives;
    }

}

