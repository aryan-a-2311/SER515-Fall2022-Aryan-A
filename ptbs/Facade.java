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

    public void newFacade() throws Exception {
        System.out.println("--------------------------------FACADE STARTED--------------------------------");
        login();
        AttachProductToUser();
        System.out.println("\nYour Products List: ");
        for (int i=0; i<this.theProductList.size(); i++) {
//            System.out.println((i+1) + " " + this.theProductList.get(i));
            System.out.println(this.theProductList.get(i));
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("\nDo you want a:\n0.Meat Menu \nor a \n1.Produce Menu?\n\n Enter 0 or 1: ");
        this.nProductCategory = sc.nextInt();
        if(!(this.nProductCategory == 0 || this.nProductCategory == 1))
            System.exit(-1);
        productOperation();
    }
    public void login() throws Exception {
        Login newLogin = new Login();
        this.userName = newLogin.usrNam;
        this.UserType = newLogin.userType;
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
        File file = new File("ptbs/UserProduct.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String tempStr;
        this.theProductList = new ClassProductList();
        while ((tempStr = reader.readLine()) != null) {
            String tempUserProductArray[];
            tempUserProductArray = tempStr.split(":");
            if(tempUserProductArray[0].equalsIgnoreCase(this.userName))
            {
                this.theProductList.add(tempUserProductArray[1]);
            }
        }
    }

    public Product SelectProduct() { return null; }

    //do - Make Person and Product Menu. Bridge and Factory Implementation
    public void productOperation() throws Exception {
        if(this.UserType == 0){
            this.thePerson = new Buyer();
        }
        else{
            this.thePerson = new Seller();
        }

        if (this.nProductCategory == 0){
            thePerson.CreateProductMenu(0);
        }
        else{
            thePerson.CreateProductMenu(1);
        }
    }
}
