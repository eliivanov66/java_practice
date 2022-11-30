import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//3. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка

public class homework_3_task3 {
    public static void main(String[] args) throws SecurityException, IOException {
        boolean badUserInput = false; //некорректный ввод от пользователя
        ArrayList<Integer> inList = new ArrayList<Integer>(); //входные данные
        ArrayList<Integer> outList = new ArrayList<Integer>();  //выходные данные
        Scanner userInput = new Scanner(System.in);
        System.out.println("Введите последовательность целозначных чисел через ПРОБЕЛ:");
        String tempUserInput = userInput.nextLine();

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
           for (Integer i : inArray) {
              inList.add(i);
           }

           //поиск минимума, максимума и среднего значения
           outList = homework_3_libr.myListAnalisys(inList);
  
           System.out.println(String.format("Исходный список: %s", inList.toString()));
           System.out.println(String.format("Минимальное значение в списке: %d", outList.get(0)));
           System.out.println(String.format("Максимальное значение в списке: %d", outList.get(1)));
           System.out.println(String.format("Среднее значение в списке: %d", outList.get(2)));
        }
        else {
           System.out.println("Введёны некорректные данные");
        }
        userInput.close();
     } 


}
