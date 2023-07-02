import java.util.HashMap;
import java.util.Map.Entry;

public class Order{
    private static Integer IDCount = 0;
    private Integer ID;
    private Custumer custumer;
    private HashMap<Goods, Integer> details;
    public Order(Custumer custumer, HashMap<Goods, Integer> details){
        this.custumer = custumer;
        this.details = details;
        IDCount ++;
        this.ID = IDCount;
    }

    public Order(){
        IDCount ++;
        this.ID = IDCount;
    }

    public Integer getID(){
        return this.ID;
    }

    public Custumer getCustumer() {
        return custumer;
    }

    public HashMap<Goods, Integer> getDetails() {
        return details;
    }

    public void setCustumer(Custumer arg) {
        this.custumer = arg;
    }

    public void setDetails(HashMap<Goods, Integer> arg) {
        this.details = arg;
    }

    public String getInfo(){
        StringBuilder temp = new StringBuilder();
        temp.append(" Покупатель = "); temp.append(custumer.getInfo()); temp.append("\n");
        for (Entry<Goods, Integer> element : details.entrySet()) {
            temp.append("   ");
            temp.append(element.getKey().getInfo()); 
            temp.append(" Количество: ");
            temp.append(element.getValue()); temp.append("\n");
        } 
        return temp.toString();
    }
}
