package ptbs;

import java.util.ArrayList;

public class ClassProductList extends ArrayList {
    public void accept(NodeVisitor visitor)
    {
        ProductIterator iterator = new ProductIterator();
        iterator.listOfProducts = this;
        for(;iterator.hasNext();) {
            Product currentProduct = new Product((String) iterator.Next());
            visitor.visitProduct(currentProduct);
        }
    }
}
