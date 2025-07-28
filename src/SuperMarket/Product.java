package SuperMarket;

public class Product {
    int Id;
    String Name;
    int Quantity;
    double Price;

    public Product(int Id, String Name, int Quantity, double Price){
        this.Id = Id;
        this.Name = Name;
        this.Quantity = Quantity;
        this.Price = Price;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
