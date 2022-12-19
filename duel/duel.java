package java_practice.duel;

import java.util.Random;
import resurces.classCleric;
import resurces.classRogue;
import resurces.classFighter;

public class duel {
    public static void main(String[] args) {
        Random rand = new Random();
        boolean phase = rand.nextBoolean();
        boolean gameOver = false;
        classFighter Player1 = new classFighter("Fighter");
        classRogue Player2 = new classRogue("Rogue");
        classCleric Player3 = new classCleric("Cleric");

        while (! gameOver) {

            if (rand.nextBoolean()){
                Player1.healing(Player1, Player3.heal(Player3));
            }
            else {
                Player2.healing(Player2, Player3.heal(Player3));
            }

            if (phase) {
                if (! Player1.dead()) {
                    Player2.defence(Player2, Player1.meleeAttack(Player1));
                }
                else {
                    gameOver = true;
                }
                phase = false;
            }
            else {
                if (! Player2.dead()) {
                    Player1.defence(Player1, Player2.rangedAttack(Player2));
                }
                else {
                    gameOver = true;
                }
                phase = true;
            }
        }
    }
}