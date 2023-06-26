import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;

public class Shop {
    private static ArrayList<Custumer> custumers;
    private static ArrayList<Goods> goods;
    private static ArrayList<Order> orders;
    private static final Integer MAX_QUANTITY = 100;
    private static final Integer MIN_QUANTITY = 0;
    private static final Double MAX_DISCOUNT = 15.0;
    static Random rand = new Random();

    public static void main(String[] args) {
        custumers = new ArrayList<>();
        custumers.add(new Custumer("Ivan", "Ivanov", "Ivanovich", 30, "+79001234561", true));
        custumers.add(new Custumer("Boris", "Borisov", "Borisovich", 35, "+79001234562", true));
        custumers.add(new Custumer("Elena", "Elenova", "Ivanovna", 25, "+79001234563", false));
        custumers.add(new Custumer("Marya", "Maryyna", "Petrovna", 27, "+79001234564", false));
        custumers.add(new Custumer("Denis", "Denisov", "Denisovich", 50, "+79001234565", true));
        
        goods = new ArrayList<>();
        goods.add(new Goods("Black Tea", 100.0));
        goods.add(new Goods("Coffee", 200.0));
        goods.add(new Goods("Water", 50.0));
        goods.add(new Goods("Cola", 70.0));
        goods.add(new Goods("Green Tea", 80.0));

        for (Goods value : goods) {
            value.setDiscount(Discounts.discount[rand.nextInt(Discounts.discount.length)]);
            value.setPremium(rand.nextBoolean());
        }
        
        orders = new ArrayList<>();
        
        try {
            //orders.add(makeOrder(new Custumer(), goods.get(rand.nextInt(goods.size())), rand.nextInt(10)));
            //orders.add(makeOrder(custumers.get(rand.nextInt(custumers.size())), new Goods(), rand.nextInt(10)));
            //orders.add(makeOrder(custumers.get(rand.nextInt(custumers.size())), goods.get(rand.nextInt(goods.size())), 1000));
            orders.add(makeOrder(custumers.get(rand.nextInt(custumers.size())), goods.get(rand.nextInt(goods.size())), rand.nextInt(1, 10)));
            orders.add(makeOrder(custumers.get(rand.nextInt(custumers.size())), goods.get(rand.nextInt(goods.size())), rand.nextInt(1, 10)));
            orders.add(makeOrder(custumers.get(rand.nextInt(custumers.size())), goods.get(rand.nextInt(goods.size())), rand.nextInt(1, 10)));
            orders.add(makeOrder(custumers.get(rand.nextInt(custumers.size())), goods.get(rand.nextInt(goods.size())), rand.nextInt(1, 10)));
            orders.add(makeOrder(custumers.get(rand.nextInt(custumers.size())), goods.get(rand.nextInt(goods.size())), rand.nextInt(1, 10)));
            orders.add(makeOrder(custumers.get(rand.nextInt(custumers.size())), goods.get(rand.nextInt(goods.size())), rand.nextInt(1, 10)));
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        } catch (ProductException e) {
            System.out.println(e.getMessage());
        } catch (AmountException e) {
            System.out.println(e.getMessage());
        } catch (TooMuchSaleException e) {
            System.out.println(e.getMessage());
        }

        //result
        for (Order order : orders) {
            System.out.println(order.getInfo());
        }
        
    }

    static Order makeOrder(Custumer argCustumer, Goods argGoods, Integer argQuntity) throws CustomerException, ProductException, AmountException, TooMuchSaleException{

        if (!custumers.contains(argCustumer)) {
            throw new CustomerException("Покупатель отсутсвует в базе " + argCustumer.getInfo());
        }

        if (!goods.contains(argGoods)) {
            throw new ProductException("Товар отсутсвует в базе " + argGoods.getInfo());
        }

        if ((argQuntity >= MAX_QUANTITY) || (argQuntity <= MIN_QUANTITY)) {
            throw new AmountException("Некорректно задано количество товара " + argQuntity);
        }

        if (argGoods.getPremium() && argGoods.getDiscount() >= MAX_DISCOUNT) {
            throw new TooMuchSaleException("Скидка слишком высока " + argGoods.getInfo());
        }

        HashMap<Goods, Integer> temp = new HashMap<>();
        temp.put(argGoods, argQuntity);
        return new Order(argCustumer, temp);
    }

    static void checkDiscount(Goods arGoods ){
        arGoods.setPremium(arGoods.getDiscount() >= MAX_DISCOUNT); 
    }
}