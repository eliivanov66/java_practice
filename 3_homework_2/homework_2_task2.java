import java.util.logging.Level;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.FileHandler;

/* Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл. */


public class homework_2_task2 {
    public static void main(String[] args) throws SecurityException, IOException {

        Scanner userInput = new Scanner(System.in);
        System.out.println("Введите последовательность целозначных чисел через ПРОБЕЛ:");
        String tempUserInput = userInput.nextLine();
        //хэндрер - имя файла и дозапись в существующий файл
        FileHandler fHandler =  new FileHandler("log.txt", true); 
        boolean badUserInput = false; //некорректный ввод от пользователя
        
        int[] inArray = new int[tempUserInput.split(" ").length];
        try {
            for (int i = 0; i < tempUserInput.split(" ").length; i++) {
                inArray[i] = Integer.valueOf(tempUserInput.split(" ")[i]);
            }
        } catch (Exception e) {
            badUserInput = true;
        } finally {
            if (! badUserInput) {
                for (int i = 0; i < tempUserInput.split(" ").length; i++) {
                    inArray[i] = Integer.valueOf(tempUserInput.split(" ")[i]);
                }
            }
        }

        if (! badUserInput) {
            for (int i = 0; i < tempUserInput.split(" ").length; i++) {
                inArray[i] = Integer.valueOf(tempUserInput.split(" ")[i]);
            }
            System.out.println(String.format("Исходный массив до сортировки", Arrays.toString(inArray)));
            
            //метод сортировки, логирование уже внутри
            int[] outArray = homework_2_libr.myBubleSorting(inArray, fHandler);
            
            //просто результат для человека
            System.out.println(String.format("Результат сортировки массива: %s", Arrays.toString(outArray)));
        }
        else {
            homework_2_libr.myLoggerWriter(fHandler, Level.INFO, "Исходный массив до сортировки: некорректный ввод пользователя" );
            System.out.println(String.format("некорректный ввод пользователя"));
        }
        userInput.close();
    }


}
