

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends JFrame {

    static boolean gameOver = false;           // a sign game is over or not

    Canvas canvas;                             // canvas object for rendering (drawing)
    Snake snake;                               // declare a snake object
    ArrayList<Cell> food;                      // declare a food object
    ArrayList<Cell> poison;                    // declare a poison object
    UI ui;

    public Game(){
        ui = new UI();
        snake = new Snake(Config.START_SNAKE_X, Config.START_SNAKE_Y, Config.START_SNAKE_SIZE, Config.KEY_RIGHT);
        food = new ArrayList<>();
        poison = new ArrayList<>();
        initResurses();
        ui.snake = snake;
        ui.food = food;
        ui.poison = poison;
    }

    public void logic() {

        while(!gameOver){
            //title change
            if (snake.size() >= Config.START_SNAKE_SIZE) {
                ui.setTitle(Config.TITLE_OF_PROGRAM + " количество очков : " + (snake.size() - Config.START_SNAKE_SIZE));
            }

            //moving
            snake.move();
            
            //self collision
            boolean selfCollision = snake.isCollisionSelf();
           
            //eating
            if (snake.eating(food)) {
                initResurses();
            }

            //poisoning
            if (snake.poisoning(poison)) {
                initResurses();
            }

            if (snake.size() < 1 || selfCollision) {
                gameOver = true;
                ui.setTitle("Конец игры " + Config.TITLE_OF_PROGRAM);
            }
            ui.snake = snake;
            ui.food = food;
            ui.poison = poison;
            ui.repaint();
            sleep(Config.SNAKE_DELAY);
        }
    }

    private void sleep(long ms) {    // method for suspending
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void initResurses(){
        food = new ArrayList<Cell>();
        poison = new ArrayList<Cell>();
        while (food.size() <=  Config.MAX_FOOD_COUNT){
            Cell cell = new Cell(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT, Config.CELL_SIZE, Config.FOOD_COLOR);
            cell.appear(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
            while (snake.isCollision(cell)) {
                cell = new Cell(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT, Config.CELL_SIZE, Config.FOOD_COLOR);
                cell.appear(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
            }
            food.add(cell);
        }

        while (poison.size() <=  Config.MAX_POISON_COUNT){
            Cell cell = new Cell(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT, Config.CELL_SIZE, Config.POISON_COLOR);
            cell.appear(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
            while (snake.isCollision(cell)) {
                cell = new Cell(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT, Config.CELL_SIZE, Config.POISON_COLOR);
                cell.appear(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
            }
            poison.add(cell);
        }
    }

    public static void main(String[] args) {
        new Game().logic();
    }
}
