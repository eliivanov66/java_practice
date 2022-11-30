import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// 4*. Каталог товаров книжного магазина сохранен в виде двумерного списка List<ArrayList<String>> так,
// что на 0й позиции каждого внутреннего списка содержится название жанра,
// а на остальных позициях - названия книг. Напишите метод для заполнения данной структуры.


public class homework_3_task4 {
    public static void main(String[] args) {
  
        List<ArrayList<String>> outInit;
        outInit = myCatalogInit(); //инициализация каталога книг
        System.out.println(String.format("Сформирован следующий каталог %s", outInit.toString()));    
    }

    public static List<ArrayList<String>> myCatalogInit() {
        boolean badUserInput = true;
        Scanner userInput = new Scanner(System.in);
        String[] userGenres = new String[] {""}; //жанры от пользователя
        String[] userBooks = new String[] {""}; //книги от пользователя
        int userChoise = -1; //выбор пользователя
        HashMap<String, Integer> arrChecker = new HashMap<>(); //для проверки уникальности
        while (badUserInput) {
            //получение данных от оператора
            System.out.println("Введите названия жанров для каталога разделённые через ПРОБЕЛ: ");
            userGenres = userInput.nextLine().toLowerCase().split(" ");
            //проверка правильности заполнения жанров
            arrChecker = new HashMap<>(); //для проверки уникальности
            for (int i = 0; i < userGenres.length; i++) {
                if (! arrChecker.containsKey(userGenres[i]) ) {
                    arrChecker.put(userGenres[i], 1);
                    badUserInput = false;
                }
                else {
                    arrChecker.clear();
                    badUserInput = true; //повторяющиейся значения
                    break;
                }
            }
            arrChecker.clear();
            if (userGenres.length < 1) badUserInput = true;
        }
        //инициализация выходной структуры
        List<ArrayList<String>> outValue = new ArrayList<ArrayList<String>>(); //выходной лист
        for (int i = 0; i < userGenres.length; i++) {
            ArrayList<String> tempArr = new ArrayList<>();
            tempArr.add(userGenres[i]);
            outValue.add(tempArr);
        }
        //запрос на заполнение книг
        while (userChoise != outValue.size()) {
            System.out.println("Выберите жанр в каталоге для заполнения ");
            for (int i = 0; i < outValue.size(); i++) {
                String tempString = outValue.get(i).get(0);
                System.out.println(String.format("%d - добавить книги для %s", i, tempString));
            }
            System.out.println(String.format("%d - закончить добавление книг в каталог", outValue.size()));
            badUserInput = true;
            while (badUserInput) {
                try {
                    userChoise = userInput.nextInt();
                    badUserInput = false;
                }
                catch (Exception e) {
                    userInput.next();
                    badUserInput = true;
                }
            }
            if (userChoise != outValue.size()) {
                badUserInput = true;
                while (badUserInput) {
                    //получение данных от оператора
                    System.out.println(String.format("Введите названия книг для каталога в жанре %s разделённые через ПРОБЕЛ: ", outValue.get(userChoise).get(0)));
                    userInput = new Scanner(System.in);
                    userBooks = userInput.nextLine().toLowerCase().split(" ");
                    //проверка правильности заполнения жанров
                    arrChecker = new HashMap<>(); //для проверки уникальности
                    for (int i = 0; i < userBooks.length; i++) {
                        if (! arrChecker.containsKey(userBooks[i]) ) {
                            arrChecker.put(userBooks[i], 1);
                            badUserInput = false;
                        }
                        else {
                            arrChecker.clear();
                            badUserInput = true; //повторяющиейся значения
                            break;
                        }
                    }
                    arrChecker.clear();
                    if (userBooks.length < 1) badUserInput = true;
                    System.out.println(userBooks.length);
                    if (! badUserInput) {
                        ArrayList<String> tempArr = new ArrayList<>();
                        tempArr.add(outValue.get(userChoise).get(0));
                        for (int i = 0; i < userBooks.length; i++) {
                            tempArr.add(userBooks[i]);
                            outValue.set(userChoise, tempArr);
                        }
                    }
                }
            }
        }
        userInput.close();
        return outValue;
        
    }

}
