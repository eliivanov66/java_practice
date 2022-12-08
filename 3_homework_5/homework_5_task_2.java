import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

// Пусть дан список сотрудников:
// Иван Иванов
// Светлана Петрова
// Кристина Белова
// Анна Мусина
// Анна Крутова
// Иван Юрин
// Петр Лыков
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. 
// Отсортировать по убыванию популярности.

public class homework_5_task_2 {
    public static void main(String[] args) {
        String[] inData = new String[] {"Иван Иванов",
                                        "Светлана Петрова",
                                        "Кристина Белова",
                                        "Анна Мусина",
                                        "Анна Крутова",
                                        "Иван Юрин",
                                        "Петр Лыков",
                                        "Павел Чернов",
                                        "Петр Чернышов",
                                        "Мария Федорова",
                                        "Марина Светлова",
                                        "Мария Савина",
                                        "Мария Рыкова",
                                        "Марина Лугова",
                                        "Анна Владимирова",
                                        "Иван Мечников",
                                        "Петр Петин",
                                        "Иван Ежов"};
        Map <Integer, String[]> humans = new HashMap<Integer, String[]>(); //исходные данные
        Map <String, Integer> humansAnalyze = new HashMap<String,Integer>(); //количество повторений и имя как ключ
        Map <Integer, String[]> humansSorted = new LinkedHashMap<Integer, String[]>(); //выходные данные

        //Заполнение несортированного списка
        int index = 0; 
        for (String name : inData) {
            String[] humanData = new String[2]; 
            humanData = name.split(" ");
            humans.put(index, humanData);
            index++;
        }
        //подсчёт количества
        for (Integer id : humans.keySet()) {
            String[] humanData = humans.get(id);
            if (! humansAnalyze.containsKey(humanData[0]) ) {
                humansAnalyze.put(humanData[0], 1);
            }  
            else {
                humansAnalyze.put(humanData[0], humansAnalyze.get(humanData[0]) + 1);
            }
        }

        //вывод результатов
        for (Integer id : humans.keySet()) {
            System.out.printf("Данные %d до сортировки %s \n",id, Arrays.toString(humans.get(id)));  
        }

        //получение порядка вывода имён
        Map <String, Integer> temp = mySortingDescent(humansAnalyze);
        
        //сортировка исходя с порядком сортировки
        int newId = 0;
        for (Entry<String, Integer> t : temp.entrySet()) {
            for (Integer id: humans.keySet() ) {
                if ( humans.get(id)[0].equals(t.getKey()) ) { //имя
                    humansSorted.put(newId, humans.get(id));
                    newId++;
                } 
            }
        }

        //вывод результатов
        for (String id : temp.keySet()) {
            System.out.printf("Имя %s имеет %d повторов \n",id, (temp.get(id)));  
        }
        
        //вывод результатов
        for (Integer id : humansSorted.keySet()) {
            System.out.printf("Данные %d после сортировки %s \n",id, Arrays.toString(humansSorted.get(id)));  
        } 
    }


    //сортировка map по значению на убывание
    public static Map<String, Integer> mySortingDescent(Map<String, Integer> arg) {        
        Map <String, Integer> out = new LinkedHashMap<String, Integer>(); //с 
        //сортировка через лист
        ArrayList<Entry<String, Integer>> temp = new ArrayList<>(arg.entrySet());
        temp.sort(Entry.comparingByValue(Comparator.reverseOrder()));
        for (Entry<String, Integer> t : temp) {
            out.put(t.getKey(), t.getValue()); //заполнение выходного списка
        }
        return out;
    }
}
