package characters;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.util.ArrayList;
import java.util.List;
import items.*;


import weapons.*;

import characters.abstractFactory.monsterType.*;

/**
 * Classe abstraite représentant un personnage, qui hérite de la classe Entity
 */
public abstract class character extends entity {
    
    protected BufferedImage[] idleSprites;
    protected BufferedImage[] runSprites;
    protected BufferedImage[] deathSprites;
    protected int FRAME_COUNT;
    protected weapon chosenWeapon;
    public enum State {IDLE, RUNNING, DEATH}; 
    private State currentState = State.IDLE;
    private double X;
    private double Y;
    private List<Item> inventory;


    /**
     * Constructeur de la classe character
     * @param PV Points de vie
     * @param Rfire Résistance au feu
     * @param Rphysic Résistance physique
     * @param Rmagic Résistance magique
     * @param Dfire Dégâts de feu
     * @param Dphysic Dégâts physiques
     * @param Dmagic Dégâts magiques
     * @param name Nom du personnage
     * @param level Niveau du personnage
     * @param mana Mana du personnage
     * @param speed Vitesse du personnage
     */
    public character(int PV, int Rfire, int Rphysic, int Rmagic, int Dfire, int Dphysic, int Dmagic, String name, int speed) {
        // Appel du constructeur de la classe Entity avec les paramètres nécessaires
        super(PV, Rfire, Rphysic, Rmagic, Dfire, Dphysic, Dmagic);

        this.name = name;
        this.speed = speed;
    }

    protected String name;
    protected double level = 1.0;
    protected double littleLevel = 0;
    protected double mana = 100.0;
    protected int speed;

    // Méthodes abstraites implémentées dans les classes filles
    public abstract int getSpeed();

    /**
     * Décrémente la mana, la durabilité en fonction de l'arme utilisée 
     * Attaque le monstre s'il est dans la range
     * @param monsters Le tableau de monstres 
     * @param weaponUsed  L'arme utilisée
     */
    public boolean attack(Monster[] monsters) {

        if (this.mana >= chosenWeapon.getManaUsed()) {
            // Déduit le mana utilisé pour l'attaque
            this.mana -= chosenWeapon.getManaUsed(); 
            // Intégrer les dégâts de l'arme
            typeDamage weaponDamage = chosenWeapon.getDamage();
            // Vérifier s'il y a un Monster dans la range du joueur
            if(monsterInRange(monsters) != null){
                List<Monster> monster = monsterInRange(monsters);
                // Attaque le monstre
                
                for (Monster m : monster){
                    System.out.println(this.name + " attaque " + m );
                    m.take_damage(weaponDamage);
                    // Logique pour vérifier si le monstre est morte
                    // Si le monstre est mort, récupération d'un certain XP en fonction du niveau du monstre
                    if (m.isDead() != 0){
                        System.out.println(m + " est mort");
                        m.setState(Monster.State.DEATH);
                        System.out.println(m.getState());
                        this.littleLevel += m.isDead();
                        increaseLittleLevel();
                    }
                }
                
                return true;
            }
            else{
                System.out.println("Il n'y a pas de monstre dans la range");
                // Il n'y a pas de monstre mais on attaque quand même
                return true;
            }

            
        } else {
            System.out.println(this.name + " n'a pas assez de mana pour attaquer avec " + chosenWeapon.getName());
            // Logique pour plus de mana, il faut empêcher l'attaque, on retourne faux
            return false;
        }
    }

    /**
     * Vérification de la présence d'un monstre dans la range du joueur
     * @return Monster : Le monstre s'il y en a un, sinon null
     */
    private List<Monster> monsterInRange(Monster[] monsters) {
        double attackRange = chosenWeapon.getRange();
        List<Monster> targets = new ArrayList<>();
    
        for (Monster monster : monsters) {
            if(monster != null){
                double distance = Math.sqrt(Math.pow(monster.getX() - this.X, 2) + Math.pow(monster.getY() - this.Y, 2));
                if (distance <= attackRange) {
                    targets.add(monster);
                }
            }
        }
    
        return targets; // Retourne les monstre dans la range, ou null si aucun
    }


    /**
     * Si l'XP atteint 100, on appelle increaseLevel
     */
    public void increaseLittleLevel(){
        if (this.littleLevel >=100){
            increaseLevel();
        }
    }

    /**
     * Augmente le niveau du personnage
     * Augmente en même temps sa résistance et ses dégats, de 1.2
     */
    public void increaseLevel() {
        this.level += 1.0;
        // Récupération des dégats et résistances du player
        typeDamage damage = this.getDamage();
        typeDamage resistance = this.getResistance();
        // Augmentation de 1.2 les dégats et résistances
        damage.increaseDamage(1.2);
        resistance.increaseDamage(1.2);
        // Attribution des nouveaux dégats et résistances 
        this.setDamage(damage);
        this.setResistance(resistance);
    }


    // Setters pour les sprites, l'état, l'inventaire et les coordonnées

    public void setXY (double x, double y)
    {
        this.X = x;
        this.Y = y;
    }

    public void setChosenWeapon(weapon weapon) {
        this.chosenWeapon = weapon;
    }   


   protected void setIdleSprites(String[] paths) {
    idleSprites = new BufferedImage[paths.length];
    for (int i = 0; i < paths.length; i++) {
        try {
            idleSprites[i] = ImageIO.read(getClass().getResourceAsStream(paths[i]));
        } catch (IOException e) {
            e.printStackTrace();
        }
     }
    }

    protected void setRunSprites(String[] paths) {
        runSprites = new BufferedImage[paths.length];
        for (int i = 0; i < paths.length; i++) {
            try {
                runSprites[i] = ImageIO.read(getClass().getResourceAsStream(paths[i]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
   
   protected void setDeathSprites(String[] paths) {
        deathSprites = new BufferedImage[paths.length];
        for (int i = 0; i < paths.length; i++) {
            try {
                deathSprites[i] = ImageIO.read(getClass().getResourceAsStream(paths[i]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public void setItemInventory(Item item) {
        this.inventory.add(item);
    }

    public void setState(State newState) {
        this.currentState = newState;
    }

    public void setMana(double newMana){
        if(this.mana < 100.0){
            this.mana += newMana;
        }
    }


    // Getters pour les sprites, l'état, l'inventaire, le nom, le niveau, les coordonnées, l'arme et la mana

    public double getX()
    {
        return this.X;
    }

    public double getY()
    {
        return this.Y;
    }

    public BufferedImage[] getIdleSprites() {
        return idleSprites;
    }

    public BufferedImage[] getRunSprites() {
        return runSprites;
    }

    public BufferedImage[] getDeathSprites() {
        return deathSprites;
    }    

    public State getState() {
        return currentState;
    }

    public String getName() {
        return name;
    }

    public double getLevel() {
        return level;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public weapon getWeapon(){
        return chosenWeapon;
    }

    public double getMana(){
        return mana;
    }
}


