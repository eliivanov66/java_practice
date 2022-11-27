import java.io.File;
import java.util.ArrayList;

public class program_5 {
    public static void main(String[] args) {
        ArrayList<String> dirOverview = myDirOverview("D:\\Python\\java_practice");
        for (String myPath : dirOverview) {
            System.out.println(myPath);
        }
    }


    public static ArrayList<String> myDirOverview(String argPath) {
        ArrayList<String> tempResult = new ArrayList<>();
        boolean badPathError = false;
        try {
            File tempFile = new File(argPath);
        } catch (Exception e) {
            badPathError = true;
        } finally {
            if (! badPathError) {
                File tempFile = new File(argPath);
                File[] insideFiles = tempFile.listFiles();
                if (tempFile.isDirectory()) {
                    for (File insideFile: insideFiles) {
                        String tempPath = insideFile.getAbsoluteFile().toString().replace("\\", "\\\\");
                        tempResult.add(tempPath);
                        tempResult.addAll(myDirOverview(tempPath));
                    }

                }
            }
        }
        return tempResult;
    }
}
