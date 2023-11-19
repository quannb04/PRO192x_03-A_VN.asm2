import java.util.*;

import java.util.Scanner;
import models.Account;
import models.Customer;
import models.Bank;
import models.User;
public class asm02 {
    public static void giaoDien() {
        System.out.println("+----------+--------------------+----------+");
        System.out.println("| NGAN HANG SO | FX18762@v2.0.0            |");
        System.out.println("+----------+--------------------+----------+");
        System.out.println(" 1. Them khach hang                         ");
        System.out.println(" 2. Them tai khoan cho khach hang           ");
        System.out.println(" 3. Hien thi danh sach khach hang           ");
        System.out.println(" 4. Tim theo CCCD                           ");
        System.out.println(" 5. Tim theo ten khach hang                 ");
        System.out.println(" 0. Thoat                                   ");
        System.out.println("+----------+--------------------+----------+");
        System.out.println("Chuc nang:");
    }
    private static final Bank bank = new Bank();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int luachon;
        while (true) {
            giaoDien();
            luachon = sc.nextInt();
            switch (luachon) {
                case 1:
                    chucnang1();
                    break;
                case 2:
                    chucnang2();
                    break;
                case 3:
                    chucnang3();
                    break;
                case 4:
                    chucnang4();
                    break;
                case 5:
                    chucnang5();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
    //phương thức nhập thông tin khách hàng mới, kiểm tra điều kiện, thêm khách hàng mới vào danh sách bank
    public static void chucnang1() {
        String name, cccd;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten khach hang");
        name = sc.next();
        System.out.println("Nhap so CCCD");
        cccd = sc.next();
        while (User.CheckCCCD(cccd) == false) {
            System.out.println("CCCD sai cu phap, nhap lai CCCD");
            cccd = sc.next();
        }
        Customer cus = new Customer(name, cccd);
        bank.addCustomer(cus);
        System.out.println("Nhap CCCD thanh cong");
    }
    //phương thức thêm tài khoản cho khách hàng
    public static void chucnang2() {
        Scanner sc = new Scanner(System.in);
        Account account = new Account();
        String cccd;
        while(true) {
            boolean pass = false;
            System.out.println("Nhap CCCD khach hang:");
            cccd = sc.next();
            for (int i = 0; i < bank.getCustomers().size(); i++) {
                if (bank.getCustomers().get(i).getCustomerId().equals(cccd)) {
                    pass = true;
                    break;
                }
            }
            if(pass == true) {
                break;
            } else {
                System.out.println("CCCD khong dung, moi nhap lai");
            }
        }
        System.out.println("Nhap ma STK gom 6 chu so:");
        String stk = sc.next();
        while(stk.length() != 6 || Integer.parseInt(stk) == 0) {//phan tich chuoi String thanh so
            System.out.println("STK la so va co 6 so, xin nhap lai");
            stk = sc.next();
        }
        account.setAccountNumber(stk);
        System.out.println("Nhap so du:");
        double sodu = sc.nextDouble();
        while (sodu < 50_000) {
            System.out.println("So du khong nho hon 50000đ, nhap lai so du:");
            sodu = sc.nextDouble();
        }
        account.setBalance(sodu);
        for(Customer cus : bank.getCustomers()) {
            if(cus.getCustomerId().equals(cccd)) {
                cus.addAccount(account);
            }
        }
    }
    //Phương thức hiển thị danh sách khách hàng
    public static void chucnang3() {
        for(int i = 0; i < bank.getCustomers().size(); i++) {
            bank.getCustomers().get(i).displayInformation();
        }
    }
    //Phương thức tìm khách hàng theo CCCD
    public static void chucnang4() {
        Scanner sc = new Scanner(System.in);
        String cccd;
        while(true) {
            boolean pass = false;
            System.out.println("Nhap CCCD khach hang:");
            cccd = sc.next();
            for (int i = 0; i < bank.getCustomers().size(); i++) {
                if (bank.getCustomers().get(i).getCustomerId().equals(cccd)) {
                        bank.getCustomers().get(i).displayInformation();
                    pass = true;
                    break;
                }
            }
            if(pass == true) {
                break;
            } else {
                System.out.println("CCCD khong dung, moi nhap lai");
            }
        }
    }
    //phương thức tìm khách hàng theo tên
    public static void chucnang5() {
        Scanner sc = new Scanner(System.in);
        String tenKh;
        while(true) {
            boolean pass = false;
            System.out.println("Nhap ten Kh khach hang:");
            tenKh = sc.next();
            for (int i = 0; i < bank.getCustomers().size(); i++) {
                if(bank.getCustomers().get(i).getName().contains(tenKh)) {
                    bank.getCustomers().get(i).displayInformation();
                    pass = true;
                }
            }
            if(pass == true) {
                break;
            } else {
                System.out.println("ten KH khong dung, moi nhap lai");
            }
        }
    }
}


