package hw8.task1;

public class User {
    String userName;
    int age;
    private String email;
    private String password;
    boolean isActive;
    double amountSpentMoney;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.length() > 3) {
            this.email = email;
        } else {
            System.out.println(email + " doesn't pass validation. Length is too short");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() <= 10) {
            this.password = password;
        } else {
            System.out.println(password + " doesn't pass validation. Length is too long");
        }
    }

    public void makePurchase(double purchasePrice) {
        System.out.println(userName + " purchased goods for " + purchasePrice + " UAH");
        amountSpentMoney += purchasePrice;
    }

    public void printTotalAmountOfSpentMoney() {
        System.out.println(userName + " total amount of spend money is " + amountSpentMoney + " UAH");
    }

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User(String userName, String password) {
        this.userName = userName;
        setPassword(password);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", isActive=" + isActive +
                ", amountSpentMoney=" + amountSpentMoney +
                '}';
    }
}
