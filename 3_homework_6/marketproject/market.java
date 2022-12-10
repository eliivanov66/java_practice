import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
// “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …
// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.


public class market {
    public static void main(String[] args) {
        Scanner ui;
        int userInput;
        ArrayList<Integer> goodUserInput;
        boolean badUserInput = true;

        //создание множества ноутбуков
        Random rand = new Random();
        int temp = rand.nextInt(100);
        Map <Integer,notebook> notebookMarket = new HashMap<Integer, notebook>(); 
        for (int i = 0; i <= temp; i++) {
            notebookMarket.put(i, new notebook());
        }

        Map <Integer, Integer> query = new HashMap<Integer, Integer>(); //запрос к множеству ноутбуков
        while (badUserInput) {
            userInput = 0;
            badUserInput = false;

            ui = new Scanner(System.in);
            goodUserInput = new ArrayList<>();
            System.out.printf("Создайте фильтр для поиска ноутбука, текущий фильтр: %s\n", notebook.queryToString(query));
            System.out.println("1 - Объем RAM "); goodUserInput.add(1);
            System.out.println("2 - Объём HDD "); goodUserInput.add(2);
            System.out.println("3 - Объём SDD "); goodUserInput.add(3);
            System.out.println("4 - Операционная система "); goodUserInput.add(4);
            System.out.println("5 - Цвет "); goodUserInput.add(5);
            System.out.println("6 - Очистить фильтр запроса "); goodUserInput.add(6);
            System.out.println("7 - Поиск "); goodUserInput.add(7);
            System.out.println("0 - Выйти из приложения "); goodUserInput.add(0);
            try {
                userInput = ui.nextInt();
                badUserInput = ! goodUserInput.contains(userInput);
            } catch (Exception e) {
                badUserInput = true;
            }

            if (badUserInput) {
                System.out.println("Некорректный ввод");
            }
            else {
                switch (userInput) {
                    case 1:
                        badUserInput = true;
                        while (badUserInput) {
                            ui = new Scanner(System.in);
                            goodUserInput = new ArrayList<>();
                            goodUserInput.add(0);
                            System.out.println("Выберите объём RAM:");
                            for (int i = 0; i < notebook.parListRam.size(); i++) {
                                System.out.printf("%d - %d Gb\n", i + 1, notebook.parListRam.get(i));
                                goodUserInput.add(i + 1);
                            }
                            System.out.println("0 - назад");
                           
                            try {
                                userInput = ui.nextInt();
                                badUserInput = ! goodUserInput.contains(userInput);
                            } catch (Exception e) {
                                badUserInput = true;
                            }
                            if (badUserInput) {
                                System.out.println("Некорректный ввод");
                            }
                        }
                        if (userInput != 0) query.put(1, userInput - 1);
                        badUserInput = true;
                        break;
                    case 2:
                        badUserInput = true;
                        while (badUserInput) {
                            ui = new Scanner(System.in);
                            goodUserInput = new ArrayList<>();
                            goodUserInput.add(0);
                            System.out.println("Выберите объём HDD:");
                            for (int i = 0; i < notebook.parListHDD.size(); i++) {
                                System.out.printf("%d - %d Gb\n", i + 1, notebook.parListHDD.get(i));
                                goodUserInput.add(i + 1);
                            }
                            System.out.println("0 - назад");
                        
                            try {
                                userInput = ui.nextInt();
                                badUserInput = ! goodUserInput.contains(userInput);
                            } catch (Exception e) {
                                badUserInput = true;
                            }
                            if (badUserInput) {
                                System.out.println("Некорректный ввод");
                            }
                        }
                        if (userInput != 0) query.put(2, userInput - 1);
                        badUserInput = true;
                        break;
                    case 3:
                        badUserInput = true;
                        while (badUserInput) {
                            ui = new Scanner(System.in);
                            goodUserInput = new ArrayList<>();
                            goodUserInput.add(0);
                            System.out.println("Выберите объём SSD:");
                            for (int i = 0; i < notebook.parListSSD.size(); i++) {
                                System.out.printf("%d - %d Gb\n", i + 1, notebook.parListSSD.get(i));
                                goodUserInput.add(i + 1);
                            }
                            System.out.println("0 - назад");
                        
                            try {
                                userInput = ui.nextInt();
                                badUserInput = ! goodUserInput.contains(userInput);
                            } catch (Exception e) {
                                badUserInput = true;
                            }
                            if (badUserInput) {
                                System.out.println("Некорректный ввод");
                            }
                        }
                        if (userInput != 0) query.put(3, userInput - 1);
                        badUserInput = true;
                        break;
                    case 4:
                        badUserInput = true;
                        while (badUserInput) {
                            ui = new Scanner(System.in);
                            goodUserInput = new ArrayList<>();
                            goodUserInput.add(0);
                            System.out.println("Выберите операционную систему:");
                            for (int i = 0; i < notebook.parListOS.size(); i++) {
                                System.out.printf("%d - %s\n", i + 1, notebook.parListOS.get(i));
                                goodUserInput.add(i + 1);
                            }
                            System.out.println("0 - назад");
                        
                            try {
                                userInput = ui.nextInt();
                                badUserInput = ! goodUserInput.contains(userInput);
                            } catch (Exception e) {
                                badUserInput = true;
                            }
                            if (badUserInput) {
                                System.out.println("Некорректный ввод");
                            }
                        }
                        if (userInput != 0) query.put(4, userInput - 1);
                        badUserInput = true;
                        break;
                    case 5:
                        badUserInput = true;
                        while (badUserInput) {
                            ui = new Scanner(System.in);
                            goodUserInput = new ArrayList<>();
                            goodUserInput.add(0);
                            System.out.println("Выберите цвет корпуса:");
                            for (int i = 0; i < notebook.parListColor.size(); i++) {
                                System.out.printf("%d - %s\n", i + 1, notebook.parListColor.get(i));
                                goodUserInput.add(i + 1);
                            }
                            System.out.println("0 - назад");
                        
                            try {
                                userInput = ui.nextInt();
                                badUserInput = ! goodUserInput.contains(userInput);
                            } catch (Exception e) {
                                badUserInput = true;
                            }
                            if (badUserInput) {
                                System.out.println("Некорректный ввод");
                            }
                        }
                        if (userInput != 0) query.put(5, userInput - 1);
                        badUserInput = true;
                        break;
                    case 6:
                        System.out.println("******************* Фильтр очищен *********************");
                        query = new HashMap<>(); //запрос к множеству ноутбуков
                        badUserInput = true;
                        break;
                    case 7:
                        //показать созданное множество ноутбуков
                        System.out.println("******************* Запрос выполнен *********************");
                        if (!query.isEmpty()) {
                            for (Entry<Integer, notebook> laptop : notebookMarket.entrySet()) {
                                if (laptop.getValue().valid(query) ) {
                                    laptop.getValue().info(String.format("Ноутбук артикул %d", laptop.getKey()));
                                }  
                            }
                        }
                        else {
                            for (Entry<Integer, notebook> laptop : notebookMarket.entrySet()) {
                                    laptop.getValue().info(String.format("Ноутбук артикул %d", laptop.getKey())); 
                            }
                        }
                        System.out.println("*******************************************************");
                        badUserInput = true;
                        break;
                    case 0:
                        badUserInput = false;
                        break;
                }
            }
        }

    }
        
}
