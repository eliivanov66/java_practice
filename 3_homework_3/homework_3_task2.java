import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//Пусть дан произвольный список целых чисел, удалить из него четные числа

public class homework_3_task2 {
   public static void main(String[] args) throws SecurityException, IOException {
      Scanner userInput = new Scanner(System.in);
      System.out.println("Введите последовательность целозначных чисел через ПРОБЕЛ:");
      String tempUserInput = userInput.nextLine();
      //хэндрер - имя файла и дозапись в существующий файл
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
         ArrayList<Integer> inList = new ArrayList<Integer>();
         for (Integer i : inArray) {
            inList.add(i);
         }

         ArrayList<Integer> outList = new ArrayList<Integer>();

         //нахождение нечётных
         for (Integer i : inList) {
            if (i % 2 != 0) {
               outList.add(i);
            }
         }

         System.out.println(String.format("Исходный список чисел: %s", inList.toString()));
         System.out.println(String.format("Результирующий список нечётных чисел: %s", outList.toString()));
      }
      else {
         System.out.println("Введёны некорректные данные");
      }
      userInput.close();
   } 
}
