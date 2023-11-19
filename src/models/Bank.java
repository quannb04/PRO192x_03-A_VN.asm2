package models;

import java.util.*;
import java.util.ArrayList;
import java.util.UUID;

public class Bank {
    private final String id;
    private final List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
        this.id = String.valueOf(UUID.randomUUID());
    }
    public String getId() {
        return id;
    }
    public List<Customer> getCustomers() {
        return customers;
    }
    public void addCustomer(Customer newCustomer) {
        if(isCustomerExisted(newCustomer.getCustomerId())) {
            customers.add(newCustomer);
        }
        else {
            System.out.println("Ma CCCD khach hang da ton tai");
        }
    }
      public boolean isCustomerExisted(String customerId) {
        for(int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getCustomerId().equals(customerId)) {
                return false;
            }
        }
        return true;
    }
}
