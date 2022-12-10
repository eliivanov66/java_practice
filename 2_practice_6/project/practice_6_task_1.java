package project;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;

public class practice_6_task_1 {
    public static void main(String[] args) {
        Random rand = new Random();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z"); 
        Date date = new Date(System.currentTimeMillis() - 3600000); 
        System.out.println(formatter.format(date));
        
        //создание экземпляров класса кот
        katze firstCat = new katze(1, "Барсик");
        katze secondCat = new katze(2, "Борис");
        katze thirdCat = new katze(3, "Мурзик");

        //вызываем методы относительно разных объёктов
        firstCat.info();
        secondCat.parBirthDate = date;
        secondCat.info();
        thirdCat.info();

        //вызываем методы относительно разных объёктов
        thirdCat.parBirthDate = new Date(System.currentTimeMillis() - rand.nextInt(9000000)); 
        thirdCat.setVisit("Лапка болит");
        thirdCat.parBirthDate = new Date(System.currentTimeMillis() - rand.nextInt(9000000)); 
        thirdCat.setVisit("Съел дождик у ёлки");
        thirdCat.parBirthDate = new Date(System.currentTimeMillis() - rand.nextInt(9000000)); 
        thirdCat.setVisit("Сильно тупит");
        thirdCat.parVisitStory();

        //создаём HashSet c экземплярами
        HashSet<katze> myCatSet = new HashSet<>();
        myCatSet.add(firstCat);
        myCatSet.add(secondCat);
        myCatSet.add(thirdCat);

        System.out.println("*******************************************************");
        System.out.println("*******************************************************");
        System.out.println("*******************************************************");
        //новые почти одинаковые коты
        katze fourthCat = new katze(4, "Рыжик");
        katze fifthtCat = new katze(4, "Рыжик");
        myCatSet.add(fourthCat);
        myCatSet.add(fifthtCat);

        //содержимое сета
        for (katze katze : myCatSet) {
            katze.info();
        }
        System.out.println("*******************************************************");
        System.out.println("*******************************************************");
        System.out.println("*******************************************************");
        
        //перебором котов исчем одинаковые исходя из определённого метода
        for (katze katze : myCatSet) {
            if (fourthCat.equals(katze)) {
                System.out.printf("Кот %s с пародой %s эквивалентен коту %s c пародой %s \n", fourthCat.parName, fourthCat.parModel, katze.parName, katze.parModel);
            } else {
                System.out.printf("Кот %s с пародой %s НЕ эквивалентен коту %s c пародой %s \n", fourthCat.parName, fourthCat.parModel, katze.parName, katze.parModel);

            }
        }


    }
}
