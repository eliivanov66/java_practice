package resurces;

import java.util.Scanner;

public class MyUI {

    public static void out(String msg) {
        System.out.println(msg);
    }

    public static int in(String msg, int min, int max){
        boolean valueBad = true;
        int temp = 0;
        Scanner in = new Scanner(System.in);
        while (valueBad){
            in = new Scanner(System.in);
            try {
                out(msg);
                temp = in.nextInt();
                valueBad = (temp < min) || (temp > max);
            } catch (Exception e) {
                valueBad = true;
                out("Некорректный ввод");
            }
        }
        in.close();
        return temp;
    }
}
