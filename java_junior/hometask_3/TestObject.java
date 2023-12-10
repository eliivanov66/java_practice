import java.io.Serializable;
import java.util.Random;

public class TestObject implements Serializable {
    private Integer first;
    private Integer second;
    private Integer third;
    private Random rand = new Random();

    public TestObject(){
        first = rand.nextInt();
        second = rand.nextInt();
        third = rand.nextInt(); 
    }

    @Override
    public String toString() {
        return String.format("first: %d, second: %d, third: %d", first, second, third);
    }
}
