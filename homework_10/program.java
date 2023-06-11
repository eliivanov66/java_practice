public class program {
    public static void main(String[] args) {
        
        //инициализация лабиринта
        labyrint myLab = new labyrint(16,16, -1);
        //расположить выход
        myLab.placeExit();
        //расположить кота
        myLab.placeCat();
        //отображение лабиринта
        System.out.printf("Начальный лабиринт, где %d - это стена, %d - кот, %d - выход\n", myLab.getWall(), myLab.getCat().value, myLab.getExit().value);
        Ui.display(myLab.getField());
        //инициализация поиска пути в начале с точкой расположения кота
        pathFinder myPath = new pathFinder(myLab.getCat());
        myPath.pathFind(myLab);
        //отображение лабиринта после поиска
        System.out.printf("Результат поиска пути к выходу для кот:\n");
        Ui.display(myLab.getField());
        //отображение результата        
        if (myPath.exitFound) {
            System.out.printf("Выход найден в точке: (%d,%d)\n", myPath.exitPoint.x, myPath.exitPoint.y);
            int[][] wayOut = myPath.pathMark(myLab, 1);
            System.out.printf("Путь к выходу:\n");
            Ui.display(wayOut);
        }
        else {
            System.out.printf("Коту не удалось найти выход из лабиринта (((");
        }
    }
}
