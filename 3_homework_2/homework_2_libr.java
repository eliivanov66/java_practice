import java.util.logging.Level;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class homework_2_libr {
    //метод получения данных от пользователя
    public static int MyUserInputInt(String text) {
        System.out.println(text);
        Scanner UserInput = new Scanner(System.in);
        int n = 0;
        boolean BadUserInput =  ! UserInput.hasNextInt();

        do {
            BadUserInput =  ! UserInput.hasNextInt();
            if (! BadUserInput) {
                n = UserInput.nextInt();
            }
            else
            {
                System.out.println(String.format("Некорректный ввод. %s", text));
            }
            UserInput = new Scanner(System.in);
        } while (BadUserInput);
        //UserInput.close();
        return n;
    }
    //метод получения данных от пользователя
    public static double MyUserInputDouble(String text) {
        System.out.println(text);
        Scanner UserInput = new Scanner(System.in);
        double n = 0;
        boolean BadUserInput =  ! (UserInput.hasNextInt() || UserInput.hasNextDouble() );

        do {
            BadUserInput =  ! (UserInput.hasNextInt() || UserInput.hasNextDouble() );
            if (! BadUserInput) {
                n = UserInput.nextDouble();
            }
            else
            {
                System.out.println(String.format("Некорректный ввод. %s", text));
            }
            UserInput = new Scanner(System.in);
        } while (BadUserInput);
        //UserInput.close();
        return n;
    }
    //метод получения данных от пользователя
    public static String sqlFilterFormer(String arg) {
        boolean badInputData = false;
        int counter1 = 0; //количество символов :
        int counter2 = 0; //количество символо ,
        String sqlCommand = "";
        
        for (char ch: arg.toCharArray()) {
            if (ch == ':') counter1 ++;
            if (ch == ',') counter2 ++;
        }

        badInputData = ! (counter2 == counter1 - 1) || ! arg.contains("{") || ! arg.contains("}");

        if (! badInputData) {
            arg = arg.replace("{", "");
            arg = arg.replace("}", "");
            String[] tempArg = arg.split(",");
            StringBuilder tempBuilder = new StringBuilder();
            tempBuilder.append("WHERE ");
            for (String tempTempArg : tempArg) {
                if (! tempTempArg.toLowerCase().contains("null")) {
                    tempBuilder.append(tempTempArg.replace(":"," = "));
                    tempBuilder.append(" AND ");
                }    
            }
            tempBuilder.append(";");
            sqlCommand = tempBuilder.toString();
            while (sqlCommand.contains("  ") ) {
                sqlCommand = sqlCommand.replace("  ", " ");
            }
            sqlCommand = sqlCommand.replace(" AND ;", ";");
        }
        else {
            sqlCommand = null;
        }
        
        return sqlCommand;
    }
    //метод записи в лог
    public static void myLoggerWriter(FileHandler argFileHandler, Level argLevel, String argMessage) throws SecurityException, IOException {
        Logger tempLogger = Logger.getLogger(argFileHandler.getClass().getName());
        SimpleFormatter txtFormatter = new SimpleFormatter();
        argFileHandler.setFormatter(txtFormatter);
        tempLogger.setUseParentHandlers(false);  //не показывать в консоли
        
        //чтобы не плодить Handler'ы
        if (tempLogger.getHandlers().length == 0) {
            tempLogger.addHandler(argFileHandler);
        }
        //и сообщение
        tempLogger.log(argLevel, argMessage);
    } 
    //метод пузырьковой сортировки
    public static int[] myBubleSorting(int[] arg, FileHandler argFileHandler) throws SecurityException, IOException {
        
        int temp1 = 0;
        int temp2 = 0;
        StringBuilder messBuilder = new StringBuilder();
        
        if (arg.length != 0) {
            messBuilder.append("Исходный массив до сортировки ");
            messBuilder.append(Arrays.toString(arg));
        }
        else {
            messBuilder.append("Исходный массив пуст");
        }
        
        myLoggerWriter(argFileHandler, Level.INFO, messBuilder.toString() );

        for (int i = 0; i < arg.length - 1; i++) {
            for (int j = 0; j < arg.length - i - 1; j++) {
                temp1 = arg[j];
                temp2 = arg[j + 1];
                if (arg[j] > arg[j + 1]) {
                    arg[j] = temp2;
                    arg[j + 1] = temp1;
                } 
            }
            messBuilder.setLength(0);
            messBuilder.append("Промежуточный результат сортировки ");
            messBuilder.append(i);
            messBuilder.append("ая итерация ");
            messBuilder.append(Arrays.toString(arg));
            myLoggerWriter(argFileHandler, Level.INFO, messBuilder.toString() );
        }
        if (arg.length != 0) {
            messBuilder.setLength(0);
            messBuilder.append("Массив после сортировки ");
            messBuilder.append(Arrays.toString(arg));
            myLoggerWriter(argFileHandler, Level.INFO, messBuilder.toString() );
        }
        return arg;
    }
}
