package characters.abstractFactory.monsterType;

import characters.entity;

import java.io.IOException;
import java.util.Map;
import java.awt.image.BufferedImage;


import javax.imageio.ImageIO;

public abstract class Monster extends entity {

    public enum monsterType {COMMON, ELITE, BOSS}
    public enum State {IDLE, WALK, ATTACK, DEATH}
    
    protected BufferedImage[] idleSprites;
    protected BufferedImage[] walkSprites;
    protected BufferedImage[] deathSprites;

    private State state = State.IDLE;
    private int id = -1;
    private double X;
    private double Y;
    private monsterType monsterType; //indique si le monstre est common ou elite

/**
 * constructeur de la classe monstre, permet de créer un monstre en définissant tous ses paremètres
 * @param monsterStats ; les stats du monstre que l'ont souhaite créer, issu de la classe monsterStats
 * @param Type : type du monstre : commun ou elite
 */
    public Monster (monsterType Type, Map<String, Integer> monsterStats)
    {
        super(
            monsterStats.get("PV"), 
            monsterStats.get("AttackSpeed"), 
            monsterStats.get("FireResistance"), 
            monsterStats.get("PhysicResistance"), 
            monsterStats.get("MagicResistance"), 
            monsterStats.get("FireDamage"), 
            monsterStats.get("PhysicDamage"), 
            monsterStats.get("MagicDamage")
        );
        this.monsterType = Type;
    }

    /**
     * affiche les données du monstre
     */
    public void print ()
    {
        System.out.println("Id : " + this.id);
        super.print();
        System.out.println("coordonée X = " + this.X + " Y = " + this.Y);
        System.out.println("Type : " + monsterType + "\n");
    }
   
    /**
     * renvoie l'id du mosntre
     * @return entier id : id du monstre
     */
    public int getId() {
        return id;
    }

    /**
     * définit l'id du monstre
     * @param id : entier qui remplaceera l'id
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * définie les coordonées du monstre
     * @param x la coordonnée de x
     * @param y la coordonnée de y
     */
    public void setXY (double x, double y)
    {
        this.X = x;
        this.Y = y;
    }

    public double getX()
    {
        return this.X;
    }

    public double getY()
    {
        return this.Y;
    }

    public State getState()
    {
        return this.state;
    }

    public void setState(State state)
    {
        this.state = state;
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
    protected void setWalkSprites(String[] paths) {
        walkSprites = new BufferedImage[paths.length];
        for (int i = 0; i < paths.length; i++) {
            try {
                walkSprites[i] = ImageIO.read(getClass().getResourceAsStream(paths[i]));
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

    public BufferedImage[] getIdleSprites() {
        return idleSprites;
    }
    public BufferedImage[] getWalkSprites() {
        return walkSprites;
    }
    public BufferedImage[] getDeathSprites() {
        return deathSprites;
    }
}