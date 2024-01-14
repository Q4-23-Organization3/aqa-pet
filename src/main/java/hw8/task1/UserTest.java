package hw8.task1;

public class UserTest {
    public static void main(String[] args) {
        User user1 = new User();
        user1.userName = "Alla";
        user1.age = 18;
        user1.isActive = true;

        User user2 = new User();
        user2.userName = "Alex";
        user2.age = 19;
        user2.amountSpentMoney = 150;
        user2.isActive = true;

        User user3 = new User("Vlad");

        User user4 = new User("Margo", "TheBest");

        user1.setEmail("a");
        user1.setPassword("1234567890");

        user2.setEmail("goodmail@mail.com");
        user2.setPassword("password that will not pass validation");

        System.out.println(user3.userName + " mail is: " + user3.getEmail());
        System.out.println(user4.userName + " password is: " + user4.getPassword());

        user1.makePurchase(5);
        user2.makePurchase(8.99);
        user3.makePurchase(10);
        user4.makePurchase(0.99);

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        System.out.println(user4);
        user1.printTotalAmountOfSpentMoney();
        user2.printTotalAmountOfSpentMoney();
        user3.printTotalAmountOfSpentMoney();
        user4.printTotalAmountOfSpentMoney();
    }
}
