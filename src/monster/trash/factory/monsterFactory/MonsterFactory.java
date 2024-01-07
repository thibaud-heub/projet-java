
package monster.trash.factory.monsterFactory;
import monster.trash.factory.monsterType.*;

//fabrique de monstre, renvoie un objet Monstre
public abstract class MonsterFactory {
    public abstract MonsterShare createMonster();
}
