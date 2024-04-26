package products;

public class TextileProduct extends Product{
    private String material;

    public TextileProduct(String name, String manufacturer, int weight, int quantity, String material) {
        super(name, manufacturer, weight, quantity);
        this.material = material;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nMaterial: " + material + "\n";
    }
}
