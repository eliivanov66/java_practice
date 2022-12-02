import java.util.LinkedList;

public class myLinkedList {
    public static LinkedList<Object> arg = new LinkedList<>();

    public void enqueue(Object value) {
        arg.add(value);
    }

    public Object dequeue() {
        Object tempOut = arg.get(0);
        arg.remove(0);
        return tempOut;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arg.size(); i++) {
            sb.append(arg.get(i));
            if (i != arg.size() - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public Object first() {
        return arg.get(0);
    }


}
