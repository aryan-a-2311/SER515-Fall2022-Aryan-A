package ptbs;

public class Buyer extends Person{

    @Override
    public void showMenu() {

    }

    @Override
    public ProductMenu CreateProductMenu(int type) throws Exception {
        if (type == 0)
        {
            MeatProductMenu buyerMeat = new MeatProductMenu();
            buyerMeat.showMenu();
            return buyerMeat;
        }
        else
        {
            ProduceProductMenu buyerProduce = new ProduceProductMenu();
            buyerProduce.showMenu();
            return buyerProduce;
        }
    }
}
