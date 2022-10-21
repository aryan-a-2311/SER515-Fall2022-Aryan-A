package ptbs;

import java.io.*;
import java.util.Scanner;

public class Facade {
    private int UserType;
    private String userName;
    private Product theSelectedProduct;
    private int nProductCategory; //0: Meat, 1: Produce.
    ClassProductList theProductList;
    private Person thePerson;
    private ClassProductList productListMenu;

    private ClassProductList userProductList = new ClassProductList();

    public void newFacade() throws Exception {
        System.out.println("\n==================== FACADE STARTED ====================");
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

        System.out.println("\n====================ITERATING OVER THE LIST (ITERATOR PATTERN)====================");

        // Iterator Pattern Implementation
        System.out.println("\nYour Requested Menu: ");
        ProductIterator iterator = new ProductIterator();
        iterator.listOfProducts = userProductList;
        for(;iterator.hasNext();) {
            System.out.println(iterator.Next());
        }

        System.out.println("\n====================REMINDERS STARTED (VISITOR PATTERN)====================");
        // Visitor Pattern Implementation
        this.remind();
    }

    public void login() throws Exception {
        Login newLogin = new Login();
        this.userName = newLogin.usrNam;
        this.UserType = newLogin.userType;
        // Creating the Person. Bridge and Factory Pattern Implementation
        System.out.println("\n====================CREATED PERSON (BRIDGE AND FACTORY PATTERNS)====================");
        if(this.UserType == 0){
            this.thePerson = new Buyer(this.userName);
        }
        else{
            this.thePerson = new Seller(this.userName);
        }

    }

    public void addTrading() {
        System.out.println("Added Trading");
    }

    public void viewTrading() {
        System.out.println("View Trading");
    }

    public void decideBidding() {
        System.out.println("Decide Bidding");
    }

    public void discussBidding() {
        System.out.println("Discuss Bidding");
    }

    public void submitBidding() {
        System.out.println("Submit Bidding");
    }

    public void accept(NodeVisitor visitor)
    {
        visitor.visitFacade(this);
    }

    public void remind()
    {
        NodeVisitor nodeVisitor = new RemindVisitor();
        this.accept(nodeVisitor);
    }

    public void createUser(UserInfoItem userinfoitem) {
        System.out.println("Creating User");
    }

    public void createProductList() throws Exception {
        System.out.println("Creating List");
    }

    //Generate appropriate product List and attach it to THIS user
    public void AttachProductToUser() throws Exception {
        // Making a list of all products
        File file = new File("ptbs/UserProduct.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String tempStr;
        this.theProductList = new ClassProductList();
        while ((tempStr = reader.readLine()) != null) {
            String[] tempUserProductArray;
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

    public Product SelectProduct() {
        System.out.println("Selecting Product");
        return null;
    }

    //Show the Meat or Produce Menu. Bridge and Factory Pattern Implementation
    public void productOperation() throws Exception {
        System.out.println("\n====================CREATED THE SELECTED MENU (BRIDGE AND FACTORY PATTERNS)====================");
        if (this.nProductCategory == 0){
           this.productListMenu =  thePerson.CreateProductMenu(0);
        }
        else{
            this.productListMenu = thePerson.CreateProductMenu(1);
        }
    }
}
