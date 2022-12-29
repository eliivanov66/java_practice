
public class program {
    public static void main(String[] args) {
        child<Integer> intChild = new child<Integer>(14);
        child<Double> doubChild = new child<Double>(2.6);
        child<String> stringChild = new child<String>("sda");

        parent<Boolean> boolParent = new child<Boolean>(false);

        intChild.getInfo();
        doubChild.getInfo();
        stringChild.getInfo();
        ((child)(boolParent)).getInfo();
    }
}
