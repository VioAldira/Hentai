import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerList customerList = new CustomerList();
        String filename = "customers.txt";

        // Load existing customers from file
        FileIO.readCustomersFromFile(customerList, filename);

        while (true) {
            System.out.println("1. Read Customer Records");
            System.out.println("2. Display Customer Records");
            System.out.println("3. Find Customer Records Based on Id");
            System.out.println("4. Find All Customer Records by Account Type");
            System.out.println("5. Delete one Customer Record Based on Id");
            System.out.println("6. Add Customer Records");
            System.out.println("7. Write The Final Customer Records");
            System.out.println("8. Exit App");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    FileIO.readCustomersFromFile(customerList, filename);
                    System.out.println("Records loaded from file.");
                    break;
                case 2:
                    customerList.displayCustomers();
                    break;
                case 3:
                    System.out.print("Enter Account ID: ");
                    int id = scanner.nextInt();
                    Customer customer = customerList.findCustomerById(id);
                    if (customer != null) {
                        customer.displayCustomer();
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account Type (Fixed/Saving/Checking): ");
                    String accountType = scanner.nextLine();
                    customerList.displayCustomersByAccountType(accountType);
                    break;
                case 5:
                    System.out.print("Enter Account ID to delete: ");
                    id = scanner.nextInt();
                    customerList.deleteCustomer(id);
                    break;
                case 6:
                    System.out.print("Enter Account ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // clear the buffer

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();

                    System.out.print("Enter DOB (dd-mm-yyyy): ");
                    String dob = scanner.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();

                    System.out.print("Enter Account Balance: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine(); // clear buffer

                    System.out.print("Enter Account Type (Fixed/Saving/Checking): ");
                    accountType = scanner.nextLine();

                    double interest = 0;
                    if (accountType.equalsIgnoreCase("Fixed")) {
                        System.out.print("Enter Fixed Daily Interest: ");
                        interest = scanner.nextDouble();
                        scanner.nextLine(); // clear buffer
                    }

                    Customer newCustomer = new Customer(id, name, address, dob, phoneNumber, balance, accountType, interest);
                    customerList.addCustomer(newCustomer);
                    System.out.println("Customer added successfully.");
                    break;
                case 7:
                    FileIO.writeCustomersToFile(customerList, filename);
                    System.out.println("Customer records saved to file.");
                    break;
                case 8:
                    System.out.println("Do you want to save the records before exiting? (yes/no)");
                    String save = scanner.nextLine();
                    if (save.equalsIgnoreCase("yes")) {
                        FileIO.writeCustomersToFile(customerList, filename);
                    }
                    System.out.println("Exiting app.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}