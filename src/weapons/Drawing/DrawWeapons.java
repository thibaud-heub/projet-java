package weapons.Drawing;

import weapons.weapon;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import entity.character;

import java.awt.image.BufferedImage;

public class DrawWeapons {
    private weapon currentWeapon;
    private int xPos;
    private int yPos;
    private int spriteIndex;
    private boolean runningLeft;
    private int weaponYAdjustment;
    private ImageObserver observer;
    private character currentCharacter;


    /**
     * Constructeur de la classe DrawWeapons
     * @param currentWeapon L'arme actuelle
     * @param currentCharacter Le personnage actuel
     * @param xPos La position en X du personnage
     * @param yPos La position en Y du personnage
     * @param spriteIndex L'index du sprite
     * @param runningLeft Le sens du personnage
     * @param weaponYAdjustment L'ajustement de l'arme en Y
     * @param observer L'observer
     */
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
    
    // Méthode qui dessine l'arme
    public void draw(Graphics g){

        // Récupère l'état de l'arme et les sprites de l'arme
        weapon.State currentState = currentWeapon.getState();
        BufferedImage [] weaponSprites = currentWeapon.getWeaponSprites(); 
        Image weaponSprite;
        // Récupère l'état du personnage
        character.State currentCharacterState = currentCharacter.getState();

        // Définit l'image de l'arme en fonction de l'état de l'arme
        switch (currentState) {
            case IDLE:
            default:
                weaponSprite = weaponSprites[0];
                break;
            case ATTACK:
                weaponSprite = weaponSprites[spriteIndex];
            break;
        }

        // Récupère les coordonées de l'arme
        int offsetWeaponX = currentWeapon.getOffsetWeaponX();
        int offsetWeaponY = currentWeapon.getOffsetWeaponY();

        int drawX = xPos;
        
        int weaponX = xPos + offsetWeaponX;
        int weaponY = yPos + offsetWeaponY;
        int amountToAdjust = 48;
        int weaponWidth = weaponSprite.getWidth(null);
        int weaponHeight = weaponSprite.getHeight(null);

        int weaponYAdjusted = weaponY + weaponYAdjustment;

        // Si le personnage est en train de courir, l'arme est légèrement décalée vers le haut
        if (currentCharacterState == character.State.RUNNING) {
            weaponYAdjusted -= 2; 
        }

        // Dessin de l'arme en fonction de si le personnage va vers la gauche ou vers la droite
        if(runningLeft){
            g.drawImage(weaponSprite, drawX - weaponWidth - offsetWeaponX + amountToAdjust, weaponYAdjusted, -weaponWidth, weaponHeight, observer);
        } else {
            g.drawImage(weaponSprite, weaponX, weaponYAdjusted, observer);
        }

    }

}