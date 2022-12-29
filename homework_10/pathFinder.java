import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
/*** алгоритмы поиска пути к выходу из лабиринта */
public class pathFinder {
    
    public Queue <point> order = new ArrayDeque <point>();
    public Queue <point> way = new ArrayDeque <point>();
    public point exitPoint = new point();
    public boolean exitFound = false;

    pathFinder(point startPoint) {
        order.add(startPoint);
    }

    /*** Метод поиска пути в лабиринте     
    порядок поиска:
        1. вверх
        2. вправо
        3. вниз
        4. влево
     */
    public void pathFind(labyrint argLab) {
        while (! this.order.isEmpty()) {
            point checkPoint = this.order.poll();
            //Проверка верхней клетки
            if (checkPoint.x + 1 < argLab.getXsize()) {
                //пустая клетка, можем туда двигаться
                if (argLab.getValue(checkPoint.x + 1, checkPoint.y) == argLab.getEmpty()) {
                    int tempX = checkPoint.x + 1;
                    int tempY = checkPoint.y;
                    int tempValue;
                    if (checkPoint.value >= 1) {
                        tempValue = checkPoint.value + 1;
                    } else {
                        tempValue = 1;
                    }
                    point tempPoint = new point();
                    
                    argLab.setValue(tempX, tempY, tempValue);
                    tempPoint.x = tempX;
                    tempPoint.y = tempY;
                    tempPoint.value = tempValue;
                        
                    this.order.add(tempPoint);
                }
                //найден выход
                if (argLab.getValue(checkPoint.x + 1, checkPoint.y) == argLab.getExit().value) {
                    exitPoint.x = checkPoint.x + 1;
                    exitPoint.y = checkPoint.y;
                    exitFound = true;
                    break;
                }
            } 
            //Проверка правой клетки
            if (checkPoint.y + 1 < argLab.getYsize()) {
                //пустая клетка, можем туда двигаться
                if (argLab.getValue(checkPoint.x, checkPoint.y + 1) == argLab.getEmpty()) {
                    int tempX = checkPoint.x;
                    int tempY = checkPoint.y + 1;
                    int tempValue;
                    if (checkPoint.value >= 1) {
                        tempValue = checkPoint.value + 1;
                    } else {
                        tempValue = 1;
                    }
                    point tempPoint = new point();
                        
                    argLab.setValue(tempX, tempY, tempValue);
                    tempPoint.x = tempX;
                    tempPoint.y = tempY;
                    tempPoint.value = tempValue;
                        
                    this.order.add(tempPoint);
                }
                //найден выход
                if (argLab.getValue(checkPoint.x, checkPoint.y + 1) == argLab.getExit().value) {
                    exitPoint.x = checkPoint.x;
                    exitPoint.y = checkPoint.y + 1;
                    exitFound = true;
                    break;
                }
            } 
            //Проверка нижней клетки
            if (checkPoint.x - 1 > 0 ) {
                //пустая клетка, может туда двигаться
                if (argLab.getValue(checkPoint.x - 1, checkPoint.y) == argLab.getEmpty()) {
                    int tempX = checkPoint.x - 1;
                    int tempY = checkPoint.y;
                    int tempValue;
                    if (checkPoint.value >= 1) {
                        tempValue = checkPoint.value + 1;
                    } else {
                        tempValue = 1;
                    }
                    point tempPoint = new point();
                        
                    argLab.setValue(tempX, tempY, tempValue);
                    tempPoint.x = tempX;
                    tempPoint.y = tempY;
                    tempPoint.value = tempValue;
                        
                    this.order.add(tempPoint);
                }
                //найден выход
                if (argLab.getValue(checkPoint.x - 1, checkPoint.y) == argLab.getExit().value) {
                    exitPoint.x = checkPoint.x - 1;
                    exitPoint.y = checkPoint.y;
                    exitFound = true;
                    break;
                }
            } 
            //Проверка нижней клетки
            if (checkPoint.y - 1 > 0 ) {
                //пустая клетка, можем туда двигаться
                if (argLab.getValue(checkPoint.x, checkPoint.y - 1) == argLab.getEmpty()) {
                    int tempX = checkPoint.x;
                    int tempY = checkPoint.y - 1;
                    int tempValue;
                    if (checkPoint.value >= 1) {
                        tempValue = checkPoint.value + 1;
                    } else {
                        tempValue = 1;
                    }
                    point tempPoint = new point();
                    
                    argLab.setValue(tempX, tempY, tempValue);
                    tempPoint.x = tempX;
                    tempPoint.y = tempY;
                    tempPoint.value = tempValue;
                        
                    this.order.add(tempPoint);
                }
                //найден выход
                if (argLab.getValue(checkPoint.x, checkPoint.y - 1) == argLab.getExit().value) {
                    exitPoint.x = checkPoint.x;
                    exitPoint.y = checkPoint.y - 1;
                    exitFound = true;
                    break;
                }
            } 

        }
    }
    
