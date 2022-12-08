import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class practice_5_task1 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Введите первое слово: ");
        String word1 = userInput.nextLine().toLowerCase();
        System.out.println("Введите второе слово: ");
        String word2 = userInput.nextLine().toLowerCase();
        
        char[] word1Char = word1.toCharArray();
        char[] word2Char = word2.toCharArray();
        
        boolean wrongInput = word1.length() != word2.length();
        
        Map <Integer, String> tempValues = new HashMap<>();
        ArrayList<Character> tempLetters = new ArrayList<Character>();

        if (! wrongInput) {
            String tempWord1 = word1; 
            for (int i = 0; i < word2.length(); i++) {
                if (! tempLetters.contains(word2Char[i])) {
                    tempWord1 = tempWord1.replace(word1Char[i], word2Char[i]);
                    tempValues.put(i, tempWord1);
                    tempLetters.add(word2Char[i]);
                }
            }
            wrongInput = ! tempValues.containsValue(word2);
        }

        if (wrongInput) {
            System.out.printf("Слово %s не является изоморфом слова %s", word1, word2);
        }
        else {
            System.out.printf("Слово %s является изоморфом слова %s", word1, word2);
        }

        userInput.close();
    }
}
 