import java.util.ArrayList;
import java.util.LinkedList;

public class practice_4_1 {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList();
        LinkedList<Integer> ll = new LinkedList();


        long time = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            al.add(i);
        }
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            ll.add(i);
        }
        System.out.println(System.currentTimeMillis() - time);
    }
}