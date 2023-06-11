package logic;

import resurces.MyUI;
import resurces.Hexetor;

public class Main {
    public static void main(String[] args) {
        Integer min = Integer.MIN_VALUE;
        Integer max = Integer.MAX_VALUE;
        MyUI.out("Перевод числа в 16ричную систему");
        MyUI.out(Hexetor.something(MyUI.in(String.format("Введите целое число в диапазоне (%d, %d):",min, max ), min, max)));      
    }
}
