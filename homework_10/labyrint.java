import java.util.Random;

public class labyrint {
    private Random rand = new Random();
    private int[][] field;
    private int wallValue;
    private int emptyValue;
    private int xSize;
    private int ySize;
    private point exit = new point();
    private point cat = new point();

    /*** Конструктор основной
     * 
     * @param argXsize //размерность лабиринта по X
     * @param argYsize //размерность лабиринта по Y
     * @param argWall //значение информирующее о том что это стена
     */

    labyrint(int argXsize, int argYsize, int argWall){
        //формирование поля
        this.field = new int[argXsize][argYsize];
        this.xSize = argXsize;
        this.ySize = argYsize;
        this.wallValue = - Math.abs(argWall);
        this.emptyValue = 0;
        for (int i = 0; i < field.length; i++) { //y
            for (int j = 0; j < field[i].length; j++) { //x
                
                if ((i == 0) || (i == field.length - 1) ) {
                    field[i][j] = this.wallValue; //внешняя стена
                } 
                if ((j == 0) || (j == field[i].length - 1) ) {
                    field[i][j] = this.wallValue; //внешняя стена
                }

            }
        }
        formLabyrint(); //формирование внутренних стен
    }

    public labyrint() {
    }

    /*** Возвращает размерность X */
    public int getXsize(){
        return this.xSize;
    }
    
    /*** Возвращает размерность Y */
    public int getYsize(){
        return this.ySize;
    }

    /*** Возвращает значение информирующее о том что элемент является стеной */
    public int getWall(){
        return this.wallValue;
    }

    /*** Возвращает значение информирующее о том место свободно */
    public int getEmpty(){
        return this.emptyValue;
    }

    /*** Возвращает значение выхода */
    public point getExit(){
        return this.exit;
    }

    
    /*** Возвращает значение кота */
    public point getCat(){
        return this.cat;
    }

    /*** Возвращает размерность поле лабиринта */
    public int[][] getField(){
        return this.field;
    }


    /*** устанавливает размерность X */
    public void setXsize(int arg){
        this.xSize = arg;
    }
    
    /*** устанавливает размерность Y */
    public void setYsize(int arg){
        this.ySize = arg;
    }

    /*** устанавливает значение информирующее о том что элемент является стеной */
    public void setWall(int arg){
        this.wallValue = arg;
    }

    /*** устанавливает значение информирующее о том место свободно */
    public void setEmpty(int arg){
        this.emptyValue = arg;
    }

    /*** устанавливает значение выхода */
    public void setExit(point arg){
        this.exit = arg;
    }

    
    /*** устанавливает значение кота */
    public void setCat(point arg){
        this.cat = arg;
    }

    /*** устанавливает размерность поле лабиринта */
    public void setField(int[][] arg){
        this.field = new int[arg.length][arg[0].length];
        for (int i = 0; i < arg.length; i++) {
            for (int j = 0; j < arg[i].length; j++) {
                this.field[i][j] = arg[i][j];
            }
        }
    }


    /*** расставляет выход */
    public void placeExit(){
        int tempX = rand.nextInt(this.xSize);
        int tempY = rand.nextInt(this.ySize);

        while (this.field[tempX][tempY] == this.wallValue) {
            tempX = rand.nextInt(this.xSize);
            tempY = rand.nextInt(this.ySize);
        }
        this.field[tempX][tempY] = this.wallValue - 1;
        this.exit.x = tempX;
        this.exit.y = tempY;
        this.exit.value = this.wallValue - 1;
    }

    /*** расставляет выход */
    public void placeCat(){
        int tempX = rand.nextInt(this.xSize);
        int tempY = rand.nextInt(this.ySize);
    
        while (this.field[tempX][tempY] == this.wallValue) {
            tempX = rand.nextInt(this.xSize);
            tempY = rand.nextInt(this.ySize);
        }
        this.field[tempX][tempY] = this.wallValue - 2;
        this.cat.x = tempX;
        this.cat.y = tempY;
        this.cat.value = this.wallValue - 2;
    }

    /*** возвращает значение из ячейки */
    public int getValue(int argX, int argY){
        return this.field[argX][argY];
    }

    /*** устанавливает значение ячейки */
    public void setValue(int argX, int argY, int argValue){
        this.field[argX][argY] = argValue;
    }

    /*** алгоритм создающий внутренние стены */
    private void formLabyrint(){
        for (int i = 1; i < this.field.length -1 ; i++) { //y
            for (int j = 1; j < this.field[i].length - 1; j++) { //x
                if ((i % 2 == 0) && (j % 2 == 0)) {
                    this.field[i][j] = this.wallValue;
                }
            }
        }
    };

    /*** копирование лабиринтов */
    public labyrint copLabyrint(){
        labyrint temp = new labyrint();
        temp.setField(this.field);
        temp.setWall(this.wallValue);
        temp.setEmpty(this.emptyValue);
        temp.setXsize(this.xSize);
        temp.setYsize(this.ySize);
        temp.setCat(this.cat);
        temp.setExit(this.exit);
        return temp;
    }
}
