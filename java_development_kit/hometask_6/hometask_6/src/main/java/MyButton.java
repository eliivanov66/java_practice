import javax.swing.*;

public class MyButton extends JButton {
    public int getIndex() {
        return index;
    }

    private int index;

    public MyButton(String text, int index) {
        super(text);
        this.index = index;
    }

    public MyButton(int index) {
        super();
        this.index = index;
    }


}
