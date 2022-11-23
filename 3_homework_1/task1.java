/* 1. Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n) */

public class task1 {
    public static void main(String[] args) {
        int UserValue = - 1;
        do {
            UserValue = libr.MyUserInputInt("Введите число n, для нахождения n-го треугольного числа и его факториала: ");
        } while (UserValue < 0);
        
        int UserTriangle = libr.MyTriangleNumber(UserValue);
        int UserFactorio = libr.MyFactorial(UserValue);
        System.out.printf("Треугольное число для %d равно %d, факториал для %d равен %d", UserValue, UserTriangle, UserValue, UserFactorio);
    }

}
