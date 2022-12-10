package project;
import java.util.Map.Entry;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class katze {
    int parId; //ID кота
    String parName; //кличка кота
    Date parBirthDate; //дата рождения
    String parModel; //порода
    String parColour; //цвет
    int parPrice; //цена кота
    HashMap <Date, String> parVisitStory; //история болезни
    Date parVisit; //дата следующего посещения
    String[] parColours = new String[] {"Black", "Orange", "White"};
    String[] parModels = new String[] {"StreetCat", "Persian", "Bengal"};

    katze(int argId, String argName, Date argBirth) {
        Random rand = new Random();
        parVisitStory = new HashMap<>();
        parId = argId;
        parName = argName;
        parBirthDate = argBirth;
        parColour = parColours[rand.nextInt(parColours.length)];
        parModel = parModels[rand.nextInt(parModels.length)];
        priceCalc();
    }
    katze(int argId, String argName) {
        Date curDate = new Date();
        Random rand = new Random();
        parVisitStory = new HashMap<>();
        parId = argId;
        parName = argName;
        parBirthDate = Date.from(curDate.toInstant());
        parColour = parColours[rand.nextInt(parColours.length)];
        //parColour = parColours[0];
        parModel = parModels[rand.nextInt(parModels.length)];
        //parModel = parModels[0];
        priceCalc();
    }

    void priceCalc(){
        switch (parModel) {
            case "StreetCat":
                parPrice = 10;
                break;
            case "Persian":
                parPrice = 100;
                break;
            case "Bengal":
                parPrice = 1000;
                break;
        }
    }

    public void info(){
        System.out.println("====================############=======================");
        System.out.printf("Имя кота: %s \n", parName);
        System.out.printf("Порода кота: %s \n", parModel);
        System.out.printf("Дата рождения кота: %s \n", parBirthDate.toString());
        System.out.printf("Цвет кота: %s \n", parColour );
        System.out.printf("Стоимость кота: %d \n", parPrice );
        System.out.println("=======================================================");
    }

    public void setVisit(String argInfo) {
        parVisitStory.put(parBirthDate, argInfo);
    }

    public void parVisitStory() {
        System.out.printf("================ Карточка кота %s ================ \n", parName);
        for (Entry<Date, String> visit : parVisitStory.entrySet()) {
            System.out.printf("Дата посещения %s, с причиной %s \n", visit.getKey().toString(), visit.getValue());
        }
        System.out.printf("================================================== \n");
    }

    public boolean equals(katze argKatze) {
        return (this.parColour.equals(argKatze.parColour)) && (this.parModel.equals(argKatze.parModel));// && (! this.parBirthDate.equals(argKatze.parBirthDate)); 
    }
}
