import java.util.Collections;
public class Product  implements Comparable<Product>{
    String productCategory;
    int productCost;
    String productName;


    public Product(String catego, int cost, String name){
        this.productCategory = catego;
        this.productCost = cost;
        this.productName = name;
    }
    @Override
    public int compareTo(Product o) {
        int diff = this.productCost - productCost;
        if (diff != 0) {
            return diff;
        }
        return productName.compareTo(o.productName);
    }
}
