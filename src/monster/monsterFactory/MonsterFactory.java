
package monster.monsterFactory;
import monster.monsterType.*;

//fabrique de monstre, renvoie un objet Monstre
public abstract class MonsterFactory {
    public abstract MonsterShare createMonster();
}
