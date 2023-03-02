import java.util.ArrayList;

public class Toyshop {
    private ArrayList<Toy> parToys;
    
    public Toyshop(int argToyCount){
        parToys = new ArrayList<>();
        for (int i = 0; i < argToyCount; i++) {
            parToys.add(new Toy());
        } 
    }

    public Toyshop(){
        this(1);
    }

    public ArrayList<Toy> getToys(){
        return this.parToys;
    }

    public Toy getToy(int argIndex){
        return this.parToys.get(argIndex);
    }

    public void addToy(Toy argToy){
        this.parToys.add(argToy);
    }

    public void replaceToy(int argIndex, Toy argToy) throws IndexOutOfBoundsException{
        this.parToys.set(argIndex, argToy);
    }
    
    public void removeToy(Toy arToy){
        this.parToys.remove(arToy);
    }

    public int Size(){
        return parToys.size();
    }

    public int getIndex(Toy arToy){
        return this.parToys.indexOf(arToy);
    }
}
