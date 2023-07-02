
import java.awt.*;

public class Config {
    public final static String TITLE_OF_PROGRAM = "Classic Game Snake";
    public final static String GAME_OVER_MSG = "GAME OVER";
    public final static int CELL_SIZE = 20;           // size of cell in pix
    public final static int CANVAS_WIDTH = 30;        // width in cells
    public final static int CANVAS_HEIGHT = 25;       // height in cells
    public final static Color SNAKE_COLOR = Color.green;
    public final static Color SNAKE_HEAD_COLOR = Color.CYAN;
    public final static Color FOOD_COLOR = Color.blue;
    public final static Color POISON_COLOR = Color.red;
    public final static int KEY_LEFT = 37;            // codes
    public final static int KEY_UP = 38;              //   of
    public final static int KEY_RIGHT = 39;           //   cursor
    public final static int KEY_DOWN = 40;            //   keys
    public final static int START_SNAKE_SIZE = 3;            // initialization data
    public final static int START_SNAKE_X = CANVAS_WIDTH/2;  //   for
    public final static int START_SNAKE_Y = CANVAS_HEIGHT/2; //   snake
    public final static int SNAKE_DELAY = 250;               // snake delay in milliseconds
    public final static int MAX_FOOD_COUNT = 10;      // max count of food
    public final static int MAX_POISON_COUNT = 10;    // max count of poison
}
