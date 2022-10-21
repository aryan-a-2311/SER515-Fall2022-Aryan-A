package ptbs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ProduceProductMenu implements ProductMenu{
    ClassProductList products = new ClassProductList();
    //Storing and Displaying the full Produce Menu
    @Override
    public void showMenu() throws Exception {
        File file = new File("ptbs/ProductInfo.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String tempStr;
        System.out.println("The Full Produce Menu");
        while ((tempStr = reader.readLine()) != null) {
            String tempMeatArray[];
            tempMeatArray = tempStr.split(":");
            if(tempMeatArray[0].equalsIgnoreCase("Produce"))
            {
                products.add(tempMeatArray[1]);
            }
        }
        System.out.println(products);
    }

    @Override
    public void showAddButton() {
        System.out.println("Showing Produce Add Button");
    }

    @Override
    public void showViewButton() {
        System.out.println("Showing Produce View Button");
    }

    @Override
    public void showRadioButton() {
        System.out.println("Showing Produce Radio Button");
    }

    @Override
    public void showLabels() {
        System.out.println("Showing Produce Labels");
    }

    @Override
    public void showComboxes() {
        System.out.println("Showing Produce Comboxes");
    }
}
