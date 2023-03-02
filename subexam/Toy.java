import java.util.Random;

public class Toy {
    private static int countID = 0;
    private int parID;
    private String parName;
    private int parPower;

    public Toy(int argID, String argName, int argPower) {
        if (argPower < 0) {
            argPower = 0;
        }
        if (argPower > 100) { 
            argPower = 100;
        }
        this.parID = argID;
        this.parName = argName;
        this.parPower = argPower; 
    }

    public Toy(String argName, int argPower) {
        this(Toy.countID ++, argName, argPower);
    }

    public Toy(){
        this(String.format("toy %s", String.valueOf(Toy.countID)), //argName
              new Random().nextInt(0, 100));                //argPower
    }

    public int getID(){
        return this.parID;
    }

    public String getName(){
        return this.parName;
    }

    public int getPower(){
        return this.parPower;
    }

    public void setName(String argName){
        this.parName = argName;
    }

    public void setPower(int argPower){
        if (argPower < 0) {
            argPower = 0;
        }
        if (argPower > 100) { 
            argPower = 100;
        }
        this.parPower = argPower;
    }

    public String getInfo(){
        return String.format("ID: %d, имя: %s, вероятность выиграша %d процентов", this.parID, this.parName, this.parPower);
    }
}
