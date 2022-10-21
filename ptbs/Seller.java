package ptbs;

import java.io.*;

public class Seller extends Person{
    String userName;

    Seller(String uName)
    {
        this.userName = uName;
    }
    @Override
    public void showMenu() throws Exception {
        File file = new File("ptbs/UserProduct.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String tempStr;
        while ((tempStr = reader.readLine()) != null) {
            String tempUserProductArray[];
            tempUserProductArray = tempStr.split(":");
            if(tempUserProductArray[0].equalsIgnoreCase(this.userName))
            {
                System.out.println(tempUserProductArray[1]);
            }
        }
    }

    // Creating the Meat or Produce Menu for the Seller
    @Override
    public ClassProductList CreateProductMenu(int type) throws Exception {
        if (type == 0)
        {
            MeatProductMenu sellerMeat = new MeatProductMenu();
            sellerMeat.showMenu();
            sellerMeat.showAddButton();
            sellerMeat.showViewButton();
            sellerMeat.showRadioButton();
            sellerMeat.showLabels();
            sellerMeat.showComboxes();
            this.theProductMenu = sellerMeat;
            return sellerMeat.products;
        }
        else
        {
            ProduceProductMenu sellerProduce = new ProduceProductMenu();
            sellerProduce.showMenu();
            sellerProduce.showAddButton();
            sellerProduce.showViewButton();
            sellerProduce.showRadioButton();
            sellerProduce.showLabels();
            sellerProduce.showComboxes();
            this.theProductMenu = sellerProduce;
            return sellerProduce.products;
        }
    }
}
