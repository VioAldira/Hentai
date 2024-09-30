public class CustomerList {
    Customer head;
    Customer tail;

    // Add a customer to the list
    public void addCustomer(Customer customer) {
        if (head == null) {
            head = tail = customer;
        } else {
            tail.next = customer;
            customer.prev = tail;
            tail = customer;
        }
    }

    // Display all customer records
    public void displayCustomers() {
        Customer current = head;
        while (current != null) {
            current.displayCustomer();
            current = current.next;
        }
    }

    // Find a customer by ID
    public Customer findCustomerById(int id) {
        Customer current = head;
        while (current != null) {
            if (current.accountId == id) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Delete a customer by ID
    public void deleteCustomer(int id) {
        Customer current = head;
        while (current != null) {
            if (current.accountId == id) {
                if (current == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Customer with ID " + id + " deleted.");
                return;
            }
            current = current.next;
        }
        System.out.println("Customer with ID " + id + " not found.");
    }

    // Filter customers by account type
    public void displayCustomersByAccountType(String accountType) {
        Customer current = head;
        while (current != null) {
            if (current.accountType.equalsIgnoreCase(accountType)) {
                current.displayCustomer();
            }
            current = current.next;
        }
    }
}
