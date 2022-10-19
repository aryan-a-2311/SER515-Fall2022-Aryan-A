package ptbs;

public interface ProductMenu {
    public ClassProductList products = new ClassProductList();
    public abstract void showMenu() throws Exception;
    public abstract void showAddButton();
    public abstract void showViewButton();
    public abstract void showRadioButton();
    public abstract void showLabels();
    public abstract void showComboxes();
}
