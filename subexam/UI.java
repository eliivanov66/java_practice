import java.util.Scanner;
public class UI{
    
    public void userOut(String argMsg) {
        System.out.println(argMsg);
    }

    public int userInputIntAck(String argMsg){
        boolean valueBad = true;
        int tempOut = 0;
        Scanner in = new Scanner(System.in);
        String key = "";
        while (valueBad){
            in = new Scanner(System.in);
            try {
                this.userOut(argMsg);
                tempOut = in.nextInt();
                valueBad = false;
            } catch (Exception e) {
                valueBad = true;
                this.userOut("Некорректный ввод");
            }

            if (!valueBad) {
                key = "";
                while (! key.toLowerCase().equals("n") && ! key.toLowerCase().equals("y")) {
                    in = new Scanner(System.in);
                    this.userOut(String.format("Вы ввели %d, скорректировать ввод?\nY/N ?", tempOut));
                    key = in.nextLine();
                    if (key.toLowerCase().equals("y")) valueBad = true;
                }
            }

        }
        //in.close();
        return tempOut;
    }

    public int userInputInt(String argMsg){
        boolean valueBad = true;
        int tempOut = 0;
        Scanner in = new Scanner(System.in);
        String key = "";
        while (valueBad){
            in = new Scanner(System.in);
            try {
                this.userOut(argMsg);
                tempOut = in.nextInt();
                valueBad = false;
            } catch (Exception e) {
                valueBad = true;
                this.userOut("Некорректный ввод");
            }
        }
        //in.close();
        return tempOut;
    }

    public String userInputStringAck(String argMsg){
        boolean valueBad = true;
        String tempOut = "";
        Scanner in = new Scanner(System.in);
        String key = "";
        while (valueBad){
            in = new Scanner(System.in);
            try {
                this.userOut(argMsg);
                tempOut = in.nextLine();
                valueBad = false;
            } catch (Exception e) {
                valueBad = true;
                this.userOut("Некорректный ввод");
            }

            if (!valueBad) {
                key = "";
                while (! key.toLowerCase().equals("n") && ! key.toLowerCase().equals("y")) {
                    in = new Scanner(System.in);
                    this.userOut(String.format("Вы ввели %s, скорректировать ввод?\nY/N ?", tempOut));
                    key = in.nextLine();
                    if (key.toLowerCase().equals("y")) valueBad = true;
                }
            }

        }
        //in.close();
        return tempOut;
    }

}

