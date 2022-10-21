package ptbs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLOutput;

public class MeatProductMenu implements ProductMenu {
    ClassProductList products = new ClassProductList();
    //Storing and Displaying the full Meat Menu
    @Override
    public void showMenu() throws Exception {
        File file = new File("ptbs/ProductInfo.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String tempStr;
        System.out.println("The Full Meat Menu");
        while ((tempStr = reader.readLine()) != null) {
            String tempMeatArray[];
            tempMeatArray = tempStr.split(":");
            if(tempMeatArray[0].equalsIgnoreCase("Meat"))
            {
                products.add(tempMeatArray[1]);
            }
        }
        System.out.println(products);
    }

    @Override
    public void showAddButton() {
        System.out.println("Showing Meat Add Button");
    }

    @Override
    public void showViewButton() {
        System.out.println("Showing Meat View Button");
    }

    @Override
    public void showRadioButton() {
        System.out.println("Showing Meat Radio Button");
    }

    @Override
    public void showLabels() {
        System.out.println("Showing Meat Labels");
    }

    @Override
    public void showComboxes() {
        System.out.println("Showing Meat Comboxes");
    }
}
