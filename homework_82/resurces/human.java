import java.util.Random;

public abstract class human {
    private String firstName;
    private String secondName;
    private boolean sex;
    Random rand = new Random();

    human(String argFirstName, String argSecondName, Boolean argSex){
        this.firstName = argFirstName;
        this.secondName = argSecondName;
        this.sex = argSex;
    }
    human(String argSecondName, Boolean argSex){
        this.secondName = argSecondName;
        this.sex = argSex;
        if (this.sex) {
            this.firstName = parts.maleNames.get(rand.nextInt(parts.maleNames.size()));
        } else {
            this.firstName = parts.femaleNames.get(rand.nextInt(parts.femaleNames.size()));
        }
    }
    human(Boolean argSex){
        this.sex = argSex;
        if (this.sex) {
            this.firstName = parts.maleNames.get(rand.nextInt(parts.maleNames.size()));
            this.secondName = parts.maleSurNames.get(rand.nextInt(parts.maleSurNames.size()));
        } else {
            this.firstName = parts.femaleNames.get(rand.nextInt(parts.femaleNames.size()));
            this.secondName = parts.femaleSurNames.get(rand.nextInt(parts.femaleSurNames.size()));
        }

    }
    human(){
        this.sex = rand.nextBoolean();
        if (this.sex) {
            this.firstName = parts.maleNames.get(rand.nextInt(parts.maleNames.size()));
            this.secondName = parts.maleSurNames.get(rand.nextInt(parts.maleSurNames.size()));
        } else {
            this.firstName = parts.femaleNames.get(rand.nextInt(parts.femaleNames.size()));
            this.secondName = parts.femaleSurNames.get(rand.nextInt(parts.femaleSurNames.size()));
        }
    }    

    public String getFirstName(){
        return this.firstName;
    }

    public String getSecondName(){
        return this.secondName;
    }

    public boolean getSex() {
        return this.sex;
    }
    
    public void SetFirstName(String arg){
        this.firstName = arg;
    }

    public void SetSecondName(String arg){
        this.secondName = arg;
    }

    public void SetFirstName(Boolean arg){
        this.sex = arg;
    }

    public String getInfo(){
        StringBuilder Builder = new StringBuilder();
        if (this != null) {
            Builder.append("Фамилия: ");
            Builder.append(this.getSecondName());
            Builder.append(", Имя: ");
            Builder.append(this.getFirstName());
            Builder.append(", Пол: ");
            if (this.getSex()) {
                Builder.append("М");
            } else {
                Builder.append("Ж");
            }
        }
        return Builder.toString();
    }
}