    /*** Метод формирующий путь к выходу    
    порядок поиска:
        1. вверх
        2. вправо
        3. вниз
        4. влево
    */
    public int[][] pathMark(labyrint argLab, int argMark){
        int[][] tempField = new int[argLab.getXsize()][argLab.getYsize()]; //поле результат
        
        tempField[argLab.getCat().x][argLab.getCat().y] = argLab.getCat().value; //кот
        tempField[this.exitPoint.x][this.exitPoint.y] = argLab.getExit().value; //выход
        for (int i = 0; i < tempField.length; i++) { //y
            for (int j = 0; j < tempField[i].length; j++) { //x
                
                if ((i == 0) || (i == tempField.length - 1) ) {
                    tempField[i][j] = argLab.getWall(); //внешняя стена
                } 
                if ((j == 0) || (j == tempField[i].length - 1) ) {
                    tempField[i][j] = argLab.getWall(); //внешняя стена
                }

            }
        }
        point checkPoint = this.exitPoint;
        //while (checkPoint.x != argLab.getCat().x && checkPoint.y != argLab.getCat().y ) { //XOR
        int count = 0;
        while ( count < argLab.getXsize() * argLab.getYsize())  { //XOR
            count ++;
            ArrayList<point> tempList = new ArrayList<>();
            //Проверка левой клетки
            if (checkPoint.y - 1 > 0 ) {
                point tempPoint = new point();
                tempPoint.x = checkPoint.x;
                tempPoint.y = checkPoint.y - 1;
                tempPoint.value = argLab.getValue(tempPoint.x, tempPoint.y );
                if (tempPoint.value != argLab.getWall() && 
                    tempPoint.value != argLab.getEmpty() && 
                    tempPoint.value != argLab.getCat().value &&
                    tempPoint.value != argLab.getExit().value
                    ) {
                        tempList.add(tempPoint);     
                }
            }
            //Проверка нижней клетки
            if (checkPoint.x - 1 > 0 ) {
                point tempPoint = new point();
                tempPoint.x = checkPoint.x - 1;
                tempPoint.y = checkPoint.y;
                tempPoint.value = argLab.getValue(tempPoint.x, tempPoint.y );
                tempPoint.value = argLab.getValue(tempPoint.x, tempPoint.y );
                if (tempPoint.value != argLab.getWall() && 
                    tempPoint.value != argLab.getEmpty() && 
                    tempPoint.value != argLab.getCat().value &&
                    tempPoint.value != argLab.getExit().value
                    ) {
                        tempList.add(tempPoint);     
                }
            } 
            //Проверка правой клетки
            if (checkPoint.y + 1 < argLab.getYsize()) {
                point tempPoint = new point();
                tempPoint.x = checkPoint.x;
                tempPoint.y = checkPoint.y + 1;
                tempPoint.value = argLab.getValue(tempPoint.x, tempPoint.y );
                tempPoint.value = argLab.getValue(tempPoint.x, tempPoint.y );
                if (tempPoint.value != argLab.getWall() && 
                    tempPoint.value != argLab.getEmpty() && 
                    tempPoint.value != argLab.getCat().value &&
                    tempPoint.value != argLab.getExit().value
                    ) {
                        tempList.add(tempPoint);     
                }
            } 
            //Проверка верхней клетки
            if (checkPoint.x + 1 < argLab.getXsize()) {
                point tempPoint = new point();
                tempPoint.x = checkPoint.x + 1;
                tempPoint.y = checkPoint.y;
                tempPoint.value = argLab.getValue(tempPoint.x, tempPoint.y );
                tempPoint.value = argLab.getValue(tempPoint.x, tempPoint.y );
                if (tempPoint.value != argLab.getWall() && 
                    tempPoint.value != argLab.getEmpty() && 
                    tempPoint.value != argLab.getCat().value &&
                    tempPoint.value != argLab.getExit().value
                    ) {
                        tempList.add(tempPoint);     
                }
            } 
            //ищем наибольшее число и движемся по нему 
            if (tempList.size()>0) {
                checkPoint = findMin(tempList);
                way.add(checkPoint);
                tempField[checkPoint.x][checkPoint.y] = argMark;
            }            
        }
        return tempField;
    }

    private point findMin(ArrayList<point> arg){
        int min = arg.get(0).value;
        int index = 0;
        for (point i : arg) {
            if (i.value < min) {
                min = i.value;
                index = arg.indexOf(i);
            } 
        }
        return arg.get(index);
    }

}
