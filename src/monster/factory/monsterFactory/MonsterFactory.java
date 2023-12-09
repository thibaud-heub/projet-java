
package monster.factory.monsterFactory;
import monster.factory.monsterType.*;

//fabrique de monstre, renvoie un objet Monstre
public abstract class MonsterFactory {
    public abstract MonsterShare createMonster();
}
