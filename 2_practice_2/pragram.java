import java.util.Scanner;

public class pragram {
    public static void main(String[] args) {
        char c1 = '1';
        char c2 = '0';
        int userInt = -1;
        Scanner userInput = new Scanner(System.in);


        System.out.println("Введите число N, для формирования строки чередующихся символов:");
        userInt = userInput.nextInt();

        StringBuilder myBuilder = new StringBuilder();

        for (int i = 0; i < Math.abs(userInt); i++) {
            if (i % 2 == 0) {
                myBuilder.append(c1);
            }
            else {
                myBuilder.append(c2);
            }
        }
        System.out.println(myBuilder);
        System.out.println(String.format("Для введённого числа %d получена следующая строка %s", userInt, myBuilder.toString()));
        
        userInput.close();

    }
}
