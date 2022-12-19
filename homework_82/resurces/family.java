import java.util.HashSet;

public interface family {
    abstract boolean equality(person arg);

    abstract HashSet<person> getChildren();

    abstract HashSet<person> getSublings();
    
    abstract person getFather();

    abstract person getMother();

    abstract boolean SetChildren(person arg);

    abstract boolean SetSublings(person arg);
    
    abstract boolean SetFather(person arg);

    abstract boolean SetMother(person arg);

    abstract boolean isSublings(person arg);

    abstract boolean isFather(person arg);

    abstract boolean isMother(person arg);

    abstract boolean inRelation(person arg);


}
