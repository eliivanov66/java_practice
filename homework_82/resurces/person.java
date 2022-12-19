import java.util.HashSet;

public class person extends human implements family{
    private person father;
    private person mother;
    private HashSet<person> children = new HashSet<>();
    private HashSet<person> sublings = new HashSet<>();

    person(String argFirstName, String argSecondName, Boolean argSex){
        super(argFirstName, argSecondName, argSex);
    }

    person(String argSecondName, Boolean argSex){
        super(argSecondName, argSex);
    }

    
    person(Boolean argSex){
        super(argSex);
    }


    person(){
        super();
    }

    @Override
    public boolean equality(person arg) {
        return (this.getFirstName().equals(arg.getFirstName())) &&
               (this.getSecondName().equals(arg.getSecondName())) &&
               (this.getSex() == arg.getSex());
    }

    @Override
    public HashSet<person> getChildren() {
        return this.children;
    }

    @Override
    public person getFather() {
        return this.father;
    }

    @Override
    public person getMother() {
        return this.mother;
    }

    @Override
    public HashSet<person> getSublings() {
        return this.sublings;
    }


    @Override
    public boolean SetChildren(person arg) {
        boolean temp = false;
        if (! this.getChildren().contains(arg) && ! this.equality(arg)){
            this.children.add(arg);
            temp = true;
        }
        return temp;
    }


    @Override
    public boolean SetSublings(person arg) {
        boolean temp = false;
        if (! this.getSublings().contains(arg) && ! this.equality(arg)){
            this.sublings.add(arg);
            temp = true;
        }
        return temp;
    }


    @Override
    public boolean SetFather(person arg) {
        this.father = arg;
        return true;
    }


    @Override
    public boolean SetMother(person arg) {
        this.mother = arg;
        return true;
    }

    @Override
    public boolean isSublings(person arg) {
        boolean temp = false;
        if ((this.father != null) && (arg.getFather() != null) && (this.mother != null) && (arg.getMother() != null)) {
            temp = this.father.equality(arg.getFather()) ||
                   this.mother.equality(arg.getMother());

        } else {
            temp = false;
        }
        return temp;
    }

    @Override
    public boolean isFather(person arg) {
        boolean temp = false;
        if (arg.getFather() != null) {
            temp = arg.getFather().equality(this);
        }
        return temp;
    }

    @Override
    public boolean isMother(person arg) {
        boolean temp = false;
        if (arg.getMother() != null) {
            temp = arg.getMother().equality(this);
        }
        return temp;
    }


    public String getInfo(String sep) {
        StringBuilder Builder = new StringBuilder();
        if (this != null) {
            Builder.append(String.format("Фамилия: "));
            Builder.append(this.getSecondName());
            Builder.append(", Имя: ");
            Builder.append(this.getFirstName());
            Builder.append(", Пол: ");
            if (this.getSex()) {
                Builder.append("М");
            } else {
                Builder.append("Ж");
            }
            if (this.father != null) {
                Builder.append(String.format("\n%sОтец: ", sep));
                Builder.append(this.father.getInfo(sep + sep));
            }
            if (this.mother != null) {
                Builder.append(String.format("\n%sМать: ", sep));
                Builder.append(this.mother.getInfo(sep + sep));
            }
            if (! this.children.isEmpty()) {
                for (person elem : this.children) {
                    if (elem.getSex()) {
                        Builder.append(String.format("\n%sсын: ", sep));
                        Builder.append(elem.getInfo());
                    } else {
                        Builder.append(String.format("\n%sдочь: ", sep));
                        Builder.append(elem.getInfo());  
                    }
                }

            }
            if (! this.sublings.isEmpty()) {
                for (person elem : this.sublings) {
                    if (elem.getSex()) {
                        Builder.append(String.format("\n%sбрат: ", sep));
                        Builder.append(elem.getInfo());
                    } else {
                        Builder.append(String.format("\n%sсестра: ", sep));
                        Builder.append(elem.getInfo());  
                    }
                }
            }
        }
        return Builder.toString();
    }

    @Override
    public boolean inRelation(person arg) {
        boolean temp = false;
        temp = arg.isFather(this) ||
               arg.isMother(this) ||
               arg.isSublings(this);
        return temp;
    }
    
    
}
