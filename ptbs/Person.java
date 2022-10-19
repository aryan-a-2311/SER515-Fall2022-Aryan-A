package ptbs;

import java.io.IOException;

public abstract class Person {
    protected ProductMenu theProductMenu;

    public abstract void showMenu() throws IOException, Exception;

    public void showAddButton() {
        System.out.println("Call the implementation to show the Add buttons.");
    }

    public void showViewButton() {
        System.out.println("Call the implementation to show the view buttons");
    }

    public void showRadioButton() {
        System.out.println("Call the implementation to show the radio buttons.");
    }

    public void showLabels() {
        System.out.println("Call the implementation to show the labels.");
    }

    public abstract ClassProductList CreateProductMenu(int type) throws Exception;
}
