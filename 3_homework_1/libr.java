
import java.util.Scanner;

public class libr {
    //метод получения данных от пользователя
    public static int MyUserInputInt(String text) {
        System.out.println(text);
        Scanner UserInput = new Scanner(System.in);
        int n = 0;
        boolean BadUserInput =  ! UserInput.hasNextInt();

        do {
            BadUserInput =  ! UserInput.hasNextInt();
            if (! BadUserInput) {
                n = UserInput.nextInt();
            }
            else
            {
                System.out.println(String.format("Некорректный ввод. %s", text));
            }
            UserInput = new Scanner(System.in);
        } while (BadUserInput);
        //UserInput.close();
        return n;
    }

    //метод подсчёта треуголького числа
    public static int MyTriangleNumber(int n) {
        int temp = 0;
        if (n < 0) {
            temp = n;
        }
        else {
            temp = n * (n + 1) / 2; 

        }
        return temp;
    }

    //метод факториал
    public static int MyFactorial(int n){
        int temp = 1;
        if (n < 0) {
            temp = n;
        }
        if (n == 0) {
            temp = 1;
        }
        if (n > 0) {
            temp = n * MyFactorial(n - 1);
        }
        return temp;
    }

    public static boolean MySimple(int n) {
        int temp_n = Math.abs(n);
        boolean result = (temp_n >= 2);
        for (int i = 2; i < temp_n; i++) {    
            if ( (temp_n % i) == 0)  {
                result = false;
                break;
            }
        }
        return result;
    }

    //метод получения данных от пользователя
    public static double MyUserInputDouble(String text) {
        System.out.println(text);
        Scanner UserInput = new Scanner(System.in);
        double n = 0;
        boolean BadUserInput =  ! (UserInput.hasNextInt() || UserInput.hasNextDouble() );

        do {
            BadUserInput =  ! (UserInput.hasNextInt() || UserInput.hasNextDouble() );
            if (! BadUserInput) {
                n = UserInput.nextDouble();
            }
            else
            {
                System.out.println(String.format("Некорректный ввод. %s", text));
            }
            UserInput = new Scanner(System.in);
        } while (BadUserInput);
        //UserInput.close();
        return n;
    }

}
