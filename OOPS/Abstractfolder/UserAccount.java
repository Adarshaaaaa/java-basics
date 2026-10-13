package OOPS.Abstractfolder;

public class UserAccount {
    private String username;
    private static int totalUsers = 0;

    UserAccount(String username) {
        this.username = username;
        totalUsers += 1;

    }

    public String getUsername() {
        return username;
    }

    public static int getTotalUsers() {
        return totalUsers;
    }
}

class StaticDemo1 {
    public static void main(String[] args) {
        System.out.println("initial total users");
        UserAccount user = new UserAccount("Aarav");
        UserAccount user1 = new UserAccount("priya");
        UserAccount user2 = new UserAccount("rohan");
        System.out.println(user.getUsername());
        System.out.println(UserAccount.getTotalUsers());
        System.out.println(user1.getUsername());
        System.out.println(UserAccount.getTotalUsers());
        System.out.println(user2.getUsername());

        System.out.println(UserAccount.getTotalUsers());
    }
}
