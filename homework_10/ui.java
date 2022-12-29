public class ui {
    
    public static void display(int[][] argField) {
        int maxLenght = Integer.toString(argField[0][0]).length();
        StringBuilder myBuilder = new StringBuilder();
        String tempString;
        int tempLenght;
        //поиск максимального элемента
        for (int i = 0; i < argField.length; i++) {
            for (int j = 0; j < argField[i].length; j++) {
               tempLenght = Integer.toString(argField[i][j]).length();
               if (tempLenght > maxLenght) maxLenght = tempLenght; 
            }
        }
        
        //отрисовка
        for (int i = 0; i < argField.length; i++) {
            for (int j = 0; j < argField[i].length; j++) {
                tempLenght = Integer.toString(argField[i][j]).length();
                tempString = " ".repeat(maxLenght - tempLenght);
                myBuilder.append(tempString);
                if (argField[i][j] != 0) {
                    myBuilder.append(Integer.toString(argField[i][j]));
                } else {
                    myBuilder.append(" ");
                }
                
                
                //myBuilder.append(","); 
            }
            myBuilder.append("\n"); 
        }

        System.out.println(myBuilder.toString());
    }
}
