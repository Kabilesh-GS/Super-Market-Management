package SuperMarket;

public class Cart {
    int Id;
    String name;
    double price;
    int quantity;

    public Cart(int Id,String name, int quantity,double price){
        this.Id = Id;
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }
}
