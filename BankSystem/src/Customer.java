public class Customer {
    int accountId;
    String name;
    String address;
    String dob;
    String phoneNumber;
    double accountBalance;
    String accountType;
    double fixedDailyInterest; // only applicable for Fixed account type

    Customer next;
    Customer prev;

    // Constructor
    public Customer(int accountId, String name, String address, String dob, String phoneNumber,
                    double accountBalance, String accountType, double fixedDailyInterest) {
        this.accountId = accountId;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.accountBalance = accountBalance;
        this.accountType = accountType;
        this.fixedDailyInterest = fixedDailyInterest;
        this.next = null;
        this.prev = null;
    }

    // Method to display customer details
    public void displayCustomer() {
        System.out.println("Account Id: " + accountId);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("DOB: " + dob);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Account Balance: " + accountBalance);
        System.out.println("Account Type: " + accountType);
        if (accountType.equalsIgnoreCase("Fixed")) {
            System.out.println("Fixed Daily Interest: " + fixedDailyInterest);
        }
        System.out.println("--------------------------");
    }
}
