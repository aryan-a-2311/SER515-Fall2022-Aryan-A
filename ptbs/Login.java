package ptbs;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Login {
    public int userType;
    public String usrNam;
    Login() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n====================LOGIN GUI====================");
        System.out.println("\nAre you a:\n0.Buyer \nor a \n1.Seller?\n\n Enter 0 or 1: ");
        int b_s = sc.nextInt();
        if(b_s == 0 || b_s == 1)
        {
            System.out.println("Enter Username: ");
            String uName = sc.next();
            System.out.println("Enter Password: ");
            String pWord = sc.next();
            if(validate(uName, pWord, b_s)){
                System.out.println("Logged In Successfully");
                this.userType = b_s;
                this.usrNam = uName;
            }
            else{
                System.out.println("Logged Failed");
                System.exit(-1);
            }
        }
        else
        {
            System.out.println("Wrong Input");
            System.exit(-1);
        }
    }

    public boolean validate(String userName, String passWord, int buy_sell) throws Exception {
        HashMap<String, String> loginMap= new HashMap<>();
        File file = null;
        if(buy_sell == 0)
        {
            file = new File("ptbs/BuyerInfo.txt");
        }
        else if (buy_sell == 1)
        {
            file = new File("ptbs/SellerInfo.txt");
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));

        String tempStr;

        while ((tempStr = reader.readLine()) != null) {
            String tempLoginArray[];
            tempLoginArray = tempStr.split(":");
            loginMap.put(tempLoginArray[0], tempLoginArray[1]);
        }

        if(loginMap.containsKey(userName))
        {
            if(loginMap.get(userName).equals(passWord))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}
