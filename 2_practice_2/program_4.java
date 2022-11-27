import java.io.File;

public class program_4 {
    public static void main(String[] args) {
        getArray("C:\\Users\\Валерий Чирков\\IdeaProjects\\task4");
    }

    public static void getArray(String str){
        File file = new File(str);
        if (file.isDirectory()) {
        String[] arr = file.list();
            for (int i = 0; i < arr.length; i++) {
                System.out.printf(arr[i] + "\n");
                File d = new File(str + "\\" + arr[i]);
                if (d.isDirectory()){
                    getArray(file.getPath() + String.format("\\%s", arr[i]));
                }
            }
        }
    }
}
