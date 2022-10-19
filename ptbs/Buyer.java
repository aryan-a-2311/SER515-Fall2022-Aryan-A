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

    @Override
    public ClassProductList CreateProductMenu(int type) throws Exception {
        if (type == 0)
        {
            MeatProductMenu buyerMeat = new MeatProductMenu();
            buyerMeat.showMenu();
            this.theProductMenu = buyerMeat;
            return buyerMeat.products;
        }
        else
        {
            ProduceProductMenu buyerProduce = new ProduceProductMenu();
            buyerProduce.showMenu();
            this.theProductMenu = buyerProduce;
            return buyerProduce.products;
        }
    }
}
