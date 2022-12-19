import java.util.ArrayList;
import java.util.Random;

public class program {
    public static void main(String[] args) {
        int pplCount = new Random().nextInt(10);
        pplCount = 5; //количество людей
        ArrayList<person> persons = new ArrayList<person>();
        for (int i = 0; i < pplCount; i++) {
            person tempPerson = new person(3);
            persons.add(tempPerson);
        }
        int count = 1;
        for (person element : persons) {
            System.out.println(String.format("============Персона %d================", count));
            System.out.println(element.getInfo(""));
            count ++;
        }
    }
    
}
