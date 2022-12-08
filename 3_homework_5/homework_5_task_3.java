import java.util.Arrays;
import java.util.Scanner;

// Реализовать алгоритм пирамидальной сортировки (HeapSort).

public class homework_5_task_3 {
    public static void main(String[] args) {
        Scanner userInput; 
        String[] rawData;
        boolean badInput = true;
        Integer[] inputData = new Integer[0];
        Integer[] outputData;

        //получение входных данных от пользователя
        while (badInput) {
            badInput = false;
            System.out.println("Введите массив чисел, разделённых через ПРОБЕЛ: ");
            userInput = new Scanner(System.in); 
            rawData = userInput.nextLine().split(" ");
            inputData = new Integer[rawData.length];
            try {
                for (int i = 0; i < rawData.length; i++) {
                    inputData[i] = Integer.valueOf(rawData[i]);
                }
                badInput = false;
            } catch (Exception e) {
                System.out.println("Некорректный ввод");
                badInput = true;
            }
        }
        //вывод промежуточного результата
        System.out.printf("Введён массив чисел: %s \n", Arrays.toString(inputData));
        outputData = HeapSort(inputData);
        System.out.printf("Массив чисел после сортировки: %s \n", Arrays.toString(outputData));
    }

    //пиромидальная сортировка
    public static Integer[] HeapSort(Integer[] arg) {
        // Перегрупировка
        for (int i = arg.length / 2 - 1; i >= 0; i--)
            arg = HeapForm(arg, arg.length, i);
        
        // Сортировка   
        for (int i = arg.length - 1; i >= 0; i--)
        {
            int temp = arg[0];
            arg[0] = arg[i];
            arg[i] = temp;
            // Вызываем процедуру heapify на уменьшенной куче
            arg = HeapForm(arg, i, 0);
        }

        return arg;
    }

    //преобразование в древо
    public static Integer[] HeapForm(Integer[] arg, int size, int head) {
        int largest = head; // Инициализируем наибольший элемент как корень
        int l = 2 * head + 1; // левый = 2*i + 1
        int r = 2 * head + 2; // правый = 2*i + 2

        // поиск наибольшего в древе
        if (l <size && arg[l] > arg[largest])
            largest = l;
        if (r < size && arg[r] > arg[largest])
            largest = r;
        
        // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
        if (largest != head)
        {
            int swap = arg[head];
            arg[head] = arg[largest];
            arg[largest] = swap;
            arg = HeapForm(arg, size, largest);
        }
        return arg;
    }
}
