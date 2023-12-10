
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> fileList = new ArrayList<>();
        ArrayList<Object> pacList = new ArrayList<>();
        ArrayList<Object> unpackList = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            pacList.add(new TestObject());
        }
        //упаковка
        pacList.stream().forEach(it -> {
            try {
                System.out.println("Packing: ");
                System.out.println(it.toString());
                fileList.add(Packer.pack((Serializable)it));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        //распаковка
        for (String file : fileList) {
            try {
                System.out.println("Unpacking: ");
                System.out.println(file);
                unpackList.add(Packer.unpack(file));
                System.out.println(unpackList.get(unpackList.size() - 1).toString());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
