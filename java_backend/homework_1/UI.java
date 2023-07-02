import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class UI extends JFrame {
    public Canvas canvas;
    public Snake snake;
    public ArrayList<Cell> food;
    public ArrayList<Cell> poison;

    public UI(){
        setTitle(Config.TITLE_OF_PROGRAM);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        canvas = new Canvas();
        canvas.setBackground(Color.black);
        canvas.setPreferredSize(new Dimension(Config.CELL_SIZE * Config.CANVAS_WIDTH, Config.CELL_SIZE * Config.CANVAS_HEIGHT));
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                snake.setDirection(e.getKeyCode());
            }
        });
        add(canvas);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }



    public void repaint(){
        canvas.repaint();
    }

    class Canvas extends JPanel {    // class for rendering (drawing)
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2D = (Graphics2D) g;
            g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            snake.paint(g2D);
            for (Cell cell : food) {
                cell.paint(g2D);
            }
            for (Cell cell : poison) {
                cell.paint(g2D);
            }
        }
    }
}
