package VendingMachine.POJO;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Integer, Integer> productQuantities = new HashMap<>();
    private Map<Integer, Product> productCatalog = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        productCatalog.put(product.getCode(), product);
        productQuantities.put(product.getCode(), quantity);
    }

    public boolean isProductAvailable(int productCode) {
        return productQuantities.getOrDefault(productCode, 0) > 0;
    }

    public void reduceProductQuantity(int productCode) {
        if (isProductAvailable(productCode)) {
            productQuantities.put(productCode, productQuantities.get(productCode) - 1);
        }
    }

    public Product getProduct(int productCode) {
        return productCatalog.get(productCode);
    }
}
