package monster.factory.monsterFactory;

public class Main {
        public static void main(String[] args) {
            Factory factory = new Factory();            

            factory.generateMonster(10);
            factory.printMonsters();
            
         }
}
