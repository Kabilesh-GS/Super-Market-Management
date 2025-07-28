package SuperMarket;

public class User {
     String email;
     String password;
     String role;
     int credit = 1000;

     public User(String email, String password,String role, int credit){
        this.email = email;
        this.password = password;
        this.role = role;
        this.credit = 1000;
     }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
