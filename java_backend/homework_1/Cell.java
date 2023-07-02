

import java.awt.*;
import java.util.Random;

public class Cell {
    private int x, y;
    private int size;
    private Color color;
    private Random random = new Random();

    public Cell(int x, int y, int size, Color color){
        set(x, y);
        setSize(size);
        setColor(color);
    }

    public int getX() {
        return x;
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isCollision(int x, int y) {
        return (getX() == x && getY() == y);
    }

    public boolean isCollision(Cell e) {
        return (e.getX() == this.x && e.getY() == this.y);
    }

    public void appear(int width, int height){
        int x, y;
        x = random.nextInt(width);
        y = random.nextInt(height);
        set(x, y);
    }

    public void paint(Graphics2D g) {         // object rendering
        g.setColor(color);
        g.fillRect(x * size, y * size,        // upper left corner
                size, size);                  // width and height
    }
}
