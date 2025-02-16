package VendingMachine.POJO;

public class Product {
    private int code;
    private String name;
    private int price;

    public Product(int code, String name, int price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
