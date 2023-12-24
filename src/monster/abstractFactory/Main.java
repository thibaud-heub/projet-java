package monster.abstractFactory;

public class Main {
    public static void main(String[] args) {
        ManageMonster manager = new ManageMonster();

        manager.generateMonster(10);
        manager.printMonsters();
     }
}
