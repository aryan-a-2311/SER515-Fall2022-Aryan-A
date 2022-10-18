package ptbs;

public abstract class Person {
    private ProductMenu theProductMenu;

    public abstract void showMenu();

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

    public abstract ProductMenu CreateProductMenu(int type) throws Exception;
}
