package ptbs;

import java.util.ArrayList;

public class Product {
    String name;
    ArrayList<Trading> allTradings = new ArrayList<Trading>();
    Product(String name)
    {
        this.name = name;

        //Adding Dummy Trades for the visitor to visit
        allTradings.add(new Trading(this, 1));
        allTradings.add(new Trading(this, 2));
    }
}
