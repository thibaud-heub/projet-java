package weapons.Drawing;

import weapons.weapon;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.BufferedImage;
import characters.character;

public class DrawWeapons {
    private weapon currentWeapon;
    private int xPos;
    private int yPos;
    private int spriteIndex;
    private boolean runningLeft;
    private int weaponYAdjustment;
    private ImageObserver observer;
    private character currentCharacter;


    public DrawWeapons(weapon currentWeapon, character currentCharacter, int xPos, int yPos, int spriteIndex, boolean runningLeft, int weaponYAdjustment, ImageObserver observer) {
        this.currentWeapon = currentWeapon;
        this.xPos = xPos;
        this.yPos = yPos;
        this.spriteIndex = spriteIndex;
        this.runningLeft = runningLeft;
        this.weaponYAdjustment = weaponYAdjustment;
        this.observer = observer;
        this.currentCharacter = currentCharacter;
    }
    
    public void draw(Graphics g){
        weapon.State currentState = currentWeapon.getState();
        BufferedImage [] weaponSprites = currentWeapon.getWeaponSprites(); 
        Image weaponSprite;

        switch (currentState) {
            case IDLE:
            default:
                weaponSprite = weaponSprites[0];
                break;
            case ATTACK:
                weaponSprite = weaponSprites[spriteIndex];
            break;
        }

        int offsetWeaponX = currentWeapon.getOffsetWeaponX();
        int offsetWeaponY = currentWeapon.getOffsetWeaponY();

        int drawX = xPos;
        
        int weaponX = xPos + offsetWeaponX;
        int weaponY = yPos + offsetWeaponY;
        int amountToAdjust = 48;
        int weaponWidth = weaponSprite.getWidth(null);
        int weaponHeight = weaponSprite.getHeight(null);

        int weaponYAdjusted = weaponY + weaponYAdjustment;

        character.State currentCharacterState = currentCharacter.getState();

        if (currentCharacterState == character.State.RUNNING) {
            weaponYAdjusted -= 2; 
        }

        if(runningLeft){
            g.drawImage(weaponSprite, drawX - weaponWidth - offsetWeaponX + amountToAdjust, weaponYAdjusted, -weaponWidth, weaponHeight, observer);
        } else {
            g.drawImage(weaponSprite, weaponX, weaponYAdjusted, observer);
        }

    }

}