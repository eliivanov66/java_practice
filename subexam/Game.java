import java.util.Random;

public class Game   {
    public Toy roll(Toyshop argToyshop){
        int diceRoll = new Random().nextInt(0, 100);

        //winning condition logic
        for (Toy item : argToyshop.getToys()) {
            if (diceRoll == item.getPower()) {
                return item;
            }
        }
        return null;
    }
}
