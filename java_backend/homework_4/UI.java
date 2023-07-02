import java.util.Scanner;

public class UI {
    static Scanner scanner = new Scanner(System.in);

    public static String in(String msg){
        out(msg);
        String temp = "";
        while (temp.isEmpty()) {
            temp = scanner.nextLine();
        }
        return temp;
    }

    public static void out(String arg){
        System.out.println(arg);
    }
}
