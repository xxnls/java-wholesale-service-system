package products;

public class FoodProduct extends Product{
    private int expiration; //in days

    public FoodProduct(String name, String manufacturer, int weight, int quantity, int expiration) {
        super(name, manufacturer, weight, quantity);
        this.expiration = expiration;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nExpiration: " + expiration + " days.\n";
    }
}
