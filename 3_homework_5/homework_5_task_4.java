import java.util.Arrays;

// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.

public class homework_5_task_4 {
    public static void main(String[] args) {
        Integer [][] chessField = new Integer [8][8];
        chessField = chessInit(chessField);
        chessField[4][3] = 2;
        chessField = chessAnalyze(chessField, 4,3);
        chessDisplay(chessField);
    }

    public static Integer[][] chessInit(Integer[][] arg) {
        for (int i = 0; i < arg.length; i++) {
            for (int j = 0; j < arg[i].length; j++) {
                arg[i][j] = 0;
            }
        }
        return arg;
    }

    public static void chessDisplay(Integer[][] arg) {
        System.out.println("Шахматная доска: ");
        for (int i = 0; i < arg.length; i++) {
            System.out.println(Arrays.toString(arg[i]));
        } 
    }

    public static Integer[][] chessAnalyze(Integer[][] arg, int x, int y) {
        for (int i = 0; i < arg.length; i++) {
            for (int j = 0; j < arg[i].length; j++) {
                if (i == x) arg[i][j] = 1; //горизонталь
                if (j == y) arg[i][j] = 1; //вертикаль
            }  
        }

        for (int i = 0; i < arg.length; i++) { //диагонали
            if (x >= i) {
                if (y >= i)                    arg[x - i][y - i] = 1; //левая ветка
                if (y + i <= arg.length - 1)   arg[x - i][y + i] = 1; //правая ветка
            }
            else {

            } 
        }
        arg[x][y] = 2;

        return arg; 
    }
}
