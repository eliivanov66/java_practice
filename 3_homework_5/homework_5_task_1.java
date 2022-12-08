import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

public class homework_5_task_1 {
    public static void main(String[] args) {
        Map <String, ArrayList<Long>> teleBook = new HashMap<String, ArrayList<Long>>(); //телефонная книга
        ArrayList<Long> phones = new ArrayList<>();
        //первая запись в телефонной книге
        phones.add(89221234567L);
        phones.add(89221234568L);
        phones.add(89221234569L);
        phones.add(89221234560L);
        teleBook.put("Ivanov".toLowerCase(), phones);
        //вторая запись в телефонной книге
        phones = new ArrayList<>();
        phones.add(89222234567L);
        phones.add(89222234568L);
        teleBook.put("Petrov".toLowerCase(), phones);
        //третья запись в телефонной книге
        phones = new ArrayList<>();
        phones.add(89223234567L);
        teleBook.put("Sidorov".toLowerCase(), phones);
        //вывод результатов
        for (String name : teleBook.keySet()) {
            System.out.printf("Для записи %s имеются следующие телефоны %s \n",name, teleBook.get(name.toLowerCase()).toString());  
        }    
    }
}
