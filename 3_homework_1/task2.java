/* 2. Вывести все простые числа от 1 до 1000 */

public class task2 {
    public static void main(String[] args) {
        int StartValue = 0;
        int EndValue = 0;
        boolean BadUserInput = true;
        while (BadUserInput) {
            StartValue = libr.MyUserInputInt("Введите первое число диапазона");
            EndValue = libr.MyUserInputInt("Введите второе число диапазона");
            BadUserInput = (StartValue >= EndValue || StartValue < 0 || EndValue < 0 || EndValue > 32767);
            if (BadUserInput) {
                System.out.println("Некорректный ввод диапазона");
            }
        }
        System.out.println(String.format("Для диапазона (%d, %d), имеются следующие простые числа", StartValue, EndValue));
        for (int i = StartValue; i <= EndValue; i++) {
            boolean Result = libr.MySimple(i);
            if (Result) {
                System.out.println(String.format("Число %d простое", i));
            }
        }
    }
}
