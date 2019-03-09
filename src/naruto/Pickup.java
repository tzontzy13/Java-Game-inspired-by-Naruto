/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naruto;

/**
 *
 * @author razvangututui
 */
import city.cs.engine.*;

/**
 * Collision listener that allows the bird to collect things.
 */
public class Pickup implements CollisionListener {
    private CharacterNaruto naruto;
    
    /**
     * the main character in the game that interacts on collision
     * @param naruto body of character
     */
    public Pickup(CharacterNaruto naruto) {
        this.naruto = naruto;
    }

    /**
     * all collisions between objects and theirs outcomes
     * @param e if collision happens
     */
    @Override
    public void collide(CollisionEvent e) {
        
        if(e.getReportingBody() instanceof CharacterSasuke && e.getOtherBody() == naruto){
        naruto.decrementLiveCount();
        e.getReportingBody().destroy();
        System.out.println("NARUTO SAUSKE COLLISION");
        naruto.setKillCount();
        } 
        
        else if (e.getReportingBody() instanceof Coin && e.getOtherBody() == naruto) {
            naruto.incrementCoinCount();
            e.getReportingBody().destroy();
        }
        
        else if (e.getReportingBody() instanceof CharacterSasuke && e.getOtherBody() instanceof Bullet){
            e.getReportingBody().destroy();
            naruto.setKillCount();
            e.getOtherBody().destroy();
        }
        
        else if (e.getReportingBody() instanceof CharacterShooter && e.getOtherBody() instanceof Bullet){
            e.getReportingBody().destroy();
            naruto.setKillCount();
            e.getOtherBody().destroy();
        }
        
        else if (e.getReportingBody() instanceof CharacterShooter2 && e.getOtherBody() instanceof Bullet){
            e.getReportingBody().destroy();
            naruto.setKillCount();
            e.getOtherBody().destroy();
        }
        
        else if (e.getReportingBody() instanceof StaticBody && e.getOtherBody() instanceof Grenade){
            e.getOtherBody().destroy();
            
        }
        
        else if (e.getReportingBody() instanceof StaticBody && e.getOtherBody() instanceof Bullet){
            e.getOtherBody().destroy();
        }
        
        else if (e.getReportingBody() instanceof CharacterSasuke && e.getOtherBody() instanceof Grenade){
            e.getReportingBody().destroy();
            naruto.setKillCount();
            e.getOtherBody().destroy();
        }
    }
    
}