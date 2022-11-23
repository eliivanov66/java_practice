
/* 3. Реализовать простой калькулятор */

public class task3 {
    public static void main(String[] args) {
        double LeftValue = 0.0;
        double RightValue =  0.0;
        double ResultValue = 0.0;
        String ResultValueStr = "";
        String Operation = "";
        
        System.out.println("========== Простой калькулятор ===========");

        LeftValue = libr.MyUserInputDouble("Введите первое число: ");
        RightValue = libr.MyUserInputDouble("Введите второе число: ");

        int UserInput = 0;
        while ((UserInput < 1) || (UserInput > 4)) {
            System.out.println(String.format("Вы ввели числа %f и %f", LeftValue, RightValue));
        
            System.out.println("Выберите действия над этими числами: ");
            System.out.println("1 - найти сумму этих чисел               : + ");
            System.out.println("2 - найти разницу этих чисел             : - ");
            System.out.println("3 - найти произведение этих чисел        : *");
            System.out.println("4 - найти частное этих чисел             : /");
            UserInput = libr.MyUserInputInt("Ваш выбор: ");
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
        System.out.println(String.format("Результат %s чисел %f и %f равен %s", Operation, LeftValue, RightValue, ResultValueStr));
    }
}
