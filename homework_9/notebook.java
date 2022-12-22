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
public class notebook implements Comparable<notebook> {
    private int parRam;
    private int parHDD;
    private int parSSD;
    private String parOS;
    private String parColor;
    
    //простой конструктор
    notebook(){
        Random rand = new Random();
        parRam = models.parListRam.get(rand.nextInt(models.parListRam.size()));
        parHDD = models.parListHDD.get(rand.nextInt(models.parListHDD.size()));
        parSSD = models.parListSSD.get(rand.nextInt(models.parListSSD.size()));
        parOS = models.parListOS.get(rand.nextInt(models.parListOS.size()));
        parColor =models. parListColor.get(rand.nextInt(models.parListColor.size()));
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

    public void setRam(int arg){
        this.parRam = arg;
    }
    public void setHDD(int arg){
        this.parHDD = arg;
    }
    public void setSSD(int arg){
        this.parSSD = arg;
    }
    public void setOS(String arg){
        this.parOS = arg;
    }
    public void setColor(String arg){
        this.parColor = arg;
    }

    public String info(String arg) {
        StringBuilder temp = new StringBuilder();
        temp.append(String.format("%s: ", arg));
        temp.append(String.format("RAM: %d Gb, ", this.parRam));
        
        if (this.parHDD != 0) {
            temp.append(String.format("HDD: %d Gb, ", this.parHDD));
        }
        else {
            temp.append(String.format("HDD: нет, ", this.parHDD));
        }

        if (this.parSSD != 0) {
            temp.append(String.format("SDD: %d Gb, ", this.parSSD));
        }
        else {
            temp.append(String.format("SDD: нет, ", this.parSSD));
        }

        if (! this.parOS.isEmpty()) {
            temp.append(String.format("OS: %s, ", this.parOS));
        }
        else {
            temp.append(String.format("OS: нет, ", this.parOS));
        }
        if (! this.parColor.isEmpty()) {
            temp.append(String.format("Цвет: %s", this.parColor));
        } 
        return temp.toString();
    }

    public boolean isEmpty(){
        return 
            this.getRam() == 0 &&
            this.getHDD() == 0 &&
            this.getSSD() == 0 &&
            this.getOS().isEmpty() &&
            this.getColor().isEmpty();
    }

    @Override
    public int compareTo(notebook o) {
        int temp = 0;
        if (
            (this.getRam() == o.getRam() || o.getRam() == 0) &&
            (this.getHDD() == o.getHDD() || o.getHDD() == 0) &&
            (this.getSSD() == o.getSSD() || o.getSSD() == 0) &&
            (this.getOS().equals(o.getOS()) || o.getOS().isEmpty()) &&
            (this.getColor().equals(o.getColor()) || o.getColor().isEmpty())
        )
        {
            temp = 0;
        } else {
            temp = -1;
        }
        return temp;
    }

}
