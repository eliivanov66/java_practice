import java.util.Arrays;

// Реализовать стэк с помощью массива. 
// Нужно реализовать методы:
// size(), empty(), push(), peek(), pop().

public class practice_4_4 {
    
    public static void main(String[] args) {
        int[] testArray = new int[] {0,1,2,3,4,5,6,7,8,9};
        System.out.println(size(testArray)); //размер
        System.out.println(empty(testArray)); //проверка на пустоту
        System.out.println(Arrays.toString(push(testArray, -1))); //добавление
        System.out.println(peek(testArray)); //верхний элемент
        System.out.println(Arrays.toString(pop(testArray))); //удаляет верхний элемент
    }
    
    //размер стека
    static public int size(int[] arg) {
        return arg.length;
    }

    //проверяет пустой
    static public boolean empty(int[] arg) {
        return arg.length == 0;
    }

    //добавляет новый элемент на вверх
    static public int[] push(int[] arg, int value) {
        int[] argTemp = new int[arg.length + 1];
        
        for (int i = 0; i < arg.length; i++) {
            argTemp[i] = arg[i];
        }
        argTemp[argTemp.length - 1] = value;

        return argTemp;
    }

    //возвращает вверхний элемент
    static public int peek(int[] arg) {
        return arg[arg.length - 1];
    }

    //удаляет верхний элемент 
    static public int[] pop(int[] arg) {
        int[] argTemp = new int[arg.length - 1];
        
        for (int i = 0; i < arg.length - 1; i++) {
            argTemp[i] = arg[i];
        }

        return argTemp;
    }
}
