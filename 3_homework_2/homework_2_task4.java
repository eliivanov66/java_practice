import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;

// 4*. К калькулятору из предыдущего дз добавить логирование.

public class homework_2_task4 {
    public static void main(String[] args) throws SecurityException, IOException {
        double LeftValue = 0.0;
        double RightValue =  0.0;
        double ResultValue = 0.0;
        String ResultValueStr = "";
        String Operation = "";
        
        //хэндрер - имя файла и дозапись в существующий файл
        FileHandler fHandler =  new FileHandler("calculator_log.txt", true); 

        System.out.println("========== Простой калькулятор ===========");

        LeftValue = homework_2_libr.MyUserInputDouble("Введите первое число: ");
        RightValue = homework_2_libr.MyUserInputDouble("Введите второе число: ");

        int UserInput = 0;
        while ((UserInput < 1) || (UserInput > 4)) {
            System.out.println(String.format("Вы ввели числа %f и %f", LeftValue, RightValue));
            homework_2_libr.myLoggerWriter(fHandler, Level.INFO, String.format("Человек ввёл числа %f и %f", LeftValue, RightValue));
            System.out.println("Выберите действия над этими числами: ");
            System.out.println("1 - найти сумму этих чисел               : + ");
            System.out.println("2 - найти разницу этих чисел             : - ");
            System.out.println("3 - найти произведение этих чисел        : *");
            System.out.println("4 - найти частное этих чисел             : /");
            UserInput = homework_2_libr.MyUserInputInt("Ваш выбор: ");
        }

        switch (UserInput) {
            case 1:
                ResultValue = LeftValue + RightValue;
                Operation = "суммы";
                ResultValueStr = String.valueOf(ResultValue);
                break;
            case 2:
                ResultValue = LeftValue - RightValue;
                Operation = "разности";
                ResultValueStr = String.valueOf(ResultValue);
                break;
            case 3:
                ResultValue = LeftValue * RightValue;
                Operation = "произведения";
                ResultValueStr = String.valueOf(ResultValue);
                break;
            case 4:
                Operation = "деления";
                if (RightValue != 0.0) {
                    ResultValue = LeftValue / RightValue;
                    ResultValueStr = String.valueOf(ResultValue);
                }
                else {
                    ResultValueStr = "бесконечность";
                }
                break;
        }
        homework_2_libr.myLoggerWriter(fHandler, Level.INFO, String.format("Результат %s чисел %f и %f равен %s", Operation, LeftValue, RightValue, ResultValueStr));
        System.out.println(String.format("Результат %s чисел %f и %f равен %s", Operation, LeftValue, RightValue, ResultValueStr));
    }


    
}
