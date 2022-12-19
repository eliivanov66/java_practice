
import java.util.Random;

public abstract class human {
    private String firstName;
    private String surName;
    private boolean sex;
    private Random rand = new Random();
    public human(String argFirstName, String argSurName, boolean argSex){
        this.firstName = argFirstName;
        this.surName = argSurName;
        this.sex = argSex;
    }
    public human(){
        this.sex = rand.nextBoolean();
        if (this.sex) {
            this.firstName = parts.maleNames.get(rand.nextInt(parts.maleNames.size()));
            this.surName = parts.maleSurNames.get(rand.nextInt(parts.maleSurNames.size()));
        } else {
            this.firstName = parts.femaleNames.get(rand.nextInt(parts.femaleNames.size()));
            this.surName = parts.femaleSurNames.get(rand.nextInt(parts.femaleSurNames.size()));  
        }
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setSurName(String surName) {
        this.surName = surName;
    }
    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getFirstName(){
        return this.firstName;
    }
    public String getSurName(){
        return this.surName;
    }
    public boolean getSex(){
        return this.sex;
    }

    abstract public String getInfo(String arg);
    
    public boolean isEqual(human arg){
        return this.firstName.equals(arg.getFirstName()) &&
               this.surName.equals(arg.getSurName()) &&
               (this.sex == arg.getSex());
    }
}
