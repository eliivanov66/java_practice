import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// 3**Дана json строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
// {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.


public class homework_2_task3 {
    public static void main(String[] args) throws IOException {
        File outFile = new File("testJson.json");
        String[] userfullTags = {"фамилия","оценка","предмет"};
        String[] userfullTagsPrefix = {"Студент","получил оценку","по предмету"};

        //заполнение если файл пуст
        if (! outFile.exists()) {
            var resFormer = myJsonWriter(outFile ,  "{фамилия:Иванов,оценка:5,предмет:Математика}" );
            if (resFormer != null) System.out.println(resFormer.toString());
            resFormer = myJsonWriter(outFile ,  "{фамилия:Петрова,оценка:4,предмет:Информатика}" );
            if (resFormer != null) System.out.println(resFormer.toString());
            resFormer = myJsonWriter(outFile ,  "{фамилия:Краснов,оценка:5,предмет:Физика}" );
            if (resFormer != null) System.out.println(resFormer.toString());
        }
        if (outFile.exists()) {
            var resReader = myJsonReader(outFile, userfullTags, userfullTagsPrefix);
            System.out.println(resReader);
        }
    }

    public static String myJsonWriter(File argFile, String arg) throws IOException {
        boolean badInputData = false;
        boolean badFile = false;
        boolean fileExisted = false;
        int counter1 = 0; //количество символов :
        int counter2 = 0; //количество символо ,
        String jSonObject = "";
        FileWriter outFileStream;
        Scanner inFileStream;
        StringBuffer buffFileStream;
        
        for (char ch: arg.toCharArray()) {
            if (ch == ':') counter1 ++;
            if (ch == ',') counter2 ++;
        }
        badInputData = ! (counter2 == counter1 - 1) || ! arg.contains("{") || ! arg.contains("}");
        
        fileExisted = argFile.exists();
        badFile = ! argFile.getName().contains(".json");
        
        if (! badInputData) {
            arg = arg.replace("{", "");
            arg = arg.replace("}", "");
            String[] tempArg = arg.split(",");
            StringBuilder tempBuilder = new StringBuilder();
            
            tempBuilder.append("{\n");
            
            for (int i = 0; i < tempArg.length; i++) {
                String[] tempTempArg = tempArg[i].split(":");
                tempBuilder.append("    ");
                tempBuilder.append(Character.toChars(34));
                tempBuilder.append(tempTempArg[0]);
                tempBuilder.append(Character.toChars(34));
                tempBuilder.append(":");
                boolean varIsInt = true;
                try {
                    Integer.valueOf(tempTempArg[1]);
                } catch (Exception e) {
                    varIsInt = false;
                }
                if (varIsInt) {
                    tempBuilder.append(Integer.valueOf(tempTempArg[1]));
                }
                else {
                    tempBuilder.append(Character.toChars(34));
                    tempBuilder.append(tempTempArg[1]);
                    tempBuilder.append(Character.toChars(34));  
                }

                if (i != tempArg.length - 1) tempBuilder.append(",");
                tempBuilder.append("\n");
            }
            tempBuilder.append("}\n");
            jSonObject = tempBuilder.toString();
            
            while (jSonObject.contains("  ") ) {
                jSonObject = jSonObject.replace("  ", " ");
            }
        }
        else {
            jSonObject = null;
        }
        
        if (! badInputData && jSonObject != "" && !badFile ) {
            if (! fileExisted) {
                argFile.createNewFile();
            }
            inFileStream = new Scanner(argFile);
            buffFileStream = new StringBuffer();
            String existedjSonObject = "";
            if (fileExisted) {
                buffFileStream.append("[\n");
                while (inFileStream.hasNextLine()) {
                    String line = inFileStream.nextLine();
                    if (! line.contains("]") && ! line.contains("[")) { 
                        buffFileStream.append(line);
                        buffFileStream.append("\n");
                    }
                }
                buffFileStream.append(",\n");
                existedjSonObject = buffFileStream.toString();
            }
            else {
                existedjSonObject = "[\n"; //начало json файла
            }
            
            StringBuilder tempBuilder = new StringBuilder();
            tempBuilder.append(existedjSonObject);
            tempBuilder.append(jSonObject);
            tempBuilder.append("]\n");
            inFileStream.close();

            outFileStream = new FileWriter(argFile, false);
            outFileStream.append(tempBuilder.toString());
            outFileStream.close();
        }
        return jSonObject;
    }

    public static String myJsonReader(File argFile, String[] tags, String[] addTags) throws FileNotFoundException {
        boolean formData = false;
        boolean formDataPrev = false;
        boolean badInputData = false;
        boolean badFile = false;
        boolean fileExisted = false;
        Scanner inFileStream;
        StringBuffer buffFileStream;
        ArrayList <String> outData = new ArrayList<>();

        fileExisted = argFile.exists();
        badFile = ! argFile.getName().contains(".json");
        badInputData = tags.length != addTags.length;

        if (fileExisted && ! badFile && ! badInputData) {
            inFileStream = new Scanner(argFile);
            buffFileStream = new StringBuffer();
            String line;
            while (inFileStream.hasNextLine()) {
                line = inFileStream.nextLine();
                //найдено начало записи
                if (line.contains("{")) {
                    formData = true;
                    buffFileStream.setLength(0);
                }
                if (line.contains("}")) {
                    formData = false;
                }
                
                if (formData) {
                    for (int i = 0; i < tags.length; i++) {
                        if (line.contains(tags[i])) {
                            line = line.replaceAll(tags[i], "");
                            line = line.replace(String.valueOf(Character.toChars(34)), "");
                            line = line.replaceAll(":", "");
                            line = line.replaceAll(",", "");
                            line = line.replaceAll(" ", "");
                            line = line.replaceAll("    ", "");
                            line = line.replaceAll("\n", "");     
                            buffFileStream.append(addTags[i]);
                            buffFileStream.append(" ");
                            buffFileStream.append(line);
                        }  
                    }
                    if (buffFileStream.length() != 0) buffFileStream.append(" ");
                }
                //добавление результат в массив
                if (formDataPrev && ! formData) {
                    buffFileStream.setLength(buffFileStream.length() - 1); //последний пробел лишний
                    outData.add(buffFileStream.toString());
                }

                formDataPrev = formData;      
            }
            inFileStream.close(); 
        }
        
        return outData.toString();
    }

}
