/**
 * program
 */
import java.util.Scanner;
import java.io.*;
public class program {

    public static void main(String[] args) {
        //точка входа языка
        System.out.println("Buy word");
        //комментарий
        /* комментарий секция */
        
        //строгая типизация элементарных типов
        short var_short = 10;
        int var_int = 0;
        String var_string = null;
        String var_string_2 = "Тестовая текстовая переменная";
        char var_char = 'i';
        float var_float = 3.6f;
        double var_double = 3.6;
        boolean var_bool = true;
        //неявная типизация - после компиляции компилятор определит тип как наиболее подходящий
        var var_unknown = 123;

        System.out.println();
        // a++ ++a  - пофиксный и префиксный инкремент
        //<< >> - побитовые сдвиги
        //^ - XOR

        //массивы
        int [] var_array = new int[8];
        int [][] var_matrix = new int[3][4];

        //данные от пользователя
        //import java.util.Scanner;
        //Scanner my_Scan = new Scanner(System.in)
        Scanner my_scan = new Scanner(System.in);
        System.out.printf("int a:");
        int i = my_scan.nextInt();

        //форматированыый вывод
        int a = 1, b =2;
        String c = "Just string";

        String var_out = a + b + c;
        System.out.println(var_out);

        String var_out2 = String.format("%d + %d", a, b); // %d - целые, %f-плавоющие
        System.out.println(var_out2);
        //{
        //вложенный код, переменные которые здесь определены, они видны лишь там. Но внешние видны им
        //
        //}

        //вызов метода из другого класса
        lib.sayHi();

        //базовые конструкции
        if (i <= 5) {
            System.out.println("i <= 5");
        }
        else{
            System.out.println("i > 5");
        }

        //switch case
        switch (i) {
            case 0,10 :
                System.out.println("i in range(0,10)");
                break;
            default:
                System.out.println("i not in range(0,10)");
                break;
        }
        //for
        for (int index = 0; index < i; index++) {
            System.out.println(index);
        }

        //do while
        int k = i;
        do 
        {
            System.out.println(k);
            k--;
        } while (k > -i);
        
        //работ с файлами
        //импорт всех нужных нам библиотек import java.io.*
        //нужные библиотеки import java.io.FileWriter;
        //нужные библиотеки import java.io.IOException;
            //запись данных
            try (FileWriter my_file_Write = new FileWriter("Text.txt", false)) {
                my_file_Write.write("line 1"); //строка
                my_file_Write.append("\n");    //конец строки
                my_file_Write.write("line 2"); //строка
                my_file_Write.append("\n");    //конец строки
            }
            catch (IOException ix) {
                System.out.println(ix.getMessage());
            }
            //чтение данных
            try (FileReader my_file_read = new FileReader("Text.txt")) {
                int ret_val = my_file_read.read();

                System.out.println(ret_val);
            }
            catch (IOException ix) {
                System.out.println(ix.getMessage());
            }

    }
}
