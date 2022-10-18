package ptbs;

public class Seller extends Person{

    @Override
    public void showMenu() {

    }

    @Override
    public ProductMenu CreateProductMenu(int type) throws Exception {
        if (type == 0)
        {
            MeatProductMenu sellerMeat = new MeatProductMenu();
            sellerMeat.showMenu();
            return sellerMeat;
        }
        else
        {
            ProduceProductMenu sellerProduce = new ProduceProductMenu();
            sellerProduce.showMenu();
            return sellerProduce;
        }
    }
}
