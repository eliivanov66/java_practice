import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class market {
    public static void main(String[] args) {
        int userInput = -1;
        ArrayList<Integer> goodUserInput;

        //создание множества ноутбуков
        Random rand = new Random();
        int temp = rand.nextInt(100);
        Map <Integer,notebook> notebookMarket = new HashMap<Integer, notebook>(); 
        for (int i = 0; i <= temp; i++) {
            notebookMarket.put(i, new notebook());
        }

        //искомый ноутбук
        notebook queryLaptop = new notebook(0,0,0,"","");

        while (userInput != 0) {
            myUI.uiOut(String.format("Создайте фильтр для поиска ноутбука, текущий фильтр: %s", queryLaptop.info("Искомый ноутбук")));
            myUI.uiOut("1 - Объем RAM ");
            myUI.uiOut("2 - Объём HDD ");
            myUI.uiOut("3 - Объём SDD ");
            myUI.uiOut("4 - Операционная система ");
            myUI.uiOut("5 - Цвет ");
            myUI.uiOut("6 - Очистить фильтр запроса ");
            myUI.uiOut("7 - Поиск ");
            myUI.uiOut("0 - Выйти из приложения ");
            goodUserInput = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7));
            userInput = myUI.uiIn("Ваш выбор: ", goodUserInput);
            switch (userInput) {
                case 1:
                    userInput = -1;
                    while (! goodUserInput.contains(userInput)) {
                        goodUserInput = new ArrayList<>();
                        goodUserInput.add(0);
                        myUI.uiOut("Выберите объём RAM:");
                        for (int i = 0; i < models.parListRam.size(); i++) {
                            myUI.uiOut(String.format("%d - %d Gb", i + 1, models.parListRam.get(i)));
                            goodUserInput.add(i + 1);
                        }
                        myUI.uiOut("0 - назад");
                        userInput = myUI.uiIn("Ваш выбор: ", goodUserInput);
                        System.out.println(userInput);
                    }
                    if (userInput != 0) queryLaptop.setRam(models.parListRam.get(userInput - 1));
                    userInput = -1;
                    break;
                case 2:
                    userInput = -1;
                    while (! goodUserInput.contains(userInput)) {
                        goodUserInput = new ArrayList<>();
                        goodUserInput.add(0);
                        myUI.uiOut("Выберите объём HDD:");
                        for (int i = 0; i < models.parListHDD.size(); i++) {
                            myUI.uiOut(String.format("%d - %d Gb", i + 1, models.parListHDD.get(i)));
                            goodUserInput.add(i + 1);
                        }
                        myUI.uiOut("0 - назад");
                        userInput = myUI.uiIn("Ваш выбор: ", goodUserInput);
                    }  
                    if (userInput != 0) queryLaptop.setHDD(models.parListHDD.get(userInput - 1));
                    userInput = -1;
                    break;
                case 3:
                    userInput = -1;
                    while (! goodUserInput.contains(userInput)) {
                        goodUserInput = new ArrayList<>();
                        goodUserInput.add(0);
                        myUI.uiOut("Выберите объём SSD:");
                        for (int i = 0; i < models.parListSSD.size(); i++) {
                            myUI.uiOut(String.format("%d - %d Gb", i + 1, models.parListSSD.get(i)));
                            goodUserInput.add(i + 1);
                        }
                        myUI.uiOut("0 - назад");
                        userInput = myUI.uiIn("Ваш выбор: ", goodUserInput);
                    }
                    if (userInput != 0) queryLaptop.setSSD(models.parListSSD.get(userInput - 1));
                    userInput = -1;
                    break;
                case 4:
                    userInput = -1;
                    while (! goodUserInput.contains(userInput)) {
                        goodUserInput = new ArrayList<>();
                        goodUserInput.add(0);
                        myUI.uiOut("Выберите операционную систему:");
                        for (int i = 0; i < models.parListOS.size(); i++) {
                            myUI.uiOut(String.format("%d - %s", i + 1, models.parListOS.get(i)));
                            goodUserInput.add(i + 1);
                        }
                        myUI.uiOut("0 - назад");
                        userInput = myUI.uiIn("Ваш выбор: ", goodUserInput);
                    }
                    if (userInput != 0) queryLaptop.setOS(models.parListOS.get(userInput - 1));
                    userInput = -1;
                    break;
                case 5:
                    userInput = -1;
                    while (! goodUserInput.contains(userInput)) {
                        goodUserInput = new ArrayList<>();
                        goodUserInput.add(0);
                        myUI.uiOut("Выберите цвет корпуса:");
                        for (int i = 0; i < models.parListColor.size(); i++) {
                            myUI.uiOut(String.format("%d - %s", i + 1, models.parListColor.get(i)));
                            goodUserInput.add(i + 1);
                        }
                        myUI.uiOut("0 - назад");
                        userInput = myUI.uiIn("Ваш выбор: ", goodUserInput);
                    }
                    if (userInput != 0) queryLaptop.setColor(models.parListColor.get(userInput - 1));
                    userInput = -1;
                    break;
                case 6:
                    myUI.uiOut("******************* Фильтр очищен *********************");
                    queryLaptop = new notebook(0,0,0,"","");
                    userInput = -1;
                    break;
                case 7:
                    //показать созданное множество ноутбуков
                    myUI.uiOut("******************* Запрос выполнен *********************");
                    if (!queryLaptop.isEmpty()) {
                        for (Entry<Integer, notebook> laptop : notebookMarket.entrySet()) {
                            if (laptop.getValue().compareTo(queryLaptop) == 0) {
                                String tempResult = laptop.getValue().info(String.format("Ноутбук артикул %d", laptop.getKey()));
                                myUI.uiOut(tempResult);
                            }  
                        }
                    }
                    else {
                        for (Entry<Integer, notebook> laptop : notebookMarket.entrySet()) {
                                String tempResult = laptop.getValue().info(String.format("Ноутбук артикул %d", laptop.getKey()));
                                System.out.println(tempResult); 
                        }
                    }
                    myUI.uiOut("*******************************************************");
                    userInput = -1;
                    break;
                }
        }
    }       
}
