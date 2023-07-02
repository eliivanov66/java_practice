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

    public static void display(int[][] field){
        for (int[] integers : field) {
            StringBuilder temp = new StringBuilder();
            for (int iterable_element : integers) {
                temp.append(String.valueOf(iterable_element));
            }
            out(temp.toString());
        }
    }
}
