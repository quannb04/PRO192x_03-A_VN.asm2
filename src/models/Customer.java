package models;

import java.util.ArrayList;
import java.util.List;
public class Customer extends User {
    private List<Account> accounts;
    public Customer() {
        accounts = new ArrayList<Account>();
    }
    public Customer(String name, String customerId) {
        super(name, customerId);
        accounts = new ArrayList<Account>();
    }
    public List<Account> getAccounts() {
        return accounts;
    }
    public boolean isPremium() {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).isPremium()) {
                return true;
            }
        }
        return false;
    }
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    public void addAccount(Account newAccount) {
        if(accounts.size() == 0) {
            accounts.add(newAccount);
        } else {
            for (int i = 0; i < accounts.size(); i++) {
                if (newAccount.getAccountNumber().equals(accounts.get(i).getAccountNumber())) {
                    System.out.println("Account Number da ton tai ");
                } else
                    accounts.add(newAccount);
            }
        }
    }
    public double getBalance() {
        double total = 0;
        for(int i = 0; i < accounts.size(); i++) {
            total += accounts.get(i).getBalance();
        }
        return total;
    }
    public void displayInformation() {
        String isPre = isPremium() == true  ? "Premium" : "Nomal";
        String show2 = String.format( "%,d", (long) getBalance());
        System.out.printf("%12s | %15s | %12s | %15sđ\n",getCustomerId(),getName(),isPre,show2);
        for(int i = 0; i < accounts.size(); i++) {
            System.out.printf("%-2d%-52sđ\n", i+1, accounts.get(i).toString());
        }
    }
}
