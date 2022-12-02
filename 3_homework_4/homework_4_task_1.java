import java.util.LinkedList;

// Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
public class homework_4_task_1 {
    public static void main(String[] args) {
        LinkedList<Object> inData = new LinkedList<>();
        inData.add("first");
        inData.add("second");
        inData.add("third");
        LinkedList<Object> outData = ListReverse(inData);
        System.out.println(outData.toString());
    }

    public static LinkedList<Object> ListReverse(LinkedList<Object> arg) {
        LinkedList<Object> outValue = new LinkedList<>();
        for (int i = arg.size() - 1; i >= 0; i--) {
            outValue.add(arg.get(i));
        }
        return outValue;
    }
}
