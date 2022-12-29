public class child<E> extends parent<E> {
    
    child(E argID){
        super(argID);
    }

    public void getInfo(){
        System.out.println(this.id.getClass());
    }
}
