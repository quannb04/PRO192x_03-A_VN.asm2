package models;

public class User {
    private String name;
    private String customerId;
    public User() {}
    public User(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCustomerId() {
        return customerId;
    }
    public void setcustomerId(String customerId) {
            this.customerId = customerId;
    }
    public static boolean CheckCCCD(String check) {
        try{
            if(check.length() == 12) {
                for (int i = 0; i < check.length(); i++) {
                    if (Character.isLetter(check.charAt(i))) {//kiểm tra ký tự char có phải 1 ký tự trong khoảnng azAZ
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("loi nhap thong tin");
            return false;
        }
    }
}

