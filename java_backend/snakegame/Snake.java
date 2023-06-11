

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Snake {
    private LinkedList<Cell> snake;
    private int direction;
    public Snake(int x, int y, int length, int direction) {
        snake = new LinkedList<>();
        for(int i = 0; i < length; i++){
            snake.add(new Cell(x-i, y, Config.CELL_SIZE, Config.SNAKE_COLOR));
        }
        this.direction = direction;
    }

    public int size(){
        return snake.size();
    }

    public void remove(){
        snake.removeLast();
    }

    public void add(Cell e){
        snake.addFirst(e);
    }

    public Cell getHead(){
        return snake.getFirst();
    }

    public void setDirection(int direction) {
        if ((direction >= Config.KEY_LEFT) && (direction <= Config.KEY_DOWN)) {
            if (Math.abs(this.direction - direction) != 2) {
                this.direction = direction;
            }
        }
    }

    public void move() {
        int x = snake.getFirst().getX();
        int y = snake.getFirst().getY();
        switch (direction) {
            case Config.KEY_LEFT: x--;
                if (x < 0)
                    x = Config.CANVAS_WIDTH - 1;
                break;
            case Config.KEY_RIGHT: x++;
                if (x == Config.CANVAS_WIDTH)
                    x = 0;
                break;
            case Config.KEY_UP: y--;
                if (y < 0)
                    y = Config.CANVAS_HEIGHT - 1;
                break;
            case Config.KEY_DOWN: y++;
                if (y == Config.CANVAS_HEIGHT)
                    y = 0;
                break;
        }

        snake.addFirst(new Cell(x, y, Config.CELL_SIZE, Config.SNAKE_COLOR)); // new head of snake
        snake.removeLast();
    }

    public boolean eating(ArrayList<Cell> food){
        //eating
        for (Cell cell : food) {
            if (snake.getFirst().isCollision(cell)) {
                //this.add(cell);
                snake.addLast(cell);
                return true;
            }
        }
        return false;
    }

    public boolean poisoning(ArrayList<Cell> food){
        //eating
        for (Cell cell : food) {
            if (snake.getFirst().isCollision(cell)) {
                //this.remove();
                snake.removeLast();
                return true;
            }
        }
        return false;
    }
    
    public boolean isCollision(Cell e){
        for (Cell cell : snake) {
            if (cell.isCollision(e)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCollisionSelf(){
        for (Cell cell : snake) {
            if (snake.getFirst().isCollision(cell) && ! snake.getFirst().equals(cell)) {                
                return true;
            }
        }
        return false;
    }

    public void paint(Graphics2D g) {
        for (Cell cell : snake) {
            if (cell.equals(snake.getFirst())) {
                cell.setColor(Config.SNAKE_HEAD_COLOR);
            } else {
                cell.setColor(Config.SNAKE_COLOR);
            }
            cell.paint(g);
        }
    }
}
