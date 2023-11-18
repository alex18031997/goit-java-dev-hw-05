package interfaces;

public class ProjectPrices {
    private String NAME;
    private int PRICE;

    public String getName() {
        return NAME;
    }

    public void setName(String NAME) {
        this.NAME = NAME;
    }

    public int getPrice() {
        return PRICE;
    }

    public void setPrice(int PRICE) {
        this.PRICE = PRICE;
    }

    @Override
    public String toString() {
        return "{" + "PRICE: " + getPrice() + ", name: " + getName() + "}";
    }
}
