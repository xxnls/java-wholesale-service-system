package products;

public class CleaningProduct extends Product{
    private String purpose;
    private Boolean safeWithFood;

    public CleaningProduct(String name, String manufacturer, int weight, int quantity, String purpose, Boolean safeWithFood) {
        super(name, manufacturer, weight, quantity);
        this.purpose = purpose;
        this.safeWithFood = safeWithFood;
    }

    @Override
    public String toString() {
        String foodsafe;
        foodsafe = safeWithFood ? "Yes" : "No";

        return super.toString() +
               "\nPurpose: " + purpose +
               "\nFood safe: " + foodsafe + "\n";
    }
}
