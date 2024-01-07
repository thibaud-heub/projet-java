package monster.trash.factory.monsterType;


public interface Monster {
    public enum DamageType {NOTHING, FIRE, MAGIC, PHYSIC}
    public enum monsterType {COMMON, ELITE}
    
    public void take_damage (int damage) ;
    public void attack (Monster other_monster);
    public void print ();
    public int getDamage ();
    public double getAttackSpeed();
    public int getPV();
    public int getArmor();
    public DamageType getResistance();
    public boolean getAlive();

}
