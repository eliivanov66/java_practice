public class Goods implements Comparable<Goods> {
    private static Integer IDCount = 0;
    private Integer ID;
    private String name = "";
    private Double price = 0.0;
    private Double discount;
    private boolean premium = false;

    public Goods(String name, Double price){
        this.name = name;
        this.price = price;
        IDCount ++;
        this.ID = IDCount;
        this.discount = 0.0;
    }

    public Goods(){
        IDCount ++;
        this.ID = IDCount;  
    }

    public Integer getID(){
        return this.ID;
    }

    public String getName(){
        return this.name;
    }

    public Double getPrice(){
        return this.price;
    }

    public Double getDiscount(){
        return this.discount;
    }

    public boolean getPremium(){
        return this.premium;
    }


    public void setName(String arg){
        this.name = arg;
    }

    public void setPrice(Double arg){
        this.price = arg;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
        this.setPrice(this.price * (1.0 - this.discount / 100.0));
    }

    public void setPremium(boolean arg){
        this.premium = arg;
    }

    public String getInfo(){
        StringBuilder temp = new StringBuilder();
        if (this.premium) {
            temp.append(" Премиальный: ");
        } else {
            temp.append(" Стандартный: ");
        }
        temp.append(" Товар: "); temp.append(name);
        temp.append(" Цена: "); temp.append(price);
        temp.append(" Скидка: "); temp.append(discount);  temp.append("%");
        return temp.toString();
    }

    @Override
    public int compareTo(Goods o) {
        if ( o.name.toLowerCase().equals(this.name.toLowerCase()) && 
             o.price == this.price) {
                return 0;
        } else {
            return -1;
        }
    }
}
