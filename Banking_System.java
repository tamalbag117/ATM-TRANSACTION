import java.util.*;

/**
 * Data Storing Class Stores {NAME, BANK BALANCE,CUSTOMER ID}
 */

class StorageGet {
    public static LinkedList<String> getName(LinkedList<String> name) {
        name.add(0, "INVALID");
        name.add(1, "HERMIONE");
        name.add(2, "HARRY");
        name.add(3, "DRACO");
        name.add(4, "RON");
        name.add(5, "ALBUS");
        name.add(6, "SEVERUS");
        name.add(7, "REBUS");
        name.add(8, "LUNA");
        name.add(9, "MINERVA");
        name.add(10, "NEVILLE");
        name.add(11, "SIRIUS");
        name.add(12, "BELLATRIX");
        name.add(13, "GINNY");
        return name;
    }

    public static LinkedList<Integer> getId(LinkedList<Integer> pin) {
        pin.add(0, 9999);
        pin.add(1, 4567);
        pin.add(2, 6078);
        pin.add(3, 1191);
        pin.add(4, 9008);
        pin.add(5, 2351);
        pin.add(6, 7865);
        pin.add(7, 6543);
        pin.add(8, 6070);
        pin.add(9, 3771);
        pin.add(10, 7665);
        pin.add(11, 5631);
        pin.add(12, 4321);
        pin.add(13, 5566);
        return pin;
    }

    public static LinkedList<Integer> getBalance(LinkedList<Integer> amount) {
        amount.add(0, 000000);
        amount.add(1, 120000);
        amount.add(2, 520000);
        amount.add(3, 620000);
        amount.add(4, 220000);
        amount.add(5, 20000);
        amount.add(6, 100000);
        amount.add(7, 100500);
        amount.add(8, 100000);
        amount.add(9, 50000);
        amount.add(10, 127000);
        amount.add(11, 220000);
        amount.add(12, 168000);
        amount.add(13, 120000);
        amount.add(14, 145000);
        amount.add(15, 200000);
        amount.add(16, 345600);
        amount.add(17, 10000);
        amount.add(18, 200200);
        return amount;
    }

}

/**
 * InnerBankingSystem
 */

class InnerBankingSystem {
    int previousTransaction = 0;

    void getWithdrawn(int amount, int balance) {

        if (balance >= amount) {
            if (amount != 0) {
                balance = balance - amount;
                previousTransaction = -amount;
                System.out.println("Withdrawn: " + amount);
            } else if (amount == 0) {
                System.out.println("Withdrawal amount is zero.");
            }
        } else 
        {
            System.out.println("You have insufficient amount balance. Can't process withdrawal operation.");
        }
    }

    void getDeposited(int amount2, int balance) {
        if (amount2 != 0) {
            balance = balance + amount2;
            previousTransaction = amount2;
            System.out.println("Deposited: " + amount2);
        } else {
            System.out.println("Deposited amount is zero.");
        }

    }

    void getPreviousTransaction() {
        if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else {
            System.out.println("No transaction occured yet.");
        }

    }
}

public class Banking_System {
    public static void main(String[] args) {
        LinkedList<String> name = new LinkedList<String>();
        LinkedList<Integer> id = new LinkedList<Integer>();
        LinkedList<Integer> amount = new LinkedList<Integer>();
        Scanner sc = new Scanner(System.in);
        int index = 0;
        String n1 = "INVALID", name2 = "INVALID";
        int id1 = 0, id2 = 1, flag = 0, balance1 = 0;
        System.out.println("Welcome to HOGWARTS  BANK OF WIZARD AND WIZARDY\n");
        System.out.println("\nBranch no.(9)*(3/4)\nWe are here at your service.");
        StorageGet.getId(id);
        StorageGet.getName(name);
        StorageGet.getBalance(amount);

        while (true) {
            System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
            System.out.println("1.NEW USER\n2.REGULAR CUSTOMAR");
            int c = sc.nextInt();
            if (c == 1) {
                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
                System.out.println("Please Enter Your Name ");
                n1 = sc.next();
                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
                System.out.println("Please Set Your ID ");
                id1 = sc.nextInt();
                System.out.println("Please Confirm Your ID");
                id2 = sc.nextInt();
                flag = 0;
                if (id1 == id2) {
                    name.add(n1);
                    id.add(id1);
                    flag = 1;
                } else
                    System.out.println("invalid");
                if (flag == 1) {
                    System.out.println("Successfully Registered with HOGWARTS");
                } else {
                    break;
                }
            } else if (c == 2) {
                int count = 0;
                System.out.print("Enter your pin :\t");
                int pin1 = sc.nextInt();
                for (int i = 0; i < id.size(); i++) {
                    if (pin1 == id.get(i))
                        index = i;
                    count = 1;
                }
                if (count != 1)
                    System.exit(0);
                else {
                    balance1 = amount.get(index);
                    name2 = name.get(index);
                    System.out.println("----------------------------------------------");
                    System.out.println("We are here at your service.");
                    System.out.println("A. Balance");
                    System.out.println("B. Deposit");
                    System.out.println("C. Withdraw");
                    System.out.println("D. Previous Transaction");
                    System.out.println("E. Exit");
                    InnerBankingSystem obj = new InnerBankingSystem();
                    while (true) {
                        System.out.println("Press a key of your choice.");
                        char choice = sc.next().charAt(0);
                        switch (choice) {
                            case 'a':
                            case 'A':
                                System.out.println("User Name :  " + name2);
                                System.out.println("Balance");
                                System.out.println("--------------------------------------");
                                System.out.println("Balance is: " + balance1);
                                break;
                            case 'c':
                            case 'C':
                                System.out.println("User Name :  " + name2);
                                System.out.println("Withdraw");
                                System.out.println("--------------------------------------");
                                System.out.println("enter an amount to withdraw: ");
                                int amount3 = sc.nextInt();
                                obj.getWithdrawn(amount3, balance1);
                                break;
                            case 'b':
                            case 'B':
                                System.out.println("User Name :  " + name2);
                                System.out.println("Deposit");
                                System.out.println("--------------------------------------");
                                System.out.println("enter an amount to deposit: ");
                                int amount2 = sc.nextInt();
                                obj.getDeposited(amount2, balance1);
                                break;
                            case 'd':
                            case 'D':
                                System.out.println("User Name :  " + name2);
                                System.out.println("Previous Transaction");
                                System.out.println("--------------------------------------");
                                System.out.println("Previous Transaction is: ");
                                obj.getPreviousTransaction();
                                break;
                            case 'e':
                            case 'E':
                                System.out.println("User Name :  " + name2);
                                System.out.println("Thanks for using our service.");
                                System.out.println("---------------------------------------");
                                System.exit(0);
                                break;

                            default:
                                System.out.println("Invalid choice, please enter correct key.");
                                break;
                        }
                    }
                }
            } else {
                System.out.println("wrong input");
                System.exit(0);
            }

        }
        sc.close();

    }
}
