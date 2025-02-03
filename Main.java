import java.util.Scanner;

public class MyClass {
    public static void main(String args[]) {
        Scanner vp = new Scanner(System.in);
        String name = "";
        String dob = "";
        String username = "";
        String password = "";
        int balance = 0;
        boolean accountCreated = false; 

        while (true) {
            System.out.println("Welcome To Bank Server");
            System.out.println("Choose An Option");
            System.out.println("1 -- Create Account");
            System.out.println("2 -- View Balance");
            System.out.println("3 -- Transaction Portal");
            System.out.println("4 -- Exit");
            int select = vp.nextInt();
            vp.nextLine(); // Consume the newline character

            switch (select) {
                case 1:
                    if (!accountCreated) {
                        System.out.println("Account Creation Portal");
                        System.out.println("Enter Your Name As Per Aadhar Card:");
                        name = vp.nextLine();
                        System.out.println("Enter Your DOB (DD/MM/YYYY):");
                        dob = vp.nextLine();
                        System.out.println("Create A Username (only small letters, no special characters):");
                        username = vp.nextLine();
                        System.out.println("Create A Strong Internet Banking Password:");
                        password = vp.nextLine();
                        System.out.println("Enter Initial Balance:");
                        balance = vp.nextInt();
                        vp.nextLine(); // Consume the newline character
                        accountCreated = true; // Mark account as created
                        System.out.println("Successfully Created Account for " + name);
                    } else {
                        System.out.println("Account already created. Only one account is allowed.");
                    }
                    break;

                case 2:
                    if (accountCreated) {
                        System.out.println("Your Balance is: " + balance);
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;

                case 3:
                    if (accountCreated) {
                        System.out.println("Transaction Portal");
                        System.out.println("1 -- Deposit");
                        System.out.println("2 -- Withdraw");
                        int transOption = vp.nextInt();
                        vp.nextLine(); // Consume the newline character

                        if (transOption == 1) {
                            System.out.println("Enter Amount to Deposit:");
                            int depositAmount = vp.nextInt();
                            vp.nextLine();
                            if (depositAmount > 0) {
                                balance += depositAmount;
                                System.out.println("Deposit Successful. New Balance: " + balance);
                            } else {
                                System.out.println("Invalid amount. Deposit amount must be greater than 0.");
                            }
                        } else if (transOption == 2) {
                            System.out.println("Enter Amount to Withdraw:");
                            int withdrawAmount = vp.nextInt();
                            vp.nextLine(); 
                            if (withdrawAmount > 0 && balance >= withdrawAmount) {
                                balance -= withdrawAmount;
                                System.out.println("Withdrawal Successful. New Balance: " + balance);
                            } else {
                                System.out.println("Insufficient Balance or Invalid Amount!");
                            }
                        } else {
                            System.out.println("Invalid Option!");
                        }
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;

                case 4:
                    System.out.println("Thank You for Using Bank Server. Goodbye!");
                    vp.close();
                    return;

                default:
                    System.out.println("Invalid Option! Please Try Again.");
            }
        }
    }
}
