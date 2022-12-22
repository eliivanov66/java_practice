import java.util.ArrayList;
import java.util.Scanner;

public class myUI {
    public static void uiOut(String arg){
        System.out.println(arg);
    }
    public static int uiIn(String arg, ArrayList<Integer> goodUserInput){
        Scanner ui;
        int userInput = 0;
        boolean badUserInput = true;

        while (badUserInput) {
            try {
                ui = new Scanner(System.in);
                userInput = ui.nextInt();
                badUserInput = ! goodUserInput.contains(userInput);
            } catch (Exception e) {
                badUserInput = true;
            }
    
            if (badUserInput) {
                System.out.println("Некорректный ввод");
            }
        }
        return userInput;

    }
}
