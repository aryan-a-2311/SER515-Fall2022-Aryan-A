package ptbs;

import java.io.*;

public class Buyer extends Person{
    String userName;

    Buyer(String uName)
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

    // Creating the Meat or Produce Menu for the Buyer
    @Override
    public ClassProductList CreateProductMenu(int type) throws Exception {
        if (type == 0)
        {
            MeatProductMenu buyerMeat = new MeatProductMenu();
            buyerMeat.showMenu();
            buyerMeat.showAddButton();
            buyerMeat.showViewButton();
            buyerMeat.showRadioButton();
            buyerMeat.showLabels();
            buyerMeat.showComboxes();
            this.theProductMenu = buyerMeat;
            return buyerMeat.products;
        }
        else
        {
            ProduceProductMenu buyerProduce = new ProduceProductMenu();
            buyerProduce.showMenu();
            buyerProduce.showAddButton();
            buyerProduce.showViewButton();
            buyerProduce.showRadioButton();
            buyerProduce.showLabels();
            buyerProduce.showComboxes();
            this.theProductMenu = buyerProduce;
            return buyerProduce.products;
        }
    }
}
