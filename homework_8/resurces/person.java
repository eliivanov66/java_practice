

import java.util.Random;
import java.util.HashSet;

public class person extends human { //implements parenthood, childhood, brotherhood, mariage
    private person father;
    private person mother;
    private HashSet<person> children = new HashSet<person>();
    private HashSet<person> sublings = new HashSet<person>();
    private boolean firstAncestor;
    Random rand = new Random();
    
    public person(String argFirstName, String argSurName, boolean argSex, int argAncestor){
        super(argFirstName, argSurName, argSex);
        this.firstAncestor = (argAncestor <= 0);
        if (! this.firstAncestor){
            if (this.getSex()) {
                this.father = new person(parts.maleNames.get(rand.nextInt(parts.maleNames.size())), this.getSurName(), true, argAncestor - 1);
                this.mother = new person(parts.femaleNames.get(rand.nextInt(parts.femaleNames.size())), parts.femaleSurNames.get(rand.nextInt(parts.femaleSurNames.size())), false, argAncestor - 1);
            } else {
                this.father = new person(parts.maleNames.get(rand.nextInt(parts.maleNames.size())), parts.maleSurNames.get(parts.femaleSurNames.indexOf(this.getSurName())), true, argAncestor - 1);
                this.mother = new person(parts.femaleNames.get(rand.nextInt(parts.femaleNames.size())), parts.femaleSurNames.get(rand.nextInt(parts.femaleSurNames.size())), false, argAncestor - 1);
            }
        }

    }

    public person(int argAncestor){
        super();
        this.firstAncestor = (argAncestor <= 0);
        if (! this.firstAncestor){
            if (this.getSex()) {
                this.father = new person(parts.maleNames.get(rand.nextInt(parts.maleNames.size())), this.getSurName(), true, argAncestor - 1);
                this.mother = new person(parts.femaleNames.get(rand.nextInt(parts.femaleNames.size())), parts.femaleSurNames.get(rand.nextInt(parts.femaleSurNames.size())), false, argAncestor - 1);
            } else {
                this.father = new person(parts.maleNames.get(rand.nextInt(parts.maleNames.size())), parts.maleSurNames.get(parts.femaleSurNames.indexOf(this.getSurName())), true, argAncestor - 1);
                this.mother = new person(parts.femaleNames.get(rand.nextInt(parts.femaleNames.size())), parts.femaleSurNames.get(rand.nextInt(parts.femaleSurNames.size())), false, argAncestor - 1);
            }
        }
    }

    
    public person getFather() {
        return father;
    }

    public person getMother() {
        return mother;
    }

    public HashSet<person> getChildren(){
        return this.children;
    }

    public HashSet<person> getSublings(){
        return this.sublings;
    }

    public void setFather(person arg){
        this.father = arg;
    }

    public void setMother(person arg){
        this.mother = arg;
    }

    public void setSubling(person arg){
        this.sublings.add(arg);
    }

    public void setChildren(person arg){
        this.children.add(arg);
    }

    public String getInfo(String arg) {
        StringBuilder temp = new StringBuilder();
        temp.append(String.format("%sФамилия: %s, ",arg, this.getSurName()));
        temp.append(String.format(" имя: %s, ",this.getFirstName()));
        if (this.getSex()) {
            temp.append(String.format(" пол: М "));
        } else {
            temp.append(String.format(" пол: Ж ")); 
        }
        if (this.father != null && this.mother != null) {
            String fatherIndex;
            String motherIndex;
            if (arg.length() / "-->".length() == 0) {
                fatherIndex = "отец";
                motherIndex = "мать";
            }else {
                fatherIndex = "пра".repeat((arg.length() / "-->".length() - 1)) + "дед";
                motherIndex = "пра".repeat((arg.length() / "-->".length() - 1)) + "бабка";
            }
            temp.append(String.format("\n%s%s: %s", arg,fatherIndex, father.getInfo(arg + "-->")));
            temp.append(String.format("\n%s%s: %s", arg,motherIndex, mother.getInfo(arg + "-->")));
            if (! this.children.isEmpty()) {
                for (person elem : this.children) {
                    temp.append(String.format("%sребёнок: %s", arg, elem.getInfo(arg)));  
                }

            }
        }

        return temp.toString();
    }

    public void setChildren(HashSet<person> children) {
        this.children = children;
    }

    public void setSublings(HashSet<person> sublings) {
        this.sublings = sublings;
    }

    public boolean isFirstAncestor() {
        return firstAncestor;
    }

    public void setFirstAncestor(boolean firstAncestor) {
        this.firstAncestor = firstAncestor;
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

}
