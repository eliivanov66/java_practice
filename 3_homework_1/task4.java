import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
4.  Задано уравнение вида q + w = e, где q, w, e >= 0. 
    Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69. 
    Требуется восстановить выражение до верного равенства. 
    Предложить хотя бы одно решение или сообщить, что его нет.
*/

public class task4 {
    public static void main(String[] args) {
        Scanner UserInput = new Scanner(System.in);
        System.out.println("Введите уровнение в виде q? + w? = e \nНекоторые цифры могут быть заменены знаком вопроса:");
        String UserString = UserInput.nextLine();
        boolean UserInputOk = false;
        String[] MyDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        List<Integer> MyList_Left = new ArrayList<Integer>();
        List<Integer> MyList_Right = new ArrayList<Integer>();
        List<Integer> MyList_Result = new ArrayList<Integer>();
        String[] TempArray;

        //========== проверка на корректность ввода ============
        int qCount = 0;
        int eqCount = 0;
        int pCount = 0;
        int spcCount = 0;
        
        while (UserString.contains("  ")) {
            UserString = UserString.replace("  ", " ");
        }
        
        for (int index = 0; index < UserString.length(); index++) {
            if (UserString.charAt(index) == ' ') {
                spcCount ++;
            }
            
            if (UserString.charAt(index) == '?') {
                qCount ++;
            }

            if (UserString.charAt(index) == '=') {
                eqCount ++;
            }

            if (UserString.charAt(index) == '+') {
                pCount ++;
            }

            if (eqCount > pCount) { //равно стоит раньше плюса
                UserInputOk = false; 
                break; 
            }
        }

        if ( (pCount == 1) && (eqCount == 1) && (spcCount == 4)) { //(qCount <= 3) &&
            UserInputOk = true;
        }
        else {
            UserInputOk = false;
        }

        try {
            UserString.split(" ", 0);
        } catch (Exception e) {
            UserInputOk = false;
        } 

        //========================================================
        if (UserInputOk) {
            TempArray = UserString.split(" ", 0);
            boolean LeftValueUnknown = false;
            boolean RightValueUnknown = false; 
            boolean ResultValueUnknown = false;

            int LeftValue = -1;
            int RightValue = -1;
            int ResultValue = -1;

            try {
                Integer.parseInt(TempArray[0]);
            } catch (Exception e) {
                LeftValueUnknown = true;
            } finally {
                if (! LeftValueUnknown) LeftValue = Integer.valueOf(TempArray[0]);
            }

            try {
                Integer.parseInt(TempArray[2]);
            } catch (Exception e) {
                RightValueUnknown = true;
            } finally {
                if (! RightValueUnknown) RightValue = Integer.valueOf(TempArray[2]);
            }

            try {
                Integer.parseInt(TempArray[4]);
            } catch (Exception e) {
                ResultValueUnknown = true;
            } finally {
                if (! ResultValueUnknown) ResultValue = Integer.valueOf(TempArray[4]);
            }
            
            //неизвестна левая часть
            if ( (LeftValueUnknown) && (!RightValueUnknown) && (!ResultValueUnknown) ) { 
                LeftValue = ResultValue - RightValue;
                MyList_Left.add(LeftValue);
                MyList_Right.add(RightValue);
                MyList_Result.add(ResultValue); 
            }
            //неизвестна правая часть
            if ( (!LeftValueUnknown) && (RightValueUnknown) && (!ResultValueUnknown) ) { 
                RightValue = ResultValue - LeftValue;
                MyList_Left.add(LeftValue);
                MyList_Right.add(RightValue);
                MyList_Result.add(ResultValue);  
            }
            //неизвестна результирующая часть часть
            if ( (!LeftValueUnknown) && (!RightValueUnknown) && (ResultValueUnknown) ) { 
                ResultValue = LeftValue + RightValue;
                MyList_Left.add(LeftValue);
                MyList_Right.add(RightValue);
                MyList_Result.add(ResultValue);  
            }
            //неизвестна левая часть и правая часть
            if ( (LeftValueUnknown) && (RightValueUnknown) && (!ResultValueUnknown) ) { 
                String TempLeftValue;
                String TempRightValue;
                int TempLeft = 0;
                int TempRight = 0;
                for (int i = 0; i < MyDigits.length; i++) {
                    TempLeftValue = TempArray[0].replace("?", MyDigits[i]);
                    for (int j = 0; j < MyDigits.length; j++) {
                        TempRightValue = TempArray[2].replace("?", MyDigits[j]);
                        try {
                            Integer.parseInt(TempLeftValue);
                            Integer.parseInt(TempRightValue);
                        } catch (Exception e) {
                            break;
                        }  finally {
                            TempLeft = Integer.parseInt(TempLeftValue);
                            TempRight = Integer.parseInt(TempRightValue);
                            if ((TempLeft + TempRight) == ResultValue ) {
                                LeftValueUnknown = false;
                                RightValueUnknown = false;
                                LeftValue = TempLeft;
                                RightValue = TempRight;
                                MyList_Left.add(LeftValue);
                                MyList_Right.add(RightValue);
                                MyList_Result.add(ResultValue); 
                            }
                        }
                    }
                }

            }
            //неизвестна левая часть и результирующая часть
            if ( (LeftValueUnknown) && (!RightValueUnknown) && (ResultValueUnknown) ) { 
                String TempLeftValue;
                String TempResultValue;
                int TempLeft = 0;
                int TempResult = 0;
                for (int i = 0; i < MyDigits.length; i++) {
                    TempLeftValue = TempArray[0].replace("?", MyDigits[i]);
                    for (int j = 0; j < MyDigits.length; j++) {
                        TempResultValue = TempArray[4].replace("?", MyDigits[j]);
                        try {
                            Integer.parseInt(TempLeftValue);
                            Integer.parseInt(TempResultValue);
                        } catch (Exception e) {
                            break;
                        }  finally {
                            TempLeft = Integer.parseInt(TempLeftValue);
                            TempResult = Integer.parseInt(TempResultValue);
                            if ((TempLeft + RightValue) == TempResult ) {
                                LeftValueUnknown = false;
                                ResultValueUnknown = false;
                                LeftValue = TempLeft;
                                ResultValue = TempResult;
                                MyList_Left.add(LeftValue);
                                MyList_Right.add(RightValue);
                                MyList_Result.add(ResultValue);
                            }
                        }
                    }
                }

            }

            //неизвестна правая часть и результирующая часть
            if ( (!LeftValueUnknown) && (RightValueUnknown) && (ResultValueUnknown) ) { 
                String TempRightValue;
                String TempResultValue;
                int TempRight = 0;
                int TempResult = 0;
                for (int i = 0; i < MyDigits.length; i++) {
                    TempRightValue = TempArray[2].replace("?", MyDigits[i]);
                    for (int j = 0; j < MyDigits.length; j++) {
                        TempResultValue = TempArray[4].replace("?", MyDigits[j]);
                        try {
                            Integer.parseInt(TempRightValue);
                            Integer.parseInt(TempResultValue);
                        } catch (Exception e) {
                            break;
                        }  finally {
                            TempRight = Integer.parseInt(TempRightValue);
                            TempResult = Integer.parseInt(TempResultValue);
                            if ((LeftValue + TempRight) == TempResult ) {
                                RightValueUnknown = false;
                                ResultValueUnknown = false;
                                RightValue = TempRight;
                                ResultValue = TempResult;
                                MyList_Left.add(LeftValue);
                                MyList_Right.add(RightValue);
                                MyList_Result.add(ResultValue);
                            }
                        }
                    }
                }

            }


            //неизвестны все части уровнения
            if ( (LeftValueUnknown) && (RightValueUnknown) && (ResultValueUnknown) ) { 
                String TempLeftValue;
                String TempRightValue;
                String TempResultValue;
                int TempLeft = 0;
                int TempRight = 0;
                int TempResult = 0;
                for (int i = 0; i < MyDigits.length; i++) {
                    TempLeftValue = TempArray[0].replace("?", MyDigits[i]);
                    for (int j = 0; j < MyDigits.length; j++) {
                        TempRightValue = TempArray[2].replace("?", MyDigits[j]);
                        for (int k = 0; k < MyDigits.length; k++) {
                            TempResultValue = TempArray[4].replace("?", MyDigits[k]); 

                            try {
                                Integer.parseInt(TempLeftValue);
                                Integer.parseInt(TempRightValue);
                                Integer.parseInt(TempResultValue);
                            } catch (Exception e) {
                                break;
                            }  finally {
                                TempLeft = Integer.parseInt(TempLeftValue);
                                TempRight = Integer.parseInt(TempRightValue);
                                TempResult = Integer.parseInt(TempResultValue);
                                if ((TempLeft + TempRight) == TempResult ) {
                                    LeftValueUnknown = false;
                                    RightValueUnknown = false;
                                    ResultValueUnknown = false;
                                    LeftValue = TempLeft;
                                    RightValue = TempRight;
                                    ResultValue = TempResult;
                                    MyList_Left.add(LeftValue);
                                    MyList_Right.add(RightValue);
                                    MyList_Result.add(ResultValue);
                                }
                            }
                        }
                    }
                }

            }

            if ( (! LeftValueUnknown) && (! RightValueUnknown) && (! ResultValueUnknown) ) {
                System.out.println(String.format("Вы ввели уравнение: %s", UserString));
                for (int i = 0; i < MyList_Result.size(); i++) {
                    System.out.println(String.format("Алгоритм разрешил его как : %d + %d = %d", MyList_Left.get(i), MyList_Right.get(i), MyList_Result.get(i)));
                }
            }
            else {
                System.out.println(String.format("Вы ввели уравнение: %s", UserString));
                System.out.println(String.format("Алгоритм не смог решить уравнение"));  
            }
        }
        else {
            System.out.println("Некорректный ввод");
        }
        UserInput.close();
    }
    
}
