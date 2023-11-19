package models;

public class Account extends User{
    private String accountNumber;
    private double balance;
    public Account(){
    }
    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public boolean isPremium() {
        if (balance >= 10_000_000) {
            return true;
        } else {
            return false;
        }
    }
    //phương thức xuất thông tin tài khoản: số tk + số dư
    public String toString() {
        String show1 = String.format( "%10s | ", getAccountNumber());
        String show2 = String.format( "%,48d", (long) getBalance());
        return show1 + show2;
    }

}
