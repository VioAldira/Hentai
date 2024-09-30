import java.io.*;

public class FileIO {

    // Reading customer records from file
    public static void readCustomersFromFile(CustomerList list, String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Account Id")) {
                    int id = Integer.parseInt(line.split("=")[1].trim());
                    String name = br.readLine().split("=")[1].trim();
                    String address = br.readLine().split("=")[1].trim();
                    String dob = br.readLine().split("=")[1].trim();
                    String phone = br.readLine().split("=")[1].trim();
                    double balance = Double.parseDouble(br.readLine().split("=")[1].trim());
                    String accountType = br.readLine().split("=")[1].trim();
                    double interest = 0;
                    if (accountType.equalsIgnoreCase("Fixed")) {
                        interest = Double.parseDouble(br.readLine().split("=")[1].trim());
                    }
                    // Add customer to the list
                    Customer customer = new Customer(id, name, address, dob, phone, balance, accountType, interest);
                    list.addCustomer(customer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Writing customer records to file
    public static void writeCustomersToFile(CustomerList list, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            Customer current = list.head;
            while (current != null) {
                bw.write("Account Id = " + current.accountId + "\n");
                bw.write("Name = " + current.name + "\n");
                bw.write("Address = " + current.address + "\n");
                bw.write("DOB = " + current.dob + "\n");
                bw.write("Phone Number = " + current.phoneNumber + "\n");
                bw.write("Account Balance = " + current.accountBalance + "\n");
                bw.write("Account Type = " + current.accountType + "\n");
                if (current.accountType.equalsIgnoreCase("Fixed")) {
                    bw.write("Fixed Daily Interest = " + current.fixedDailyInterest + "\n");
                }
                bw.write("\n");
                current = current.next;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

