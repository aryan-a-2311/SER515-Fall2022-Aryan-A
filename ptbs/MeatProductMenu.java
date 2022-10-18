package ptbs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class MeatProductMenu implements ProductMenu {
    @Override
    public void showMenu() throws Exception {
        File file = new File("ptbs/ProductInfo.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String tempStr;

        while ((tempStr = reader.readLine()) != null) {
            String tempMeatArray[];
            tempMeatArray = tempStr.split(":");
            if(tempMeatArray[0].equalsIgnoreCase("Meat"))
            {
                System.out.println(tempMeatArray[1]);
            }
        }
    }

    @Override
    public void showAddButton() {
        System.out.println("Show Add Button");
    }

    @Override
    public void showViewButton() {
        System.out.println("Show View Button");
    }

    @Override
    public void showRadioButton() {
        System.out.println("Show Radio Button");
    }

    @Override
    public void showLabels() {
        System.out.println("Show Labels");
    }

    @Override
    public void showComboxes() {

    }
}
