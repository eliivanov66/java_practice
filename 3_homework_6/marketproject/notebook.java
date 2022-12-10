import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
public class notebook {
    public int parRam;
    public int parHDD;
    public int parSSD;
    public String parOS;
    public String parColor;
    
    public static ArrayList<Integer> parListRam = new ArrayList<Integer>(List.of(4, 8, 16, 32));
    public static ArrayList<Integer> parListHDD = new ArrayList<Integer>(List.of(0, 256, 512, 1024, 2048));
    public static ArrayList<Integer> parListSSD = new ArrayList<Integer>(List.of(0, 256, 512, 1024, 2048));
    public static ArrayList<String> parListColor = new ArrayList<String>(List.of("Красный", "Зелёный", "Синий", "Чёрный", "Белый", "Жёлтый", "Серебристый"));
    public static ArrayList<String> parListOS = new ArrayList<String>(List.of("none", "Ubuntu", "FreeDos", "Windows 10", "Windows 11"));

    //простой конструктор
    notebook(){
        Random rand = new Random();
        parRam = parListRam.get(rand.nextInt(parListRam.size()));
        parHDD = parListHDD.get(rand.nextInt(parListHDD.size()));
        parSSD = parListSSD.get(rand.nextInt(parListSSD.size()));
        parOS = parListOS.get(rand.nextInt(parListOS.size()));
        parColor = parListColor.get(rand.nextInt(parListColor.size()));
    }
    //конструктор с указанием параметров
    notebook(int argRam, int argHDD, int argSDD, String argOS, String argColor){
        parRam = argRam;
        parHDD = argHDD;
        parSSD = argSDD;
        parOS = argOS;
        parColor = argColor;
    }

    public Integer getRam(){
        return this.parRam;
    }
    public Integer getHDD(){
        return this.parHDD;
    }
    public Integer getSSD(){
        return this.parSSD;
    }
    public String getOS(){
        return this.parOS;
    }
    public String getColor(){
        return this.parColor;
    }

    public void info(String arg) {
        System.out.printf("%s, ", arg);
        System.out.printf("RAM: %d Gb, ", this.parRam);
        
        if (this.parHDD != 0) {
            System.out.printf("HDD: %d Gb, ", this.parHDD);
        }
        else {
            System.out.printf("HDD: нет, ", this.parHDD);
        }

        if (this.parSSD != 0) {
            System.out.printf("SDD: %d Gb, ", this.parSSD);
        }
        else {
            System.out.printf("SDD: нет, ", this.parSSD);
        }

        if (! this.parOS.equals("none") ) {
            System.out.printf("OS: %s, ", this.parOS);
        }
        else {
            System.out.printf("OS: нет, ", this.parOS);
        }
        System.out.printf("Цвет: %s\n", this.parColor);
    }

    public boolean valid(Map<Integer, Integer> argQuery) {
        Boolean[] result = new Boolean[5];
        if (argQuery.containsKey(1)) {
            result[0] = this.parRam == parListRam.get(argQuery.get(1));
        }
        else {
            result[0] = true;
        }
        if (argQuery.containsKey(2)) {
            result[1] = this.parHDD == parListHDD.get(argQuery.get(2));
        }
        else {
            result[1] = true;
        }
        if (argQuery.containsKey(3)) {
            result[2] = this.parSSD == parListSSD.get(argQuery.get(3));
        }
        else {
            result[2] = true;
        }
        if (argQuery.containsKey(4)) {
            result[3] = this.parOS.equals(parListOS.get(argQuery.get(4)));
        }
        else {
            result[3] = true;
        }
        if (argQuery.containsKey(5)) {
            result[4] = this.parColor.equals(parListColor.get(argQuery.get(5)));
        }
        else {
            result[4] = true;
        }
        return result[0] && result[1] && result[2] && result[3] && result[4];
    }

    public static String queryToString(Map<Integer, Integer> argQuery) {
        StringBuilder result = new StringBuilder();
        
        if (argQuery.size() == 0) {
            result.append("*");
        }
        else{
            if (argQuery.containsKey(1)) {
                result.append(String.format("RAM: %d Gb, ", parListRam.get(argQuery.get(1))));
            }
            if (argQuery.containsKey(2)) {
                result.append(String.format("HDD: %d Gb, ", parListHDD.get(argQuery.get(2))));
            }
            if (argQuery.containsKey(3)) {
                result.append(String.format("SSD: %d Gb, ", parListSSD.get(argQuery.get(3))));
            }
            if (argQuery.containsKey(4)) {
                result.append(String.format("OS: %s, ", parListOS.get(argQuery.get(4))));
            }
            if (argQuery.containsKey(5)) {
                result.append(String.format("Цвет: %s, ", parListColor.get(argQuery.get(5))));
            }
        }
        
        return result.toString();
    }
}
