import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class array_spectre {
    
    private ArrayList<Integer> abc = new ArrayList <Integer> (List.of(0,1,2,3,4,5,6,7,8,9));
    private ArrayList<Integer> sortedIn;
    
    //конструктор по-умолчанию
    public  array_spectre(ArrayList<Integer> argInput){
        argInput.sort(null);
        sortedIn = argInput;
    }

    public HashMap<Integer, Double> formSpectre() {
        HashMap<Integer, Double> outValue = new HashMap<Integer, Double>();
        //инициализация
        for (Integer element : abc) {
            outValue.put(element, 0.0);
        }
        //построение спектра
        for (Integer element : this.sortedIn) {
            if (outValue.keySet().contains(element)) {
                outValue.put(element, outValue.get(element) + 1.0);
            }
        }
        //и построение спектра
        for (Entry<Integer, Double> element : outValue.entrySet()) {
            outValue.put(element.getKey(), (element.getValue()) / (sortedIn.size()) );   
        }

        return outValue;
    }

}
