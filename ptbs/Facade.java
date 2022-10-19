package ptbs;

import java.io.*;
import java.util.Scanner;

public class Facade {
    private int UserType;
    private String userName;
    private Product theSelectedProduct;
    private int nProductCategory; //0: Meat, 1: Produce.
    private ClassProductList theProductList;
    private Person thePerson;
    private ClassProductList productListMenu;

    private ClassProductList userProductList = new ClassProductList();

    public void newFacade() throws Exception {
        System.out.println("--------------------------------FACADE STARTED--------------------------------");
        //User Login
        login();

        //Taking the user choice of the Meat or Produce Menu they want
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\nDo you want a:\n0.Meat Menu \nor a \n1.Produce Menu?\n\n Enter 0 or 1: ");
        this.nProductCategory = sc.nextInt();
        if(!(this.nProductCategory == 0 || this.nProductCategory == 1))
            System.exit(-1);

        //Making the full Meat/Produce Menu
        productOperation();

        //Reading the Product List of user and matching it with the Meat/Produce Menu List and displaying the matched items
        AttachProductToUser();

        System.out.println("\nYour Entire Menu: ");
        thePerson.showMenu();

        // Iterator Implementation
        System.out.println("\nYour Requested Menu: ");
        ProductIterator iterator = new ProductIterator();
        iterator.listOfProducts = userProductList;
        for(;iterator.hasNext();)
            System.out.println(iterator.Next());
    }

    public void login() throws Exception {
        Login newLogin = new Login();
        this.userName = newLogin.usrNam;
        this.UserType = newLogin.userType;
        // Creating the Person. Bridge and Factory Implementation
        if(this.UserType == 0){
            this.thePerson = new Buyer(this.userName);
        }
        else{
            this.thePerson = new Seller(this.userName);
        }

    }

    public void addTrading() {}

    public void viewTrading() {}

    public void decideBidding() {}

    public void discussBidding() {}

    public void submitBidding() {}

    //Do
    public void remind() {}

    public void createUser(UserInfoItem userinfoitem) {}

    public void createProductList() throws Exception {

    }

    //Generate appropriate product List and attach it to THIS user
    public void AttachProductToUser() throws Exception {
        // Making a list of all products
        File file = new File("ptbs/UserProduct.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String tempStr;
        this.theProductList = new ClassProductList();
        while ((tempStr = reader.readLine()) != null) {
            String tempUserProductArray[];
            tempUserProductArray = tempStr.split(":");
            if(tempUserProductArray[0].equalsIgnoreCase(this.userName)) {
                this.theProductList.add(tempUserProductArray[1]);
            }
        }

        for (Object o : theProductList) {
            for (Object listMenu : productListMenu) {
                if (o.equals(listMenu))
                    this.userProductList.add(o);
            }
        }

    }

    public Product SelectProduct() { return null; }

    //Show the Meat or Produce Menu. Bridge and Factory Implementation
    public void productOperation() throws Exception {
        if (this.nProductCategory == 0){
//            System.out.println("Your Meat Menu: ");
           this.productListMenu =  thePerson.CreateProductMenu(0);
        }
        else{
//            System.out.println("Your Produce Menu: ");
            this.productListMenu = thePerson.CreateProductMenu(1);
        }
    }
}
